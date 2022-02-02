package clothing;

import character.Character;

import java.util.Objects;

/**
 * HandGear class which represents a type of {@link Clothing} that is equipped
 * by a {@link Character}. Implements the {@link Clothing} by extending the
 * {@link ClothingImpl}. A {@link Character} can equip a maximum of 10
 * {@link HandGear} and can be used for either ATTACK or DEFENSE.
 * 
 * @author Jaswin Gumpella
 *
 */
public class HandGear extends ClothingImpl {

  /**
   * Constructor for the class which constructs a {@link HandGear} by taking input
   * of the name, description, mode of the hand gear, power of the hand gear, if
   * it is a cursed clothing or not and the maximum number of times the clothing
   * can be used.
   */
  public HandGear(String name, String description, Mode mode, int power, boolean cursed,
      int maxUsage) {
    super(name, description, mode, power, cursed, maxUsage);
  }

  /**
   * Method used to compare a given clothing with this clothing.
   */
  @Override
  public int compareTo(Clothing clothing) {
    if (null != clothing) {
      if (clothing instanceof ClothingImpl) {
        if (clothing instanceof HandGear) {
          return this.compareToHandGear(clothing);
        }
        return ((ClothingImpl) clothing).compareToHandGear(this);
      } else {
        throw new IllegalStateException();
      }
    }
    return 1;
  }

  @Override
  protected int compareToHandGear(Clothing clothing) {
    if (null != clothing) {
      if (this.clothingMode.equals(clothing.getMode())) {
        if (this.getPower() > clothing.getPower()) {
          return 1;
        } else if (this.getPower() == clothing.getPower()) {
          return 0;
        } else {
          return -1;
        }
      } else {
        if (this.clothingMode.equals(Mode.ATTACK)) {
          return 1;
        } else {
          return -1;
        }
      }
    }
    return 1;
  }

  /**
   * Method used to check if the given object is equal to this.
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
      return clothing.equalsHandGear(this);
    }
    return ((ClothingImpl) other).equalsHandGear(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clothingDescription, clothingMode, clothingName, clothingPower, isCursed,
        isWornOut, maxUsage, numberOfTimesUsed);
  }

  @Override
  protected boolean equalsHandGear(HandGear other) {
    return true;
  }

  @Override
  public boolean equipToCharacter(Character character) {
    boolean added = false;
    if (null != character) {
      added = character.addToHandGearList(this);
    } else {
      throw new IllegalArgumentException("Character is invalid.");
    }
    return added;
  }

  /**
   * Method used to describe the {@link HandGear}. Prints the name, description,
   * mode, power, if it is cursed and the maximum number of times it can be used.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("HandGear [");
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
