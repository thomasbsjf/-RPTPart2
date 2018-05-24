package trbparte2;

public class ArvoreSplay {

    NoSplay raiz;
    
    public ArvoreSplay() {
        raiz = null;
    }
    
    void pesquisa(){
        
    }
    
    NoSplay insereSplay(NoSplay no, int valor)
    {
        NoSplay aux1, aux2, parente;
        if(no == null)
        {
            no = new NoSplay(valor);
            if(no == null)
            {
                System.out.println("Erro de alocacao");
                System.exit(0);
            }
        return no;
        }
        
    }
    
    void insere(int valor)
    {
        NoSplay x = insereSplay(raiz,valor);
        raiz = x;
    }
    
    void remove(){
        
    }
    public NoSplay rot_zig_dir(NoSplay p){
        NoSplay q = p.getAnterior();
        p.setAnterior(q.getProximo());
        q.setProximo(p);
        return q;
    }

    public NoSplay rot_zig_esq(NoSplay p){
        NoSplay q = p.getProximo();
        p.setProximo(q.getAnterior());
        q.setAnterior(p);
        return q;
        }
    
    public NoSplay rot_zigzag_dir(NoSplay p){
        p = rot_zig_esq(p.getAnterior());
        return rot_zig_dir(p);
    }
            
    public NoSplay rot_zigzag_esq(NoSplay p){
        p = rot_zig_dir(p.getProximo());
        return rot_zig_esq(p);
    }
    
    public NoSplay rot_zigzig_dir(NoSplay p){
        return p;
    }
    public NoSplay rot_zigzig_esq(NoSplay p){
        return p;
    }
}
