package game;

import character.Character;
import chest.Chest;
import clothing.Clothing;
import clothing.Footwear;
import clothing.HandGear;
import clothing.HeadGear;
import clothing.Jewelry;
import clothing.Mode;

/**
 * {@link Game} interface which contains all the operations that are needed to
 * be performed in a {@link Game}.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface Game {

  /**
   * Method used to create a {@link Character} in the {@link Game}.
   * 
   * @param name              which represents the name of the {@link Character}.
   * @param description       which represents the description of the
   *                          {@link Character}.
   * @param basicAttackPower  which represents the basic attack power of the
   *                          {@link Character}.
   * @param basicDefensePower which represents the basic defense power of the
   *                          {@link Character}.
   * @return true if the {@link Character} has been created, false if not.
   */
  public boolean createCharacter(String name, String description, int basicAttackPower,
      int basicDefensePower);

  /**
   * Method used to create a {@link HeadGear} in the {@link Game}.
   * 
   * @param name        which represents the name of the {@link Clothing}.
   * @param description which represents the descriptiopn of the {@link Clothing}.
   * @param power       which represents the power of the {@link Clothing}.
   * @param cursed      which represents if a {@link Clothing} is cursed or not.
   * @param maxUse      which represents the maximum number of times a
   *                    {@link Clothing} can be used. -1 if it can be used
   *                    unlimited number of times.
   * @return true if the {@link Clothing} has been created successfully, false if
   *         not.
   */
  public boolean createHeadGear(String name, String description, int power, boolean cursed,
      int maxUse);

  /**
   * Method used to create a {@link Footwear} in the {@link Game}.
   * 
   * @param name        which represents the name of the {@link Clothing}.
   * @param description which represents the description of the {@link Clothing}.
   * @param power       which represents the power of the {@link Clothing}.
   * @param cursed      which represents if a {@link Clothing} is cursed or not.
   * @param maxUse      which represents the maximum number of times a
   *                    {@link Clothing} can be used. -1 if it can be used
   *                    unlimited number of times.
   * @return true if the {@link Clothing} has been created successfully, false if
   *         not.
   */
  public boolean createFootwear(String name, String description, int power, boolean cursed,
      int maxUse);

  /**
   * Method used to create a {@link HandGear} in the {@link Game}.
   * 
   * @param name        which represents the name of the {@link Clothing}.
   * @param description which represents the description of the {@link Clothing}.
   * @param power       which represents the power of the {@link Clothing}.
   * @param cursed      which represents if a {@link Clothing} is cursed or not.
   * @param maxUse      which represents the maximum number of times a
   *                    {@link Clothing} can be used. -1 if it can be used
   *                    unlimited number of times.
   * @return true if the {@link Clothing} has been created successfully, false if
   *         not.
   */
  public boolean createHandGear(String name, String description, Mode mode, int power,
      boolean cursed, int maxUse);

  /**
   * Method used to create a {@link Jewelry} in the {@link Game}.
   * 
   * @param name        which represents the name of the {@link Clothing}.
   * @param description which represents the description of the {@link Clothing}.
   * @param power       which represents the power of the {@link Clothing}.
   * @param cursed      which represents if a {@link Clothing} is cursed or not.
   * @param maxUse      which represents the maximum number of times a
   *                    {@link Clothing} can be used. -1 if it can be used
   *                    unlimited number of times.
   * @return true if the {@link Clothing} has been created successfully, false if
   *         not.
   */
  public boolean createJewelry(String name, String description, Mode mode, int power,
      boolean cursed, int maxUse);

  /**
   * Method used to populate a {@link Chest} of {@link Clothing} from which a
   * {@link Character} can dress to go into a battle in the {@link Game}.
   * 
   * @return a string which contains the list of {@link Clothing} in the
   *         {@link Chest}.
   */
  public boolean populateChestOfGears();

  /**
   * Method used to dress the {@link Character} by picking 20 random
   * {@link Clothing} from the {@link Chest} and equip accordingly.
   * 
   * @return a string which contains the details of any discarded {@link Clothing}
   *         and the {@link Clothing} which replaces it.
   */
  public String dressCharacters();

  /**
   * Method used to get the details of all the characters in the {@link Game}.
   * 
   * @return a string which contains all the details of the characters in the
   *         {@link Game}.
   */
  public String printCharacters();

  /**
   * Method used to predict a battle between the given 2 characters after dressing
   * them for battle.
   * 
   * @param character1 which represents a {@link Character} to battle.
   * @param character2 which represents a {@link Character} to battle.
   * @return a string which contains the details of the battle prediction
   *         including the number of rounds each {@link Character} can survive and
   *         the winner of the battle. The prediction can also print a tie in the
   *         battle.
   */
  public String predictBattle(character.Character character1, character.Character character2);

  /**
   * Method used to enable a rematch between the characters by discarding all the
   * {@link Clothing} equipped by a {@link Character}, resetting the attack power,
   * defense power and hit points of the {@link Character} and dressing the
   * characters with a new set of 20 random items from the new {@link Chest}.
   * 
   * @param character1 which represents a {@link Character} to battle.
   * @param character2 which represents a {@link Character} to battle.
   * @return a string which contains the returned information from
   *         {@link Game#dressCharacters()} and
   *         {@link Game#predictBattle(Character, Character)}.
   */
  public String rematch(Character character1, Character character2);

  /**
   * Method used to get a {@link Character} from the list of characters by using
   * the name of the {@link Character}.
   * 
   * @param string which represents the name of the {@link Character}.
   * @return {@link Character} from the list of characters in the {@link Game}.
   */
  public Character getCharacter(String string);

}
