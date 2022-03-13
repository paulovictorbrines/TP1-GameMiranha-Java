package JogoAranha;

import java.util.Comparator;

public class Pontuacoes{
    private int pontos;
    private String nome;

    public Pontuacoes(int pontos, String nome) {
        this.pontos = pontos;
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public static Comparator<Pontuacoes> PontosComp = new Comparator<Pontuacoes>() {

        public int compare(Pontuacoes p1, Pontuacoes p2) {

            int ponto1 = p1.getPontos();
            int ponto2 = p2.getPontos();

            return ponto2-ponto1;
        }};

    @Override
    public String toString() {
        return "Pontuacoes{" +
                "pontos=" + pontos +
                ", nome='" + nome + '\'' +
                '}';
    }
}
