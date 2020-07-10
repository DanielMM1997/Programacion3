package MatrixChainMultiplication;

public class MCM_BruteForceRecursive {
    
    public int MatrixChainMultiplication(int[] dims, int p, int u) {
        if (p >= u) {
            return 0;
        }
        int ope_min = MatrixChainMultiplication(dims, p, p) + 
                MatrixChainMultiplication(dims, p+1, u) + dims[p]*dims[p+1]*dims[u+1];
        for (int i = p+1; i < u; i++) {
            int ope = MatrixChainMultiplication(dims, p, i) + 
                    MatrixChainMultiplication(dims, i+1, u) + dims[p]*dims[i+1]*dims[u+1];
            if (ope < ope_min) {
                ope_min = ope;
            }
        }
        return ope_min;
    }    
}
