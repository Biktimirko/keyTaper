import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;

import java.util.Random;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class TestFrame extends JFrame {
     
    private JLabel label;
    private JLabel textLabel;
    private JLabel anvLabel;
    private static int[] keyArray;
    private int keyRand;
     
    public TestFrame() {
        super("Test frame");
        createGUI();
    }



    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	keyRand = getRandom(keyArray);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setFocusable(true);
 
        label = new JLabel();
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        textLabel = new JLabel();
        textLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        anvLabel = new JLabel();
        anvLabel.setFont(new Font("Calibri", Font.PLAIN, 20));         
        
	textLabel.setText(KeyEvent.getKeyText(keyRand));

	panel.addKeyListener(new KeyAdapter() {
 
            public void keyPressed(KeyEvent e) {
                
		label.setText(e.getKeyText(e.getKeyCode()));
		if (label.getText().equals(textLabel.getText())){
			anvLabel.setText("GREAT");
                }else{
			anvLabel.setText("BAD");
		}
		keyRand = getRandom(keyArray);
		textLabel.setText(KeyEvent.getKeyText(keyRand));
            }
             
        });

        panel.add(label, BorderLayout.CENTER);
        panel.add(textLabel, BorderLayout.NORTH);
        panel.add(anvLabel, BorderLayout.SOUTH);
                 
        setPreferredSize(new Dimension(200, 200));
        getContentPane().add(panel);
    }
     
    public static void main(String[] args) {
        
	    keyArray = new int[] {65, 83, 68, 70, 71, 72, 74, 75, 76, 59};

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                TestFrame frame = new TestFrame();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static int getRandom(int[] array) {
    	int rnd = new Random().nextInt(array.length);
            return array[rnd];
    }
}
