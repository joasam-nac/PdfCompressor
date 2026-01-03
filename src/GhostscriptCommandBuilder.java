public class GhostscriptCommandBuilder {
    String gsPath = "gswin64c";
    String inputFile;
    private String outputFile;
    private CompressionQuality quality;

    public GhostscriptCommandBuilder setGsPath(String gsPath) {
        this.gsPath = gsPath;
        return this;
    }

    public GhostscriptCommandBuilder setGsPath() {
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

    public GhostscriptCommand build() {
        if (inputFile == null) inputFile = "input.pdf";
        if (outputFile == null) outputFile = "output.pdf";
        if (quality == null) quality = CompressionQuality.SCREEN;

        return new GhostscriptCommand(inputFile, outputFile, quality);
    }
}
