public class GhostscriptExecutor {
    public void execute(GhostscriptCommand ghostscriptCommand) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(ghostscriptCommand.toCommandArray());
        pb.inheritIO();
        Process process = pb.start();
        int exitCode = process.waitFor();

        if (exitCode != 0) {
            throw new RuntimeException("Ghostscript failed: " + exitCode);
        }
        System.out.println("Compressed Pdf file: " + ghostscriptCommand.inputFile() + " to " + ghostscriptCommand.outputFile());
    }
}
