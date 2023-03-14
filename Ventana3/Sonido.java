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
            clip.open(audioStream);            
            clip.loop(0);        
        }catch(Exception e){}
    }
}
