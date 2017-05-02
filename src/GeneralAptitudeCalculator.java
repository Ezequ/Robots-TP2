import java.util.ArrayList;

/**
 * Created by ezequiel on 01/05/17.
 */
public class GeneralAptitudeCalculator extends AptitudeCalculator {

    public static final int SIZE_BOARD = 12;
    public static final int SIZE_BOARD_SQUARE = 144;

    private ArrayList<Integer> positions;

    @Override
    // This method calculates aptitude based on how many queens from cromosom are in jaque
    public float calculateAptitude(Cromosom cromosom) {
        int countCromosoms = 0;
        this.positions = cromosom.getPositions();
        // This for structure check if this queen is in jaque
        for (Integer position: positions){
            boolean isInJaque = hasOtherQueenInHorizontal(position) || hasOtherQueenInVertical(position);
            if (isInJaque){
                countCromosoms++;
            }
        }
        return (float) 1 / countCromosoms;
    }
    
    private boolean hasOtherQueenInHorizontal(int currentPosition){
        int minHorizontal = (int) (Math.floor(currentPosition / SIZE_BOARD)) * SIZE_BOARD;
        int maxHorizontal = minHorizontal + SIZE_BOARD;
        for (Integer x: positions){
            if (currentPosition != x && x >= minHorizontal && x < maxHorizontal){
                return true;
            }
        }
        return false;
    }

    private boolean hasOtherQueenInVertical(int currentPosition){
        int maxSum = currentPosition + SIZE_BOARD_SQUARE;
        ArrayList<Integer> forbidenPositions = new ArrayList<Integer>();
        while (maxSum > 0){
            forbidenPositions.add(maxSum);
            maxSum -= SIZE_BOARD;
        }
        for (Integer x : positions){
            if (currentPosition != x && forbidenPositions.contains(x)){
                return true;
            }
        }
        return false;
    }
}
