package Ventana3;
import javax.swing.*;
import java.awt.event.*;
public class Ventana4 extends JFrame{
    boolean bandera=true;
    public Ventana4(){
        initValues();
    }
    private void initValues(){
        JButton btnStart=new JButton("Start");
        Kemonito monito=new Kemonito("images/mario1.png","images/mario2.png",btnStart);
        //JButton btnPause=new JButton("Pause");
        //JButton btnReanudar=new JButton("Reanudar");
        //JButton btnStop=new JButton("Stop");

        monito.setFocusable(true);
        btnStart.setFocusable(false);

        monito.setBounds(10,177,32,39);
        btnStart.setBounds(10,60,70,30);
        //btnPause.setBounds(80,60,70,30);
        //btnReanudar.setBounds(140,60,70,30);
        //btnStop.setBounds(210,60,70,30);

        ActionListener listener=new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(ae.getSource()==btnStart){
                    Thread t=new Thread(monito);
                    t.start();
                }
                /*if(ae.getSource()==btnPause){
                    if (bandera) {
                        monito.pausarHilo();
                        bandera=false;
                    } else {
                        monito.reanudarHilo();
                        bandera=true;
                    }
                    
                }
                if(ae.getSource()==btnReanudar){
                    monito.reanudarHilo();                    
                }
                if(ae.getSource()==btnStop){
                    monito.stopHilo();
                    bandera=true;
                }*/
                
            }//end actionPerformed
        };
        btnStart.addActionListener(listener);
        //btnPause.addActionListener(listener);
        //btnReanudar.addActionListener(listener);
        //btnStop.addActionListener(listener);
        monito.addKeyListener(monito);
        //Adds
        add(monito);
        add(btnStart);
        //add(btnPause);
        //add(btnReanudar);
        //add(btnStop);
        //Valores ventana
        setTitle("Ventana4");
        setSize(300,300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }//end initValues
}
