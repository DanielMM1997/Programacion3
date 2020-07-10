package MatrixChainMultiplication;

public class MCM_Tabulation {

    public int tabulation(int dims[], int p, int u) {
        int d = dims.length-1;
        int[][] cache = new int[u+1][u+1];
        for(int length = 1; length < d; length++) {
            int n = 0;
            while ((n + length) < d) {
                int min = cache[n][n] + cache[n+1][n+length] + 
                                dims[n]*dims[n+1]*dims[n+length+1];
                for (int i = n+1; i < n+length; i++) {
                    int cost = cache[n][i] + cache[i+1][n+length] + 
                                    dims[n]*dims[i+1]*dims[n+length+1];
                    if (cost < min) {
                        min = cost;
                    }
                }
                cache[n][n+length] = min;
                n++;
            }
        }
        return cache[0][u];
    }
}