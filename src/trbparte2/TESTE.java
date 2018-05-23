/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trbparte2;
import java.util.Scanner;

public class TESTE extends ED2_pt2{
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
                a.insere(Integer.parseInt(Q[i].id));
                
            }
    }
 
}
