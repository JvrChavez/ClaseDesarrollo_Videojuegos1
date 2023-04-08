package Caballos;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Ventana extends JFrame{
    public Ventana(){
        initValues();
    }
    private void initValues(){
        JLabel background=new JLabel();
        ImageIcon icon=new ImageIcon(this.getClass().getResource("images/fondo.jpg"));
        background.setIcon(icon);
        
        JLabel controles=new JLabel("Enter: Pausar/Reanudar     Esc: Stop       Flechas: Moverse    Shift: Correr");
        controles.setForeground(Color.BLACK);
        controles.setFont(new Font("Arial", Font.BOLD, 30));

        Human1 man=new Human1("images/human1.png", "images/human2.png", "images/humanjump.png","images/humanfall.png");
        Bots bot=new Bots("images/human1.png", "images/human2.png", "images/humanjump.png","images/humanfall.png","corredor 3");
        Bots bot2=new Bots("images/human1.png", "images/human2.png", "images/humanjump.png","images/humanfall.png","corredor 1");
        Ganador gan=new Ganador();
        JLabel roca=new JLabel();
        JLabel rocabot=new JLabel();
        JLabel rocabot2=new JLabel();
        ImageIcon rock=new ImageIcon(this.getClass().getResource("images/obstaculo.png"));
        roca.setIcon(rock);
        rocabot.setIcon(rock);
        rocabot2.setIcon(rock);        
        man.roca=roca;
        man.rocaother=rocabot;
        man.rocaother2=rocabot2;
        bot.roca=rocabot;
        bot.rocaother=roca;
        bot.rocaother2=rocabot2;
        bot2.roca=rocabot2;
        bot2.rocaother=roca;
        bot2.rocaother2=rocabot;
        man.fondo=background;
        bot.fondo=background;
        bot2.fondo=background;
        man.botcito=bot;
        man.botcito2=bot2;
        bot.player=man;
        bot.botcito=bot2;
        bot2.player=man;
        bot2.botcito=bot;
        man.gan=gan;
        bot.gan=gan;
        bot2.gan=gan;
        JButton btnStart=new JButton("Start");
        man.btnStart=btnStart;

        //Focus
        man.setFocusable(true);
        bot.setFocusable(false);
        bot2.setFocusable(false);
        btnStart.setFocusable(false);

        //Bounds
        man.setBounds(30,500,36,60);
        bot.setBounds(30,600,36,60);
        bot2.setBounds(30,400,36,60);
        roca.setBounds(200,530,30,30);
        rocabot.setBounds(200,630,30,30);
        rocabot2.setBounds(200,430,30,30);
        btnStart.setBounds(1100,30,70,25);
        gan.setBounds(190,260,900,130);
        background.setBounds(0,-157,3840,1080);
        controles.setBounds(80,130,1040,30);
        //Listeners
        ActionListener listener=new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (ae.getSource()==btnStart) {                    
                    Thread t=new Thread(man);
                    t.start();
                    Thread t2=new Thread(bot);
                    t2.start();
                    Thread t3=new Thread(bot2);
                    t3.start();
                }
            }
        };
        btnStart.addActionListener(listener);
        man.addKeyListener(man);
        //Adds
        add(gan);
        //gan.mostrar("Gano corredor 3");
        gan.setVisible(false);
        add(controles);
        add(man);
        add(bot);
        add(bot2);
        add(roca);
        add(rocabot);
        add(rocabot2);
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
