import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class SnakeGameTester {
//test length, if tail is found, and the amount of checks
    //remember to add notes about the test cases (justify them and tell if it passes or failed)

    @Test
    public void findTailExhaustive1(){ //tests to see if tail is found and length
        boolean[][] arr = {{true, true, true},
                          {false, false, true},
                          {false, true, true}};
        int[] testArr = {1,2,6};
        SnakeGame sol = new SnakeGame(arr, 0, 0);
        assertArrayEquals(testArr, sol.findTailExhaustive());
    }

    @Test
    public void findTailExhaustive2(){ //tests to see if tail is found and length
        boolean[][] arr = {{false, false, false, false, false, false},
                          {true, true, true, true, false, false},
                          {true, false, false, true, true, true},
                          {true, false, false, false, false, true},
                          {false, false, true, true, true, true},
                          {false, false, true, false, false, false}};
        int[] testArr = {2,5,15};
        SnakeGame sol = new SnakeGame(arr, 0, 3);
        assertArrayEquals(testArr, sol.findTailExhaustive());
    }

    @Test
    public void findTailExhaustive3(){ //tests amount of checks
        boolean[][] arr = {{false, false, false, false, false},
                           {true, true, true, false, false},
                           {true, false, true, false, false},
                           {true, false, true, false, false},
                           {false, false, true, false, false}};
        int testChecks = 25;
        SnakeGame sol = new SnakeGame(arr, 2, 4);
        sol.findTailExhaustive();
        assertEquals(testChecks, sol.getExhaustiveChecks());
    }

    @Test
    public void findTailExhaustive4(){ //tests amount of checks
        boolean[][] arr = {{false, false, false},
                           {true, true, true},
                           {true, false, true}};
        int testChecks = 9;
        SnakeGame sol = new SnakeGame(arr, 0, 2);
        sol.findTailExhaustive();
        assertEquals(testChecks, sol.getExhaustiveChecks());
    }

    @Test
    public void findTailExhaustive5(){ //tests length, if tail is found and amount of checks
        boolean[][] arr = {{false, false, false, false},
                           {true, true, true, false},
                           {true, false, true, true}};
        int[] testArr = {3,2,6};
        int testChecks = 12;

        SnakeGame sol = new SnakeGame(arr, 4, 0);
        assertArrayEquals(testArr, sol.findTailExhaustive());
        sol.findTailExhaustive();
        assertEquals(testChecks, sol.getExhaustiveChecks());
    }

    @Test
    public void findTailRecursive1(){
        boolean[][] arr = {{true, true, true},
                          {false, false, true},
                          {false, true, true}};
        int[] testArr = {0,0,6};
        SnakeGame sol = new SnakeGame(arr, 1, 2);
        assertArrayEquals(testArr,sol.findTailRecursive());
    }

    @Test
    public void findTailRecursive2(){ //tests to see if tail is found and length
        boolean[][] arr = {{false, false, false, false, false, false},
                {true, true, true, true, false, false},
                {true, false, false, true, true, true},
                {true, false, false, false, false, true},
                {false, false, true, true, true, true},
                {false, false, true, false, false, false}};
        int[] testArr = {0,0,15};
        SnakeGame sol = new SnakeGame(arr, 0, 3);
        assertArrayEquals(testArr, sol.findTailRecursive());
    }

    @Test
    public void findTailRecursive3(){ //tests amount of checks
        boolean[][] arr = {{false, false, false, false, false},
                {true, true, true, false, false},
                {true, false, true, false, false},
                {true, false, true, false, false},
                {false, false, true, false, false}};
        int testChecks = 2;
        SnakeGame sol = new SnakeGame(arr, 2, 4);
        sol.findTailRecursive();
        assertEquals(testChecks, sol.getRecursiveChecks());
    }

    @Test
    public void findTailRecursive4(){ //tests amount of checks
        boolean[][] arr = {{false, false, false},
                {true, true, true},
                {true, false, true}};
        int testChecks = 4;
        SnakeGame sol = new SnakeGame(arr, 0, 2);
        sol.findTailRecursive();
        assertEquals(testChecks, sol.getRecursiveChecks());
    }

    @Test
    public void findTailRecursive5(){ //tests length, if tail is found and amount of checks
        boolean[][] arr = {{true, true, true},
                           {false, false, true},
                           {false, true, true}};
        int[] testArr = {0,0,6};
        int testChecks = 13;

        SnakeGame sol = new SnakeGame(arr, 0, 0);
        assertArrayEquals(testArr, sol.findTailRecursive());
        sol.findTailRecursive();
        assertEquals(testChecks, sol.getRecursiveChecks());
    }
}
