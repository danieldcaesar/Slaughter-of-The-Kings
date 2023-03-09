package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP)
            upPressed = true;
        if (keyCode == KeyEvent.VK_DOWN)
            downPressed = true;
        if (keyCode == KeyEvent.VK_LEFT)
            leftPressed = true;
        if (keyCode == KeyEvent.VK_RIGHT)
            rightPressed = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP)
            upPressed = false;
        if (keyCode == KeyEvent.VK_DOWN)
            downPressed = false;
        if (keyCode == KeyEvent.VK_LEFT)
            leftPressed = false;
        if (keyCode == KeyEvent.VK_RIGHT)
            rightPressed = false;
    }
    
}
