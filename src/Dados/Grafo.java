package Dados;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rickh on 16/05/2017.
 */
public class Grafo {
    private Map<String, Vertice> vertices;
    private int quantidadeArestas; //Apenas para controle no print

    public Grafo() {
        vertices = new HashMap<>();
        quantidadeArestas = 0;
    }

    /**
     * Adiciona um vértice ao um grafo
     * @param v
     */
    public Vertice adicionarVertice(Vertice v){
        Vertice p = existsVertice(v.getRotulo());
        if(p == null){
            vertices.put(v.getRotulo(), v);
            return v;
        }else{
            return p;
        }
    }

    /**
     * Adicionar uma aresta entre dois vértices
     * @param v
     * @param u
     * @param peso
     */
    public void adicionarAresta(Vertice v, Vertice u, int peso){
        v.adicionarAdjacencia(new Adjacencia(u, peso));
        u.adicionarAdjacencia(new Adjacencia(v, peso));
        quantidadeArestas++;
    }

    /**
     * Função que informa se o vértice que possui tal rótulo já está no grafo
     * @param rotulo
     */
    private Vertice existsVertice(String rotulo){
        return vertices.get(rotulo);
    }

    /**
     * Procedimento que reinicia os vértices com suas características originais,
     * mantendo as adjacências e rótulos.
     */
    public void resetGrafo(){
        for(Vertice v : vertices.values()) {
            v.setTd(0);
            v.setTf(0);
            v.setLow(0);
            v.setDist(0);
            v.setPred(null);
            v.setCor(Cor.BRANCO);
        }
    }

    /**
     * Função auxiliar que printa o grafo
     */
    public void printarGrafo(){
        System.out.println("** Informações Gerais: **");
        System.out.println("\tVértices: " + vertices.size());
        System.out.println("\tArestas: " + quantidadeArestas);
        System.out.println("\n** Lista de Vértices **\n");
        for (Vertice vertice : vertices.values()) {
            vertice.printarVertice();
        }
    }

    public Map<String, Vertice> getVertices() {
        return vertices;
    }

    public int getQuantidadeArestas() {
        return quantidadeArestas;
    }
}
