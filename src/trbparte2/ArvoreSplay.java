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
    public NoSplay rotacaoDireita(NoSplay p, NoSplay q){
        NoSplay r;
        r = p.getAnterior();
        p.setAnterior(r.getProximo());
        if(r.getProximo() != null)
        {
            r.getProximo().setPai(p);
        }
        r.setProximo(p);
        if(p.getPai() != null)
        {
            if(p == p.getPai().getProximo())
            {
                p.getPai().setProximo(r);
            }
            else
            {
                p.getPai().setAnterior(r);
            }
        }
        r.setPai(p.getPai());
        p.setPai(r);
        if( p == q)
        {
            return r;
        }
        else
        {
            return q;
        }
    }
    

    public NoSplay rotacaoEsquerda(NoSplay p, NoSplay q){
        NoSplay r;
        r = p.getProximo();
        p.setProximo(r.getAnterior());
        if(r.getAnterior()!= null)
        {
            r.getAnterior().setPai(p);
        }
        r.setAnterior(p);
        if(p.getPai() != null)
        {
            if(p == p.getPai().getAnterior())
            {
                p.getPai().setAnterior(r);
            }
            else
            {
                p.getPai().setProximo(r);
            }
        }
        r.setPai(p.getPai());
        p.setPai(r);
        if( p == q)
        {
            return r;
        }
        else
        {
            return q;
        }
    }
    
    void splay(NoSplay no, NoSplay raiz)
    {
        NoSplay p, q;
        
        if( no==raiz) return;
        else if(no.getPai() == raiz)
        {
            if(no==no.getPai().getAnterior())
            {
                raiz = rotacaoDireita(raiz, raiz);
            }
            else
            {
                raiz = rotacaoEsquerda(raiz, raiz);
            }
        }
        else
        {
            p = no.getPai();
            q = p.getPai();
            if( no == p.getAnterior() && p == q.getAnterior())
            {
                raiz = rotacaoDireita(q, raiz);
                raiz = rotacaoDireita(p, raiz);
            }
            else if(no ==p.getProximo() && p == q.getProximo())
            {
                raiz = rotacaoEsquerda(q, raiz);
                raiz = rotacaoEsquerda(p, raiz);
            }
            else if(no == p.getProximo() && p == q.getAnterior())
            {
                raiz = rotacaoEsquerda(p, raiz);
                raiz = rotacaoDireita(q, raiz);
            }
            else if(no == p.getAnterior() && p == q.getProximo())
            {
                raiz = rotacaoDireita(p, raiz);
                raiz = rotacaoEsquerda(q, raiz);
            }
            splay (no,raiz);
        }
    }

}
