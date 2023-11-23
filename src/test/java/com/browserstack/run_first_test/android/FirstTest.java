package com.browserstack.run_first_test.android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class FirstTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
    	int num1 = generateRandomNumbers();
    	int num2 = generateRandomNumbers();
    	String a = Integer.toString(num1);
    	String b= Integer.toString(num2);
      AndroidElement searchElement1 = (AndroidElement) new WebDriverWait(driver, 30).until(
          ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/digit_"+a))));
      searchElement1.click();

      AndroidElement add = (AndroidElement) new WebDriverWait(driver, 30).until(
              ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/op_add"))));
          add.click();
          
      AndroidElement searchElement2 = (AndroidElement) new WebDriverWait(driver, 30).until(
              ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/digit_"+b))));
          searchElement2.click();
          
          AndroidElement getResult = (AndroidElement) new WebDriverWait(driver, 30).until(
                  ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/result_preview"))));
         String res= getResult.getText();
         Integer.parseInt(res);
          Assert.assertTrue(num1+num2==Integer.parseInt(res));

    }
   
    
    public int getAddition(int a,int b) {

    	return a+b;
    }
    
    public int generateRandomNumbers() {
    	
    	Random random = new Random();
    	int randomDigit = random.nextInt(10);
    	return randomDigit;
    }
}
