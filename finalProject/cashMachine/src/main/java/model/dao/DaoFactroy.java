package model.dao;

import model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactroy {
    private static DaoFactroy daoFactroy;

    public abstract CheckDao createCheckDao();

    public abstract ProductDao createProductDao();

    public abstract UserDao createUserDao();

    public static DaoFactroy getInstance(){
        if(daoFactroy == null){
            synchronized (DaoFactroy.class){
                if(daoFactroy == null)
                    daoFactroy = new JDBCDaoFactory();
            }
        }
        return daoFactroy;
    }
}
