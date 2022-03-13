package JogoAranha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaGO extends JFrame {
    protected JFrame jMenu;
    protected JLabel goFundo;
    protected JButton voltarMenu;
    protected JButton fecharJogo;

    public TelaGO(JFrame jMenu, Dimension SCREEN_SIZE) throws HeadlessException {
        this.jMenu = jMenu;
        this.setTitle("VOCÊ EH MUITO RUIM CARA KKKKK");
        this.setIconImage(Menu.iconTopFrame2.getImage());

        ImageIcon iconGOfundo = new ImageIcon(getClass().getResource("Imagens/gameIMG/gameover.gif"));
        goFundo = new JLabel(iconGOfundo);

        ImageIcon voltar = new ImageIcon(getClass().getResource("Imagens/gameIMG/voltarmenu.png"));
        voltarMenu = new JButton(voltar);
        voltarMenu.setBounds(650,350,150,50 );
        voltarMenu.setBackground(new Color(0,0,0,0));
        voltarMenu.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                jMenu.setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                repaint();
            }
        });

        ImageIcon fechar = new ImageIcon(getClass().getResource("Imagens/gameIMG/fecharjogo.png"));
        fecharJogo = new JButton(fechar);
        fecharJogo.setBounds(850,350,150,50);
        fecharJogo.setBackground(new Color(0,0,0,0));
        fecharJogo.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                repaint();
            }
        });


        this.add(voltarMenu);
        this.add(fecharJogo);

        this.add(goFundo);

        repaint();

        this.setSize(SCREEN_SIZE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }


}
