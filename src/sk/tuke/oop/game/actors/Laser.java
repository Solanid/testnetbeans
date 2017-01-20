/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author daniel
 */
public class Laser extends AbstractActor implements Movable{
    
    private int dx, dy, step, damage;
    
    public Laser(String name) {
        super(name);
        Animation animation= new Animation("resources/sprites/laser_beam.png", 16, 16);     
        super.setAnimation(animation);      
        step=4; 
        damage=5;
    }
    
    public void setDirection(int dx, int dy){
        this.dx=dx;
        this.dy=dy;
    }
    
     
    @Override
    public void act(){
        int x, y;
        x=getX()+(dx*step);
        y=getY()+(dy*step);
        setPosition(x, y);        
        for(Actor actor : getWorld()){
            if(actor instanceof AbstractCharacter && actor.intersects(this)  ){
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
