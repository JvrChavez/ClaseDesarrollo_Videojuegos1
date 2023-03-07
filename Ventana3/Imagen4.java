package Ventana3;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Imagen4 extends JLabel implements Runnable,KeyListener{
    private String url1, url2;
    private ImageIcon icon;
    JLabel base;
    private int y=177,posX=10;
    private boolean runStatus=false, right=false,up=false,changeImg=false;
    public Imagen4(String url1,String url2){
        this.url1=url1;
        this.url2=url2;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run() {
        runStatus=true;
        while (true) {            
            if(interseccion()){
                gravedad(0, 50);
                if(right){moveImagen(1, 75);}
                if(up){}
            }else{
                gravedad(5,10);
            }
        }//end while
    }//end run
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
        posX+=power;
        setIcon(icon);
        setBounds(posX,getY(),32,39);
        changeImage(time);
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
            if(ke.getKeyCode()==KeyEvent.VK_UP){up=false;}
        }//end runStatus
    }//end KeyReleased
    public void keyPressed(KeyEvent ke){
        if (runStatus) {
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT){right=true;}
            if(ke.getKeyCode()==KeyEvent.VK_UP){up=true;}
        }//end runStatus
    }//end KeyPressed
        
}
