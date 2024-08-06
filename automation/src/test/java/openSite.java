
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class openSite {
    public static void main(String[] args) throws IOException, InterruptedException {
        // System Property for Chrome Driver
        WebDriverManager.chromedriver().setup();
        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver();



        // Launch Website
        driver.navigate().to("http://www.jamesallen.com/");

        //Maximize the browser
        driver.manage().window().maximize();

        driver.navigate().to("http://www.jamesallen.com/sitemap");
        ArrayList<String> goodLinks = new ArrayList<>();

        // Get all the available Links
        List<WebElement> links
                = driver.findElements(By.tagName("a"));

        // Iterating through all the Links and printing link
        // text
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(link.getAttribute("href")))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());


            if (response.statusCode() != 200){
                System.out.println("Error");
            }
            else {
                goodLinks.add(link.getAttribute("href"));
            }

        }
        System.out.println(goodLinks);
        driver.close();

    }
}
