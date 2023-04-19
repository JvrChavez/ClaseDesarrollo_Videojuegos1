package Ventana3;
import javax.swing.*;
import java.awt.event.*;
public class Ventana2 extends JFrame{
    public Ventana2(){
        initValues();
    }
    private void initValues(){
        JLabel background=new JLabel();
        ImageIcon icon=new ImageIcon(this.getClass().getResource("images/background.jpg"));
        background.setIcon(icon);

        Imagen3 img=new Imagen3("images/mario1.png","images/mario2.png","images/marioSaltoOrigin.png");
        img.background=background;

        JButton btnStart=new JButton("Start");

        JLabel wall1=new JLabel();
        ImageIcon icon2=new ImageIcon(this.getClass().getResource("images/wall.png"));
        wall1.setIcon(icon2);
        img.wall1=wall1;
        //Focus
        img.setFocusable(true);
        btnStart.setFocusable(false);
        //Bounds
        btnStart.setBounds(10,80,75,30);
        wall1.setBounds(70,204,16,12);
        background.setBounds(0,-817,3840,1080);
        img.setBounds(10,174,32,39);
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
        add(wall1);
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
