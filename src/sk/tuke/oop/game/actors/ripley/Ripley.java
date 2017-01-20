/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.openables.Openable;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.commands.NextItem;
import sk.tuke.oop.game.commands.Shoot;
import sk.tuke.oop.game.commands.TakeItem;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.commands.Use;

/**
 *
 * @author daniel
 */
public class Ripley extends AbstractCharacter implements Movable {


    private int ammo;
    private BackpackImpl batoh;
    private Animation dead;
    private String state;
    private Running run;
    private Dying die;
    private boolean gunUp;
    
    
    
    public Ripley(){
        super("ripley"); 
        Animation running;
        dead = new Animation("resources/sprites/player_die.png", 32, 32, 100);
        running = new Animation("resources/sprites/player.png", 32, 32, 100);
        state= "alive";
        running.setPingPong(true);
        super.setAnimation(running);        
        super.setEnergy(100);
        ammo = 100;
        batoh = new BackpackImpl(5);
        run = new Running(this);
        die = new Dying(this);
        gunUp = false;
    }
    
    public void setAlive(String state){
        this.state=state;
    }
    
    public int getAmmo() {
        return ammo;
    }
    
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public void setGunUp(boolean gunup){
        gunUp = gunup;
    }
    
    public boolean getGunUp(){
        return gunUp;
    }
    

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        world.showBackpack(batoh);
        getWorld().centerOn(this);
    }

    public Item getItemByName(String name) {
        for (Item item : batoh) {
            if (item.getName().contentEquals(name)) {
                return item;
            }
        }
        return null;
    }
    
    public void writeMsg(){
        String sprava;
        sprava = String.format("Energy: %d Ammo: %d", super.getEnergy(), ammo);
        Message msg;
        msg = new Message(sprava, 85, 10);
        getWorld().showMessage(msg);
    }
    
    public void pick(){
        for( Actor actor : getWorld() ){
            if(this.intersects(actor)==true && actor instanceof Item ){
                 new TakeItem(batoh ,(Item)actor).execute();               
                 break;
            }
        }
    }
    
    public void deadAnim(){
        super.setAnimation(dead);
    }
    
    public void movements(Input input){
         int dx, dy;
        dx = 0;
        dy = 0;                   
        if (input.isKeyDown(Input.Key.LEFT)) {
            dx = -1;
        } else if (input.isKeyDown(Input.Key.RIGHT)) {
            dx = 1;
        }
        if (input.isKeyDown(Input.Key.UP)) {
            dy = -1;
        } else if (input.isKeyDown(Input.Key.DOWN)) {
            dy = 1;
        }
        
        new Move(this, 1, dx, dy).execute();

    }
    
    public void finish(){
        Input input = Input.getInstance();
        if (input.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }
        Message message = new Message("You won", 400, 300);
        getWorld().showMessage(message);
    }
    
    public void use(){
        for(Actor actor : getWorld()){
                if(intersects(actor) &&(actor instanceof Usable || actor instanceof Openable))
                    new Use(actor ,batoh.getLastItem()).execute();
            }
    }
    
    public void keys(Input input){
        if (input.isKeyPressed(Input.Key.ENTER)) {
            pick();
        }
        else if (input.isKeyPressed(Input.Key.BACK)) {
            new DropItem(batoh, getWorld(), getX(), getY()).execute();
        }        
        else if (input.isKeyPressed(Input.Key.N)){
            new NextItem(batoh).execute();
        }
        else if (input.isKeyPressed(Input.Key.E)){
            use();
        }
        else if(input.isKeyPressed(Input.Key.SPACE)){
            new Shoot(this).execute();
        } 
    }
    
    
    public BackpackImpl getBackpack(){
        return batoh;
    }
    
    @Override
    public void act() {
        if(state.equals("alive"))
           run.act();
        else if(state.equals("dead"))
           die.act();        
        else if(state.equals("finish"))
           finish();
        writeMsg();
    }
}
