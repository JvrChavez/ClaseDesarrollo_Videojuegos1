package Ventana3;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Time;
public class Imagen3 extends JLabel implements Runnable,KeyListener{
    private String url1,url2,url3;
    private int posX=10,posXBack=0,y=174;
    private ImageIcon icon;
    private boolean changeImg=false,runStatus=false,right=false,shift=false,up=false;
    JLabel background;
    public Imagen3(String url1,String url2,String url3){
        this.url1=url1;
        this.url2=url2;
        this.url3=url3;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        runStatus=true;
        while(true){
            System.out.println("while");            
            if(right&&shift){moveImage(10, 40);}
            else if(right){moveImage(3,100);}
            if(shift&right&up){saltote(10, 100);}
            if(right&&up){saltote(3,20);}
            if(up){saltito(20);}
        }//end while
    }//end run
    private void saltito(int time){
        for (y=174; y >=150; y--) {
            moveImage(1, time);
            setBounds(posX,y,42,42);
            try {Thread.sleep(time);} catch (Exception e) {}
        }//end for UP
        for (y=getY(); y <=173; y++) {
            moveImage(0, time);
            setBounds(posX,y,42,42);
            try {Thread.sleep(time);} catch (Exception e) {}
        }//end for DOWN
        changeImage(time);
    }
    private void saltote(int power,int time){
        for (y=174; y>=150; y-=power) {
            //posX+=power;
            moveImage(power, time);
            setBounds(posX,y,42,42);
            try {Thread.sleep(time);} catch (Exception e) {}
        }//end UP
        for (y=getY(); y<=173; y+=power) {
            //posX+=power;
            moveImage(power, time);
            setBounds(posX,y,42,42);
            try {Thread.sleep(time);} catch (Exception e) {}
        }
        //changeImage(time);
    }//end saltote
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
    private void moveImage(int power, int time){
        if(posX>=120 && posXBack>=-3540&&right){
            posXBack-=power;
            background.setBounds(posXBack,-817,3840,1080);
            setBounds(posX,y,42,42);
        }else if(posX<=263&&right){            
            posX+=power;            
            setBounds(posX,y,42,42);            
        }
        if(up || (y<=173)){
            System.out.println("si entro");
            icon=new ImageIcon(this.getClass().getResource(url3));
            setIcon(icon);
        }else{
            System.out.println("algo");
            changeImage(time);}
        
    }
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){
        if(runStatus){
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT){right=true;}
            if(ke.getKeyCode()==KeyEvent.VK_SHIFT){shift=true;}
            if(ke.getKeyCode()==KeyEvent.VK_UP){up=true;}
        }
    }//end keyPressed
    public void keyReleased(KeyEvent ke){
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT){right=false;}
        if(ke.getKeyCode()==KeyEvent.VK_SHIFT){shift=false;}
        if(ke.getKeyCode()==KeyEvent.VK_UP){up=false;}
    }
}
