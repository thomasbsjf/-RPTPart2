package trbparte2;

public class NoSplay {
    NoSplay proximo, anterior, pai;
    int valor;

    public NoSplay(int valor) {
        this.proximo = null;
        this.anterior = null;
        this.pai = null;
        this.valor = valor;
    }

    public NoSplay getProximo() {
        return proximo;
    }

    public void setProximo(NoSplay proximo) {
        this.proximo = proximo;
    }

    public NoSplay getAnterior() {
        return anterior;
    }

    public void setAnterior(NoSplay anterior) {
        this.anterior = anterior;
    }

    public NoSplay getPai() {
        return pai;
    }

    public void setPai(NoSplay pai) {
        this.pai = pai;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
