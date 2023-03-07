package Ventana3;

import javax.swing.JLabel;
import javax.swing.*;
public class Kemonito extends JLabel implements Runnable {
        private String url1,url2;
        private ImageIcon icon;
        private boolean moveStatus=false,pausar,stop=false;
    public Kemonito(String url1,String url2){
        this.url1=url1;
        this.url2=url2;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        for (int x = 10; x < 150; x+=3) {
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
    synchronized void stopHilo(){stop=true; notify();}
}
