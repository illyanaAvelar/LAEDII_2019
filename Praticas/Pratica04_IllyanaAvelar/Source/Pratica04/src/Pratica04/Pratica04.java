/**************************************************************
 * Prática 04 - Algoritmos e Estruturas de Dados              *
 * Implementação em JAVA do TAD Heap                          *
 * Illyana Guimarães de Avelar                                *
 * Data de Entrega: 10/04/2019                                *
 *************************************************************/

/*As implementaçoes de Heap foram baseadas nas do livro Projetos de Algoritmos - Nivio Ziviani*/
/*http://www2.dcc.ufmg.br/livros/algoritmos-java/implementacoes.php*/
package Pratica04;
import Item.Item;
import java.util.*;
public class Pratica04 {
public static void main(String[] args){
    Item a, d, r;//Itens que serao inseridos nos Heaps
        /////////////Crescentes/////////////
        Item[] ascending10 = new Item[10000];
        Item[] ascending20 = new Item[20000];
        Item[] ascending30 = new Item[30000];
        Item[] ascending40 = new Item[40000];
        Item[] ascending50 = new Item[50000];
        Item[] ascending60 = new Item[60000];
        Item[] ascending70 = new Item[70000];
        Item[] ascending80 = new Item[80000];
        Item[] ascending90 = new Item[90000];
       Item[] ascending100 = new Item[100000];
        ///////////Descrescentes/////////////
        Item[] descending10 = new Item[10000];
        Item[] descending20 = new Item[20000];
        Item[] descending30 = new Item[30000];
        Item[] descending40 = new Item[40000];
        Item[] descending50 = new Item[50000];
        Item[] descending60 = new Item[60000];
        Item[] descending70 = new Item[70000];
        Item[] descending80 = new Item[80000];
        Item[] descending90 = new Item[90000];
       Item[] descending100 = new Item[100000];
        /////////////Aleatorios//////////////
          Item[] random10 = new Item[10000];
          Item[] random20 = new Item[20000];
          Item[] random30 = new Item[30000];
          Item[] random40 = new Item[40000];
          Item[] random50 = new Item[50000];
          Item[] random60 = new Item[60000];
          Item[] random70 = new Item[70000];
          Item[] random80 = new Item[80000];
          Item[] random90 = new Item[90000];
         Item[] random100 = new Item[100000];
    
      //Gera numeros aleatorios sem repeticao e os embaralha
      //http://www.guj.com.br/t/resolvido-como-gerar-numeros-aleatorios-sem-repeticao/74652/4  
      List<Integer> numeros = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            numeros.add(i);
        }
      Collections.shuffle(numeros);
      
      //laço que preenche os heaps 
      for(int i = 0; i < 100000; i++){
          r = new Item(numeros.get(i));
          a = new Item(i);
          d = new Item(i);
          //com 100000 Itens
          random100[i] = r;
          ascending100[i] = a;
          descending100[99999-i] = d;
          //com 90000 Itens
          if(i<90000){
          random90[i] = r;
          ascending90[i] = a;
          descending90[89999-i] = d;
          }//com 80000 Itens
          if(i<80000){
          random80[i] = r;
          ascending80[i] = a;
          descending80[79999-i] = d;
          }//com 70000 Itens
          if(i<70000){
          random70[i] = r;
          ascending70[i] = a;
          descending70[69999-i] = d;
          }//com 60000 Itens
          if(i<60000){
          random60[i] = r;
          ascending60[i] = a;
          descending60[59999-i] = d;
          }//com 50000 Itens
          if(i<50000){
          random50[i] = r;
          ascending50[i] = a;
          descending50[49999-i] = d;
          }//com 40000 Itens
          if(i<40000){
          random40[i] = r;
          ascending40[i] = a;
          descending40[39999-i] = d;
          }//com 30000 Itens
          if(i<30000){
          random30[i] = r;
          ascending30[i] = a;
          descending30[29999-i] = d;
          }//com 20000 Itens
          if(i<20000){
          random20[i] = r;
          ascending20[i] = a;
          descending20[19999-i] = d;
          }//com 10000 Itens
          if(i<10000){
          random10[i] = r;
          ascending10[i] = a;
          descending10[9999-i] = d;
          }
      }
      System.out.println("Heaps preenchidos!");
      System.out.println();
    /*Realiza as comparaçoes e imprime a quantidade para cada vetor de ordem aleatória*/  
    JHeapSort h;
    h = new JHeapSort(random10, 9999);
    System.out.println("Comparaçoes Heap Aleatorio 10000 Itens: " + h.jcomp);
    h = new JHeapSort(random20, 19999);
    System.out.println("Comparaçoes Heap Aleatorio 20000 Itens: " + h.jcomp);
    h = new JHeapSort(random30, 29999);
    System.out.println("Comparaçoes Heap Aleatorio 30000 Itens: " + h.jcomp);
    h = new JHeapSort(random40, 39999);
    System.out.println("Comparaçoes Heap Aleatorio 40000 Itens: " + h.jcomp);
    h = new JHeapSort(random50, 49999);
    System.out.println("Comparaçoes Heap Aleatorio 50000 Itens: " + h.jcomp);
    h = new JHeapSort(random60, 59999);
    System.out.println("Comparaçoes Heap Aleatorio 60000 Itens: " + h.jcomp);
    h = new JHeapSort(random70, 69999);
    System.out.println("Comparaçoes Heap Aleatorio 70000 Itens: " + h.jcomp);
    h = new JHeapSort(random80, 79999);
    System.out.println("Comparaçoes Heap Aleatorio 80000 Itens: " + h.jcomp);
    h = new JHeapSort(random90, 89999);
    System.out.println("Comparaçoes Heap Aleatorio 90000 Itens: " + h.jcomp);
    h = new JHeapSort(random100, 99999);
    System.out.println("Comparaçoes Heap Aleatorio 100000 Itens: " + h.jcomp);
    System.out.println();

