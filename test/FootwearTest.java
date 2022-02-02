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
 * Test class for {@link Footwear}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class FootwearTest {

  Clothing footwear;
  Clothing footwear2;
  Clothing headGear;
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
    footwear2 = new Footwear("Sandals", "Speed", 200, true, 3);
    headGear = new HeadGear("Potara", "Fusion", 200, false, 1);
    handGear = new HandGear("Gloves", "Power", Mode.ATTACK, 600, false, 1);
    character = new CharacterImpl("Goku", "Martial Artist", 1000, 500);
  }

  /**
   * Test method for {@link clothing.Footwear#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObject() {
    assertEquals(true, footwear.equals(footwear2));
  }

  /**
   * Test method for {@link clothing.Footwear#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObjectFalse() {
    assertEquals(false, footwear.equals(headGear));
  }

  /**
   * Test method for
   * {@link clothing.Footwear#compareToFootwear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToFootwear() {
    assertEquals(-1, footwear2.compareTo(footwear));
  }

  /**
   * Test method for
   * {@link clothing.Footwear#compareToFootwear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToFootwearZero() {
    assertEquals(0, footwear.compareTo(footwear));
  }

  /**
   * Test method for
   * {@link clothing.Footwear#compareToFootwear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToFootwearGreater() {
    assertEquals(1, footwear.compareTo(footwear2));
  }

  /**
   * Test method for {@link clothing.Footwear#equalsFootwear(clothing.Footwear)}.
   */
  @Test
  public final void testEqualsFootwear() {
    assertEquals(true, footwear.equals(footwear2));
  }

  /**
   * Test method for
   * {@link clothing.Footwear#Footwear(String, String, int, boolean, int)}.
   */
  @Test
  public final void testFootwear() {
    footwear = new Footwear("Boots", "Flight", 400, false, -1);
    assertEquals(Footwear.class, footwear.getClass());
  }

  /**
   * Test method for
   * {@link clothing.Footwear#Footwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testFootwearInvalidName() {
    new Footwear("", "Flight", 400, false, -1);
  }

  /**
   * Test method for
   * {@link clothing.Footwear#Footwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testFootwearInvalidDescription() {
    new Footwear("Boots", "", 400, false, -1);
  }

  /**
   * Test method for
   * {@link clothing.Footwear#Footwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testFootwearInvalidPower() {
    new Footwear("Boots", "Flight", -400, false, -1);
  }

  /**
   * Test method for
   * {@link clothing.Footwear#Footwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testFootwearInvalidMaxUse() {
    new Footwear("Boots", "Flight", 400, false, -10);
  }

  /**
   * Test method for {@link clothing.Footwear#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareTo() {
    assertEquals(1, footwear.compareTo(handGear));
  }

  /**
   * Test method for {@link clothing.Footwear#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToEqual() {
    assertEquals(0, footwear.compareTo(footwear));
  }

  /**
   * Test method for {@link clothing.Footwear#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToGreater() {
    assertEquals(-1, footwear2.compareTo(footwear));
  }

  /**
   * Test method for
   * {@link clothing.Footwear#equipToCharacter(character.Character)}.
   */
  @Test
  public final void testEquipToCharacter() {
    assertEquals(true, footwear.equipToCharacter(character));
  }

  /**
   * Test method for
   * {@link clothing.Footwear#equipToCharacter(character.Character)}.
   */
  @Test
  public final void testEquipToCharacterFalse() {
    character.equipClothing(footwear);
    character.equipClothing(footwear2);
    assertEquals(false, footwear.equipToCharacter(character));
  }

  /**
   * Test method for
   * {@link clothing.Footwear#equipToCharacter(character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testEquipToCharacterInvalid() {
    assertEquals(true, footwear.equipToCharacter(null));
  }

  /**
   * Test method for {@link clothing.Footwear#hashCode()}.
   */
  @Test
  public final void testhashCode() {
    Clothing footwear = new Footwear("Boots", "Flight", 400, false, -1);
    Clothing footwear2 = new Footwear("Boots", "Flight", 400, false, -1);
    assertEquals(footwear.hashCode(), footwear2.hashCode());
  }

  /**
   * Test method for {@link clothing.Footwear#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Footwear [clothingName=Boots, clothingDescription=Flight, "
        + "clothingMode=ATTACK, clothingPower=400, isCursed=false, "
        + "maxUsage=Unlimited, isWornOut=false]";
    assertEquals(expected, footwear.toString());
  }

}
