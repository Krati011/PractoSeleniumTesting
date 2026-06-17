package com.runner;
//practoTestRunner

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src\\test\\resource\\Features\\PractoHospital.feature",
glue = "com.stepDefinition",
//plugin = {"pretty"},
//tags="@testcase6",
plugin = {"pretty",
		"pretty:target/pretty.txt",
		"html: target/CucumberReport/Cucumber.html",
		"json:target/CucumberJson.json",
		"junit:target/CucumberJunit.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)


public class TestRunnerTestNG extends AbstractTestNGCucumberTests{
	

}