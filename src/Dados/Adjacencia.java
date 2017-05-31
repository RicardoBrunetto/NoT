package Dados;

/**
 * Created by rickh on 16/05/2017.
 */

/**
 * Uma adjacencia entre dois vertices implica em uma ARESTA
 */
public class Adjacencia {
    Vertice vertice;
    int peso;

    public Adjacencia(Vertice vertice, int peso) {
        this.vertice = vertice;
        this.peso = peso;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public int getPeso() {
        return peso;
    }
}
