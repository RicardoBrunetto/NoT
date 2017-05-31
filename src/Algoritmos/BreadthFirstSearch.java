package Algoritmos;

import Dados.Adjacencia;
import Dados.Cor;
import Dados.Grafo;
import Dados.Vertice;

import java.util.*;

/**
 * Created by rickh on 17/05/2017.
 */
public class BreadthFirstSearch implements Search {

    private Vertice source, destino;
    private Grafo grafo;

    public BreadthFirstSearch(Vertice source) {
        this.source = source;
    }

    public BreadthFirstSearch(Vertice source, Vertice destino) {
        this.source = source;
        this.destino = destino;
    }

    @Override
    public void aplicarBusca(Grafo grafo) {
        this.grafo = grafo;
        grafo.resetGrafo();

        source.setDist(0);
        source.setCor(Cor.CINZA);

        Fila fila = new Fila();
        fila.enqueue(source);
        while (!fila.isEmpty()) {
            Vertice v = fila.dequeue();
            for (Adjacencia adj : v.getAdjacentes()) {
                Vertice u = adj.getVertice();
                if (u.getCor() == Cor.BRANCO) {
                    u.setCor(Cor.CINZA);
                    u.setDist(v.getDist() + 1);
                    u.setPred(v);
                    fila.enqueue(u);
                }
            }
            v.setCor(Cor.PRETO);
        }
    }

    @Override
    public void printarResultado() {
        if(destino == null){
            if(grafo != null){
                grafo.printarGrafo();
            }
        }else{
            System.out.print("\nDistancia de " + source.getRotulo() + " a " + destino.getRotulo() + " = " + destino.getDist() + "\n");
            System.out.println("Caminho de " + source.getRotulo() + " a " + destino.getRotulo() + ":");
            printarCaminho(destino);
        }
    }

    private void printarCaminho(Vertice v){
        if(v == source)
            System.out.print(source.getRotulo());
        else{
            if(v.getPred() == null)
                System.out.println("Nao ha caminho de " + source.getRotulo() + " a " + v.getRotulo());
            else{
                printarCaminho(v.getPred());
                System.out.print(" -> " + v.getRotulo());
            }
        }
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public Vertice getDestino() {
        return destino;
    }

    private class Fila {
        ArrayList<Vertice> vertices;

        private Fila() {
            this.vertices = new ArrayList<>();
        }

        private void enqueue(Vertice vertice) {
            vertices.add(vertices.size(), vertice);
        }

        private Vertice dequeue() {
            return vertices.size() > 0
                    ? vertices.remove(0)
                    : null;
        }

        private boolean isEmpty() {
            if (vertices.size() == 0) return true;
            else return false;
        }
    }
}
