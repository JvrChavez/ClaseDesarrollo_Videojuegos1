package Ventana3;
import javax.sound.sampled.*;
import java.io.*;
public class Sonido {
    private String ruta;
    private AudioInputStream audioStream;
    private Clip clip;
    public Sonido(String ruta){
        this.ruta=ruta;
        try {
            audioStream=AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
            clip=AudioSystem.getClip();
        } catch (Exception e) {}
    }
    public void play(){
        try{
            System.out.println("Entro al play");
            clip.open(audioStream);
            System.out.println("dentro");
            clip.loop(0);
            System.out.println("Salio");
        }catch(Exception e){}
    }
}
