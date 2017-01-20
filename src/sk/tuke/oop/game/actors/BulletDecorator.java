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
public class BulletDecorator extends AbstractActor implements Decorator{

    private Decorator bullet;
    private int dx,dy;
    
    
    public BulletDecorator(Decorator bullet) {
        super("decorator");
        this.bullet=bullet;
    }
    
    @Override
    public void act(){
        bullet.act();
    }

    @Override
    public void setDirection(int dx, int dy) {
        this.dx=dx;
        this.dy=dy;
    }

    @Override
    public void movement() {
        int x, y;
        x=getX()+(dx*4);
        y=getY()+(dy*4);
        setPosition(x, y);  
    }

}
