package DeleteClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteClass extends Base{
    String assignPlanTxt = "Đăng ký lịch giảng";
    @Test
    public void del_test1(){
        WebElement addSubjBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[2]/th[8]/a"));
        System.out.println(addSubjBtn.getText());
        addSubjBtn.click();
        WebElement delbtn = driver.findElement(By.xpath("//a[contains(., 'Xóa')]"));
        System.out.println(delbtn.getText());
        delbtn.click();

        Assert.assertEquals(this.driver.getTitle(), titleMain);
    }

    @Test
    public void del_test2(){
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
        WebElement delbtn = driver.findElement(By.xpath("//a[contains(., 'Xóa')]"));
        System.out.println(delbtn.getText());
        delbtn.click();

        Assert.assertEquals(this.driver.getTitle(), titleMain);
    }

    @Test
    public void del_test3(){
        List<WebElement> delbtns = driver.findElements(By.xpath("//a[contains(., 'Xóa')]"));
        if(delbtns.size()==0){
            Assert.assertEquals(this.driver.getTitle(), titleMain);
        } else {
            for(int i=0; i<delbtns.size(); i++){
                System.out.println(delbtns.get(i).getText());
                delbtns.get(i).click();
            }

            Assert.assertEquals(this.driver.getTitle(), titleMain);
        }
    }
}
