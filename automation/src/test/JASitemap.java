import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JASitemap {

    public static void main(String[] args) {

        String url = "https://www.jamesallen.com/sitemap/";
        try {
            // Fetch the HTML content from the URL
            Document document = Jsoup.connect(url).get();

            // Select all links in the document
            Elements links = document.select("a[href]");

            // Use a set to avoid duplicate links
            Set<String> uniqueLinks = new HashSet<>();

            // Iterate through each link element and retrieve the href attribute
            for (Element link : links) {
                String linkHref = link.attr("href");
                if (!linkHref.isEmpty()) {
                    uniqueLinks.add(linkHref);
                }
            }

            String base = "https://www.jamesallen.com";
            System.out.println("Found " + uniqueLinks.size() + " unique links:");
            for (String link : uniqueLinks) {
                System.out.println("\n" + link);
                if (!link.startsWith("/")) {
                    link = "/" + link;
                }
                String path = base + link;
                System.out.println("path: " + path);
               // if (path = "https://www.jamesallen.com/mailto:service@jamesallen.com"
                Connection connection = Jsoup.connect(path).timeout(500000);

                Connection.Response response = connection
                        .execute();
                System.out.println("Response: " + response.statusCode());
                if (response.statusCode() == 200) {
                    System.out.println("PASS" );
                } else {
                    System.out.println("FAILED" );
                }



            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
