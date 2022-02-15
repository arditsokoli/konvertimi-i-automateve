import java.util.ArrayList;

public class Vlerat {
    public static void printimiTabeles(String[] shkronjat, int row, int gjatesi, ArrayList<ArrayList<String>> rows, String[][] gjendje_info) {
        int gjts = gjatesi + 4;
        int gjatesiaVijave = (shkronjat.length * gjts) + 4;
        int gjatesia = 0;


        for (String[] strings : gjendje_info) {
            if (strings[0].length() > gjatesia) {       //gjetja e stringut max ne gjendjet
                gjatesia = strings[0].length();
            }
        }
        for (int i = 0; i < gjatesia + 3; i++) {
            System.out.print(" ");
        }

        if (row == 0) {
            for (String s : shkronjat) {
                System.out.printf(" %-" + gjts + "s ", s + ":");  //afishimi i shkonjave (rrjesht) rrjsh pare
            }
            System.out.println();

            for (int i = 0; i < gjatesia + 3; i++) {
                System.out.print(" ");
            }
        }

        int gjtStr = gjts - 2;
        for (int i = 0; i < gjatesiaVijave; i++) {
            System.out.print("-");                   //afishimi i vijave ndarese te fillimit
        }
        System.out.println("-");

        int gjt1 = gjatesia + 1;
        //afishimi i gjendjeve (kollone)
        System.out.printf(" %" + gjt1 + "s ", gjendje_info[row][0] + ":");

        for (int i = 1; i <= rows.get(row).size(); i++) {
            System.out.printf("| %-" + gjtStr + "s ", "{" + rows.get(row).get(i - 1) + "}");
        }
        System.out.println("|");

        if (row == rows.size() - 1) {     //afishimi i vijave ndarese te fundit
            for (int i = 0; i < gjatesia + 3; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < gjatesiaVijave; i++) {
                System.out.print("-");
            }
            System.out.println("-");
        }

    }

    public static void printimiGjendjeve(String[][] gjendjet) {
        System.out.print("Gjendjet:     ");
        for (int i = 0; i < gjendjet.length; i++) {

            if (gjendjet[i][1].equals("po") && gjendjet[i][2].equals("po")) {
                System.out.print("-->((" + gjendjet[i][0] + "))");
            }
            if (gjendjet[i][1].equals("po") && gjendjet[i][2].equals("jo")) {
                System.out.print("-->(" + gjendjet[i][0] + ")");
            }
            if (gjendjet[i][1].equals("jo") && gjendjet[i][2].equals("po")) {
                System.out.print("((" + gjendjet[i][0] + "))");
            }
            if (gjendjet[i][1].equals("jo") && gjendjet[i][2].equals("jo")) {
                System.out.print("(" + gjendjet[i][0] + ")");
            }
            System.out.print("   ");
        }
        System.out.println();
    }
}



