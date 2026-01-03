public record GhostscriptCommand(String inputFile, String outputFile, CompressionQuality quality) {
    //this.gsPath = gsPath;

    public String[] toCommandArray() {
        String gsPath = "gswin64c";
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
