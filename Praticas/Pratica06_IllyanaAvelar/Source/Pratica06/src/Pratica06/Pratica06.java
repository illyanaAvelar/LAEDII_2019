package Pratica06;
import java.io.*;
import java.util.*;

public class Pratica06{
  
  private static class Aresta{
    public int v1;
    public int v2;
    public int peso;
        
    public Aresta(int v1,int v2,int peso){
      this.v1 = v1;
      this.v2 = v2;
      this.peso = peso;
    }
  }
  
  public static void main(String[] args) {
        
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.print("Numero do Grafo::");
    n = scan.nextInt();
    ArrayList<Aresta> arestas = new ArrayList<Aresta>();
    int maxVertice = 0;

      for(int i = 0; i < n; i ++){
        System.out.println("V1:");
        int v1 = scan.nextInt();
        System.out.println("V1:");
        int v2 = scan.nextInt();
        System.out.println("Peso:");
        int c  = scan.nextInt();
        if (v1>maxVertice) maxVertice = v1;
        if (v2>maxVertice) maxVertice = v2;
        Aresta a = new Aresta(v1,v2,c);
        arestas.add(a);
      }
        
      JGrafo grafo = new JGrafo(maxVertice+1);
      //insere as arestas duas vezes por não ser direcionado   
      for (Aresta a : arestas) {
        grafo.insereAresta(a.v1, a.v2, a.peso);
        grafo.insereAresta(a.v2, a.v1, a.peso);
      }
      JAGM agm = new JAGM(grafo);
       
      //Tenta obter a AGM
        try{agm.obterAgm(0);}
        catch(Exception e){
          System.out.println("ERRO!");
          return;
        } 
        
        agm.imprime();
        System.out.println("Peso da AGM: "+agm.total());
    } 
}
