package puzzle;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class defines the PuzzleFish object subclass of PuzzleModel.
 *
 * @author Jessica Cramer
 * @author lucas.burdell
 */
public class PuzzleFlower extends PuzzleModel {

    // configurable constants
    public static final int MAP_WIDTH = 200;
    public static final int MAP_HEIGHT = 200;
    public static final int NUMBER_OF_FLOWER = 10;

    private static final Random RANDOM = new Random();

    private ArrayList<Flower> flowers = new ArrayList<>();
    private int flowerLeft;

    /**
     * Constructor
     */
    public PuzzleFlower() {
        for (int i = 0; i < NUMBER_OF_FLOWER; i++) {
            Flower flower = new Flower();
            flowers.add(flower);
        }
        flowerLeft = flowers.size();
    }

    /**
     * @return the fishes
     */
    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    /**
     * @return the fishLeft
     */
    public int getFlowerLeft() {
        return flowerLeft;
    }

    /**
     * Method for catching a fish
     *
     * @param flower the Flower to catch
     * @return true if fish caught successfully
     */
    public boolean catchFish(Flower flower) {
        if (flower.isCaught()) {
            return false;
        }
        if (!flowers.contains(flower)) {
            return false;
        }
        flower.setCaught(true);
        flowerLeft--;
        if (getFlowerLeft() <= 0) {
            this.setCompleted();
        }
        return true;
    }

    /**
     * This static inner class defines a Flower object to be used by the
     * PuzzleFish object
     */
    public static class Flower {

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
        public Flower() {
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
