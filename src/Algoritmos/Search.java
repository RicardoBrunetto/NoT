package Algoritmos;

import Dados.Grafo;

/**
 * Created by rickh on 17/05/2017.
 * Interface para o Padrao de Projeto Strategy
 * https://sourcemaking.com/design_patterns/strategy
 */

public interface Search {
    /**
     * Realiza a busca que do tipo desejado no grafo
     * @param grafo
     */
    public void aplicarBusca(Grafo grafo);

    /**
     * Mostra na tela o resultado da busca
     */
    public void printarResultado();
}
