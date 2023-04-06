package Caballos;

import javax.swing.*;
import java.awt.event.*;
public class Ventana extends JFrame{
    public Ventana(){
        initValues();
    }
    private void initValues(){
        JLabel background=new JLabel();
        ImageIcon icon=new ImageIcon(this.getClass().getResource("images/fondo.jpg"));
        background.setIcon(icon);

        Human1 man=new Human1("images/human1.png", "images/human2.png", "images/humanjump.png","images/humanfall.png");
        JLabel roca=new JLabel();
        ImageIcon rock=new ImageIcon(this.getClass().getResource("images/obstaculo.png"));
        roca.setIcon(rock);
        man.roca=roca;
        JButton btnStart=new JButton("Start");

        //Focus
        man.setFocusable(true);
        btnStart.setFocusable(false);

        //Bounds
        man.setBounds(30,155,36,60);
        roca.setBounds(200,190,30,30);
        btnStart.setBounds(1100,30,70,25);
        background.setBounds(0,-157,3840,1080);
        //Listeners
        ActionListener listener=new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (ae.getSource()==btnStart) {
                    Thread t=new Thread(man);
                    t.start();
                }
            }
        };
        btnStart.addActionListener(listener);
        man.addKeyListener(man);
        //Adds
        add(man);
        add(roca);
        add(btnStart);
        add(background);
        
        //Valores de ventana
        setTitle("Ventana3");
        setSize(1280,720);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
