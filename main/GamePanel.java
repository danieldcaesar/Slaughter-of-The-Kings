package main;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import entity.Player;

import java.awt.*;
import java.io.BufferedInputStream;
// import java.awt.Image;
// import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{
    final int tileSize = 16;
    final int scale = 3;
    public final int scaledTile = tileSize*scale;

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = scaledTile * maxScreenCol;
    final int screenHeight = scaledTile * maxScreenRow;

    Thread gameThread;
    final int FPS=60;

    // BufferedImage image;

    KeyManager keyHandler = new KeyManager();
    Player Abraham = new Player(this, keyHandler);;

    public GamePanel(){
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.black);
        setDoubleBuffered(true);

        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        // image = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
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
            paintComponent(getGraphics());
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

        Abraham.draw(g2);

        g2.dispose();
    }

    
}
