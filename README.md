# Network of Thrones
Este trabalho foi desenvolvido para a disciplina de Algoritmos em Grafos.

## Funcionalidade
Dado um arquivo de entrada (`stormofswords.csv`), o programa o interpreta como um grafo não orientado e permite:
1. Consultar as distâncias entre vértices;
2. Consultar o número de pontes do grafo (caso exista);
3. Consultar os pontos de articulação do grafo (caso exista).

Também é possível que o usuário informe outro arquivo de entrada através do menu principal. O arquivo padrão fica localizado em `src/Resources`.

## Especificações Tecnológicas
Todo o programa foi escrito em Java. O projeto original foi criado com o auxílio da IDE da JetBrains para a linguagem: IntelliJ IDEA. Contudo, um `makefile` local pode ser perfeitamente utilizado, visto que não há dependências externas que requeiram complexidade.

## Implementação
O projeto apresenta uma implementação Java para a representação Lista de Adjacências de um grafo.
Neste projeto, são divididos os seguintes pacotes:
- `Dados`: que contém as classes que representam o Modelo a ser trabalhado;
- `Algoritmos`: que contém as classes que implementam os algoritmos de busca. Implementam o padrão de projeto *Strategy*.
  - `ArticulationPointSearch`: Busca pelos pontos de articulação. Faz uso da Busca em Profundidade.
  - `BreadthFirstSearch`: Busca em largura. Implementa as funcionalidades de mostrar um caminho entre dois vértices e sua distância.
  - `BridgeSearch`: Busca pelas pontes. Faz uso da Busca em Profundidade. Cria-se uma lista de pares (`Vertice`, `Adjacencia`), onde cada par vincula um vértice à sua adjacência, o que já é feito na Lista de Adjacências, mas neste caso são selecionados apenas alguns deles: as pontes (não são instanciadas novamente).
  - `DepthFirstSearch`: Busca em Profundidade.
  - `Search`: Interface que é implementada por todas as outras do pacote. Exige que se sobrescreva dois métodos: `aplicarBusca`, responsável por aplicar o algoritmo em si; e `printarResultado`, responsável por mostrar o resultado da busca na tela.

## Licença
Este projeto segue a licença [Creative Commons Attribution-ShareAlike (BY-SA)](https://creativecommons.org/licenses/by-sa/4.0/), que está detalhada no arquivo [`LICENSE.md`](LICENSE.md).
<p align="center">
  <img src="https://licensebuttons.net/l/by-sa/3.0/88x31.png">
</p>
