/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Input;

/**
 *
 * @author daniel
 */
public class Dying implements RipleyState{
    
    private Ripley ripley;
    
    public Dying(Ripley ripley){
        this.ripley=ripley;
    }
    
    @Override
    public void act() {
        if(!ripley.getName().equals("dying ripley"))
            ripley.setName("dying ripley");
        Input input = Input.getInstance();
        if (input.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }
        ripley.setEnergy(0);
    }
    
}
