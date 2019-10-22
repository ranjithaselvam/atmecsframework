package com.atmecs.konakart.script;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DynamicTestng {
	public void suiteTest(Map<String,String> testngParams) {

    //Create an instance on TestNG
     TestNG testNG = new TestNG();

    //Create an instance of XML Suite and assign a name for it.
     XmlSuite suite = new XmlSuite();
     suite.setName("Suite");

    //Create an instance of XmlTest and assign a name for it.
     XmlTest test = new XmlTest(suite);
     test.setName("test");
     

    //Add any parameters that you want to set to the Test.
     test.setParameters(testngParams);

    //Create a list which can contain the classes that you want to run.
     List<XmlClass> classes = new ArrayList<XmlClass> ();
     classes.add(new XmlClass("ProductSearch"));

    //Assign that to the XmlTest Object created earlier.
     test.setXmlClasses(classes);

    //Create a list of XmlTests and add the Xmltest you created earlier to it.
     List<XmlTest> myTests = new ArrayList<XmlTest>();
     myTests.add(test);

    //add the list of tests to your Suite.
     suite.setTests(myTests);

    //Add the suite to the list of suites.
     List<XmlSuite> suites = new ArrayList<XmlSuite>();
     suites.add(suite);

    //Set the list of Suites to the testNG object you created earlier.
     testNG.setXmlSuites(suites);

    TestListenerAdapter tla = new TestListenerAdapter();
    testNG.addListener(tla);

    //invoke run() - this will run your class.
     testNG.run();
    }


}


