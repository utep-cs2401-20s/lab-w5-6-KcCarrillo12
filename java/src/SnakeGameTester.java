import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class SnakeGameTester {
//test length, if tail is found, and the amount of checks
    //remember to add notes about the test cases (justify them and tell if it passes or failed)

    @Test
    public void findTailExhaustive1(){         //This Test Case is used to see if the tail and the length of the snake are found properly.
        boolean[][] arr = {{true, true, true}, //In this case the test passed.
                          {false, false, true},
                          {false, true, true}};
        int[] testArr = {1,2,6};
        SnakeGame sol = new SnakeGame(arr, 0, 0);
        assertArrayEquals(testArr, sol.findTailExhaustive());
    }

    @Test
    public void findTailExhaustive2(){                                //This Test Case is used to see if the tail and the length of the snake are found properly.
        boolean[][] arr = {{false, false, false, false, false, false},//In this case the test passed.
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
    public void findTailExhaustive3(){                        //This Test Case is used to see if the getExhaustiveChecks method is working properly.
        boolean[][] arr = {{false, false, false, false, false},//This test passed.
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
    public void findTailExhaustive4(){            //This Test Case is used to see if the getExhaustiveChecks method is working properly.
        boolean[][] arr = {{false, false, false},//This test passed.
                           {true, true, true},
                           {true, false, true}};
        int testChecks = 9;
        SnakeGame sol = new SnakeGame(arr, 0, 2);
        sol.findTailExhaustive();
        assertEquals(testChecks, sol.getExhaustiveChecks());
    }

    @Test
    public void findTailExhaustive5(){                 //This Test Case is used to see if the length and the tail of the snake are found properly.
        boolean[][] arr = {{false, false, false, false},//It is also used to see if the getExhaustiveChecks method is working correctly.
                           {true, true, true, false},   //This Test Case passed.
                           {true, false, true, true}};
        int[] testArr = {3,2,6};
        int testChecks = 12;

        SnakeGame sol = new SnakeGame(arr, 4, 0);
        assertArrayEquals(testArr, sol.findTailExhaustive());
        sol.findTailExhaustive();
        assertEquals(testChecks, sol.getExhaustiveChecks());
    }

    @Test
    public void findTailRecursive1(){         //This Test Case is used to see if the tail and the length of the snake are found properly.
        boolean[][] arr = {{true, true, true},//This Test Case passed.
                          {false, false, true},
                          {false, true, true}};
        int[] testArr = {0,0,6};
        SnakeGame sol = new SnakeGame(arr, 1, 2);
        assertArrayEquals(testArr,sol.findTailRecursive());
    }

    @Test
    public void findTailRecursive2(){                                //This Test Case is used to see if the tail and the length of the snake are found properly.
        boolean[][] arr = {{true, false, false, false, false, false},//This Test Cass passed.
                            {true, true, true, true, false, false},
                            {false, false, false, true, true, true},
                            {false, false, false, false, false, true},
                            {false, false, true, true, true, true},
                            {false, false, true, false, false, false}};
        int[] testArr = {0,0,14};
        SnakeGame sol = new SnakeGame(arr, 5, 2);
        assertArrayEquals(testArr, sol.findTailRecursive());
    }

    @Test
    public void findTailRecursive3(){                           //This Test Case is used to see if the getExhaustiveChecks method is working properly.
        boolean[][] arr = {{false, false, false, false, false}, //This Test Cases did not pass. (Said actual was 2 not 6)
                           {true, true, true, false, false},
                           {false, false, true, false, false},
                           {false, false, true, false, false},
                           {false, false, true, false, false}};
        int testChecks = 6;
        SnakeGame sol = new SnakeGame(arr, 4, 2);
        sol.findTailRecursive();
        assertEquals(testChecks, sol.getRecursiveChecks());
    }

    @Test
    public void findTailRecursive4(){             //This Test Case is used to see if the getExhaustiveChecks method is working properly.
        boolean[][] arr = {{false, false, false}, //This Test Cases did not pass. (Said actual was 2 not 5)
                           {true, true, true},
                           {true, false, true}};
        int testChecks = 5;
        SnakeGame sol = new SnakeGame(arr, 2, 2);
        sol.findTailRecursive();
        assertEquals(testChecks, sol.getRecursiveChecks());
    }

    @Test
    public void findTailRecursive5(){           //This Test Case is used to see if the length and the tail of the snake are found properly.
        boolean[][] arr = {{true, true, true},  //It is also used to see if the getExhaustiveChecks method is working correctly.
                           {false, false, true},//This Test Cases did not pass. (said actual was 2 not 6)
                           {false, true, true}};
        int[] testArr = {0,0,6};
        int testChecks = 6;

        SnakeGame sol = new SnakeGame(arr, 2, 2);
        assertArrayEquals(testArr, sol.findTailRecursive());
        sol.findTailRecursive();
        assertEquals(testChecks, sol.getRecursiveChecks());
    }
}
