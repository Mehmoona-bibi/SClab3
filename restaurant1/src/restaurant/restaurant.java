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

// default time is one hour/60 mins
public class restaurant {
    Hashtable<Integer, int[]> t= new Hashtable();
    public int[] chef={1,1,1,1}; // 4 chefs
    long[] startTime={0,0,0,0}; //time for each chef
    public int servers=6; // 6 servers
    public int manager=1; // 1 manager
    public int[] table={1,3,8,4};
    // table[0]--> extra large table for 12 people
    // table[1]--> large table for 6 people
    // table[2]--> medium table for 4 people
    // table[3]--> small table for 2 people
    int guests=0; // number of guests
    guest head=null; //head of list
    
    
    
    //-------------adding guests to list------------
    public void serving(int items,int people, float time,int allocate_time){
        list();
        if(head==null){
            head=new guest(guests,items,people);
        }else{
        
            guest temp=new guest(guests,items,people);
            guest cur = head;     
                
            if(cur!=null){
                while(cur.getNext()!=null){
            
                    cur=cur.getNext();
                }
                cur.setNext(temp);
                cur.setTable(allocate_table(people,time));
                if(cur.getTable()==0){
                    cur.total_time=time;
                }else{
                    cur.total_time=60;
                }
                
                cur.settabletime(System.currentTimeMillis());
                cur.setTime(serving_time(items));
            }
        }           
    }
    
    //--------if a guest leave marking table as empty---------
    public void guest_leaving(int id){
        if(head==null){
            System.out.print("NO ELEMENTS");
        }else{      
            guest cur = head;     
                
            if(id==cur.getId()){
                cur.setId(cur.getNext().getId());
                cur.setNext(cur.getNext().getNext());
                 
            }else{
              while(cur.getNext()!= null){
                cur=cur.getNext();
                if(id==cur.getId()){
                    cur.setId(cur.getNext().getId());
                    cur.setNext(cur.getNext().getNext());                    
                }
              }
            }            
            table[cur.getTable()]++;
        }
    }
    
    //-----------calculating serving time--------
    public float serving_time(int items){
        int c=-1; // number of chefs working on one order
        for(int i=0;i<4;i++){
            if(chef[i]!=0){ // if chef is not available
                // checking the time required for thr the chef to complete previous order
                //time is assumed in 1 milliseconds == 1 minute 
               long remain= System.currentTimeMillis()- startTime[i]; 
               if(remain >30){
                   chef[i]=0;
                   startTime[i]=0;
               }
            }
            if(chef[i]==0){ // if chef is available
                startTime[i]=System.currentTimeMillis(); // start timer for that order
                chef[i]=1;
                c++; // number of chefs working on that order plus 1
            }
        }
        float t =times(items-c);//time for that order to complete
        System.out.print("Time in serving is "+t+" mins");
        return t; // time for serving
    }
    //time for order to be completed
    public float times(int items)
    {
        float time;
        time= (items * 30);
        return time;        
    }   
    
    //--------allocation of table-----------
    public int allocate_table(int persons,float time){
        int t=-1; // no table at the moment
        if(persons<=2 && table[3]>0){ // if persons less than or equal to 2
            t=allocate(3,time);
        }else{
            if(persons<=4 && table[2]>0){ // if persons less than or equal to 4
                
           t=allocate(2,time);
            }else{
                if(persons<=6 && table[1]>0){ // if persons less than or equal to 6
                    t=allocate(1,time);
                }else{
                    if(persons<=12 && table[0]>0){ // if persons less than or equal to 12
                        t=allocate(0,time);
                    }else{
                        System.out.print("No table available \n"); 
                    }
                }
            }
        }
        return t;
    }
    //allocation of table
    public int allocate(int i,float t){
        int assign =0;
        int j;
        for(j=i;j>=0;j--){
            if(table[j]>0){
                table[j]--;
                
                if(j==0){
                System.out.print("Table "+j+" is assigned to you and time is "+t+" min\n");
                }else{
                    System.out.print("Table "+j+" is assigned to you and time is 60 min only\n");
                }
                assign=1;
                
                break;
            }
        }
        if(assign==0){
            System.out.print("Sorry! No tables available :) \n");
            j=-1;
        }
        return j;
    }
    
    //add list
    public void list(){
        t.put(11,table);
        t.put(12,table);
        t.put(1,table);
        t.put(2,table);
        t.put(3,table);
        t.put(4,table);
        t.put(5,table);
        t.put(6,table);
        t.put(7,table);
        t.put(8,table);
        t.put(9,table);
        t.put(10,table);
    }
}
