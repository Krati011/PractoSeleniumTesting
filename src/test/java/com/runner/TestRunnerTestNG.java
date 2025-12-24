package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

// practoTestRunner


//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src\\test\\resource\\Features\\PractoHospital.feature",
glue = "com.stepDefinition",
//plugin = {"pretty"},
//,
tags="@testcase1", //or
//dryRun = true,
//monochrome = true
plugin = {"pretty",
		"pretty:target/pretty.txt",
		"html: target/CucumberReport/Cucumber.html",
		"json:target/CucumberJson.json",
		"junit:target/CucumberJunit.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//plugin = {"usage"}'

)


public class TestRunnerTestNG extends AbstractTestNGCucumberTests{
	

}