package clothing;

/**
 * Abstract class which implements the {@link Clothing} interface. Represents
 * the common attributes of different types of {@link Clothing}.
 * 
 * @author Jaswin Gumpella
 *
 */
public abstract class ClothingImpl implements Clothing {

  protected final String clothingName;
  protected final String clothingDescription;
  protected final Mode clothingMode;
  protected int clothingPower;
  protected final boolean isCursed;
  protected final int maxUsage;
  protected boolean isWornOut;
  protected int numberOfTimesUsed;

  /**
   * Constructor for the class which constructs a {@link Clothing} by taking input
   * of the name, description, power, if it is a cursed clothing or not and the
   * maximum number of times the clothing can be used.
   */
  protected ClothingImpl(String name, String description, Mode mode, int power, boolean cursed,
      int maxUsage) {
    if (null != name && !name.isBlank()) {
      this.clothingName = name;
    } else {
      throw new IllegalArgumentException("Name of the clothing cannot be empty.");
    }

    if (null != description && !description.isBlank()) {
      this.clothingDescription = description;
    } else {
      throw new IllegalArgumentException("Description of the clothing cannot be empty.");
    }

    if (null != mode && (mode.equals(Mode.ATTACK) || mode.equals(Mode.DEFENSE))) {
      this.clothingMode = mode;
    } else {
      throw new IllegalArgumentException("Mode of the clothing is invalid.");
    }

    if (power >= 0) {
      this.clothingPower = power;
    } else {
      throw new IllegalArgumentException("Power of the clothing is invalid.");
    }

    this.isCursed = cursed;

    if (maxUsage >= -1 && maxUsage != 0) {
      this.maxUsage = maxUsage;
    } else {
      throw new IllegalArgumentException(
          "Maximum usage of the clothing cannot be 0 or less than -1.");
    }

    this.isWornOut = false;
    this.numberOfTimesUsed = 0;

  }

  @Override
  public int getPower() {
    return this.clothingPower;
  }

  @Override
  public Mode getMode() {
    return this.clothingMode;
  }

  @Override
  public int getMaxUsage() {
    return this.maxUsage;
  }

  @Override
  public boolean isCursed() {
    return this.isCursed;
  }

  @Override
  public boolean isWornOut() {
    return this.isWornOut;
  }

  @Override
  public void useClothing() {
    this.numberOfTimesUsed++;
    if (this.maxUsage != -1 && (this.maxUsage - this.numberOfTimesUsed) <= 0) {
      this.isWornOut = true;
    }
  }

  @Override
  public String getName() {
    return this.clothingName;
  }

  @Override
  public String getDescription() {
    return this.clothingDescription;
  }

  /**
   * Method used to determine if a clothing has a higher attack power than this.
   * 
   * @param clothing which is the clothing to be compared to with this.
   * @return an integer representing if the clothing is less than, greater than or
   *         equal to.
   */
  private int compareToAttack(Clothing clothing) {
    if (null != clothing) {
      if (this instanceof HeadGear) {
        return -1;
      } else {
        if (this.getMode().equals(clothing.getMode())) {
          if (this.getPower() > clothing.getPower()) {
            return 1;
          } else {
            return -1;
          }
        } else {
          if (this.getMode().equals(Mode.ATTACK)) {
            return 1;
          } else {
            return -1;
          }
        }
      }
    }
    return 1;
  }

  /**
   * Method used to compare this with {@link HeadGear}.
   * 
   * @param clothing which is the clothing compared to.
   * @return an integer representing if the clothing is less than, greater than or
   *         equal to.
   */
  protected int compareToHeadGear(Clothing clothing) {
    return 1;
  }

  /**
   * Method used to compare this with {@link Footwear}.
   * 
   * @param clothing which is the clothing compared to.
   * @return {@link ClothingImpl#compareToAttack(Clothing)}.
   */
  protected int compareToFootwear(Clothing clothing) {
    return compareToAttack(clothing);
  }

  /**
   * Method used to compare this with {@link HandGear}.
   * 
   * @param clothing which is the clothing compared to.
   * @return {@link ClothingImpl#compareToAttack(Clothing)}.
   */
  protected int compareToHandGear(Clothing clothing) {

    return compareToAttack(clothing);

  }

  /**
   * Method used to compare this with {@link Jewelry}.
   * 
   * @param clothing which is the clothing compared to.
   * @return {@link ClothingImpl#compareToAttack(Clothing)}.
   */
  protected int compareToJewelry(Clothing clothing) {

    return compareToAttack(clothing);

  }

  /**
   * Method used to check if this is equal to {@link HeadGear}.
   * 
   * @param other which is the {@link HeadGear}.
   * @return true if equal, false if not.
   */
  protected boolean equalsHeadGear(HeadGear other) {
    return false;
  }

  /**
   * Method used to check if this is equal to {@link Footwear}.
   * 
   * @param other which is the {@link Footwear}.
   * @return true if equal, false if not.
   */
  protected boolean equalsFootwear(Footwear other) {
    return false;
  }

  /**
   * Method used to check if this is equal to {@link HandGear}.
   * 
   * @param other which is the {@link HandGear}.
   * @return true if equal, false if not.
   */
  protected boolean equalsHandGear(HandGear other) {
    return false;
  }

  /**
   * Method used to check if this is equal to {@link Jewelry}.
   * 
   * @param other which is the {@link Jewelry}.
   * @return true if equal, false if not.
   */
  protected boolean equalsJewelry(Jewelry other) {
    return false;
  }

}
