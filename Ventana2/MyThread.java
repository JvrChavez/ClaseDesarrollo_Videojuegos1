package Ventana2;
import javax.swing.*;

public class MyThread extends Thread {
    JLabel texto1;
    JButton btn;
    int x1=90, y1=1;
    int x2=180, y2=240;
    boolean ded=true;
    public void run(){
        btn.setEnabled(false);
        while(true){
            try {
                Thread.sleep(5);                
                texto1.setText("Fuimonos");                
                if (x1<180 || x2>180) {                    
                    x1++;                    
                    if (y1<240 || y2>240) {
                        y1++;
                        texto1.setBounds(x1,y1,120,25);
                    } else {
                        y2--;
                        texto1.setBounds(x1,y2,120,25);
                        if(y2==0){
                            y2=240;
                            y1=1;
                        }
                    }                    
                } else{                    
                    x2--;                    
                    if(x2==0){
                        x2=180;                        
                        x1=1;                        
                    }
                    if (y1<240 || y2>240) {
                        y1++;
                        texto1.setBounds(x2,y1,120,25);
                    } else {
                        y2--;
                        texto1.setBounds(x2,y2,120,25);
                        if(y2==0){
                            y2=240;
                            y1=1;
                        }
                    }                    
                }//end if
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }//end run
}