package entity;


import main.GamePanel;
import main.KeyManager;

public class Player extends Entity {
    GamePanel panel;
    KeyManager keyHandler;

    public Player(GamePanel gp, KeyManager km){
        panel = gp;
        keyHandler = km;
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 5;
    }
    public void update(){
        if (keyHandler.upPressed == true) {
            y -= speed;
        }
        else if (keyHandler.downPressed == true) {
            y += speed;
        }
        else if (keyHandler.leftPressed == true) {
            x -= speed;
        }
        else if (keyHandler.rightPressed == true) {
            x += speed;
        }
    }
    public void draw(){

    }
}
