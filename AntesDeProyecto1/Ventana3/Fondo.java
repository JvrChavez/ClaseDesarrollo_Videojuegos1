package Ventana3;

import javax.swing.*;

public class Fondo extends JLabel implements Runnable{
    private ImageIcon icon;
    private JLabel avatar;
    private int x,xa;
    boolean correr;
    //private boolean correr=false;
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
                    System.out.println("9");
                    desplazarFondo(9);
                }else{
                    System.out.println("5");
                    desplazarFondo(5);
                }
                
            }
        } catch (Exception e) {
            // TODO: handle exception
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
