package net.ext;

import net.dao.IDao;

public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Capteurs (Extension V2)");
        return 60.0;
    }
}