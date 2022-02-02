package character;

import clothing.Clothing;
import clothing.Footwear;
import clothing.HandGear;
import clothing.HeadGear;
import clothing.Jewelry;
import game.Game;

/**
 * Character interface which represents a character in the {@link Game}.
 * Contains the operations that can be performed by the character.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface Character {

  /**
   * Method used to equip a {@link Clothing} to a {@link Character}.
   * 
   * @param clothing which is the {@link Clothing} to be equipped.
   * @return true if equipped successfully, false if not.
   */
  public boolean equipClothing(Clothing clothing);

  /**
   * Method used to reduce the current defense power and hit points when a
   * {@link Character} is attacked.
   * 
   * @param damage which is the damage the {@link Character} has to take.
   */
  public void reduceHitPoints(int damage);

  /**
   * Method used to get the current hit points of a {@link Character}.
   * 
   * @return an integer representing the hit points of a {@link Character}.
   */
  public int getHitPoints();

  /**
   * Method used to get the current attack power of a {@link Character}.
   * 
   * @return an integer which represents the current attack power of a
   *         {@link Character}.
   */
  public int getCurrentAttackPower();

  /**
   * Method used to get the current defense power of a {@link Character}.
   * 
   * @return an integer which represents the current defense power of a
   *         {@link Character}.
   */
  public int getCurrentDefensePower();

  /**
   * Method used to equip a {@link HeadGear} to a {@link Character}.
   * 
   * @param headGear which is the {@link Clothing}to be equipped.
   * @return true if the {@link HeadGear} is added successfully, false if not.
   */
  public boolean addToHeadGearList(Clothing headGear);

  /**
   * Method used to equip a {@link Footwear} to a {@link Character}.
   * 
   * @param footwear which is the {@link Clothing}to be equipped.
   * @return true if the {@link Footwear} is added successfully, false if not.
   */
  public boolean addToFootwearList(Clothing footwear);

  /**
   * Method used to equip a {@link HandGear} to a {@link Character}.
   * 
   * @param handGear which is the {@link Clothing}to be equipped.
   * @return true if the {@link HandGear} is added successfully, false if not.
   */
  public boolean addToHandGearList(Clothing handGear);

  /**
   * Method used to equip a {@link Jewelry} to a {@link Character}.
   * 
   * @param jewelry which is the {@link Clothing}to be equipped.
   * @return true if the {@link Jewelry} is added successfully, false if not.
   */
  public boolean addToJewelryList(Clothing jewelry);

  /**
   * Method used to increase the count of the ATTACK type {@link Clothing} being
   * used after attack.
   */
  public void attack();

  /**
   * Method used to get the name of the {@link Character}.
   * 
   * @return a string which represents the name of the {@link Character}.
   */
  public String getName();

  /**
   * Method used to replace a {@link Clothing} of the {@link Character} when
   * trying to dress the {@link Character} with a better one if it exists.
   * 
   * @param clothing which is the {@link Clothing} to be compared with the list of
   *                 {@link Clothing} equipped and replace.
   * @return a string which represents the details of the {@link Clothing}
   *         replacing an equipped one. Empty if not replaced.
   */
  public String replaceClothing(Clothing clothing);

  /**
   * Method used to discard all the {@link Clothing} of the {@link Character} and
   * reset the attack power, defense power and hit points of the
   * {@link Character}.
   */
  public void discardAllClothing();
}
