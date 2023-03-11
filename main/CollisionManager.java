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

    public int checkObject(Entity ent, boolean player){
        int index = 99;

        for(int i=0; i<panel.items.length; i++){
            if(panel.items[i] != null){
                ent.solidArea.x += ent.worldX;
                ent.solidArea.y += ent.worldY;

                panel.items[i].solidArea.x += panel.items[i].worldX;
                panel.items[i].solidArea.y += panel.items[i].worldY;

                switch(ent.direction){
                    case "up":{
                        ent.solidArea.y -= ent.speed;
                        if(ent.solidArea.intersects(panel.items[i].solidArea)){
                            if(panel.items[i].collision == true){
                                ent.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                    }
                        
                    case "down":{
                        ent.solidArea.y -= ent.speed;
                        if(ent.solidArea.intersects(panel.items[i].solidArea)){
                            if(panel.items[i].collision == true){
                                ent.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    }
                        
                    case "left":{
                        ent.solidArea.y -= ent.speed;
                        if(ent.solidArea.intersects(panel.items[i].solidArea)){
                            if(panel.items[i].collision == true){
                                ent.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    }
                        
                    case "right":{
                        ent.solidArea.y -= ent.speed;
                        if(ent.solidArea.intersects(panel.items[i].solidArea)){
                            if(panel.items[i].collision == true){
                                ent.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    }
                        
                    default: break;
                    
                }
                ent.solidArea.x = ent.solidAreaX;
                ent.solidArea.y = ent.solidAreaY;
                panel.items[i].solidArea.x = panel.items[i].solidAreaX;
                panel.items[i].solidArea.y = panel.items[i].solidAreaY;
            }
        }

        return index;
    }
}
