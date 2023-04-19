package Ventana3;

import java.awt.event.*;
import javax.swing.*;

public class Ventana5 extends JFrame{
    Sonido sonido;
    public Ventana5(){
        initValues();
    }
    private void initValues(){
        JButton btnStart=new JButton("Start");
        JButton btnPause=new JButton("Pause");
        JButton btnResume=new JButton("Resume");
        JButton btnStop=new JButton("Stop");

        btnStart.setBounds(10,10,75,25);
        btnPause.setBounds(90,10,75,25);
        btnResume.setBounds(170,10,75,25);
        btnStop.setBounds(250,10,75,25);
        ActionListener listener=new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (ae.getSource()==btnStart) {
                    sonido=new Sonido("Ventana3/sonido/sonidillo.wav");
                    sonido.play();
                }
                if(ae.getSource()==btnPause){
                    sonido.pause();
                }
                if(ae.getSource()==btnResume){
                    sonido.resume();
                }
                if(ae.getSource()==btnStop){
                    sonido.stopAlto();
                }
            }
        };
        btnStart.addActionListener(listener);
        btnPause.addActionListener(listener);
        btnResume.addActionListener(listener);
        btnStop.addActionListener(listener);

        add(btnStart);
        add(btnPause);
        add(btnResume);
        add(btnStop);
        //Valores ventana
        setTitle("Ventana4");
        setSize(300,300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
