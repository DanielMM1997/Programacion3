package Iterador;
import java.util.Iterator;

public class IteradorCombinaciones implements Iterator<int[]>{
    
    private final int[] counters;
    private final int minValue, maxValue;

    public IteradorCombinaciones(int n, int minValue, int maxValue) {
        this.counters = new int[n];
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.reset();
    }

    @Override
    public boolean hasNext() {
        return counters[0] <= maxValue;
    }

    @Override
    public int[] next() {
        int[] res = new int[counters.length];
        System.arraycopy(counters, 0, res, 0, counters.length);        
        int i;
        for(i = counters.length - 1; counters[i] == maxValue && i > 0; i--){
            counters[i] = minValue;
        }
        counters[i]++;        
        return res;
    }
    
    public void reset(){
        for (int i = 0; i < counters.length; i++) {
            counters[i] = minValue;
        }
    }   
}
