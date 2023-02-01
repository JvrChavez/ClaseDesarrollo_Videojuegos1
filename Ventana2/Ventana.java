package Ventana2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    public Ventana(){
        initValues();
    }
    private void initValues(){
        Font font1=new Font("Arial",1,22);
        JLabel texto1=new JLabel ("Hilo 1 : ");
        texto1.setFont(font1);
        JButton btnStart=new JButton("Start");

        texto1.setBounds(10,10,120,25);
        btnStart.setBounds(10,40,75,25);
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MyThread t=new MyThread();
                t.btn=btnStart;
                t.texto1=texto1;
                t.start();
            }
        };

        add(texto1);
        add(btnStart);
        //Especificaciones de mi ventana
        setTitle("Mi Ventana");
        setSize(300,300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btnStart.addActionListener(listener);
    }//end initValues
    
}
