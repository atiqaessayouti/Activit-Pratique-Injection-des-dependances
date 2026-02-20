package net.dao;

import net.framework.annotations.MyComponent; // Import dyal l-annotation dyalk

@MyComponent
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version base de données (Framework Maison)");
        return Math.random() * 40;
    }
}