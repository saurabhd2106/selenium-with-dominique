package commonLibrary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static void takeScreenshot(WebDriver driver, String filename) throws Exception {

		filename = filename.trim();

		File imgFile, tmpFile;

		imgFile = new File(filename);

		if (imgFile.exists()) {
			throw new Exception("File already exists..");
		}

		TakesScreenshot camera;

		camera = (TakesScreenshot) driver;

		tmpFile = camera.getScreenshotAs(OutputType.FILE);

		FileUtils.moveFile(tmpFile, imgFile);

	}

}
