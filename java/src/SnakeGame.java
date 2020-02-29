public class SnakeGame {

    private boolean [][] game;
    private int [] headPosition = new int [2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame(){
        this.game = new boolean [1][1];
    }

    public SnakeGame(boolean [][] arry, int x, int y){
        this.game = new boolean[arry.length][arry[0].length];

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

        if((C-1) >=0 && game[R][C-1] == true)
            counter ++;

        if((R-1) >=0 && game[R-1][C] == true)
            counter ++;

        if((R+1) < game.length && game[R+1][C] == true)
            counter ++;

        if((C+1) < game.length && game[R][C+1] == true)
            counter ++;

        return counter;
    }

    public int[] findTailExhaustive(){
        resetCounters();
        int [] tailFound = new int [3];
        int tailLength = 0;
        int x;
        int y;

        for(int i=0; i<game.length; i++){
            for(int j=0; j<game[i].length; j++){

                exhaustiveChecks++;

                if(game[i][j] == true){
                    tailLength += 1;

                    if(neighbors(i, j) == 1 && i != headPosition[0] && j != headPosition[1]){
                        x = j;
                        y = i;
                        tailFound[0] = x;
                        tailFound[1] = y;
                    }
                }
            }
        }
        tailFound[2] = tailLength;

        return tailFound;
    }

    public int [] findTailRecursive(){
        resetCounters();
        return findTailRecursive(headPosition, headPosition);
    }

    private int[] findTailRecursive(int [] currentPosition, int [] previousPosition){
        //headPosition is the first position (current position) -> goes to neighbors (current position which makes head position previous position and so on and so forth)
        int x;
        int y;

        if(neighbors(currentPosition[0],currentPosition[1]) == 1 && currentPosition[0] != previousPosition[0] && currentPosition[1] != previousPosition[1]){
            x = currentPosition[0];
            y = currentPosition[1];
            recursiveChecks++;

            return new int [] {x, y, getLength()};
        }
        else{
            int [] neighbor = neighborTracker(currentPosition[0],currentPosition[1],previousPosition[0],previousPosition[1]);

            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            recursiveChecks++;

            return findTailRecursive(neighbor,previousPosition);
        }
    }

    public int[] neighborTracker(int R, int C, int prev, int prev2){ //
        int [] neighborPosition = new int [2];

        //left
        if(((C-1) >=0) && game[R][C-1] == true && R != prev && (C-1) == prev2){
            neighborPosition[0] = R;
            neighborPosition[1] = (C-1);
        }

        //up
        if(R-1 >=0 && game[R-1][C] == true && (R-1) != prev && C != prev2){
            neighborPosition[0] = (R-1);
            neighborPosition[1] = C;
        }

        //down
        if(R+1 < game.length && game[R+1][C] == true && (R+1) != prev && C != prev2){
            neighborPosition[0] = (R+1);
            neighborPosition[1] = C;
        }

        //right
        if(C+1 < game.length && game[R][C+1] == true &&  R == prev && (C+1) == prev2){
            neighborPosition[0] = R;
            neighborPosition[1] = (C+1);
        }

        return neighborPosition;
    }
    
    private int getLength(){
        int tailLength = 0;

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                if(game[i][j]){
                    tailLength++;
                }
            }
        }

        return tailLength;
    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    public static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }

    public static int getRecursiveChecks(){
        return recursiveChecks;
    }
}
