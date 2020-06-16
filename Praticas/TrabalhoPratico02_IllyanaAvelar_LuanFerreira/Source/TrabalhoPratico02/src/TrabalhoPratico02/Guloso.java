package TrabalhoPratico02;

import java.io.*;
import java.util.*;

public class Guloso {
  private ArrayList<Integer> A1 = new ArrayList();
  private ArrayList<Integer> A2 = new ArrayList();
  private ArrayList<Integer> T1 = new ArrayList();
  private ArrayList<Integer> T2 = new ArrayList();
  private ArrayList<String> Path = new ArrayList();
  private int lv = 0;
 
  public Guloso(ArrayList A1, ArrayList A2, ArrayList T1, ArrayList T2) throws IOException{
  
    this.A1 = A1;
    this.A2 = A2;
    this.T1 = T1;
    this.T2 = T2;
  }

  public void caminho(){
    //enquanto houverem elementos antes do final da linha
    for(int i=0; i < A1.size()-2; i++){
      if(i==0){//1a
        //se a linha um formar um caminho menor que a linha 2, o caminho formado por ela é adicionado ao caminho final  
        if((A1.get(0) + A1.get(1)) <= (A2.get(0) + A2.get(1))){
          Path.add(Integer.toString(A1.get(0)));
          Path.add(Integer.toString(A1.get(1)));
          lv = 1;
        }
        else{
          //senão o caminho formado pela linha 2 é escolhido
          lv = -1;
          Path.add(Integer.toString(A2.get(0)));
          Path.add(Integer.toString(A2.get(1)));
        }
      }
        else//2a
          //se estiver no meio da linha
          if(i > 0 && i < A1.size()-3){ 
            if(lv==1){
              //se passar pela primeira linha for mais rápido que descer para a segunda
              if(A1.get(i+1) <= (T1.get(i-1) + A2.get(i+1))){
                //o caminho continua por ela
                Path.add(Integer.toString(A1.get(i+1)));
              }
              else{
                //senão desce para a linha de baixo
                lv = -1;
                //para identificar quando desce para a linha de baixo o array terá um \n
                Path.add("\n" + Integer.toString(T1.get(i-1)));
                //adiciona a linha de baixo ao caminho final
                Path.add(Integer.toString(A2.get(i+1)));
              }
                  
            }
            else{//3a
              //se continuar na segunda linha gastar menos tempo  
              if(A2.get(i+1) <= (T2.get(i-1) + A1.get(i+1))){
                //adicionamos o próximo da segunda linha ao caminho final  
                Path.add(Integer.toString(A2.get(i+1)));
              }
              else{
                //senão subimos para a linha 1
                lv = 1;
                //e adicionamos o intermediário mais o próximo da linha 1 ao caminho final
                Path.add("\n" + Integer.toString(T2.get(i-1)));
                Path.add(Integer.toString(A1.get(i+1)));
              }
            }
          }
          //no final do caminho
          else{
            //se estiver na linha 1  
            if(lv==1){
              //se continuar na linha 1 for menos custoso
              if((A1.get(i+1) + A1.get(i+2)) <= (T1.get(i-1) + A2.get(i+1) + A2.get(i+2))){
                //adicionamos o final referente a continuar na linha 1
                Path.add(Integer.toString(A1.get(i+1)));
                Path.add(Integer.toString(A1.get(i+2)));
              }
              else{
                //senão descemos para a linha 2
                lv = -1;
                Path.add("\n" + Integer.toString(T1.get(i-1)));
                Path.add(Integer.toString(A2.get(i+1)));
                Path.add(Integer.toString(A2.get(i+2)));
              }
            }
            //se estiver na linha 2
            else{
              //se continuar na linha 2 for menos custoso acabamos nela  
              if((A2.get(i+1) + A2.get(i+2)) <= (T2.get(i-1) + A1.get(i+1) + A1.get(i+2))){
                Path.add(Integer.toString(A2.get(i+1)));
                Path.add(Integer.toString(A2.get(i+2)));
              }
              //senão acabamos na linha 1
              else{
                lv = 1;
                Path.add("\n" + Integer.toString(T2.get(i-1)));
                Path.add(Integer.toString(A1.get(i+1)));
                Path.add(Integer.toString(A1.get(i+2)));
              }
            }
          }
    }   
    //Imprime todo o caminho percorrido
    System.out.print("Path: ");
    Path.forEach((str) -> {
        System.out.print(str + "  ");
    });
    System.out.println("\n");
  }
}
