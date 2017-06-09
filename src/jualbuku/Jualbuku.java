/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jualbuku;

import java.util.Scanner;

/**
 *
 * @author aamvee
 */
public class Jualbuku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         tablebuku entityObjk =new tablebuku();
        querybuku tambah = new querybuku();
        Scanner input=new Scanner(System.in);
        String nama,nohp,judul,pengarang,penerbit,alamat,mtdpengiriman,jwb;
        long id;
        System.out.println("SELAMAT DATANG DI BUKU ONLINE");
        System.out.println("Masukkan Biodata Anda");
        System.out.print("Nama Lengkap :");nama = input.nextLine();
        System.out.print ("Alamat :");alamat=input.nextLine();
        System.out.print("Nomor hp :");nohp=input.nextLine();
        System.out.print ("Judul :");judul=input.nextLine();
        System.out.print ("Pengarang :");pengarang=input.nextLine();
        System.out.print ("Penerbit :");penerbit=input.nextLine();
        System.out.print ("Jenis Pengiriman :");mtdpengiriman=input.nextLine();
        
        entityObjk.setNama(nama);
        entityObjk.setNohp(nohp);
        entityObjk.setAlamat(alamat);
        entityObjk.setJudul(judul);
        entityObjk.setPengarang(pengarang);
        entityObjk.setPenerbit(penerbit);
        entityObjk.setMtdpengiriman(mtdpengiriman);
        tambah.Add(entityObjk);
        
        System.out.println("Apakah data anda ingin dilihat ? jawab ya/tidak");jwb=input.nextLine();
        if(jwb.equals("ya")){
        tambah.Show();
        }
        //System.out.println("Apakah data anda ingin di rubah ? jawab ya/tidak");jwb=input.nextLine();
        //if(jwb.equals("ya")){
        
        System.out.println("Apakah data anda ingin di rubah / di hapus?"
                + "\n jawab ok : untuk merubah, "
                + " jawab tidak : untuk hapus");
        jwb=input.nextLine();
        if (jwb.equals("ok")){
        
            System.out.print("Nama :");nama = input.nextLine();
            System.out.print("No HP :");nohp = input.nextLine();
            System.out.print("Judul:");judul=input.nextLine();
            System.out.print("Alamat:");alamat=input.nextLine();
            System.out.print("Pengarang:");pengarang=input.nextLine();
            System.out.print("Penerbit:");penerbit=input.nextLine();
            System.out.print("Jenis Pengiriman:");mtdpengiriman=input.nextLine();
            System.out.print("ID :");id=input.nextLong();
            
            tambah.update(id, nama, nohp, alamat, judul, penerbit, pengarang, mtdpengiriman);
            tambah.Show();
        
        }else if (jwb.endsWith("tidak")){
            
    
       // System.out.println("Apakah data anda ingin di hapus ? jawab ya/tidak");jwb=input.nextLine();
       // input.nextLine();
       // if(jwb.equals("ya")){
            System.out.print("Masukan ID :");id=input.nextLong();
            tambah.hapus(id);
            tambah.Show();
        }
        
    }
    
    }


    
    

