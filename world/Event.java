package world;

/**
 *
 * @author lucas.burdell
 */
public class Event {

    private String music;
    private String[] sounds;
    private Choice[] choices = new Choice[0];
    private String picture;
    private String text;
    

    //public Event(String music, String[] sounds, Choice[] choices, String picture, String text) {
    //public Event(String text, Choice[] choices) {
    public Event(String text, Choice[] choices) {
        this.text = text;
        this.choices = choices;
    }
    
    public Event(String text) {
        this.text = text;
    }

    public Event(String text, Choice[] choices, String picture, String music, String[] sounds) {
        this.text = text;
        this.choices = choices;
        this.picture = picture;
        this.music = music;
        this.sounds = sounds;
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

    /**
     * @param music the music to set
     */
    public void setMusic(String music) {
        this.music = music;
    }

    /**
     * @param sounds the sounds to set
     */
    public void setSounds(String[] sounds) {
        this.setSounds(sounds);
    }

    /**
     * @param choices the choices to set
     */
    
    public void addChoice(String text, Action action){
        Choice[] temp = new Choice[this.choices.length + 1];
        System.arraycopy(this.choices, 0, temp, 0, choices.length);
        temp[temp.length - 1] = new Choice(text, action);
        this.choices = temp;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

}
