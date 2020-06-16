package Pratica07;
import java.io.*;
public class Pratica07 {
  static BufferedReader in = new BufferedReader (
                             new InputStreamReader (System.in));
  public static JGrafo.Aresta lerAresta () throws Exception {
    System.out.println ("Aresta:");
    System.out.print ("  V1:");
    int v1 = Integer.parseInt (in.readLine());
    System.out.print ("  V2:");
    int v2 = Integer.parseInt (in.readLine());
    System.out.print ("  Peso:");
    int peso = Integer.parseInt (in.readLine());
    return new JGrafo.Aresta (v1, v2, peso);
  }
  public static JGrafo.Aresta lerAresta (int u, int v, int p) {
    int v1 = u, v2 = v, peso = p;
    return new JGrafo.Aresta (v1, v2, peso);
  }

  public static void main (String[] args) throws Exception {
    System.out.print ("No. vertices:"); 
    int nVertices = Integer.parseInt (in.readLine());
    System.out.print ("No. arestas:"); 
    int nArestas = Integer.parseInt (in.readLine());
    System.out.print ("Raiz da ACMC:"); 
    int raiz = Integer.parseInt (in.readLine());
    JGrafo grafo = new JGrafo (nVertices);
    for (int i = 0; i < nArestas; i++) {
      JGrafo.Aresta a = lerAresta ();
      grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
    }
    grafo.imprime ();
    JAEDsMaps dj = new JAEDsMaps (grafo);
    dj.obterArvoreCMC (raiz);
    dj.imprime ();
    dj.imprimeCaminho (0, 2);
  }
  
}

