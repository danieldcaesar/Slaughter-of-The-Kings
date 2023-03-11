package item;

import java.awt.Rectangle;


public class Gem extends Item{
    public int value;

    public Gem(){
        solidArea = new Rectangle(8, 8, 16, 16);
        solidAreaX = solidArea.x;
        solidAreaY = solidArea.y;
        collision = true;
        
    }
    
}
