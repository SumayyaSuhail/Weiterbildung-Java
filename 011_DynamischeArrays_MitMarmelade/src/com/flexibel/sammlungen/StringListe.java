package com.flexibel.sammlungen;

import java.util.ArrayList;

public class StringListe extends ArrayList {
    @Override
    public boolean add(Object element) {
        if (element instanceof String) {
            return super.add(element);
        } else {
            // Exception
            // Hinweise
            return false;
        }
    }
}
