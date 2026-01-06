void main() {
    try (Scanner sc = new Scanner(System.in)) {
        PdfCompressorFacade pcf = new PdfCompressorFacade("config.properties");

        boolean running = true;
        while (running) {
            MenuChoice.printMenu();
            IO.print("Ange val: ");

            try {
                MenuChoice choice = MenuChoice.from(sc.nextLine().trim());

                running = choice.execute(sc, pcf);
            } catch (Exception e) {
                IO.println(e.getMessage());
            }
        }
    } catch (IOException e) {
        IO.println("Fel vid filhantering: " + e.getMessage());
    }
}