package Ventana3;
import javax.swing.*;
import java.awt.event.*;

public class Imagen2 extends JLabel implements Runnable,KeyListener{
    private String url1,url2;
    private ImageIcon icon;
    private int posX=10,posY=90;
    private boolean runStatus=false,correr=false,mover=false,brincar=false;
    public Imagen2(String url1,String url2){
        this.url1=url1;
        this.url2=url2;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        posX=10;
        runStatus=true;
        while(true){            
            try {
                Thread.sleep(50);
                //Condicional brincar
                if(brincar){                    
                    posY=75;                    
                }else{
                    posY=90;
                }
                //Condicional mover y correr
                if (correr && mover) {
                    posX+=3; 
                }else if(mover){
                    posX++;
                }
                animacionMovimiento();                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }            
        }//end while             
    }//end run
    //Valores movimiento
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){
        if (runStatus) {            
            if (ke.getKeyCode()==KeyEvent.VK_RIGHT) {  
                mover=true;                                                                                      
            }
            if ((ke.getKeyCode()==KeyEvent.VK_SPACE)) {
                correr=true;                
            }
            if ((ke.getKeyCode()==KeyEvent.VK_UP)) {
                brincar=true;                
            }        
        }        
    }
    public void keyReleased(KeyEvent ke){
        if ((ke.getKeyCode()==KeyEvent.VK_SPACE)) {            
            correr=false;
        }
        if ((ke.getKeyCode()==KeyEvent.VK_RIGHT)) {
            mover=false;
        }
        if ((ke.getKeyCode()==KeyEvent.VK_UP)) {
            brincar=false;
        }
    }
    public void animacionMovimiento(){        
        if ((posX%2)!=0) {
            icon=new ImageIcon(this.getClass().getResource(url2));
        }else{
            icon=new ImageIcon(this.getClass().getResource(url1));
        }
        setBounds(posX,posY,42,42);
        setIcon(icon);
    }
}