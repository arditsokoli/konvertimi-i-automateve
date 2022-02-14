import java.util.ArrayList;

public class afd extends afjd {


    public void mainAFD(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String[] shkronjatPae) {

        //System.out.println(super.afjd);
        //System.out.println(super.gjendjetAFJD);
        ArrayList<ArrayList<String>> afdArray = new ArrayList<>();
        afdArray = return_ArrayList_afd(afjd,gjendje_info,shkronjatPae); //kthen tranzicionet per  AFD ne afdArray
        afd.tabelaAFD(afjd, gjendje_info, shkronjatPae);   //AFJD
    }


    protected ArrayList<ArrayList<String>> return_ArrayList_afd(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String[] shkronjatPae) {
        ArrayList<ArrayList<String>> afdArraylist = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < gjendje_info.length; i++) {

        }
        return afdArraylist;
    }


    public static void tabelaAFD(ArrayList<ArrayList<String>> afdArray, String[][] gjendje_info, String[] shkronjatPae) {
        for (int k = 0; k < afdArray.size(); k++) {
            printimiTabeles(shkronjatPae, k, 5, afdArray, gjendje_info);
            //printimi i tabeles se alfabetit e-AFJD
        }
    }

}