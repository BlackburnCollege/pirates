package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas.burdell
 */
public class EntitySQLLoader {

    private final SQLDatabaseManager manager
            = new SQLDatabaseManager("piratestest", false);

    private final Connection connection = manager.getConnection();

    private String name;
    private int health;
    private double meleeModifier;
    private double rangedModifier;
    private double verbalModifier;
    private boolean insultImmune;

    public EntitySQLLoader(String name) {
        try {
            PreparedStatement statement
                    = connection.prepareStatement(""
                            + "SELECT * FROM entitydata WHERE ENTITY_NAME=?");
            statement.setString(0, name);
            ResultSet set = statement.executeQuery();

            if (set.isBeforeFirst()) {
                set.next();
                this.name = set.getString("ENTITY_NAME");
                this.health = set.getInt("HEALTH");
                this.meleeModifier = set.getDouble("MELEE_MODIFIER");
                this.rangedModifier = set.getDouble("RANGED_MODIFIER");
                this.verbalModifier = set.getDouble("VERBAL_MODIFIER");
                this.insultImmune = set.getBoolean("INSULT_IMMUNITY");
            } else {
                this.name = name;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void saveToDatabase() {
        try {
            PreparedStatement statement
                    = connection.prepareStatement(""
                            + "SELECT * FROM entitydata WHERE ENTITY_NAME=?");
            statement.setString(0, name);
            ResultSet set = statement.executeQuery();
            
            if (!set.isBeforeFirst()) {
                // if nothing in database,
                // use insert
                PreparedStatement insert = this.connection.prepareStatement(
                        "INSERT INTO entitydata(ENTITY_NAME, HEALTH, "
                        + "MELEE_MODIFIER, RANGED_MODIFIER, "
                        + "VERBAL_MODIFIER, INSULT_IMMUNITY) VALUES "
                        + "(?,?,?,?,?,?)");
                insert.setString(0, this.name);
                insert.setInt(1, this.health);
                insert.setDouble(2, this.meleeModifier);
                insert.setDouble(3, this.rangedModifier);
                insert.setDouble(4, this.verbalModifier);
                insert.setBoolean(5, this.insultImmune);
                insert.execute();
            } else {
                // use update
                PreparedStatement update = this.connection.prepareStatement(
                        "UPDATE entitydata SET HEALTH=?, MELEE_MODIFIER=?, "
                        + "RANGED_MODIFIER=?, VERBAL_MODIFIER=?, "
                        + "INSULT_IMMUNITY=? "
                        + "WHERE ENTITY_NAME=?");
                update.setInt(0, this.health);
                update.setDouble(1, this.meleeModifier);
                update.setDouble(2, this.rangedModifier);
                update.setDouble(3, this.verbalModifier);
                update.setBoolean(4, this.insultImmune);
                update.setString(5, this.name);
                update.execute();

            }
        } catch (SQLException ex) {
            System.err.println("Failed to write " + this.name + " to database");
            ex.printStackTrace();
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return the meleeModifier
     */
    public double getMeleeModifier() {
        return meleeModifier;
    }

    /**
     * @return the rangedModifier
     */
    public double getRangedModifier() {
        return rangedModifier;
    }

    /**
     * @return the verbalModifier
     */
    public double getVerbalModifier() {
        return verbalModifier;
    }

    /**
     * @return the insultImmunity
     */
    public boolean isInsultImmune() {
        return insultImmune;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @param meleeModifier the meleeModifier to set
     */
    public void setMeleeModifier(double meleeModifier) {
        this.meleeModifier = meleeModifier;
    }

    /**
     * @param rangedModifier the rangedModifier to set
     */
    public void setRangedModifier(double rangedModifier) {
        this.rangedModifier = rangedModifier;
    }

    /**
     * @param verbalModifier the verbalModifier to set
     */
    public void setVerbalModifier(double verbalModifier) {
        this.verbalModifier = verbalModifier;
    }

    /**
     * @param insultImmune the insultImmune to set
     */
    public void setInsultImmune(boolean insultImmune) {
        this.insultImmune = insultImmune;
    }

}
