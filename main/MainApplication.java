package main;

import javax.swing.JFrame;


/**
 * MainApplication
 */
public class MainApplication {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Slaughter of the Kings");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setItems();
        gamePanel.startThread();
    }
    
    
}