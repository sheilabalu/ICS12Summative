import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @see http://stackoverflow.com/a/16531380/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new TestPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class TestPanel extends JPanel implements KeyListener {

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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}