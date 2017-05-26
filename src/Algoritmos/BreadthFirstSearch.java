package Algoritmos;

import Dados.Adjacencia;
import Dados.Cor;
import Dados.Grafo;
import Dados.Vertice;

import java.util.*;

/**
 * Created by rickh on 17/05/2017.
 */
public class BreadthFirstSearch implements Search{

    private Vertice source, destino;
    private BFSTree t;

    public BreadthFirstSearch(Vertice source) {
        this.source = source;
        t = new BFSTree(source);
    }

    @Override
    public void aplicarBusca(Grafo grafo) {
        grafo.resetGrafo();

        source.setDist(0);
        source.setCor(Cor.CINZA);

        Fila fila = new Fila();
        fila.enqueue(source);
        while(!fila.isEmpty()) {
            Vertice v = fila.dequeue();
            for(Adjacencia adj : v.getAdjacentes()){
                Vertice u = adj.getVertice();
                if(u.getCor() == Cor.BRANCO) {
                    u.setCor(Cor.CINZA);
                    u.setDist(v.getDist()+1);
                    u.setPred(v);
                    fila.enqueue(u);
                    //Neste ponto, adiciona-se o vértice como nó na BFSTree
                    t.setChild(v, u);
                }
            }
            v.setCor(Cor.PRETO);
        }
    }

    @Override
    public void printarResultado() {
        t.BFSPrint();
    }

    private class Fila {
        ArrayList<Vertice> vertices;

        private Fila() {
            this.vertices = new ArrayList<>();
        }

        private void enqueue(Vertice vertice){
            vertices.add(vertices.size(), vertice);
        }

        private Vertice dequeue(){
            return vertices.size() > 0
                    ? vertices.remove(0)
                    : null;
        }

        private boolean isEmpty(){
            if(vertices.size() == 0) return true;
            else return false;
        }
    }

    private class BFSTree<T> {
        private Node<T> root;

        public BFSTree(T rootData) {
            root = new Node<T>(rootData);
        }

        public void setRoot(Node<T> root) {
            this.root = root;
        }

        public Node<T> getRoot() {
            return root;
        }

        private Node<T> busca(T vertice, Node<T> atual){
            if(atual.vertice == vertice) return atual;
            if(atual.filhos.size() >0){
                for(Node<T> filho : atual.filhos)
                    return busca(vertice, filho);
            }
            return null;
        }

        public void setChild(T parent, T child){
            Node<T> parentNode = busca(parent, root);
            if(parentNode == null) return;
            Node<T> childNode = new Node<T>(child);
            parentNode.filhos.add(childNode);
        }

        private class Node<T> {
            private T vertice;
            private List<Node<T>> filhos;

            public Node(T vertice) {
                this.vertice = vertice;
                this.filhos = new ArrayList<>();
            }


        }

        public void BFSPrint(){
            Queue<Node<T>> q = new LinkedList<>();
            q.offer(root);
            BFSPrint(q);
        }

        private void BFSPrint(Queue<Node<T>> q){
            if(q.isEmpty())
                return;
            while(!q.isEmpty()){
                Node<T> current = q.remove();
                System.out.print(current.vertice.toString() + " ");
                for(Node<T> node : current.filhos)
                    q.offer(node);
                System.out.println();
            }
        }
    }
}
