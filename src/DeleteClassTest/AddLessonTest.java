package DeleteClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddLessonTest extends Base2{

    @Test
    public void addlesson_test1() throws InterruptedException{
        setUp2();
        generateClass();
        driver.findElement(By.name("kip")).sendKeys("1");
        driver.findElement(By.name("tenbaihoc")).sendKeys("Bai 1");
        driver.findElement(By.name("loai")).sendKeys("");
        driver.findElement(By.name("ghichu")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/h4")).getText(), "Thêm thành công!");
        driver.close();
    }

    @Test
    public void addlesson_test2() throws InterruptedException{
        setUp2();
        generateClass();
        driver.findElement(By.name("kip")).sendKeys("-1");
        driver.findElement(By.name("tenbaihoc")).sendKeys("Bai -1");
        driver.findElement(By.name("loai")).sendKeys("");
        driver.findElement(By.name("ghichu")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/h4")).getText(), "Yêu cầu nhập lại!");
        driver.close();
    }

    @Test
    public void addlesson_test3() throws InterruptedException{
        setUp2();
        generateClass();
        driver.findElement(By.name("kip")).sendKeys("1.5");
        driver.findElement(By.name("tenbaihoc")).sendKeys("Bai 1");
        driver.findElement(By.name("loai")).sendKeys("");
        driver.findElement(By.name("ghichu")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/h4")).getText(), "Yêu cầu nhập lại!");
        driver.close();
    }

    @Test
    public void addlesson_test4() throws InterruptedException{
        setUp2();
        generateClass();
        driver.findElement(By.name("kip")).sendKeys("17154916391691864916491561946394619461");
        driver.findElement(By.name("tenbaihoc")).sendKeys("Bai 137119569164619");
        driver.findElement(By.name("loai")).sendKeys("");
        driver.findElement(By.name("ghichu")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/h4")).getText(), "Yêu cầu nhập lại!");
        driver.close();
    }

    @Test
    public void addlesson_test5() throws InterruptedException{
        setUp2();
        generateClass();
        driver.findElement(By.name("kip")).sendKeys("Một");
        driver.findElement(By.name("tenbaihoc")).sendKeys("Bai 1");
        driver.findElement(By.name("loai")).sendKeys("");
        driver.findElement(By.name("ghichu")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/h4")).getText(), "Yêu cầu nhập lại!");
        driver.close();
    }

    @Test
    public void addlesson_test6() throws InterruptedException{
        setUp2();
        generateClass();
        driver.findElement(By.name("kip")).sendKeys("");
        driver.findElement(By.name("tenbaihoc")).sendKeys("");
        driver.findElement(By.name("loai")).sendKeys("");
        driver.findElement(By.name("ghichu")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/h4")).getText(), "Yêu cầu nhập lại!");
        driver.close();
    }

    @Test
    public void addlesson_test7() throws InterruptedException{
        setUp2();
        generateClass();
        driver.findElement(By.name("kip")).sendKeys("2");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/h4")).getText(), "Yêu cầu nhập lại!");
        driver.close();
    }

    public void generateClass(){
        WebElement addSubjBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/tbody/tr[2]/th[8]/a"));
        System.out.println(addSubjBtn.getText());
        addSubjBtn.click();
        WebElement createPlanBtn = driver.findElement(By.xpath("//*[@id=\"main2\"]/tbody/tr[2]/th[8]/a[2]"));
        createPlanBtn.click();

        Assert.assertEquals(this.driver.getTitle(), expectedTitle);
    }

    public void deleteifExist(){
        WebElement delbtn = driver.findElement(By.xpath("//a[contains(., 'Xóa')]"));
        System.out.println(delbtn.getText());
        delbtn.click();
    }
}
