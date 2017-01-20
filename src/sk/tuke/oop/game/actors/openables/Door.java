/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Observer;

/**
 *
 * @author daniel
 */
public class Door extends AbstractActor implements Openable, Observer {
    private boolean otvorene;
    private boolean vertical;
    private Animation animation;
    private List<Observer> listOfObservers;
    
    public Door(String name,boolean vertical){
        super(name);        
        this.vertical=vertical;
        listOfObservers = new ArrayList<Observer>();
        if(vertical){
            animation= new Animation("resources/sprites/vdoor.png", 16, 32,100);
            
        }
        else
            animation= new Animation("resources/sprites/hdoor.png", 32, 16,100);
        otvorene = false;
        super.setAnimation(animation);
        animation.stop();
        animation.setPingPong(true);       
        
    }
    
    public void addObserver(Observer observer){
        listOfObservers.add(observer);
    }
    
    public void removeObserver(Observer observer){
        listOfObservers.remove(observer);
    }
    
    public boolean getOtvorene(){
        return otvorene;
    }
    
    public void setOtvorene(boolean otvorene){
        this.otvorene=otvorene;
    }

    @Override
    public void open() {
       otvorene= true; 
       animation.stopAt(3);
       animation.start();
       wakeUp();
       wall();
    }

    @Override
    public void close() {
        otvorene= false;
        animation.stopAt(0);
        animation.start();
        wall();
    }

    public void wall(){
    getWorld().setWall(this.getX()/16, this.getY()/16 , !otvorene);
       if(vertical)
           getWorld().setWall(this.getX()/16, (this.getY()/16)+1 , !otvorene);
       else
           getWorld().setWall((this.getX()/16)+1, this.getY()/16 , !otvorene);
    }
    
    @Override
    public boolean isOpen() {
        return otvorene;
    }
    
//    @Override
//    public void addedToWorld(World world) {
//        super.addedToWorld(world);
//        getWorld().setWall(this.getX()/16, this.getY()/16 , !otvorene);
//        if(vertical)
//           getWorld().setWall(this.getX()/16, (this.getY()/16)+1 , !otvorene);
//        else
//           getWorld().setWall((this.getX()/16)+1, this.getY()/16 , !otvorene);
//    }

    @Override
    public void wakeUp() {
        for(Observer observer : listOfObservers){
            observer.wakeUp();
        }
    }

}
