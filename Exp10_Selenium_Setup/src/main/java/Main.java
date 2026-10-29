
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");

            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Selenium test executed successfully!");
        } finally {
            driver.quit();
        }
    }
}
