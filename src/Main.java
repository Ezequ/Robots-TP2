public class Main {

    public static void main(String[] args) {
        if (((String[]) args).length != 1 ){
            System.out.print("Pasar como parámetro la cantidad de reinas a meter.");
        }
        int queensCount = Integer.parseInt(args[0]);
         queensCount = 7;
        getSolutions(queensCount);
    }

    private static void getSolutions(int queensCount) {
        Cromosom[] initialQueensList = Randomizer.getInitialCromosoms(queensCount,50);
        GeneralAptitudeCalculator gAC = new GeneralAptitudeCalculator();
        for (Cromosom c : initialQueensList){
            float aptitude = gAC.calculateAptitude(c);
            c.setAptitude(aptitude);
            System.out.print(aptitude+"-");
        }
    }
}
