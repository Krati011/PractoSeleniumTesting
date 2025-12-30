package com.runner;

import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src\\test\\resource\\Features\\PractoHospital.feature",
glue = "com.stepDefinition",
plugin = {"pretty"},
tags="@testcase1 or @testcase2"
) 


public class TestRunnerParallelTestNg extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
