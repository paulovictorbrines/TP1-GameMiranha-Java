package JogoAranha;

import javax.swing.*;

public class Bot extends RectMove {

    int xVelocity;
    int x;

    // Duende Verde
    ImageIcon iconVilao1 = new ImageIcon(getClass().getResource("Imagens/gameIMG/.doendeverde.gif"));
    JLabel lBot = new JLabel(iconVilao1);
    
    Bot(int x, int y, int BOT_WIDTH, int BOT_HEIGHT) {
        super(x, y, BOT_WIDTH, BOT_HEIGHT);
    }

    public void setXVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void move() {
        x+= xVelocity;
        lBot.setBounds(x, y, width, height);
    }

}
