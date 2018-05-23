package trbparte2;

public class ArvoreSplay {
    
    void pesquisa(){
        
    }
    
    void insere(){
        
    }
    
    void remove(){
        
    }
    public No rot_zig_dir(No p){
        No q = p.getAnterior();
        p.setAnterior(q.getProximo());
        q.setProximo(p);
        return q;
    }

    public No rot_zig_esq(No p){
        No q = p.getProximo();
        p.setProximo(q.getAnterior());
        q.setAnterior(p);
        return q;
        }
    
    public No rot_zigzag_dir(No p){
        p = rot_zig_esq(p.getAnterior());
        return rot_zig_dir(p);
    }
            
    public No rot_zigzag_esq(No p){
        p = rot_zig_dir(p.getProximo());
        return rot_zig_esq(p);
    }
    
    public No rot_zigzig_dir(No p){
        return p;
    }
    public No rot_zigzig_esq(No p){
        return p;
    }
}
