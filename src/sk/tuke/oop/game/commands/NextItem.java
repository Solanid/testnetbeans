/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author daniel
 */
public class NextItem implements Command{
    
    private BackpackImpl batoh;
    
    public NextItem(BackpackImpl backpack){
        batoh=backpack;
    }

    @Override
    public void execute() {
        batoh.next();
    }
    
}
