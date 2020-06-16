package TrabalhoPratico02;

import java.io.*;
import java.util.*;

public class TrabalhoPratico02 {
    
  
  public static void main(String[] args) throws IOException {
    Scanner read = new Scanner(System.in);
    String l1, l2, t1, t2;
    System.out.print("Insira a montagem:");
    l1 = read.nextLine();
    l2 = read.nextLine();
    t1 = read.nextLine();
    t2 = read.nextLine();
  	
    String[] str0 = new String[12];
    String[] str1 = new String[12];
    String[] str2 = new String[12];
    String[] str3 = new String[12];
     
    ArrayList<Integer> A1 = new ArrayList<>();
    ArrayList<Integer> A2 = new ArrayList<>();
    ArrayList<Integer> T1 = new ArrayList<>();
    ArrayList<Integer> T2 = new ArrayList<>();

    int i = 0;
    str0 = l1.split(",");
    for(i=0; i < str0.length;i++)
    A1.add(Integer.parseInt(str0[i]));
    str1 = l2.split(",");
    for(i=0; i < str1.length;i++)
    A2.add(Integer.parseInt(str1[i]));
    str2 = t1.split(",");
    for(i=0; i < str2.length;i++)
    T1.add(Integer.parseInt(str2[i]));
    str3 = t2.split(",");
    for(i=0; i < str3.length;i++)
    T2.add(Integer.parseInt(str3[i]));
    
    System.out.println("A1 = " + A1);
    System.out.println("A2 = " + A2);
    System.out.println("T1 = " + T1);
    System.out.println("T1 = " + T2);
    
    System.out.println("\nDINAMICO:");
    Dinamico dinamico = new Dinamico(A1, A2, T1, T2);
    long tempoInicio = System.currentTimeMillis();
    //dinamico.caminho(0, 0, 0);
                
    System.out.println("GULOSO:");
    Guloso guloso = new Guloso(A1, A2, T1, T2);
    tempoInicio = System.currentTimeMillis();
    guloso.caminho();
    System.out.println("Tempo: "+(System.currentTimeMillis()-tempoInicio) + " milissegundos\n");
  }
}
