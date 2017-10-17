/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasalgo2genap;

/**
 *
 * @author nurudin72
 */
public class TugasAlgo2Genap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyInputStream keyboard = new MyInputStream();
        
        System.out.println("Enter Number of Element");
        int n = keyboard.readInteger();
        if (n < 2)
        {
            System.out.println("Too few Element");
            System.exit(1);
        }
        System.out.println("Enter Number of Relations");
        int r = keyboard.readInteger();
        if(r<1)
        {
        System.out.println("Too few Realitions");
        System.exit(1);
        }
        
        ArrayStack [] list = new ArrayStack[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new ArrayStack();
        for(int i = 1; i <= r; i++){
            System.out.println("Enter next Realation/Pair");
            int a = keyboard.readInteger();
            int b = keyboard.readInteger();
            list[a].push(new Integer(b));
            list[b].push(new Integer(a));
        }
        
        ArrayStack unprocessedList = new ArrayStack();
        boolean [] out = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++)
            if(!out[i])
            {
                System.out.println("Next class is : "+ i +" ");
                out[i] = true;
                unprocessedList.push(new Integer(i));
                while(!unprocessedList.empty())
                {
                    int j = ((Integer) unprocessedList.pop()).intValue();
                    while(!list[j].empty()){
                        int q = ((Integer) list[j].pop()).intValue();
                        if(!out[q]){
                            System.out.println(q+" ");
                            out[q] = true;
                            unprocessedList.push(new Integer(q));
                        }
                    }
                }
                System.out.println();
            }
        System.out.println("End of List of Equivalence Classes");
    }
    
}
