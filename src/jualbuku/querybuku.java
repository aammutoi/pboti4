/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jualbuku;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author aamvee
 */
public class querybuku {
    public void Add (Object object){
     EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("jualbukuPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
                em.persist(object);
                em.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
        } finally {
                em.close();
        }
    }
    public void update(long id,String nama,String nohp, String judul, String alamat, String penerbit,
            String pengarang, String mtdpengiriman){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("jualbukuPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        em.createQuery("UPDATE tablebuku e SET e.nama=?1,e.nohp=?2,e.judul=?3, e.alamat=?5, e.penerbit=?6, e.pengarang=?7, e.mtdpengiriman=?8 WHERE e.id=?4",querybuku.class)
                .setParameter(1, nama)
                .setParameter(2, nohp)
                .setParameter(3, judul)
                .setParameter(5, alamat)
                .setParameter(6, pengarang)
                .setParameter(7, penerbit)
                .setParameter(8, mtdpengiriman)
                .setParameter(4, id)
                .executeUpdate();
        em.getTransaction().commit();
  }
public void hapus(long id){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("jualbukuPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        int hapusyu=em.createQuery("DELETE FROM tablebuku e WHERE e.id=:par").setParameter("par", id).executeUpdate();
        em.getTransaction().commit();
}
  public void Show() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("jualbukuPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM tablebuku e");
        List<tablebuku> result = query.getResultList();
        for (tablebuku e : result) {
                 System.out.println("ID Pembeli :"+ e.getId() + "\n NAMA :" + e.getNama()+ "\n NO HP :" +e.getNohp()+ "\n judul :" +e.getJudul()+ "\n Alamt :" +e.getAlamat()
                 +"\n Pengarang :"+e.getPengarang()+ "\n Penerbit :"+e.getPenerbit()+ "\n Jenis Pengiriman :"+e.getMtdpengiriman());   
        }
    }
}