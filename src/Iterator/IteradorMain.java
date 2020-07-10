package Iterator;

import HouseRobber.houseRobber;

public class IteradorMain {

    public static void main(String[] args) {
        IteradorCombinaciones it = new IteradorCombinaciones(4, 0, 1);
        /*
        while(it.hasNext()) {
            for (int i : it.next()) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }*/
        houseRobber ro = new houseRobber();
        System.out.println(ro.robber(4, 0, 1));
    }    
}
