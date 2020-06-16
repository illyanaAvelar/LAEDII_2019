/**************************************************************
 * Prática 05 - Algoritmos e Estruturas de Dados              *
 * Implementação em JAVA do TAD MatrizAdj                     *
 * Illyana Guimarães de Avelar                                *
 * Data de Entrega: 10/05/2019                                *
 *************************************************************/
package Pratica05;
import java.io.*;

public class Pratica05 {
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
  public static void main (String[] args) throws Exception {
    System.out.print ("No. vertices:"); 
    int nVertices = Integer.parseInt (in.readLine());
    System.out.print ("No. arestas:"); 
    int nArestas = Integer.parseInt (in.readLine());
    JGrafo grafo = new JGrafo (nVertices);
    for (int i = 0; i < nArestas; i++) {
      JGrafo.Aresta a = lerAresta ();
      grafo.insereAresta (a.v1 (), a.v2 (), a.peso ());     
    //  grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
    }
    grafo.imprime ();
    
    JCiclo ciclo = new JCiclo (grafo);
    
    ciclo.buscaEmLargura();
    
    for (int v = 0; v < grafo.numVertices(); v++) {
      System.out.println ("d["+v+"]:" + ciclo.d (v) + " -- antecessor["+v+"]:" + ciclo.antecessor (v));      
    }
    ciclo.imprimeCaminho (0, 2);
    int c = ciclo.cycle();
    if(c == 1)
        System.out.println("Tem Ciclo");
    else
        System.out.println("Não Tem Ciclo");
  }
}
