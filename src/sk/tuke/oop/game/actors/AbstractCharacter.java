/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

/**
 *
 * @author daniel
 */
public class AbstractCharacter extends AbstractActor{

    private int energy;
    
    public AbstractCharacter(String name) {
        super(name);
    }
    
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
