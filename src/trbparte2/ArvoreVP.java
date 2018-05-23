package trbparte2;

public class ArvoreVP {
    
    NoVP raiz;

    public ArvoreVP() {
        raiz = null;
    }
    
    int alturaVP(){
        return altura(raiz);
    }
    NoVP getRaiz(){
        return raiz;
    }   
        
    void insere(int valor){
        insereAVP(raiz, null, valor);
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
    
    void remover(int valor){
        if(raiz == null){
            return;
        }
        NoVP p = raiz;
        boolean achou = false;
        while( p!= null){
            if(p.getValor() == valor){
                achou = true;
                break;
            }
            if(p.getValor() < valor){
                p = p.getProx();
            }else{
                p = p.getAnt();
            }
        }
        if( achou == false){
            return;
        }else{ // IMPRIME NA TELA, BOM PARA TESTES
            System.out.println("Iniciando remocao do valor " + valor);
            if(p.getAnt() == null && p.getProx() != null){
                System.out.println("No a ser removido tem 2 filhos");
                NoVP predecessor = getPredecessor(p.getAnt());
                System.out.println("Seu predecessor eh o no " + predecessor.getValor());
                System.out.println("Substituindo o no a ser removido " + p.getValor() + " pelo seu predecessor "+predecessor.getValor());
                p.setValor(predecessor.getValor());
                p = predecessor;
                System.out.println("Agora o no a ser ajustado eh o no "+ p.getValor());
            }else{
                System.out.println("No a ser removido tem 1 ou nenhum filho");
            }
            // P deve ser folha ou ter apenas 1 filho
            if(p.getAnt() == null || p.getProx() == null){                
            }else{
                System.out.println("Erro: P tem 2 filhos");
            }
            //Pega o unico filho de p, se houver
            NoVP filho = (p.getProx()==null) ? p.getAnt() : p.getProx();
            if(p.getCor() == NoVP.PRETO){
                if(filho != null){
                    p.setCor(filho.getCor());
                }else{
                    p.setCor(NoVP.PRETO);
                }
                removerCaso1(p);
            }
            trocaNos(p,filho);
            System.out.println("Deletou" + valor);
        }
    }
    
    void removerCaso1(NoVP n){
        System.out.println("Remocao Caso 1 (No = " + n.getValor() + "):");
        if(n.getPai() == null)
        {
            System.out.println("Pai NULL");
        }
        else
        {
            System.out.println("Pai nao NULL");
            removerCaso2(n);
        }
    }
    void removerCaso2(NoVP n){
        System.out.println("Remocao Caso 1 (No = " + n.getValor() + "):");
        NoVP irmao = getIrmao(n);
        if(irmao.getCor() == NoVP.VERMELHO)
        {
            System.out.println("Irmao Vermelho -> Rotacionar");
            n.getPai().setCor(NoVP.VERMELHO);
            irmao.setCor(NoVP.PRETO);
            if(n ==n.getPai().getAnt())
            {
                rotacaoEsquerda(n.getPai());
            }
            else
            {
                rotacaoDireita(n.getPai());
            }
        }
        else
        {
            System.out.println("Irmao nao é vermelho");              
        }
        removerCaso3(n);
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
        while(no.getProx() != null){
            no = no.getProx();
        }
        return no;
    }
    NoVP getIrmao(NoVP no){
        if(no == null || no.getPai() == null){
            //Nó ou pai do nó é null
        }
        if(no == no.getPai().getAnt()){
            return no.getPai().getProx();
        }else{
            return no.getPai().getAnt();
        }
    }
    void trocaNos(NoVP noVelho, NoVP noNovo){
        if(noVelho.getPai() == null){
            raiz = noNovo;
        }else{
            if(noVelho == noVelho.getPai().getAnt()){
                noVelho.getPai().setAnt(noNovo);
            }else{
                noVelho.getPai().setProx(noNovo);
            }
        }
        if(noNovo != null){
            noNovo.setPai(noVelho.getPai());
        }
    }
    int altura(NoVP no){
        return 0;
    }
    
}
