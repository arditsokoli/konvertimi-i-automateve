import java.util.ArrayList;
import java.util.Collections;

public class afd extends afjd {
    ArrayList<String> gjendjet_info_afd1;
    String[][] gjendjet_info_afd2;


    public void mainAFD(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String[] shkronjatPae) {

        ArrayList<ArrayList<String>> afdArray;
        afdArray = return_ArrayList_afd(afjd, gjendje_info, shkronjatPae); //kthen tranzicionet per  AFD ne afdArray
        System.out.println(afdArray);

        String[][] gjendjet_info_afd3 = new String[this.gjendjet_info_afd1.size()][1];
        for (int i = 0; i < this.gjendjet_info_afd1.size(); i++) {
            gjendjet_info_afd3[i][0] = this.gjendjet_info_afd1.get(i);       // kthimi nga ArrayList String to Array 2d
        }
        this.gjendjet_info_afd2 = gjendjet_info_afd3;


        afd.tabelaAFD(afdArray, gjendjet_info_afd2, shkronjatPae);   //AFJD printimi tek vlerat
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
        gjendjet_info_afd.add(gjendje_info[gjendjaFillestare][0]);


        for (int k = 0; k < gjendje_info.length ; k++) {
            ArrayList<String> index = new ArrayList<>();

            for (int c = 0; c < shkronjatPae.length; c++) {
                if (k == 0) {
                    index.add(afjd.get(gjendjaFillestare).get(c));   //gjendja fillestare
                }
                // nese gjendet ne arraylist kthen false ne te kundert kthen true




                if ((k > 0) && (gjendet_ne_arrayList(gjendjet_info_afd, afdArraylist.get(k - 1).get(c)))) {
                    gjendjet_info_afd.add(afdArraylist.get(k - 1).get(c));
                    if (gjendjet_info_afd.get(gjendjet_info_afd.size() - 1).contains(",")) {
                        //??nese gjendja permban me shum se 2 elemente:
                        index.add(tranz_gjendjes(afjd, gjendje_info, gjendjet_info_afd.get(gjendjet_info_afd.size() - 1), c));

                    } else if (gjendjet_info_afd.get(gjendjet_info_afd.size() - 1).equals("∅")) {
                        index.add("∅");
                    } else {
                        //??nese gjendja permban vetem nje shkronje
                        String shkronja = gjendjet_info_afd.get(gjendjet_info_afd.size() - 1);
                        int gjendjax = indexi_gjendjes(gjendje_info, shkronja);
                        index.add(afjd.get(gjendjax).get(c));   //gjendja fillestare

                    }
                }


            }
            if (!index.isEmpty()) {
                afdArraylist.add(index);
            }
        }
        this.gjendjet_info_afd1 = gjendjet_info_afd;
        return afdArraylist;
    }

    // index.add(tranz_gjendjes(afjd, gjendje_info, gjendjet_info_afd.get(elFudit), c));
    private String tranz_gjendjes(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String elFundit, int d) {
        //??nese gjendja permban me shum se 2 elemente:
        ArrayList<String> vleraSplit = new ArrayList<>();
        ArrayList<String> index1 = new ArrayList<>();   // mban shkronjat perfundimtare "te perseritura"
        ArrayList<String> vlera2 = new ArrayList<>();  // mban shkronjat perfundimtare "te pa perseritura"

        String[] split = elFundit.split(",");
        Collections.addAll(vleraSplit, split);


        for (int i = 0; i < vleraSplit.size(); i++) {
            int indexiX = indexi_gjendjes(gjendje_info, vleraSplit.get(i));
            if (afjd.get(indexiX).get(d).contains(",")) {//kur ka me shum se 2 shkronje ne tranzicionin
                Collections.addAll(index1, afjd.get(indexiX).get(d).split(","));
            } else {//kur ka  ∅  ose vetm nje shkronje
                index1.add(afjd.get(indexiX).get(d));
            }
        }

        int a = 0;
        for (int h = 0; h < index1.size(); h++) {
            if (!vlera2.contains(index1.get(h))) {   //ben bashkimin , heq perseritjen
                vlera2.add(index1.get(a));
            }
            a++;
        }
        return String.join(",", vlera2);

    }

    private int indexi_gjendjes(String[][] gjendje_info, String shkronja) {
        //?? kthimin e indeksit ku ndodhet gjendja x ne afdarray
        for (int f = 0; f < gjendje_info.length; f++) {
            if (gjendje_info[0][f].contains(shkronja)) {
                return f;
            }
        }
        return 0;
    }

    protected static boolean gjendet_ne_arrayList(ArrayList<String> gjendjet_info_afd, String afdArraylist) {

        for (int h = 0; h < gjendjet_info_afd.size(); h++) {
            if (gjendjet_info_afd.get(h).equals(afdArraylist)) {
                return false; //nese nuk permbajne ket elementin kthen true
            }
        }
        return true;//nese permbajne ket elementin kthen false
    }


    public static void tabelaAFD(ArrayList<ArrayList<String>> afdArray, String[][] gjendje_info, String[] shkronjatPae) {
        for (int k = 0; k < afdArray.size(); k++) {
            printimiTabeles(shkronjatPae, k, 5, afdArray, gjendje_info);

            //printimi i tabeles se alfabetit e-AFJD
        }
    }

}