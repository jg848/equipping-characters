package clothing;

import character.Character;

import java.util.Objects;

/**
 * HeadGear class which represents a type of {@link Clothing} that is equipped
 * by a {@link Character}. Implements the {@link Clothing} by extending the
 * {@link ClothingImpl}. A {@link Character} can equip a maximum of 1
 * {@link HeadGear} and can be used for DEFENSE only.
 * 
 * @author Jaswin Gumpella
 *
 */
public class HeadGear extends ClothingImpl {

  private static final Mode MODE = Mode.DEFENSE;

  /**
   * Constructor for the class which constructs a {@link HeadGear} by taking input
   * of the name, description, power of the headgear, if it is a cursed clothing
   * or not and the maximum number of times the clothing can be used.
   */
  public HeadGear(String name, String description, int power, boolean cursed, int maxUsage) {
    super(name, description, MODE, power, cursed, maxUsage);
  }

  /**
   * Method used to compare the given clothing with this clothing.
   */
  @Override
  public int compareTo(Clothing clothing) {
    if (null != clothing) {
      if (clothing instanceof ClothingImpl) {
        if (clothing instanceof HeadGear) {
          return this.compareToHeadGear(clothing);
        }
        return ((ClothingImpl) clothing).compareToHeadGear(this);
      } else {
        throw new IllegalStateException();
      }
    }
    return 1;
  }

  @Override
  protected int compareToHeadGear(Clothing clothing) {
    if (null != clothing) {
      if (this.getPower() > clothing.getPower()) {
        return 1;
      } else if (this.getPower() == clothing.getPower()) {
        return 0;
      } else {
        return -1;
      }
    }
    return 1;
  }

  /**
   * Method used to check if a clothing is equal to this.
   */
  @Override
  public boolean equals(Object other) {
    if (null == other) {
      throw new IllegalArgumentException("Cannot compare with null instance.");
    }
    if (this == other) {
      return true;
    }
    if (other instanceof ClothingImpl) {
      ClothingImpl clothing = (ClothingImpl) other;
      return clothing.equalsHeadGear(this);
    }
    return ((ClothingImpl) other).equalsHeadGear(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clothingDescription, clothingMode, clothingName, clothingPower, isCursed,
        isWornOut, maxUsage, numberOfTimesUsed);
  }

  @Override
  protected boolean equalsHeadGear(HeadGear other) {
    return true;
  }

  @Override
  public boolean equipToCharacter(Character character) {
    boolean added = false;
    if (null != character) {
      added = character.addToHeadGearList(this);
    } else {
      throw new IllegalArgumentException("Character is invalid.");
    }
    return added;
  }

  /**
   * Method used to describe the {@link HeadGear}. Prints the name, description,
   * mode, power, if it is cursed and the maximum number of times it can be used.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("HeadGear [");
    if (clothingName != null) {
      builder.append("clothingName=");
      builder.append(clothingName);
      builder.append(", ");
    }
    if (clothingDescription != null) {
      builder.append("clothingDescription=");
      builder.append(clothingDescription);
      builder.append(", ");
    }
    if (clothingMode != null) {
      builder.append("clothingMode=");
      builder.append(clothingMode);
      builder.append(", ");
    }
    builder.append("clothingPower=");
    builder.append(clothingPower);
    builder.append(", isCursed=");
    builder.append(isCursed);
    builder.append(", maxUsage=");
    if (this.maxUsage == -1) {
      builder.append("Unlimited");
    } else {
      builder.append(maxUsage);
    }
    builder.append(", isWornOut=");
    builder.append(isWornOut);
    builder.append("]");
    return builder.toString();
  }

}
