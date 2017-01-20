/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.Decorator;
import sk.tuke.oop.game.actors.EnergyBullet;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author daniel
 */
public class Shoot implements Command{

    private Ripley ripley;
    private int dx, dy, rotation;
    
    public Shoot(Ripley ripley){
        this.ripley=ripley;
        
    }
    
    public boolean checkAmmo(){
        return ripley.getAmmo()==0;
    }
    
    public boolean upe(){
        return  rotation == 0 || rotation == 315 || rotation == 45;         
    }
    
    public boolean down(){
        return rotation == 180 || rotation == 135 || rotation == 225;
    }
    
    public boolean right(){
        return rotation == 90 || rotation == 135 || rotation == 45;
    }
    
    public boolean left(){
        return rotation == 270 || rotation == 315 || rotation == 225;
    }
    
    @Override
    public void execute() {
        if(checkAmmo())
            return;
        rotation =ripley.getAnimation().getRotation();               
        ripley.setAmmo(ripley.getAmmo()-1);
        
        if (left()) {
            dx = -1;
        } else if (right()) {
            dx = 1;
        }
        if (upe()) {
            dy = -1;
        } else if (down()) {
            dy = 1;
        }
        Decorator decorator;
        if(!ripley.getGunUp()){
            decorator= new Bullet("naboj");
        }
        else
            decorator= new EnergyBullet(new Bullet("naboj"));
        decorator.setDirection(dx, dy);
        
        Actor actor= (Actor) decorator;
        actor.setPosition(ripley.getX()+8, ripley.getY()+8);
        actor.getAnimation().setRotation(rotation);  
        ripley.getWorld().addActor((Actor)decorator);       
       
        
        }
    }

