package character;

import clothing.Clothing;
import clothing.Mode;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class of the {@link Character} interface. Represents the
 * attributes of a character and the operations which a character can perform.
 * 
 * @author Jaswin Gumpella
 *
 */
public class CharacterImpl implements Character {

  private final String characterName;
  private final String characterDescription;
  private int hitpoints;
  private final int basicAttackPower;
  private final int basicDefensePower;
  private int currentAttackPower;
  private int currentDefensePower;
  private List<Clothing> characterHeadGear;
  private List<Clothing> characterFootwear;
  private List<Clothing> characterHandGear;
  private List<Clothing> characterJewelry;
  private List<Clothing> allClothings;
  private static final int MAX_HEADGEAR = 1;
  private static final int MAX_FOOTWEAR = 2;
  private static final int MAX_HANDGEAR = 10;

  /**
   * Constructor for the implementation class of {@link Character}. Takes input of
   * the name, description, basic attack power and basic defense power to
   * initialize the attributes of the class.
   */
  public CharacterImpl(String name, String description, int attackPower, int defensePower) {
    if (null != name && !name.isBlank()) {
      this.characterName = name;
    } else {
      throw new IllegalArgumentException("Name of the character cannot be blank.");
    }

    if (null != description && !description.isBlank()) {
      this.characterDescription = description;
    } else {
      throw new IllegalArgumentException("Description of the character cannot be blank.");
    }

    if (attackPower > 0) {
      this.basicAttackPower = attackPower;
      this.currentAttackPower = this.basicAttackPower;
    } else {
      throw new IllegalArgumentException("Attack power of the character cannot be negative or 0.");
    }

    if (defensePower > 0) {
      this.basicDefensePower = defensePower;
      this.currentDefensePower = this.basicDefensePower;
    } else {
      throw new IllegalArgumentException("Defense power of the character cannot be negative or 0.");
    }

    this.hitpoints = this.basicAttackPower + this.basicDefensePower;
    characterHeadGear = new ArrayList<>();
    characterFootwear = new ArrayList<>();
    characterHandGear = new ArrayList<>();
    characterJewelry = new ArrayList<>();
    allClothings = new ArrayList<>();
  }

  @Override
  public boolean equipClothing(Clothing clothing) {
    if (null == clothing) {
      throw new IllegalArgumentException("Invalid clothing.");
    }
    boolean added = false;

    added = clothing.equipToCharacter(this);

    return added;
  }

  @Override
  public void reduceHitPoints(int damage) {
    if (damage > this.currentDefensePower) {
      this.hitpoints -= (damage - this.currentDefensePower);
      this.currentDefensePower = 0;
    } else {
      this.currentDefensePower -= damage;
    }
    for (int i = 0; i < this.allClothings.size(); i++) {
      if (this.allClothings.get(i).getMode().equals(Mode.DEFENSE)) {
        this.allClothings.get(i).useClothing();
        if (this.allClothings.get(i).isWornOut()) {
          this.currentDefensePower -= (2 * this.allClothings.get(i).getPower());
          if (this.currentDefensePower < 0) {
            this.currentDefensePower = 0;
          }
        }
      }
    }
  }

  @Override
  public int getHitPoints() {
    return this.hitpoints;
  }

  @Override
  public int getCurrentAttackPower() {
    return this.currentAttackPower;
  }

  @Override
  public int getCurrentDefensePower() {
    return this.currentDefensePower;
  }

