package Ventana3;
import javax.swing.*;

public class Imagen extends JLabel implements Runnable{
    ImageIcon icon;
    String url,url2;
    int time, y;
    JButton btnStart;
    //Constructor
    public Imagen(String url, String url2, Integer time,Integer y){
        this.url=url;
        this.url2=url2;
        this.time=time;
        this.y=y;
        icon=new ImageIcon(this.getClass().getResource(url));
        setIcon(icon);
    }
    public void run(){
        for (int x = 10; x <=250; x++) {
            if ((x%2)!=0) {
                icon=new ImageIcon(this.getClass().getResource(url2));
            } else {
                icon=new ImageIcon(this.getClass().getResource(url));
            }
            setIcon(icon);
            setBounds(x,y,42,42);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }//end for
        //Habilitamos el boton cuando el hilo mal lento termine
        if (y==40) {
            btnStart.setEnabled(true);
        }
    }//end run
}
