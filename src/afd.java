import java.util.ArrayList;
import java.util.Collections;

public class afd extends afjd {
    ArrayList<String> gjendjet_info_afd1;
    String[][] gjendjet_info_afd2;


    public void mainAFD(ArrayList<ArrayList<String>> afjd, String[][] gjendje_info, String[] shkronjatPae) {

        ArrayList<ArrayList<String>> afdArray;
        afdArray = return_ArrayList_afd(afjd, gjendje_info, shkronjatPae); //kthen tranzicionet per  AFD ne afdArray


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

        int kombinimet_e_mundshme= (int) (Math.pow(2, gjendje_info.length) + gjendje_info.length);
        int a = 0;

        for (int k = 0; k < kombinimet_e_mundshme; k++) {
            ArrayList<String> index = new ArrayList<>();
            int sa_gjendje_shtohen = 0;
            String gjendjaEfundit;
            if (k == 0) {
                for (int c = 0; c < shkronjatPae.length; c++) {
                    index.add(afjd.get(gjendjaFillestare).get(c));   //gjendja fillestare
                }
            }

            if (k > 0) {  //gjendjet me index me te madh se 0  1...
                for (int g = 0; g < shkronjatPae.length; g++) {

                    String stringu = afdArraylist.get(a).get(g);



                    if (gjendet_ne_arrayList(gjendjet_info_afd, stringu)) {
                        if (g == 1) {
                            a++;
                        }

                        gjendjet_info_afd.add(stringu);
                        sa_gjendje_shtohen++;

                    }
                }
            }


            for (int j = sa_gjendje_shtohen; j > 0; j--) {
                gjendjaEfundit = gjendjet_info_afd.get(gjendjet_info_afd.size() - j);

                ArrayList<String> index1 = new ArrayList<>();

                if (gjendjaEfundit.contains(",")) {
                    for (int h = 0; h < shkronjatPae.length; h++) {
                        //??nese gjendja permban me shum se 2 elemente:
                        index1.add(tranz_gjendjes(afjd, gjendje_info, gjendjaEfundit, h));
                    }
                } else if (gjendjaEfundit.equals("∅")) {
                    for (int h = 0; h < shkronjatPae.length; h++) {
                        //??nese gjendja permban vetem nje ∅
                        index1.add(gjendjaEfundit);
                    }
                } else {
                    for (int h = 0; h < shkronjatPae.length; h++) {
                        //??nese gjendja permban vetem nje shkronje
                        index1.add(afjd.get(indexi_gjendjes(gjendje_info, gjendjaEfundit)).get(h));   //gjendja fillestare
                    }
                }
                afdArraylist.add(index1);
            }

            if (!index.isEmpty()) {
                afdArraylist.add(index);
            }
        }

        // nese nuk gjendet gjendja e errorit , shtimi i saj
        boolean b = gjendet_ne_arrayList2D(afdArraylist, "∅"); // kthen true nese ndogjet ne adfarray
        boolean c = gjendet_ne_arrayList(gjendjet_info_afd, "∅"); //kthen true nese ndodhet ne gjendjet_info_afd
        if (b && c) {
            gjendjet_info_afd.add("∅");
            ArrayList<String> d= new ArrayList<>();
            for (int h = 0; h < shkronjatPae.length; h++) {
                d.add("∅");
            }
            afdArraylist.add(d);
        }

        this.gjendjet_info_afd1 = gjendjet_info_afd;
        return afdArraylist;
    }

    // index.add(tranz_gjendjes(afjd, gjendje_info, gjendjaEfundit, h));
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
            }

            else {//kur ka  ∅  ose vetm nje shkronje
                index1.add(afjd.get(indexiX).get(d));
            }
        }

        int a = 0;
        for (int h = 0; h < index1.size(); h++) {
            if (!vlera2.contains(index1.get(h))){   //ben bashkimin , heq perseritjen
                vlera2.add(index1.get(a));
            }
            a++;
        }



        return String.join(",", vlera2);

    }

    private int indexi_gjendjes(String[][] gjendje_info, String shkronja) {
        //?? kthimin e indeksit ku ndodhet gjendja x ne afdarray
        for (int f = 0; f < gjendje_info.length; f++) {
            if (gjendje_info[f][0].contains(shkronja)) {
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

    protected static boolean gjendet_ne_arrayList2D(ArrayList<ArrayList<String>> gjendjet_info_afd2d, String error) {
        for (int g = 0; g < gjendjet_info_afd2d.size(); g++) {
            for (int h = 0; h < gjendjet_info_afd2d.get(g).size(); h++) {
                if (gjendjet_info_afd2d.get(g).get(h).equals(error)) {
                    return true; //nese nuk permbajne ket elementin kthen true
                }
            }

        }
        return false;//nese permbajne ket elementin kthen false
    }


    public static void tabelaAFD(ArrayList<ArrayList<String>> afdArray, String[][] gjendje_info, String[] shkronjatPae) {
        for (int k = 0; k < afdArray.size(); k++) {
            printimiTabeles(shkronjatPae, k, 8, afdArray, gjendje_info);

            //printimi i tabeles se alfabetit e-AFJD
        }
    }

}
