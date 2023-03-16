package Ventana3;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;
public class Kemonito extends JLabel implements Runnable ,KeyListener{
        private String url1,url2,ruta="Ventana3/sonido/dragonball.wav";
        private ImageIcon icon;
        private boolean moveStatus=false,pausar,stop,runStatus=false,bandera=true;
        private AudioInputStream audioStream;
        JButton btnStart;
        private int x=10,x1=10,x2=270;
    private Clip clip;
    private Long microSegundos;
    public Kemonito(String url1,String url2){
        this.url1=url1;
        this.url2=url2;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        runStatus=true;
        stop=false;
        btnStart.setEnabled(false);
        x1=10;x2=270;
        try {
            audioStream=AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
            clip=AudioSystem.getClip();
            clip.open(audioStream);            
            clip.loop(Clip.LOOP_CONTINUOUSLY);  
        } catch (Exception e) {}
        //for (int x = 10; x < 300; x+=3) {
        while(true){
            if(x1<270){x1+=3; x=x1;
            }else if (x2>10){x2-=3; x=x2;}
            else{x1=10;x2=270;}
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
                        btnStart.setEnabled(true);
                        break;
                    }
                }//end synchronized
            } catch (Exception e) {}
        }            
        //}//end for
    }//end run
    synchronized void pausarHilo(){        
        microSegundos=clip.getMicrosecondPosition();
        clip.stop();
        pausar=true;
    }
    synchronized void reanudarHilo(){
        pausar=false;
        notify();
        clip.close();
        
        try {
            audioStream=AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());           
            clip.open(audioStream);            
            clip.loop(0);    
            clip.setMicrosecondPosition(microSegundos);            
        } catch (Exception e) {}
    }
    synchronized void stopHilo(){
        stop=true;
        pausar=false;
        notify();
        microSegundos=0L;
        clip.stop();
        clip.close();
    }
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
