package conecta4;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class Menu {
    JFrame principal;
    JButton btmJugarCBot;
    JButton btmJugarCAmigo;
    JButton btmSalir;

    public Menu(){

    }

    public void abrir(){
        principal = new JFrame("Conecta4 - Menu Principal");
        principal.setLayout(new FlowLayout());
        btmJugarCBot = new JButton("Jugar contra un bot");
        btmJugarCAmigo = new JButton("Jugar contra un amigo");
        btmSalir = new JButton("Salir");
        principal.setSize(1000, 600);
        principal.setResizable(false);
        principal.add(btmJugarCBot);
        principal.add(btmJugarCAmigo);
        principal.add(btmSalir);
        btmSalirAction();
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setVisible(true);
    }

    private void btmSalirAction(){
        btmSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
}
