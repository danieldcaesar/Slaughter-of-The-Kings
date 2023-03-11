package main;

import item.*;

public class ItemManager {
    GamePanel panel;

    public ItemManager(GamePanel gp){
        panel = gp;
    }
    public void setObject(){
        panel.items[0] = new Chest();
        panel.items[0].worldX = 15 * panel.scaledTile;
        panel.items[0].worldY = 10 * panel.scaledTile;

        panel.items[1] = new Ruby();
        panel.items[1].worldX = 15 * panel.scaledTile;
        panel.items[1].worldY = 9 * panel.scaledTile;

        panel.items[2] = new Emerald();
        panel.items[2].worldX = 15 * panel.scaledTile;
        panel.items[2].worldY = 8 * panel.scaledTile;
    }
}
