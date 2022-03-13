package JogoAranha;


import javax.swing.*;
import java.awt.event.KeyEvent;

public class Player extends RectMove {

    int skin;
    int taMutado;

    int yVelocity;
    int xVelocity;
    int speed = 10;
    boolean projetilPlayerCriada = false;
    boolean flag = false;
    int aux = 0;

    ImageIcon iconPlayerMexendo;
    ImageIcon iconPlayerParado;
    JLabel lplayer;
    Musica[] musicas;


    Player(int x, int y, int player_WIDTH, int player_HEIGHT, int skin, Musica[] musicas, int taMutado) {
        super(x, y, player_WIDTH, player_HEIGHT);
        this.skin = skin;
        this.taMutado = taMutado;
        this.musicas = musicas;

        switch (skin) {
            case 2:
                iconPlayerMexendo = new ImageIcon(getClass().getResource("Imagens/gameIMG/.venom_mexendo.gif"));
                iconPlayerParado = new ImageIcon(getClass().getResource("Imagens/gameIMG/.venom_parado.png"));
                break;
            case 3:
                iconPlayerMexendo = new ImageIcon(getClass().getResource("Imagens/gameIMG/.milesmorales_mexendo.gif"));
                iconPlayerParado = new ImageIcon(getClass().getResource("Imagens/gameIMG/.milesmorales_parado.png"));
                break;
            default:
                iconPlayerMexendo = new ImageIcon(getClass().getResource("Imagens/gameIMG/.ha_mexendo.gif"));
                iconPlayerParado = new ImageIcon(getClass().getResource("Imagens/gameIMG/.ha_parado.png"));
                break;
        }

        lplayer = new JLabel(iconPlayerParado);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(-speed);
            aux = 1;
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            setYDirection(speed);
            aux = 1;
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            setXDirection(speed);
            aux = 1;
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            setXDirection(-speed);
            aux = 1;
            move();
        }

        // cria projetilPlayer
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            projetilPlayerCriada = true;
            flag = true;
            aux = 0;
        }

        if (e.getKeyCode() == KeyEvent.VK_M) {
            if (taMutado == 0) {
                paraMusicas();
                taMutado = 1;
            } else {
                resumeMusica();
                taMutado = 0;
            }
        }
    }

    public void keyRealiased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(0);
            aux = 0;
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            setYDirection(0);
            aux = 0;
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            setXDirection(0);
            aux = 0;
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            setXDirection(0);
            aux = 0;
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            projetilPlayerCriada = false;
            move();
        }
    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
        lplayer.setBounds(x, y, width, height);
    }

    public void mudaSpray() {
        if (aux == 0) {
            lplayer.setIcon(iconPlayerParado);
        }
        if (aux == 1) {
            lplayer.setIcon(iconPlayerMexendo);
        }
    }

    public void paraMusicas() {
        musicas[0].stop();
        musicas[1].stop();
        musicas[2].stop();
    }

    public void resumeMusica() {
        if (skin == 1) {
            musicas[0].resume();
        } else if (skin == 2) {
            musicas[1].resume();
        } else if (skin == 3) {
            musicas[2].resume();
        }
    }
}
