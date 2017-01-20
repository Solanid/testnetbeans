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
import sk.tuke.oop.game.actors.openables.LockedDoor;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author daniel
 */
public class AccessCard extends AbstractActor implements Item, Usable {
    
    
     public AccessCard(String name){
        super(name);
        Animation animation;
        animation= new Animation("resources/sprites/key.png", 16, 16);
        super.setAnimation(animation);
    }

    @Override
    public void use(Actor actor) {
        if(actor instanceof LockedDoor){  
            for(Actor actoris : actor.getWorld()){
                if(actoris instanceof Ripley){
                    Ripley ripley = (Ripley) actoris;                    
                    ripley.getBackpack().remove(this);
                    break;
            }
        }
        }
    }
}
