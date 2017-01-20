/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.enemies.Mother;
import sk.tuke.oop.game.actors.enemies.StupidAlien;
import sk.tuke.oop.game.actors.enemies.WaitingAlien;
import sk.tuke.oop.game.actors.openables.Finish;
import sk.tuke.oop.game.actors.openables.LockedDoor;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;
import sk.tuke.oop.game.items.GunUpgrade;

/**
 *
 * @author daniel
 */
public class ActorFactoryImpl implements ActorFactory{

    @Override
    public Actor create(String type, String name) {
         if(type.equals("ripley"))
             return new Ripley();
         if(type.equals("alien")) 
              return new Alien(name);
         if(type.equals("energy")) 
              return new Energy(name);

         if(type.equals("card"))       
             return new AccessCard(name);
         if(type.equals("hdoor"))
             return new Door(name,false);
         if(type.equals("reactor"))
             return new Reactor(name);
         if(type.equals("turret"))
             return new LasserTurret(name);
         Actor actor =pmdMethod(type, name);
         if(actor== null)
             actor = methodPMD(type, name);
         return actor;
    }
    
    public Actor pmdMethod(String type, String name){
    
         if(type.equals("wall"))
             return new Wall(name);
         if(type.equals("mother"))
             return new Mother(name);
         if(type.equals("gunup"))
             return new GunUpgrade(name);
         if(type.equals("ammo"))
             return new Ammo(name);
         if(type.equals("waiting"))
             return new WaitingAlien(name);
         if(type.equals("hole"))
             return new Hole(name);
         if(type.equals("stupid"))
             return new StupidAlien(name);

         return null;
    }
    
    public Actor methodPMD(String type, String name){
         if(type.equals("switch"))
             return new Switch(name);
         if(type.equals("finish"))
             return new Finish(name,true);
         if(type.equals("vdoor"))
             return new Door(name,true);
         if(type.equals("hdoorlocked"))
             return new LockedDoor(name,false);
         return null;
    }
    
}
