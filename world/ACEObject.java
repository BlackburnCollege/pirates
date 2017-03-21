package world;

/**
 * Created by lucas.burdell on 3/20/2017.
 */
public abstract class ACEObject {

    private static int objectCount = 0;
    private final int ID;

    public ACEObject() {
        this.ID = objectCount;
        objectCount++;
    }

    public int getID() {
        return ID;
    }
}
