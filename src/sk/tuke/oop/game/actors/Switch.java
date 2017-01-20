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
public class Switch extends AbstractActor implements Usable{

    private LasserTurret turret;
    
    public Switch(String name) {
        super(name);
        Animation animation= new Animation("resources/sprites/button_green.png", 16, 16);     
        super.setAnimation(animation);      
        
    }
    
    @Override
    public void act(){
        if(turret == null){
            turret=(LasserTurret) getActorByName("turret");
        }
    }

    @Override
    public void use(Actor actor) {
        turret.toggle();
    }
}
