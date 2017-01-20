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

/**
 *
 * @author daniel
 */
public class Hammer extends AbstractActor implements Item, Usable {
    
    public Hammer(String name){
        super(name);
        Animation animation;
        animation= new Animation("resources/sprites/hammer.png", 16, 16);
        super.setAnimation(animation);
    }

    @Override
    public void use(Actor actor) {
        
    }
    
        
}
