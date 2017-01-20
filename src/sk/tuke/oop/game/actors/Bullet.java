/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.enemies.Enemy;

/**
 *
 * @author daniel
 */
public class Bullet extends AbstractActor implements Movable, Decorator{

    private int dx, dy, damage;
    
    public Bullet(String name) {
        super(name);
        Animation animation= new Animation("resources/sprites/bullet.png", 16, 16);     
        super.setAnimation(animation);          
        damage = 10;
    }
    
    public void setDirection(int dx, int dy){
        this.dx=dx;
        this.dy=dy;
    }
    
    public void setDamage(int damage){
        this.damage=damage;
    }
    
    @Override
    public void movement(){
        int x, y;
        x=getX()+(dx*4);
        y=getY()+(dy*4);
        setPosition(x, y);  
    }
    
    @Override
    public void act(){  
        movement();
        for(Actor actor : getWorld()){
            if(actor instanceof Enemy  && intersects(actor) ){
                AbstractCharacter character =(AbstractCharacter) actor;
                character.setEnergy(character.getEnergy() - damage);
                getWorld().removeActor(this);
                break;
            }
        }
        if(getWorld().intersectWithWall(this)){
            getWorld().removeActor(this);            
        }
    }
    

}
