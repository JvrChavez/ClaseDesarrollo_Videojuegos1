package Ventana3;
import javax.swing.*;
import java.awt.event.*;

public class Imagen2 extends JLabel implements Runnable,KeyListener{
    private String url1,url2;
    private ImageIcon icon;
    private int posX=10;
    private boolean runStatus=false;
    public Imagen2(String url1,String url2){
        this.url1=url1;
        this.url2=url2;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        runStatus=true;
    }//end run
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){
        if (runStatus) {
            if (ke.getKeyCode()==KeyEvent.VK_RIGHT) {
                posX++;
                if ((posX%2)!=0) {
                    icon=new ImageIcon(this.getClass().getResource(url2));
                }else{
                    icon=new ImageIcon(this.getClass().getResource(url1));
                }
                if(ke.getKeyCode()==KeyEvent.VK_SHIFT){
                    posX+=10;
                    System.out.println("Entro");
                }                
                setBounds(posX,90,42,42);
                setIcon(icon);
            }
        }        
    }
    public void keyReleased(KeyEvent ke){}
}
