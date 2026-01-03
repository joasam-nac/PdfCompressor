void main() {
    GhostscriptCommand cmd =
            new GhostscriptCommandBuilder()
                    .setInputFile("input.pdf")
                    .setOutputFile("output.pdf")
                    .setQuality(CompressionQuality.SCREEN)
                    .build();

    try {
        new GhostscriptExecutor().execute(cmd);
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}