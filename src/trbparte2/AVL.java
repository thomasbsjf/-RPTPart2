package trbparte2;

public class AVL {

    No raiz;
    
    public AVL() {
        raiz = null;
    }
    
    public No getRaiz() {
        return raiz;
    }
    
    public int Altura(No p){
        int alturaEsq, alturaDir;
        if(p==null) return 0;
        else{
            alturaEsq = Altura(p.getAnterior());
            alturaDir = Altura(p.getProximo());
            if(alturaEsq >alturaDir){
                return (1+ alturaEsq);
            }else{
                return (1+ alturaDir);
            }
        }
    }
    
    public int Calcula_FB(No p){
        if(p==null) return 0;
        return (Altura(p.getAnterior()) - Altura(p.getProximo()));
    }
    
    public void Set_FB(No p){
        if(p!=null){
            p.setMarca(Altura(p.getAnterior()) - Altura(p.getProximo()));
            Set_FB(p.getAnterior());
            Set_FB(p.getProximo());
        }
    }
    
    public No rot_dir(No p){
        No q = p.getAnterior();
        p.setAnterior(q.getProximo());
        q.setProximo(p);
        
        return q;
    }
    
    public No rot_esq(No p){
        No q = p.getProximo();
        p.setProximo(q.getAnterior());
        q.setAnterior(p);
        return q;
    }
        
    public No rot_duplo_dir(No p){
        p = rot_esq(p.getAnterior());
        return rot_dir(p);
    }
            
    public No rot_duplo_esq(No p){
        p = rot_dir(p.getProximo());
        return rot_esq(p);
    }
    
    public No CorrigeAVL(No p){
        if(p != null)
        {
            p.setMarca(Calcula_FB(p));
            if(p.getMarca() == 2)
            {
                p.getAnterior().setMarca(Calcula_FB(p.getAnterior()));
                if(p.getAnterior().getMarca() >0)
                {
                    p = rot_dir(p);
                }else
                {
                    p = rot_duplo_dir(p);
                }
                       
            }else if(p.getMarca() == -2)
            {
                p.getProximo().setMarca((Calcula_FB(p.getProximo())));
                if(p.getProximo().getMarca() < 0){
                    p = rot_esq(p);
                }else
                {
                    p = rot_duplo_esq(p);
                }
            }
            p.setAnterior(CorrigeAVL(p.getAnterior()));
            p.setProximo(CorrigeAVL(p.getProximo()));
        }
        return p;
    }
    
    public No InsereAVL(No p, int chave){
        if(p == null){
            p = new No(null, null);
            p.setValor(chave);
            p.setMarca(0);
            return p;
        }else
        {
            if(chave < p.getValor()){
                p.setAnterior(InsereAVL(p.getAnterior(), chave));
            }else
            {
                p.setProximo(InsereAVL(p.getProximo(), chave));
            }
        }
        return p;
    }
    
    public No Consulta(No p, int chave){
        while(p != null)
        {
            if(chave == p.getValor()){
                return p;
            }
            else
            {
                if(chave < p.getValor()){
                    p = p.getAnterior();
                }
                else{
                    p = p.getProximo();
                }
            }
        }
        return null;
    }
    
    public No RemoveAVL(No p){
        No aux;
        No auxPai = null;
        
        if((p.getAnterior()== null) && (p.getProximo()==null))
        {
            p = null;
            return null;
        }
        else if((p.getAnterior() == null) && (p.getProximo()!= null))
        {
            aux = p.getAnterior();
            p = null;
            return aux;
        }
        else if((p.getAnterior()!= null) && (p.getProximo() == null))
        {
            aux = p.getProximo();
            p = null;
            return aux;
        }
        else
        {
            if(p.getAnterior().getProximo() == null)
            {
                aux = p.getAnterior();
                p.getAnterior().setProximo(p.getProximo());
                p = null;
                return aux;
            }else
            {
                aux = p.getAnterior();               
                while(aux.getProximo() != null)
                {
                    auxPai = aux;
                    aux = aux.getProximo();
                }
                if(aux.getAnterior() != null){
                    auxPai.setProximo(aux.getAnterior());
                }
                else{
                    auxPai.setProximo(null);
                }
                aux.setProximo(p.getProximo());
                aux.setAnterior(p.getAnterior());
                p = null;
                return aux;
            }
        }
    }

    public No Remove(No p, int n){
        No aux = p;
        No auxPai = null;
        boolean bdir = false;
        
        if(n == p.getValor()) return RemoveAVL(aux);
        
        while(aux != null)
        {
            if(n == aux.getValor())
            {
                if(bdir) auxPai.setProximo(RemoveAVL(aux));
                else auxPai.setAnterior(RemoveAVL(aux));
                return p;
            }
            else
            {
                if(n < aux.getValor())
                {
                    bdir = false;
                    auxPai = aux;
                    aux = aux.getAnterior();
                }
                else
                {
                    bdir = true;
                    auxPai = aux;
                    aux = aux.getProximo();
                }
            }
        }
        return p;
    }
    
    void Insere(int chave){
        raiz = InsereAVL(raiz, chave);
        raiz = CorrigeAVL(raiz);
        Set_FB(raiz);
    }
    
    void Remover(int chave)
    {
        raiz = Remove(raiz, chave);
        raiz = CorrigeAVL(raiz);
        Set_FB(raiz);
    }
}
