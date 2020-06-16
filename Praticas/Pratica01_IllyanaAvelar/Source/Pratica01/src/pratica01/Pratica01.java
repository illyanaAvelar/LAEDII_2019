/**************************************************************
 * Prática 01 - Algoritmos e Estruturas de Dados              *
 * Implementação em JAVA do TAD Árvore Binária de Pesquisa    *
 * Illyana Guimarães de Avelar                                *
 * Data de Entrega: 22/03/2019                                *
 *************************************************************/

package pratica01;
import java.io.*;
import java.util.*;
/*Função para criar e testar as árvores*/
public class Pratica01 {

  public static void main (String[] args) throws Exception {
    
    Item i1, i2;//Itens para preencher as árvores
    Item rand = new Item(9501);//Item não existente na árvoere (que será usado para a busca)         
    ArvoreBinaria[] ordered = new ArvoreBinaria [9];//Árvore que terá os ítens ordenados
    ArvoreBinaria[] random = new ArvoreBinaria [9];//Árvore que terá os ítens aleatórios
    
    /*Cria as nove árvores ordenadas*/
    for(int i = 0; i < 9; i++){
      ordered[i] = new ArvoreBinaria();
    }
    /*Cria as nove árvores não ordenadas*/
    for(int i = 0; i < 9; i++){
      random[i] = new ArvoreBinaria();
    }
    
    /*Cria uma lista de números*/
    List<Integer> num = new ArrayList<Integer>();
    for (int i = 1; i < 9500; i++) { 
        num.add(i);
    }
    /*embaralha os números da lista criada acima*/
    Collections.shuffle(num);
    
    /*preenche as duas árvores*/
    for(int count = 0; count <9000; count++){
      i1 = new Item(count); //itens ordenados
      i2 = new Item(num.get(count)); //itens aleatórios
      if(count<9000){//preenche a posição 8 com 9000 números
       ordered[8].insere(i1);
       random[8].insere(i2); 
       if(count<8000){//preenche a posição 7 com 8000 números... 
        ordered[7].insere(i1);
        random[7].insere(i2); 
        if(count<7000){
          ordered[6].insere(i1);
          random[6].insere(i2);
          if(count<6000){
            ordered[5].insere(i1);
            random[5].insere(i2);
            if(count<5000){
              ordered[4].insere(i1);
              random[4].insere(i2);
              if(count<4000){   
                ordered[3].insere(i1);
                random[3].insere(i2);
                if(count<3000){
                  ordered[2].insere(i1);
                  random[2].insere(i2);
                  if(count<2000){
                    ordered[1].insere(i1);
                    random[1].insere(i2);
                    if(count<1000){
                      ordered[0].insere(i1);
                      random[0].insere(i2);
                    }}}}}}}}}
    }
    System.out.println("Árvores Preenchidas\n");
  
    /*Loop que faz a busca nas 9 árvores ordenadas*/
    for(int i = 0; i < 9; i ++){    
    
      ArvoreBinaria.comp = 0;//zera a variável que conta as comparações
      double timeI = System.nanoTime();//armazena o tempo inicial
      ordered[i].pesquisa(rand);//faz a busca
      double timeF = System.nanoTime();//armazena o tempo final
      double timeT = timeF - timeI;//calcula o tempo total da ordenação
      System.out.println("Arvore Ordenada " + i);
      System.out.println("Tempo: " + timeT);
      System.out.println("Comparaçoes: " + ArvoreBinaria.comp + "\n");
      
    }
    
    /*Loop que faz a busca nas 9 árvores de ordem aleatória*/
    for(int i = 0; i < 9; i ++){    
      
      ArvoreBinaria.comp = 0;//zera a variável que conta as comparações
      double timeI = System.nanoTime();//armazena o tempo inicial 
      random[i].pesquisa(rand);//faz a busca
      double timeF = System.nanoTime();//armazena o tempo final
      double timeT = timeF - timeI;//calcula o tempo total da ordenação
      System.out.println("Arvore Aleatoria " + i);
      System.out.println("Tempo: " + timeT);
      System.out.println("Comparaçoes: " + ArvoreBinaria.comp + "\n");
      
    }
  }
}