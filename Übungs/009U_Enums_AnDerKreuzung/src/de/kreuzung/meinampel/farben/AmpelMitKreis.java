package de.kreuzung.meinampel.farben;

import static de.kreuzung.meinampel.farben.Farbe.BLACK_BOLD_BRIGHT;

/**
 * String ampelBild = "\033[1;90m" + " __" + "\n"
 + "\033[1;90m" + "|"+"\033[0;91m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;93m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;92m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + " ‾‾";

 String ampelBildRot= "\033[1;90m" + " __" + "\n"
 + "\033[1;90m" + "|"+"\033[0;91m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;97m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;97m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + " ‾‾";

 String ampelBildRotGelb= "\033[1;90m" + " __" + "\n"
 + "\033[1;90m" + "|"+"\033[0;91m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;93m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;97m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + " ‾‾";

 String ampelBildGruen= "\033[1;90m" + " __" + "\n"
 + "\033[1;90m" + "|"+"\033[0;97m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;97m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;92m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + " ‾‾";


 String ampelBildGelb= "\033[1;90m" + " __" + "\n"
 + "\033[1;90m" + "|"+"\033[0;97m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;93m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + "|"+"\033[0;97m"+ symbol +"\033[1;90m" + "|" + "\n"
 + "\033[1;90m" + " ‾‾";
 */
public class AmpelMitKreis {
    public enum Phase{//Innere Klasse/ inneres Enum
        ROT(2, 1,7,7),
        ROTGELB(1,1,3,7),
        GRUEN(3,7,7,2),
        GELB(1,7,3,7 );

        private final static String symbol = "⬤";

        /**Dauer in Sekunden*/
        private final int dauer;
        private final int zifferOben;
        private final int zifferMitte;
        private final int zifferUnten;

        Phase(int dauer, int zifferOben, int zifferMitte, int zifferUnten) {
            this.dauer = dauer;
            this.zifferOben = zifferOben;
            this.zifferMitte = zifferMitte;
            this.zifferUnten = zifferUnten;
        }

        public int getDauer() {
            return dauer;
        }

        public String toString() {
            // "\t"+
            String ampelBild ="\t"+ BLACK_BOLD_BRIGHT + " __" + "\n"
                    + "\t"+BLACK_BOLD_BRIGHT + "|"+"\033[0;9" + zifferOben + "m"+ symbol +BLACK_BOLD_BRIGHT + "|" + "\n"
                    +"\t"+ BLACK_BOLD_BRIGHT + "|"+"\033[0;9" + zifferMitte + "m"+ symbol +BLACK_BOLD_BRIGHT + "|" + "\n"
                    + "\t"+BLACK_BOLD_BRIGHT + "|"+"\033[0;9" + zifferUnten + "m"+ symbol +BLACK_BOLD_BRIGHT + "|" + "\n"
                    +"\t"+ BLACK_BOLD_BRIGHT + " ‾‾";
            return ampelBild;
        }

    }

    private Phase zustand;

    public AmpelMitKreis() {
        zustand = Phase.ROT;
    }

    public void schalten() {
        try {
            Thread.sleep(1000L * zustand.getDauer());
            //Unterbricht den aktuellen Anlauf fuer eine Anzahl von Millisekunden
        }catch (InterruptedException unterbrechung) {
            System.out.println("Unterbrechung");
        }
        zustand = Phase.values()[(zustand.ordinal()+1) % Phase.values().length ];
    }

    @Override
    public String toString() {
        return zustand.toString() ;
    }


}

