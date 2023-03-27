package Ventana3;

import javax.swing.*;
import java.awt.*;

public class Circulo1 extends JPanel{
    private int x=0;
    public void moverCirculo(){
        x++;
    }
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.blue);
        g2d.fillOval(x,0,30,30);
    }//end paint
}
