/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.Movable;
/**
 *
 * @author daniel
 */
public class Move implements Command {
    
    private int step, dx, dy;
    private Movable actor;
    
    public Move(Movable actor,int step, int dx, int dy){
        this.step=step;
        this.dx=dx;
        this.dy=dy;
        this.actor=actor;
    }
    
    @Override
    public void execute() {
        Actor actor= (Actor) this.actor;
        int x, y;
        double angle;
        Animation animacia;
        animacia=actor.getAnimation();
        x=actor.getX()+(dx*step);
        y=actor.getY()+(dy*step);
        actor.setPosition(x, y);
        if(actor.getWorld().intersectWithWall(actor))
            actor.setPosition(x-(dx*step), y-(dy*step));
        if(dx!=0 || dy!=0){
            animacia.start();
            angle= Math.toDegrees(Math.atan2(dy,dx))+90;
            if(animacia.getRotation() != (int) angle)
                animacia.setRotation((int)angle);
        }
        else{
            animacia.stop();
        }
    }
    
}
