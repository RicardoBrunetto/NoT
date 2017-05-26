package Algoritmos;

import Dados.Adjacencia;
import Dados.Cor;
import Dados.Grafo;
import Dados.Vertice;

import java.util.*;

/**
 * Created by rickh on 17/05/2017.
 * Busca em Largura
 */

public class BridgeSearch implements Search{
    private int tempo;
    /*Aqui cria-se uma lista de pares (Vertice, Adjacencia)
    * Cada par vincula um vértice à sua adjacência
    * Isso já é feito na Lista de Adjacencias, mas aqui
    * Apenas selecionamos alguns deles: as pontes (não criamos novamente)*/
    List<Map.Entry<Vertice, Adjacencia>> pontes;

    public BridgeSearch() {
        pontes = new ArrayList<>();

    }

    @Override
    public void aplicarBusca(Grafo grafo) {
        grafo.resetGrafo();
        tempo = 0;
        for(Vertice v : grafo.getVertices().values())
            if(v.getCor() == Cor.BRANCO)
                bridges(v);
    }

    private void bridges(Vertice u){
        tempo++;
        u.setCor(Cor.CINZA);
        u.setLow(tempo);
        u.setTd(tempo);
        for(Adjacencia adj : u.getAdjacentes()){
            Vertice v = adj.getVertice();
            if(v.getCor() == Cor.BRANCO){
                v.setPred(u);
                bridges(v);
                u.setLow(min(u.getLow(), v.getLow()));
                if(v.getLow() > u.getTd()) //(u,v) é ponte
                    pontes.add(new AbstractMap.SimpleEntry<>(u, adj));
            }else{
                if(u.getPred() != v && v.getTd() < u.getTd()){
                    u.setLow(min(u.getLow(), v.getTd()));
                }
            }
            u.setCor(Cor.PRETO);
            tempo++;
            u.setTf(tempo);
        }
    }

    private int min(int a, int b){
        if(a<b) return a;
        else return b;
    }

    public List<Map.Entry<Vertice, Adjacencia>> getPontes() {
        return pontes;
    }

    @Override
    public void printarResultado() {
        System.out.print("\n\n** Pontes **\n");
        for(Map.Entry<Vertice, Adjacencia> entrada : pontes) {
            System.out.println("(" + entrada.getKey().getRotulo() + "," + entrada.getValue().getVertice().getRotulo() + "," + entrada.getValue().getPeso() + ")");
        }
        System.out.print("\tTotal: " + pontes.size() + "\n");
    }
}
