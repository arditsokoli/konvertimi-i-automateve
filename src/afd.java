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
                    index.add(afjd.get(gjendjaFillestare).get(c));   //gjendja fillestare
                }

                if (k > 0) {
                    if (nuk_gjendet_ne_arrayList(gjendjet_info_afd, afdArraylist.get(k - 1).get(c))) {
                        gjendjet_info_afd.add(afdArraylist.get(k - 1).get(c));
                        int elFudit = gjendjet_info_afd.size() - 1;
                        if (gjendjet_info_afd.get(elFudit).contains(",")) {
                            //??nese gjendja permban me shum se 2 elemente:
                        } else if (gjendjet_info_afd.get(elFudit).contains("∅")) {
                            for (int l = 0; l < shkronjatPae.length; l++) {
                                index.add("∅");
                            }
                        } else {
                            //??nese gjendja permban vetem nje shkronje
                            for (int f = 0; f < shkronjatPae.length; f++) {
                                String shkronja = afdArraylist.get(k - 1).get(c);
                                int gjendjax = indexi_gjendjes(afjd, gjendje_info, shkronja);
                                for (int q = 0; q < shkronjatPae.length; q++) {
                                    index.add(afjd.get(gjendjax).get(q));   //gjendja fillestare
                                }
                            }
                        }
                    }
                }


            }
            afdArraylist.add(index);
        }

        return afdArraylist;
    }

    private int indexi_gjendjes(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String shkronja) {
        //?? kthimin e indeksit ku ndodhet gjendja x ne afdarray
        for (int f = 0; f < gjendje_info.length; f++) {
            if (gjendje_info[0][f].contains(shkronja)) {
                return f;
            }
        }
        return 0;
    }

    protected static boolean nuk_gjendet_ne_arrayList(ArrayList<String> gjendjet_info_afd, String afdArraylist) {
        int a = 0;
        for (int h = 0; h < gjendjet_info_afd.size(); h++) {
            if (!gjendjet_info_afd.get(h).contains(afdArraylist)) {
                return true; //nese nuk permbajne ket elementin kthen true
            }
            a++;
        }
        return false;//nese permbajne ket elementin kthen false
    }


    public static void tabelaAFD(ArrayList<ArrayList<String>> afdArray, String[][] gjendje_info, String[] shkronjatPae) {
        for (int k = 0; k < afdArray.size(); k++) {
            printimiTabeles(shkronjatPae, k, 5, afdArray, gjendje_info);

            //printimi i tabeles se alfabetit e-AFJD
        }
    }

}