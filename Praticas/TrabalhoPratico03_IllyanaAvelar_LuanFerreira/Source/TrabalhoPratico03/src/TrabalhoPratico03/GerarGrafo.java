
package TrabalhoPratico03;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class GerarGrafo {
       
    public int grafo[][];
    public int V;
      
    public GerarGrafo(){
        
    }

    public GerarGrafo(int V){
        this.V = V;
        grafo = new int[V][V];
        Random gerador = new Random();
          int random;
          for(int i = 0; i<V;i++){
              for(int j = i; j<V; j++){
                  if(i!=j){
                      random = gerador.nextInt(2);
                      grafo[i][j]=random; 
                      grafo[j][i]=random; 
                  }
                  if(i==j){
                      grafo[i][j]=0;
                  }
              }
          }
              
    
       /* for(int i = 0; i<V;i++){
            for(int j = 0; j<V; j++){
                System.out.print(" " + grafo[i][j] + " ");
            }
            System.out.println();
        }
*/

     
    }
}
