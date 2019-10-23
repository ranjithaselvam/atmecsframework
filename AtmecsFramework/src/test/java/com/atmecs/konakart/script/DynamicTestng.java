package com.atmecs.konakart.script;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 * Dynamic suite creation
 * 
 * @author ranjitha.selvam
 *
 */
public class DynamicTestng {
	
	//public static void suiteTest() {

		//XmlSuite xmlSuite = new XmlSuite();
		//xmlSuite.setName("Suite");

		//XmlTest xmlTest = new XmlTest(xmlSuite);

		//xmlTest.setName("Test");
		//xmlTest.setThreadCount(3);
		//XmlClass publicTestClass = new XmlClass(ProductSearch.class);
		//List<XmlClass> list = new ArrayList<XmlClass>();
		//list.add(publicTestClass);

		//xmlTest.setXmlClasses(list);
		//TestNG testng = new TestNG();

		//List<XmlSuite> suites = new ArrayList<XmlSuite>();
		//suites.add(xmlSuite);
		//testng.setXmlSuites(suites);
		//testng.run();

//	}

//}

	//public static void suiteTest()
	//{
 // TestNG testNG = new TestNG(); 
 // XmlSuite suite = new XmlSuite();
 // suite.setName("Suite"); 
 // XmlTest test = new XmlTest(suite);
  //test.setName("Test"); 
  //test.setThreadCount(3); 
  //test.setParameters(testngParams);
 // List<XmlClass> classes = new ArrayList<XmlClass> ();
 // classes.add(new XmlClass(ProductSearch.class));
 // test.setXmlClasses(classes); 
 // List<XmlTest> myTests = new ArrayList<XmlTest>();
 // myTests.add(test); suite.setTests(myTests);
 // List<XmlSuite> suites = new ArrayList<XmlSuite>(); suites.add(suite);
 // testNG.setXmlSuites(suites); 
   //TestListenerAdapter tla = new TestListenerAdapter();
  // testNG.addListener(tla); 
 // testNG.run();
//}
//}

 public void runTestNGTest(Map<String,String> testngParams)
  {   
     TestNG testNG = new TestNG();   
     XmlSuite suite = new XmlSuite(); 
     suite.setName("Suite"); 
     suite.setParallel(XmlSuite.ParallelMode.TESTS);  
     XmlTest test = new XmlTest(suite); 
     test.setName("Test");   
     test.setParameters(testngParams); 
     List<XmlClass> classes = new ArrayList<XmlClass>();
     classes.add(new XmlClass(ProductSearch.class));   
     test.setXmlClasses(classes);   
     List<XmlTest> tests = new ArrayList<XmlTest>(); 
     tests.add(test);   
     suite.setTests(tests); 
     suite.setFileName("myTemp.xml");
     List<XmlSuite> suites = new ArrayList<XmlSuite>(); 
     suites.add(suite);    
     testNG.setXmlSuites(suites);
    
     suite.setThreadCount(3);   
     testNG.run();
     for(XmlSuite x : suites) 
    {  
        createXmlFile(x); 
    }   
    System.out.println("Filerated successfully.");   
    Map<String,String> params = test.getParameters(); 
    for(Map.Entry<String,String> entry : params.entrySet()) 
    { 
      System.out.println(entry.getKey() + " => " + entry.getValue()); 
    }
   }
   public void createXmlFile(XmlSuite mSuite) 
   { 
      FileWriter writer; 
      try { 
           writer = new FileWriter(new File("myTemp.xml")); 
           writer.write(mSuite.toXml()); 
           writer.flush(); 
           writer.close(); 
           System.out.println(new File("myTemp.xml").getAbsolutePath());            
           } catch (IOException e)
           {
             e.printStackTrace(); 
           }
   }
  
   @Test
   public void suiteTest()
   {
	   Map<String,String> testngParams = new HashMap<String,String>(); 
	   testngParams.put("browser", "firefox");
	   runTestNGTest(testngParams); 
   }
}
