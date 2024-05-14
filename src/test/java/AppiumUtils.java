import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public abstract class AppiumUtils {


    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
        // Read JSON file content to a string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        // Parse JSON string to list of hashmaps
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {});

        return data;
    }
    public AppiumDriverLocalService startAppiumServer(String ipAddress,int port){
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).withIPAddress(ipAddress).usingPort(port).build();
        service.start();
        return service;
    }
    public String getSccreenshotPath(String testCaseName , AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") +  "//src//ExtentReports" +testCaseName + ".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;
        //1.Capture and place in folder 2.extent report pick file and attach to  report
    }

}
