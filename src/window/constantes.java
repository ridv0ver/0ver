package src.window;

import java.awt.Font;
import javax.swing.*;

public class constantes extends JFrame {
    JLabel marca;
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public JLabel generaMarca(){
        marca = new JLabel("Over 2020 v0.9");
        marca.setBounds(1075,500,200,100);
        marca.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,15));
        return marca;
    }
}
