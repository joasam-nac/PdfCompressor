void main() {
    try {
        PdfCompressorFacade pcf = new PdfCompressorFacade("config.properties");

        pcf.compress();
        pcf.compress("input2.pdf", "output2.pdf");
        pcf.compress("input3.pdf", "output3.pdf", CompressionQuality.EBOOK);
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}