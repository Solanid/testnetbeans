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
public class Cooler extends AbstractActor {
    
    private boolean damaged;
    private Animation animation;
    
    public Cooler(String name){
        super(name);      
        animation= new Animation("resources/sprites/fan.png", 32, 32, 200);
        animation.setPingPong(true);        
        super.setAnimation(animation);
        this.damaged=true;
        super.setPosition(200, 200);
    }

    
    @Override
        public void act(){
            if (damaged==true)
                animation.stop();
        }  
}
