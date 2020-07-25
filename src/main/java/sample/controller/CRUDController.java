package sample.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sample.entity.Category;
import sample.utils.HibernateUtil;

public class CRUDController {

    public static void main(String args[]){

        new CRUDController().insertCategoryData();

    }

    public void insertCategoryData(){
        Category catObj = new Category();
        catObj.setCategoryName("Hot Beverages");
        catObj.setCategoryDescription("Coffee, Tea..");
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try{
            Session sessionObj = factory.openSession();
            Transaction tx = sessionObj.beginTransaction();

            try{
                sessionObj.persist(catObj);
                tx.commit();
                System.out.println("Saving Object successful with id -> " + catObj.getCategoryId());
            }catch(Exception exInsert){
                tx.rollback();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            factory.close();
        }
    }
}
