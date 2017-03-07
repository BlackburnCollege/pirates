package gui;

import java.util.concurrent.Callable;

/**
 *
 * @author lucas.burdell
 */
public abstract class ChallengeController {
    
    private Callable onChallengeFinish;
    
    
    
    /**
     * @return the callable
     */
    public Callable getOnChallengeFinish() {
        return onChallengeFinish;
    }

    /**
     * @param callable the callable to set
     */
    public void setOnChallengeFinish(Callable callable) {
        this.onChallengeFinish = callable;
    }
    
    
}
