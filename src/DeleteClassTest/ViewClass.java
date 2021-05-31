package DeleteClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ViewClass extends Base{
    String expectedTitle = "XEM KẾ HOẠCH GIẢNG DẠY";
    String assignPlanTxt = "Đăng ký lịch giảng";

    @Test
    public void viewclass_test1(){
        List<WebElement> viewClassBtns = driver.findElements(By.xpath("//*[@id=\"main2\"]/tbody/tr[2]/th[8]/a[1]"));
        if(viewClassBtns.size()==0){
            Assert.assertEquals(driver.getTitle(), titleMain);
        } else {
            for(int i=viewClassBtns.size()-1; i>=0; i--){
                viewClassBtns.get(i).click();
                this.driver.findElement(By.xpath("/html/body/header/nav/ul/a")).click();
                Assert.assertEquals(driver.getTitle(), titleMain);

                WebElement delbtn = driver.findElement(By.xpath("//a[contains(., 'Xóa')]"));
                System.out.println(delbtn.getText());
                delbtn.click();
            }
        }
    }

    @Test
    public void viewclass_test2(){
        WebElement addSubjBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[2]/th[8]/a"));
        System.out.println(addSubjBtn.getText());
        addSubjBtn.click();
        this.driver.findElement(By.xpath("//*[@id=\"main2\"]/tbody/tr[2]/th[8]/a[1]")).click();


        this.driver.findElement(By.xpath("/html/body/header/nav/ul/a")).click();
        Assert.assertEquals(driver.getTitle(), titleMain);

        WebElement delbtn = driver.findElement(By.xpath("//a[contains(., 'Xóa')]"));
        System.out.println(delbtn.getText());
        delbtn.click();
    }

    @Test
    public void viewclass_test3(){
        WebElement addSubjBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[2]/th[8]/a"));
        System.out.println(addSubjBtn.getText());
        addSubjBtn.click();

        WebElement createPlanBtn = driver.findElement(By.xpath("//*[@id=\"main2\"]/tbody/tr[2]/th[8]/a[2]"));
        createPlanBtn.click();
        Assert.assertEquals(this.driver.getTitle(), assignPlanTxt);
        this.driver.findElement(By.name("kip")).sendKeys("1");
        this.driver.findElement(By.name("tenbaihoc")).sendKeys("Bai 1");
        this.driver.findElement(By.name("loai")).sendKeys("");
        this.driver.findElement(By.name("ghichu")).sendKeys("");
        this.driver.findElement(By.xpath("/html/body/div/form/button")).click();
        this.driver.findElement(By.xpath("/html/body/header/nav/ul/a")).click();
        Assert.assertEquals(this.driver.getTitle(), titleMain);

        this.driver.findElement(By.xpath("//*[@id=\"main2\"]/tbody/tr[2]/th[8]/a[1]")).click();


        this.driver.findElement(By.xpath("/html/body/header/nav/ul/a")).click();
        Assert.assertEquals(driver.getTitle(), titleMain);

        WebElement delbtn = driver.findElement(By.xpath("//a[contains(., 'Xóa')]"));
        System.out.println(delbtn.getText());
        delbtn.click();
    }


}
