package Caballos;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
public class Human1 extends JLabel implements Runnable ,KeyListener{
    private ImageIcon icon;
    private String url1,url2,url3,url4;
    private boolean runStatus,moveStatus=false,upSatus=false,right=false,left=false,up=false,correr=false,falling=false;
    private int x,y;
    JLabel roca;
    public Human1(String url1,String url2,String url3,String url4){
        this.url1=url1;
        this.url2=url2;
        this.url3=url3;
        this.url4=url4;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        runStatus=true;
        while(true){
            if (right&&correr) {moveImage(5,50);}
            else if(right){moveImage(3,70);}
            if(right&&correr&&up){salto(5,3,50);}
            else if(right&&up){salto(3, 3, 50);}
            else if(up){salto(1, 3, 20);}
            while(interseccion()){caer(2,70);}     
            System.out.println(".");
        }        
    }//end run
    public void caer(int power,int time){
        falling=true;
        moveImage(power, time);
        //setBounds(getX(),getY(),getWidth(),getHeight());
        falling =false;
    }//end caer
    private boolean interseccion(){
        Area areaRoca=new Area(roca.getBounds());
        Area areaHuman=new Area(getBounds());
        return areaRoca.intersects(areaHuman.getBounds2D());
    }
    private void salto(int power,int jump,int time){
        int posY=getY();
        upSatus=true;
        for (y=getY(); y>=posY-50; y-=power) {
            moveImage(power, time);
            setBounds(getX(),y,getWidth(),getHeight());
        }//end UP
        for (y=getY(); y<=posY; y+=power) {
            moveImage(power, time);
            setBounds(getX(),y,getWidth(),getHeight());
        }//end DOWN
        upSatus=false;
    }//end salto
    public void moveImage(int power,int time){    
        x=getX()+power;
        changeImage(); 
        if(falling){
            setBounds(x,getY(),60,36);
        }else{
            setBounds(x,getY(),36,60);
        }        
        try{Thread.sleep(time);}catch(InterruptedException e){e.printStackTrace();}
                   
    }
    public void changeImage(){
        if (falling) {
            icon=new ImageIcon(this.getClass().getResource(url4));
        } else if(upSatus) {
            icon=new ImageIcon(this.getClass().getResource(url3));
        }else {
            if (moveStatus) {              
                icon=new ImageIcon(this.getClass().getResource(url1));
                moveStatus=false;
            } else {                    
                icon=new ImageIcon(this.getClass().getResource(url2));
                moveStatus=true;
            }
        }             
        setIcon(icon);
    }
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){
        if (runStatus) {
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT){right=true;}
            if(ke.getKeyCode()==KeyEvent.VK_SHIFT){correr=true;}
            if(ke.getKeyCode()==KeyEvent.VK_UP){up=true;}
        }
    }
    public void keyReleased(KeyEvent ke){
        if (runStatus) {
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT){right=false;}
            if(ke.getKeyCode()==KeyEvent.VK_SHIFT){correr=false;}
            if(ke.getKeyCode()==KeyEvent.VK_UP){up=false;}
        }
    }
}
