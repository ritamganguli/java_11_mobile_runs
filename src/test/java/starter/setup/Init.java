package starter.setup;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

//import net.thucydides.core.util.EnvironmentVariables;
//import net.thucydides.core.environment.SystemEnvironmentVariables;

public class Init {

  private static EnvironmentVariables envVars;
 public static String getAppUrl() {
	  String appUrl=null;
     envVars = SystemEnvironmentVariables.createEnvironmentVariables();
     appUrl=System.getProperty("appUrl","").toString();
    if (appUrl.equals("")) {
    	appUrl =envVars.getProperty("appUrl");
	}
	return appUrl;
  }



}
