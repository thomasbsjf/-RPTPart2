/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trbparte2;


public class Questions {
    String id;
    String user,data,score,title;

    public Questions(String id, String user, String data, String score, String title){
        this.id = id;
        this.user = user;
        this.data = data;
        this.score = score;
        this.title = title;
    }
    
   void imprime()
   {
        System.out.println("id "+id);
        System.out.println("usr " +user);
        System.out.println("data " +data);
        System.out.println("score "+score);
        System.out.println("title "+title);
   }
}