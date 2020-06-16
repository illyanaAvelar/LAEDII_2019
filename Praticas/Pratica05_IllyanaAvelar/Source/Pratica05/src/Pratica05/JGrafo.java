package Pratica05;

public class JGrafo{
  
  public static class Aresta{
      
    private int v1, v2, peso;
    
    public Aresta(int v1, int v2, int peso){
      this.v1 = v1; this.v2 = v2; this.peso = peso;
    }
    
    public int peso(){
        return this.peso; 
    }
    public int v1(){
        return this.v1; 
    }
    public int v2(){
        return this.v2;
    }
  }
  
  private int mat[][];     // matriz de pesos 
  private int numVertices; //quantidade de vértices
  private int pos[];       // posicao atual ao se percorrer as adjacencias de um vertice
  
  //contrutor de JGrafo
  public JGrafo (int numVertices){
    
    this.mat = new int[numVertices][numVertices];//matriz de pesos com o numero de vertices^2
    this.pos = new int[numVertices];//lista com o numero de vertices 
    this.numVertices = numVertices; //numero de vertices do grafo que será recebido
    for(int i = 0; i < this.numVertices; i++){//para cada linha da matriz e lista
      for(int j = 0; j < this.numVertices; j++)//e para cada coluna
        this.mat[i][j] = 0;//a matriz é iniciada com 0
      this.pos[i] = -1;//posicão atual recebe uma posição em que ela nunca estará ao visitar as adjacências de um vértice 
    }
  }
  
  public void insereAresta(int v1, int v2, int peso){
    this.mat[v1][v2] = peso;//insere o peso da aresta em sua respectiva posição 
  }
  
  public boolean existeAresta(int v1, int v2){
    return (this.mat[v1][v2] > 0);//retorna se o valor corresponente a aresta foi inserido
  }
  
  public boolean listaAdjVazia(int v){
    for(int i =0; i < this.numVertices; i++)//para cada vértice
      if (this.mat[v][i] > 0)//verifica se a lista está vazia 
        return false;//retorna falso caso não esteja
    return true;
  }
  
  public Aresta primeiroListaAdj(int v){
    //Retorna a primeira aresta que o vertice v participa 
    //ou null se a lista de adjacencia de v for vazia
    this.pos[v] = -1;
    return this.proxAdj(v);
  }
  
  public Aresta proxAdj(int v){
    //Retorna a proxima aresta que o vertice v participa ou
    //retorna null se a lista de adjacencia de v estiver no fim 
    this.pos[v] ++;
    while ((this.pos[v] < this.numVertices)&&(this.mat[v][this.pos[v]] == 0))
      this.pos[v]++;
    if (this.pos[v] == this.numVertices) 
      return null;
    else
      return new Aresta(v, this.pos[v], this.mat[v][this.pos[v]]);
  }
  
  public Aresta retiraAresta(int v1, int v2){
    if (this.mat[v1][v2] == 0)//caso a aresta nao exista 
      return null;//não faz nada e retorna nulo 
    else{//caso exista, realiza a remoção
      Aresta aresta = new Aresta(v1, v2, this.mat[v1][v2]);
      this.mat[v1][v2] = 0;
      return aresta;
    }
  }
  
  public void imprime(){
    System.out.print ("   ");
    for (int i = 0; i < this.numVertices; i++) 
      System.out.print (i + "   "); 
    System.out.println ();
    for (int i = 0; i < this.numVertices; i++){ 
      System.out.print (i + "  ");
      for(int j = 0; j < this.numVertices; j++)
        System.out.print (this.mat[i][j] + "   ");
      System.out.println ();
    }
  }
  
  public int numVertices(){
    return this.numVertices; 
  }
  
  public JGrafo grafoTransposto(){
    JGrafo grafoT = new JGrafo(this.numVertices); 
    for(int v = 0; v < this.numVertices; v++)
      if(!this.listaAdjVazia (v)){
        Aresta adj = this.primeiroListaAdj (v);
        while (adj != null){
          grafoT.insereAresta(adj.v2 (), adj.v1 (), adj.peso ());
          adj = this.proxAdj (v);
        }
      }
    return grafoT;
  }
}
