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
public interface Decorator{
    public void act();
    public void setDirection(int dx, int dy);
    public void movement();
}
