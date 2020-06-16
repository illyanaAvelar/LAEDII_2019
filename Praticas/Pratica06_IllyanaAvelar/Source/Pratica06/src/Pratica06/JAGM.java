package Pratica06;
public class JAGM {
  private int antecessor[];
  private double p[];
  private JGrafo grafo;

  public JAGM (JGrafo grafo){
    this.grafo = grafo; 
  }  
  public void obterAgm(int raiz)throws Exception{
    int n = this.grafo.numVertices();//quantidade de vertices
    this.p = new double[n];//peso de vertices
    int vs[] = new int[n+1];//vertices
    boolean itensHeap[] = new boolean[n];
    this.antecessor = new int[n];
    for (int u = 0; u < n; u ++){
      this.antecessor[u] = -1;
      p[u] = Double.MAX_VALUE;//infinito
      vs[u+1] = u;//Heap indireto a ser construido
      itensHeap[u] = true;
    }
    p[raiz] = 0;
    JHeap heap = new JHeap (p, vs);//instancia heap 
    heap.constroi();//controi heap
    while (!heap.vazio ()){//enquanto houverem elementos
      int u = heap.retiraMin();//retira o menor caminho
      itensHeap[u] = false;
      if (!this.grafo.listaAdjVazia(u)){//se há elementos na lista de adjacência
        JGrafo.Aresta adj = grafo.primeiroListaAdj(u);
        while (adj != null) {
          int v = adj.v2 ();
          if (itensHeap[v] && (adj.peso () < this.peso (v))) {
            antecessor[v] = u; heap.diminuiChave (v, adj.peso ());
          }
          adj = grafo.proxAdj (u);
        }
      }
    }
  }
  public int antecessor(int u){
    return this.antecessor[u]; 
  }
  public double peso(int u){
    return this.p[u]; 
  }
  public void imprime(){
    for (int u = 0; u < this.p.length; u++)
      if (this.antecessor[u] != -1) 
        System.out.println ("(" +antecessor[u]+ "," +u+ ") -- p:" + peso (u));
  }
  //calcula a soma dos valores das arestas da AGM
  public double total(){
      double total = 0;
      for(double i : this.p)
          if(i!=Double.MAX_VALUE)
              total = total + i;
      return total;
  }
}
