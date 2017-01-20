package sk.tuke.oop.game;

import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.ActorFactoryImpl;
import sk.tuke.oop.game.actors.LasserTurret;
import sk.tuke.oop.game.actors.Reactor;
//import sk.tuke.oop.game.actors.Switch;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author Manager
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ActorFactoryImpl factory= new ActorFactoryImpl();
        SlickWorld hra= new SlickWorld( "hra",800,600);
        hra.setFactory(factory);
        
        
        hra.setMap("resources/levels/map.tmx");      
        
        hra.run();
        
    }
    
    public static void scenario(){
        
        Ripley ripley = new Ripley();
        //hrac zapne reactor
        new Reactor("reactor").use(ripley);
        //otoci vezu 3x
        LasserTurret turret = new LasserTurret("turret");
        turret.use(ripley);
        turret.use(ripley);
        turret.use(ripley);
        //zapne ve lasserovu vezu zelenim tlacitkom a pocka kym prepali stenu
       // Swtich switch = new Switch("switch");
                
    } 
   
}
   