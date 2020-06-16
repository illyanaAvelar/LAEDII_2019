package TrabalhoPratico03;

import java.io.*; 
import java.util.*; 
//classe que implementa um grafo nao direcionado e uma heuristica para encontrar seu numero cromatico 
public class Heuristica{ 
    private int V;
    private int ncr = 0;
    private LinkedList<Integer> adj[];//lista de adjacencia 

    Heuristica(int a){ 
        V = a; 
	adj = new LinkedList[a]; 
	for (int i=0; i<a; ++i) 
            adj[i] = new LinkedList(); 
    } 

    //adiciona um vertice ao grafo 
    void novaAresta(int v,int w){ 
        //adiciona nos dois sentidos pois o grafo e nao direcionado
        adj[v].add(w); 
	adj[w].add(v); 
    } 

    //heuristica para numero cromatico 
    void guloso(){ 
	int cores[] = new int[V]; 
        // inicializa os vertices 
	Arrays.fill(cores, -1); 
        //adiciona a primeira cor (0) ao primeiro vertice 
	cores[0] = 0; 
	//a disponibilidade das cores e armazenada em um array 
	boolean disponivel[] = new boolean[V]; 
	//preenche todo o array como disponivel pois inicialmente nenhuma cor esta indisponivel 
	Arrays.fill(disponivel, true); 
	//distribui as cores para os vertices, comecando do 1 pois 0 ja foi preenchido 
	//para todos os vertices do grafo
        for (int u = 1; u < V; u++){ 
	    //todas as cores de vertices adjacentes se tornam indisponiveis 
	    Iterator<Integer> it = adj[u].iterator() ; 
            //enquanto houver adjacencias
            while (it.hasNext()){ 
		int i = it.next(); 
                if (cores[i] != -1) 
		disponivel[cores[i]] = false; 
	    } 

	    //encontra a proxima cor disponivel 
            int cr; 
            for (cr = 0; cr < V; cr++){
                //se estiver marcada com disponivel encerra o loop
            	if(cr > ncr)
                    ncr = cr;
                if (disponivel[cr])
                    break;
            } 
            //atribui a cor encontrada acima
            cores[u] = cr; 
            //Reseta os valores para a proxima iteracao 
            Arrays.fill(disponivel, true); 
	} 

	//improme as cores 
	//for (int u = 0; u < V; u++){ 
        //    System.out.println("Vertex " + u + " ---> Color "+ cores[u]); 
        //}
        ncr++;
        System.out.println("Numero cromatico: "+ncr);
    } 
} 

