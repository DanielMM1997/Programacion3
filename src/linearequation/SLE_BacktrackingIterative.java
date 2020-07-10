package linearequation;

import Iterador.IteradorBacktracking;

public class SLE_BacktrackingIterative {

    private IteradorBacktracking ite;
    
    public SLE_BacktrackingIterative(int[] coeff, int min_value, int max_value, int ind){
        ite = new IteradorBacktracking(coeff, min_value, max_value, ind);
    }
    
    public int count(int coeff[], int rhs) {
        int count = 0;
        int c = 0;
        while (ite.hasNext()) {
            int[] comb = ite.next();
            c++;
            if (evaluate(comb, coeff) == rhs) {
                count++;
            }            
        }
        System.out.println(c);
        return count;
    }
    
    public int evaluate(int[] comb, int[] coeff) {
        int res = 0;
        for (int i = 0; i < comb.length; i++) {
            res += comb[i] * coeff[i];            
        }
        return res;
    }
    
    public void print() {
        while(ite.hasNext()){
            for (int i : ite.next()) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
