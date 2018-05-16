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
                insereNo(no, s);
                no.filho[no.getPos(s)] = no.filho[no.getPos(s)+1];
                no.filho[no.getPos(s)+1] = novoNo;
            }
        }
    }
    int split(NoB n, NoB novoNo){
        return 0;
    }
    void deletaArvore(NoB n){
        
    }
    NoB buscar(int valor, NoB n){
        NoB aux = new NoB();
        int k = 0;
        
        if(n == null){
            return null;
        }
        else{
            if(n.getPos(valor) != -1){
                return n;
            }
        }
        while(k < n.tamanho){
            if(n.chave[k] < valor)k++;
            else break;
        }
        if(n.chave[k] < valor){
            k++;
        }
        aux = buscar(valor, n.filho[k]);
        if( aux != null){
            return aux;
        }
        return null;
    }
    

    void remover(int valor){
        
    }
    boolean buscar(int valor){
       if(buscar(valor,raiz) != null){       
            return true; 
       }
       return false;
    }

}
