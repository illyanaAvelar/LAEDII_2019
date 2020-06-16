package TrabalhoPratico03;

public class ForcaBruta { 
    public int V; 
    private int color[]; 
    private int cores = 1;
    private int cor[] = new int[9999];
    private int l = 1;
    private int k = 0;
  
    //verifica se a cor atual pode ser usada no vertice
    boolean disponivel(int v, int graph[][], int color[], int c){ 
        for (int i = 0; i < V; i++) 
            if (graph[v][i] == 1 && c == color[i]) 
                return false; 
        return true; 
    } 
  
    //funcao recursiva para coloracao
    boolean colorir(int graph[][], int m, int color[], int v){ 
        //retorna quando todos os vertices forem coloridos
        if (v == V) 
            return true; 
  
        //testa diferentes cores 
        for (int c = 1; c <= m; c++){ 
            //checa se é possível atribuir a cor ao vertice
            if (disponivel(v, graph, color, c)){ 
                color[v] = c; 
  
                //chamada recursiva
                if (colorir(graph, m, color, v + 1)) 
                    return true; 
  
                //remove a cor se ela nao levar a solucao
                color[v] = 0; 
            } 
        } 
  
        //se nenhuma cor pode ser atribuida
        return false; 
    } 
  
    boolean naive(int graph[][], int m){ 
        //inicializa as cores 
        color = new int[V]; 
        for (int i = 0; i < V; i++) 
            color[i] = 0; 
  
        //chama colorir para o vertice 0 
        if (!colorir(graph, m, color, 0)){ 
            System.out.println("não há solucação"); 
            return false; 
        } 
  
        //imprime a solucao 
        imprime(color); 
        return true; 
    } 
  
    //funcao para imprimir a solucao
    void imprime(int color[]){ 
        System.out.println("Cores usadas:"); 
        cor[0] = 1;
        for (int i = 0; i < V; i++) {
            
            k = 1;
            for(int j = 0; j <= l; j++){
               if (color[i] == cor[j])
               k = 0;  
            }
            if(k==1){
                cores++;
                cor[l] = color[i];
                l++;
            }
            System.out.print(" " + color[i] + " "); 
        }
        System.out.println();
        System.out.println("Numero cromatico " + cores); 
    } 
} 

