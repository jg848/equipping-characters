package game;

import clothing.Mode;

import java.util.Scanner;

/**
 * Driver class to demonstrate the working of the {@link Game} implementation.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GameDriver {

  static GameBuilder builder;
  static Game game;

  /**
   * Main method to run the program.
   * 
   * @param args represents the command line input to the main method.
   */
  public static void main(String[] args) {
    System.out.println("Initializing Game.");
    builder = new GameBuilder();
    game = new GameImpl();
    System.out.println("Creating character 'Goku'.");
    builder.createCharacter("Goku", "Martial Artist", 1000, 500);
    System.out.println("Creating character 'Vegeta'.");
    builder.createCharacter("Vegeta", "King", 900, 600);
    System.out.println("Creating character 'Gohan'.");
    builder.createCharacter("Gohan", "Scholor", 800, 400);
    System.out.println("Creating headgear 'Potara'.");
    builder.createHeadGear("Potara", "Fusion", 200, false, 3);
    System.out.println("Creating headgear 'Shades'.");
    builder.createHeadGear("Shades", "Doom", 400, true, 1);
    System.out.println("Creating footwear 'Boots'.");
    builder.createFootwear("Boots", "Flight", 400, false, -1);
    System.out.println("Creating footwear 'Sandals'.");
    builder.createFootwear("Sandals", "Speed", 200, true, 3);
    System.out.println("Creating handgear 'Sword'.");
    builder.createHandGear("Sword", "Light", Mode.ATTACK, 800, false, 4);
    System.out.println("Creating handgear 'Gloves'.");
    builder.createHandGear("Gloves", "Power", Mode.DEFENSE, 600, false, 1);
    System.out.println("Creating jewelry 'Scouter'.");
    builder.createJewelry("Scouter", "Tracking", Mode.DEFENSE, 200, true, 5);
    System.out.println("Creating jewelry 'Radar'.");
    builder.createJewelry("Radar", "Tracking", Mode.ATTACK, 700, false, -1);
    System.out.println("Building Game.");
    game = builder.build();
    System.out.println("Printing characters created.");
    System.out.println(game.printCharacters());
    System.out.println("Populating chest from available clothing.");
    game.populateChestOfGears();
    System.out.println("Dressing characters with clothing from chest.");
    System.out.println(game.dressCharacters());
    System.out.println("Predicting battle between 'Goku' and 'Vegeta'");
    System.out.println(game.predictBattle(game.getCharacter("Goku"), game.getCharacter("Vegeta")));
    Scanner scanner = new Scanner(System.in);
    System.out.println("Do you want a rematch between 'Goku' and 'Vegeta' ? (Y/N)");

    boolean breakLoop = false;
    while (!breakLoop) {
      String input = scanner.nextLine();
      if ("Y".equalsIgnoreCase(input)) {
        System.out.println("Initializing rematch between 'Goku' and 'Vegeta'.");
        System.out.println(game.rematch(game.getCharacter("Goku"), game.getCharacter("Vegeta")));
        System.out.println("Do you want a rematch between 'Goku' and 'Vegeta' ? (Y/N)");
      } else if ("N".equalsIgnoreCase(input)) {
        System.out.println("Rematch Declined. Proceeding.");
        breakLoop = true;
      } else {
        System.out.println("Enter a valid input.");
      }
    }
    scanner.reset();

    System.out.println("Predicting battle between 'Goku' and 'Gohan'");
    System.out.println(game.predictBattle(game.getCharacter("Goku"), game.getCharacter("Gohan")));
    System.out.println("Do you want a rematch between 'Goku' and 'Gohan' ? (Y/N)");

    breakLoop = false;
    while (!breakLoop) {
      String input = scanner.nextLine();
      if ("Y".equalsIgnoreCase(input)) {
        System.out.println("Initializing rematch between 'Goku' and 'Gohan'.");
        System.out.println(game.rematch(game.getCharacter("Goku"), game.getCharacter("Gohan")));
        System.out.println("Do you want a rematch between 'Goku' and 'Gohan' ? (Y/N)");
      } else if ("N".equalsIgnoreCase(input)) {
        System.out.println("Rematch Declined. Proceeding.");
        breakLoop = true;
      } else {
        System.out.println("Enter a valid input.");
      }
    }
    scanner.reset();

    System.out.println("Predicting battle between 'Gohan' and 'Vegeta'");
    System.out.println(game.predictBattle(game.getCharacter("Gohan"), game.getCharacter("Vegeta")));
    System.out.println("Do you want a rematch between 'Gohan' and 'Vegeta' ? (Y/N)");

    breakLoop = false;
    while (!breakLoop) {
      String input = scanner.nextLine();
      if ("Y".equalsIgnoreCase(input)) {
        System.out.println("Initializing rematch between 'Gohan' and 'Vegeta'.");
        System.out.println(game.rematch(game.getCharacter("Gohan"), game.getCharacter("Vegeta")));
        System.out.println("Do you want a rematch between 'Gohan' and 'Vegeta' ? (Y/N)");
      } else if ("N".equalsIgnoreCase(input)) {
        System.out.println("Rematch Declined. Proceeding.");
        breakLoop = true;
      } else {
        System.out.println("Enter a valid input.");
      }
    }
    scanner.close();
    System.out.println("Demonstration complete.");
  }

}
