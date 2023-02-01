package Ventana1;
import javax.swing.*;
public class Etiqueta extends JLabel implements Runnable{
    JButton btn1;
    int time;
    String name;
    public Etiqueta(String txt1){
        setText(txt1);
    }
    public void run(){        
        for (int i = 1; i <=10; i++) {
            btn1.setEnabled(false);
            try {
                Thread.sleep(time);
                setText(name+Integer.toString(i));
            } catch (Exception e) {
                // TODO: handle exception
            }    
        }
        if(name=="Hilo 1 : "){//Activa el boton solo hasta que acabe el primer hilo
            btn1.setEnabled(true);
        }        
    }
    public void setTime(Integer time){
        this.time=time;
    }
    public void setButton(JButton btn1){
        this.btn1=btn1;
    }
    public void setName(String name){
        this.name=name;
    }
}