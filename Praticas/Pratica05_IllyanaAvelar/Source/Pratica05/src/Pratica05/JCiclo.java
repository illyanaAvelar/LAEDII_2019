package Pratica05;
import java.util.*;

public class JCiclo {
  private ArrayList<Integer> path;//caminho percorrido no grafo
  private int cycle = 0;//variável para controlar a existência ou não de ciclos  
  public static final byte branco = 0;//não foi visitado
  public static final byte cinza  = 1;//foi visitado
  public static final byte preto  = 2;//não está na fila
  private int d[], antecessor[];
  private JGrafo grafo;//instância de um grafo
  
  //metódo contrutor de JCiclo
  public JCiclo (JGrafo grafo){
    this.grafo = grafo;
    int n = this.grafo.numVertices();
    this.d = new int[n];
    this.antecessor = new int[n];
  }
  
  //Percorre todo o grafo até que não hajam elementos na fila
  private void visitaBfs (int u, int cor[]) throws Exception {
    cor[u] = cinza;//vertice foi visitado
    this.d[u] = 0;
    path.add(u);//adiciona o vértice u ao caminho 
    Fila fila = new Fila();//cria uma nova fila
    fila.enfileira(new Integer (u));//enfilera o vértice que será visitado

    while (!fila.vazia ()){
     
      Integer aux = (Integer)fila.desenfileira();//retira um item para percorre-lo
      u = aux.intValue();//u recebe o item retirado da fila 
      if(!this.grafo.listaAdjVazia(u)){//enquanto a lista de adjacência não estiver vazia
        JGrafo.Aresta a = this.grafo.primeiroListaAdj(u);//a recebe o primeiro item da lista
        
        while(a != null){//enquanto houverem adjacências
          for(int i : path){//para cada item do caminho
            if(i==a.v2())//se ha um ciclo na lista 
              this.cycle = 1;//então cycle é alterada
          }      
          int v = a.v2();
          if(cor[v] == branco){//se o vértice não foi percorrido ainda
            cor[v] = cinza;//ele será nesse momento então recebe a cor cinza
            this.d[v] = this.d[u] + 1;
            this.antecessor[v] = u;
            fila.enfileira(new Integer (v));
          }
          a = this.grafo.proxAdj (u);
        }
      }
      path.remove(path.size()-1);//remove os vertices do caminho 
      cor[u] = preto;//depois de percorrer todas as adjacências do vértice, a cor muda para preto

    }
  }
  //realiza a busca em largura
  public void buscaEmLargura () throws Exception {
    int cor[] = new int[this.grafo.numVertices ()];//vetor de cores com a quantidade de vertices 
    for (int u = 0; u < grafo.numVertices (); u++){//para cada vértice
      cor[u] = branco; this.d[u] = Integer.MAX_VALUE;//inicia com nenhum vértice visitado 
      this.antecessor[u] = -1;
    }  
    //para todos os vértices
    for (int u = 0; u < grafo.numVertices (); u++){
      this.path = new ArrayList<Integer>();//cria um vetor para o caminho
      if (cor[u] == branco) this.visitaBfs (u, cor);//se ainda não foi visitado,
      //é mandado para o método que visita os vértices
    }
  }
  
  public int d (int v){
    return this.d[v];
  }
  
  public int antecessor(int v){
    return this.antecessor[v]; 
  }  
  
  public void imprimeCaminho(int origem, int v){
    if(origem == v)
      System.out.println (origem);
    else if(this.antecessor[v] == -1) 
      System.out.println ("Nao existe caminho de " + origem + " ate " + v);
    else{
      imprimeCaminho(origem, this.antecessor[v]);
      System.out.println (v);
    }    
  }
  //retorna o valor de cycle que será usado na main para verificar se existe ciclo
  public int cycle(){
    return this.cycle();
  } 
}