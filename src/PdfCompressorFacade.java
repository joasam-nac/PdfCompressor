import java.io.IOException;

public class PdfCompressorFacade {
    private final AppConfig config;
    private final GhostscriptExecutor gsExecutor;

    public PdfCompressorFacade(String configFile) throws IOException {
        this.config = new AppConfig(configFile);
        this.gsExecutor = new GhostscriptExecutor();
    }

    // följer config.properties
    public void compress() throws Exception {
        GhostscriptCommand gc = new GhostscriptCommandBuilder().build(config);
        gsExecutor.execute(gc);
    }

    // egen in och ut filer
    public void compress(String inputFile, String outputFile) throws Exception {
        GhostscriptCommand gc = new GhostscriptCommandBuilder()
                .setInputFile(inputFile).setOutputFile(outputFile).build(config);
        gsExecutor.execute(gc);
    }

    // väljer kvalitet, och in och ut filer
    public void compress(String inputFile, String outputFile, CompressionQuality quality) throws Exception {
        GhostscriptCommand gs = new GhostscriptCommandBuilder()
                .setInputFile(inputFile).setOutputFile(outputFile).setQuality(quality).build(config);
        gsExecutor.execute(gs);
    }
}
