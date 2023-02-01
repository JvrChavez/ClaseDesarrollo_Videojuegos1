package Ventana1;//En visual studio code necesita llevar package, en consola puede omitirse
//Author Javier Chavez 218212241
import javax.swing.JLabel;
public class Hilo implements Runnable {
    private int time,cont;
    private JLabel texto1;
    public void run() {
        for (int i = 0; i <= 10; i++) {
            cont = i;            
            try {
                texto1.setText("Incremento: " + cont);
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                // TODO: handle exception
            }
        }
    }
    public void setTime(Integer time){
        this.time=time;
    }
    public void setLabel(JLabel texto1){
        this.texto1=texto1;
    }
}//end Hilo