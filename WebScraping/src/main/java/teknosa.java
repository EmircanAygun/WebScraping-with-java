import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class teknosa {
    private static final String URL = "https://www.teknosa.com/laptop-notebook-c-116004?s=%3Arelevance&page=";
    private static final String CARD = "prd";
    private static final String LINK = "div a";

    class Product {
        private String link;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
    
    public List<Product> extractProducts() {
        List<Product> products = new ArrayList<Product>();
        int m;
        int u = 0;
        for(m=2; m<18; m++){
        Document doc;
        try {
            doc = Jsoup.connect(URL + m).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        Elements productElements = doc.getElementsByClass(CARD);
        
        for (Element productElement : productElements) {
            Product product = new Product();
            
            Elements linkElements = productElement.select(LINK);
            if (!linkElements.isEmpty()) {
                 product.setLink(linkElements.get(0).attr("href"));
            }
            
            if((product).getLink() != null ){
                products.add(product);
            }
            u++;
        }
        }
        //System.out.println(u);
        return products;
    }
}
