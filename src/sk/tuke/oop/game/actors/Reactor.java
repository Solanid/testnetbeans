/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author daniel
 */
public class Reactor extends AbstractActor implements Usable{

    private Animation onAnimation;
    private Animation offAnimation;
    private List<PowerConsumer> devices;
    private boolean work;
    
    public Reactor(String name) {
        super(name);
        offAnimation = new Animation("resources/sprites/reactor.png", 80, 80);
        onAnimation = new Animation("resources/sprites/reactor_on.png", 80, 80, 100);
        onAnimation.setPingPong(true);
        super.setAnimation(offAnimation);
        this.devices = new ArrayList<PowerConsumer>();
        work=false;
    }

    @Override
    public void use(Actor actor) {
        work = !work;
        for(PowerConsumer consumer : devices){
            consumer.setElectricityFlow(work);
        }
        if(work)
            super.setAnimation(onAnimation);
        else
            super.setAnimation(offAnimation);
    }
    
    public void addConsumer(PowerConsumer consumer){
        devices.add(consumer);
        consumer.setElectricityFlow(work);
    }
    
}
