package Caballos;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
public class Human1 extends JLabel implements Runnable ,KeyListener{
    private ImageIcon icon;
    private String url1,url2,url3,url4;
    private boolean runStatus,moveStatus=false,upSatus=false,right=false,left=false,up=false,correr=false,falling=false;
    JLabel roca,fondo,rocaother,rocaother2;
    Bots botcito,botcito2;
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
            else if(left){moveImage(-3,70);}
            if(right&&correr&&up){salto(5,3,50);}
            else if(right&&up){salto(3, 3, 50);}
            else if(up){salto(1, 3, 20);}
            while(interseccion()){caer(2,70);}
               
        }        
    }//end run
    public void caer(int power,int time){
        falling=true;
        moveImage(power, time);
        falling =false;
    }//end caer
    private boolean interseccion(){
        Area areaRoca=new Area(roca.getBounds());
        Area areaHuman=new Area(getBounds());
        return areaRoca.intersects(areaHuman.getBounds2D());
    }//end interseccion
    private void salto(int power,int jump,int time){
        int posY=getY();
        upSatus=true;
        for (int y=getY(); y>=posY-50; y-=power) {
            left=false;//mantiene falso el LEFT para evitar desincronizacion con el fondo
            moveImage(power, time);
            setBounds(getX(),y,getWidth(),getHeight());
        }//end UP
        for (int y=getY(); y<=posY; y+=power) {
            left=false;
            moveImage(power, time);
            setBounds(getX(),y,getWidth(),getHeight());
        }//end DOWN
        upSatus=false;
    }//end salto
    public void moveImage(int power,int time){
        changeImage();
        if(roca.getX()<10){roca.setBounds(roca.getX()+1000,roca.getY(),roca.getWidth(),roca.getHeight());}//Reaparece la roca
        if(getX()>640&&fondo.getX()>-1792&& !left){            
            fondo.setBounds(fondo.getX()-power,fondo.getY(),fondo.getWidth(),fondo.getHeight());
            roca.setBounds(roca.getX()-power,roca.getY(),roca.getWidth(),roca.getHeight());
            botcito.setBounds(botcito.getX()-power,botcito.getY(),botcito.getWidth(),botcito.getHeight());
            rocaother.setBounds(rocaother.getX()-power,rocaother.getY(),rocaother.getWidth(),rocaother.getHeight());
            botcito2.setBounds(botcito2.getX()-power,botcito2.getY(),botcito2.getWidth(),botcito2.getHeight());
            rocaother2.setBounds(rocaother2.getX()-power,rocaother2.getY(),rocaother2.getWidth(),rocaother2.getHeight());
            if(falling){
                setBounds(getX(),getY(),60,36);
            }else{setBounds(getX(),getY(),36,60);}            
        }else{              
            if(falling){
                setBounds(getX()+power,getY(),60,36);
            }else{
                setBounds(getX()+power,getY(),36,60);
            }
        }     
        try{Thread.sleep(time);}catch(InterruptedException e){e.printStackTrace();}                   
    }//end moveImage
    public void changeImage(){
        if (falling) {
            icon=new ImageIcon(this.getClass().getResource(url4));
        } else if(upSatus) {
            icon=new ImageIcon(this.getClass().getResource(url3));
        }else if (moveStatus) {              
            icon=new ImageIcon(this.getClass().getResource(url1));
            moveStatus=false;
        } else {                    
            icon=new ImageIcon(this.getClass().getResource(url2));
            moveStatus=true;
        }          
        setIcon(icon);
    }//end changeImage
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){
        if (runStatus) {
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT){right=true;}
            if(ke.getKeyCode()==KeyEvent.VK_LEFT){left=true;}
            if(ke.getKeyCode()==KeyEvent.VK_SHIFT){correr=true;}
            if(ke.getKeyCode()==KeyEvent.VK_UP){up=true;}
        }
    }//end keyPressed
    public void keyReleased(KeyEvent ke){
        if (runStatus) {
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT){right=false;}
            if(ke.getKeyCode()==KeyEvent.VK_LEFT){left=false;}
            if(ke.getKeyCode()==KeyEvent.VK_SHIFT){correr=false;}
            if(ke.getKeyCode()==KeyEvent.VK_UP){up=false;}
        }
    }//end keyReleased
}