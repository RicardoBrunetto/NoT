package Dados;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickh on 16/05/2017.
 */

public class Vertice {
    Cor cor;
    int td, tf, low, dist;
    String rotulo;
    Vertice pred;
    List<Adjacencia> adjacentes;

    /**
     * Construtor que recebe apenas o rotulo como parametro
     * @param rotulo
     */
    public Vertice(String rotulo) {
        this.rotulo = rotulo;
        this.td = 0;
        this.tf = 0;
        this.low = 0;
        this.dist = 0;
        this.cor = Cor.BRANCO;
        this.pred = null;
        adjacentes = new ArrayList<>();
    }

    /**
     * Inclui uma Adjacencia na lista de vertices adjacentes
     * @param adjacencia
     */
    public void adicionarAdjacencia(Adjacencia adjacencia){
        adjacentes.add(adjacencia);
    }

    public void printarVertice(){
        System.out.println("[" + getRotulo() + "] | Cor: " + getCor().name() + " | Adjacencias: " + adjacentes.size() + " | " + getTd() + "/" + getTf() + " - low: " + getLow() + " | Dist: " + getDist());
        System.out.print("\t| ");
        for(Adjacencia a : adjacentes)
            System.out.print(" -> " + a.vertice.getRotulo() + "[" + a.peso + "]");
        System.out.print(" |\n");
    }

    @Override
    public String toString() {
        return rotulo;
    }

    //Getters e Setters

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int getTd() {
        return td;
    }

    public void setTd(int td) {
        this.td = td;
    }

    public int getTf() {
        return tf;
    }

    public void setTf(int tf) {
        this.tf = tf;
    }

    public String getRotulo() {
        return rotulo;
    }

    public Vertice getPred() {
        return pred;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void setPred(Vertice pred) {
        this.pred = pred;
    }

    public List<Adjacencia> getAdjacentes() {
        return adjacentes;
    }

    public void setAdjacentes(List<Adjacencia> adjacentes) {
        this.adjacentes = adjacentes;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }
}
