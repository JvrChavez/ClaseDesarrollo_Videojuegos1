package Caballos;

import javax.swing.*;
import java.awt.event.*;
public class Ventana extends JFrame{
    public Ventana(){
        initValues();
    }
    private void initValues(){
        JLabel background=new JLabel();
        ImageIcon icon=new ImageIcon(this.getClass().getResource("images/background.jpg"));
        background.setIcon(icon);

        /*Imagen4 img=new Imagen4("images/mario1.png","images/mario2.png","images/marioSaltoOrigin.png");

        JLabel base=new JLabel();
        ImageIcon icon2=new ImageIcon(this.getClass().getResource("images/base.png"));
        base.setIcon(icon2);

        JLabel base2=new JLabel();
        ImageIcon icon3=new ImageIcon(this.getClass().getResource("images/base.png"));
        base2.setIcon(icon3);

        img.base=base;
        img.base2=base2;

        JButton btnStart=new JButton("Start");

        img.setFocusable(true);
        btnStart.setFocusable(false);

        img.setBounds(10,177,32,39);
        btnStart.setBounds(10,80,75,30);
        base.setBounds(0,215,162,27);
        base2.setBounds(200,215,162,27);
        background.setBounds(0,-817,3840,1080);
        //Listeners de hilos
        ActionListener listener=new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Thread t=new Thread(img);
                t.start();
            }//end actionPerformed
        };
        btnStart.addActionListener(listener);
        img.addKeyListener(img);        
        //Agregar elementos
        add(img);
        add(base);
        add(base2);
        add(btnStart);*/
        background.setBounds(0,-817,3840,1080);
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
