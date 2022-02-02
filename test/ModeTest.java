import static org.junit.Assert.assertEquals;

import clothing.Mode;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the enumeration {@link Mode}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ModeTest {

  Mode mode;
  Mode mode2;

  /**
   * Method used to setup the test class.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    mode = Mode.ATTACK;
    mode2 = Mode.DEFENSE;
  }

  /**
   * Test method for {@link Mode}.
   */
  @Test
  public final void testAttack() {
    assertEquals(Mode.ATTACK, mode);
  }

  /**
   * Test method for {@link Mode}.
   */
  @Test
  public final void testDefense() {
    assertEquals(Mode.DEFENSE, mode2);
  }

}