    /*Realiza as comparaçoes e imprime a quantidade para cada vetor de ordem crescente*/
    h = new JHeapSort(ascending10, 9999);
    System.out.println("Comparaçoes Heap Crescente 10000 Itens: " + h.jcomp);
    h = new JHeapSort(ascending20, 19999);
    System.out.println("Comparaçoes Heap Crescente 20000 Itens: " + h.jcomp);
    h = new JHeapSort(ascending30, 29999);
    System.out.println("Comparaçoes Heap Crescente 30000 Itens: " + h.jcomp);
    h = new JHeapSort(ascending40, 39999);
    System.out.println("Comparaçoes Heap Crescente 40000 Itens: " + h.jcomp);
    h = new JHeapSort(ascending50, 49999);
    System.out.println("Comparaçoes Heap Crescente 50000 Itens: " + h.jcomp);
    h = new JHeapSort(ascending60, 59999);
    System.out.println("Comparaçoes Heap Crescente 60000 Itens: " + h.jcomp);
    h = new JHeapSort(ascending70, 69999);
    System.out.println("Comparaçoes Heap Crescente 70000 Itens: " + h.jcomp);
    h = new JHeapSort(ascending80, 79999);
    System.out.println("Comparaçoes Heap Crescente 80000 Itens: " + h.jcomp);
    h = new JHeapSort(ascending90, 89999);
    System.out.println("Comparaçoes Heap Crescente 90000 Itens: " + h.jcomp);
    h = new JHeapSort(ascending100, 99999);
    System.out.println("Comparaçoes Heap Crescente 100000 Itens: " + h.jcomp);
    System.out.println();
    
    /*Realiza as comparaçoes e imprime a quantidade para cada vetor de ordem decrescente*/
    System.out.println("Comparaçoes Heap Decrescente 10000 Itens: " + h.jcomp);
    h = new JHeapSort(descending10, 9999);
    System.out.println("Comparaçoes Heap Decrescente 20000 Itens: " + h.jcomp);
    h = new JHeapSort(descending20, 19999);
    System.out.println("Comparaçoes Heap Decrescente 30000 Itens: " + h.jcomp);
    h = new JHeapSort(descending30, 29999);
    System.out.println("Comparaçoes Heap Decrescente 40000 Itens: " + h.jcomp);
    h = new JHeapSort(descending40, 39999);
    System.out.println("Comparaçoes Heap Decrescente 50000 Itens: " + h.jcomp);
    h = new JHeapSort(descending50, 49999);
    System.out.println("Comparaçoes Heap Decrescente 60000 Itens: " + h.jcomp);
    h = new JHeapSort(descending60, 59999);
    System.out.println("Comparaçoes Heap Decrescente 70000 Itens: " + h.jcomp);
    h = new JHeapSort(descending70, 69999);
    System.out.println("Comparaçoes Heap Decrescente 80000 Itens: " + h.jcomp);
    h = new JHeapSort(descending80, 79999);
    System.out.println("Comparaçoes Heap Decrescente 90000 Itens: " + h.jcomp);
    h = new JHeapSort(descending90, 89999);
    System.out.println("Comparaçoes Heap Decrescente 100000 Itens: " + h.jcomp);
    h = new JHeapSort(descending100, 99999);
    System.out.println();
    
    }
    
}
