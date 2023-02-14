package Ventana3;
import javax.swing.*;
import java.awt.event.*;

public class Imagen2 extends JLabel implements Runnable,KeyListener{
    private String url1,url2;
    private ImageIcon icon;
    private int posX=10;
    private boolean runStatus=false,correr=false,mover=false;
    public Imagen2(String url1,String url2){
        this.url1=url1;
        this.url2=url2;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        runStatus=true;
        posX=10;
        setBounds(posX,90,42,42);
    }//end run
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){
        if (runStatus) {
            //Valores velocidad
            if (ke.getKeyCode()==KeyEvent.VK_RIGHT) {        
                if (correr) {
                    posX+=3; 
                }else{
                    posX++;
                }                                                    
            }
            if ((ke.getKeyCode()==KeyEvent.VK_SPACE)) {
                correr=true; 
            }
            //Animacion movimiento
            if ((posX%2)!=0) {
                icon=new ImageIcon(this.getClass().getResource(url2));
            }else{
                icon=new ImageIcon(this.getClass().getResource(url1));
            }
            setBounds(posX,90,42,42);
            setIcon(icon);
        }        
    }
    public void keyReleased(KeyEvent ke){
        if ((ke.getKeyCode()==KeyEvent.VK_SPACE)) {
            correr=false;
        }
    }
}
