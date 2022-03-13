package JogoAranha;

import javax.swing.*;
import java.awt.*;

public class TelaTutorial extends JFrame{
    JPanel panelTelaTutorial;
    JLabel lTutorialFundo;
    ImageIcon iconTutorial;

    public TelaTutorial(String title) {
        super(title);
        this.setIconImage(Menu.iconTopFrame.getImage());

        panelTelaTutorial = new JPanel();
        panelTelaTutorial.setBounds(0,-5, 792, 460);
        panelTelaTutorial.setBackground(new Color(0,0,0,0));

        iconTutorial = new ImageIcon(getClass().getResource("Imagens/menuIMG/tutorial.jpg"));
        lTutorialFundo = new JLabel(iconTutorial);


        panelTelaTutorial.add(lTutorialFundo);
        this.add(panelTelaTutorial);

        this.setSize(792,460);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
