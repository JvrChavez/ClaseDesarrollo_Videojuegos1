package Caballos;
import javax.swing.*;
import java.awt.geom.*;
public class Bots extends JLabel implements Runnable{
    private ImageIcon icon;
    private String url1,url2,url3,url4,name;
    private boolean moveStatus=false,upSatus=false,right=true,left=false,up=false,correr=false,falling=false;
    JLabel roca,fondo,rocaother,rocaother2;
    Human1  player;
    Bots botcito;
    Ganador gan;
    public Bots(String url1,String url2,String url3,String url4,String name){
        this.url1=url1;
        this.url2=url2;
        this.url3=url3;
        this.url4=url4;
        this.name=name;
        icon=new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }
    public void run(){
        while(true){
            if ((Math.random() > 0.3)) {correr=true;}//Condicion aleatoria de correr
            if (right&&correr){moveImage(6,50);}
            else if(right){moveImage(4,70);}
            else if(left){moveImage(-3,70);}
            if(roca.getX()-getX()<55 &&roca.getX()-getX()>45){up=((Math.random() > 0.7));}//Condicion aleatoria de se saltar
            if(right&&correr&&up){salto(6,3,50);}
            else if(right&&up){salto(4, 3, 50);}
            else if(up){salto(1, 3, 20);}
            while(interseccion()){caer(3,70);}
            //Se recomponen por default las cosas aleatorias
            up=false;
            correr=false;
            if(getX()>1215){//Condicional de si gano
                if (!player.stop) {
                    gan.mostrar("Gano "+name);
                }                
                break;
            }else if(player.getX()>1215){
                break;
            }else if(botcito.getX()>1215){
                break;
            }    
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
        roca.setBounds(roca.getX()-power,roca.getY(),roca.getWidth(),roca.getHeight());
        if(roca.getX()<-30){roca.setBounds(roca.getX()+1280,roca.getY(),roca.getWidth(),roca.getHeight());}//Reaparece la roca
        if(getX()>640&&fondo.getX()>-1792&& !left){            
            fondo.setBounds(fondo.getX()-power,fondo.getY(),fondo.getWidth(),fondo.getHeight());
            roca.setBounds(roca.getX()-power,roca.getY(),roca.getWidth(),roca.getHeight());
            player.setBounds(player.getX()-power,player.getY(),player.getWidth(),player.getHeight());
            rocaother.setBounds(rocaother.getX()-power,rocaother.getY(),rocaother.getWidth(),rocaother.getHeight());
            botcito.setBounds(botcito.getX()-power,botcito.getY(),botcito.getWidth(),botcito.getHeight());
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
        try {
            synchronized(this){
                while(player.pausar){
                    wait();
                }
                if(player.stop){
                    setBounds(1216,getY(),getWidth(),getHeight());
                }
            }//end synchronized
        } catch (Exception e) {}                    
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
}