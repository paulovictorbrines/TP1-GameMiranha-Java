package JogoAranha;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

import static javax.sound.sampled.AudioSystem.*;

public class Musica {
    private Clip clip;
    private int framePosition;

    //constructor that recieve a string that represent a path file of the song
    public Musica (URL soundFileName) {
        this.framePosition = 0; //init the song at literally of begin

        try {
            AudioInputStream sound = getAudioInputStream(soundFileName);

            this.clip = getClip();
            this.clip.open(sound);
        }
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Error audio set");
        }
    }

    public void play () {
        this.clip.setFramePosition(0);
        this.clip.start();
    }

    //overloading method in case its needed
    public void play (double vol) {
        this.clip.setFramePosition(0);
        FloatControl gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float)(Math.log(vol) / Math.log(10) * 20); //math for dB
        gain.setValue(dB);
        this.clip.start();
    }

    public void loop () {
        this.clip.setFramePosition(0);
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    //stop the music (pause)
    public void stop () {
        this.clip.stop();
        this.framePosition = this.clip.getFramePosition(); //save the position fo the song
    }

    public void close () {
        this.clip.close();
    }

    //unpause the song
    public void resume () {
        this.clip.setFramePosition(framePosition);
        this.clip.start();
    }

    public void setVolume (double vol) {
        //controls the volume of song
        FloatControl gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float)(Math.log(vol) / Math.log(10) * 20); //math for dB
        gain.setValue(dB);
    }

}
