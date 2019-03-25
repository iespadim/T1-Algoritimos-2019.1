public class ArvoreGenealogicaDePosse{
    private Barbaro raiz;

    public ArvoreGenealogicaDePosse(Barbaro raiz){
        p("Arvore inicializada com ancião em sua raiz:");
        this.raiz = raiz;
        this.raiz.toString();
    }

    public ArvoreGenealogicaDePosse(){}
    
    public Barbaro getRaiz(){
        return raiz;
    }


    public Barbaro buscarBarbaro(String nome, Barbaro b, int nivel){        
        Barbaro encontrado = null;

        if(b.getNome().equals(nome)){            
            p("achamos "+ b.getNome());
            encontrado = b;
        }else{
            p("não é "+ b.getNome());            
            if(b.getFilhos().size()>0){
                p("procurando nos  "+b.getFilhos().size()+" filhos de "+b.getNome());
                for (Barbaro filho : b.getFilhos()) {
                    encontrado = buscarBarbaro(nome, filho, nivel++);            
                }    
            }else{
                p(b.getNome()+" não tem filhos.");
            }
        }
        
        
        
        
        return encontrado;
    }
    

    public Barbaro buscarBarbaro(String nome){
        if(raiz != null){
            System.out.print("\nbuscando alguem chamado "+nome+"...");
            return buscarBarbaro(nome, raiz, 0);
        }else{
            p("não achou ninguem chamado "+ nome);
            return null;
        }
    }


    public static void p(String s){
        System.out.println(s);
      }


    //   p("\n                               Não é ele. procurando nos filhos de "+b.getNome());
    //         p("\n                               "+b.getNome() +" tem "+b.getFilhos().size()+" filhos:"); 
    //         System.out.print("                               ");
    //         for (Barbaro ggg : b.filhos) {
    //             System.out.print(ggg.getNome()+", ");
    //         }
    //         p("");
    //         for(int i = 0; i < b.getFilhos().size()+1;) {
    //             Barbaro filho = b.getFilhos().get(i);
    //             p("                               testando o filho "+b.getFilhos().get(i).getNome());
    //             p("                               procurando nos filhos de "+filho.getNome()+":");                    
    //             if(filho.getNome().equals(nome)){
    //                 nivel++;
    //                 System.out.print("\n                               ... É filho de "+filho.getNome()+"!!\n                               Geração "+ nivel+"\n");
    //                 return buscarBarbaro(nome, filho, nivel);
    //             }else{
    //                 nivel++;                        
    //                 System.out.print("\n                               ...não é filho de "+filho.getNome()+".\n                               Procurando nos filhos de "+ filho.getNome());
    //                 p("\n                               procurando por "+nome+" relacionado a "+ filho.getNome());
    //                 return buscarBarbaro(nome, filho, nivel);
    //             }
    
}