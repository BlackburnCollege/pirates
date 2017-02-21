package world;

/**
 *
 * @author lucas.burdell
 */
public class Event {
    private String music;
    private String[] sounds;
    private Choice[] choices;
    private String picture;
    
    public Event(Choice[] choices) {
        this(null, null, choices, null);
    }
    
    public Event(String music, Choice[] choices) {
        this(music, null, choices, null);
    }
    
    public Event(String music, String[] sounds, Choice[] choices) {
        this(music, sounds, choices, null);
    }
    
    public Event(String music, String[] sounds, Choice[] choices, String picture) {
        this.music = music;
        this.sounds = sounds;
        this.choices = choices;
        this.picture = picture;
    }

    /**
     * @return the music
     */
    public String getMusic() {
        return music;
    }

    /**
     * @return the sounds
     */
    public String[] getSounds() {
        return sounds;
    }

    /**
     * @return the choices
     */
    public Choice[] getChoices() {
        return choices;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }
    
    
    
}
