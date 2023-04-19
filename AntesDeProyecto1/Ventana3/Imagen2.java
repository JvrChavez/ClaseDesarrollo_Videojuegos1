package Ventana3;
import javax.swing.*;
import java.awt.event.*;

public class Imagen2 extends JLabel implements Runnable,KeyListener{
    private String url1,url2,urli1,urli2;
    private ImageIcon icon;
    private int posX=10,posY=174,aire=0;
    boolean runStatus=false,correr,right=false,left=false,brincar=false;
    public Imagen2(String url1,String url2,String urli1,String urli2){
        this.url1=url1;
        this.url2=url2;
        this.urli1=urli1;
        this.urli2=urli2;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        posX=10;
        runStatus=true;
        while(true){//Mover         
            try {
                Thread.sleep(50);                
                if(brincar && aire<10){//Condicional brincar                   
                    aire++;          
                    posY=154;                    
                }else {                    
                    posY=174;                    
                }                  
                if (posX<151){
                    if (correr && right) {//Condicional right y correr
                        posX+=9;                        
                        animacionDerecha();
                    }else if(right){
                        posX+=5;
                        animacionDerecha();                        
                    }                    
                }else{//Experimental
                    posX++;
                    posX++;
                    posX++;
                    animacionDerecha();
                    Thread.sleep(50);
                    System.out.println(posX);
                    posX--;
                    posX--;
                    posX--;

                }
                if (posX>0){
                    if (correr && left) {//Condicional right y correr
                        posX-=9;
                        animacionIzquierda();                        
                    }else if(left){
                        posX-=5;
                        animacionIzquierda();                        
                    }                    
                }                                                                   
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
                right=true;                                                                                      
            }
            if (ke.getKeyCode()==KeyEvent.VK_LEFT) {  
                left=true;                                                                                      
            }
            if ((ke.getKeyCode()==KeyEvent.VK_SHIFT)) {
                correr=true;            
            }
            if ((ke.getKeyCode()==KeyEvent.VK_UP)) {
                brincar=true;                                
            }        
        }        
    }
    public void keyReleased(KeyEvent ke){
        if (runStatus) {
            if ((ke.getKeyCode()==KeyEvent.VK_RIGHT)) {
                right=false;
            }
            if (ke.getKeyCode()==KeyEvent.VK_LEFT) {  
                left=false;                                                                                      
            }
            if ((ke.getKeyCode()==KeyEvent.VK_SHIFT)) {            
                correr=false;
            }
            if ((ke.getKeyCode()==KeyEvent.VK_UP)) {
                brincar=false;
                aire=0;            
            }
        }                
    }
    public void animacionDerecha(){        
        if ((posX%2)!=0) {
            icon=new ImageIcon(this.getClass().getResource(url2));
        }else{
            icon=new ImageIcon(this.getClass().getResource(url1));
        }
        setBounds(posX,posY,42,42);
        setIcon(icon);
    }
    public void animacionIzquierda(){        
        if ((posX%2)!=0) {
            icon=new ImageIcon(this.getClass().getResource(urli2));
        }else{
            icon=new ImageIcon(this.getClass().getResource(urli1));
        }
        setBounds(posX,posY,42,42);
        setIcon(icon);
    }
}