package chest;

import clothing.Clothing;
import clothing.Footwear;
import clothing.HandGear;
import clothing.HeadGear;
import clothing.Jewelry;
import game.Game;

import java.util.List;

/**
 * Chest class which is an interface containing all the operations that should
 * be performed by a {@link Chest}. Used to populate a {@link Chest} of
 * {@link Clothing} from the available list of {@link Clothing}.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface Chest {

  /**
   * Method used to populate a list of {@link HeadGear} from the available list.
   * 
   * @param headGearList which is the list of available {@link HeadGear} in the
   *                     {@link Game}.
   * @param chestList    which is the list of gears representing a {@link Chest}.
   * @return true if items added, false if not
   */
  public boolean populateHeadGear(List<Clothing> headGearList, List<Clothing> chestList);

  /**
   * Method used to populate a list of {@link Footwear} from the available list.
   * 
   * @param footwearList which is the list of available {@link Footwear} in the
   *                     {@link Game}.
   * @param chestList    which is the list of gears representing a {@link Chest}.
   * @return true if items added, false if not
   */
  public boolean populateFootwear(List<Clothing> footwearList, List<Clothing> chestList);

  /**
   * Method used to populate a list of {@link HandGear} from the available list.
   * 
   * @param handGearList which is the list of available {@link HandGear} in the
   *                     {@link Game}.
   * @param chestList    which is the list of gears representing a {@link Chest}.
   * @return true if items added, false if not
   */
  public boolean populateHandGear(List<Clothing> handGearList, List<Clothing> chestList);

  /**
   * Method used to populate a list of {@link Jewelry} from the available list.
   * 
   * @param jewelryList which is the list of available {@link Jewelry} in the
   *                    {@link Game}.
   * @param chestList   which is the list of gears representing a {@link Chest}.
   * @return true if items added, false if not
   */
  public boolean populateJewelry(List<Clothing> jewelryList, List<Clothing> chestList);

}
