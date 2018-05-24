package trbparte2;

public class ArvoreSplay {

    NoSplay raiz;

    public NoSplay getRaiz() {
        return raiz;
    }
    
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
        else
        {   
            aux1 = null;
            aux2 = no;
            while(aux2 != null)
            {
                aux1 = aux2;
                if(aux2.getValor() > valor)
                {
                    aux2 = aux2.getAnterior();
                }
                else if(aux2.getValor() < valor)
                {
                    aux2 = aux2.getProximo();
                }
                else
                {
                    if(aux2.getValor() == valor)
                    {
                        return aux2;
                    }
                }
            }
            if(aux1.getValor() > valor)
            {
                parente = aux1;
                aux1.setAnterior(new NoSplay(valor));
                aux1 = aux1.getAnterior();
                
                if(aux1 != null)
                {
                    aux1.setPai(parente);
                }
                else
                {
                    System.out.println("Erro de alocacao\n");
                    System.exit(0);
                }
            }
            else
            {
                parente = aux1;
                aux1.setProximo(new NoSplay(valor));
                aux1 = aux1.getProximo();
                if(aux1 != null)
                {
                    aux1.setPai(parente);
                }
                else
                {
                    System.out.println("Erro de alocacao\n");
                    System.exit(0);
                }
            }
        }
        splay(aux1,no);
        return aux1;
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

    private void splay(NoSplay aux1, NoSplay no) {
        
    }
}
