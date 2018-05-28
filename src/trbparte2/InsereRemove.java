package trbparte2;
import java.util.Scanner;

public class InsereRemove extends OperadorQuestions
{
    int x;

    public InsereRemove(int x, int op) 
    {
        super(x);
        this.x=x;
        switch(op){
            case 1:
                long inicioavl = System.currentTimeMillis();
                InsAVL();
                System.out.println("A insercao da AVL executou em " + (System.currentTimeMillis() - inicioavl)/1000 + " segundos");
                break;
            case 2:    
                long iniciob = System.currentTimeMillis();
                InsArvoreB();
                System.out.println("A insercao da Arvore B executou em " + (System.currentTimeMillis() - iniciob)/1000 + " segundos");
                break;
            case 3:
                long iniciosplay = System.currentTimeMillis();
                InsArvoreSplay();
                System.out.println("A insercao da Arvore Splay executou em " + (System.currentTimeMillis() - iniciosplay)/1000 + " segundos");
                break;
            case 4:    
                long iniciovp = System.currentTimeMillis();
                InsArvoreVP();
                System.out.println("A insercao da Arvore VP executou em " + (System.currentTimeMillis() - iniciovp)/1000 + " segundos");        
                break;
            case 5:
                long inicioREMavl = System.currentTimeMillis();
                RemAVL();
                System.out.println("A remocao da AVL executou em " + (System.currentTimeMillis() - inicioREMavl)/1000 + " segundos");
                break;
            case 6:
                long inicioREMb = System.currentTimeMillis();
                RemArvoreB();
                System.out.println("A remocao da Arvore B executou em " + (System.currentTimeMillis() - inicioREMb)/1000 + " segundos");
                break;
            case 7:
                long inicioREMvp = System.currentTimeMillis();
                RemArvoreVP();
                System.out.println("A remocao da Arvore VP executou em " + (System.currentTimeMillis() - inicioREMvp)/1000 + " segundos");
                break;
            default:
                System.out.println("Numero invalido");
        }
    }
    
    void setx(int x)
    {
        this.x=x;
    }

    void InsAVL()
    {
        Questions[]Q=new Questions[x];
        Q=super.Inicia(x);
        AVL a= new AVL();
        for(int i=0;i<x;i++)
        {
            a.Insere(Integer.parseInt(Q[i].id));

        }
    }

    void InsArvoreB()
    {
        Questions[] Q = new Questions[x];
        Q=super.Inicia(x);
        ArvoreB a = new ArvoreB();
        for(int i=0; i<x; i++)
        {
            a.inserir(Integer.parseInt(Q[i].id));
        }
    }  

    void InsArvoreSplay()
    {
        Questions[] Q = new Questions[x];
        Q=super.Inicia(x);
        ArvoreSplay a = new ArvoreSplay();
        for(int i=0; i<x; i++)
        {
            a.insere(Integer.parseInt(Q[i].id));
        }
    }

    void InsArvoreVP()
    {
        Questions[] Q = new Questions[x];
        Q=super.Inicia(x);
        ArvoreVP a = new ArvoreVP();
        for(int i=0; i<x; i++)
        {
            a.insere(Integer.parseInt(Q[i].id));
        }
    }
    
    void RemAVL()
    {
        Questions[]Q=new Questions[x];
        Q=super.Inicia(x);
        AVL a= new AVL();
        for(int i=0;i<x;i++)
        {
            a.Remover(Integer.parseInt(Q[i].id));

        }
    }

    void RemArvoreB()
    {
        Questions[] Q = new Questions[x];
        Q=super.Inicia(x);
        ArvoreB a = new ArvoreB();
        for(int i=0; i<x; i++)
        {
            a.remover(Integer.parseInt(Q[i].id));
        }
    }  

    void RemArvoreVP()
    {
        Questions[] Q = new Questions[x];
        Q=super.Inicia(x);
        ArvoreVP a = new ArvoreVP();
        for(int i=0; i<x; i++)
        {
            a.remover(Integer.parseInt(Q[i].id));
        }
    }
    
}
