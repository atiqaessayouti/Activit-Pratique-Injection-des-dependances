package net.pres;

import net.ext.DaoImplV2;
import net.metier.MetierImpl;

public class Pres1 {
    public static void main(String [] args){

        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
       // metier.setDao(d); // Injection des dépendances


        System.out.println("res=" + metier.calcul());
    }
}