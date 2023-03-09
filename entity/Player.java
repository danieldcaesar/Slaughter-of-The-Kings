package entity;


import main.GamePanel;
import main.KeyManager;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.Color;s
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;



public class Player extends Entity {
    GamePanel panel;
    KeyManager keyHandler;

    public Player(GamePanel gp, KeyManager km){
        panel = gp;
        keyHandler = km;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 5;
        direction = "down";
    }
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("../sprites/characters/player/up-1"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../sprites/characters/player/up-2"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../sprites/characters/player/down-1"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../sprites/characters/player/down-2"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../sprites/characters/player/left-1"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../sprites/characters/player/left-2"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../sprites/characters/player/right-1"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../sprites/characters/player/right-2"));

        //     up1 = ImageManager.loadBufferedImage("../sprites/character/player/up-1");
        // up2 = ImageManager.loadBufferedImage("../sprites/character/player/up-2");
        // down1 = ImageManager.loadBufferedImage("../sprites/character/player/down-1");
        // down2 = ImageManager.loadBufferedImage("../sprites/character/player/down-2");
        // left1 = ImageManager.loadBufferedImage("../sprites/character/player/left-1");
        // left2 = ImageManager.loadBufferedImage("../sprites/character/player/left-2");
        // right1 = ImageManager.loadBufferedImage("../sprites/character/player/right-1");
        // right2 = ImageManager.loadBufferedImage("../sprites/character/player/right-2");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if (keyHandler.upPressed == true) {
            direction = "up";
            y -= speed;
        }
        else if (keyHandler.downPressed == true) {
            direction = "down";
            y += speed;
        }
        else if (keyHandler.leftPressed == true) {
            direction = "left";
            x -= speed;
        }
        else if (keyHandler.rightPressed == true) {
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, panel.scaledTile, panel.scaledTile);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
            default:
                break;
        }
        g2.drawImage(image, x, y, panel.scaledTile, panel.scaledTile, null);
    }
}
