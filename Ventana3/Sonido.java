package Ventana3;
import javax.sound.sampled.*;
import java.io.*;
public class Sonido {
    private String ruta;
    private AudioInputStream audioStream;
    private Clip clip;
    private Long microSegundos;
    public Sonido(String ruta){
        this.ruta=ruta;
        try {
            audioStream=AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
            clip=AudioSystem.getClip();
        } catch (Exception e) {}
    }//end constructor
    public void play(){
        try{            
            clip.open(audioStream);            
            clip.loop(0);        
        }catch(Exception e){}
    }//end play
    public void pause(){
        microSegundos=clip.getMicrosecondPosition();
        clip.stop();        
    }//end pause
    public void resume(){
        clip.close();
        try {
            audioStream=AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
            play();
            clip.setMicrosecondPosition(microSegundos);            
        } catch (Exception e) {}
    }//end resume
    public void stopAlto(){
        microSegundos=0L;
        clip.stop();
        clip.close();
    }//end stopAlto
}
