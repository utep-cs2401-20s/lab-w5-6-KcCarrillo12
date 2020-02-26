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

    public int neighbors(int R, int C){
        int counter = 0;

        if(((C-1) >=0) && ((C-1) < game.length) && (R >=0) && (R < game.length) && game[R][C-1] == true)
            counter ++;

        if((C >=0) && (C < game.length) && ((R-1) >=0) && ((R-1) < game.length) && game[R-1][C] == true)
            counter ++;

        if((C >=0) && (C < game.length) && ((R+1) >=0) && ((R+1) < game.length) && game[R+1][C] == true)
            counter ++;

        if(((C+1) >=0) && ((C+1) < game.length) && (R >=0) && (R < game.length) && game[R][C+1] == true)
            counter ++;

        return counter;
    }

    public int[] findTailExhaustive(){
        resetCounters();
        int [] tailFound = new int [3];
        int tailLength = 0;
        int x;
        int y;

        for(int i=0; i<game.length; i++) {
            for(int j=0; j<game[i].length; j++){
                if(game[i][j] == true){
                    if(game[i][j] && neighbors(i, j)  == 1 && game[i][j] != headPosition) {
                        tailLength += 1;
                        x = i;
                        y = j;
                    }
                    else
                        exhaustiveChecks--;
                }
                exhaustiveChecks++;
            }
        }

        return tailFound{x  , y, tailLength};
        //return an array of int size 3 (includes tail position and the length) [tail x, tail y, length]
    }


    public int[] findTailRecursive(){
        resetCounters();
        return findTailRecursive(int[] currentPosition, int[] previousPosition);

        //return an array of int size 3 (includes tail position and the length) [tail x, tail y, length]
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        //headPosition is the first position (current position) -> goes to neighbor (current position which makes head position previous position and so on and so forth)
        int [] currentPosition = {headPosition};
        int [] previousPosition; //i dont know what im doing rn i need a nap. i figure out later /.\
        int [] tailFound = new int [3];
        int tailLength = 0;
        int x;
        int y;

        if()
        return tailFound{x, y, tailLength};
    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    public static int getRecursiveChecks(){
        return findTailRecursive();
    }

    public static int getExhaustiveChecks(){
        return findTailExhaustive();
    }
}

    //exastivley- going through every possible way to find it
    //nested for loop
    //check how many cells are checked

    //recursivley- using recurssion  >0)
    //stop: finds tail                (>) <--- its a duck
    //recursive call: find neighbors and call recursive call on the neighbor until tail is found
    //check how many cells are checked
