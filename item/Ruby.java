package item;

import main.ImageManager;

public class Ruby extends Gem{
    public Ruby(){
        super();
        name = "ruby";
        image = ImageManager.loadBufferedImage("sprites/objects/gem-3.png");
    }
    
}
