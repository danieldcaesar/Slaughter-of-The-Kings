package main;

import javax.swing.*;

import entity.Player;
import item.Item;
import tile.TileManager;

import java.awt.*;
// import java.io.BufferedInputStream;
// import java.awt.Image;
// import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{
    public final int tileSize = 16;
    final int scale = 3;
    public final int scaledTile = tileSize*scale;

    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = scaledTile * maxScreenCol;
    public final int screenHeight = scaledTile * maxScreenRow;

    public final int maxWorldCol = 32;
    public final int maxWorldRow = 24;
    public final int worldWidth = scaledTile * maxWorldCol;
    public final int worldHeight = scaledTile * maxWorldRow;


    Thread gameThread;
    final int FPS=60;
    

    SoundManager soundManager  = SoundManager.getInstance();;
    public CollisionManager coManager = new CollisionManager(this);
    public ItemManager itemManager = new ItemManager(this);
    TileManager tileManager = new TileManager(this);
    KeyManager keyHandler = new KeyManager();
    public Item items[] = new Item[10];
    public Player Abraham = new Player(this, keyHandler);

    public GamePanel(){
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.black);
        setDoubleBuffered(true);

        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }

    public void setItems(){
        itemManager.setObject();
    }

    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null){
            update();
            repaint();
            try {
                double remTime = nextDrawTime - System.nanoTime();
                remTime = remTime/1000000;
                
                if(remTime<0)
                    remTime = 0;

                Thread.sleep((long) remTime);
                nextDrawTime += drawInterval;
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        
    }
    public void update(){
        Abraham.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tileManager.draw(g2);

        for(int i=0; i<items.length; i++){
            if(items[i] != null){
                items[i].draw(g2, this);
            }
        }

        Abraham.draw(g2);

        g2.dispose();
    }
    public void playBGM(){
        soundManager.playClip("background", true);
    }
    public void playPowerupSFX(){
        soundManager.playClip("powerup", false);
    }
    public void playCollectSFX(){
        soundManager.playClip("coin", false);
    }
    public void playBlipSFX(){
        soundManager.playClip("blip", false);
    }
    
}