  /**
   * Helper method to modify the current attack power and current defense power of
   * the {@link Character}.
   * 
   * @param clothing which represents a {@link Clothing} which can temporarily add
   *                 or subtract the attack power or defense strength of the
   *                 {@link Character}.
   */
  private void modifyPower(Clothing clothing) {
    if (null != clothing) {
      if (!clothing.isCursed() && !clothing.isWornOut()) {
        if (clothing.getMode().equals(Mode.ATTACK)) {
          this.currentAttackPower += clothing.getPower();
        } else if (clothing.getMode().equals(Mode.DEFENSE)) {
          this.currentDefensePower += clothing.getPower();
        }
      } else if (clothing.isCursed() || clothing.isWornOut()) {
        if (clothing.getMode().equals(Mode.ATTACK)) {
          this.currentAttackPower -= clothing.getPower();
        } else if (clothing.getMode().equals(Mode.DEFENSE)) {
          this.currentDefensePower -= clothing.getPower();
        }
      }
      this.hitpoints = this.currentAttackPower + this.currentDefensePower;
    }
  }

  @Override
  public boolean addToHeadGearList(Clothing headGear) {
    if (null != headGear && this.characterHeadGear.size() < MAX_HEADGEAR) {
      this.characterHeadGear.add(headGear);
      this.allClothings.add(headGear);
      modifyPower(headGear);
      return true;
    }
    return false;
  }

  @Override
  public boolean addToFootwearList(Clothing footwear) {
    if (null != footwear && this.characterFootwear.size() < MAX_FOOTWEAR) {
      this.characterFootwear.add(footwear);
      this.allClothings.add(footwear);
      modifyPower(footwear);
      return true;
    }
    return false;
  }

  @Override
  public boolean addToHandGearList(Clothing handGear) {
    if (null != handGear && this.characterHandGear.size() < MAX_HANDGEAR) {
      this.characterHandGear.add(handGear);
      this.allClothings.add(handGear);
      modifyPower(handGear);
      return true;
    }
    return false;
  }

  @Override
  public boolean addToJewelryList(Clothing jewelry) {
    if (null != jewelry) {
      this.characterJewelry.add(jewelry);
      this.allClothings.add(jewelry);
      modifyPower(jewelry);
      return true;
    }
    return false;
  }

  @Override
  public void attack() {
    if (null != this.allClothings) {
      for (int i = 0; i < this.allClothings.size(); i++) {
        if (this.allClothings.get(i).getMode().equals(Mode.ATTACK)) {
          this.allClothings.get(i).useClothing();
          if (this.allClothings.get(i).isWornOut()) {
            this.currentAttackPower -= (2 * this.allClothings.get(i).getPower());
            if (this.currentAttackPower < 0) {
              this.currentAttackPower = this.basicAttackPower;
            }
          }
        }
      }
    }
  }

  @Override
  public String getName() {
    return this.characterName;
  }

  @Override
  public String replaceClothing(Clothing clothing) {
    StringBuilder replaced = new StringBuilder();
    if (null == clothing) {
      throw new IllegalArgumentException("Clothing is invalid.");
    }
    for (int i = 0; i < allClothings.size(); i++) {
      if (clothing.compareTo(allClothings.get(i)) > 0) {
        Clothing replacedClothing = allClothings.get(i);
        discardClothing(i);
        this.equipClothing(clothing);
        replaced.append(replacedClothing.toString());
        return replaced.toString();
      }
    }
    return replaced.toString();
  }

  /**
   * Helper method to discard a clothing and reduce the current attack, defense
   * power and hit points accordingly.
   * 
   * @param i which is the index of the clothing in the clothing list.
   */
  private void discardClothing(int index) {
    if (!allClothings.get(index).isCursed() && !allClothings.get(index).isWornOut()) {
      if (allClothings.get(index).getMode().equals(Mode.ATTACK)) {
        this.currentAttackPower -= allClothings.get(index).getPower();
      } else if (allClothings.get(index).getMode().equals(Mode.DEFENSE)) {
        this.currentDefensePower -= allClothings.get(index).getPower();
      }
    } else if (allClothings.get(index).isCursed() || allClothings.get(index).isWornOut()) {
      if (allClothings.get(index).getMode().equals(Mode.ATTACK)) {
        this.currentAttackPower += allClothings.get(index).getPower();
      } else if (allClothings.get(index).getMode().equals(Mode.DEFENSE)) {
        this.currentDefensePower += allClothings.get(index).getPower();
      }
    }
    this.hitpoints = this.currentAttackPower + this.currentDefensePower;
    if (characterHeadGear.contains(allClothings.get(index))) {
      characterHeadGear.remove(allClothings.get(index));
    } else if (characterFootwear.contains(allClothings.get(index))) {
      characterFootwear.remove(allClothings.get(index));
    } else if (characterHandGear.contains(allClothings.get(index))) {
      characterHandGear.remove(allClothings.get(index));
    } else if (characterJewelry.contains(allClothings.get(index))) {
      characterJewelry.remove(allClothings.get(index));
    }
    allClothings.remove(index);
  }

