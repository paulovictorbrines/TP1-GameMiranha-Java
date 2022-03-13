package JogoAranha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame {

    GameFrame(Dimension SCREEN_SIZE, JLabel lFundo) {
        this.setIconImage(Menu.iconTopFrame.getImage());

        this.setSize(SCREEN_SIZE);
        this.setTitle("JOGO DO MIRANHA");
        this.setBackground(Color.blue);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setResizable(false);


        this.add(GamePanel.projetilBot.lprojetilBot);
        this.add(GamePanel.destroco.lprojetilBot);
        this.add(GamePanel.bot.lBot);

        this.add(GamePanel.player.lplayer);
        this.add(GamePanel.projetilPlayer.lprojetilPlayer);

        this.add(GamePanel.lexplosao);

        this.add(GamePanel.vidas.phud);
        this.add(lFundo);
        leTeclado(GamePanel.player);
    }

    public void leTeclado(Player player) {
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            public void keyReleased(KeyEvent e) {
                player.keyRealiased(e);
            }

            public void keyTyped(KeyEvent e) {
            }
        });

    }
}
