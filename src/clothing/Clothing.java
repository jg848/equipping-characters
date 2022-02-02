package clothing;

/**
 * Interface for different types of {@link Clothing}. Contains operations that
 * all types of {@link Clothing} should support.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface Clothing extends Comparable<Clothing> {

  /**
   * Method used to get the power of the {@link Clothing}.
   * 
   * @return an integer which represents the power of the {@link Clothing}.
   */
  public int getPower();

  /**
   * Method used to get the {@link Mode} of the {@link Clothing}.
   * 
   * @return type of {@link Mode} which is either ATTACK or DEFENSE.
   */
  public Mode getMode();

  /**
   * Method used to get the maximum number of times a {@link Clothing} can be
   * used.
   * 
   * @return an integer which represents the maximum number of times a
   *         {@link Clothing} can be used. -1 if it can be used unlimited number
   *         of times.
   */
  public int getMaxUsage();

  /**
   * Method used to check if a {@link Clothing} is cursed or not.
   * 
   * @return true if {@link Clothing} is cursed, false if not.
   */
  public boolean isCursed();

  /**
   * Method used to check if a {@link Clothing} is worn out.
   * 
   * @return true if {@link Clothing} is used more than the maximum number of
   *         times it can be used, false if not.
   */
  public boolean isWornOut();

  /**
   * Method used to equip a {@link Clothing} to a {@link Character}.
   * 
   * @param character which is the {@link Character} to equip the {@link Clothing}
   *                  to.
   * @return boolean true if the {@link Clothing} is equipped, false if not.
   */
  public boolean equipToCharacter(character.Character character);

  /**
   * Method used to count the number of times a {@link Clothing} is used. Will set
   * wornOut to true if the clothing is used more than the maximum number of times
   * it can be used.
   */
  public void useClothing();

  /**
   * Method used to get the name of the {@link Clothing}.
   * 
   * @return string which represents the name of the {@link Clothing}.
   */
  public String getName();

  /**
   * Method used to get the description of the {@link Clothing}.
   * 
   * @return string which represents the description of the {@link Clothing}.
   */
  public String getDescription();
}
