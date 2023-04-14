import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class mediaMarkt {
    private static final String EBAY_GLOBAL_DEALS_URL = "https://www.mediamarkt.com.tr/tr/category/_laptop-504926.html?searchParams=&sort=suggested&view=&page=";
    
    private static final String PRODUCT_CARD_CLASS = "product-wrapper";
    //private static final String PRODUCT_TITLE_CLASS = "prdct-desc-cntnr-name hasRatings";
    private static final String PRODUCT_LINK_SELECTOR = "div.content a";
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
        Document doc;
        try {
            doc = Jsoup.connect(EBAY_GLOBAL_DEALS_URL + m).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        Elements productElements = doc.getElementsByClass(PRODUCT_CARD_CLASS);
        
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

