package de.diebohne.dascafe;

/**
 * <pre>
 *     Demonstriert die Verwendung und dan Aufbau mehrdimensionaler Arrays.
 * </pre>
 */
public class Dimensionen {

    /**
     * Organisiert den Ablauf
     * @param args wird hier ignoriert
     */
    public static void main(String[] args) {
        int[] ursprung = new int[2];
        ursprung[0] = 0;
        ursprung[1] = 0;

        int[] punktA = {2,4};
        int[] punktB = {3,-9};

        int[][] punkte = new int[4][];
        punkte[0] = ursprung;
        punkte[1] = punktA;
        punkte[2] = punktB;
        punkte[3] = new int[3]; //Punkt im Raum mit x,y und z Koordinate
        punkte[3][0] = 6; // x Koordinate
        punkte[3][1] = 2; // y Koordinate
        punkte[3][2] = 5; // z Koordinate
//        punkte[3] = new int[]{6,2,5};

        for (int i = 0; i < punkte.length; i++) {
            for (int j = 0; j < punkte[i].length; j++) {
                System.out.print(punkte[i][j] + " ");
            }
            System.out.println();
        }

        String[][] namen = new String[3][2];
        //Abkürzung für:
        //String[][] namen = new String[3][];
        //namen[0] = new String[2];
        //namen[1] = new String[2];
        //namen[2] = new String[2];

        namen[0][0] = "Justus";
        namen[0][1]= "Jonas";

        namen[1][0] = "Peter";
        namen[1][1] = "Shaw";

        namen[2][0] = "Bob";
        namen[2][1] = "Andrews";

        double[][][][] doof = new double[2][][][];
    }
}
