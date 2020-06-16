package TrabalhoPratico02;
import java.io.*;
import java.util.*;

public class Dinamico {

  int t = 99;
  private ArrayList<Integer> A1 = new ArrayList();
  private ArrayList<Integer> A2 = new ArrayList();
  private ArrayList<Integer> T1 = new ArrayList();
  private ArrayList<Integer> T2 = new ArrayList();
  private ArrayList<String> Path = new ArrayList();
  private ArrayList<String> CPath = new ArrayList();
    
  public Dinamico(ArrayList A1, ArrayList A2, ArrayList T1, ArrayList T2) throws IOException {
   
    this.A1 = A1;
    this.A2 = A2;
    this.T1 = T1;
    this.T2 = T2;
  }

  public void caminho(int lv, int index, int peso){
    
    //se estiver na linha 1    
    if(lv == 1){
      //se estiver no final da linha
      if(index == A1.size()-1){
        //se a soma atual for menor do que a total até o momento, a total anterior é substituída
        //e um novo caminho é criado com o formado pelo menor peso
        if(peso < t){
          t = peso;
          CPath = new ArrayList(Path);
        }
      }
      //Linha de montagem
      else{
        if(index==0){
          //se estiver no inicio adiciona o primeiro peso
          peso = A1.get(index);
          Path.add(Integer.toString(peso));    
        }
        //adiciona o próximo item na linha 1 e realiza a chamada recursiva
        Path.add(Integer.toString(A1.get(index+1)));
        caminho(lv,index+1,peso+A1.get(index+1));
        try{
        //retira o último elemento    
        Path.remove(Path.size()-1);
        }catch(IndexOutOfBoundsException e){
          System.out.println("Erro de posição inválida");
          e.getMessage();
        }
        //se estiver no meio
        if(index < A1.size()-2 && index > 0){
          //vai para a linha 2 e adiciona seu caminho ao caminho total 
          Path.add("\n" + Integer.toString(T1.get(index-1)));
          Path.add(Integer.toString(A2.get(index+1)));
          //realiza chamada recursiva
          caminho(-1,index+1,peso+T1.get(index-1)+A2.get(index+1));
            try{
            //retira o último e penúltimo elementos    
            Path.remove(Path.size()-1);
            Path.remove(Path.size()-1);
            }catch(IndexOutOfBoundsException e){
              System.out.println("Erro de posição inválida");
              e.getMessage();
            }
        }
      }
    }
      //se estiver na linha 2  
      else{
        //se estiver no final da linha
        if(index==A2.size()-1){
          //se a soma atual for menor do que a total até o momento, a total anterior é substituída
          //e um novo caminho é criado com o formado pelo menor peso
          if(peso<t){
            t=peso;
            CPath = new ArrayList(Path);
          }
        }
        //se estiver no meio, realiza passos análogos aos da linha 1    
        else{
          if(index==0){
            peso = A2.get(index);
            Path.add(Integer.toString(peso));
          }
          Path.add(Integer.toString(A2.get(index+1)));
          caminho(lv,index+1,peso+A2.get(index+1));
          try{
          Path.remove(Path.size()-1);
          }catch(IndexOutOfBoundsException e){
            System.out.println("Erro de posição inválida");
            e.getMessage();
          }
        
          if(index<A2.size()-2 && index>0){
            Path.add("\n" + Integer.toString(T2.get(index-1)));
            Path.add(Integer.toString(A1.get(index+1)));
            caminho(1,index+1,peso+T2.get(index-1)+A1.get(index+1));
            try{
            Path.remove(Path.size()-1);
            }catch(IndexOutOfBoundsException e){
              System.out.println("Erro de posição inválida");
              e.getMessage();
            }
          }
        }
      }
    //imprime todo o caminho percorrido
    System.out.print("Path -> ");
    CPath.forEach((item) -> {
        System.out.print(item + ", ");
    });
    System.out.println("\n");
  }
}
   


