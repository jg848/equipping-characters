import static org.junit.Assert.assertEquals;

import clothing.Clothing;
import clothing.ClothingImpl;
import clothing.Footwear;
import clothing.HandGear;
import clothing.HeadGear;
import clothing.Jewelry;
import clothing.Mode;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link ClothingImpl}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ClothingImplTest {

  Clothing headGear;
  Clothing headGear2;
  Clothing footwear;
  Clothing footwear2;
  Clothing handGear;
  Clothing handGear2;
  Clothing jewelry;
  Clothing jewelry2;

  /**
   * Method to setup the test class with required attributes.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    headGear = new HeadGear("Potara", "Fusion", 200, false, 1);
    headGear2 = new HeadGear("Potara", "Fusion", 200, false, 1);
    footwear = new Footwear("Boots", "Flight", 400, false, -1);
    footwear2 = new Footwear("Sandals", "Speed", 200, true, 3);
    handGear = new HandGear("Gloves", "Power", Mode.ATTACK, 600, false, 1);
    handGear2 = new HandGear("Gloves", "Power", Mode.DEFENSE, 600, false, 1);
    jewelry = new Jewelry("Scouter", "Tracking", Mode.DEFENSE, 200, true, 5);
    jewelry2 = new Jewelry("Radar", "Tracking", Mode.ATTACK, 700, false, -1);
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#ClothingImpl(String, String, clothing.Mode, int, boolean, int)}.
   */
  @Test
  public final void testClothingImpl() {
    handGear = new HandGear("Gloves", "Power", Mode.ATTACK, 600, false, 1);
    String expected = "HandGear [clothingName=Gloves, clothingDescription=Power, "
        + "clothingMode=ATTACK, clothingPower=600, isCursed=false, "
        + "maxUsage=1, isWornOut=false]";
    assertEquals(expected, handGear.toString());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#getPower()}.
   */
  @Test
  public final void testGetPower() {
    assertEquals(600, handGear.getPower());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#getMode()}.
   */
  @Test
  public final void testGetModeAttack() {
    assertEquals(Mode.ATTACK, handGear.getMode());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#getMode()}.
   */
  @Test
  public final void testGetModeDefense() {
    assertEquals(Mode.DEFENSE, jewelry.getMode());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#getMaxUsage()}.
   */
  @Test
  public final void testGetMaxUsage() {
    assertEquals(1, headGear.getMaxUsage());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#getMaxUsage()}.
   */
  @Test
  public final void testGetMaxUsageUnlimited() {
    assertEquals(-1, footwear.getMaxUsage());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#isCursed()}.
   */
  @Test
  public final void testIsCursedTrue() {
    assertEquals(true, jewelry.isCursed());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#isCursed()}.
   */
  @Test
  public final void testIsCursedFalse() {
    assertEquals(false, headGear.isCursed());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#isWornOut()}.
   */
  @Test
  public final void testIsWornOutTrue() {
    headGear.useClothing();
    assertEquals(true, headGear.isWornOut());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#isWornOut()}.
   */
  @Test
  public final void testIsWornOutFalse() {
    assertEquals(false, headGear.isWornOut());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#useClothing()}.
   */
  @Test
  public final void testUseClothing() {
    headGear.useClothing();
    assertEquals(true, headGear.isWornOut());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#getName()}.
   */
  @Test
  public final void testGetName() {
    assertEquals("Potara", headGear.getName());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#getDescription()}.
   */
  @Test
  public final void testGetDescription() {
    assertEquals("Fusion", headGear.getDescription());
  }

  /**
   * Test method for {@link clothing.ClothingImpl#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObject() {
    assertEquals(true, footwear.equals(footwear2));
  }

  /**
   * Test method for {@link clothing.ClothingImpl#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObjectFalse() {
    assertEquals(false, footwear.equals(headGear));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#compareToHeadGear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToHeadGear() {
    assertEquals(-1, jewelry.compareTo(headGear));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#compareToFootwear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToFootwear() {
    assertEquals(-1, handGear.compareTo(footwear));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#compareToFootwear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToFootwearGreater() {
    assertEquals(1, handGear2.compareTo(footwear));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#compareToHandGear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToHandGear() {
    assertEquals(-1, jewelry.compareTo(handGear));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#compareToHandGear(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToHandGearGreater() {
    assertEquals(1, footwear2.compareTo(handGear));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#compareToJewelry(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToJewelry() {
    assertEquals(-1, handGear.compareTo(jewelry));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#compareToJewelry(clothing.Clothing)}.
   */
  @Test
  public final void testCompareToJewelryGreater() {
    assertEquals(1, handGear.compareTo(jewelry2));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#equalsHeadGear(clothing.HeadGear)}.
   */
  @Test
  public final void testEqualsHeadGear() {
    assertEquals(false, jewelry.equals(headGear));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#equalsFootwear(clothing.Footwear)}.
   */
  @Test
  public final void testEqualsFootwear() {
    assertEquals(false, jewelry.equals(footwear));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#equalsHandGear(clothing.HandGear)}.
   */
  @Test
  public final void testEqualsHandGear() {
    assertEquals(false, jewelry.equals(handGear));
  }

  /**
   * Test method for
   * {@link clothing.ClothingImpl#equalsJewelry(clothing.Jewelry)}.
   */
  @Test
  public final void testEqualsJewelry() {
    assertEquals(false, footwear.equals(jewelry));
  }

}
