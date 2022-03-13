package JogoAranha;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class TelaPontuacoes extends JFrame {
    JPanel panelFundo;
    JPanel panelTabela;
    JLabel lPontuacoes;
    ImageIcon iconPontuacoes;
    ArrayList<Pontuacoes> pontuacoes;
    JTable tabela;

    public TelaPontuacoes(String title, ArrayList<Pontuacoes> pontuacoes) throws HeadlessException {
        super(title);
        this.setIconImage(Menu.iconTopFrame.getImage());
        this.pontuacoes = pontuacoes;

        panelFundo = new JPanel();
        panelFundo.setBounds(-1,-5, 890, 500);
        panelFundo.setBackground(new Color(0,0,0,0));

        panelTabela = new JPanel();
        panelTabela.setBounds(190,200, 500, 250);
        panelTabela.setBackground(new Color(0,0,0,0));

        iconPontuacoes = new ImageIcon(getClass().getResource("Imagens/menuIMG/pontuacoes.jpg"));
        lPontuacoes = new JLabel(iconPontuacoes);

        tabela = new JTable();
        tabela.setGridColor(Color.black );
        carregarTabela();


        JScrollPane jScrollPane = new JScrollPane(tabela);
        panelTabela.add(jScrollPane);
        panelFundo.add(lPontuacoes);

        getContentPane().add(panelTabela);
        getContentPane().add(panelFundo);

        this.setSize(890,500);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void carregarTabela(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"NICK", "SCORE"}, 0);

        Collections.sort(pontuacoes, Pontuacoes.PontosComp);
        for (int i = 0; i < pontuacoes.size(); i++) {
            Object linha[] = new Object[]{pontuacoes.get(i).getNome(), pontuacoes.get(i).getPontos()};
            modelo.addRow(linha);
        }

        tabela.setModel(modelo);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);


        tabela.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
        tabela.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
    }

}
