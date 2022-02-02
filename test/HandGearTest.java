import static org.junit.Assert.assertEquals;

import character.Character;
import character.CharacterImpl;
import clothing.Clothing;
import clothing.Footwear;
import clothing.HandGear;
import clothing.HeadGear;
import clothing.Mode;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link HandGear}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class HandGearTest {

  Clothing footwear;
  Clothing headGear;
  Clothing handGear2;
  Clothing handGear;
  Character character;

  /**
   * Method to setup the test class with required attributes.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    footwear = new Footwear("Boots", "Flight", 400, false, -1);
    handGear = new HandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    handGear2 = new HandGear("Gloves", "Power", Mode.DEFENSE, 600, false, 1);
    headGear = new HeadGear("Potara", "Fusion", 200, false, 1);
    character = new CharacterImpl("Goku", "Martial Artist", 1000, 500);
  }

  /**
   * Test method for {@link clothing.HandGear#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObject() {
    assertEquals(true, handGear.equals(handGear2));
  }

  /**
   * Test method for {@link clothing.HandGear#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObjectFalse() {
    assertEquals(false, handGear.equals(headGear));
  }

  /**
   * Test method for {@link clothing.HandGear#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObjectSelf() {
    assertEquals(true, handGear.equals(handGear));
  }

  /**
   * Test method for {@link clothing.HandGear#equals(java.lang.Object)}.
   */
  @Test(expected = ClassCastException.class)
  public final void testEqualsObjectOther() {
    handGear.equals(character);
  }

  /**
   * Test method for
   * {@link clothing.HandGear#compareToHandGear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToHandGear() {
    assertEquals(-1, handGear2.compareTo(handGear));
  }

  /**
   * Test method for
   * {@link clothing.HandGear#compareToHandGear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToHandGearZero() {
    assertEquals(0, handGear.compareTo(handGear));
  }

  /**
   * Test method for
   * {@link clothing.HandGear#compareToHandGear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToHandGearGreater() {
    assertEquals(1, handGear.compareTo(handGear2));
  }

  /**
   * Test method for {@link clothing.HandGear#equalsHandGear(clothing.HandGear)}.
   */
  @Test
  public final void testEqualsHandGear() {
    assertEquals(true, handGear.equals(handGear2));
  }

  /**
   * Test method for
   * {@link clothing.HandGear#HandGear(String, String, int, boolean, int)}.
   */
  @Test
  public final void testHandGear() {
    handGear = new HandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    assertEquals(HandGear.class, handGear.getClass());
  }

  /**
   * Test method for
   * {@link clothing.HandGear#HandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHandGearInvalidName() {
    new HandGear("", "Kais", Mode.ATTACK, 800, true, 3);
  }

  /**
   * Test method for
   * {@link clothing.HandGear#HandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHandGearInvalidDescription() {
    new HandGear("Sword", "", Mode.ATTACK, 800, true, 3);
  }

  /**
   * Test method for
   * {@link clothing.HandGear#HandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHandGearInvalidMode() {
    new HandGear("Sword", "Kais", null, 800, true, 3);
  }

  /**
   * Test method for
   * {@link clothing.HandGear#HandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHandGearInvalidPower() {
    new HandGear("Sword", "Kais", Mode.ATTACK, -800, true, 3);
  }

  /**
   * Test method for
   * {@link clothing.HandGear#HandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHandGearInvalidMaxUse() {
    new HandGear("Sword", "Kais", Mode.ATTACK, 800, true, -3);
  }

  /**
   * Test method for {@link clothing.HandGear#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareTo() {
    assertEquals(1, handGear.compareTo(handGear2));
  }

  /**
   * Test method for {@link clothing.HandGear#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToEqual() {
    assertEquals(0, handGear.compareTo(handGear));
  }

  /**
   * Test method for {@link clothing.HandGear#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToGreater() {
    assertEquals(-1, handGear2.compareTo(handGear));
  }

  /**
   * Test method for
   * {@link clothing.HandGear#equipToCharacter(character.Character)}.
   */
  @Test
  public final void testEquipToCharacter() {
    assertEquals(true, handGear.equipToCharacter(character));
  }

  /**
   * Test method for
   * {@link clothing.HandGear#equipToCharacter(character.Character)}.
   */
  @Test
  public final void testEquipToCharacterFalse() {
    for (int i = 0; i < 10; i++) {
      character.equipClothing(handGear);
    }
    assertEquals(false, handGear.equipToCharacter(character));
  }

  /**
   * Test method for
   * {@link clothing.HandGear#equipToCharacter(character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testEquipToCharacterInvalid() {
    assertEquals(true, handGear.equipToCharacter(null));
  }

  /**
   * Test method for {@link clothing.HandGear#hashCode()}.
   */
  @Test
  public final void testhashCode() {
    Clothing handGear = new HandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    Clothing handGear2 = new HandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    assertEquals(handGear.hashCode(), handGear2.hashCode());
  }

  /**
   * Test method for {@link clothing.HandGear#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "HandGear [clothingName=Sword, clothingDescription=Kais, "
        + "clothingMode=ATTACK, clothingPower=800, isCursed=true, "
        + "maxUsage=3, isWornOut=false]";
    assertEquals(expected, handGear.toString());
  }

}
