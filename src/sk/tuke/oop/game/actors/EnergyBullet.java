/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.enemies.Enemy;

/**
 *
 * @author daniel
 */
public class EnergyBullet extends BulletDecorator{

    
    public EnergyBullet(Decorator bullet) {
        super(bullet);
        Animation animation = new Animation("resources/sprites/energy_wave.png", 16, 16);
        super.setAnimation(animation);
    }
    
    @Override
    public void act(){
        super.movement();
        for(Actor actor : getWorld()){
            if(actor instanceof Enemy  && intersects(actor) ){
                AbstractCharacter character =(AbstractCharacter) actor;
                character.setEnergy(character.getEnergy() - 25);
                getWorld().removeActor(this);
                break;
            }
        }
        if(getWorld().intersectWithWall(this)){
            getWorld().removeActor(this);            
        }
    }
    }
