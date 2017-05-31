import Algoritmos.*;
import Dados.Grafo;
import Dados.Vertice;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

/**
 * Created by rickh on 16/05/2017.
 */
public class Main {

    public static Grafo grafo;
    private static final String ENTRADA_PADRAO = System.getProperty("user.dir")  + "/src/Resources/stormofswords.csv";

    public static void main(String[] args){

        System.out.println("=================================");
        System.out.println("Autores:");
        System.out.println("\tRafael Rodrigues dos Santos\tRA: 94075");
        System.out.println("\tRicardo Henrique Brunetto\tRA: 94182");
        System.out.println("\tThais Aparecida Camacho\t\tRA: 93807");
        System.out.println("=================================");

        System.out.print("\nDaenerys esta chegando! Lannisters nao passarao!!!\n");

        carregarGrafo(true);

        MenuOpcoes menu = new MenuOpcoes();
        menu.inicar();
    }

    public static void novoGrafo(){
        System.out.print("\nCarregar novo Grafo (deve estar no formato [String VERTICE],[String VERTICE],[int PESO]):\n");
        System.out.println("\t0 - Cancelar");
        System.out.println("\t1 - Entrada Padrao [stormofswords.csv]");
        System.out.println("\t2 - Novo arquivo de entrada");
        System.out.println("Digite uma opcao: ");
        Scanner sc = new Scanner(System.in);
        int resp = sc.nextInt();
        if(resp == 1)
            carregarGrafo(true);
        else if(resp == 0)
            return;
        else
            carregarGrafo(false );
    }

    private static void carregarGrafo(boolean stdin){
        grafo = new Grafo();
        File file;
        Scanner scanner;
        if(stdin)
            file = new File(ENTRADA_PADRAO);
        else{
            System.out.println("\nDigite o caminho do arquivo de entrada: ");
            scanner = new Scanner(System.in);
            file = new File(scanner.nextLine());
        }
        try{
            scanner = new Scanner(file);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro! Arquivo Nao encontrado!");
            return;
        }
        
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
            grafo.adicionarAresta(grafo.adicionarVertice(new Vertice(str[0].toUpperCase())), grafo.adicionarVertice(new Vertice(str[1].toUpperCase())), i);
        }
    }

}
