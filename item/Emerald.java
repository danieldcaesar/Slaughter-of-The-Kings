package item;

import main.ImageManager;

public class Emerald extends Gem{
    public Emerald(){
        super();
        name = "emerald";
        image = ImageManager.loadBufferedImage("sprites/objects/gem-2.png");
    }
}
