package puzzle;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class defines the PuzzleFish object subclass of PuzzleModel.
 *
 * @author Jessica Cramer
 * @author lucas.burdell
 */
public class PuzzleFish extends PuzzleModel {

    // configurable constants
    public static final int MAP_WIDTH = 200;
    public static final int MAP_HEIGHT = 200;
    public static final int NUMBER_OF_FISH = 10;

    private static final Random RANDOM = new Random();

    private ArrayList<Fish> fishes = new ArrayList<>();
    private int fishLeft;

    /**
     * Constructor
     */
    public PuzzleFish() {
        for (int i = 0; i < NUMBER_OF_FISH; i++) {
            Fish fish = new Fish();
            fishes.add(fish);
        }
        fishLeft = fishes.size();
    }

    /**
     * @return the fishes
     */
    public ArrayList<Fish> getFishes() {
        return fishes;
    }

    /**
     * @return the fishLeft
     */
    public int getFishLeft() {
        return fishLeft;
    }

    /**
     * Method for catching a fish
     *
     * @param fish the Fish to catch
     * @return true if fish caught successfully
     */
    public boolean catchFish(Fish fish) {
        if (fish.isCaught()) {
            return false;
        }
        if (!fishes.contains(fish)) {
            return false;
        }
        fish.setCaught(true);
        fishLeft--;
        if (getFishLeft() <= 0) {
            this.setCompleted();
        }
        return true;
    }

    /**
     * This static inner class defines a Fish object to be used by the
     * PuzzleFish object
     */
    public static class Fish {

        private int xPos = 0;
        private int yPos = 0;
        private int rotation = 0;
        private int xDirection = 0;
        private int yDirection = 0;
        private long thoughtTimeDelta;
        private long lastThoughtTime;

        private boolean caught = false;

        /**
         * Constructor
         */
        public Fish() {
            xPos = RANDOM.nextInt(MAP_WIDTH);
            yPos = RANDOM.nextInt(MAP_HEIGHT);
            xDirection = (RANDOM.nextInt(3) - 1) * (RANDOM.nextInt(1) + 1);
            yDirection = (RANDOM.nextInt(3) - 1) * (RANDOM.nextInt(1) + 1);
            thoughtTimeDelta = RANDOM.nextInt(5) * 1000000000L;
            lastThoughtTime = System.nanoTime();
        }

        //1000000000L
        public void think(long now) {
            if (now - lastThoughtTime >= thoughtTimeDelta) {
                xDirection = (RANDOM.nextInt(3) - 1) * (RANDOM.nextInt(1) + 1);
                yDirection = (RANDOM.nextInt(3) - 1) * (RANDOM.nextInt(1) + 1);
                thoughtTimeDelta = RANDOM.nextInt(5) * 1000000000L;
                lastThoughtTime = now;
            }
            xPos = (xPos + xDirection) % MAP_WIDTH;
            if (xPos <= 0) {
                xPos = (MAP_WIDTH + xDirection) % MAP_WIDTH;
            }
            yPos = (yPos + yDirection) % MAP_HEIGHT;
            if (yPos <= 0) {
                yPos = (MAP_HEIGHT + yDirection) % MAP_HEIGHT;
            }
            rotation = (int) Math.toDegrees(Math.atan2(-yDirection, -xDirection));
        }

        /**
         * @return the xPos
         */
        public int getXPos() {
            return xPos;
        }

        /**
         * @param xPos the xPos to set
         */
        public void setXPos(int xPos) {
            this.xPos = xPos;
        }

        /**
         * @return the yPos
         */
        public int getYPos() {
            return yPos;
        }

        /**
         * @param yPos the yPos to set
         */
        public void setYPos(int yPos) {
            this.yPos = yPos;
        }

        /**
         * @return the caught
         */
        public boolean isCaught() {
            return caught;
        }

        /**
         * @param caught the caught to set
         */
        public void setCaught(boolean caught) {
            this.caught = caught;
        }

        /**
         * @return the rotation
         */
        public int getRotation() {
            return rotation;
        }

        /**
         * @param rotation the rotation to set
         */
        public void setRotation(int rotation) {
            this.rotation = rotation;
        }

        /**
         * @return the xDirection
         */
        public int getxDirection() {
            return xDirection;
        }

        /**
         * @param xDirection the xDirection to set
         */
        public void setxDirection(int xDirection) {
            this.xDirection = xDirection;
        }

        /**
         * @return the yDirection
         */
        public int getyDirection() {
            return yDirection;
        }

        /**
         * @param yDirection the yDirection to set
         */
        public void setyDirection(int yDirection) {
            this.yDirection = yDirection;
        }

        /**
         * @return the nextThoughtTime
         */
        public long getNextThoughtTime() {
            return thoughtTimeDelta;
        }

        /**
         * @param nextThoughtTime the nextThoughtTime to set
         */
        public void setNextThoughtTime(long nextThoughtTime) {
            this.thoughtTimeDelta = nextThoughtTime;
        }
    }
}
