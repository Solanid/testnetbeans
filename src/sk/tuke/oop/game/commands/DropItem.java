/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;


import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author daniel
 */
public class DropItem implements Command {
    
    private BackpackImpl batoh;
    private World world;
    private int x, y;
    
    public DropItem(BackpackImpl backpack, World world, int x, int y){
        this.x=x;
        this.y=y;
        this.world=world;
        batoh=backpack;
    }

    @Override
    public void execute() {
        Item item= batoh.getLastItem();
        world.addActor(item);
        item.setPosition(x, y);
        batoh.remove(item);
    }    
    
}
