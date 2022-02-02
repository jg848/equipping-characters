package game;

import character.Character;
import character.CharacterImpl;
import chest.Chest;
import chest.ChestImpl;
import clothing.Clothing;
import clothing.Footwear;
import clothing.HandGear;
import clothing.HeadGear;
import clothing.Jewelry;
import clothing.Mode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implementation class of the {@link Game} interface. Used to implement the
 * operations defined in the {@link Game} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GameImpl implements Game {

  private List<character.Character> charactersList;
  private List<Clothing> headGearList;
  private List<Clothing> footwearList;
  private List<Clothing> handGearList;
  private List<Clothing> jewelryList;
  private List<Clothing> chestList;
  private Random random;

  /**
   * Constructor for the implementation class of the {@link Game} interface.
   */
  public GameImpl() {
    charactersList = new ArrayList<>();
    headGearList = new ArrayList<>();
    footwearList = new ArrayList<>();
    handGearList = new ArrayList<>();
    jewelryList = new ArrayList<>();
    chestList = new ArrayList<>();
    random = new Random();
  }

  @Override
  public boolean createCharacter(String name, String description, int basicAttackPower,
      int basicDefensePower) {
    boolean create = false;
    if (null == name || name.isBlank()) {
      throw new IllegalArgumentException("Invalid name input for the character.");
    }

    if (null != charactersList && !charactersList.isEmpty()) {
      for (int i = 0; i < charactersList.size(); i++) {
        if (charactersList.get(i).getName().equals(name.trim())) {
          throw new IllegalArgumentException("Character with the same name already exists.");
        }
      }
    }

    if (null == description || description.isBlank()) {
      throw new IllegalArgumentException("Invalid description input for the character.");
    }

    if (basicAttackPower <= 0 || basicDefensePower <= 0) {
      throw new IllegalArgumentException("Power cannot be negative or 0.");
    }

    character.Character character = new CharacterImpl(name, description, basicAttackPower,
        basicDefensePower);
    if (null != charactersList) {
      create = charactersList.add(character);
    }

    return create;
  }

  /**
   * Method used to validate the input to create a {@link Clothing}.
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

  @Override
  public boolean createHeadGear(String name, String description, int power, boolean cursed,
      int maxUse) {
    boolean create = false;

    validateClothingInput(name, description, power, maxUse);

    Clothing headGear = new HeadGear(name, description, power, cursed, maxUse);
    create = headGearList.add(headGear);

    return create;
  }

  @Override
  public boolean createFootwear(String name, String description, int power, boolean cursed,
      int maxUse) {
    boolean create = false;

    validateClothingInput(name, description, power, maxUse);

    Clothing footwear = new Footwear(name, description, power, cursed, maxUse);
    create = footwearList.add(footwear);

    return create;
  }

  @Override
  public boolean createHandGear(String name, String description, Mode mode, int power,
      boolean cursed, int maxUse) {
    boolean create = false;

    validateClothingInput(name, description, power, maxUse);

    if (null == mode || !(mode.equals(Mode.ATTACK) || mode.equals(Mode.DEFENSE))) {
      throw new IllegalArgumentException("Mode of the gear is invalid.");
    }

    Clothing handGear = new HandGear(name, description, mode, power, cursed, maxUse);
    create = handGearList.add(handGear);

    return create;
  }

  @Override
  public boolean createJewelry(String name, String description, Mode mode, int power,
      boolean cursed, int maxUse) {
    boolean create = false;

    validateClothingInput(name, description, power, maxUse);

    if (null == mode || !(mode.equals(Mode.ATTACK) || mode.equals(Mode.DEFENSE))) {
      throw new IllegalArgumentException("Mode of the gear is invalid.");
    }

    Clothing jewelry = new Jewelry(name, description, mode, power, cursed, maxUse);
    create = jewelryList.add(jewelry);

    return create;
  }

  @Override
  public boolean populateChestOfGears() {
    Chest chest = new ChestImpl();
    return chest.populateHeadGear(this.headGearList, this.chestList)
        && chest.populateFootwear(this.footwearList, this.chestList)
        && chest.populateHandGear(this.handGearList, this.chestList)
        && chest.populateJewelry(this.jewelryList, this.chestList);
  }

  @Override
  public String dressCharacters() {
    StringBuilder dressing = new StringBuilder();
    List<Clothing> dresses;
    String replaced = null;
    if (this.charactersList.isEmpty()) {
      throw new IllegalArgumentException("Characters list is invalid.");
    }
    if (this.chestList.isEmpty()) {
      throw new IllegalArgumentException("Chest is not populated.");
    }
    for (int i = 0; i < this.charactersList.size(); i++) {
      dresses = new ArrayList<>();
      for (int j = 0; j < 20; j++) {
        dresses.add(this.chestList.get(random.nextInt(this.chestList.size())));
      }
      for (int x = 0; x < dresses.size(); x++) {
        if (!charactersList.get(i).equipClothing(dresses.get(x))) {
          replaced = charactersList.get(i).replaceClothing(dresses.get(x));
          if (null != replaced && !replaced.isBlank()) {
            dressing.append("\n").append(charactersList.get(i).getName()).append(" discarded \n")
                .append(replaced).append("\nand replaced with\n").append(dresses.get(x).toString());
          }
        }
      }

    }
    return dressing.toString();
  }

  @Override
  public String printCharacters() {
    StringBuilder characters = new StringBuilder();
    if (null != charactersList) {
      for (int i = 0; i < charactersList.size(); i++) {
        characters.append(charactersList.get(i).toString()).append("\n");
      }
    }
    return characters.toString();
  }

  @Override
  public String predictBattle(Character character1, Character character2) {
    if (null == character1 || null == character2) {
      throw new IllegalArgumentException("Invalid character input");
    }
    StringBuilder battle = new StringBuilder();
    battle.append("Prediction starts.").append("\n");

    int numberOfRoundsForCharacter1 = 0;
    int numberOfRoundsForCharacter2 = 0;

    for (numberOfRoundsForCharacter1 = 0; character1
        .getHitPoints() > 0; numberOfRoundsForCharacter1++) {
      character1.reduceHitPoints(character2.getCurrentAttackPower());
      character2.attack();
    }

    for (numberOfRoundsForCharacter2 = 0; character2
        .getHitPoints() > 0; numberOfRoundsForCharacter2++) {
      character2.reduceHitPoints(character1.getCurrentAttackPower());
      character1.attack();
    }

    battle.append("Number of rounds lasted by ").append(character1.getName()).append(": ")
        .append(numberOfRoundsForCharacter1).append("\n");
    battle.append("Number of rounds lasted by ").append(character2.getName()).append(": ")
        .append(numberOfRoundsForCharacter2).append("\n");

    if (numberOfRoundsForCharacter1 > numberOfRoundsForCharacter2) {
      battle.append("Winner: ").append(character1.getName());
    } else if (numberOfRoundsForCharacter2 > numberOfRoundsForCharacter1) {
      battle.append("Winner: ").append(character2.getName());
    } else {
      battle.append("Match Tied.");
    }

    return battle.toString();
  }

  @Override
  public String rematch(Character character1, Character character2) {
    if (null == charactersList || charactersList.isEmpty()) {
      throw new IllegalArgumentException("Characters list is empty.");
    }
    for (int i = 0; i < charactersList.size(); i++) {
      charactersList.get(i).discardAllClothing();
    }
    this.chestList = new ArrayList<>();
    if (null == character1 || null == character2) {
      throw new IllegalArgumentException("Invalid Character input.");
    }
    if (populateChestOfGears()) {
      StringBuilder builder = new StringBuilder();
      builder.append("\n");
      builder.append(dressCharacters());
      builder.append("\n");
      builder.append(predictBattle(character1, character2));
      builder.append("\n");
      return builder.toString();
    }
    return null;
  }

  @Override
  public Character getCharacter(String string) {
    if (null != string && !string.isBlank()) {
      for (int i = 0; i < charactersList.size(); i++) {
        if (charactersList.get(i).getName().equals(string.trim())) {
          return charactersList.get(i);
        }
      }
    } else {
      throw new IllegalArgumentException("Invalid character name.");
    }
    return null;
  }

}
