package entity;

import main.GamePanel;
import main.KeyManager;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Entity {
    public int worldX, worldY, speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteNum=1, spriteCounter=10;

    public Rectangle solidArea;
    public boolean collisionOn = false;

}
