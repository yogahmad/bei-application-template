package com.traveloka.bootcamp.arithmetic;

import com.traveloka.common.application.jetty.ApplicationRunner;
import com.traveloka.common.application.jetty.GroovyConfigParserInitializer;
import com.traveloka.common.application.jetty.LogDestination;

import java.io.IOException;
import java.util.Map;

public class ArithmeticServiceApplication {
  public static void main(String[] args) throws IOException, IllegalStateException {
    Map<String, Object> parsedArgs = ApplicationRunner.parseArguments(args);

    // do nothing if -h or --help is provided (print help)
    if(parsedArgs.containsKey("help")) return;

    String env = parsedArgs.containsKey("env") ? String.valueOf(parsedArgs.get("env")) : (System.getenv("TRAVELOKA_ENV") != null ? System.getenv("TRAVELOKA_ENV") : "dev");
    String group = parsedArgs.containsKey("group") ? String.valueOf(parsedArgs.get("group")) : "arithmetic";
    String node = parsedArgs.containsKey("node") ? String.valueOf(parsedArgs.get("node")) : "tv01";
    String configPath = parsedArgs.containsKey("configPath") ? String.valueOf(parsedArgs.get("configPath")) : null;
    boolean maintenanceMode =Boolean.parseBoolean(parsedArgs.containsKey("maintenance") ? String.valueOf(parsedArgs.get("maintenance")) : (System.getenv("TRAVELOKA_MAINTENANCE_MODE") != null ? System.getenv("TRAVELOKA_MAINTENANCE_MODE") : "false"));
    String additionalEnv = System.getenv("TRAVELOKA_ADDITIONAL_CONFIG_ENV") != null ? System.getenv("TRAVELOKA_ADDITIONAL_CONFIG_ENV") : "";

    // initialize GroovyConfigParser
    GroovyConfigParserInitializer.initialize(env, configPath, additionalEnv);

    // initialize and run ApplicationRunner
    try {
      ApplicationRunner runner = new ApplicationRunner(
          new ApplicationRunner.ApplicationConfig.Builder()
              .setTopLevelComponentClass(ArithmeticServiceComponent.class)
              .setPort(parsedArgs.containsKey("port") ? (int) parsedArgs.get("port") : 44444)
              .setLogDestination(LogDestination.NONE)
              .setMaintenanceMode(maintenanceMode)
              .build(),
          new ApplicationRunner.EnvironmentConfig(env, group, node)
      );

      runner.start();
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }
}
