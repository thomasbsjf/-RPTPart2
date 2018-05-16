package trbparte2;

public class ArvoreVP {
    
    NoVP raiz;

    public ArvoreVP() {
        raiz = null;
    }
    
    void remover(int p){
        
    }
    int alturaVP(){
        return 0;
    }
    NoVP getRaiz(){
        return raiz;
    }
    
        void insere(int valor){
        
    }
    void insereAVP(NoVP no,NoVP pai, int valor){
        if(no == null){
            NoVP novo = new NoVP(valor);
            if(pai != null){
                novo.setPai(pai);
                if(valor < pai.getValor()){
                    pai.setAnt(novo);
                }else{
                    pai.setProx(novo);
                }
            }else{
                raiz = novo;
            }
            corrigeCaso1(novo);
        }else{
            if(valor < no.getValor()){
                insereAVP(no.getAnt(), no, valor);
            }else{
                insereAVP(no.getProx(), no, valor);
            }
        }
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
        if(no.getPai().getCor() == NoVP.PRETO){
        }
        else{
            corrigeCaso3(no);
        }
    }
    void corrigeCaso3(NoVP no){
        if(no.getPai().getCor() == NoVP.VERMELHO && no.getTio().getCor() == NoVP.VERMELHO){
            no.getPai().setCor(NoVP.PRETO);
            no.getTio().setCor(NoVP.PRETO);
            no.getAvo().setCor(NoVP.VERMELHO);
            if(raiz.getCor() == NoVP.VERMELHO){
                raiz.setCor(NoVP.PRETO);
            }
        }
        else{
            corrigeCaso4(no);
        }
    }
    
    void corrigeCaso4(NoVP no){
        NoVP pai = no.getPai();
        NoVP avo = no.getAvo();
        NoVP tio = no.getTio();
        if(pai.getCor() == NoVP.VERMELHO && tio.getCor()== NoVP.PRETO){
            if(avo.getAnt() == pai && pai.getProx() == no){
                rotacaoEsquerda(pai);
                corrigeCaso5(pai);
            }
            if(avo.getProx() == pai && pai.getAnt() == no){
                rotacaoDireita(pai);
                corrigeCaso5(pai);
            }
            corrigeCaso5(no);
        }
    }
    void corrigeCaso5(NoVP no){
        NoVP pai = no.getPai();
        NoVP avo = no.getAvo();
        NoVP tio = no.getTio();
        if(avo.getAnt() == pai){
            rotacaoDireita(avo);
        }
        else{
            rotacaoEsquerda(avo);
        }
        pai.setCor(NoVP.PRETO);
        avo.setCor(NoVP.VERMELHO);
        no.setCor(NoVP.VERMELHO);
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
