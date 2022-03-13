package JogoAranha;

import javax.swing.*;

public class ProjetilBot extends RectMove {

    int yVelocity;
    JLabel lprojetilBot;

    ImageIcon iconProjetilBot = new ImageIcon(getClass().getResource("Imagens/gameIMG/.bomba_doende20.png"));

    ProjetilBot(int x, int y, int width, int height, int speed){
        super(x, y, width, height);
        yVelocity = speed;
        lprojetilBot = new JLabel(iconProjetilBot);
    }

    public void move() {
        y += yVelocity;
        lprojetilBot.setBounds(x, y, width, height);
    }

}
