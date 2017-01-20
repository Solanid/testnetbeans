/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author daniel
 */
public class Hole extends AbstractActor{
    

    
    private Animation animation;
    private boolean activate;
    private int wait;
    private int count;
    
    public Hole(String name) {
        super(name);
        animation= new Animation("resources/sprites/hole.png", 32, 32, 100);
        animation.stop();
        animation.setLooping(false);
        super.setAnimation(animation);
        activate=false;
        count=4;
        wait=150;
    }
    
    public void create(){
        if(wait==0){
            wait=150;
            count--;
            Actor actor = new Alien("alien");
            actor.setPosition(getX(), getY());
            getWorld().addActor(actor);
        }
        else if(count >= 0){
            wait--;
        }
    }
    
    @Override
    public void act(){
        if(activate){
            create();
        }
        else{
           for(Actor actor : getWorld()){
                if(actor instanceof Ripley && intersects(actor)){
                    animation.start();
                    activate = !activate;
                    break;
                }
            } 
       }
    }
    
}
