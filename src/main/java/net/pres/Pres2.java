package net.pres;

import net.dao.IDao;
import net.metier.IMetier;
import java.io.File;
import java.util.Scanner;
import java.lang.reflect.Method; // Import l-mouhim hna

public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config"));

        // 1. Instanciation dynamique du DAO
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao d = (IDao) cDao.getConstructor().newInstance();

        // 2. Instanciation dynamique du Métier
        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();


        //Method setDao = cMetier.getMethod("setDao", IDao.class);

        //setDao.invoke(metier, d);


        System.out.println("res=" + metier.calcul());
    }
}