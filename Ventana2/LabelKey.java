package Ventana2;
import javax.swing.*;
import java.awt.event.*;

public class LabelKey extends JLabel implements Runnable{
    int posX=112;
    public LabelKey(String texto){
        setText(texto);
    }
    public void run(){
        this.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent ke){}
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode()== KeyEvent.VK_RIGHT && posX<=670){
                    posX+=10;
                    setBounds(posX,200,50,25);                        
                }
                if(ke.getKeyCode()== KeyEvent.VK_LEFT && posX>=10){
                    posX-=10;
                    setBounds(posX,200,50,25);        
                }               
            }//end keyPressed
            public void keyReleased(KeyEvent ke){}
        });
    }//end run
}