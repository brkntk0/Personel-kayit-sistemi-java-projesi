package Main;

import Departman.Departman;
import Departman.DepartmanIslem;
import Egitimler.Egitim;
import Egitimler.EgitimIslem;
import EngelDurumu.EngelDurumu;
import EngelDurumu.EngelDurumuIslem;
import GirisTarihi.*;
import HomeOfisPersonel.HomeOfisPersonelIslem;
import KadroluPersonel.*;
import MezunDurum.*;
import Personel.*;
import Pozisyon.*;
import SaglikSigortasi.SaglikSigortasi;
import SaglikSigortasi.SaglikSigortasiIslem;
import SenelikIzinHakki.*;
import HomeOfisPersonel.*;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        PersonelIslem personelIslem = new PersonelIslem();
        PozisyonIslem pozisyonIslem = new PozisyonIslem();
        GirisTarihiIslem girisTarihiIslem = new GirisTarihiIslem();
        DepartmanIslem departmanIslem = new DepartmanIslem();
        EgitimIslem egitimIslem = new EgitimIslem();
        SenelikIzinHakkiIslem senelikIzinHakkiIslem = new SenelikIzinHakkiIslem();
        SaglikSigortasiIslem saglikSigortasiIslem = new SaglikSigortasiIslem();
        MezunDurumIslem mezunDurumIslem = new MezunDurumIslem();
        EngelDurumuIslem engelDurumuIslem = new EngelDurumuIslem();
        KadroluPersonelIslem kadroluPersonelIslem = new KadroluPersonelIslem();
        HomeOfisPersonelIslem homeOfisPersonelIslem = new HomeOfisPersonelIslem();


        List<Personel> personeller = personelIslem.PersonelleriListele();
        List<Pozisyon> pozisyonlar = pozisyonIslem.PozisyonleriListele();
        List<GirisTarihi> girisTarihleri = girisTarihiIslem.GirisSaatiListele();
        List<Departman> departmanlar = departmanIslem.DepartmanleriListele();
        List<Egitim> egitimler = egitimIslem.EgitimleriListele();
        List<SenelikIzinHakki> izinHaklari = senelikIzinHakkiIslem.SenelikIzinHakkiListele();
        List<SaglikSigortasi> sagliksigortalari = saglikSigortasiIslem.SaglikSigortasiListele();
        List<MezunDurum> mezunDurumlar─▒ = mezunDurumIslem.MezunDurumlariListele();
        List<EngelDurumu> engeldurumlari = engelDurumuIslem.EngelDurumuListele();
        List<KadroluPersonel> kadroluPersoneller = kadroluPersonelIslem.KadroluPersonelListele();
        List<HomeOfisPersonel> homeOfisPersoneller = homeOfisPersonelIslem.HomeOfisPersonelListele();


        String secim, ad, soyad, cinsiyet, departmanAd, egitimAd;
        int silinecekpersonel, silinecekEgitim, silinecekDepartman,homeOfisId, maas, girisTarihiId, egitimId, pozisyonId, departmanId, izinHakkiId, sigortaId, engelId, mezunId, kardoId, egitimsayisi = 0, deparmansayisi = 0, personelsayisi = 0;
        boolean anamenukontrol = true, egitimKontrol = true, personelmenukontrol = true, departmanKontrol = true;//Men├╝ kontrol de─či┼čkenleri
        Scanner veri = new Scanner(System.in);

