package Ventana2;
import javax.swing.*;

public class MyThread extends Thread {
    JLabel texto1;
    JButton btn;
    int n=1,i=180;
    public void run(){
        btn.setEnabled(false);
        while(true){
            try {
                Thread.sleep(20);
                
                texto1.setText("Fuimonos");                
                if (n>180) {
                    texto1.setBounds(i,10,120,25);
                    i--;
                } else{
                    texto1.setBounds(n,10,120,25);
                    n++;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }//end run
}
