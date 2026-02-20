package net.metier;

import net.dao.IDao;
import net.framework.annotations.MyAutowired;
import net.framework.annotations.MyComponent;

@MyComponent
public class MetierImpl implements IMetier {

    @MyAutowired
    private IDao dao;

    public MetierImpl() {
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        return t * 12 * Math.PI;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}