package Ventana3;

import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
public class Kemonito extends JLabel implements Runnable ,KeyListener{
        private String url1,url2;
        private ImageIcon icon;
        private boolean moveStatus=false,pausar,stop,runStatus=false,bandera=true;
    public Kemonito(String url1,String url2){
        this.url1=url1;
        this.url2=url2;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        runStatus=true;
        stop=false;
        for (int x = 10; x < 300; x+=3) {
            if(moveStatus){
                icon=new ImageIcon(this.getClass().getResource(url1));
                moveStatus=false;
            }else{
                icon=new ImageIcon(this.getClass().getResource(url2));
                moveStatus=true;             
            }
            setIcon(icon);
            setBounds(x,getY(),32,39);
            try{Thread.sleep(100);}catch(Exception e){}
            try {
                synchronized(this){
                    while(pausar){
                        wait();
                    }
                    if(stop){
                        stop=false;
                        break;
                    }
                }//end synchronized
            } catch (Exception e) {}
        }//end for
    }//end run
    synchronized void pausarHilo(){pausar=true;}
    synchronized void reanudarHilo(){pausar=false; notify();}
    synchronized void stopHilo(){stop=true; pausar=false; notify();}
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){
        if(runStatus){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                if (bandera) {
                    pausarHilo();
                    bandera=false;
                } else {
                    reanudarHilo();
                    bandera=true;
                }
            }
            if(ke.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                stopHilo();
                bandera=true;
            }
        }//end runStatus
    }//en key Pressed
    public void keyReleased(KeyEvent ke){}

}
