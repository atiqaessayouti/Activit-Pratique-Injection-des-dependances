package net.pres;

import net.framework.context.MyContext;
import net.metier.IMetier;

public class PresFramework {
    public static void main(String[] args) {
        System.out.println("=== Lancement du Mini-Framework Maison ===");

        try {

            MyContext context = new MyContext(new String[]{"net.dao", "net.metier"});


            IMetier metier = context.getBean(IMetier.class);


            if (metier != null) {
                System.out.println("Résultat Framework Maison : " + metier.calcul());
            } else {
                System.out.println("Erreur : Le bean n'a pas été créé.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}