//                         VER─░ G─░R─░┼×LER─░ BA┼×LANGI├ç
        GirisTarihiEkle(girisTarihiIslem); 
        
        EgitimEkle(egitimIslem);
        egitimsayisi=5;

        MezunDurumuEkle(mezunDurumIslem);
        
        DepartmanEkle(departmanIslem);
        deparmansayisi=5;
        
        PozisyonEkle(pozisyonIslem);
        
        
        engeldurumlari.add(new EngelDurumu(0, false));
        engeldurumlari.add(new EngelDurumu(1, true));

        izinHaklari.add(new SenelikIzinHakki(0, false));
        izinHaklari.add(new SenelikIzinHakki(1, true));

        sagliksigortalari.add(new SaglikSigortasi(0, false));
        sagliksigortalari.add(new SaglikSigortasi(1, true));

        kadroluPersoneller.add(new KadroluPersonel(0, false));
        kadroluPersoneller.add(new KadroluPersonel(1, true));
        
        homeOfisPersoneller.add(new HomeOfisPersonel(0,false));
        homeOfisPersoneller.add(new HomeOfisPersonel(1,true));
        


        personeller.add(new Personel(1, "Emirhan", "├çeriba┼č", "Erkek", 1, 1, 1, 5, 1200000, 1, 1, 1, 0, 1,0));
        personelsayisi++;
        personeller.add(new Personel(2, "Ey├╝p Can", "Ya─č─▒r", "Erkek", 5, 3, 3, 2, 12000, 10, 1, 1, 0, 1,0));
        personelsayisi++;
        personeller.add(new Personel(3, "Berkant", "Kocatepe", "Erkek", 2, 5, 5, 1, 1, 5, 0, 1, 0, 1,1));
        personelsayisi++;
        
