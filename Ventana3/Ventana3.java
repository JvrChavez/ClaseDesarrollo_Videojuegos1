package Ventana3;
import javax.swing.*;
import java.awt.event.*;
public class Ventana3 extends JFrame{
    public Ventana3(){
        initValues();
    }
    private void initValues(){
        JLabel background=new JLabel();
        ImageIcon icon=new ImageIcon(this.getClass().getResource("images/background.jpg"));
        background.setIcon(icon);

        Imagen4 img=new Imagen4("images/mario1.png","images/mario2.png");

        JLabel base=new JLabel();
        ImageIcon icon2=new ImageIcon(this.getClass().getResource("images/base.PNG"));
        base.setIcon(icon2);

        img.base=base;

        JButton btnStart=new JButton("Start");

        img.setFocusable(true);
        btnStart.setFocusable(false);

        img.setBounds(10,177,32,39);
        btnStart.setBounds(10,80,75,30);
        base.setBounds(0,215,162,27);
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
        add(btnStart);
        add(background);
        //Valores de ventana
        setTitle("Ventana2");
        setSize(300,300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
