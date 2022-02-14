import java.util.ArrayList;

public class afd extends afjd {


    public void printimiAFD(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String[] shkronjatPae) {

        System.out.println(super.afjd);
        System.out.println(super.gjendjetAFJD);
        afd.tabelaAFD(afjd, gjendje_info, shkronjatPae);   //afjd
    }

    public static void tabelaAFD(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String[] shkronjatPae) {
        for (int k = 0; k < afjd.size(); k++) {
            printimiTabeles(shkronjatPae, k, afjd.size(), afjd, gjendje_info);
            //printimi i tabeles se alfabetit e-AFJD
        }
    }

}