  @Override
  public void discardAllClothing() {
    characterHeadGear = new ArrayList<>();
    characterFootwear = new ArrayList<>();
    characterHandGear = new ArrayList<>();
    characterJewelry = new ArrayList<>();
    allClothings = new ArrayList<>();
    this.hitpoints = this.basicAttackPower + this.basicDefensePower;
    this.currentAttackPower = this.basicAttackPower;
    this.currentDefensePower = this.basicDefensePower;
  }

  /**
   * Method used to get a string containing all the details of a {@link Character}
   * including the details of the {@link Clothing} equipped.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Character [").append("\n");
    if (characterName != null) {
      builder.append("characterName=");
      builder.append(characterName);
      builder.append(", ");
    }
    if (characterDescription != null) {
      builder.append("characterDescription=");
      builder.append(characterDescription);
      builder.append(", ");
    }
    builder.append("hitpoints=");
    builder.append(hitpoints);
    builder.append(", currentAttackPower=");
    builder.append(currentAttackPower);
    builder.append(", currentDefensePower=");
    builder.append(currentDefensePower);
    builder.append(", ");
    if (characterHeadGear != null && !characterHeadGear.isEmpty()) {
      for (int i = 0; i < characterHeadGear.size(); i++) {
        builder.append(characterHeadGear.get(i).getName()).append(" of ")
            .append(characterHeadGear.get(i).getDescription());
      }
      builder.append(", ");
    }
    if (characterFootwear != null && !characterFootwear.isEmpty()) {
      for (int i = 0; i < characterFootwear.size(); i++) {
        if (i == 0) {
          builder.append(characterFootwear.get(i).getName()).append(" of ")
              .append(characterFootwear.get(i).getDescription());
        } else {
          if (i == characterFootwear.size() - 1) {
            builder.append(" and ").append(characterFootwear.get(i).getDescription());
          }
        }
      }
      builder.append(", ");
    }
    if (characterHandGear != null && !characterHandGear.isEmpty()) {
      for (int i = 0; i < characterHandGear.size(); i++) {
        if (i == 0) {
          builder.append(characterHandGear.get(i).getName()).append(" of ")
              .append(characterHandGear.get(i).getDescription());
        } else {
          if (i < characterHandGear.size() - 1) {
            builder.append(", ").append(characterHandGear.get(i).getDescription());
          }
          if (i == characterHandGear.size() - 1) {
            builder.append(" and ").append(characterHandGear.get(i).getDescription());
          }
        }
      }
      builder.append(", ");
    }
    if (characterJewelry != null && !characterJewelry.isEmpty()) {
      for (int i = 0; i < characterJewelry.size(); i++) {
        if (i == 0) {
          builder.append(characterJewelry.get(i).getName()).append(" of ")
              .append(characterJewelry.get(i).getDescription());
        } else {
          if (i < characterJewelry.size() - 1) {
            builder.append(", ").append(characterJewelry.get(i).getDescription());
          }
          if (i == characterJewelry.size() - 1) {
            builder.append(" and ").append(characterJewelry.get(i).getDescription());
          }
        }
      }
    }
    builder.append("\n").append("]");
    return builder.toString();
  }

}
