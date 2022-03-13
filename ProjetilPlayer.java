package JogoAranha;

import javax.swing.*;

public class ProjetilPlayer extends RectMove {

    int yVelocity = 5;
    JLabel lprojetilPlayer;
    ImageIcon iconprojetilPlayer;


    ProjetilPlayer(int x, int y, int width, int height, int skin) {
        super(x, y, width, height);


        switch (skin) {
            case 2:
                iconprojetilPlayer = new ImageIcon(getClass().getResource("Imagens/gameIMG/.teiaP_venom.png"));
                break;
            case 3:
                iconprojetilPlayer = new ImageIcon(getClass().getResource("Imagens/gameIMG/.teiaP.png"));
                break;
            default:
                iconprojetilPlayer = new ImageIcon(getClass().getResource("Imagens/gameIMG/.teiaP.png"));
                break;
        }

        lprojetilPlayer = new JLabel(iconprojetilPlayer);
    }

    public void move() {
        y -= yVelocity;
        lprojetilPlayer.setBounds(x, y, width, height);
    }

}
