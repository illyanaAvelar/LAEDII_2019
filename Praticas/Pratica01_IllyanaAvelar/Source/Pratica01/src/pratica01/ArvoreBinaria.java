package pratica01;
/*Classe para a implementação do TAD*/
public class ArvoreBinaria {

  private static class No { 
    Item reg; 
    No esq, dir; 
      }
  private No raiz;
  static double comp;

  /*Método responsável pela busca e pelo cálculo das comparalções*/
  private Item pesquisa (Item reg, No p) {
    if (p == null){//chegou até uma folha
      this.comp++;//única ou última comparação  
      return null; 
    }else 
      if (reg.compara (p.reg) < 0){//vai para a subarvore à esquerda se for menor
        this.comp += 2;//segunda comparação
        return pesquisa (reg, p.esq);
      }else 
        if (reg.compara (p.reg) > 0){//vai para a subarvore à direita se for maior 
          this.comp += 3;//terceira comparação
          return pesquisa (reg, p.dir);
        }else
          return p.reg;//retorna o nó, caso encontre o ítem
  } 
 
  /*Insere um novo Item na árvore*/ 
  private No insere (Item reg, No p) {
      if (p == null) {
      p = new No (); 
      p.reg = reg; 
      p.esq = null;
      p.dir = null;
    }
      else
      if (reg.compara (p.reg) < 0)
        p.esq = insere (reg, p.esq);
        else 
        if (reg.compara (p.reg) > 0)
          p.dir = insere (reg, p.dir);
          else
            System.out.println ("Erro: Registro ja existente");
    return p; 
  } 
  
  /*Inicia a àrvore Binária*/  
  public ArvoreBinaria () {
    this.raiz = null;
  }
  
  /*Chama o método de pesquisa*/
  public Item pesquisa (Item reg) {
    return this.pesquisa (reg, this.raiz);
    
  }
  
  /*Método para retornar o valor de comparações realizadas na busca*/
  public double comparacoes(){
      return this.comp;
  }
  
  /*Método para inserir itens na árvore*/
  public void insere (Item reg) {
    this.raiz = this.insere(reg, this.raiz);
  }

}
