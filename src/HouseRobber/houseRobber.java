package HouseRobber;

import Iterator.*;

public class houseRobber {
    int[] casa = {3, 10, 3, 1, 2};
    IteradorCombinaciones ite = new IteradorCombinaciones(casa.length, 0, 1);

    public int robber(int tam, int min, int max) {
        int bestComb = 0;
        while (ite.hasNext()) {
            int[] comb = ite.next();
            int res = 0;
            if (isValid(comb)) {
                res = evalua(comb);
            }
            if (res > bestComb) {
                bestComb = res;
            }
        }
        return bestComb;
    }
    
    public boolean isValid(int[] comb) {
        for (int i = 0; i < comb.length-1; i++) {
            if (comb[i] == 1 && comb[i+1] == 1) {
                return false;
            }
        }
        return true;
    }
    
    public int evalua(int[] comb) {
        int suma = 0;
        for (int i = 0; i < comb.length; i++) {
            if(comb[i] == 1) {
                suma += casa[i];
            }
        }
        return suma;
    }
}
