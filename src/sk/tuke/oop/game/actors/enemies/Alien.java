/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author daniel
 */
public class Alien extends AbstractCharacter implements Movable, Enemy{


     private Ripley ripley;
    
    public Alien(String name){
        super(name);
        Animation animation;
        animation = new Animation("resources/sprites/warrior_alien.png", 32, 32, 100);
        animation.setPingPong(true);
        super.setAnimation(animation);        
        super.setEnergy(50);
    }

    public void getRipley(){
        for( Actor actor : getWorld() ){
            if(actor instanceof Ripley){                    
                   ripley = (Ripley) actor;            
            }
        
         }
    }
    
    public void remove(){
        if(super.getEnergy()<=0)
            getWorld().removeActor(this);
    }
    
    @Override
    public void act() {
        remove();
        if(ripley== null){
            getRipley();
        }
        if(ripley != null){
            int dx=0;
            int dy=0;
            int centerX = getX() + (getWidth()/2);
            int centerY = getY() + (getHeight()/2);
            int ripleyX = ripley.getX() + (ripley.getWidth()/2);
            int ripleyY = ripley.getY()+ (ripley.getHeight()/2);
            if( centerX > ripleyX)
            dx=-1;
            else if(centerX < ripleyX)
            dx = 1;    
            if(centerY > ripleyY)
            dy = -1;
            else if(centerY < ripleyY)
            dy = 1;            
            new Move(this, 1, dx, dy).execute();         
            if(super.intersects(ripley)){
                ripley.setEnergy(ripley.getEnergy()-1);
            }
    }
    }
}
