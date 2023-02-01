package Ventana2;
import javax.swing.*;

public class MyThread extends Thread {
    JLabel texto1;
    JButton btn;
    int n=1,i=180;
    boolean ded=true;
    public void run(){
        btn.setEnabled(false);
        while(true){
            try {
                Thread.sleep(20);
                
                texto1.setText("Fuimonos");                
                if (n>180 || n<0 || ded) {
                    texto1.setBounds(i,10,120,25);
                    i--;
                } else{
                    ded=false;
                    texto1.setBounds(n,10,120,25);
                    n--;
                    if(n==0){
                        ded=true;
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }//end run
}
