package Ventana3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{
    public Ventana(){
        initValues();
    }
    
    private void initValues(){
        //Inicializar etiquetas
        JButton btnStart=new JButton("Start");
        Imagen img1=new Imagen("images/mario1.png","images/mario2.png",40,40);
        Imagen2 img2=new Imagen2("images/link1.png","images/link2.png");
        //Focusable
        img2.setFocusable(true);
        btnStart.setFocusable(false);
        //Set Bounds
        btnStart.setBounds(10,10,75,25);
        img1.setBounds(10,40,42,42);
        img2.setBounds(10,90,42,42);

        ActionListener listener=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Deshabilitar el boton
                btnStart.setEnabled(false);
                //Hilo mario
                Thread tm=new Thread(img1);
                img1.btnStart=(btnStart);
                tm.start();
                //Hilo Link
                Thread t2=new Thread(img2);
                t2.start();
                /*//Hilo link
                Thread tl=new Thread (img2);
                img2.btnStart=(btnStart);
                tl.start();*/
            }
        };
        //Listeners
        btnStart.addActionListener(listener);
        img2.addKeyListener(img2);
        //Los ADD
        add(btnStart);
        add(img1);
        add(img2);
        //valores ventana
        setTitle("Ventana #3");
        setSize(300,300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }//end initValues
    
}
