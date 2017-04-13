package gui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import world.Challenge;
import world.Player;
import world.World;

/**
 *
 * @author lucas.burdell
 */
public abstract class ChallengeController {
    
    
    private ChallengeCallback onChallengeFinish;
    private String challengeInformation;
    private world.Player player;
    private World world;


    /**
     * @return the callable
     */
    public ChallengeCallback getOnChallengeFinish() {
        return onChallengeFinish;
    }
    
    public abstract void setupListeners(Scene scene);
    
    public abstract void teardownListeners(Scene scene);

    /**
     * @param callable the callable to set
     */
    public void setOnChallengeFinish(ChallengeCallback callable) {
        this.onChallengeFinish = callable;
    }

    /**
     * This method will be called after the Challenge object is loaded into the controller.
     */
    public abstract void onChallengeLoaded();

    public void finishChallenge(ChallengeStatus status) {
        this.onChallengeFinish.challengeCompleted(status);
    }

    /**
     * @return the challengeInformation
     */
    public String getChallengeInformation() {
        return challengeInformation;
    }

    /**
     * @param challengeInformation the challengeInformation to set
     */
    public void setChallengeInformation(String challengeInformation) {
        this.challengeInformation = challengeInformation;
    }


    public world.Player getPlayer() {
        return player;
    }

    public void setPlayer(world.Player player) {
        this.player = player;
    }

    /**
     * @return the world
     */
    public World getWorld() {
        return world;
    }

    /**
     * @param world the world to set
     */
    public void setWorld(World world) {
        this.world = world;
        this.setPlayer(world.getPlayer());
    }
}
