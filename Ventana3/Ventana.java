package Ventana3;
import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame{
    boolean correri;
    public Ventana(){
        initValues();
    }    
    private void initValues(){
        //Inicializar etiquetas
        JButton btnStart=new JButton("Start");
        
        //Imagen img1=new Imagen("images/mario1.png","images/mario2.png",40,40);
        Imagen2 img2=new Imagen2("images/mario1.png","images/mario2.png","images/marioi1.png","images/marioi2.png");
        Fondo back=new Fondo("images/background.jpg",img2);       
        //Focusable
        img2.setFocusable(true);
        back.setFocusable(false);
        btnStart.setFocusable(false);
        //Set Bounds
        btnStart.setBounds(10,10,75,25);
        //img1.setBounds(10,40,42,42);
        img2.setBounds(10,174,42,42);
        back.setBounds(0,-817,3840,1080);

        ActionListener listener=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Deshabilitar el boton
                btnStart.setEnabled(false);
                //Hilo mario
                /*Thread tm=new Thread(img1);
                img1.btnStart=(btnStart);
                tm.start();*/
                //Hilo Link
                Thread t2=new Thread(img2);
                img2.correr=correri;
                t2.start();
                Thread t3=new Thread(back);
                back.correr=correri;
                t3.start();//Hola
            }
        };
        //Listeners
        btnStart.addActionListener(listener);
        img2.addKeyListener(img2);
        //Los ADD
        add(btnStart);
        /*add(img1);*/
        add(img2);
        add(back);
        
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