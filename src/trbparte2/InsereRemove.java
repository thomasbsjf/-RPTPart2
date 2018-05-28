package trbparte2;
import java.util.Scanner;

public class InsereRemove extends OperadorQuestions
{
    int x;

    public InsereRemove(int x) 
    {
        super(x);
        this.x=x;
        long inicioavl = System.currentTimeMillis();
        InsAVL();
        System.out.println("A insercao da AVL executou em " + (System.currentTimeMillis() - inicioavl)/1000 + " segundos");
        long iniciob = System.currentTimeMillis();
        InsArvoreB();
        System.out.println("A insercao da Arvore B executou em " + (System.currentTimeMillis() - iniciob)/1000 + " segundos");
        long iniciosplay = System.currentTimeMillis();
        InsArvoreSplay();
        System.out.println("A insercao da Arvore Splay executou em " + (System.currentTimeMillis() - iniciosplay)/1000 + " segundos");
        long iniciovp = System.currentTimeMillis();
        InsArvoreVP();
        System.out.println("A insercao da Arvore VP executou em " + (System.currentTimeMillis() - iniciovp)/1000 + " segundos");        
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
    
    
}
