import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class TestPanel extends JPanel implements KeyListener {

        public TestPanel() {

            this.addKeyListener(this);
            this.setFocusable(true);
            this.requestFocusInWindow();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                System.out.println("Right");
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                System.out.println("Left");
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }