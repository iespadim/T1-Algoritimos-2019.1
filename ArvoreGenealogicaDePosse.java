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
        return raiz.buscar(nome);
    }
}