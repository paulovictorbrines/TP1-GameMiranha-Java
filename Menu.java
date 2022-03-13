package JogoAranha;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Menu {
    public int skin = 1;
    public int taMutado = 0;

    static ImageIcon iconTopFrame;
    static ImageIcon iconTopFrame2;

    public ImageIcon iconlMenu1;
    public ImageIcon iconlMenu2;
    public ImageIcon iconlMenu3;

    public ImageIcon iconPlay;
    public ImageIcon iconSkin1;
    public ImageIcon iconSkin2;
    public ImageIcon iconSkin3;

    public ImageIcon iconTutorial;
    public ImageIcon iconRecords;
    public ImageIcon iconMute;
    public ImageIcon iconDesmute;

    public Musica musMiranha;
    public Musica musVenom;
    public Musica musMiles;
    private Musica musVenomExtra;

    Musica[] musicas = new Musica[4];

    JButton extra;

    ArrayList<Pontuacoes> pontuacoes = new ArrayList<Pontuacoes>();

    Menu() {
        iniciaIcones();

        iniciaMusicas();
        this.musMiranha.loop();

        JLabel lMenu = new JLabel(iconlMenu1);
        JFrame fMenu = new JFrame("MENU");
        fMenu.setIconImage(iconTopFrame2.getImage());


        JPanel panelMenu = new JPanel();
        panelMenu.setBounds(0,-5,890,500);
        panelMenu.setBackground(Color.red);

        JButton play = new JButton(iconPlay);
        play.setBounds(660,150,200,50);
        play.setBackground(new Color(0,0,0,0));
        // inicia o jogo
        play.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                GamePanel panel = new GamePanel(skin, fMenu, musicas, taMutado, pontuacoes);
                fMenu.setVisible(false);

            }

            public void mousePressed(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseExited(MouseEvent e) {
                fMenu.repaint();
            }
        });


        JButton mute = new JButton(iconDesmute);
        mute.setBounds(815,10,50,50);
        mute.setBackground(new Color(0,0,0,0));
        mute.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                fMenu.repaint();

                if (taMutado == 0) {
                    paraMusicas();
                    taMutado = 1;
                    mute.setIcon(iconMute);
                } else {
                    resumeMusica();
                    taMutado = 0;
                    mute.setIcon(iconDesmute);
                }
            }

            public void mousePressed(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseExited(MouseEvent e) {
                fMenu.repaint();
            }
        });


        JButton skin1 = new JButton(iconSkin1);
        skin1.setBounds(710,250,100,30);
        skin1.setBackground(new Color(0,0,0,0));
        JButton skin2 = new JButton(iconSkin2);
        skin2.setBounds(710,300,100,30);
        skin2.setBackground(new Color(0,0,0,0));
        JButton skin3 = new JButton(iconSkin3);
        skin3.setBounds(710,350,100,30);
        skin3.setBackground(new Color(0,0,0,0));

        // seleciona skin
        skin1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                skin = 1;
                panelMenu.setBackground(Color.red);
                lMenu.setIcon(iconlMenu1);
                fMenu.repaint();
                ativaExtra();
                paraMusicas();
                if (taMutado == 0) {
                    musMiranha.loop();
                }
            }

            public void mousePressed(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseExited(MouseEvent e) {
                fMenu.repaint();
            }
        });
        skin2.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                skin = 2;
                panelMenu.setBackground(Color.black);
                lMenu.setIcon(iconlMenu2);
                fMenu.repaint();
                ativaExtra();
                paraMusicas();
                if (taMutado == 0) {
                    musVenom.loop();
                }
            }

            public void mousePressed(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseExited(MouseEvent e) {
                fMenu.repaint();
            }
        });
        skin3.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                skin = 3;
                panelMenu.setBackground(Color.magenta);
                lMenu.setIcon(iconlMenu3);
                fMenu.repaint();
                ativaExtra();
                paraMusicas();
                if (taMutado == 0) {
                    musMiles.loop();
                }
            }

            public void mousePressed(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseExited(MouseEvent e) {
                fMenu.repaint();
            }
        });

        extra = new JButton();
        extra.setBounds(45,330,150,140);
        extra.setBackground(new Color(0,0,0,0));
        extra.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                fMenu.repaint();
            }

            public void mousePressed(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                fMenu.repaint();

                if (taMutado == 0) {

                    musVenom.stop();
                    musVenomExtra.loop();
                }
            }

            public void mouseExited(MouseEvent e) {
                fMenu.repaint();

                if (taMutado == 0) {

                    musVenomExtra.stop();
                    musVenom.resume();
                }
            }
        });

        JButton melhoresTempos = new JButton(iconRecords);
        melhoresTempos.setBounds(10,160,150,40);
        melhoresTempos.setBackground(new Color(0,0,0,0));
        melhoresTempos.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                fMenu.repaint();
                TelaPontuacoes telaPontuacoes = new TelaPontuacoes("MELHORES SCORES", pontuacoes);
            }

            public void mousePressed(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseExited(MouseEvent e) {
                fMenu.repaint();
            }
        });

        JButton tutorial = new JButton(iconTutorial);
        tutorial.setBounds(10,220,150,40);
        tutorial.setBackground(new Color(0,0,0,0));
        tutorial.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                fMenu.repaint();
                TelaTutorial frameTutorial = new TelaTutorial("TUTORIAL");
            }

            public void mousePressed(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                fMenu.repaint();
            }

            public void mouseExited(MouseEvent e) {
                fMenu.repaint();
            }
        });

        fMenu.add(mute);
        fMenu.add(play);
        fMenu.add(skin1);
        fMenu.add(skin2);
        fMenu.add(skin3);
        fMenu.add(tutorial);
        fMenu.add(melhoresTempos);
        fMenu.add(extra);

        extra.setVisible(false);

        panelMenu.add(lMenu);
        fMenu.add(panelMenu);

        fMenu.setSize(890,500);
        fMenu.setLayout(null);
        fMenu.setResizable(false);
        fMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fMenu.setVisible(true);
        fMenu.setLocationRelativeTo(null);

    }

    public void iniciaIcones() {
        iconlMenu1 = new ImageIcon(getClass().getResource("Imagens/menuIMG/menu1.jpg"));
        iconlMenu2 = new ImageIcon(getClass().getResource("Imagens/menuIMG/menu2referencia.jpg"));
        iconlMenu3 = new ImageIcon(getClass().getResource("Imagens/menuIMG/menu3.jpg"));

        iconPlay = new ImageIcon(getClass().getResource("Imagens/menuIMG/menuPlay.png"));
        iconSkin1 = new ImageIcon(getClass().getResource("Imagens/menuIMG/menuMiranha.png"));
        iconSkin2 = new ImageIcon(getClass().getResource("Imagens/menuIMG/menuVenom.png"));
        iconSkin3 = new ImageIcon(getClass().getResource("Imagens/menuIMG/menuMiles.png"));

        iconTutorial = new ImageIcon(getClass().getResource("Imagens/menuIMG/menuTutorial.png"));
        iconRecords = new ImageIcon(getClass().getResource("Imagens/menuIMG/menuRecord.png"));

        iconMute = new ImageIcon(getClass().getResource("Imagens/menuIMG/menuMute.png"));
        iconDesmute = new ImageIcon(getClass().getResource("Imagens/menuIMG/menuDesmute.png"));

        iconTopFrame = new ImageIcon(getClass().getResource("Imagens/menuIMG/iconTop.jpg"));
        iconTopFrame2 = new ImageIcon(getClass().getResource("Imagens/menuIMG/iconTop1.jpg"));

    }

    public void iniciaMusicas() {
        musMiranha = new Musica(getClass().getResource("soundFX/mus_miranha.wav"));
        musVenom = new Musica(getClass().getResource("soundFX/mus_venom.wav"));
        musVenomExtra = new Musica(getClass().getResource("soundFX/mus_venom_extra.wav"));
        musMiles = new Musica(getClass().getResource("soundFX/mus_miles.wav"));

        musicas[0] = musMiranha;
        musicas[1] = musVenom;
        musicas[2] = musMiles;
    }

    public void paraMusicas() {
        musMiles.stop();
        musMiranha.stop();
        musVenom.stop();
    }

    public void resumeMusica() {
        if (skin == 1) {
            musMiranha.resume();
        } else if (skin == 2) {
            musVenom.resume();
        } else if (skin == 3) {
            musMiles.resume();
        }
    }

    public void ativaExtra() {
        if (skin == 2) {
            extra.setVisible(true);
        } else {
            extra.setVisible(false);
        }
    }

}

