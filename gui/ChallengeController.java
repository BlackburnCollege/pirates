package gui;

import java.util.concurrent.Callable;

/**
 *
 * @author lucas.burdell
 */
public abstract class ChallengeController {
    
    private Callable onFinish;
    
    
    
    /**
     * @return the callable
     */
    public Callable getOnFinish() {
        return onFinish;
    }

    /**
     * @param callable the callable to set
     */
    public void setOnFinish(Callable callable) {
        this.onFinish = callable;
    }
    
    
}
