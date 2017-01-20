/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author daniel
 */
public class LasserTurret extends AbstractActor implements Usable, PowerConsumer{

    private boolean electricity, toggle, register;
    
    public LasserTurret(String name) {
        super(name);
        Animation animation;
        animation= new Animation("resources/sprites/laserturret.png", 48, 48);
        super.setAnimation(animation);
        electricity=false;
        toggle=false;
        register=true;
    }

    @Override
    public void use(Actor actor) {
        Animation anim = getAnimation();
        anim.setRotation(anim.getRotation()+90);
    }

    public void toggle(){
        toggle= !toggle;
    }
    
    @Override
    public void setElectricityFlow(boolean ele) {
        electricity =ele;
    }
    
    @Override
    public void act(){
        if(register){
            Reactor reactor =(Reactor) getActorByName("reactor");
            if(reactor != null){
                reactor.addConsumer(this);
                register= false;
            }
        }
        if(toggle && electricity){
            int rotation =getAnimation().getRotation();
  
            Laser lasser= new Laser("naboj");
            int dx=0;
            int dy=0;
            if (rotation == 270) {
                dx = -1;
                lasser.setPosition(getX()-8, getY()+16);
            }
            else if (rotation == 90) {
                dx = 1;
                lasser.setPosition(getX()+48, getY()+16);
            }
            else if (rotation == 0) {
                dy = -1;
                lasser.setPosition(getX()+16, getY()-8);
            }
            else if (rotation == 180) {
                lasser.setPosition(getX()+16, getY()+48);
                dy = 1;
            }
            lasser.setDirection(dx, dy);
            
            lasser.getAnimation().setRotation(rotation);  
            getWorld().addActor(lasser);
        
        }    
    }
    
}
