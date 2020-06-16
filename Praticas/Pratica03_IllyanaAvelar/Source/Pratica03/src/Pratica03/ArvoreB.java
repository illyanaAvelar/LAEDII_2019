package Pratica03;
import Item.Item;
public class ArvoreB {
  
  static double comp;
  static double pag;
  private static class Pagina {
   int n; Item r[]; Pagina p[]; 
   public Pagina (int mm){
    this.n = 0; this.r = new Item[mm]; this.p = new Pagina[mm+1];
   }
  }
  
  private Pagina raiz;
  private int m, mm;
 
  /*Metodo para realizar pesquisa*/
  private Item pesquisa (Item reg, Pagina ap) {
    pag++;//inicia busca em outra pagina
      if (ap == null) return null; 
    else {
      int i = 0;
      while ((i < ap.n-1) && (reg.compara (ap.r[i]) > 0)){
       comp+=1;
       i++;
      }           
      if (reg.compara (ap.r[i]) == 0){
        comp+=1;//uma comparaçao necessaria
        return ap.r[i];
      }
      else if (reg.compara (ap.r[i]) < 0){
        comp+=2;//duas comparaçoes necessarias
        return pesquisa (reg, ap.p[i]);
      }
      else {
        comp+=3;//tres comparaçoes necessarias
        return pesquisa (reg, ap.p[i+1]);
      }
    }
  }
  /*Metodo para inserir um numero na mesma pagina*/
  private void insereNaPagina (Pagina ap, Item reg, Pagina apDir) {
    int k = ap.n - 1;
    while ((k >= 0) && (reg.compara (ap.r[k]) < 0)) {
      ap.r[k+1] = ap.r[k]; ap.p[k+2] = ap.p[k+1]; k--; 
    }
    ap.r[k+1] = reg; ap.p[k+2] = apDir; ap.n++;     
  }
  
  /*Metodo para inserir na mesma pagina ou em uma nova pagina o Item passado como parametro*/
  private Pagina insere (Item reg, Pagina ap, Item[] regRetorno, boolean[] cresceu) {
    Pagina apRetorno = null;
    if (ap == null){
       cresceu[0] = true; 
       regRetorno[0] = reg; 
    } 
    else{
      int i = 0;
      while ((i < ap.n-1) && (reg.compara (ap.r[i]) > 0))
        i++;      
      if (reg.compara (ap.r[i]) == 0){
        System.out.println ("Erro: Registro ja existente");
        cresceu[0] = false;
      } 
      else{
        if(reg.compara (ap.r[i]) > 0) 
          i++;
        apRetorno = insere (reg, ap.p[i], regRetorno, cresceu);
        if (cresceu[0])
          //se tem espaço, o item é colocado na página 
          if (ap.n < this.mm) {
            this.insereNaPagina (ap, regRetorno[0], apRetorno);
            cresceu[0] = false; apRetorno = ap;
          } 
          //se a pagina nao tem mais espaço, uma nova página é criada
          else{ 
            Pagina apTemp = new Pagina (this.mm); apTemp.p[0] = null;
            if (i <= this.m){
              this.insereNaPagina (apTemp, ap.r[this.mm-1], ap.p[this.mm]);
              ap.n--;
              this.insereNaPagina (ap, regRetorno[0], apRetorno);
            }
            else
              this.insereNaPagina (apTemp, regRetorno[0], apRetorno);
            
            for (int j = this.m+1; j < this.mm; j++) {
              this.insereNaPagina (apTemp, ap.r[j], ap.p[j+1]);
              ap.p[j+1] = null; 
            }
            
            ap.n = this.m; apTemp.p[0] = ap.p[this.m+1]; 
            regRetorno[0] = ap.r[this.m]; apRetorno = apTemp;
          }
      }        
    }
    return (cresceu[0] ? apRetorno : ap);
  }
 
  /*Metodo para iniciar a arvore, recebendo seu peso*/ 
  public ArvoreB (int m) {
    this.raiz = null; this.m = m; this.mm = 2*m;
  }
  /*Metodo para chamar a pesquisa*/
  public Item pesquisa (Item reg) {
    return this.pesquisa (reg, this.raiz);
  }
  
  /*Metodo para inserir uma pagina*/
  public void insere (Item reg) {
    Item regRetorno[] = new Item[1];
    boolean cresceu[] = new boolean[1];
    Pagina apRetorno = this.insere (reg, this.raiz, regRetorno, cresceu);
    if (cresceu[0]){
      Pagina apTemp = new Pagina(this.mm);
      apTemp.r[0] = regRetorno[0];
      apTemp.p[0] = this.raiz;
      apTemp.p[1] = apRetorno;
      this.raiz = apTemp; this.raiz.n++;
    } else this.raiz = apRetorno;
  }

 
}
