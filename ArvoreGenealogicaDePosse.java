import Barbaro;

public class ArvoreGenealogicaDePosse{
    private Barbaro raiz;

    public ArvoreGenealogicaDePosse(Barbaro raiz){
        this.raiz = raiz;
    }

    public ArvoreGenealogicaDePosse(){}
    
    public Barbaro getRaiz(){
        return raiz;
    }

    public Barbaro buscar(String nome){
        if(getRaiz().nome = nome) return getRaiz();
        for (Barbaro b : getRaiz().filhos) {
            if(b.nome = nome) return b;
            else for (Barbaro c : b.filhos) {
                
            }

            
        }

    }

    
    public boolean adicionaDescendente(Barbaro b, String nomeDoPai){
        if(raiz == null || getRaiz().nome.equals(nomeDoPai)){
            return getRaiz().filhos.add(b);
        }else{
            Barbaro aux = buscarBarbaro(nomeDoPai);
            return false;
        }        
    }

    
}



// public Barbaro buscar(String nome){
    // if(this.nome.equals(nome)){
        // return this;
    // }
    // for (Barbaro filho : filhos) {
        // Barbaro aux = filho.buscar(nome);
        // if (aux != null){
            // return aux;
        // }
    // }
    // return new Barbaro("ué");            
    // 
// }