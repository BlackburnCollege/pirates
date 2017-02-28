package gui;

/**
 *
 * @author lucas.burdell
 */
public enum Sound {
    SWORD_SWISH, CLICK;
    
    private static String[] fileNames = new String[]{"snd_sword.mp3", 
        "snd_click.mp3"};
    
    public String getFileName() {
        return fileNames[this.ordinal()];
    }
}
