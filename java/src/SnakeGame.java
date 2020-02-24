public class SnakeGame {

    private boolean [][] game;
    private int [] headPosition = new int[2];
    private static int exhaustiveChecks = 0;
    private static int recursiveChecks = 0;

    public SnakeGame(){
        this.game = new boolean [1][1];
    }

    public SnakeGame(boolean [][] arry, int x, int y){
        for(int i=0; i<arry.length; i++){
            for(int j=0; j<arry[i].length; j++){
                game[i][j] = arry[i][j];
            }
        }

        headPosition[0] = x;
        headPosition[1] = y;
    }

    public int[] findTailExhaustive(){
        resetCounters();
        int [] tailFound = new int [3];
        int tailLength = 0;
        int x;
        int y;

        for(int i=0; i<game.length; i++) {
            for(int j=0; j<game[i].length; j++){
                if(game[i][j] == 1){
                    if(game[i][j] && neighbors(i, j)  == 1 && game[i][j] != headPosition) {
                        tailLength += 1;
                        x = i;
                        y = j;
                    }
                    else
                        exhaustiveChecks--;
                }
                exhaustiveChecks++b ;
            }
        }

        return tailFound(x  , y, tailLength);
        //return an array of int size 3 (includes tail position and the length) [tail x, tail y, length]
    }

    public int neighbors(int R, int C){
        int counter = 0;

        if(((C-1) >=0) && ((C-1) < game.length) && (R >=0) && (R < game.length) && game[R][C-1] == 1)
            counter ++;

        if((C >=0) && (C < game.length) && ((R-1) >=0) && ((R-1) < game.length) && game[R-1][C] == 1)
            counter ++;

        if((C >=0) && (C < game.length) && ((R+1) >=0) && ((R+1) < game.length) && game[R+1][C] == 1)
            counter ++;

        if(((C+1) >=0) && ((C+1) < game.length) && (R >=0) && (R < game.length) && game[R][C+1] == 1)
            counter ++;

        return counter;
    }

    public int[] findTailRecursive(){
        resetCounters();
        int [] tailFound = new int [3];
        int tailLength = 0;


        //return an array of int size 3 (includes tail position and the length) [tail x, tail y, length]
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){

    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getRecursiveChecks(){
        return findTailRecursive();
    }

    private static int getExhaustiveChecks(){
        return findTailExhaustive();
    }
}

    //exastivley- going through every possible way to find it
    //nested for loop
    //check how many cells are checked

    //recursivley- using recurssion
    //stop: finds tail
    //recursive call: find neighbors and call recursive call on the neighbor until tail is found
    //check how many cells are checked
