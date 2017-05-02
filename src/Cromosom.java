import java.util.ArrayList;

/**
 * Created by ezequiel on 01/05/17.
 */
public class Cromosom {

    private int[] values;
    private float aptitude;
    ArrayList<Integer> positions;
    int size;

    public ArrayList<Integer> getPositions() {
        return positions;
    }

    public Cromosom(int size, ArrayList<Integer> positions) {
        this.positions = (ArrayList<Integer>) positions.clone();
        this.size = size;
//        values = new int[size];
//        for (Integer position: positions){
//            values[position] = 1;
//        }
    }
}
