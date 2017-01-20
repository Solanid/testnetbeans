/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author daniel
 */
public class LockedDoor extends Door implements Usable{

    private boolean locked;
    private Animation animation;
    
    public LockedDoor(String name, boolean vertical) {
        super(name, vertical);
        locked=true;
        animation=super.getAnimation();
    }
    
    @Override
    public void open() {
       if(isLocked())
           return;
       setOtvorene(true);
       animation.stopAt(3);
       animation.start();
       wall();     
       super.wakeUp();
    }

    public void unlock() {
        if(locked)
            locked=false;
    }
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void use(Actor actor) {
        if(!locked && getOtvorene()){
            close();
        }
        else if(!locked && !getOtvorene()){
            open();
        }
        else if(actor instanceof AccessCard){
            unlock();
            Usable usable =(Usable) actor;
            usable.use((Actor)this);
        }      
    }
    
}
