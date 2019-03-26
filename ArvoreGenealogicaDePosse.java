import java.util.ArrayList;

public class ArvoreGenealogicaDePosse{
    private Barbaro raiz;
    private ArrayList<Barbaro> folhas = new ArrayList<>();

    public ArvoreGenealogicaDePosse(Barbaro raiz){
        // p("Arvore inicializada com ancião em sua raiz:");
        this.raiz = raiz;
        this.raiz.toString();
    }

    public ArvoreGenealogicaDePosse(){}
    
    public Barbaro getRaiz(){
        return raiz;
    }


    public Barbaro buscarBarbaro(String nome, Barbaro b, boolean encontrou){        
        Barbaro encontrado = null;

        if(b.getNome().equals(nome)){            
            // p(nivel+"Encontrado "+ b.getNome()+"!");
            encontrado = b;
            
        }else{
            if(encontrou == false){
                // p(nivel+" não é "+ b.getNome()+", ");            
                if(b.getFilhos().size()>0){
                    //  System.out.println(nivel+"procurando nos  "+b.getFilhos().size()+" filhos de "+b.getNome());                    
                    for (Barbaro filho : b.getFilhos()) {
                        // p(nivel+"->filho "+filho.getNome());                   
                        encontrado = buscarBarbaro(nome, filho, false);
                        if( encontrado != null && encontrado.getNome().equals(nome)) break;            
                    }    
                }else{
                    // p(nivel+b.getNome()+" não tem filhos.");
                }
            }
        }
        // if(encontrado == null) p(nivel+"indo para proximo filho de "+b.getNome());
        return encontrado;
    }
    

    public Barbaro buscarBarbaro(String nome){
        if(raiz != null){
            // System.out.print("\nbuscando alguem chamado "+nome+"...\n");
            return buscarBarbaro(nome, raiz, false);
        }else{
            p("Arvore vazia");
            return null;
        }
    }

    
    // pega as terras da raiz e divide pelo numero de filhos
    // supoe-se que a arvore ja está pronta.
    public void distribuiBens(){        
        Barbaro aux = getRaiz();
        distribuiBens(aux,0);
    }

    //  metodo auxiliar para recursivamente ser chamado por distribuiBens();
    public void distribuiBens(Barbaro b, int geracao){
        if(!b.getFilhos().isEmpty()){
            for (Barbaro filho : b.getFilhos()) {
                filho.herdar(filho, geracao++);
                distribuiBens(filho, geracao++);
            }
        }else{
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