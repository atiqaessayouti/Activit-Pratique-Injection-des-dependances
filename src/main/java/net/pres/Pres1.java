package net.pres;

import net.dao.DaoImpl;
import net.metier.MetierImpl;

public class Pres1 {
    public static void main(String [] args){
        DaoImpl d= new DaoImpl();
        MetierImpl metier =new MetierImpl(d);
        //metier.setDao(d);// injection des dependeces via le setter
        System.out.println("res="+ metier.calcul());
    }
}

