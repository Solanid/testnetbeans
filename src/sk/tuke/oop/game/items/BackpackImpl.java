/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import sk.tuke.oop.framework.Backpack;
import sk.tuke.oop.framework.Item; 

/**
 *
 * @author daniel
 */
public class BackpackImpl implements Backpack{
    private List<Item> list;
    private int capacity;
    
    public BackpackImpl(int capacity){
        this.capacity=capacity;
        list=new ArrayList<>(capacity-1);
    }
    
    
    @Override
    public void add(Item item) {
        if(list.size()<capacity){
            list.add(0,item);
        }
        else
            throw new ArrayIndexOutOfBoundsException("Backpack is full");
    }
    
    public void addLast(Item item) {
        if(list.size()<capacity){
            list.add(item);
        }
        else
            throw new ArrayIndexOutOfBoundsException("Backpack is full");
    }
    
    public void next(){
        Collections.rotate(list, 1);
    }
    

    public Item getFirstItem(){
        if(!list.isEmpty())
            return list.get(0);
        return null;
    }
    
    public Item getLastItem(){
        if(!list.isEmpty())
            return list.get(list.size()-1);
        return null;
    }    

    @Override
    public void remove(Item item) {
        if(!list.isEmpty()){
            if(list.remove(item)==false){
                throw new NoSuchElementException("No such item in backpack");
            }
        }  
        else    
            throw new NoSuchElementException("Backpack is already empty");
            
    }

    @Override
    public Iterator<Item> iterator() {
          return list.iterator(); 
    }
    
}
