import static org.junit.Assert.assertEquals;

import chest.Chest;
import chest.ChestImpl;
import clothing.Clothing;
import clothing.Footwear;
import clothing.HandGear;
import clothing.HeadGear;
import clothing.Jewelry;
import clothing.Mode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for {@link ChestImplTest}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ChestImplTest {

  Chest chest;
  List<Clothing> headGearList;
  List<Clothing> footwearList;
  List<Clothing> handGearList;
  List<Clothing> jewelryList;
  List<Clothing> chestList;
  Clothing headGear;
  Clothing footwear;
  Clothing handGear;
  Clothing jewelry;

  /**
   * Method to setup the test class with required attributes.
   * 
   * @throws IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    chest = new ChestImpl();
    chestList = new ArrayList<>();
    headGearList = new ArrayList<>();
    footwearList = new ArrayList<>();
    handGearList = new ArrayList<>();
    jewelryList = new ArrayList<>();
    headGear = new HeadGear("Potara", "Fusion", 200, false, 1);
    footwear = new Footwear("Boots", "Flight", 400, false, -1);
    handGear = new HandGear("Gloves", "Power", Mode.ATTACK, 600, false, 1);
    jewelry = new Jewelry("Scouter", "Tracking", Mode.DEFENSE, 200, true, 5);
    headGearList.add(headGear);
    footwearList.add(footwear);
    handGearList.add(handGear);
    jewelryList.add(jewelry);
  }

  /**
   * Test method for {@link chest.ChestImpl#ChestImpl()}.
   */
  @Test
  public final void testChestImpl() {
    chest = new ChestImpl();
    assertEquals(ChestImpl.class, chest.getClass());
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateHeadGear(java.util.List, java.util.List)}.
   */
  @Test
  public final void testPopulateHeadGear() {
    assertEquals(true, chest.populateHeadGear(headGearList, chestList));
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateHeadGear(java.util.List, java.util.List)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPopulateHeadGearInvalidChest() {
    chest.populateHeadGear(headGearList, null);
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateHeadGear(java.util.List, java.util.List)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPopulateHeadGearInvalidList() {
    headGearList.remove(0);
    chest.populateHeadGear(headGearList, chestList);
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateFootwear(java.util.List, java.util.List)}.
   */
  @Test
  public final void testPopulateFootwear() {
    assertEquals(true, chest.populateFootwear(footwearList, chestList));
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateFootwear(java.util.List, java.util.List)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPopulateFootwearInvalidChest() {
    chest.populateFootwear(footwearList, null);
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateFootwear(java.util.List, java.util.List)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPopulateFootwearInvalidList() {
    footwearList.remove(0);
    chest.populateFootwear(footwearList, chestList);
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateHandGear(java.util.List, java.util.List)}.
   */
  @Test
  public final void testPopulateHandGear() {
    assertEquals(true, chest.populateHandGear(handGearList, chestList));
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateHandGear(java.util.List, java.util.List)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPopulateHandGearInvalidChest() {
    chest.populateHandGear(handGearList, null);
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateHandGear(java.util.List, java.util.List)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPopulateHandGearInvalidList() {
    handGearList.remove(0);
    chest.populateHandGear(handGearList, chestList);
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateJewelry(java.util.List, java.util.List)}.
   */
  @Test
  public final void testPopulateJewelry() {
    assertEquals(true, chest.populateJewelry(jewelryList, chestList));
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateJewelry(java.util.List, java.util.List)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPopulateJewelryInvalidChest() {
    chest.populateJewelry(jewelryList, null);
  }

  /**
   * Test method for
   * {@link chest.ChestImpl#populateJewelry(java.util.List, java.util.List)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPopulateJewelryInvalidList() {
    jewelryList.remove(0);
    chest.populateJewelry(jewelryList, chestList);
  }

}
