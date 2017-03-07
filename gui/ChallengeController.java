package gui;

import java.util.function.Consumer;
/**
 *
 * @author lucas.burdell
 */
public abstract class ChallengeController {
    
    
    private ChallengeCallback onChallengeFinish;
    private String challengeInformation;
    
    
    
    /**
     * @return the callable
     */
    public ChallengeCallback getOnChallengeFinish() {
        return onChallengeFinish;
    }

    /**
     * @param callable the callable to set
     */
    public void setOnChallengeFinish(ChallengeCallback callable) {
        this.onChallengeFinish = callable;
    }
    
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
    
    
}
