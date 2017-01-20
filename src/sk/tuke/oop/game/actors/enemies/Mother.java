/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.AccessCard;

/**
 *
 * @author daniel
 */
public class Mother extends WaitingAlien{

    public Mother(String name) {
        super(name);
        Animation animation;
        animation = new Animation("resources/sprites/mother.png", 112, 162, 100);
        animation.setPingPong(true);
        super.setAnimation(animation);        
        super.setEnergy(400);
    }
    
    @Override
    public void remove(){
        if(getEnergy() <=0){
            AccessCard card = new AccessCard("karta");
            card.setPosition(getX()+66, getY()+81);
            getWorld().addActor(card);
        }
        super.remove();
    }
}
