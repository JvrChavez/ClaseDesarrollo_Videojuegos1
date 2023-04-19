package Ventana1;//En visual studio code necesita llevar package, en consola puede omitirse
//Author Javier Chavez 218212241
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
    private Font font1;
    //private JLabel texto1;
    private JButton btn1;
    public Ventana(){
        initValues();
        //escucharButton();
    }//end Ventana
    public void initValues(){
        font1=new Font("Arial",1,24);
        //Se crea texto 1
        Etiqueta texto1=new Etiqueta("Hilo 1 : ");//Que se haga thread contando 1-10 con un button
        texto1.setFont(font1);
        texto1.setBounds(50,10,200,25);
        add(texto1);
        //Se crea texto 2
        Etiqueta texto2=new Etiqueta("Hilo 2 : ");//Que se haga thread contando 1-10 con un button
        texto2.setFont(font1);
        texto2.setBounds(50,40,200,25);
        add(texto2);
        //Se crea boton 1
        btn1=new JButton("Incrementar");//Boton para accionar el conteo
        btn1.setFont(font1);;
        btn1.setBounds(50,150,200,25);
        add(btn1);
        //Especificaciones de mi ventana
        setTitle("Mi Ventana");
        setSize(300,300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Accionador de los botones
        ActionListener listener=new ActionListener(){
            public void actionPerformed(ActionEvent ae1){
                System.out.println("Me diste click");                
                Thread t1=new Thread(texto1);
                texto1.time=(1000);
                texto1.btn1=(btn1);
                texto1.name=("Hilo 1 : ");
                t1.start();
                Thread t2=new Thread(texto2);
                texto2.time=(800);
                texto2.btn1=(btn1);
                texto2.name=("Hilo 2 : ");
                t2.start();
            }
        };
        btn1.addActionListener(listener);
    }//end initvalues
    /*public void escucharButton(){
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementar();
            }
        });
    }//end escucharButton
    private void incrementar() {//Se crea y llama el hilo 
        Hilo h=new Hilo();
        //h.setLabel(texto1);
        h.setTime(500);
        Thread t1=new Thread(h);
        t1.start();
    }//end incrementar*/
}