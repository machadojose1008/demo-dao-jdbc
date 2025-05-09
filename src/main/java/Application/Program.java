package Application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ====");

        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("=== TEST 2: sellers findByDepartment ====");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: sellers findAll ====");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

       // System.out.println("\n=== TEST 4: seller insert ===");
        //Seller newSeller = new Seller(null, "Greg","greg@mail.com",LocalDate.now(),4000.0,department);
        //sellerDao.insert(newSeller);
       //System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wane");
        sellerDao.update(seller);
        System.out.println("Update Completed!");


        System.out.println("\n=== TEST 6: seller update === ");
        System.out.println("Enter id for delete test:");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete Completed!");
        sc.close();


    }
}
