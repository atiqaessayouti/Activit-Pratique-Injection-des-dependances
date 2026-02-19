package net.ext;

import net.dao.IDao;
import org.springframework.stereotype.Component;

//@Component("d2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Capteurs (Extension V2)");
        return 60.0;
    }
}