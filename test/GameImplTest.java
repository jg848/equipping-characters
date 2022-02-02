import static org.junit.Assert.assertEquals;

import clothing.Mode;
import game.Game;
import game.GameBuilder;
import game.GameImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link GameImpl}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GameImplTest {

  Game game;
  GameBuilder builder;

  /**
   * Method to setup the test class with required attributes.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    game = new GameImpl();
    builder = new GameBuilder();
    builder.createCharacter("Goku", "Martial Artist", 1000, 500);
    builder.createCharacter("Vegeta", "King", 900, 600);
    builder.createHeadGear("Shades", "Doom", 600, false, 1);
    builder.createFootwear("Boots", "Flight", 400, false, -1);
    builder.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3);
    builder.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4);
    game = builder.build();
  }

  /**
   * Test method for {@link game.GameImpl#GameImpl()}.
   */
  @Test
  public final void testGameImpl() {
    game = new GameImpl();
    assertEquals(GameImpl.class, game.getClass());
  }

  /**
   * Test method for
   * {@link game.GameImpl#createCharacter(String, String, int, int)}.
   */
  @Test
  public final void testCreateCharacter() {
    game = new GameImpl();
    assertEquals(true, game.createCharacter("Gohan", "Scholor", 800, 400));
  }

  /**
   * Test method for
   * {@link game.GameImpl#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterAlreadyExists() {
    game = new GameImpl();
    game.createCharacter("Goku", "Martial Artist", 1000, 500);
    game.createCharacter("Goku", "Martial Artist", 1000, 500);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterInvalidName() {
    game = new GameImpl();
    game.createCharacter("", "Martial Artist", 1000, 500);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterInvalidDescription() {
    game = new GameImpl();
    game.createCharacter("Goku", "", 1000, 500);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterNullName() {
    game = new GameImpl();
    game.createCharacter(null, "Martial Artist", 1000, 500);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterNullDescription() {
    game = new GameImpl();
    game.createCharacter("Goku", null, 1000, 500);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterInvalidBasicAttack() {
    game = new GameImpl();
    game.createCharacter("Goku", "Martial Artist", -1000, 500);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createCharacter(String, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateCharacterInvalidBasicDefense() {
    game = new GameImpl();
    game.createCharacter("Goku", "Martial Artist", 1000, -500);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test
  public final void testCreateHeadGear() {
    assertEquals(true, game.createHeadGear("Shades", "Doom", 600, false, 1));
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHeadGearInvalidName() {
    game.createHeadGear("", "Doom", 600, false, 1);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHeadGearInvalidDescription() {
    game.createHeadGear("Shades", "", 600, false, 1);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHeadGearInvalidPower() {
    game.createHeadGear("Shades", "Doom", -600, false, 1);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHeadGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHeadGearInvalidMaxUse() {
    game.createHeadGear("Shades", "Doom", 600, false, -10);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createFootwear(String, String, int, boolean, int)}.
   */
  @Test
  public final void testCreateFootwear() {
    assertEquals(true, game.createFootwear("Boots", "Flight", 400, false, -1));
  }

  /**
   * Test method for
   * {@link game.GameImpl#createFootwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateFootwearInvalidName() {
    game.createFootwear("", "Flight", 400, false, -1);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createFootwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateFootwearInvalidDescription() {
    game.createFootwear("Boots", "", 400, false, -1);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createFootwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateFootwearInvalidPower() {
    game.createFootwear("Boots", "Flight", -400, false, -1);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createFootwear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateFootwearInvalidMaxUse() {
    game.createFootwear("Boots", "Flight", 400, false, -10);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHandGear(String, String, Mode, int, boolean, int)}.
   */
  @Test
  public final void testCreateHandGear() {
    assertEquals(true, game.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, 3));
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidName() {
    game.createHandGear("", "Kais", Mode.ATTACK, 800, true, 3);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidDescription() {
    game.createHandGear("Sword", "", Mode.ATTACK, 800, true, 3);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidMode() {
    game.createHandGear("Sword", "Kais", null, 800, true, 3);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidPower() {
    game.createHandGear("Sword", "Kais", Mode.ATTACK, -800, true, 3);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createHandGear(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHandGearInvalidMaxUse() {
    game.createHandGear("Sword", "Kais", Mode.ATTACK, 800, true, -3);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createJewelry(String, String, Mode, int, boolean, int)}.
   */
  @Test
  public final void testCreateJewelry() {
    assertEquals(true, game.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, 4));
  }

  /**
   * Test method for
   * {@link game.GameImpl#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidName() {
    game.createJewelry("", "Charm", Mode.DEFENSE, 300, false, 4);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidDescription() {
    game.createJewelry("Chain", "", Mode.DEFENSE, 300, false, 4);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidMode() {
    game.createJewelry("Chain", "Charm", null, 300, false, 4);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidPower() {
    game.createJewelry("Chain", "Charm", Mode.DEFENSE, -300, false, 4);
  }

  /**
   * Test method for
   * {@link game.GameImpl#createJewelry(String, String, int, boolean, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateJewelryInvalidMaxUse() {
    game.createJewelry("Chain", "Charm", Mode.DEFENSE, 300, false, -4);
  }

  /**
   * Test method for {@link game.GameImpl#populateChestOfGears()}.
   */
  @Test
  public final void testPopulateChestOfGears() {
    assertEquals(true, game.populateChestOfGears());
  }

  /**
   * Test method for {@link game.GameImpl#dressCharacters()}.
   */
  @Test
  public final void testDressCharacters() {
    game.populateChestOfGears();
    assertEquals(true, !game.dressCharacters().isBlank());
  }

  /**
   * Test method for {@link game.GameImpl#dressCharacters()}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testDressCharactersInvalidChest() {
    game.dressCharacters();
  }

  /**
   * Test method for {@link game.GameImpl#printCharacters()}.
   */
  @Test
  public final void testPrintCharacters() {
    assertEquals(true, !game.printCharacters().isBlank());
  }

  /**
   * Test method for
   * {@link game.GameImpl#predictBattle(character.Character, character.Character)}.
   */
  @Test
  public final void testPredictBattle() {
    assertEquals(true,
        !game.predictBattle(game.getCharacter("Goku"), game.getCharacter("Vegeta")).isBlank());
  }

  /**
   * Test method for
   * {@link game.GameImpl#predictBattle(character.Character, character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPredictBattleInvalidCharacterNames() {
    game.predictBattle(game.getCharacter(""), game.getCharacter(""));
  }

  /**
   * Test method for
   * {@link game.GameImpl#predictBattle(character.Character, character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPredictBattleInvalidCharacterName() {
    game.predictBattle(game.getCharacter("Goku"), game.getCharacter(""));
  }

  /**
   * Test method for
   * {@link game.GameImpl#predictBattle(character.Character, character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPredictBattleInvalidCharacters() {
    game.predictBattle(null, null);
  }

  /**
   * Test method for
   * {@link game.GameImpl#predictBattle(character.Character, character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testPredictBattleInvalidCharacter() {
    game.predictBattle(null, game.getCharacter("Vegeta"));
  }

  /**
   * Test method for
   * {@link game.GameImpl#rematch(character.Character, character.Character)}.
   */
  @Test
  public final void testRematch() {
    assertEquals(true,
        !game.rematch(game.getCharacter("Goku"), game.getCharacter("Vegeta")).isBlank());
  }

  /**
   * Test method for
   * {@link game.GameImpl#rematch(character.Character, character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testRematchInvalidCharacterNames() {
    game.rematch(game.getCharacter(""), game.getCharacter(""));
  }

  /**
   * Test method for
   * {@link game.GameImpl#rematch(character.Character, character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testRematchInvalidCharacterName() {
    game.rematch(game.getCharacter("Goku"), game.getCharacter(""));
  }

  /**
   * Test method for
   * {@link game.GameImpl#rematch(character.Character, character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testRematchInvalidCharacters() {
    game.rematch(null, null);
  }

  /**
   * Test method for
   * {@link game.GameImpl#rematch(character.Character, character.Character)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testRematchInvalidCharacter() {
    game.rematch(null, game.getCharacter("Vegeta"));
  }

  /**
   * Test method for {@link game.GameImpl#getCharacter(String)}.
   */
  @Test
  public final void testGetCharacter() {
    assertEquals("Goku", game.getCharacter("Goku").getName());
  }

  /**
   * Test method for {@link game.GameImpl#getCharacter(String)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testGetCharacterInvalidName() {
    game.getCharacter("");
  }

  /**
   * Test method for {@link game.GameImpl#getCharacter(String)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testGetCharacterNullName() {
    game.getCharacter(null);
  }

}
