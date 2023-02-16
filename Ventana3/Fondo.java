package Ventana3;

import javax.swing.*;
import java.awt.event.*;

public class Fondo extends JLabel implements Runnable,KeyListener{
    private ImageIcon icon;
    private JLabel avatar;
    private int x,xa;
    private boolean correr=false;
    public Fondo(String url,JLabel avatar){
        this.avatar=avatar;
        icon=new ImageIcon(this.getClass().getResource(url));
        setIcon(icon);
    }
    public void run() {
        try {
            while(true){
                Thread.sleep(50);
                if (correr) {
                    desplazarFondo(5);
                }else{
                    desplazarFondo(1);
                }
                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }        
    }
    //Valores movimiento
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){          
        if ((ke.getKeyCode()==KeyEvent.VK_SPACE)) {
            System.out.println("corri");
            correr=true;                
        }             
    }
    public void keyReleased(KeyEvent ke){
        if ((ke.getKeyCode()==KeyEvent.VK_SPACE)) {            
            correr=false;
        }
    }
    public void desplazarFondo(int move){        
        xa=avatar.getX();
            if (xa>150) {
                x-=move;
                setBounds(x,-817,3840,1080);
            }
    }   
}
