package com.practiceFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practiceFramework.company.testbase.TestBase;

public class A extends TestBase{
	
	@Test
	public void testLoginA(){
		Assert.assertTrue(true);
	}

}
