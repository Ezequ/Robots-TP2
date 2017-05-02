/**
 * Created by ezequiel on 01/05/17.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Randomizer {

    public static final int TOTAL_POSITIONS = 144;

    public static Cromosom[] getInitialCromosoms(int countQueens, int countCromosoms)
    {
        Random randomGenerator = new Random();
        Cromosom[] queenPositions = new Cromosom[countCromosoms];
        for (int i = 0; i < countCromosoms ; i++){
            System.out.print("Para "+i+ " ");
            ArrayList<Integer> positions = new ArrayList<Integer>();
            for (int j = 0; j < countQueens ; j++){
                int position = randomGenerator.nextInt(TOTAL_POSITIONS - 1 );
                while(positions.contains(position)){
                    position = randomGenerator.nextInt(TOTAL_POSITIONS - 1 );
                }
                positions.add(position);
                System.out.print(position+ ";");
            }
            queenPositions[i] = new Cromosom(TOTAL_POSITIONS, positions);
            positions.clear();
        }
        return queenPositions;
    }
}
