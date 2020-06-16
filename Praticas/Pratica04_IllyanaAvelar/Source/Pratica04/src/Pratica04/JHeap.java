package Pratica04;
import Item.Item; 
public class JHeap {
  private Item v[];
  private int  n;
  public static double comp; 
  
  //contrutor de JHeap que recebe tamanHo
  public JHeap (int maxTam) { 
    this.v = new Item[maxTam + 1];
    this.n = 0;
    comp = 0;
  }

  //contrutor de JHeap que recebe vetor
  public JHeap(Item v[]){
      this.v = v;
      this.n = this.v.length - 1;
  }
  //classe para refazer o Heap a partir de duas posiçoes do vetor 
  public void refaz(int esq, int dir) {
    int j = esq * 2;//pivo
    comp = 0;//inicia as comparaçoes com 0
    Item x = this.v[esq];
    
    //compara as posiçoes do vetor para saber se é um Heap e refaz o Heap
    while (j <= dir){
      comp+=1;
      if ((j < dir) && (this.v[j].compara (this.v[j + 1]) > 0))
        j++;
      if (x.compara (this.v[j]) <= 0)
        break;
      this.v[esq] = this.v[j];
      esq = j;
      j = esq * 2;
    }
    this.v[esq] = x;
  }

  //controi o Heap
  public void constroi(){
    int esq = n / 2 + 1;
    while (esq > 1){
      esq--;
      this.refaz(esq, this.n);
    }
  }

}
