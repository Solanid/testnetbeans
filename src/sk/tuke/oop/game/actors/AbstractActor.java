/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

/**
 *
 * @author daniel
 */
public class AbstractActor implements Actor{

    private int x;
    private int y;
    private Animation running;
    private World world;
    private String name;
    
    public AbstractActor(String name){
        this.name=name;
    }
    
    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
       return this.y; 
    }

    @Override
    public int getWidth() {
        return this.running.getWidth();
    }

    @Override
    public int getHeight() {
         return this.running.getHeight();
    }

    @Override
    public void setPosition(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public Animation getAnimation() {
        return this.running;
    }

    @Override
    public void setAnimation(Animation animation) {
        this.running=animation;
    }

    @Override
    public void act() {
        
    }

    @Override
    public boolean intersects(Actor actor) {
        int actorX, actorY, actorW, actorH;
        actorX = actor.getX();
        actorY = actor.getY();
        actorW = actor.getWidth();
        actorH = actor.getHeight();
        
        return !(getX()+getWidth()< actorX || getX()> actorX+actorW ||
                getY()+getHeight()< actorY || getY() > actorY+actorH);
    }
    

    
    
    @Override
    public void addedToWorld(World world) {
        this.world=world;
    }
    
    public Actor getActorByName(String name){
        for(Actor actor : getWorld()){
            if(actor.getName().contentEquals(name))
                return actor;
        }
        return null;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    

    public void setName(String name) {
        this.name= name ;
    }

    @Override
    public World getWorld() {
       return world;
    }
       
}
