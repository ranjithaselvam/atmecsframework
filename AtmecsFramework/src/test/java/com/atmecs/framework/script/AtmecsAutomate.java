package com.atmecs.framework.script;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.framework.testbase.Browsers;

public class AtmecsAutomate extends Browsers {
	    @Test
        public void automate()
        {
        	driver.findElement(By.className("btn orange-btn")).click();
        }
}
