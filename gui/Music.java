package gui;

/**
 *
 * @author lucas.burdell
 */
public enum Music {
    LIVING_VOYAGE;
    
    private static String[] fileNames = new String[]{"mus_living_voyage.mp3"};
    
    public String getFileName() {
        return fileNames[this.ordinal()];
    }
}
