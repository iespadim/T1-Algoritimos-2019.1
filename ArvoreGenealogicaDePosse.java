import java.util.ArrayList;

public class ArvoreGenealogicaDePosse{
    private Barbaro raiz;
    // ArrayList com todos os barbaros sem filhos;
    // é populada após a arvore ser criada completamente;
    private ArrayList<Barbaro> folhas = new ArrayList<>();

    public ArvoreGenealogicaDePosse(Barbaro raiz){        
        this.raiz = raiz;
    }
    
    public Barbaro getRaiz(){
        return raiz;
    }

    public Barbaro buscarBarbaro(String nome, Barbaro b, boolean encontrou){        
        // variavel para fallback quando encontrar;
        Barbaro encontrado = null;

        if(b.getNome().equals(nome)){            
            //b é o cara que procuramos
            encontrado = b;            
        }else{
            //b nao não é o cara que procuramos
            if(encontrou == false){
                // b tem filhos?
                //  ele tem filhos!
                if(b.getFilhos().size()>0){
                    // busca nos filhos dele
                    for (Barbaro filho : b.getFilhos()) {
                        // procura o cara nos filhos
                        encontrado = buscarBarbaro(nome, filho, false);
                        //  achou? para de procurar
                        if( encontrado != null && encontrado.getNome().equals(nome)) break;            
                    }    
                }else{
                // b nao tem filhos
                // nao faz nada
                }
            }
        }                
        return encontrado;
    }
    

    public Barbaro buscarBarbaro(String nome){
        if(raiz != null){
            // a arvore nao está vazia
            return buscarBarbaro(nome, raiz, false);
        }else{
            // arvore vazia
            return null;
        }
    }

    
    // pega as terras da raiz e divide pelo numero de filhos
    // supoe-se que a arvore ja está pronta.
    public void distribuiBens(){        
        Barbaro aux = getRaiz();
        distribuiBens(aux,0);
    }

    // metodo auxiliar para recursivamente ser chamado por distribuiBens();
    public void distribuiBens(Barbaro b, int geracao){
        // se b tem filhos
        if(!b.getFilhos().isEmpty()){
            // fazer com que cada filho herde os bens do pai
            for (Barbaro filho : b.getFilhos()) {
                filho.herdar(filho, geracao++);
                // distribuir bens do filho na proxima geração
                distribuiBens(filho, geracao++);
            }
        }else{
        // B nao tem herdeiros, logo é uma folha
        //  logo é da ultima geração; guarda a geração
            folhas.add(b);
            b.setGeracao(geracao);
        }        
    }

    // percorre o array de folhas e retorna a folha com mais getTerras();
    public String maisRico(){
        Barbaro e = null;
        for (Barbaro b : folhas) {
            if(e==null){
                e = b;
            }else{
                if(e.getTerras()<b.getTerras()){
                    e=b;
                }                
            }
        }
        return e.toString();
    }

    // print preguiçoso;
    public static void p(String s){
        System.out.println(s);
      }    
}