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
public class GunUpgrade extends AbstractActor implements Item  {
    
    public GunUpgrade(String name){
        super(name);
        Animation animation;
        animation= new Animation("resources/sprites/gunup.png", 24, 24);
        super.setAnimation(animation);
    } 
    
    @Override
    public void act() {
       for(Actor actor : getWorld()){
           if(super.intersects(actor) == true && actor instanceof Ripley){
               Ripley hrac = (Ripley) actor;
               hrac.setGunUp(true);
               getWorld().removeActor(this);
               break;
               }
           }          
       }      
  }  
