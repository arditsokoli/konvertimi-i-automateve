import java.util.ArrayList;

public class afd extends afjd {


    public void mainAFD(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String[] shkronjatPae) {

        //System.out.println(super.afjd);
        //System.out.println(super.gjendjetAFJD);
        ArrayList<ArrayList<String>> afdArray;
        afdArray = return_ArrayList_afd(afjd, gjendje_info, shkronjatPae); //kthen tranzicionet per  AFD ne afdArray
        afd.tabelaAFD(afdArray, gjendje_info, shkronjatPae);   //AFJD printimi tk vlerat
    }


    protected ArrayList<ArrayList<String>> return_ArrayList_afd(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String[] shkronjatPae) {
        ArrayList<ArrayList<String>> afdArraylist = new ArrayList<>();
        ArrayList<String> gjendjet_info_afd = new ArrayList<>();

        int gjendjaFillestare = 0;
        for (int i = 0; i < gjendjetAFJD.size(); i++) {
            if (gjendjetAFJD.get(i).contains("-")) {
                gjendjaFillestare = i;     // gjetja e indeksit te gjendjes fillestare
            }
        }
        gjendjet_info_afd.add(gjendjetAFJD.get(gjendjaFillestare));

        int gjatesia = 0;
        for (int k = 0; k < gjendje_info.length; k++) {
            ArrayList<String> index = new ArrayList<>();
            for (int c = 0; c < shkronjatPae.length; c++) {
                if (k == 0) {
                    index.add(afjd.get(gjendjaFillestare).get(c));
                }


            }
            afdArraylist.add(index);
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