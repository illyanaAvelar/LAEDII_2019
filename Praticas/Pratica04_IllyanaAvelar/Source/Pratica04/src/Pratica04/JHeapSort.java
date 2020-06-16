package Pratica04;
import Item.Item;
public class JHeapSort {
public static double jcomp;
    
    public JHeapSort(Item v[], int n) {
      jcomp = 0;//quantidade de comparaçoes que inicialmente é zero
      JHeap heap = new JHeap (v);//instancia um heap
      int k = n;//atribui o tamano do heap a uma variável auxiliar
      heap.constroi ();//constroi o heap 
      while (1 < k) {//enquanto nao percorrer todos os itens 
        //troca o primeiro com k, que vai de n a 2
        Item x = v[1];
        v[1] = v[k];
        v[k] = x;
        k--;
        heap.refaz (1, k);//refaz o heap
        jcomp = heap.comp + jcomp;//incrementa na variável que conta as comparaçoes
      }
    }
}
