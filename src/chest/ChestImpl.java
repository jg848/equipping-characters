package chest;

import clothing.Clothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implementation class of the {@link Chest} interface which contains the
 * implementations of the operations defined in the {@link Chest}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ChestImpl implements Chest {

  private int numberOfHeadGear;
  private int numberOfFootwear;
  private int numberOfHandGear;
  private int numberOfJewelry;
  private static final int MIN_HEADGEAR = 4;
  private static final int MIN_FOOTWEAR = 8;
  private static final int MIN_HANDGEAR = 15;
  private static final int MIN_JEWELRY = 15;
  private Random random;

  /**
   * Constructor for the implementation class of {@link Chest} which initializes
   * the attributes of the class.
   */
  public ChestImpl() {
    numberOfHeadGear = 0;
    numberOfFootwear = 0;
    numberOfHandGear = 0;
    numberOfJewelry = 0;
    random = new Random();
  }

  @Override
  public boolean populateHeadGear(List<Clothing> headGearList, List<Clothing> chestList) {
    boolean populate;
    List<Clothing> headGears = new ArrayList<>();
    if (null == chestList) {
      throw new IllegalArgumentException("Chest list is invalid.");
    }
    if (null != headGearList && !headGearList.isEmpty()) {
      while (numberOfHeadGear <= MIN_HEADGEAR) {
        for (int i = 0; i < random.nextInt(MIN_HEADGEAR); i++) {
          headGears.add(headGearList.get(random.nextInt(headGearList.size())));
          numberOfHeadGear++;
        }
      }
      populate = chestList.addAll(headGears);
    } else {
      throw new IllegalArgumentException("Head Gear list cannot be empty.");
    }
    return populate;
  }

  @Override
  public boolean populateFootwear(List<Clothing> footwearList, List<Clothing> chestList) {
    boolean populate;
    List<Clothing> footwear = new ArrayList<>();
    if (null == chestList) {
      throw new IllegalArgumentException("Chest list is invalid.");
    }
    if (null != footwearList && !footwearList.isEmpty()) {
      while (numberOfFootwear <= MIN_FOOTWEAR) {
        for (int i = 0; i < random.nextInt(MIN_FOOTWEAR); i++) {
          footwear.add(footwearList.get(random.nextInt(footwearList.size())));
          numberOfFootwear++;
        }
      }
      populate = chestList.addAll(footwear);
    } else {
      throw new IllegalArgumentException("Footwear list cannot be empty.");
    }
    return populate;
  }

  @Override
  public boolean populateHandGear(List<Clothing> handGearList, List<Clothing> chestList) {
    boolean populate;
    List<Clothing> handGears = new ArrayList<>();
    if (null == chestList) {
      throw new IllegalArgumentException("Chest list is invalid.");
    }
    if (null != handGearList && !handGearList.isEmpty()) {
      while (numberOfHandGear <= MIN_HANDGEAR) {
        for (int i = 0; i < random.nextInt(MIN_HANDGEAR); i++) {
          handGears.add(handGearList.get(random.nextInt(handGearList.size())));
          numberOfHandGear++;
        }
      }
      populate = chestList.addAll(handGears);
    } else {
      throw new IllegalArgumentException("Hand Gear list cannot be empty.");
    }
    return populate;
  }

  @Override
  public boolean populateJewelry(List<Clothing> jewelryList, List<Clothing> chestList) {
    boolean populate;
    List<Clothing> jewelry = new ArrayList<>();
    if (null == chestList) {
      throw new IllegalArgumentException("Chest list is invalid.");
    }
    if (null != jewelryList && !jewelryList.isEmpty()) {
      while (numberOfJewelry <= MIN_JEWELRY) {
        for (int i = 0; i < random.nextInt(MIN_JEWELRY); i++) {
          jewelry.add(jewelryList.get(random.nextInt(jewelryList.size())));
          numberOfJewelry++;
        }
      }
      populate = chestList.addAll(jewelry);
    } else {
      throw new IllegalArgumentException("Jewelry list cannot be empty.");
    }
    return populate;
  }

}
