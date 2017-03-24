package gui;

/**
 *
 * @author lucas.burdell
 */
public enum Sound {
    SWORD_SWISH, CLICK, SAFEDETECTCOMBO, SAFEDIALTURN, SAFELOCKRESET, SAFEUNLOCK;
    
    private static String[] fileNames = new String[]{"snd_sword.mp3", 
        "snd_click.mp3", "snd_safedetectcombo.mp3", "snd_safedialturn.mp3", "snd_safelockreset.mp3",
        "snd_safeunlock.mp3"};
    
    public String getFileName() {
        return fileNames[this.ordinal()];
    }


    // THIS IS A TEST
}
