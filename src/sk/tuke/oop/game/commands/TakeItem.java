/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author daniel
 */
public class TakeItem implements Command{
        
    private BackpackImpl batoh;
    private Item item;
    
    public TakeItem(BackpackImpl backpack, Item item){
        batoh=backpack;
        this.item=item;
    }

    @Override
    public void execute() {
        batoh.add(item);
        Actor actor= (Actor) item;
        actor.getWorld().removeActor(actor);
    }
    
    
}
