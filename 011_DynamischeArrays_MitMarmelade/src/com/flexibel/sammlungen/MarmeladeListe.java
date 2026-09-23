package com.flexibel.sammlungen;

import java.util.ArrayList;

public class MarmeladeListe extends ArrayList {
    @Override
    public boolean add(Object element) {
        if (element instanceof Marmelade) {
            return super.add(element);
        } else {
            return false;
        }
    }
}
