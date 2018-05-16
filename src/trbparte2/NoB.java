package trbparte2;

public class NoB {
    
    static final int T = 2;
    static final int MAX = 2 * T;
    static final int MIN = T;
    int tamanho;
    int chave[] = new int[MAX+1];
    NoB filho[] = new NoB[MAX + 2];
    

    public NoB() {
        for(int i = 0; i <= MAX; i++){
            chave[i] = 0;
            filho[i] = null;
        }
        filho[MAX+1] = null;
        tamanho = 0;      
    }
    
    int getPos(int valor){

        for(int i = 0; i < tamanho; i++){

            if(chave[i] == valor) return i;

        }
        return -1;

    }///Retorna a posicao do 'valor' no vetor chave.
     /// Para facilitar, os nós permitem uma chave a mais (buffer na posição MAX).    
}
