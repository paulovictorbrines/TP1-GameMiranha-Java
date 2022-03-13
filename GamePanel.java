package JogoAranha;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1200;
    static final int GAME_HEIGHT = 1000;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

    static final int GO_WIDTH = 1066;
    static final int GO_HEIGHT = 600;
    static final Dimension GO_SCREEN_SIZE = new Dimension(GO_WIDTH, GO_HEIGHT);

    static final int WIN_WIDTH = 1067;
    static final int WIN_HEIGHT = 600;
    static final Dimension WIN_SCREEN_SIZE = new Dimension(WIN_WIDTH, WIN_HEIGHT);

    static final int player_WIDTH = 103;
    static final int player_HEIGHT = 202;
    static final int DANO_PLAYER = 2;

    static final int bot_WIDTH = 209;
    static final int bot_HEIGHT = 143;
    static final int bot_SPEED = 5;

    static final int projetilBot_DIAMETER = 20;
    static final int projetilbot_SPEED = 10;

    static final int projetilPlayer_DIAMETER = 20;

    static final int destroco_DIAMETER = 200;
    static final int destroco_SPEED = 5;

    static Player player;
    static Bot bot;
    static ProjetilBot projetilBot;
    static ProjetilBot destroco;
    static ProjetilPlayer projetilPlayer;
    static Vidas vidas;

    int skin;

    GameFrame frame;
    JFrame jMenu;
    Thread gameThread;

    ImageIcon iconlParedeNvl1 = new ImageIcon(getClass().getResource("Imagens/gameIMG/.background1.jpg"));
    ImageIcon iconlParedeNvl3 = new ImageIcon(getClass().getResource("Imagens/gameIMG/.background2.jpg"));
    ImageIcon iconlParedeNvl2 = new ImageIcon(getClass().getResource("Imagens/gameIMG/.background3.jpg"));
    JLabel lFundo = new JLabel(iconlParedeNvl1);

    ImageIcon iconVilao2 = new ImageIcon(getClass().getResource("Imagens/gameIMG/.dr_octopus.gif"));
    ImageIcon iconVilao3 = new ImageIcon(getClass().getResource("Imagens/gameIMG/.doende_laranja.gif"));

    ImageIcon iconProjetil2 = new ImageIcon(getClass().getResource("Imagens/gameIMG/.garra_dr_oc.png"));
    ImageIcon iconProjetil3 = new ImageIcon(getClass().getResource("Imagens/gameIMG/.bomba_doende20.png"));

    ImageIcon iconDestroco = new ImageIcon(getClass().getResource("Imagens/gameIMG/.helicoptero_girando.gif"));

    static ImageIcon iconExplosao;
    static JLabel lexplosao;

    ArrayList<Pontuacoes> pontuacoes;

    GamePanel(int skin, JFrame jMenu, Musica[] musicas, int taMutado, ArrayList<Pontuacoes> pontuacoes) {
        this.skin = skin;
        this.jMenu = jMenu;
        this.pontuacoes = pontuacoes;

        newplayer(skin, musicas, taMutado);
        newbot();
        newprojetilBot();
        newdestroco();
        newprojetilPlayer();

        iconExplosao = new ImageIcon(getClass().getResource("Imagens/gameIMG/.explosao.gif"));
        lexplosao = new JLabel(iconExplosao);

        vidas = new Vidas(GAME_WIDTH, GAME_HEIGHT);
        frame = new GameFrame(SCREEN_SIZE, lFundo);

        this.setFocusable(true);
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }


    public void newplayer(int skin, Musica[] musicas, int taMutado) {
        player = new Player((GAME_WIDTH/2)-40, 500, player_WIDTH, player_HEIGHT, skin, musicas, taMutado);
    }

    public void newbot() {
        bot = new Bot(GAME_WIDTH/2, 61, bot_WIDTH, bot_HEIGHT);
    }

    public void newprojetilBot() {
        projetilBot = new ProjetilBot(bot.x + 5, bot.y, projetilBot_DIAMETER, projetilBot_DIAMETER, projetilbot_SPEED);
    }

    public void newdestroco() {
        destroco = new ProjetilBot(50, -500, destroco_DIAMETER, destroco_DIAMETER, destroco_SPEED);
        destroco.lprojetilBot.setIcon(iconDestroco);
    }

    public void newprojetilPlayer() {
        projetilPlayer = new ProjetilPlayer(-projetilPlayer_DIAMETER, GAME_HEIGHT + projetilPlayer_DIAMETER,
                                            projetilPlayer_DIAMETER, projetilPlayer_DIAMETER, skin);
    }

    public void apagaprojetilPlayer() {
        player.projetilPlayerCriada = false;
        projetilPlayer.setBounds(-projetilPlayer_DIAMETER, 0, projetilPlayer_DIAMETER, projetilPlayer_DIAMETER);
    }

    public void criaprojetilPlayer() {
        projetilPlayer.setBounds(player.x + 10, player.y, projetilPlayer_DIAMETER, projetilPlayer_DIAMETER);
    }

    public void move() {
        player.move();
        bot.move();
        projetilBot.move();
        destroco.move();

        if (player.flag) {
            projetilPlayer.move();
        }
    }

    public void explode(int x, int y) {
        lexplosao.setBounds(x, y, 137, 200);
    }

    public void checkCollision() {

        // projetilBot batendo no Player
        if (projetilBot.intersects(player.x, player.y, player_WIDTH, player_HEIGHT)) {
            vidas.player--;
            explode(projetilBot.x, projetilBot.y);
            projetilBot.setBounds(bot.x + projetilBot_DIAMETER/2, bot.y, projetilBot_DIAMETER, projetilBot_DIAMETER);
        }
        // muda a posição da projetilBot sempre q a anterior sai da tela
        if (projetilBot.y > GAME_HEIGHT) {
            explode(projetilBot.x, GAME_HEIGHT);
            projetilBot.setBounds(bot.x + projetilBot_DIAMETER/2, bot.y, projetilBot_DIAMETER, projetilBot_DIAMETER);
        }

        // destroço batendo no Player
        if (destroco.intersects(player.x, player.y, player_WIDTH, player_HEIGHT)) {
            vidas.player -= 3;
            explode(player.x, player.y);
            if (player.x > destroco.x + destroco_DIAMETER/2) {
                player.x = destroco.x + destroco_DIAMETER;
            } else {
                player.x = destroco.x - player_WIDTH;
            }
        }
        // invoca um destroço despois de um tempo
        if (destroco.y > GAME_HEIGHT+1000) {
            destroco.setBounds(bot.x, -1300, destroco_DIAMETER, destroco_DIAMETER);
        }


        // cria projetilPlayer
        if (player.projetilPlayerCriada) {
            criaprojetilPlayer();
        }
        // projetilPlayer batendo no bot e no destroço
        if (player.flag) {
            if (projetilPlayer.intersects(bot.x, bot.y, bot_WIDTH, bot_HEIGHT)) {
                vidas.bot -= DANO_PLAYER;
                apagaprojetilPlayer();
            }
            if (projetilPlayer.intersects(destroco)) {
                explode(destroco.x, destroco.y);
                destroco.setBounds(bot.x, -1300, destroco_DIAMETER, destroco_DIAMETER);

                if (vidas.player < 8) {
                    vidas.player += 2;
                } else if (vidas.player == 9) {
                    vidas.player += 1;
                }

                apagaprojetilPlayer();
            }
        }

        // Player batendo nas bordas
        {
            if (player.y >= GAME_HEIGHT - player_HEIGHT) {
                player.y = GAME_HEIGHT - player_HEIGHT;
            }
            if (player.y <= bot_HEIGHT + 62) {
                player.y = bot_HEIGHT + 62;
            }
            if (player.x <= 0) {
                player.x = 0;
            }
            if (player.x >= GAME_WIDTH - player_WIDTH) {
                player.x = GAME_WIDTH - player_WIDTH;
            }
        }

        // movimento do bot
        {
            if (bot.x >= GAME_WIDTH - bot_WIDTH)
                bot.setXVelocity(-bot_SPEED);

            if (bot.x <= 0)
                bot.setXVelocity(bot_SPEED);
        }
    }

    public void mudaNvl() {
        switch (vidas.nvl) {
            case 2:
                // Dr Octopus
                lFundo.setIcon(iconlParedeNvl2);
                bot.lBot.setIcon(iconVilao2);
                projetilBot.lprojetilBot.setIcon(iconProjetil2);
                projetilBot.yVelocity = 15;
                break;
            case 3:
                // Ainda a definir
                lFundo.setIcon(iconlParedeNvl3);
                bot.lBot.setIcon(iconVilao3);
                projetilBot.lprojetilBot.setIcon(iconProjetil3);
                projetilBot.yVelocity = 20;
                break;
            default:
                break;
        }
    }

    public void run() {
        int pontos = 0;

        // game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/ amountOfTicks;
        double delta = 0;

        while(true) {
            pontos++;

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                mudaNvl();
                player.mudaSpray();
                vidas.attTexto();

                vidas.vidasTemporario();
                if (vidas.gameOver) {
                    frame.dispose();

                    // tela de game over e depois volta pro menu
                    TelaGO telaGO = new TelaGO(jMenu, GO_SCREEN_SIZE);
                    break;
                }
                if (vidas.win) {
                    frame.dispose();
                    pontos = abs((1500000000 - pontos)/100000);
                    if(pontos < 0) {
                        pontos = 0;
                    }

                    // tela de vitória e depois volta pro menu
                    TelaWin win = new TelaWin(jMenu, WIN_SCREEN_SIZE, pontos, pontuacoes);
                    break;
                }

                delta--;
            }
        }
    }
}

