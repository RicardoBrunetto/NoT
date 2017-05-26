package Algoritmos;

import Dados.Adjacencia;
import Dados.Cor;
import Dados.Grafo;
import Dados.Vertice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickh on 17/05/2017.
 */
public class ArticulationPointSearch implements Search{
    private int tempo;
    private List<Vertice> pontosArticulacao;

    public ArticulationPointSearch() {
        this.pontosArticulacao = new ArrayList<>();
    }

    @Override
    public void aplicarBusca(Grafo grafo) {
        grafo.resetGrafo();
        tempo = 0;
        for(Vertice v : grafo.getVertices().values())
            if(v.getCor() == Cor.BRANCO)
                articulationPoint(v);
    }

    private void articulationPoint(Vertice u){
        tempo++;
        u.setCor(Cor.CINZA);
        u.setLow(tempo);
        u.setTd(tempo);

        for(Adjacencia adj : u.getAdjacentes()){ //Percorrendo as "arestas" - os adjacentes a u
            Vertice v = adj.getVertice();
            if(v.getCor() == Cor.BRANCO){
                v.setPred(u);
                articulationPoint(v);
                if(u.getPred() == null){ //u é raiz
                    if(u.getAdjacentes().size() > 1) //u possui mais de 1 filho
                        if(u.getAdjacentes().contains(v))// se v é filho de u
                            addPontoArticulacao(u);
                }else{
                    u.setLow(min(u.getLow(), v.getLow()));
                    if(v.getLow() >= u.getTd()) //u é ponto de articulaçãp
                        addPontoArticulacao(u);
                }
            }else {
                if (u.getPred() != v && (v.getTd() < u.getTd())) {
                    u.setLow(min(u.getLow(), v.getTd()));
                }
            }
        }
        u.setCor(Cor.PRETO);
        tempo++;
        u.setTf(tempo);
    }

    private int min(int a, int b){
        if(a<b) return a;
        else return b;
    }

    private void addPontoArticulacao(Vertice v){
        if(!pontosArticulacao.contains(v))
            pontosArticulacao.add(v);
    }

    public List<Vertice> getPontosArticulacao(){
        return pontosArticulacao;
    }

    @Override
    public void printarResultado() {
        System.out.print("\n\n** Pontos de Articulação **\n");
        for(Vertice v : pontosArticulacao)
            System.out.println(v.getRotulo());
        System.out.print("\tTotal: " + pontosArticulacao.size() + "\n");
    }
}
