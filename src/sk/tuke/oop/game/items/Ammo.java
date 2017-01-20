/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author daniel
 */
public class Ammo extends AbstractActor implements Item  {
    
    public Ammo(String name){
        super(name);
        Animation animation;
        animation= new Animation("resources/sprites/ammo.png", 16, 16);
        super.setAnimation(animation);
    } 
    
    @Override
    public void act() {
       for(Actor actor : getWorld()){
           if(super.intersects(actor) == true && actor instanceof Ripley){
               Ripley hrac = (Ripley) actor;
               if(hrac.getAmmo()<=450){
                   hrac.setAmmo(hrac.getAmmo()+50);                   
                   getWorld().removeActor(this);
                   break;
               }
               else if(hrac.getAmmo()<=500){
                    hrac.setAmmo(500);
                    getWorld().removeActor(this);
                    break;
               }
           }       
       }      
    }
}