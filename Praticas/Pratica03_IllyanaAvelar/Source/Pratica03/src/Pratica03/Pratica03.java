/**************************************************************
 * Prática 03 - Algoritmos e Estruturas de Dados              *
 * Implementação em JAVA do TAD Arvore B                      *
 * Illyana Guimarães de Avelar                                *
 * Data de Entrega: 05/04/2019                                *
 *************************************************************/

package Pratica03;
import Item.Item;
import java.io.*;
import java.util.*;
/*Função para criar e testar as árvores*/
public class Pratica03 {

  public static void main (String[] args) throws Exception {
 
    int ordem;
    Scanner sc = new Scanner(System.in);   
    System.out.println("Insira a ordem da Arvore B:");
    ordem = sc.nextInt();
    Item i1, i2;//Itens para preencher as árvores
    Item rand = new Item(106000);//Item não existente na árvoere (que será usado para a busca)         
    ArvoreB[] ordered = new ArvoreB [10];//ÁrvoreB que terá os ítens ordenados
    ArvoreB[] random = new ArvoreB [10];//ÁrvoreB que terá os ítens aleatórios
    ArvoreSBB[] orderedS = new ArvoreSBB [10];//ÁrvoreSBB que terá os ítens ordenados
    ArvoreSBB[] randomS = new ArvoreSBB [10];//ÁrvoreSBB que terá os ítens aleatórios
    
    /*Cria as dez árvores B ordenadas*/
    for(int i = 0; i < 10; i++){
      ordered[i] = new ArvoreB(ordem);
    }
    /*Cria as dez árvores B não ordenadas*/
    for(int i = 0; i < 10; i++){
      random[i] = new ArvoreB(ordem);
    }
   
    /*Cria as dez árvores SBB ordenadas*/
    for(int i = 0; i < 10; i++){
      orderedS[i] = new ArvoreSBB();
    }
    /*Cria as dez árvores SBB não ordenadas*/
    for(int i = 0; i < 10; i++){
      randomS[i] = new ArvoreSBB();
    }
    
    /*Cria uma lista de números*/
    List<Integer> num = new ArrayList<Integer>();
    for (int i = 1; i < 105000; i++) { 
        num.add(i);
    }
    /*embaralha os números da lista criada acima*/
    Collections.shuffle(num);
    
    /*preenche as duas árvores B*/
    for(int count = 0; count <100000; count++){
     i1 = new Item(count); //itens ordenados
     i2 = new Item(num.get(count)); //itens aleatórios
     if(count<100000){
      ordered[9].insere(i1);
      random[9].insere(i2); 
      if(count<90000){
       ordered[8].insere(i1);
       random[8].insere(i2); 
       if(count<80000){
        ordered[7].insere(i1);
        random[7].insere(i2); 
        if(count<70000){
          ordered[6].insere(i1);
          random[6].insere(i2);
          if(count<60000){
            ordered[5].insere(i1);
            random[5].insere(i2);
            if(count<50000){
              ordered[4].insere(i1);
              random[4].insere(i2);
              if(count<40000){   
                ordered[3].insere(i1);
                random[3].insere(i2);
                if(count<30000){
                  ordered[2].insere(i1);
                  random[2].insere(i2);
                  if(count<20000){
                    ordered[1].insere(i1);
                    random[1].insere(i2);
                    if(count<10000){
                      ordered[0].insere(i1);
                      random[0].insere(i2);
                    }}}}}}}}}}
    }
    System.out.println("Árvores B Preenchidas\n");
  
   /*preenche as duas árvores SBB*/
    for(int count = 0; count <100000; count++){
     i1 = new Item(count); //itens ordenados
     i2 = new Item(num.get(count)); //itens aleatórios
     if(count<100000){
      orderedS[9].insere(i1);
      randomS[9].insere(i2); 
      if(count<90000){
       orderedS[8].insere(i1);
       randomS[8].insere(i2); 
       if(count<80000){
        orderedS[7].insere(i1);
        randomS[7].insere(i2); 
        if(count<70000){
          orderedS[6].insere(i1);
          randomS[6].insere(i2);
          if(count<60000){
            orderedS[5].insere(i1);
            randomS[5].insere(i2);
            if(count<50000){
              orderedS[4].insere(i1);
              randomS[4].insere(i2);
              if(count<40000){   
                orderedS[3].insere(i1);
                randomS[3].insere(i2);
                if(count<30000){
                  orderedS[2].insere(i1);
                  randomS[2].insere(i2);
                  if(count<20000){
                    orderedS[1].insere(i1);
                    randomS[1].insere(i2);
                    if(count<10000){
                      orderedS[0].insere(i1);
                      randomS[0].insere(i2);
                    }}}}}}}}}}
    }
    System.out.println("Árvores SBB Preenchidas\n");
    
    /*Loop que faz a busca nas 10 árvores B ordenadas*/
    for(int i = 0; i < 10; i ++){    
    
      ArvoreB.comp = 0;//zera a variável que conta as comparações
      ArvoreB.pag = 0;//zera a variável que conta as paginas
      double timeI = System.nanoTime();//armazena o tempo inicial
      ordered[i].pesquisa(rand);//faz a busca
      double timeF = System.nanoTime();//armazena o tempo final
      double timeT = timeF - timeI;//calcula o tempo total da ordenação
      System.out.println("Arvore B Ordenada " + i);
      System.out.println("Tempo: " + timeT);
      System.out.println("Páginas: " + ArvoreB.pag + "\n");
      System.out.println("Comparaçoes: " + ArvoreB.comp + "\n");
      
    }
    
    /*Loop que faz a busca nas 10 árvores B de ordem aleatória*/
    for(int i = 0; i < 10; i ++){    
      
      ArvoreB.comp = 0;//zera a variável que conta as comparações
      ArvoreB.pag = 0;//zera a variável que conta as paginas
      double timeI = System.nanoTime();//armazena o tempo inicial 
      random[i].pesquisa(rand);//faz a busca
      double timeF = System.nanoTime();//armazena o tempo final
      double timeT = timeF - timeI;//calcula o tempo total da ordenação
      System.out.println("Arvore B Aleatoria " + i);
      System.out.println("Tempo: " + timeT);
      System.out.println("Páginas: " + ArvoreB.pag + "\n");
      System.out.println("Comparaçoes: " + ArvoreB.comp + "\n");
      
    }
    
     /*Loop que faz a busca nas 10 árvores SBB ordenadas*/
    for(int i = 0; i < 10; i ++){    
    
      ArvoreSBB.comp = 0;//zera a variável que conta as comparações
      double timeI = System.nanoTime();//armazena o tempo inicial
      orderedS[i].pesquisa(rand);//faz a busca
      double timeF = System.nanoTime();//armazena o tempo final
      double timeT = timeF - timeI;//calcula o tempo total da ordenação
      System.out.println("Arvore SBB Ordenada " + i);
      System.out.println("Tempo: " + timeT);
      System.out.println("Comparaçoes: " + ArvoreSBB.comp + "\n");
      
    }
    
    /*Loop que faz a busca nas 10 árvores SBB de ordem aleatória*/
    for(int i = 0; i < 10; i ++){    
      
      ArvoreSBB.comp = 0;//zera a variável que conta as comparações
      double timeI = System.nanoTime();//armazena o tempo inicial 
      randomS[i].pesquisa(rand);//faz a busca
      double timeF = System.nanoTime();//armazena o tempo final
      double timeT = timeF - timeI;//calcula o tempo total da ordenação
      System.out.println("Arvore SBB Aleatoria " + i);
      System.out.println("Tempo: " + timeT);
      System.out.println("Comparaçoes: " + ArvoreSBB.comp + "\n");
      
    }
    
  }
}   