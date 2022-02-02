package game;

import character.Character;
import clothing.Clothing;
import clothing.Footwear;
import clothing.HandGear;
import clothing.HeadGear;
import clothing.Jewelry;
import clothing.Mode;

/**
 * Builder class for the {@link Game} class. Used to build the {@link Game} with
 * the required {@link Character} and {@link Clothing}. The Game requires
 * atleast 2 characters and atleast one of each of the clothing types.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GameBuilder {

  private int numberOfCharacters;
  private int numberOfHeadGear;
  private int numberOfFootwear;
  private int numberOfHandGear;
  private int numberOfJewelry;
  private static final int MIN_CHARACTERS = 2;
  private static final int MIN_HEADGEAR = 1;
  private static final int MIN_FOOTWEAR = 1;
  private static final int MIN_HANDGEAR = 1;
  private static final int MIN_JEWELRY = 1;
  Game game;

  /**
   * Constructor for the builder class to construct the builder.
   */
  public GameBuilder() {
    numberOfCharacters = 0;
    numberOfHeadGear = 0;
    numberOfFootwear = 0;
    numberOfHandGear = 0;
    numberOfJewelry = 0;
    game = new GameImpl();
  }

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
   * @return an instance of {@link GameBuilder} after creating a
   *         {@link Character}.
   */
  public GameBuilder createCharacter(String name, String description, int basicAttackPower,
      int basicDefensePower) {
    if (null == name || name.isBlank()) {
      throw new IllegalArgumentException("Invalid name input for the character.");
    }

    if (null == description || description.isBlank()) {
      throw new IllegalArgumentException("Invalid description input for the character.");
    }

    if (basicAttackPower <= 0 || basicDefensePower <= 0) {
      throw new IllegalArgumentException("Power cannot be negative or 0.");
    }

    if (game.createCharacter(name, description, basicAttackPower, basicDefensePower)) {
      this.numberOfCharacters++;
    }

    return this;
  }

  /**
   * Method used to validate the input given to create a {@link Clothing}.
   * 
   * @param name        which represents the name of the {@link Clothing}.
   * @param description which represents the description of the {@link Clothing}.
   * @param power       which represents the power of the {@link Clothing}.
   * @param maxUse      which represents the maximum number of times a
   *                    {@link Clothing} can be used. -1 if it can be used
   *                    unlimited number of times.
   */
  private void validateClothingInput(String name, String description, int power, int maxUse) {
    if (null == name || name.isBlank()) {
      throw new IllegalArgumentException("Invalid name input for the clothing.");
    }

    if (null == description || description.isBlank()) {
      throw new IllegalArgumentException("Invalid description input for the clothing.");
    }

    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative.");
    }

    if (maxUse == 0 || maxUse < -1) {
      throw new IllegalArgumentException("Invalid maximum usage input.");
    }
  }

  /**
   * Method used to create a {@link HeadGear} in the {@link Game}.
   * 
   * @param name        which represents the name of the {@link Clothing}.
   * @param description which represents the description of the {@link Clothing}.
   * @param power       which represents the power of the {@link Clothing}.
   * @param cursed      which represents if a {@link Clothing} is cursed or not.
   * @param maxUse      which represents the maximum number of times a
   *                    {@link Clothing} can be used. -1 if it can be used
   *                    unlimited number of times.
   * @return an instance of {@link GameBuilder} after creating a {@link Clothing}.
   */
  public GameBuilder createHeadGear(String name, String description, int power, boolean cursed,
      int maxUse) {
    validateClothingInput(name, description, power, maxUse);

    if (game.createHeadGear(name, description, power, cursed, maxUse)) {
      this.numberOfHeadGear++;
    }

    return this;
  }

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
   * @return an instance of {@link GameBuilder} after creating a {@link Clothing}.
   */
  public GameBuilder createFootwear(String name, String description, int power, boolean cursed,
      int maxUse) {
    validateClothingInput(name, description, power, maxUse);

    if (game.createFootwear(name, description, power, cursed, maxUse)) {
      this.numberOfFootwear++;
    }

    return this;
  }

  /**
   * Method used to create a {@link HandGear} in the {@link Game}.
   * 
   * @param name        which represents the name of the {@link Clothing}.
   * @param description which represents the description of the {@link Clothing}.
   * @param mode        which represents the {@link Mode} of the {@link Clothing}.
   * @param power       which represents the power of the {@link Clothing}.
   * @param cursed      which represents if a {@link Clothing} is cursed or not.
   * @param maxUse      which represents the maximum number of times a
   *                    {@link Clothing} can be used. -1 if it can be used
   *                    unlimited number of times.
   * @return an instance of {@link GameBuilder} after creating a {@link Clothing}.
   */
  public GameBuilder createHandGear(String name, String description, Mode mode, int power,
      boolean cursed, int maxUse) {
    validateClothingInput(name, description, power, maxUse);

    if (null == mode) {
      throw new IllegalArgumentException("Invalid mode input.");
    }

    if (game.createHandGear(name, description, mode, power, cursed, maxUse)) {
      this.numberOfHandGear++;
    }

    return this;
  }

  /**
   * Method used to create a {@link Jewelry} in the {@link Game}.
   * 
   * @param name        which represents the name of the {@link Clothing}.
   * @param description which represents the description of the {@link Clothing}.
   * @param mode        which represents the {@link Mode} of the {@link Clothing}.
   * @param power       which represents the power of the {@link Clothing}.
   * @param cursed      which represents if a {@link Clothing} is cursed or not.
   * @param maxUse      which represents the maximum number of times a
   *                    {@link Clothing} can be used. -1 if it can be used
   *                    unlimited number of times.
   * @return an instance of {@link GameBuilder} after creating a {@link Clothing}.
   */
  public GameBuilder createJewelry(String name, String description, Mode mode, int power,
      boolean cursed, int maxUse) {
    validateClothingInput(name, description, power, maxUse);

    if (null == mode) {
      throw new IllegalArgumentException("Invalid mode input.");
    }

    if (game.createJewelry(name, description, mode, power, cursed, maxUse)) {
      this.numberOfJewelry++;
    }

    return this;
  }

  /**
   * Method used to build a {@link Game}. Checks if all the required conditions
   * are met to create a {@link Game}.
   * 
   * @return an instance of {@link Game}.
   */
  public Game build() {
    if ((this.numberOfCharacters >= MIN_CHARACTERS) && (this.numberOfHeadGear >= MIN_HEADGEAR)
        && (this.numberOfFootwear >= MIN_FOOTWEAR) && (this.numberOfHandGear >= MIN_HANDGEAR)
        && (this.numberOfJewelry >= MIN_JEWELRY)) {
      return this.game;
    } else {
      throw new IllegalStateException("Enough number of characters or clothing not created.");
    }
  }

}
