import java.util.Scanner;

public enum MenuChoice {

    CONFIG("1", "Använd värdena i config.properties-filen") {
        @Override
        boolean execute(Scanner sc, PdfCompressorFacade pcf)
                throws Exception {
            IO.println("Använder config.properties...");
            pcf.compress();
            return true;
        }
    },
    FILES("2", "Ange egen in och ut-fil") {
        @Override
        boolean execute(Scanner sc, PdfCompressorFacade pcf)
                throws Exception {
            Files files = readFiles(sc);
            IO.println("Komprimerar filen...");
            pcf.compress(files.input, files.output);
            return true;
        }
    },
    QUALITY("3", "Ange egen kvalitet + Ange egen in och ut-fil") {
        @Override
        boolean execute(Scanner sc, PdfCompressorFacade pcf)
                throws Exception {
            Files files = readFiles(sc);
            CompressionQuality quality = readQuality(sc);
            IO.println(
                    "Komprimerar filen med kvalitet " + quality + "..."
            );
            pcf.compress(files.input, files.output, quality);
            return true;
        }
    },
    EXIT("4", "Avsluta") {
        @Override
        boolean execute(Scanner sc, PdfCompressorFacade pcf) {
            IO.println("Avslutar...");
            return false;
        }
    };

    abstract boolean execute(Scanner sc, PdfCompressorFacade pcf) throws Exception;

    private final String key;
    private final String description;

    MenuChoice(String key, String description) {
        this.key = key;
        this.description = description;
    }


    public static MenuChoice from(String input) {
        for (MenuChoice c : values()) {
            if (c.key.equals(input)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Ogiltigt menyval");
    }

    public static void printMenu() {
        IO.println("---------------------------------------------------");
        IO.println("Komprimera pdf-fil:");
        for (MenuChoice c : values()) {
            IO.println(c.key + ". " + c.description);
        }
        IO.println();
    }

    private static Files readFiles(Scanner sc) {
        return new Files(
                read(sc, "Ange input-fil: "),
                read(sc, "Ange output-fil: ")
        );
    }

    private static CompressionQuality readQuality(Scanner sc) {
        IO.println("Ange kvalitet:");
        for (CompressionQuality q : CompressionQuality.values()) {
            IO.println(q);
        }
        return CompressionQuality.valueOf(
                read(sc, "").toUpperCase()
        );
    }

    private static String read(Scanner sc, String prompt) {
        IO.print(prompt);
        return sc.nextLine().trim();
    }

    private record Files(String input, String output) {}
}