package Caballos;
import javax.swing.*;
import java.awt.*;
public class Ganador extends JPanel {
    private int h=getHeight();
    public void mostrar(String name){
        this.setBackground(Color.BLACK);
        JLabel label=new JLabel(name);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 80));
        label.setBounds(10,h/2,100,100);
        add(label);
        setVisible(true);
    }
}
