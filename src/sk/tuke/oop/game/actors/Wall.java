/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author daniel
 */
public class Wall extends AbstractCharacter{

    public Wall(String name) {
        super(name);
        Animation animation = new Animation("resources/sprites/wall.png", 16, 32, 100);
        super.setAnimation(animation);        
        super.setEnergy(500);
    }
    
    public void act(){
        if(getEnergy()<=0){
           getWorld().setWall(this.getX()/16, this.getY()/16 , false);
           getWorld().setWall(this.getX()/16, (this.getY()/16)+1 , false);
           getWorld().removeActor(this);
        }
        
    }
    
}
