public enum CompressionQuality {
    SCREEN("/screen"),
    EBOOK("/ebook"),
    PRINTER("/printer"),
    PREPRESS("/prepress");

    private final String setting;
    CompressionQuality(String setting) {
        this.setting = setting;
    }

    public String getSetting() {
        return setting;
    }
}
