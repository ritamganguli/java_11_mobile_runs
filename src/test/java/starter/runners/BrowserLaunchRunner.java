package starter.runners;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
		"src/test/resources/features/browser_launch/validate_browser_launch.feature" }, glue = {
				"starter.steps" }, monochrome = false)
public class BrowserLaunchRunner {
	static Logger log = LogManager.getLogger();
	
	@BeforeClass
	public static void Setup() {
		try {
			log.info("File Deletion Running");
			FileUtils.deleteDirectory(new File("reports"));
			
			String lambdaTestCloud = System.getProperty("lambdaTestCloud");	
			if(lambdaTestCloud != null && lambdaTestCloud.equalsIgnoreCase("true")) {				
				log.info("##### Setting LambdaTest Options #####");
				Properties systemProperties = System.getProperties();
				List<String> keys = new ArrayList<String>();
				for(String key : systemProperties.stringPropertyNames()) {
				  keys.add(key);
				}
		
				Collections.sort(keys);
				keys.forEach((k) -> { 
					if(k.toString().contains("webdriver")) {
						if (k.equals("webdriver.remote.url")) {
							String hub = systemProperties.getProperty(k);
							int pos = hub.lastIndexOf(":");
						    if (pos > -1) {
						        hub = hub.substring(0, hub.indexOf("//"))
						             + "****your-user-name****:****your-access-key****"
						             + hub.substring(hub.indexOf("@") + "@".length());
						        log.info(k + " :: " + hub);
						    }
						} else if (k.contains("accessKey")) {
							log.info(k + " :: ****your-access-key****");
						} else {
							log.info(k + " :: " + systemProperties.getProperty(k));
						}
					} 
				});
				log.info("##### LambdaTest Options Added #####");
				log.info("Running on LambdaTest-->");
			} else {
				log.info("Continue execution-->");
			}		
		}
		catch (IOException e) {
		}
	}
}