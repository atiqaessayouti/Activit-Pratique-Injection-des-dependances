package net.metier;

import net.dao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao; // couplage faible
    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }
    @Override
    public double calcul() {
        double t = dao.getData();
        double res =t*12*Math.PI;
        return res;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }


}
