package world;

/**
 *
 * @author lucas.burdell
 */
public class Event {

    private gui.Music music;
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

    public Event(String text, Choice[] choices, String picture, gui.Music music, String[] sounds) {
        this.text = text;
        this.choices = choices;
        this.picture = picture;
        this.music = music;
        this.sounds = sounds;
    }

    /**
     * @return the music
     */
    public gui.Music getMusic() {
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
     * @return 
     */
    public Event setMusic(gui.Music music) {
        this.music = music;
        return this;
    }

    /**
     * @param sounds the sounds to set
     * @return 
     */
    public Event setSounds(String[] sounds) {
        this.sounds = sounds;
        return this;
    }

    /**
     * @param choices the choices to set
     */
    public Event addChoice(String text, Action action){
        this.addChoice(new Choice(text, action));
        return this;
    }
    
    public Event addChoice(Choice choice) {
        Choice[] temp = new Choice[this.choices.length + 1];
        System.arraycopy(this.choices, 0, temp, 0, choices.length);
        temp[temp.length - 1] = choice;
        this.choices = temp;
        return this;
    }

    /**
     * @param picture the picture to set
     */
    public Event setPicture(String picture) {
        this.picture = picture;
        return this;
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
    public Event setText(String text) {
        this.text = text;
        return this;
    }

}
