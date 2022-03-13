package JogoAranha;


import javax.swing.*;
import java.awt.*;

public class Vidas {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player = 10;
    int bot = 20;
    boolean gameOver = false;
    boolean win = false;
    int nvl = 1;

    JLabel lhud;

    JPanel phud = new JPanel();

    Vidas(int GAME_WIDTH, int GAME_HEIGHT) {
        Vidas.GAME_WIDTH = GAME_WIDTH;
        Vidas.GAME_HEIGHT = GAME_HEIGHT;

        Font fonte = new Font("Arial-BoldIt", Font.PLAIN, 25);
        //
        //Arial-Black
        Rectangle rhud = new Rectangle(10,18,1165,50);

        lhud = new JLabel("VIDA: " + player+ "                       BOSS: " + bot + "                       NÍVEL " + nvl);
        lhud.setFont(fonte);
        lhud.setVerticalTextPosition(SwingConstants.CENTER);
        lhud.setVerticalAlignment(SwingConstants.CENTER);
        lhud.setHorizontalTextPosition(SwingConstants.CENTER);
        lhud.setBackground(Color.DARK_GRAY);

        phud.setBounds(rhud);
        lhud.setBackground(Color.DARK_GRAY);
        phud.add(lhud);


    }


    public void vidasTemporario() {
        if (player <= 0) {
            gameOver = true;
        }

        if (bot <= 0) {
            nvl++;
            if (nvl < 4) {
                bot = 20;
            } else {
                win = true;
            }
        }
    }

    public void attTexto() {
        lhud.setText("VIDA: " + player+ "                       BOSS: " + bot + "                       NÍVEL " + nvl);
        lhud.repaint();
    }
}
