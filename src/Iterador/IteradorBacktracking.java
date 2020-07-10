package Iterador;

import java.util.Iterator;

public class IteradorBacktracking implements Iterator<int[]> {

    private final int[] counters;
    private final int[] coeff;
    private final int minValue;
    private final int maxValue;
    private final int ind;

    public IteradorBacktracking(int[]coeff, int minValue, int maxValue, int ind) {
        this.counters = new int[coeff.length];
        this.coeff = coeff;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.ind = ind;
        this.reset();
    }

    @Override
    public boolean hasNext() {
        return counters[coeff.length-1] <= ind/coeff[coeff.length-1];
    }

    @Override
    public int[] next() {
        int[] res = new int[counters.length];
        System.arraycopy(counters, 0, res, 0, counters.length);
        int i;
        for(i = counters.length - 1; counters[i] >= maxValue && i > 0; i--){
            counters[i] = minValue;
        }        
        counters[i]++; 
        foo(); 
        return res;
    }
    
    private void foo(){
        int res = 0;
        for (int i = 0; i < counters.length; i++) {
            //calculo el resultado de la combinacion
            res += counters[i]*coeff[i];            
        }
        // Si el resultado es mayor que el numero que buscamos
        if (res > ind) {
            //entonces avanzo a la siguiente combinacion
            if (hasNext()) {
                next();
            }
        }
    }
    
    public void reset() {
        for (int i = 0; i < counters.length; i++) {
            counters[i] = minValue;
        }
    }
}
