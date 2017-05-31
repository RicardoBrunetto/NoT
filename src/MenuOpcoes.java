import Algoritmos.*;
import Dados.Vertice;

import java.util.Scanner;

/**
 * Created by rickh on 30/05/2017.
 */
public class MenuOpcoes {
    private int opcao;

    public void inicar(){
        printarOpcoes();
        lerOpcao();
    }

    private void printarOpcoes(){
        System.out.print("\n\n============== NETWORK OF THRONES ==============\n");
        System.out.println("0 - Sair");
        System.out.println("1 - Calcular distancia entre vertices");
        System.out.println("2 - Listar Pontes");
        System.out.println("3 - Listar Pontos de Articulacao");
        System.out.println("\t\t---\t\t");
        System.out.println("4 - Aplicar Busca em Largura");
        System.out.println("5 - Aplicar Busca em Profundidade");
        System.out.println("6 - Printar Grafo");
        System.out.println("\t\t---\t\t");
        System.out.println("7 - Carregar outro Grafo a partir de arquivo");
    }

    private void lerOpcao(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("\n\tDigite a opcao desejada: ");

        int opcao = scanner.nextInt();

        Search search = new DepthFirstSearch();

        switch(opcao){
            case 0:
                return;
            case 1:
                //Distancia
                String lblOrigem, lblDestino;
                Vertice origem, destino;
                do{
                    System.out.println("Digite corretamente o rotulo do vertice ORIGEM [Nome de um Personagem]: ");
                    lblOrigem = scanner.next();
                    System.out.println("Digite corretamente o rotulo do vertice DESTINO [Nome de um Personagem]: ");
                    lblDestino = scanner.next();
                    origem = Main.grafo.getVertices().get(lblOrigem.toUpperCase());
                    destino = Main.grafo.getVertices().get(lblDestino.toUpperCase());
                }while(origem == null ||destino == null);

                search = new BreadthFirstSearch(origem, destino);
                break;
            case 2:
                //Pontes
                search = new BridgeSearch();
                break;
            case 3:
                //Pontos de Articulacao
                search = new ArticulationPointSearch();
                break;
            case 4:
                //Apenas BFS
                origem = null;
                do{
                    System.out.println("Digite corretamente o rotulo do vertice ORIGEM [Nome de um Personagem]: ");
                    lblOrigem = scanner.next();
                    origem = Main.grafo.getVertices().get(lblOrigem.toUpperCase());
                }while(origem == null);
                search = new BreadthFirstSearch(origem);
                break;
            case 5:
                //Apenas DFS
                search = new DepthFirstSearch();
                break;
            case 6:
                Main.grafo.printarGrafo();
                inicar();
                return;
            case 7:
                Main.novoGrafo();
                inicar();
                return;
        }
        search.aplicarBusca(Main.grafo);
        search.printarResultado();

        inicar();

    }
}
