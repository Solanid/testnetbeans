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
public class Running implements RipleyState {

    private Ripley ripley;
    
    public Running(Ripley ripley){
        this.ripley=ripley;
    }
    
    @Override
    public void act() {
        Input input = Input.getInstance();
        if (input.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }
        ripley.keys(input);
        ripley.movements(input);
        if(ripley.getEnergy()<=0){
            ripley.setAlive("dead");
            ripley.deadAnim();
        }
    }
    
}
