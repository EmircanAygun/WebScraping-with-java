import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class hepsiBurada {
    private static final String EBAY_GLOBAL_DEALS_URL = "https://www.hepsiburada.com/laptop-notebook-dizustu-bilgisayarlar-c-98?sayfa=";
    
    private static final String PRODUCT_CARD_CLASS = "productListContent-zAP0Y5msy8OHn5z7T_K_";
    //private static final String PRODUCT_TITLE_CLASS = "prdct-desc-cntnr-name hasRatings";
    private static final String PRODUCT_LINK_SELECTOR = "div.moria-ProductCard-joawUM cxrSvK stijz9l070i a";
    //private static final String PRODUCT_PRICE_SELECTOR = "div.prc-box-dscntd";

    class Product {
        private String name;
        private String link;
        private String formattedPrice;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
        
        public String getFormattedPrice() {
            return formattedPrice;
        }

        public void setFormattedPrice(String formattedPrice) {
            this.formattedPrice = formattedPrice;
        }
    }
    
    public List<Product> extractProducts() {
        List<Product> products = new ArrayList<Product>();
        int m;
        int u=0;
        
        for(m=2;m<5;m++){
        Document dok;
        try {
            Connection.Response response = Jsoup.connect(EBAY_GLOBAL_DEALS_URL + m).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36 Edg/106.0.1370.42").timeout(0).execute();
        int statusCode = response.statusCode();
        if(statusCode == 200){
        Document doc = Jsoup.parse(response.body(),EBAY_GLOBAL_DEALS_URL + m);
        System.out.println("opened page: "+ EBAY_GLOBAL_DEALS_URL + m);
        }


//            doc = Jsoup.connect(EBAY_GLOBAL_DEALS_URL + m).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)"
//                    + " Chrome/106.0.0.0 Safari/537.36 Edg/106.0.1370.47").timeout(0).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        Elements productElements = dok.getElementsByClass(PRODUCT_CARD_CLASS);
        
        for (Element productElement : productElements) {
            Product product = new Product();
            
            Elements linkElements = productElement.select(PRODUCT_LINK_SELECTOR);
            if (!linkElements.isEmpty()) {
                 product.setLink(linkElements.get(0).attr("href"));
            }
            
            if((product).getLink() != null ){products.add(product);}
            u++;
        }
        }
        System.out.println(u);
        return products;
    }
}
