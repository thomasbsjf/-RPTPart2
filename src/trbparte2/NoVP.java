package trbparte2;

public class NoVP {
    private static final int VERMELHO = 0;
    private static final int PRETO = 1;
    NoVP proximo;
    NoVP anterior;
    NoVP pai;
    int valor;
    int cor;

    public NoVP(int v) {
        pai = null;
        proximo = null;
        anterior = null;
        cor = VERMELHO;
        valor = v;
    }

    NoVP getProx(){return proximo;}
    NoVP getAnt(){return anterior;}
    NoVP getPai(){return pai;}
    int getValor(){return valor;}
    int getCor(){return cor;}
    void setProx(NoVP p){proximo = p;}
    void setAnt(NoVP a){anterior = a;}
    void setPai(NoVP pa){pai = pa;}
    void setValor(int v){valor = v;}
    void setCor(int c){cor = c;}
        
    NoVP getAvo(){
        if(pai != null){
            return pai.getPai();
        }
        return null;
    }
    
    NoVP getTio(){
        NoVP avo = getAvo();
        if(avo == null){
            return null;
        }
        if(pai == avo.getAnt()){
            return avo.getProx();
        }else{
            return avo.getAnt();
        }
    }

}