//                         VER─░ G─░R─░┼×LER─░ B─░T─░┼×


        do {
            System.out.println("----------PERSONEL S─░STEM─░NE HO┼×GELD─░N─░Z----------");
            System.out.println("1--> Personellerin ki┼čisel bilgilerini g├Âr├╝nt├╝le");
            System.out.println("2--> Departmanlar─▒ g├Âr├╝nt├╝le");
            System.out.println("3--> E─čitimleri g├Âr├╝nt├╝le");
            System.out.println("4--> ---------------├ç─▒k─▒┼č yap---------------------");
            System.out.print("Yapmak istedi─činiz i┼člemi se├žiniz ==>");
            secim = veri.next();
            if ("1".equals(secim)) {

                do {
                    for (Personel personel : personeller) {//foreach ile personelleri yazd─▒r─▒yoruz
                        for (int i = 0; i < departmanlar.size(); i++) {//burdaki d├Âng├╝ ile personelin hangi pozisyonda oldu─čunu buluyoruz
                            if (personel.getDepartmanId() == departmanlar.get(i).getDepartmanId()) {//personelin bulundu─ču pozisyon do─čru mu yanl─▒┼č m─▒ oldu─čunu burada kontrol ediyoruz
                                System.out.println("Id: " + personel.getPersonelId() +
                                            "\n" + "Ad: " + personel.getAd() +
                                            "\n" + "Soyad: " + personel.getSoyad() +
                                            "\n" + "Cinsiyet: " + personel.getCinsiyet() +

                                            "\n" + "Departman: " + departmanIslem.DepartmanIdyeGoreAdG├Âr├╝nt├╝le(personel.getDepartmanId()) +
                                            "\n" + "─░zin Hakk─▒: " + senelikIzinHakkiIslem.IzinIdyeGoreAdG├Âr├╝nt├╝le(personel.getIzinHakkiId()) +
                                            "\nSa─čl─▒k sigortas─▒: " + saglikSigortasiIslem.sigortaIdyeGoreAdG├Âr├╝nt├╝le(personel.getSigotaId()) +
                                            "\nEngel Durumu: " + engelDurumuIslem.EngelIdyeGoreAdG├Âr├╝nt├╝le(personel.getEngelId()) +
                                            "\nKadro Durumu: " + kadroluPersonelIslem.KadroIdyeGoreAdG├Âr├╝nt├╝le(personel.getKadroId())+
                                        "\nHome Ofis Durumu: "+homeOfisPersonelIslem.HomeOfisPersonelIdyeGoreAdG├Âr├╝nt├╝le(personel.getHomeOfisId()));

                            }
                        }
                        for (int i=0; i < egitimler.size();i++){
                            if (personel.getEgitimId()==egitimler.get(i).getEgitimId()){
                                System.out.println("E─čitim: "+egitimIslem.EgitimIdyeGoreAdG├Âr├╝nt├╝le(personel.getEgitimId()));
                            }

                        }
//                        egitimIslem.EgitimleriListele();
                        for (int i=0;i<pozisyonlar.size();i++){
                            if (personel.getPozisyonId()==pozisyonlar.get(i).getPozisyonId()){
                                System.out.println("Pozisyon: "+pozisyonIslem.PozisyonIdyeGoreAdG├Âr├╝nt├╝le(personel.getPozisyonId()));
                            }
                        }
                        for (int i= 0;i<mezunDurumlar─▒.size();i++){
                            if (personel.getMezunDurumId()==mezunDurumlar─▒.get(i).getMezunDurumId()){
                                System.out.println("Mezun Durumu:"+mezunDurumIslem.mezunIdyeGoreAdG├Âr├╝nt├╝le(personel.getMezunDurumId())+"\n" + "Maa┼č: " + personel.getMaas());
                                System.out.println("------------------------------------------");
                            }

                        }

                    }
                    System.out.println("-)Personel Silme ");
                    System.out.println("+)Personel Ekleme");
                    System.out.println("*)Personel G├╝ncelleme");
                    System.out.println("0)Ana Men├╝");
                    System.out.print("====>");
                    secim = veri.next();
                    if ("-".equals(secim)) {
                        System.out.print("Silmek istedi─činiz personelin idsini giriniz :");
                        silinecekpersonel = veri.nextInt();
                        personelIslem.PersonelSil(silinecekpersonel);
                        System.out.println("\n" + silinecekpersonel + " idli personel silindi");
                    } else if ("+".equals(secim)) {
                        personelsayisi++;
                        System.out.print("Personelin ad─▒n─▒ giriniz:");
                        ad = veri.next();
    

                        System.out.println("Personelin soyad─▒n─▒ giriniz:");
                        soyad = veri.next();
                        veri.nextLine();
                        System.out.println("Personelin cinsiyeti giriniz:");
                        cinsiyet = veri.next();
                        for (Departman departman : departmanlar) {
                            System.out.println(departman.getDepartmanId() + " => " + departman.getAd());
                        }
                        System.out.println("Personelin departman─▒n─▒ giriniz:");
                        departmanId = veri.nextInt();

                        for (MezunDurum mezunDurum : mezunDurumlar─▒) {
                            System.out.println(mezunDurum.getMezunDurumId() + " => " + mezunDurum.getMezunDurumAd());
                        }
                        System.out.println("Personelin diploma t├╝r├╝n├╝ giriniz:");
                        mezunId = veri.nextInt();


                        for (Egitim egitim : egitimler) {
                            System.out.println(egitim.getEgitimId() + " => " + egitim.getAd());
                        }
                        System.out.println("Personelin ald─▒─č─▒ e─čitimi giriniz:");
                        egitimId = veri.nextInt();

                        for (Pozisyon pozisyon : pozisyonlar) {
                            System.out.println(pozisyon.getPozisyonId() + " =>" + pozisyon.getAd());
                        }
                        System.out.println("Personelin Pozisyonunu giriniz:");
                        pozisyonId = veri.nextInt();
                        System.out.println("Personelin maa┼č─▒n─▒ giriniz:");
                        maas = veri.nextInt();
                        for (GirisTarihi girisTarihi : girisTarihleri) {
                            System.out.println(girisTarihi.getGirisTarihiId() + "=>" + girisTarihi.getGirisYili());
                        }
                        System.out.println("Personelin giri┼č tarihini idsini giriniz:");
                        girisTarihiId = veri.nextInt();
                        System.out.println("1 => ─░zin hakk─▒ var\n0 => ─░zin hakk─▒ yok\nPersonelin izin hakk─▒n─▒ giriniz:");
                        izinHakkiId = veri.nextInt();
                        System.out.println("1 => Sigorta var\n0 => Sigorta Yok\nPersonelin sigorta durumunu giriniz:");
                        sigortaId = veri.nextInt();
                        System.out.println("1 => Engel Durumu var\n0 => Engel Durumu yok\nPersonelin engel durumunu giriniz");
                        engelId = veri.nextInt();

                        System.out.println("1 => Kadrolu\n0 => Kadrosuz\nPersonelin kadro durumunu giriniz");
                        kardoId = veri.nextInt();
                        
                        System.out.println("1 => Home Ofis\n0 => Home Ofis De─čil\nPersonelin home ofis durumunu giriniz");
                        homeOfisId = veri.nextInt();

                        personeller.add(new Personel(personelsayisi, ad, soyad, cinsiyet, departmanId, mezunId, egitimId, pozisyonId, maas, girisTarihiId, izinHakkiId, sigortaId, engelId, kardoId,homeOfisId));
                    } else if ("*".equals(secim)) {

                        System.out.println("G├╝ncellemek ─░stedi─činiz Personelin Id sini giriniz:");
                        int g├╝ncelleme = veri.nextInt();
                        personelIslem.PersonelGuncelle(g├╝ncelleme);

                    } else if ("0".equals(secim)) {
                        personelmenukontrol = false;

                    } else {
                        System.out.println("Yanl─▒┼č ─░┼člem yapt─▒n─▒z.");
                    }


                } while (personelmenukontrol);
            } else if ("2".equals(secim)) {

                do {
                    for (Departman departman : departmanlar) {
                        System.out.println("Departman Id: " + departman.getDepartmanId() + "\nDeparman Ad─▒: " + departman.getAd());
                        System.out.println("----------------------");
                    }
                    System.out.println("+)Departman Ekleme ");
                    System.out.println("-)Departman Silme");
                    System.out.println("0)Ana Men├╝");
                    System.out.print("====>");
                    secim = veri.next();
                    if ("+".equals(secim)) {
                        deparmansayisi++;
                        System.out.println("Eklenicek Departman─▒n adini giriniz: ");
                        departmanAd = veri.next();
                        departmanlar.add(new Departman(deparmansayisi, departmanAd));
                    } else if ("-".equals(secim)) {

                        System.out.print("Silmek istedi─činiz departman─▒n idsini giriniz :");
                        silinecekDepartman = veri.nextInt();
                        departmanIslem.DepartmanSil(silinecekDepartman);
                        System.out.println("\n" + silinecekDepartman + " idli departman silindi");

                    } else if ("0".equals(secim)) {
                        System.out.println("Geri gidiliyor...");
                        departmanKontrol = false;
                    } else {
                        System.out.println("Belirtilen ─░┼člemlerden Birini Giriniz");
                    }
                } while (departmanKontrol);
            } else if ("3".equals(secim)) {
                do {

                    for (Egitim egitim : egitimler) {
                        System.out.println("E─čitim Id: " + egitim.getEgitimId() + "\nE─čitim Ad─▒: " + egitim.getAd());
                        System.out.println("----------------------");
                    }
                    System.out.println("+)E─čitim Ekleme ");
                    System.out.println("-)E─čitim Silme");
                    System.out.println("0)Ana Men├╝");
                    System.out.print("====>");
                    secim = veri.next();
                    if ("+".equals(secim)) {
                        egitimsayisi++;
                        System.out.println("E─čitim ad─▒ giriniz: ");
                        egitimAd = veri.next();
                        veri.nextLine();
                        egitimler.add(new Egitim(egitimsayisi, egitimAd));
                    } else if ("-".equals(secim)) {

                        System.out.print("Silmek istedi─činiz E─čitim idsini giriniz :");
                        silinecekEgitim = veri.nextInt();
                        egitimIslem.EgitimSil(silinecekEgitim);
                        System.out.println("\n" + silinecekEgitim + " idli e─čitim silindi");
                    } else if ("0".equals(secim)) {
                        System.out.println("Geri gidiliyor...");
                        egitimKontrol = false;
                    } else {
                        System.out.println("Belirtilen ─░┼člemlerden Birini Giriniz");
                    }

                } while (egitimKontrol);
            } else if ("4".equals(secim)) {
                System.out.println("├ç─▒k─▒┼č Yap─▒l─▒yor ...");
                anamenukontrol = false;
            } else {
                System.out.println("\n\n\nL├╝rfen bir daha i┼člem se├žiniz. ");
            }
        } while (anamenukontrol);
    }

    private static void GirisTarihiEkle(GirisTarihiIslem girisTarihiIslem) {
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(1, 2011));
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(2, 2012));
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(3, 2013));
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(4, 2014));
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(5, 2015));
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(6, 2016));
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(7, 2017));
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(8, 2018));
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(9, 2019));
        girisTarihiIslem.GirisSaatiEkle(new GirisTarihi(10, 2020));
    }
    private static void EgitimEkle(EgitimIslem egitimIslem) {
        egitimIslem.EgitimEkle(new Egitim(1,"Etkin Y├Âneticilik ve Liderlik E─čitimi" ));
        egitimIslem.EgitimEkle(new Egitim(2,"Etkili Tak─▒m ├çal─▒┼čmas─▒ E─čitimi" ));
        egitimIslem.EgitimEkle(new Egitim(3,"Zaman Y├Ânetimi E─čitimi" ));
        egitimIslem.EgitimEkle(new Egitim(4,"Sat─▒┼č ve Pazarlama E─čitimi" ));
        egitimIslem.EgitimEkle(new Egitim(5,"M├╝zakere Teknikleri" ));
    }
    private static void MezunDurumuEkle(MezunDurumIslem mezunDurumIslem) {
            
        mezunDurumIslem.MezunDurumEkle(new MezunDurum(1, "─░lk Okul"));
        mezunDurumIslem.MezunDurumEkle(new MezunDurum(2, "Orta Okul"));
        mezunDurumIslem.MezunDurumEkle(new MezunDurum(3, "Lise"));
        mezunDurumIslem.MezunDurumEkle(new MezunDurum(4, "├ťniversite"));
        mezunDurumIslem.MezunDurumEkle(new MezunDurum(5, "Y├╝ksek Lisans"));
    }
    private static void DepartmanEkle(DepartmanIslem departmanIslem) {
        
        departmanIslem.DepartmanEkle(new Departman(1,"Y├Ânetim Departman─▒"));
        departmanIslem.DepartmanEkle(new Departman(2,"Pazarlama Departman─▒"));
        departmanIslem.DepartmanEkle(new Departman(3,"─░nsan Kaynaklar─▒ Departman─▒"));
        departmanIslem.DepartmanEkle(new Departman(4,"Hukuk Departman─▒"));
        departmanIslem.DepartmanEkle(new Departman(5,"├ťretim  Departman─▒"));
    }
    private static void PozisyonEkle(PozisyonIslem pozisyonIslem) {
        
        pozisyonIslem.PozisyonEkle(new Pozisyon(1,"CEO"));
        pozisyonIslem.PozisyonEkle(new Pozisyon(2,"Ba┼čkan ve Ba┼čkan Yard─▒mc─▒s─▒"));
        pozisyonIslem.PozisyonEkle(new Pozisyon(3,"Departman M├╝d├╝rleri"));
        pozisyonIslem.PozisyonEkle(new Pozisyon(4,"Patron"));
        pozisyonIslem.PozisyonEkle(new Pozisyon(5,"─░┼č├ži"));
        }
        
}
