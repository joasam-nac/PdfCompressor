public class GhostscriptCommandBuilder {
    String gsPath;
    String inputFile;
    private String outputFile;
    private CompressionQuality quality;

    public GhostscriptCommandBuilder setGsPath(String gsPath) {
        this.gsPath = gsPath;
        return this;
    }

    public GhostscriptCommandBuilder setInputFile(String inputFile) {
        this.inputFile = inputFile;
        return this;
    }

    public GhostscriptCommandBuilder setOutputFile(String outputFile) {
        this.outputFile = outputFile;
        return this;
    }

    public GhostscriptCommandBuilder setQuality(CompressionQuality quality) {
        this.quality = quality;
        return this;
    }

    public GhostscriptCommand build(AppConfig config) {
        if (gsPath == null) gsPath = config.getGhostscriptPath();
        if (inputFile == null) inputFile = config.getDefaultInput();
        if (outputFile == null) outputFile = config.getDefaultOutput();
        if (quality == null) quality = config.getDefaultQuality();

        return new GhostscriptCommand(gsPath, inputFile, outputFile, quality);
    }
}
