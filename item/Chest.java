package item;

import main.ImageManager;

public class Chest extends Item{
    public Chest(){
        name = "chest";
        image = ImageManager.loadBufferedImage("sprites/objects/chest-1.png");
    }
}
