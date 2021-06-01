package DeleteClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteClass extends Base{
    String assignPlanTxt = "Đăng ký lịch giảng";
    @Test (priority = 2)
    public void del_test1() throws InterruptedException{
        WebElement addSubjBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[2]/th[8]/a"));
        addSubjBtn.click();
        WebElement delbtn = driver.findElement(By.xpath("//a[contains(., 'Xóa')]"));
        delbtn.click();
        System.out.println("Đã xóa môn học");
        Assert.assertEquals(this.driver.getTitle(), titleMain);
        Thread.sleep(10000L);
        driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[2]/th[8]/a")).click();
        WebElement addedSubject = driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[2]/th[2]"));
        WebElement expectedResult = driver.findElement(By.xpath("//*[@id=\"main2\"]/tbody/tr[2]/th[2]"));
        Assert.assertEquals(addedSubject.getText(), expectedResult.getText());
        Thread.sleep(10000L);

    }

    @Test (priority = 3)
    public void del_test2() throws InterruptedException{
        WebElement addSubjBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[3]/th[8]/a"));
        System.out.println(addSubjBtn.getText());
        addSubjBtn.click();
        WebElement createPlanBtn = driver.findElement(By.xpath("//*[@id=\"main2\"]/tbody/tr[3]/th[8]/a[2]"));
        createPlanBtn.click();
        Assert.assertEquals(this.driver.getTitle(), assignPlanTxt);
        this.driver.findElement(By.name("kip")).sendKeys("1");
        this.driver.findElement(By.name("tenbaihoc")).sendKeys("Bai 1");
        this.driver.findElement(By.name("loai")).sendKeys("");
        this.driver.findElement(By.name("ghichu")).sendKeys("");
        this.driver.findElement(By.xpath("/html/body/div/form/button")).click();
        this.driver.findElement(By.xpath("/html/body/header/nav/ul/a")).click();
        Assert.assertEquals(this.driver.getTitle(), titleMain);
        List<WebElement> delbtns2 = driver.findElements(By.xpath("//a[contains(., 'Xóa')]"));
        System.out.println(delbtns2.get(delbtns2.size()-1).getText());
        delbtns2.get(delbtns2.size()-1).click();
        Thread.sleep(10000L);
        Assert.assertEquals(this.driver.getTitle(), titleMain);
        driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[3]/th[8]/a")).click();
        WebElement addedSubject = driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[3]/th[2]"));
        WebElement expectedResult = driver.findElement(By.xpath("//*[@id=\"main2\"]/tbody/tr[3]/th[2]"));
        Assert.assertEquals(addedSubject.getText(), expectedResult.getText());
        Thread.sleep(10000L);

    }

    @Test (priority = 1)
    public void del_test3(){
        List<WebElement> delbtns = driver.findElements(By.xpath("//a[contains(., 'Xóa')]"));
        if(delbtns.size()==0){
            Assert.assertEquals(this.driver.getTitle(), titleMain);
            System.out.println("Không có nút xóa");
        } else {
            while(delbtns.size()>0){
                System.out.println(delbtns.get(0).getText());
                delbtns.get(0).click();
            }

            Assert.assertEquals(this.driver.getTitle(), titleMain);
        }
    }
}
