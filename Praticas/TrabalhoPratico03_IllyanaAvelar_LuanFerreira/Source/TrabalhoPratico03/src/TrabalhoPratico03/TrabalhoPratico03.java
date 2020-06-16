/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* Trabalho Pratico 03 - Laboratorio de Algoritmos e Estruturas de DadosII  *
*      Força Bruta e Heurística para Coloração de Vértices em Grafos       *
*           Illyana Guimarães Avelar _ Luan Ferreira de Almeida            *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package TrabalhoPratico03;
import java.util.*;

public class TrabalhoPratico03 {

   
    public static void main(String args[]){
	int V1, V2;
        Scanner read = new Scanner(System.in);
        int vertices = read.nextInt();
        int arestas = read.nextInt();
        Heuristica grafoH = new Heuristica(arestas); 
	for(int i = 0; i < arestas; i++){
            V1 = read.nextInt();
            V2 = read.nextInt();
            grafoH.novaAresta(V1, V2);
        }
	grafoH.guloso(); 
/*
        for (int i = 0; i < 10; i++){
            Scanner read = new Scanner(System.in);
            int vertices = read.nextInt();
            ForcaBruta grafoF = new ForcaBruta(); 
            GerarGrafo grafo = new GerarGrafo(vertices);
            int graph[][] = grafo.grafo;
            int m = 999999; // Number of colors 
            grafoF.V = vertices;
            long tempoInicial = System.currentTimeMillis();
            grafoF.naive(graph, m);
            System.out.println();
            System.out.println("Tempo de Execução: " + (System.currentTimeMillis() - tempoInicial));
            System.out.println();

        }
    */}
}
