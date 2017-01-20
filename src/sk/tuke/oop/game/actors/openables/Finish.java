/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author daniel
 */
public class Finish extends LockedDoor{

    private Ripley ripley;
    
    public Finish(String name, boolean vertical) {
        super(name, vertical);
        
    }
    
    @Override
    public void open(){
        super.open();
        ripley.setAlive("finish");
    }
    
    public void act(){
        if(ripley==null)
            ripley= (Ripley) getActorByName("ripley");
    }
    
}
