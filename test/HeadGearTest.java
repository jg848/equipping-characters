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
 * Test class for {@link HeadGear}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class HeadGearTest {

  Clothing footwear;
  Clothing headGear;
  Clothing headGear2;
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
    headGear = new HeadGear("Shades", "Doom", 600, false, 1);
    headGear2 = new HeadGear("Potara", "Fusion", 200, false, 1);
    character = new CharacterImpl("Goku", "Martial Artist", 1000, 500);
  }

  /**
   * Test method for {@link clothing.HeadGear#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObject() {
    assertEquals(true, headGear.equals(headGear2));
  }

  /**
   * Test method for {@link clothing.HeadGear#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObjectSelf() {
    assertEquals(true, headGear.equals(headGear));
  }

  /**
   * Test method for {@link clothing.HeadGear#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObjectFalse() {
    assertEquals(false, headGear.equals(footwear));
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#compareToHeadGear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToHeadGear() {
    assertEquals(-1, headGear2.compareTo(headGear));
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#compareToHeadGear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToHeadGearZero() {
    assertEquals(0, headGear.compareTo(headGear));
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#compareToHeadGear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToHeadGearGreater() {
    assertEquals(1, headGear.compareTo(headGear2));
  }

  /**
   * Test method for {@link clothing.HeadGear#equalsHeadGear(clothing.HeadGear)}.
   */
  @Test
  public final void testEqualsHeadGear() {
    assertEquals(true, headGear.equals(headGear2));
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#HeadGear(String, String, int, boolean, int)}.
   */
  @Test
  public final void testHeadGear() {
    headGear = new HeadGear("Shades", "Doom", 600, false, 1);
    assertEquals(HeadGear.class, headGear.getClass());
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#HeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHeadGearInvalidName() {
    new HeadGear("", "Doom", 600, false, 1);
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#HeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHeadGearInvalidDescription() {
    new HeadGear("Shades", "", 600, false, 1);
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#HeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHeadGearInvalidPower() {
    new HeadGear("Shades", "Doom", -600, false, 1);
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#HeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHeadGearInvalidMaxUse() {
    new HeadGear("Shades", "Doom", 600, false, -10);
  }

  /**
   * Test method for {@link clothing.HeadGear#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareTo() {
    assertEquals(1, headGear.compareTo(handGear));
  }

  /**
   * Test method for {@link clothing.HeadGear#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToEqual() {
    assertEquals(0, headGear.compareTo(headGear));
  }

  /**
   * Test method for {@link clothing.HeadGear#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToGreater() {
    assertEquals(-1, headGear2.compareTo(headGear));
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#equipToCharacter(character.Character)}.
   */
  @Test
  public final void testEquipToCharacter() {
    assertEquals(true, headGear.equipToCharacter(character));
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#equipToCharacter(character.Character)}.
   */
  @Test
  public final void testEquipToCharacterFalse() {
    character.equipClothing(headGear);
    character.equipClothing(headGear2);
    assertEquals(false, headGear.equipToCharacter(character));
  }

  /**
   * Test method for
   * {@link clothing.HeadGear#equipToCharacter(character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testEquipToCharacterInvalid() {
    assertEquals(true, headGear.equipToCharacter(null));
  }

  /**
   * Test method for {@link clothing.HeadGear#hashCode()}.
   */
  @Test
  public final void testhashCode() {
    Clothing headGear = new HeadGear("Shades", "Doom", 600, false, 1);
    Clothing headGear2 = new HeadGear("Shades", "Doom", 600, false, 1);
    assertEquals(headGear.hashCode(), headGear2.hashCode());
  }

  /**
   * Test method for {@link clothing.HeadGear#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "HeadGear [clothingName=Shades, clothingDescription=Doom, "
        + "clothingMode=DEFENSE, clothingPower=600, isCursed=false, "
        + "maxUsage=1, isWornOut=false]";
    assertEquals(expected, headGear.toString());
  }

}
