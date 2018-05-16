package trbparte2;

public class ArvoreVP {
    
    NoVP raiz;

    public ArvoreVP() {
        raiz = null;
    }
    
    void insere(int valor){
        
    }
    void remover(int p){
        
    }
    int alturaVP(){
        return 0;
    }
    NoVP getRaiz(){
        return raiz;
    }
    
    
    void insereAVP(NoVP no,NoVP pai, int valor){
        
    }
    void deletaH(NoVP p){
        
    }
    void corrigeCaso1(NoVP no){
        if(no.getPai() == null){
            no.setCor(NoVP.PRETO);
        }else{
            corrigeCaso2(no);
        }
    }
    void corrigeCaso2(NoVP no){
        
    }
    void corrigeCaso3(NoVP no){
        
    }
    void corrigeCaso4(NoVP no){
        
    }
    void corrigeCaso5(NoVP no){
        
    }
    void rotacaoEsquerda(NoVP no){
        NoVP y = no.getProx();
        no.setProx(y.getAnt());
        if(y.getAnt() != null){
            y.getAnt().setPai(no);
        }
        y.setPai(no.getPai());
        if(no.getPai() == null){
            raiz = y;
        }else{
            if(no == no.getPai().getAnt()){
                no.getPai().setAnt(y);
            }
            else{
                no.getPai().setProx(y);
            }
        }
        y.setAnt(no);
        no.setPai(y);
    }
    void rotacaoDireita(NoVP no){
        NoVP y = no.getAnt();
        no.setAnt(y.getProx());
        if(y.getProx() != null){
            y.getProx().setPai(no);
        }
        y.setPai(no.getPai());
        if(no.getPai() == null){
            raiz = y;
        }
        else{
            if(no == no.getPai().getProx()){
                no.getPai().setProx(y);
            }
            else{
                no.getPai().setAnt(y);
            }
        }
        y.setProx(no);
        no.setPai(y);
    }
    void removerCaso1(NoVP n){
        
    }
    void removerCaso2(NoVP n){
        
    }
    void removerCaso3(NoVP n){
        
    }
    void removerCaso4(NoVP n){
        
    }
    void removerCaso5(NoVP n){
        
    }
    void removerCaso6(NoVP n){
        
    }
    NoVP getPredecessor(NoVP no){
        return no;
    }
    NoVP getIrmao(NoVP no){
        return no;
    }
    void trocaNos(NoVP noVelho, NoVP noNovo){
        
    }
    int altura(NoVP no){
        return 0;
    }
    
}
