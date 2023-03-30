package Ventana3;

import javax.swing.*;
import java.awt.*;

public class Circulo1 extends JPanel{
    private int x=35,y=0;
    private int h=50,w=70;
    public void moverReloj(){
        x++;
        y++;
    }
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.blue);
        g2d.drawLine(w/2,h/2,x,y);
    }//end paint
}
