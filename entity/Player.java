package entity;


import main.GamePanel;
import main.ImageManager;
import main.KeyManager;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;




public class Player extends Entity {
    GamePanel panel;
    KeyManager keyHandler;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyManager km){
        panel = gp;
        keyHandler = km;

        screenX = panel.screenWidth/2 - (panel.scaledTile/2);
        screenY = panel.screenHeight/2 - (panel.scaledTile/2);

        solidArea = new Rectangle(16, 32, 16, 16);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = panel.scaledTile * 12;
        worldY = panel.scaledTile * 16;
        speed = 3;
        direction = "down";
    }
    public void getPlayerImage(){
        up1 = ImageManager.loadBufferedImage("sprites/characters/player/up-1.png");
        down1 = ImageManager.loadBufferedImage("sprites/characters/player/down-1.png");
        left1 = ImageManager.loadBufferedImage("sprites/characters/player/left-1.png");
        right1 = ImageManager.loadBufferedImage("sprites/characters/player/right-1.png");
        up2 = ImageManager.loadBufferedImage("sprites/characters/player/up-2.png");
        down2 = ImageManager.loadBufferedImage("sprites/characters/player/down-2.png");
        left2 = ImageManager.loadBufferedImage("sprites/characters/player/left-2.png");
        right2 = ImageManager.loadBufferedImage("sprites/characters/player/right-2.png");
        
        // try {
        //     up1 = ImageIO.read(getClass().getClassLoader().getResource("sprites/characters/player/up-1.png"));
        //     up2 = ImageIO.read(getClass().getClassLoader().getResource("sprites/characters/player/up-2.png"));
        //     down1 = ImageIO.read(getClass().getClassLoader().getResource("sprites/characters/player/down-1.png"));
        //     down2 = ImageIO.read(getClass().getClassLoader().getResource("sprites/characters/player/down-2.png"));
        //     left1 = ImageIO.read(getClass().getClassLoader().getResource("sprites/characters/player/left-1.png"));
        //     left2 = ImageIO.read(getClass().getClassLoader().getResource("sprites/characters/player/left-2.png"));
        //     right1 = ImageIO.read(getClass().getClassLoader().getResource("sprites/characters/player/right-1.png"));
        //     right2 = ImageIO.read(getClass().getClassLoader().getResource("sprites/characters/player/right-2.png"));


        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
    public void update(){
        if(keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true){
            if (keyHandler.upPressed == true) {
                direction = "up";
                worldY -= speed;
            }
            else if (keyHandler.downPressed == true) {
                direction = "down";
                worldY += speed;
            }
            else if (keyHandler.leftPressed == true) {
                direction = "left";
                worldX -= speed;
            }
            else if (keyHandler.rightPressed == true) {
                direction = "right";
                worldX += speed;
            }

            collisionOn = false;
            panel.coManager.checkTile(this);

            spriteCounter++;
            if(spriteCounter > 15){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        
    }
    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, panel.scaledTile, panel.scaledTile);

        BufferedImage image = null;

        switch (direction) {
            case "up":
            if(spriteNum == 1){
                image = up1;
            }
            if(spriteNum == 2){
                image = up2;
            }    
            break;
            case "down":
            if(spriteNum == 1){
                image = down1;
            }
            if(spriteNum == 2){
                image = down2;
            }    
            break;
            case "left":
            if(spriteNum == 1){
                image = left1;
            }
            if(spriteNum == 2){
                image = left2;
            }    
            break;
            case "right":
            if(spriteNum == 1){
                image = right1;
            }
            if(spriteNum == 2){
                image = right2;
            }    
            break;
            default:
                break;
        }
        g2.drawImage(image, screenX, screenY, 64, 64, null);
    }
}
