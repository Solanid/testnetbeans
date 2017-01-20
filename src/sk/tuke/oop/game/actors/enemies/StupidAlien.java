/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.enemies;

import java.util.Random;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author daniel
 */
public class StupidAlien extends Alien {
        
     private Random randomobj;
     private int count;
     private int dx, dy;
     private Move pohyb;
    
    public StupidAlien(String name) {
        super(name);        
        this.randomobj= new Random();
        this.count=0;
    }
    
    public void moving(){
        int random;
        if(count==0){
            dx=0;
            dy=0;
            random=randomobj.nextInt(3);
            if(random==0){
                dx=-1;
            }
            else if(random==1){
                dx=1;
            }
            random=randomobj.nextInt(3);
            if(random==0){
                dy=-1;
            }
            else if(random==1){
                dy=1;
            } 
            count=100;
            pohyb= new Move(this, 1 ,dx , dy);
        }
        pohyb.execute();
        count--;
    }
    
     @Override
    public void act(){      
        if(super.getEnergy()<=0)
            getWorld().removeActor(this);
        moving();
        for( Actor actor : getWorld() ){
            if(actor instanceof Ripley && super.intersects(actor)==true){ 
                   Ripley hrac;
                   hrac = (Ripley) actor;
                   hrac.setEnergy(hrac.getEnergy()-1);                
            }
        
         }
    }
    
}
