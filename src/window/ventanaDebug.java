package src.window;

import javax.swing.*;

public class ventanaDebug extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ventanaDebug(){
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        //cargarComplementos();
    }
    
}
