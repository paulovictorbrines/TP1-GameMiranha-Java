package JogoAranha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Locale;

public class TelaWin extends JFrame {
    protected JLabel goFundo;
    protected JButton voltarMenu;
    protected JButton fecharJogo;
    private JButton salvarPontuacao;
    private JTextField nickname;
    private JFrame menu;

    public TelaWin(JFrame jMenu, Dimension SCREEN_SIZE, int pontos, ArrayList<Pontuacoes> pontuacoes) throws HeadlessException {
        this.setTitle("VOCÊ EH MUITO BOM CARA PARA BENS 👏");
        this.menu = jMenu;
        this.setIconImage(Menu.iconTopFrame.getImage());

        ImageIcon iconWINfundo = new ImageIcon(getClass().getResource("Imagens/gameIMG/gamewin.gif"));
        goFundo = new JLabel(iconWINfundo);

        JOptionPane.showMessageDialog(null, "Seu SCORE foi de " + pontos + " pontos!!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        ImageIcon voltar = new ImageIcon(getClass().getResource("Imagens/gameIMG/voltarmenu.png"));
        voltarMenu = new JButton(voltar);
        voltarMenu.setBounds(325,450,150,50);
        voltarMenu.setBackground(new Color(0,0,0,0));
        voltarMenu.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                menu.setVisible(true);
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
        fecharJogo.setBounds(575,450,150,50);
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

        ImageIcon salvar = new ImageIcon(getClass().getResource("Imagens/gameIMG/salvarscore.png"));
        salvarPontuacao = new JButton(salvar);
        salvarPontuacao.setBounds(325, 375, 100, 30);
        salvarPontuacao.setBackground(new Color(0, 0, 0, 0));
        salvarPontuacao.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                repaint();

                if (nickname.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "PREENCHA COM SEU NICK ANTES DE SALVAR!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    nickname.requestFocus();
                } else {
                    String nick = nickname.getText().toUpperCase(Locale.ROOT);
                    JOptionPane.showMessageDialog(null, "Pontuação de " + pontos + " salva como " + nick, "Mensagem", JOptionPane.INFORMATION_MESSAGE);

                    pontuacoes.add(new Pontuacoes(pontos, nick));
                    salvarPontuacao.setEnabled(false);
                    nickname.setEnabled(false);
                    nickname.setText("");
                }
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

        nickname = new JTextField();
        nickname.setBounds(475, 375, 250, 30);
        nickname.requestFocus();

        this.add(salvarPontuacao);
        this.add(nickname);
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
