import static org.junit.Assert.assertEquals;

import clothing.Mode;
import game.GameBuilder;
import game.GameImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link GameBuilder}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GameBuilderTest {

  GameBuilder builder;

  /**
   * Method to setup the test class with required parameters.
   * 
   */
  @Before
  public void setUp() {
    builder = new GameBuilder();
  }

  /**
   * Test method for {@link game.GameBuilder#GameBuilder()}.
   */
  @Test
  public final void testGameBuilder() {
    builder = new GameBuilder();
    assertEquals(GameBuilder.class, builder.getClass());
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createCharacter(String, String, int, int)}.
   */
  @Test
  public final void testCreateCharacter() {
    assertEquals(GameBuilder.class,
        builder.createCharacter("Goku", "Martial Artist", 1000, 500).getClass());
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterInvalidName() {
    builder.createCharacter("", "Martial Artist", 1000, 500);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterInvalidDescription() {
    builder.createCharacter("Goku", "", 1000, 500);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterInvalidBasicAttack() {
    builder.createCharacter("Goku", "Martial Artist", -1000, 500);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterInvalidBasicDefense() {
    builder.createCharacter("Goku", "Martial Artist", 1000, -500);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test
  public final void testCreateHeadGear() {
    assertEquals(GameBuilder.class,
        builder.createHeadGear("Shades", "Doom", 600, false, 1).getClass());
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHeadGearInvalidName() {
    builder.createHeadGear("", "Doom", 600, false, 1);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHeadGearInvalidDescription() {
    builder.createHeadGear("Shades", "", 600, false, 1);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHeadGearInvalidPower() {
    builder.createHeadGear("Shades", "Doom", -600, false, 1);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHeadGearInvalidMaxUse() {
    builder.createHeadGear("Shades", "Doom", 600, false, -10);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createFootwear(String, String, int, boolean, int)}.
   */
  @Test
  public final void testCreateFootwear() {
    assertEquals(GameBuilder.class,
        builder.createFootwear("Boots", "Flight", 400, false, -1).getClass());
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createFootwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateFootwearInvalidName() {
    builder.createFootwear("", "Flight", 400, false, -1);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createFootwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateFootwearInvalidDescription() {
    builder.createFootwear("Boots", "", 400, false, -1);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createFootwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateFootwearInvalidPower() {
    builder.createFootwear("Boots", "Flight", -400, false, -1);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createFootwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateFootwearInvalidMaxUse() {
    builder.createFootwear("Boots", "Flight", 400, false, -10);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHandGear(String, String, Mode, int, boolean, int)}.
   */
  @Test
  public final void testCreateHandGear() {
    assertEquals(GameBuilder.class,
        builder.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3).getClass());
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidName() {
    builder.createHandGear("", "Kais", Mode.ATTACK, 800, true, 3);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidDescription() {
    builder.createHandGear("Sword", "", Mode.ATTACK, 800, true, 3);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidMode() {
    builder.createHandGear("Sword", "Kais", null, 800, true, 3);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidPower() {
    builder.createHandGear("Sword", "Kais", Mode.ATTACK, -800, true, 3);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidMaxUse() {
    builder.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, -3);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createJewelry(String, String, Mode, int, boolean, int)}.
   */
  @Test
  public final void testCreateJewelry() {
    assertEquals(GameBuilder.class,
        builder.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4).getClass());
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidName() {
    builder.createJewelry("", "Charm", Mode.DEFENSE, 300, false, 4);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidDescription() {
    builder.createJewelry("Chain", "", Mode.DEFENSE, 300, false, 4);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidMode() {
    builder.createJewelry("Chain", "Charm", null, 300, false, 4);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidPower() {
    builder.createJewelry("Chain", "Charm", Mode.DEFENSE, -300, false, 4);
  }

  /**
   * Test method for
   * {@link game.GameBuilder#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidMaxUse() {
    builder.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, -4);
  }

  /**
   * Test method for {@link game.GameBuilder#build()}.
   */
  @Test
  public final void testBuild() {
    builder.createCharacter("Goku", "Martial Artist", 1000, 500);
    builder.createCharacter("Vegeta", "King", 900, 600);
    builder.createHeadGear("Shades", "Doom", 600, false, 1);
    builder.createFootwear("Boots", "Flight", 400, false, -1);
    builder.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    builder.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    assertEquals(GameImpl.class, builder.build().getClass());
  }

  /**
   * Test method for {@link game.GameBuilder#build()}.
   */
  @Test(expected = IllegalStateException.class)
  public final void testBuildNoCharacters() {
    builder.createHeadGear("Shades", "Doom", 600, false, 1);
    builder.createFootwear("Boots", "Flight", 400, false, -1);
    builder.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    builder.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    builder.build();
  }

  /**
   * Test method for {@link game.GameBuilder#build()}.
   */
  @Test(expected = IllegalStateException.class)
  public final void testBuildLessCharacters() {
    builder.createCharacter("Goku", "Martial Artist", 1000, 500);
    builder.createHeadGear("Shades", "Doom", 600, false, 1);
    builder.createFootwear("Boots", "Flight", 400, false, -1);
    builder.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    builder.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    builder.build();
  }

  /**
   * Test method for {@link game.GameBuilder#build()}.
   */
  @Test(expected = IllegalStateException.class)
  public final void testBuildNoHeadGear() {
    builder.createCharacter("Goku", "Martial Artist", 1000, 500);
    builder.createCharacter("Vegeta", "King", 900, 600);
    builder.createFootwear("Boots", "Flight", 400, false, -1);
    builder.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    builder.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    builder.build();
  }

  /**
   * Test method for {@link game.GameBuilder#build()}.
   */
  @Test(expected = IllegalStateException.class)
  public final void testBuildNoFootwear() {
    builder.createCharacter("Goku", "Martial Artist", 1000, 500);
    builder.createCharacter("Vegeta", "King", 900, 600);
    builder.createHeadGear("Shades", "Doom", 600, false, 1);
    builder.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    builder.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    builder.build();
  }

  /**
   * Test method for {@link game.GameBuilder#build()}.
   */
  @Test(expected = IllegalStateException.class)
  public final void testBuildNoHandGear() {
    builder.createCharacter("Goku", "Martial Artist", 1000, 500);
    builder.createCharacter("Vegeta", "King", 900, 600);
    builder.createHeadGear("Shades", "Doom", 600, false, 1);
    builder.createFootwear("Boots", "Flight", 400, false, -1);
    builder.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    builder.build();
  }

  /**
   * Test method for {@link game.GameBuilder#build()}.
   */
  @Test(expected = IllegalStateException.class)
  public final void testBuildNoJewelry() {
    builder.createCharacter("Goku", "Martial Artist", 1000, 500);
    builder.createCharacter("Vegeta", "King", 900, 600);
    builder.createHeadGear("Shades", "Doom", 600, false, 1);
    builder.createFootwear("Boots", "Flight", 400, false, -1);
    builder.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    builder.build();
  }

}
