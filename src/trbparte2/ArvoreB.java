package trbparte2;

public class ArvoreB {
    NoB raiz ;

    public ArvoreB(NoB raiz) {
        raiz = null;
    }
    NoB getRaiz(){
        return raiz;
    }
    
    void inserir(int valor){
        if(raiz == null){
            raiz = new NoB();
            insereNo(raiz, valor);
        }else{
            insereRecursivo(raiz, valor);
            if(raiz.chave[NoB.MAX] != 0){
                NoB novoNo = new NoB();
                NoB auxRaiz = new NoB();
                int s = split(raiz, novoNo);
                auxRaiz.filho[0] = raiz;
                auxRaiz.filho[1] = novoNo;
                auxRaiz.chave[0] = s;
                auxRaiz.tamanho++;
                raiz = auxRaiz;
            }
        }
    }
    
    void insereNo(NoB no, int valor){
        int k = 0;
        while(k< no.tamanho && no.chave[k] < valor){
            k++;
        }
        for(int i = no.tamanho-1; i>=k; i--){
            no.chave[i+1] = no.chave[i];
        }
        for(int i =no.tamanho; i>=k; i--){
            no.filho[i+1] = no.filho[i];
        }
        no.chave[k] = valor;
        no.tamanho++;
    }
    void insereRecursivo(NoB no, int valor){
        int k = 0;
        while(k < no.tamanho){
            if(no.chave[k] < valor)k++;
            else break;
        }
        if(no.filho[k] == null){
            insereNo(no, valor);
        }
        else{
            insereRecursivo(no.filho[k], valor);
            if(no.filho[k].chave[NoB.MAX] != 0){
                NoB novoNo = new NoB();
                int s = split(no.filho[k], novoNo);
            }
        }
    }
    int split(NoB n, NoB novoNo){
        return 0;
    }
    void deletaArvore(NoB n){
        
    }
    NoB buscar(int valor, NoB n){
        return n;
    }
    

    void remover(int valor){
        
    }
    boolean buscar(int valor){
       return true; 
    }

}
