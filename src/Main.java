void main() {
    try (Scanner sc = new Scanner(System.in)) {
        PdfCompressorFacade pcf =
                new PdfCompressorFacade("config.properties");

        boolean running = true;
        while (running) {
            menu();
            IO.print("Ange val: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    IO.println("Använder config.properties...");
                    pcf.compress();
                }
                case "2" -> compressWithFiles(sc, pcf);
                case "3" -> compressWithQuality(sc, pcf);
                case "4" -> {
                    IO.println("Avslutar...");
                    running = false;
                }
                default -> IO.println("Ogiltigt val");
            }
        }
    } catch (IOException e) {
        IO.println("Fel vid filhantering: " + e.getMessage());
    } catch (Exception e) {
        IO.println("Felaktigt värde: " + e.getMessage());
    }
}

private static void compressWithFiles(
        Scanner sc,
        PdfCompressorFacade pcf
) throws Exception {
    String inputFile = read(sc, "Ange input-fil: ");
    String outputFile = read(sc, "Ange output-fil: ");

    IO.println("Komprimerar filen...");
    pcf.compress(inputFile, outputFile);
}

private static void compressWithQuality(
        Scanner sc,
        PdfCompressorFacade pcf
) throws Exception {
    String inputFile = read(sc, "Ange input-fil: ");
    String outputFile = read(sc, "Ange output-fil: ");

    IO.println("Ange kvalitet:");
    for (CompressionQuality q : CompressionQuality.values()) {
        IO.println(q);
    }

    CompressionQuality quality =
            CompressionQuality.valueOf(read(sc, "").toUpperCase());

    IO.println(
            "Komprimerar filen med kvalitet " + quality + "..."
    );
    pcf.compress(inputFile, outputFile, quality);
}

private static String read(Scanner sc, String prompt) {
    IO.print(prompt);
    return sc.nextLine().trim();
}

private static void menu() {
    IO.println("Komprimera pdf-filer");
    IO.println("1. Använd värdena i config.properties-filen");
    IO.println("2. Ange egna in och ut-filer");
    IO.println("3. Ange egen kvalitet + Ange egna in och ut-filer");
    IO.println("4. Avsluta");
    IO.println();
}