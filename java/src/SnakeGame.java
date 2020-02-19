public class SnakeGame {

    private boolean [][] game;
    private int [] headPosition = new int[2];
    private static int exhaustiveChecks = 0;
    private static int recursiveChecks = 0;

    public SnakeGame(){
        game = new boolean [1][1];
    }

    public SnakeGame(boolean [][] arry, int x, int y){
        for(int i=0; i<arry.length; i++){
            for(int j=0; j<arry[i].length; j++){
                game[i][j] == arry[i][j];
            }
        }

        headPosition[0] = x;
        headPosition[1] = y;
    }

    public int[] findTailExhaustive(){
        resetCounters();
        int tailCounter = 0;

        for(int i=0; i<game.length; i++) {
            for(int j=0; j<game[i].length; j++){
                exhaustiveChecks++;

                if(game[i][j] == 1){
                    tailCounter += 1;
                }
            }
        }
        //return an array of int size 3 (includes tail position and the length) [tail x, tail y, length]
    }

    public int[] findTailRecursive(){
        //return an array of int size 3 (includes tail position and the length) [tail x, tail y, length]
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){

    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getRecursiveChecks(){

    }

    private static int getExhaustiveChecks(){

    }
}

    //exastivley- going through every possible way to find it
    //nested for loop
    //check how many cells are checked

    //recursivley- using recurssion
    //stop: finds tail
    //recursive call: find neighbors and call recursive call on the neighbor until tail is found
    //check how many cells are checked
