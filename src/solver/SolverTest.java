package solver;

import java.io.IOException;

/**
 * Created by Richard Harrington on 11/3/2014.
 */
public class SolverTest {

    public static void main(String args[]) {
        Solver solver = new Solver();
        try {
            solver.solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
