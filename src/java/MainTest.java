
import controller.GeneralController;
import controller.InterfaceController;
import static java.lang.System.out;
import java.util.Date;
import models.BerkasCuti;
import models.Departemen;
import models.Karyawan;
import models.Permohonan;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class MainTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Class type = Karyawan.class;
        Class typee = Departemen.class;
        System.out.println(sessionFactory);

        GeneralController<Karyawan> generalController = new GeneralController(sessionFactory, type);
//        
        Karyawan k = generalController.getById("10000");
//        System.out.println(k.getAwalGabung());
//        
//        System.out.println("update");
        GeneralController<Departemen> generalDept = new GeneralController(sessionFactory, typee);
        Departemen d = generalDept.getById(new Integer("200"));
//        k = new Karyawan("10002", "Eko Siswadya", "085725123234", "eks12@gmail.com",
                   // new Date("09/01/2018"), "10000", "qwerty456", 10, 10, new byte [100],d);
        //k.setIdDepartemen(new Departemen(100));
        System.out.println(generalController.saveOrUpdate(k));
//        
//        System.out.println("\nGet all data");
//        for (Karyawan karyawan : generalController.getAll()) {
//            System.out.println(karyawan.getNamaKaryawan());
//        }

//        InterfaceController<BerkasCuti> ic = new GeneralController<BerkasCuti>(sessionFactory, BerkasCuti.class);
//        BerkasCuti bc = (BerkasCuti) ic.getById(new Integer("20123"));
//        GeneralController<Permohonan> generalDepta = new GeneralController(sessionFactory, Permohonan.class);
//        Permohonan p = generalDepta.getById(new Integer("10123"));
//        String message = "Gagal Update";
//        String Lokasi = "cpoba aja";
//        System.out.println(bc.getIdPermohonan().getCatatan() + "," + p.getStatus());
////            out.print(getIdnya+" 1 "+idPer+" - "+Lokasi);
//        if (bc != null) {
//            System.out.println("should save");
////            bc = new BerkasCuti(new Integer("20235"), Lokasi, p);
//            BerkasCuti bc1 = new BerkasCuti();
//            bc1.setidBerkasCuti(Integer.parseInt("20125"));
//            bc1.setLokasiBerkas("cobakah");
//            bc1.setIdPermohonan(p);
//            System.out.print(bc1);
//            if (ic.saveOrUpdate(bc1)) {
//                message = "sukses update";
//            }
//            System.out.print(message);
//        } else {
//            System.out.println("must be update");
//        }
    }

}
