import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private final Properties prop = new Properties();

    public AppConfig(String configFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(configFile)) {
            prop.load(fis);
        }
    }

    public String getGhostscriptPath() {
        return prop.getProperty("ghostscript.path", "gswin64c");
    }

    public String getDefaultInput() {
        return prop.getProperty("default.input", "input.pdf");
    }

    public String getDefaultOutput() {
        return prop.getProperty("default.output", "output.pdf");
    }

    public CompressionQuality getDefaultQuality() {
        String quality = prop.getProperty("default.quality", "SCREEN");
        return CompressionQuality.valueOf(quality);
    }
}
