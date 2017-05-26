import Algoritmos.*;
import Dados.Grafo;
import Dados.Vertice;

import java.util.Scanner;

/**
 * Created by rickh on 16/05/2017.
 */
public class Main {

    public static void main(String[] args){
        Grafo grafo = new Grafo();

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String string = scanner.nextLine();
            if(string.isEmpty()) break;
            String[] str = string.split(",");
            Integer i;
            try{
                i =  Integer.valueOf(str[2]);
            }catch(Exception e){
                continue;
            }
            grafo.adicionarAresta(grafo.adicionarVertice(new Vertice(str[0])), grafo.adicionarVertice(new Vertice(str[1])), i);
        }

        Search search;

        //Pontos de Articulação
        search = new ArticulationPointSearch();
        search.aplicarBusca(grafo);
        search.printarResultado();

        //Pontes
        search = new BridgeSearch();
        search.aplicarBusca(grafo);
        search.printarResultado();

        //BFS
        /*String sourceLabel = scanner.nextLine();

        Vertice source = grafo.getVertices().get(sourceLabel);
        if(source == null) return;

        search = new BreadthFirstSearch(source);
        search.aplicarBusca(grafo);
        search.printarResultado();*/
        //grafo.printarGrafo();
    }

}
