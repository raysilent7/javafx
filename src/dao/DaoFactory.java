package dao;

import dao.impl.DepartmentDaoJdbc;
import dao.impl.SellerDaoJdbc;
import db.DB;

public class DaoFactory {

    public static SellerDao createSellerDao () {
        return new SellerDaoJdbc (DB.openConnection());
    }

    public static DepartmentDao createDepartmentDao () {
        return new DepartmentDaoJdbc (DB.openConnection());
    }
}
