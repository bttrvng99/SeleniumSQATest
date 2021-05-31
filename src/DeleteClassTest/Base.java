package DeleteClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
    WebDriver driver;
    String URL_LOGIN = "http://localhost:8080/SQA_war/";
    String URl_Main = "http://localhost:8080/SQA_war/LoginController";
    String titleLogin = "Login";
    String titleMain = "Quản lý học phần";
    String expectedTitle = "Đăng ký lịch giảng";


    public Base(){}

    @BeforeTest
    public void setUp() throws InterruptedException{
        System.setProperty("webdriver.edge.driver", "c:\\msedgedriver.exe");
        this.driver = new EdgeDriver();
        this.driver.get("http://localhost:8080/SQA_war/");
        this.driver.findElement(By.name("username")).sendKeys("trung");
        this.driver.findElement(By.name("password")).sendKeys("123456");
        this.driver.findElement(By.className("login100-form-btn")).click();
        Thread.sleep(1000L);

        Assert.assertEquals(this.driver.getTitle(), titleMain);

    }

    @AfterTest
    public void finishTest(){
        this.driver.quit();
    }
}
