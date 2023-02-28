package Ventana3;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Time;
import java.awt.geom.*;
public class Imagen3 extends JLabel implements Runnable,KeyListener{
    private String url1,url2,url3;
    private int posX=10,posXBack=0,y=174,xblocks=70;
    private ImageIcon icon;
    private boolean changeImg=false,runStatus=false,right=false,shift=false,up=false;
    JLabel background,wall1;
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
            if(right&&shift){moveImage(8, 70);}
            else if(right){moveImage(4,90);}
            if(shift&right&up){saltote(8, 70);}
            if(right&&up){saltote(4,90);}
            if(up){saltito(20);}
            if(interseccion()){break;}
        }//end while
    }//end run
    private boolean interseccion(){
        Area areaWall1=new Area(wall1.getBounds());
        Area areaMario=new Area(getBounds());
        return areaWall1.intersects(areaMario.getBounds2D());
    }
    private void saltito(int time){
        for (y=174; y >=150; y--) {
            moveImage(1, time);
            setBounds(posX,y,32,39);
            try {Thread.sleep(time);} catch (Exception e) {}
        }//end for UP
        for (y=getY(); y <=173; y++) {
            moveImage(0, time);
            setBounds(posX,y,32,39);
            try {Thread.sleep(time);} catch (Exception e) {}
        }//end for DOWN
        changeImage(time);
    }
    private void saltote(int power,int time){
        for (y=174; y>=150; y-=power) {
            //posX+=power;
            moveImage(power, time);
            setBounds(posX,y,32,39);
            try {Thread.sleep(time);} catch (Exception e) {}
        }//end UP
        for (y=getY(); y<=173; y+=power) {
            //posX+=power;
            moveImage(power, time);
            setBounds(posX,y,32,39);
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
            if (xblocks<-16){xblocks+=300;}else{xblocks-=power;}//Hace reaparecer el bloque en cuanto sale de pantalla
            posXBack-=power;
            background.setBounds(posXBack,-817,3840,1080);
            wall1.setBounds(xblocks,200,16,16);
            setBounds(posX,y,32,39);
        }else if(posX<=263&&right){            
            posX+=power;            
            setBounds(posX,y,32,39);           
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
