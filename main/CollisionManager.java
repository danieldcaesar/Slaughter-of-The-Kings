package main;
import entity.Entity;

public class CollisionManager {
    GamePanel panel;
    
    int entityTopLeft;
    int entityTopRight;
    int entityBottomLeft;
    int entityBottomRight;

    public CollisionManager(GamePanel gp){
        panel = gp;
    }
    public void checkTile(Entity entity){
    }
}
