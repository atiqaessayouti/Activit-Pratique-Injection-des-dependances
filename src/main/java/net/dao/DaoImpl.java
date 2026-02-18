package net.dao;

public class DaoImpl implements IDao {

    @Override
    public double getData() {
        System.out.println("Version base de données");
        double t= 34; // Ghir mital dyal l-valeur
        return t;
    }
}