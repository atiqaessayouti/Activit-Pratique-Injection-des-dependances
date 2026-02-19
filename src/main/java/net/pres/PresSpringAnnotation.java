package net.pres;

import net.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationcontext= new
                AnnotationConfigApplicationContext("net.ext","net.metier");
        IMetier metier=applicationcontext.getBean(IMetier.class);
        System.out.println("res="+metier.calcul());
    }
}
