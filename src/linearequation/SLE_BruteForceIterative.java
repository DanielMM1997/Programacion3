package linearequation;

import Iterador.IteradorCombinaciones;

public class SLE_BruteForceIterative {

    private final IteradorCombinaciones ite;
    
    public SLE_BruteForceIterative(int n, int min_value, int max_value) {
        ite = new IteradorCombinaciones(n, min_value, max_value);
    }
    
    public int count(int coeff[], int rhs) {
        int count = 0;
        while (ite.hasNext()) {
            int[] comb = ite.next();
            if (evaluate(comb, coeff) == rhs) {
                count++;
            }
        }
        return count;
    }
    
    public int evaluate(int[] comb, int[] coeff) {
        int res = 0;
        for (int i = 0; i < comb.length; i++) {
            res += comb[i] * coeff[i];            
        }
        return res;
    }   
}
