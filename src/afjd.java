import java.util.*;


public class afjd extends Vlerat {

    ArrayList<ArrayList<String>> afjd;
    ArrayList<String> gjendjetAFJD;


    protected static void mainAFJD(ArrayList<ArrayList<String>> tranzicionet, String[][] gjendjet, String[] shkronjat, String[][] gjendje_info) {
        int nrgjendjeve = gjendjet.length;
        int nrshkronjave = shkronjat.length;
        int numriMagjik = nrshkronjave - 1;


        System.out.print("Shkruani 'po' ose 'jo' per ta kovertuar ne AFJD:");
        Scanner sc = new Scanner(System.in);
        String konverto = sc.next();
        if (konverto.equals("po")) {
            System.out.println();


            afjd t = new afjd();
            ArrayList<ArrayList<Integer>> eClosure = t.toTable(tranzicionet, nrgjendjeve, nrshkronjave, numriMagjik, gjendje_info);
            ArrayList<ArrayList<String>> AFJD = new ArrayList<>();

            int gjatesia = 0;
            for (int i = 0; i < gjendjet.length; i++) {   // 0-3
                ArrayList<String> row = new ArrayList<>();
                for (int j = 0; j < numriMagjik; j++) {  //0-2   // futja ne tabelen perfundimtare
                    afjd k = new afjd();
                    String vlera = k.toStringu(tranzicionet, nrgjendjeve, nrshkronjave, numriMagjik, gjendje_info, i, j);

                    if (vlera.length() > gjatesia) {
                        gjatesia = vlera.length();
                    }
                    if (vlera.equals("")) {
                        row.add("∅");
                    } else {
                        row.add(vlera);
                    }
                }
                AFJD.add(row);
            }

            String[] shkronjatPae = new String[numriMagjik];
            for (int f = 0; f < numriMagjik; f++) {         // fshirja e epsilonit nga shkronjat
                shkronjatPae[f] = shkronjat[f];
            }

            System.out.println("Konvertimi ne AFJD :\n");
            ArrayList<String> gjendjetArray = printimiGjendjeveAFJD(tranzicionet, gjendje_info, numriMagjik);  // printimi gjendjeve  eshte:

            System.out.println();
            for (int k = 0; k < eClosure.size(); k++) {
                printimiTabeles(shkronjatPae, k, gjatesia, AFJD, gjendje_info);
                //printimi i tabeles se alfabetit e-AFJD
            }

            afd a = new afd();
            a.afjd = AFJD;
            a.gjendjetAFJD = gjendjetArray;

            System.out.println("Konvertimi perfundoi me sukses.");
            System.out.println();

            System.out.print("Shkruani 'po' ose 'jo' per ta kovertuar ne AFD:");
            Scanner sc1 = new Scanner(System.in);
            String konvertoAfd = sc1.next();
            if (konvertoAfd.equals("po")) {    // konvertimi ne afd
                System.out.println();
                a.mainAFD(AFJD, gjendje_info, shkronjatPae);
            }

        } else {
            System.out.println("\nKonvertimi nuk perfundoi.");
        }
    }


    // kthimi nga array me String ne Array Inteager "me indexin e gjendjeve"       e mbyllje
    protected ArrayList<ArrayList<Integer>> toTable(ArrayList<ArrayList<String>> tranzicionet, int nrgjendjeve, int nrshkronjave, int numri, String[][] gjendje_info) {
        ArrayList<ArrayList<Integer>> Closure = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < nrgjendjeve; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            index.clear();
            if (tranzicionet.get(i).get(numri).contains(",")) {
                String[] split = tranzicionet.get(i).get(nrshkronjave - 1).split(",");
                for (int d = 0; d < split.length; d++) {
                    for (int l = 0; l < nrgjendjeve; l++) {
                        if (split[d].equals(gjendje_info[l][0])) {
                            index.add(l);
                        }
                    }
                }
                row.addAll(index);
            } else if (!tranzicionet.get(i).get(numri).contains("∅")) {
                for (int d = 0; d < 1; d++) {
                    for (int l = 0; l < nrgjendjeve; l++) {
                        if (tranzicionet.get(i).get(numri).equals(gjendje_info[l][0])) {
                            row.add(l);
                        }
                    }
                }
            }
            Closure.add(row);
        }
        return Closure;
    }

    protected String toStringu(ArrayList<ArrayList<String>> tranzicionet, int nrgjendjeve, int nrshkronjave, int numriMagjik, String[][] gjendje_info, int nrgj, int nrshkr) {
        ArrayList<String> vlerax = new ArrayList<>();
        ArrayList<String> vlera2 = new ArrayList<>();
        ArrayList<String> index1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> eClosure = toTable(tranzicionet, nrgjendjeve, nrshkronjave, numriMagjik, gjendje_info);


        for (int d = 0; d < eClosure.get(nrgj).size(); d++) {  // ecloset 0 1 2   0 1   0
            if (!tranzicionet.get(eClosure.get(nrgj).get(d)).get(nrshkr).equals("∅"))
                vlerax.add(tranzicionet.get(eClosure.get(nrgj).get(d)).get(nrshkr));
        }

        for (int n = 0; n < vlerax.size(); n++) {
            for (int t = 0; t < nrgjendjeve; t++) {
                if (vlerax.get(n).equals(gjendje_info[t][0])) {
                    String[] split = tranzicionet.get(t).get(nrshkronjave - 1).split(",");
                    Collections.addAll(vlera2, split);
                }
            }
        }
        int a = 0;
        for (int h = 0; h < vlera2.size(); h++) {
            if (!index1.contains(vlera2.get(h))) {   //ben bashkimin , heq perseritjen
                index1.add(vlera2.get(a));
            }
            a++;
        }

        return String.join(",", index1);
    }

    protected static ArrayList<String> printimiGjendjeveAFJD(ArrayList<ArrayList<String>> tranzicionet, String[][] gjendjet, int nrMagjik) {

        System.out.print("Gjendjet:     ");
        int nrF = -1;

        for (int q = 0; q < gjendjet.length; q++) {
            if (gjendjet[q][2].contains("po")) {
                nrF = q; //gjetja e nr te gjendjes fundore
            }
        }
        String fundem = gjendjet[nrF][0];


        ArrayList<String> gjendjetArray = new ArrayList<>();
        String name;
        for (int i = 0; i < gjendjet.length; i++) {

            //eshte fillestare dhe permban gjendjen fundore
            if (gjendjet[i][1].equals("po") && tranzicionet.get(i).get(nrMagjik).contains(fundem)) {
                System.out.print("-->((" + gjendjet[i][0] + "))");
                name = "-*" + gjendjet[i][0];
                gjendjetArray.add(name);
            }
            //eshte fillestare dhe nuk permban gjendjen fundore
            else if (gjendjet[i][1].equals("po") && !tranzicionet.get(i).get(nrMagjik).contains(fundem)) {
                System.out.print("-->(" + gjendjet[i][0] + ")");
                name = "-" + gjendjet[i][0];
                gjendjetArray.add(name);
            }
            //eshte fundore dhe  permban gjendjen fundore
            else if (gjendjet[i][1].equals("jo") && tranzicionet.get(i).get(nrMagjik).contains(fundem)) {
                System.out.print("((" + gjendjet[i][0] + "))");
                name = "*" + gjendjet[i][0];
                gjendjetArray.add(name);
            } else {
                System.out.print("(" + gjendjet[i][0] + ")");
                name = gjendjet[i][0];
                gjendjetArray.add(name);
            }
            System.out.print("   ");
        }
        System.out.println();
        return gjendjetArray;
    }

}
