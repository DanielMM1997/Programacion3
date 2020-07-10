package MatrixChainMultiplication;

import java.util.HashMap;

public class MCM_Memoization {
    
    public int MatrixChainMultiplication(int dims[], int p, int u) {
        HashMap<String, Integer> cache = new HashMap<>();
        return memoization(dims, p, u, cache);
    }
    
    private int memoization(int dims[], int p, int u, HashMap<String, Integer> cache) {
        if (p >= u) {
            return  0;
        }
        String key = p + "|" + u;
        if (!cache.containsKey(key)) {
            int min = memoization(dims, p, p, cache) + memoization(dims, p+1, u, cache) 
                    + dims[p]*dims[p+1]*dims[u+1];
            for (int i = p+1; i < u; i++) {
                int cost = memoization(dims, p, i, cache) + 
                            memoization (dims, i+1, u, cache) + 
                                dims[p]*dims[i+1]*dims[u+1];
                if (cost < min) {
                    min = cost;
                }
            }
            cache.put(key, min);
        }  
        return cache.get(key);        
    }
}