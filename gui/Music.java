package gui;

/**
 *
 * @author lucas.burdell
 */
public enum Music {
    LIVING_VOYAGE, THE_BUILDER, CORRUPTION, CRUSADE, LORD_OF_THE_LAND, NOTHING;
    
    private static String[] fileNames = new String[]{"mus_living_voyage.mp3", 
            "mus_the_builder.mp3", "mus_corruption.mp3", "mus_crusade.mp3", "mus_lord_of_the_land.mp3", "nothing.mp3"};
    
    public String getFileName() {
        return fileNames[this.ordinal()];
    }
}
