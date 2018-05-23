package trbparte2;
import java.util.Scanner;

public class TESTE extends OperadorQuestions{
    int x;

    public TESTE(int x) {
        super(x);
        this.x=x;
        AVL();
    }
    
    void setx(int x)
    {
        this.x=x;
    }

    void AVL()
    {
        Questions[]Q=new Questions[x];
        Q=super.Inicia(x);
        AVL a= new AVL();
        for(int i=0;i<x;i++)
        {
            a.Insere(Integer.parseInt(Q[i].id));

        }
    }
 
}
