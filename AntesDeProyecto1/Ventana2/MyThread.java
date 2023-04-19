package Ventana2;
import javax.swing.*;

public class MyThread extends Thread {
    JLabel texto1;
    JButton btn;
    int x1=1, y1=1;
    int x2=414, y2=502;
    boolean ded=true;
    public void run(){
        btn.setEnabled(false);
        while(true){
            try {
                Thread.sleep(3);                             
                if (x1<414 || x2>414) {                    
                    x1++;      
                    if (y1<502 || y2>502) {
                        y1++;
                        texto1.setBounds(x1,y1,276,168);
                    } else {
                        y2--;
                        texto1.setBounds(x1,y2,276,168);
                        if(y2==0){
                            y2=502;
                            y1=1;
                        }
                    }                    
                } else{                    
                    x2--;
                    if(x2<=0){
                        x2=414;                        
                        x1=1;                        
                    }
                    if (y1<502 || y2>502) {
                        y1++;
                        texto1.setBounds(x2,y1,276,168);
                    } else {
                        y2--;
                        texto1.setBounds(x2,y2,276,168);
                        if(y2==0){
                            y2=502;
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