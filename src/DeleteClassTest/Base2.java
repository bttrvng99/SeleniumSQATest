package DeleteClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.util.List;

public class Base2 {
    WebDriver driver;
    String URL_LOGIN = "http://localhost:8080/SQA_war/";
    String URl_Main = "http://localhost:8080/SQA_war/LoginController";
    String titleLogin = "Login";
    String titleMain = "Quản lý học phần";
    String expectedTitle = "Đăng ký lịch giảng";

    public Base2(){}


    public void setUp2() throws InterruptedException{
        System.setProperty("webdriver.edge.driver", "c:\\msedgedriver.exe");
        this.driver = new EdgeDriver();
        this.driver.get("http://localhost:8080/SQA_war/");
        this.driver.findElement(By.name("username")).sendKeys("trung");
        this.driver.findElement(By.name("password")).sendKeys("123456");
        this.driver.findElement(By.className("login100-form-btn")).click();
        Thread.sleep(1000L);

        Assert.assertEquals(this.driver.getTitle(), titleMain);

        List<WebElement> delbtns = driver.findElements(By.xpath("//a[contains(., 'Xóa')]"));
        for(int i = delbtns.size()-1 ; i>=0; i--){
            delbtns.get(i).click();
        }

    }

    @AfterTest
    public void clearUp() throws InterruptedException{
        setUp2();
        List<WebElement> delbtns = driver.findElements(By.xpath("//a[contains(., 'Xóa')]"));
        for(int i = delbtns.size()-1 ; i>=0; i--){
            delbtns.get(i).click();
        }
        driver.quit();
    }
}
