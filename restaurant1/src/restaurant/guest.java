/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.Hashtable;

/**
 *
 * @author mehmoona
 */

///////guests
public class guest {
    
    private int id;
    private int table;
    private int items;
    private int people;
    private float serve_time;
    private float start_time;
    public float total_time =60;
    public int allotime=0;
    private guest next;
    
    public guest(int id,int items, int people){
        this.id=id;
        this.items=items;
        this.people=people;
    }
    
    public void setTable(int tab){
      table =tab;
    }
    
    public int getTable(){
      return table;
    }
    
    public void setId(int i){
      id =i;
    }
    
    public int getId(){
      return id;
    }
    
    public void settabletime(float i){
      start_time =i;
    }
    
    public float gettabletime(){
      return start_time;
    }
    
    public void setTime(float time){
      serve_time =time;
    }
    
    public guest getNext(){
      return next;
    }
  
    public void setNext(guest c){ 
      next=c;
    }
    
}
