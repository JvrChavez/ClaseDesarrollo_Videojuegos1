package Ventana3;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Imagen4 extends JLabel implements Runnable,KeyListener{
    private String url1, url2,url3;
    private ImageIcon icon;
    JLabel base;
    private int y=177,posX=10;
    private boolean runStatus=false, right=false,shift=false,up=false,changeImg=false;
    public Imagen4(String url1,String url2,String url3){
        this.url1=url1;
        this.url2=url2;
        this.url3=url3;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run() {
        runStatus=true;
        while (true) {            
            if(interseccion()){
                gravedad(0, 50);
                if(right&&shift){moveImagen(8, 70);}
                else if(right){moveImagen(4,90);}
                if(shift&right&up){saltote(8, 70);}
                else if(right&&up){saltote(4,90);}
                else if(up){saltito(20);}
            }else{
                gravedad(5,10);
            }
        }//end while
    }//end run
    private void saltote(int power,int time){
        for (y=174; y>=150; y-=power) {
            //posX+=power;
            moveImagen(power, time);
            setBounds(posX,y,32,39);
            try {Thread.sleep(time);} catch (Exception e) {}
        }//end UP
        for (y=getY(); y<=173; y+=power) {
            //posX+=power;
            moveImagen(power, time);
            setBounds(posX,y,32,39);
            try {Thread.sleep(time);} catch (Exception e) {}
        }
        //changeImage(time);
    }//end saltote
    private void saltito(int time){
        for (y=174; y >=150; y--) {
            moveImagen(1, time);
            setBounds(posX,y,32,39);
            try {Thread.sleep(time);} catch (Exception e) {}
        }//end for UP
        for (y=getY(); y <=173; y++) {
            moveImagen(0, time);
            setBounds(posX,y,32,39);
            try {Thread.sleep(time);} catch (Exception e) {}
        }//end for DOWN
        changeImage(time);
    }
    private void changeImage(int time){
        if(changeImg){
            icon=new ImageIcon(this.getClass().getResource(url1));
            changeImg=false;
        }else{
            icon=new ImageIcon(this.getClass().getResource(url2));
            changeImg=true;
        }        
        setIcon(icon);
        try {Thread.sleep(time);} catch (Exception e) {}
    }//end moveImage
    private void moveImagen(int power,int time){
        if(right){
            posX+=power;        
            setBounds(posX,getY(),32,39);
        }      
        if(up || (y<=173)){
            icon=new ImageIcon(this.getClass().getResource(url3));
            setIcon(icon);
        }else{
            changeImage(time);} 
    }//end moveImagen
    private void gravedad(int presion, int time){
        y+=presion;
        setBounds(getX(),y,32,39);
        try {Thread.sleep(time);} catch (Exception e) {}
    }//end gravedad
    public boolean interseccion(){
        Area aBase=new Area(base.getBounds());
        Area aMario=new Area(getBounds());
        return aBase.intersects(aMario.getBounds2D());
    }
    public void keyTyped(KeyEvent ke) {} 
    public void keyReleased(KeyEvent ke){
        if (runStatus) {
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT){right=false;}
            if(ke.getKeyCode()==KeyEvent.VK_SHIFT){shift=false;}
            if(ke.getKeyCode()==KeyEvent.VK_UP){up=false;}
        }//end runStatus
    }//end KeyReleased
    public void keyPressed(KeyEvent ke){
        if (runStatus) {
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT){right=true;}
            if(ke.getKeyCode()==KeyEvent.VK_SHIFT){shift=true;}
            if(ke.getKeyCode()==KeyEvent.VK_UP){up=true;}
        }//end runStatus
    }//end KeyPressed
        
}
