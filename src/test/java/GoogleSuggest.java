import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSuggest {
    @Test
    public void googleSuggestTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com.ua/webhp?complete=1&hl=ru");
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("гладиолус");
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));
            if (resultsDiv.isDisplayed()) {
                break;
            }
        }
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }
    }
}
