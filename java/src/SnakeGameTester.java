import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class SnakeGameTester {
//test length, if tail is found, and the amount of checks
    //remember to add notes about the test cases (justify them and tell if it passes or failed)

    @Test
    public void findTailExhaustive1() {
        int [][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int R = 1;
        int C = 1;
        SnakeGame sol = new SnakeGame(arr);

        assertEquals(0, sol.neighbors(R, C) );
    }

    @Test
    public void findTailRecursive1() {
        int [][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int R = 1;
        int C = 1;
        SnakeGame sol = new SnakeGame(arr);

        assertEquals(0, sol.neighbors(R, C) );
    }

}
