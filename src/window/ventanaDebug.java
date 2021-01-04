package src.window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaDebug extends JFrame implements ActionListener{
    JTextField debug;
    JButton button;
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
    }
    
    public void debugger(){
        debug = new JTextField();
        debug.setBounds(200,300,500,50);
        add(debug);
        button = new JButton("1001010");
        button.addActionListener(this);
        button.setBounds(750, 250, 200, 200);
        add(button);
        setVisible(true);
    }

    public void debugsCodes(String code){
        if(code.equalsIgnoreCase("1432")){
            dispose();
            fullAdmin ventana = new fullAdmin();
            ventana.setVisible(true);
        }
        if(code.equalsIgnoreCase("0")){
            dispose();
            ventanaPrincipal ventana = new ventanaPrincipal();
            ventana.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        debugsCodes(debug.getText());     
    }
}
