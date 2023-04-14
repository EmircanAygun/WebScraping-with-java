import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class NewClass {
    
    
    public static void main(String[] args) throws SQLException {

//n11 ürün linki çekme        
        n11 jsoupScrapper2 = new n11();
        List<n11.Product> nProducts = jsoupScrapper2.extractProducts();
        int r = 0;
        for (n11.Product product2 : nProducts) {
            
            //System.out.println( String.format("Product:\n%s\n\n", product2.getLink()) );
            r++;
        }
        System.out.println(r + " çekilen link - n11");

//vatan ürün linki çekme        
        vatan jsoupScrapper3 = new vatan();
        List<vatan.Product> vProducts = jsoupScrapper3.extractProducts();
        int r2 = 0;
        for (vatan.Product product3 : vProducts) {
            
            //System.out.println( String.format("Product:\n%s\n\n", product3.getLink()) );
            r2++;
        }
        System.out.println(r2 + " çekilen link - vatan");
    
//teknosa ürün linki çekme
        teknosa jsoupScrapper5 = new teknosa();
        List<teknosa.Product> products5 = jsoupScrapper5.extractProducts();
        int r3 = 0;
        for (teknosa.Product product5 : products5) {
            
            //System.out.println( String.format("Product:\n%s\n\n", product5.getLink()) );
            r3++;
        }
        System.out.println(r3 + " çekilen link - teknosa");        
        
//***************************************************************************************

////n11 ÜRÜN ÖZELLÝKLERÝ ÇEKME
//System.out.println("\nn11");
//int i2 = 0;
//    
//for (n11.Product n11Product : nProducts) {
//        Baglanti baglanti=new Baglanti(  );
//        Connection conn=baglanti.baglan(  );    
//        Document doc2;
//        try {
//                doc2 = Jsoup.connect(String.format(n11Product.getLink())).get();
//        } catch (IOException e) {
//                throw new RuntimeException(e);
//        }
//        String q1 = null,q2 = null,q3 = null,q4 = null,q5 = null,q6 = null,q7 = null,q8 = null,q9 = null,q10 = null,q11 = null,q12,q13;
//        String n;
//        String k;
//        String pr2;
//        String title2;
//        
//        
//        
//        System.out.println( String.format(n11Product.getLink()) ) ;
//        
//        Elements fiyat2 = doc2.select("div.unf-p-summary-price");
//        
//        
//        
//        Elements ttl2 = doc2.select("div.proNameHolder div");
//        title2 = ttl2.select("h1.proName").text();
//        System.out.println(title2);       
//        
//        pr2 = fiyat2.select("*").text();
//        System.out.print(pr2 + " - ");
//        
//        Elements n11Elements = doc2.select("div.unf-prop-context ul");
//        
//        for (Element productElement : n11Elements) {           
//            
//            Elements productElements2 = n11Elements.select("li.unf-prop-list-item");
//            for (Element productElement2 : productElements2) {
//                n = productElement2.select("*").text();
//                
//
//                if(n.contains("Ýþlemci") == true && n.contains("Hýzý") == false && n.contains("Çekirdek") == false && n.contains("Modeli") == false ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    System.out.print(k + " - ");
//                }
//                else if(n.contains("Ýþletim Sistemi") == true ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    q3=k;
//                    System.out.print(k + " - ");
//                }
//                else if(n.contains("Ekran Kartý Modeli") == true ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    q11=k;
//                    System.out.print(k + " - ");
//                }
//                else if(n.contains("Disk Kapasitesi") == true ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    q7=k.substring(0, k.indexOf(" "));
//                    System.out.print(k.substring(0, k.indexOf(" ")) + " - ");
//                }
//                else if(n.contains("Disk Türü") == true ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    q6=k;
//                    System.out.print(k + " - ");
//                }
//                else if(n.contains("Bellek Kapasitesi") == true ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    q5=k.substring(0, k.indexOf(" "));
//                    System.out.print(k.substring(0, k.indexOf(" ")) + " - ");
//                }
//                else if(n.contains("Ýþlemci Modeli") == true ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    q4 = k.substring(k.lastIndexOf(" ")+1);
//                    System.out.print(k.substring(k.lastIndexOf(" ")+1) + " - ");
//                }
//                else if(n.contains("Model") == true ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    q2 = k.substring(k.lastIndexOf(" ")+1);
//                    System.out.print(k.substring(k.lastIndexOf(" ")+1) + " - ");
//                }
//                else if(n.contains("Ekran Boyutu") == true ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    q10=k;
//                    System.out.print(k + " - ");
//                }
//                else if(n.contains("Marka") == true ){
//                    k = productElement2.select("p.unf-prop-list-prop").text();
//                    q1 = k;
//                    System.out.print(k + " - ");
//                }
//         
//            }        
//
//            System.out.println("n11 \n");
//        }
//    i2++;
//    
//
//    String query = " insert into ws_db (marka, model_no, isletim_sistemi, islemci, ram,disk_turu,disk_boyutu,fiyat,site_ismi,ekran_boyutu,ekran_kartý,site_link,title)"
//        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//    
//    PreparedStatement preparedStmt = conn.prepareStatement(query);
//    
//                        preparedStmt.setString (1, q1);
//                        preparedStmt.setString (2, q2);
//                        preparedStmt.setString (3, q3);
//                        preparedStmt.setString (4, q4);
//                        preparedStmt.setString(5, q5);
//                        preparedStmt.setString (6, q6);
//                        preparedStmt.setString (7, q7);
//                        preparedStmt.setString (8, pr2);
//                        preparedStmt.setString (9, "1");
//                        preparedStmt.setString (10, q10);
//                        preparedStmt.setString (11, q11);
//                        preparedStmt.setString (12, String.format(n11Product.getLink()));
//                        preparedStmt.setString (13, title2);   
//    
//    preparedStmt.execute();
//    conn.close();
//    }
//    System.out.println(i2);    
//    
//        
////vatan ürün özellikleri çekme
//System.out.println("Vatan");
//int i3 = 0;
//    for (vatan.Product vatanProduct : vProducts) {
//            
//        Document doc3;
//        try {
//            doc3 = Jsoup.connect( "https://www.vatanbilgisayar.com" + String.format(vatanProduct.getLink()) ).get();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        String k3;
//        String n3;
//        String pr3;
//        String name3;
//        String title3;
//        
//        System.out.println("https://www.vatanbilgisayar.com" + String.format(vatanProduct.getLink()) ) ;
//        
//        Elements fiyat3 = doc3.select("div.product-list__cost.product-list__description");
//        
//        Elements vatanElements2 = doc3.select("div.wrapper-breadcrumb div div div ul");
//        name3 = vatanElements2.select("li:nth-of-type(4)").text();
//        
//        Elements vatanElements3 = doc3.select("div.product-list__content.product-detail-big-price");
//        title3 = vatanElements3.select("h1.product-list__product-name").text();
//        
//        Elements vatanElements = doc3.select("div.row.masonry-tab div div table tbody tr");        
//        System.out.println(title3);
//        System.out.print(name3 + " - ");
//        for (Element vatanElement : vatanElements) {
//            
//            k3 = vatanElement.select("*").text();
//                        
//            if(k3.contains("Ýþlemci Numarasý") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3 + " - ");
//            }
//            else if(k3.contains("Ram (Sistem Belleði)") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3.substring(0, n3.indexOf(" ")) + "- ");
//            }
//            else if(k3.contains("Ekran Kartý Chipseti") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3 + " - ");
//            }
//            else if(k3.contains("Üretici Part Numarasý") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3 + " - ");
//            }
//            else if(k3.contains("Ekran Boyutu") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3.substring(0, n3.indexOf(" ")) + " - ");
//            }
//            else if(k3.contains("Ýþlemci Nesli") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3 + " - ");
//            }
//            else if(k3.contains("Ýþlemci Teknolojisi") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3 + " - ");
//            }
//            else if(k3.contains("Ýþletim Sistemi") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3 + " - ");
//            }
//            else if(k3.contains("Disk Türü") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3 + " - ");
//            }
//            else if(k3.contains("Disk Kapasitesi") == true ){
//                n3 = vatanElement.select("p").text();
//                System.out.print(n3.substring(0, n3.indexOf(" ")) + " - ");
//            } 
//        }
//        pr3 = fiyat3.select("span").get(0).text();
//        System.out.print(pr3 + " - ");
//        
//    System.out.println("Vatan \n");
//    i3++;
//    }
//System.out.println(i3);
//    
////  TEKNOSA ÜRÜN ÖZELLÝKLERÝ ÇEKME   
//    System.out.println("Teknosa");
//    List<String> st = new ArrayList<String>();
//    List<String> st2 = new ArrayList<String>();
//    
//    for (teknosa.Product product5 : products5) {    
//       
//        Document doc5;
//        try {
//                doc5 = Jsoup.connect(String.format( "https://www.teknosa.com/" + product5.getLink()) ).get();
//        } catch (IOException e) {
//                throw new RuntimeException(e);
//        }
//        
//        String k5;
//        String n5;
//        String price5;
//        String name5;
//        String title5;
//        Elements productElements  = doc5.select("div.ptf-body table tbody tr th");
//        Elements productElements2 = doc5.select("div.ptf-body table tbody tr td");
//        Elements productElements3 = doc5.select("div.prd-block2 div div span");
//        Elements productElements4 = doc5.select("div.pdp-base h1 b");
//        Elements productElements5 = doc5.select("div.pdp-base");
//        
//        for (Element productElement : productElements ) {           
//            k5 = productElement.select("*").text();
//            st.add(k5);
//        }
//        for (Element productElement2 : productElements2 ) {           
//            n5 = productElement2.select("*").text();
//            st2.add(n5);
//        }
//        price5 = productElements3.select("*").text();
//        name5  = productElements4.select("*").text();
//        title5 = productElements5.select("h1.pdp-title").text();
//
//        System.out.println(String.format( "https://www.teknosa.com/" + product5.getLink()) );
//        System.out.println(title5);
//        System.out.print(name5 + " - ");
//        for (int p = 0; p < st.size(); p++) {
// 
//            if((st.get(p)).equals("SSD Kapasitesi")){
//            System.out.print(st2.get(p).substring(0, st2.get(p).indexOf(" ")) + " - ");
//            }
//            if((st.get(p)).equals("Ekran Boyutu")){
//            System.out.print(st2.get(p).substring(0, st.get(p).indexOf(" ")) + " - ");
//            }
//            if((st.get(p)).equals("Model Kodu")){
//            System.out.print(st2.get(p) + " - ");
//            }
//            if((st.get(p)).equals("Disk Türü")){
//            System.out.print(st2.get(p) + " - ");
//            }
//            if((st.get(p)).equals("Ýþlemci")){
//            System.out.print(st2.get(p) + " - ");
//            }
//            if((st.get(p)).equals("Ýþlemci Nesli")){
//            System.out.print(st2.get(p) + " - ");
//            }
//            if((st.get(p)).equals("Ýþletim Sistemi Yazýlýmý")){
//            System.out.print(st2.get(p) + " - ");
//            }
//            if((st.get(p)).equals("Ekran Kartý Modeli")){
//            System.out.print(st2.get(p) + " - ");
//            }
//            if((st.get(p)).equals("Ram")){
//            System.out.print(st2.get(p).substring(0, st2.get(p).indexOf(" ")) + " - ");
//            }
//            
//        }	 	
//        System.out.print(price5.substring(0, price5.indexOf(" ")) + " - ");
//        System.out.println("Teknosa \n");
//    
//    st.clear();
//    st2.clear();
//
//    }  
//    


    }
}



