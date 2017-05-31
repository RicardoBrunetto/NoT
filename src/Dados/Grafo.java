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
     * Adiciona um vertice ao um grafo
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
     * Adicionar uma aresta entre dois vertices
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
     * Funcao que informa se o vertice que possui tal rotulo ja esta no grafo
     * @param rotulo
     */
    private Vertice existsVertice(String rotulo){
        return vertices.get(rotulo);
    }

    /**
     * Procedimento que reinicia os vertices com suas características originais,
     * mantendo as adjacencias e rotulos.
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
     * Funcao auxiliar que printa o grafo
     */
    public void printarGrafo(){
        System.out.println("** Informacões Gerais: **");
        System.out.println("\tVertices: " + vertices.size());
        System.out.println("\tArestas: " + quantidadeArestas);
        System.out.println("\n** Lista de Vertices **\n");
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
