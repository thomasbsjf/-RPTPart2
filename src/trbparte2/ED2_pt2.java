/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trbparte2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ED2_pt2 {
    public int x;
    protected
    ED2_pt2(int x)
    {
        this.x=x;
    }
 public Questions[] Inicia(int x)
 {
         Questions [] Q = new Questions [x];
    criaVetorQuestions(x,Q);
    
    for(int i=0;i<x;i++)
    {
        System.out.println(Q[i].id);
    }
    return Q;
 }
 public static void criaVetorQuestions(int N,Questions[] Q)  
    {   
        try(FileReader f=new FileReader("Questions2.txt"))
        {
            try (Scanner questions = new Scanner(f)) {
                int i=0;
                Questions q ;
                String user,data,score,title;
                String id;
                int g=0;
                while(questions.hasNext()&&g<N)
                {
                    id=questions.nextLine();
                    user=questions.nextLine();
                    data=questions.nextLine();
                    score=questions.nextLine();
                    title=questions.nextLine();
                    System.out.println(title);
                    if(!id.contains("NA"))
                    {Q[g]=new Questions(id,user,data,score,title);
                            g++;}
                                
                    
                }
            }
        try
        {

        }
            catch (Exception e)
            {
                
            }


        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}

