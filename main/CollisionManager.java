package main;
import entity.Entity;

public class CollisionManager {
    GamePanel panel;
    


    public CollisionManager(GamePanel gp){
        panel = gp;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/panel.scaledTile;
        int entityRightCol = entityRightWorldX/panel.scaledTile;
        int entityTopRow = entityTopWorldY/panel.scaledTile;
        int entityBottomRow = entityBottomWorldY/panel.scaledTile;

        int tileNum1, tileNum2;
        
        switch (entity.direction) {
            case "up": 
                entityTopRow = (entityTopWorldY - entity.speed)/panel.scaledTile;
                tileNum1 = panel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = panel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(panel.tileManager.tile[tileNum1].collision == true || panel.tileManager.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "down": 
                entityBottomRow = (entityBottomWorldY + entity.speed)/panel.scaledTile;
                tileNum1 = panel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = panel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(panel.tileManager.tile[tileNum1].collision == true || panel.tileManager.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left": 
                entityLeftCol = (entityLeftWorldX - entity.speed)/panel.scaledTile;
                tileNum1 = panel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = panel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if(panel.tileManager.tile[tileNum1].collision == true || panel.tileManager.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;

            case "right": 
                entityRightCol = (entityRightWorldX + entity.speed)/panel.scaledTile;
                tileNum1 = panel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = panel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(panel.tileManager.tile[tileNum1].collision == true || panel.tileManager.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        
            default:
                break;
        }
    }
}
