import java.util.ArrayList;


public class prova {

    protected static boolean nuk_gjendet_ne_arrayList(ArrayList<String> afd, String afd1) {

        for (int h = 0; h < afd.size(); h++) {
            if (afd.get(h).equals(afd1)) {

                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> afd = new ArrayList<>();
        ArrayList<String> afd1 = new ArrayList<>();
        afd.add("q1,q2");
        afd.add("q2");
        afd.add("q1,q2,q3");

        boolean t;
        afd1.add("q1");
        afd1.add("q2");
        afd1.add("q3");
        afd1.add("q1,q2");
        for (int h = 0; h < afd1.size(); h++) {
            t = !nuk_gjendet_ne_arrayList(afd, afd1.get(h));
            System.out.println(t);
        }

    }
}
