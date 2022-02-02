import static org.junit.Assert.assertEquals;

import character.Character;
import character.CharacterImpl;
import clothing.Clothing;
import clothing.Footwear;
import clothing.HandGear;
import clothing.HeadGear;
import clothing.Jewelry;
import clothing.Mode;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the implementation class of {@link Character}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class CharacterImplTest {

  Character character;
  Clothing headGear;
  Clothing footwear;
  Clothing footwear2;
  Clothing handGear;
  Clothing handGear2;
  Clothing jewelry;
  Clothing jewelry2;

  /**
   * Method used to setup the test class with required attributes.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    character = new CharacterImpl("Goku", "Martial Artist", 1000, 500);
    headGear = new HeadGear("Potara", "Fusion", 200, false, 1);
    footwear = new Footwear("Boots", "Flight", 400, false, -1);
    footwear2 = new Footwear("Sandals", "Speed", 200, true, 3);
    handGear = new HandGear("Gloves", "Power", Mode.ATTACK, 600, false, 1);
    handGear2 = new HandGear("Sword", "Light", Mode.DEFENSE, 400, false, -1);
    jewelry = new Jewelry("Scouter", "Tracking", Mode.DEFENSE, 200, true, 5);
    jewelry2 = new Jewelry("Chain", "Charm", Mode.ATTACK, 400, true, 5);
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#CharacterImpl(String, String, int, int)}.
   */
  @Test
  public final void testCharacterImpl() {
    character = new CharacterImpl("Goku", "Martial Artist", 1000, 500);
    assertEquals(CharacterImpl.class, character.getClass());
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#CharacterImpl(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCharacterImplInvalidName() {
    new CharacterImpl("", "Martial Artist", 1000, 500);
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#CharacterImpl(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCharacterImplInvalidDescription() {
    new CharacterImpl("Goku", "", 1000, 500);
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#CharacterImpl(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCharacterImplInvalidNameNull() {
    new CharacterImpl(null, "Martial Artist", 1000, 500);
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#CharacterImpl(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCharacterImplInvalidDescriptionNull() {
    new CharacterImpl("Goku", null, 1000, 500);
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#CharacterImpl(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCharacterImplInvalidBasicAttack() {
    new CharacterImpl("Goku", "Martial Artist", -1000, 500);
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#CharacterImpl(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCharacterImplInvalidBasicDefense() {
    new CharacterImpl("Goku", "Martial Artist", 1000, -500);
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#equipClothing(clothing.Clothing)}.
   */
  @Test
  public final void testEquipClothingTrue() {
    assertEquals(true, character.equipClothing(headGear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#equipClothing(clothing.Clothing)}.
   */
  @Test
  public final void testEquipClothingFalse() {
    character.equipClothing(headGear);
    assertEquals(false, character.equipClothing(headGear));
  }

  /**
   * Test method for {@link character.CharacterImpl#reduceHitPoints(int)}.
   */
  @Test
  public final void testReduceHitPoints() {
    character.equipClothing(headGear);
    String expected = "Character [\n"
        + "characterName=Goku, characterDescription=Martial Artist, hitpoints=1700, "
        + "currentAttackPower=1000, currentDefensePower=200, Potara of Fusion, \n" + "]";
    character.reduceHitPoints(100);
    assertEquals(expected, character.toString());
  }

  /**
   * Test method for {@link character.CharacterImpl#reduceHitPoints(int)}.
   */
  @Test
  public final void testReduceHitPointsWearOut() {
    character.equipClothing(headGear);
    character.reduceHitPoints(0);
    String expected = "Character [\n"
        + "characterName=Goku, characterDescription=Martial Artist, hitpoints=1700, "
        + "currentAttackPower=1000, currentDefensePower=0, Potara of Fusion, \n" + "]";
    character.reduceHitPoints(100);
    assertEquals(expected, character.toString());
  }

  /**
   * Test method for {@link character.CharacterImpl#reduceHitPoints(int)}.
   */
  @Test
  public final void testReduceHitPointsZeroDefense() {
    character.equipClothing(headGear);
    String expected = "Character [\n"
        + "characterName=Goku, characterDescription=Martial Artist, hitpoints=1400, "
        + "currentAttackPower=1000, currentDefensePower=0, Potara of Fusion, \n" + "]";
    character.reduceHitPoints(1000);
    assertEquals(expected, character.toString());
  }

  /**
   * Test method for {@link character.CharacterImpl#reduceHitPoints(int)}.
   */
  @Test
  public final void testReduceHitPointsAttackMode() {
    character.equipClothing(handGear);
    String expected = "Character [\n"
        + "characterName=Goku, characterDescription=Martial Artist, hitpoints=2100, "
        + "currentAttackPower=1600, currentDefensePower=400, Gloves of Power, \n" + "]";
    character.reduceHitPoints(100);
    assertEquals(expected, character.toString());
  }

  /**
   * Test method for {@link character.CharacterImpl#reduceHitPoints(int)}.
   */
  @Test
  public final void testReduceHitPointsZeroDefenseAttackMode() {
    character.equipClothing(handGear);
    String expected = "Character [\n"
        + "characterName=Goku, characterDescription=Martial Artist, hitpoints=1600, "
        + "currentAttackPower=1600, currentDefensePower=0, Gloves of Power, \n" + "]";
    character.reduceHitPoints(1000);
    assertEquals(expected, character.toString());
  }

  /**
   * Test method for {@link character.CharacterImpl#getHitPoints()}.
   */
  @Test
  public final void testGetHitPoints() {
    assertEquals(1500, character.getHitPoints());
  }

  /**
   * Test method for {@link character.CharacterImpl#getCurrentAttackPower()}.
   */
  @Test
  public final void testGetCurrentAttackPower() {
    assertEquals(1000, character.getCurrentAttackPower());
  }

  /**
   * Test method for {@link character.CharacterImpl#getCurrentDefensePower()}.
   */
  @Test
  public final void testGetCurrentDefensePower() {
    assertEquals(500, character.getCurrentDefensePower());
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToHeadGearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToHeadGearList() {
    assertEquals(true, character.addToHeadGearList(headGear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToHeadGearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToHeadGearListFalse() {
    character.addToHeadGearList(headGear);
    assertEquals(false, character.addToHeadGearList(headGear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToHeadGearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToHeadGearListNullFalse() {
    assertEquals(false, character.addToHeadGearList(null));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToFootwearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToFootwearList() {
    assertEquals(true, character.addToFootwearList(footwear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToFootwearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToFootwearListMultiple() {
    character.addToFootwearList(footwear);
    assertEquals(true, character.addToFootwearList(footwear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToFootwearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToFootwearListFalse() {
    character.addToFootwearList(footwear);
    character.addToFootwearList(footwear);
    assertEquals(false, character.addToFootwearList(footwear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToFootwearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToFootwearListNullFalse() {
    assertEquals(false, character.addToFootwearList(null));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToHandGearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToHandGearList() {
    assertEquals(true, character.addToHandGearList(handGear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToHandGearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToHandGearListMultiple() {
    character.addToHandGearList(handGear2);
    character.addToHandGearList(handGear2);
    character.addToHandGearList(handGear2);
    assertEquals(true, character.addToHandGearList(handGear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToHandGearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToHandGearListFalse() {
    for (int i = 0; i < 10; i++) {
      character.addToHandGearList(handGear);
    }
    assertEquals(false, character.addToHandGearList(handGear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToHandGearList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToHandGearListNullFalse() {
    assertEquals(false, character.addToHandGearList(null));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToJewelryList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToJewelryList() {
    assertEquals(true, character.addToJewelryList(jewelry));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToJewelryList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToJewelryListMultiple() {
    character.addToJewelryList(jewelry2);
    character.addToJewelryList(jewelry2);
    character.addToJewelryList(jewelry2);
    assertEquals(true, character.addToJewelryList(jewelry));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#addToJewelryList(clothing.Clothing)}.
   */
  @Test
  public final void testAddToJewelryListFalse() {
    assertEquals(false, character.addToJewelryList(null));
  }

  /**
   * Test method for {@link character.CharacterImpl#attack()}.
   */
  @Test
  public final void testAttack() {
    character.equipClothing(headGear);
    character.equipClothing(footwear);
    character.equipClothing(handGear);
    character.attack();
    String expected = "Character [\n"
        + "characterName=Goku, characterDescription=Martial Artist, hitpoints=2700, "
        + "currentAttackPower=800, currentDefensePower=700, "
        + "Potara of Fusion, Boots of Flight, Gloves of Power, \n" + "]";
    assertEquals(expected, character.toString());
  }

  /**
   * Test method for {@link character.CharacterImpl#attack()}.
   */
  @Test
  public final void testAttackNullCharacters() {
    character.attack();
    String expected = "Character [\n"
        + "characterName=Goku, characterDescription=Martial Artist, hitpoints=1500, "
        + "currentAttackPower=1000, currentDefensePower=500, \n" + "]";
    assertEquals(expected, character.toString());
  }

  /**
   * Test method for {@link character.CharacterImpl#getName()}.
   */
  @Test
  public final void testGetName() {
    assertEquals("Goku", character.getName());
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#replaceClothing(clothing.Clothing)}.
   */
  @Test
  public final void testReplaceClothingHeadGear() {
    Clothing headGear2 = new HeadGear("Halo", "Death", 400, false, -1);
    character.equipClothing(headGear);
    String expected = "HeadGear [clothingName=Potara, clothingDescription=Fusion, "
        + "clothingMode=DEFENSE, clothingPower=200, isCursed=false, maxUsage=1, isWornOut=false]";
    assertEquals(expected, character.replaceClothing(headGear2));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#replaceClothing(clothing.Clothing)}.
   */
  @Test
  public final void testReplaceClothingHeadGearFail() {
    Clothing headGear2 = new HeadGear("Halo", "Death", 400, false, -1);
    character.equipClothing(headGear2);
    String expected = "";
    assertEquals(expected, character.replaceClothing(headGear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#replaceClothing(clothing.Clothing)}.
   */
  @Test
  public final void testReplaceClothingFootwear() {
    character.equipClothing(footwear2);
    String expected = "Footwear [clothingName=Sandals, clothingDescription=Speed, "
        + "clothingMode=ATTACK, "
        + "clothingPower=200, isCursed=true, maxUsage=3, isWornOut=false]";
    assertEquals(expected, character.replaceClothing(footwear));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#replaceClothing(clothing.Clothing)}.
   */
  @Test
  public final void testReplaceClothingFootwearFail() {
    character.equipClothing(footwear);
    character.equipClothing(footwear);
    String expected = "";
    assertEquals(expected, character.replaceClothing(footwear2));
  }

  /**
   * Test method for
   * {@link character.CharacterImpl#replaceClothing(clothing.Clothing)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testReplaceClothingInvalidClothing() {
    character.replaceClothing(null);
  }

  /**
   * Test method for {@link character.CharacterImpl#discardAllClothing()}.
   */
  @Test
  public final void testDiscardAllClothing() {
    character.equipClothing(headGear);
    character.equipClothing(handGear);
    String expected = "Character [\n"
        + "characterName=Goku, characterDescription=Martial Artist, hitpoints=2300, "
        + "currentAttackPower=1600, currentDefensePower=700, Potara of Fusion, Gloves of Power, \n"
        + "]";
    assertEquals(expected, character.toString());
    expected = "Character [\n" + "characterName=Goku, characterDescription=Martial Artist, "
        + "hitpoints=1500, currentAttackPower=1000, currentDefensePower=500, \n" + "]";
    character.discardAllClothing();
    assertEquals(expected, character.toString());
  }

  /**
   * Test method for {@link character.CharacterImpl#toString()}.
   */
  @Test
  public final void testToString() {
    character.equipClothing(headGear);
    character.equipClothing(footwear);
    character.equipClothing(footwear2);
    character.equipClothing(handGear);
    character.equipClothing(handGear);
    character.equipClothing(handGear);
    character.equipClothing(handGear2);
    character.equipClothing(handGear2);
    character.equipClothing(jewelry);
    character.equipClothing(jewelry);
    character.equipClothing(jewelry2);
    character.equipClothing(jewelry2);
    String expected = "Character [\n"
        + "characterName=Goku, characterDescription=Martial Artist, hitpoints=3300, "
        + "currentAttackPower=2200, currentDefensePower=1100, "
        + "Potara of Fusion, Boots of Flight and Speed,"
        + " Gloves of Power, Power, Power, Light and Light, "
        + "Scouter of Tracking, Tracking, Charm and Charm\n" + "]";
    assertEquals(expected, character.toString());
  }

}
