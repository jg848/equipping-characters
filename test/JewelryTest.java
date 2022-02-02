import static org.junit.Assert.assertEquals;

import character.Character;
import character.CharacterImpl;
import clothing.Clothing;
import clothing.Footwear;
import clothing.HeadGear;
import clothing.Jewelry;
import clothing.Mode;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Jewelry}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class JewelryTest {

  Clothing footwear;
  Clothing headGear;
  Clothing jewelry;
  Clothing jewelry2;
  Clothing jewelry3;
  Character character;

  /**
   * Method to setup the test class with the required attributes.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    footwear = new Footwear("Boots", "Flight", 400, false, -1);
    headGear = new HeadGear("Potara", "Fusion", 200, false, 1);
    jewelry = new Jewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    jewelry2 = new Jewelry("Radar", "Tracking", Mode.ATTACK, 700, false, -1);
    jewelry3 = new Jewelry("Scouter", "Tracking", Mode.ATTACK, 500, false, -1);
    character = new CharacterImpl("Goku", "Martial Artist", 1000, 500);
  }

  /**
   * Test method for {@link clothing.Jewelry#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObject() {
    assertEquals(true, jewelry.equals(jewelry2));
  }

  /**
   * Test method for {@link clothing.Jewelry#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObjectSelf() {
    assertEquals(true, jewelry.equals(jewelry));
  }

  /**
   * Test method for {@link clothing.Jewelry#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObjectFalse() {
    assertEquals(false, jewelry.equals(headGear));
  }

  /**
   * Test method for {@link clothing.Jewelry#equals(java.lang.Object)}.
   */
  @Test(expected = ClassCastException.class)
  public final void testEqualsObjectOther() {
    jewelry.equals(character);
  }

  /**
   * Test method for {@link clothing.Jewelry#compareToJewelry(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToJewelry() {
    assertEquals(-1, jewelry.compareTo(jewelry2));
  }

  /**
   * Test method for {@link clothing.Jewelry#compareToJewelry(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToJewelryZero() {
    assertEquals(0, jewelry.compareTo(jewelry));
  }

  /**
   * Test method for {@link clothing.Jewelry#compareToJewelry(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToJewelryGreater() {
    assertEquals(1, jewelry2.compareTo(jewelry));
  }

  /**
   * Test method for {@link clothing.Jewelry#equalsJewelry(clothing.Jewelry)}.
   */
  @Test
  public final void testEqualsJewelry() {
    assertEquals(true, jewelry.equals(jewelry2));
  }

  /**
   * Test method for
   * {@link clothing.Jewelry#Jewelry(String, String, int, boolean, int)}.
   */
  @Test
  public final void testJewelry() {
    jewelry = new Jewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    assertEquals(Jewelry.class, jewelry.getClass());
  }

  /**
   * Test method for
   * {@link clothing.Jewelry#Jewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testJewelryInvalidName() {
    new Jewelry("", "Charm", Mode.DEFENSE, 300, false, 4);
  }

  /**
   * Test method for
   * {@link clothing.Jewelry#Jewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testJewelryInvalidDescription() {
    new Jewelry("Chain", "", Mode.DEFENSE, 300, false, 4);
  }

  /**
   * Test method for
   * {@link clothing.Jewelry#Jewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testJewelryInvalidMode() {
    new Jewelry("Chain", "Charm", null, 300, false, 4);
  }

  /**
   * Test method for
   * {@link clothing.Jewelry#Jewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testJewelryInvalidPower() {
    new Jewelry("Chain", "Charm", Mode.DEFENSE, -300, false, 4);
  }

  /**
   * Test method for
   * {@link clothing.Jewelry#Jewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testJewelryInvalidMaxUse() {
    new Jewelry("Chain", "Charm", Mode.DEFENSE, 300, false, -4);
  }

  /**
   * Test method for {@link clothing.Jewelry#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareTo() {
    assertEquals(1, jewelry2.compareTo(jewelry));
  }

  /**
   * Test method for {@link clothing.Jewelry#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToEqual() {
    assertEquals(0, jewelry.compareTo(jewelry));
  }

  /**
   * Test method for {@link clothing.Jewelry#compareTo(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToGreater() {
    assertEquals(-1, jewelry.compareTo(jewelry2));
  }

  /**
   * Test method for
   * {@link clothing.Jewelry#equipToCharacter(character.Character)}.
   */
  @Test
  public final void testEquipToCharacter() {
    assertEquals(true, jewelry.equipToCharacter(character));
  }

  /**
   * Test method for
   * {@link clothing.Jewelry#equipToCharacter(character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testEquipToCharacterInvalid() {
    assertEquals(true, jewelry.equipToCharacter(null));
  }

  /**
   * Test method for {@link clothing.Jewelry#hashCode()}.
   */
  @Test
  public final void testhashCode() {
    Clothing jewelry = new Jewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    Clothing jewelry2 = new Jewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    assertEquals(jewelry.hashCode(), jewelry2.hashCode());
  }

  /**
   * Test method for {@link clothing.Jewelry#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Jewelry [clothingName=Chain, clothingDescription=Charm, "
        + "clothingMode=DEFENSE, clothingPower=300, isCursed=false, "
        + "maxUsage=4, isWornOut=false]";
    assertEquals(expected, jewelry.toString());
  }

}
