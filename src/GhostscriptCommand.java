public record GhostscriptCommand(String gsPath, String inputFile, String outputFile, CompressionQuality quality) {

    public String[] toCommandArray() {
        return new String[]{
                gsPath,
                "-sDEVICE=pdfwrite",
                "-dCompatibilityLevel=1.4",
                "-dPDFSETTINGS=" + quality.getSetting(),
                "-dNOPAUSE",
                "-dQUIET",
                "-dBATCH",
                "-sOutputFile=" + outputFile,
                inputFile
        };
    }
}
