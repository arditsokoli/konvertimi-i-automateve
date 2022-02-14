import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App  {
    public static void main(String[] args) {

        System.out.println("ε-Afjd -> Afjd -> Afd -> Afd(minimizim)");
        Scanner sc = new Scanner(System.in);
        System.out.print("Jepni numrin e gjendjeve te automatit: ");
        int nrGjendjeve = sc.nextInt();

        String[][] gjendje_info = new String[nrGjendjeve][3];

        System.out.println("Shenim: Pergjigjuni me po ose jo, nese eshte fillestare apo fundore ");
        System.out.println();

        for (int i = 0; i < nrGjendjeve; i++) {
            int gjendja = i + 1;
            System.out.print("Emri i gjendjes se " + gjendja + ":");
            gjendje_info[i][0] = sc.next();
            System.out.print("A eshte fillestare: ");   //ruan ne gjendje_info po ose jo per gjendjet fill.. dhe fundore
            gjendje_info[i][1] = sc.next();
            System.out.print("A eshte fundore: ");
            gjendje_info[i][2] = sc.next();
        }
        System.out.println("=============================");
        System.out.print("Jepni numrin e shkonjave: ");
        int nrShkonjave = sc.nextInt();
        int nrShkonjaveArray = nrShkonjave + 1;
        String[] shkronjat = new String[nrShkonjaveArray];

        for (int k = 0; k < nrShkonjave; k++) {
            int nr = k + 1;
            System.out.print("Jepni emrin e shkonjes se " + nr + " :");  //ruan ne array shkonjat
            shkronjat[k] = sc.next();
        }
        shkronjat[nrShkonjave] = "ε-Mbyllje";
        System.out.println(Arrays.toString(shkronjat));

        System.out.println("=============================");
        System.out.println("Pas cdo rreshti vendosni emrin e gjendjes ku kalon automati me ate shkronje.");
        System.out.println("Shtoi me ',' nese ka me me shume  gjendje dhe '-' nese nuk ka.");
        ArrayList<ArrayList<String>> rows = new ArrayList<>();

        int gjatesia = 0;
        for (int i = 0; i < nrGjendjeve; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < nrShkonjaveArray; j++) {
                System.out.print(gjendje_info[i][0] + " me " + shkronjat[j] + "=");  // shtimi i alfabetit ne gjendje_info
                String vlera = sc.next();
                if (vlera.length() > gjatesia) {
                    gjatesia = vlera.length();
                }
                if (vlera.equals("-")) {
                    row.add("∅");
                } else {
                    row.add(vlera);
                }
            }
            rows.add(row);
        }

        //gajtesia max e stringut ne array

        System.out.println();
        Vlerat.printimiGjendjeve(gjendje_info);  // printimi gjendjeve  eshte:  filestar/fundor
        System.out.println();


        System.out.println("Alfabeti :");
        for (int k = 0; k < rows.size(); k++) {
            Vlerat.printimiTabeles(shkronjat, k, gjatesia, rows, gjendje_info);          //printimi i tabeles se alfabetit e-AFJD
        }


        // Konvertimi ne AFJD

        afjd.mainAFJD(rows, gjendje_info, shkronjat, gjendje_info);   //afjd



       // dfa.tabelaAFD(rows, gjendje_info, shkronjat, gjendje_info);



        // fundi i konvertimit

    }
}
