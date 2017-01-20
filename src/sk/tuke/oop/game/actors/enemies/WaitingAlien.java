/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.openables.Door;

/**
 *
 * @author daniel
 */
public class WaitingAlien extends Alien implements Observer {

    private boolean activate;
    private Door door;
    private boolean registry;
    
    public WaitingAlien(String name) {
        super(name);
        activate=false;
        registry=true;
    }

    public void register(){
        
        String name = this.getName();     
        if(name.contentEquals("alien1")){
            door=(Door) getActorByName("door1");
        }
        else if(name.contentEquals("alien2")){
            door=(Door) getActorByName("door2");
        }        
        else
            return;
        registry=false;
        door.addObserver(this);
    }
    
    @Override
    public void wakeUp() {
        activate=true;
    }
    
    @Override
    public void remove(){
        if(super.getEnergy()<=0){
            door.removeObserver(this);
            getWorld().removeActor(this);
        }
    }
    
    @Override
    public void act(){
        if(registry)
            register();
        if(activate){
            super.act();            
        }
    }
}
    
