package Algoritmos;

import Dados.Adjacencia;
import Dados.Cor;
import Dados.Grafo;
import Dados.Vertice;

/**
 * Created by rickh on 17/05/2017.
 */
public class DepthFirstSearch implements Search{
    private int tempo;
    private Grafo g; //Apenas para printar o resultado

    @Override
    public void aplicarBusca(Grafo grafo) {
        this.g = grafo;
        grafo.resetGrafo();
        tempo = 0;
        for(Vertice v : grafo.getVertices().values())
            if(v.getCor() == Cor.BRANCO)
                DFS_Visit(v);
    }

    private void DFS_Visit(Vertice u){
        tempo++;
        u.setCor(Cor.CINZA);
        u.setTd(tempo);
        for(Adjacencia adj : u.getAdjacentes()){ //Percorrendo as "arestas" - os adjacentes a u
            Vertice v = adj.getVertice();
            if(v.getCor() == Cor.BRANCO) {
                v.setPred(u);
                DFS_Visit(v);
            }
        }
        u.setCor(Cor.PRETO);
        tempo++;
        u.setTf(tempo);
    }

    @Override
    public void printarResultado() {
        g.printarGrafo();
    }
}
