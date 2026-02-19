package net.pres;

import net.dao.IDao;
import net.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config"));
        String daoClassName =scanner.nextLine();;;
        Class cDao = Class.forName(daoClassName);
        IDao d= (IDao) cDao.newInstance();

        String metierClassName =scanner.nextLine();;;
        Class cMetier = Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        System.out.println("res"+metier.calcul());

    }
}
