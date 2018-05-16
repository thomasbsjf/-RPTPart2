package arvoreavl;

public class AVL {

    No raiz;
    
    public AVL() {
        raiz = null;
    }
    
    public No getRaiz() {
        return raiz;
    }
    
    public int Altura(No p){
        Integer alturaEsq, alturaDir;
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
                       
            }        
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
    
    public No RemoveAVL(No p, int n){
        return p;
    }

    public No Remove(No p, int n){
        return p;
    }
    
    void insere(int chave){
        raiz = InsereAVL(raiz, chave);
        //raiz = CorrigeAVL(raiz);
        Set_FB(raiz);
    }
    
}
