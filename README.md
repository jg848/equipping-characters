# Role Playing Game by Jumptastic

### About/Overview
The Role Playing Game presented by Jumptastic Games is one in which characters will be able to enhance their basic abilities by "wearing" different items.
Overview of the Features:
  - There can be multiple characters in the game with different types of items which can be worn by these characters to increase their attack and defense strengths.
  - The characters can equip different items from the chest of gears which will be populated randomly. Characters can wear four different types of gears - **_HEAD GEAR_**, **_FOOTWEAR_**, **_HAND GEAR_** and **_JEWELRY_**. 
  - The attack or defensive power of the items that a character is wearing temporarily adds (or subtracts in the case of a cursed item) to the players attack power and defensive strength.
  - Some items wear out with each use and thus their benefit decreases each time a player uses them. Characters that continue to wear and use worn-out items find that these items decrease their basic attack power and defensive strength.
  - The characters are dressed from a randomly selected 20 items from the chest of gears and can run a simulation of a battle with other characters using their strengths. The winner will be decided based on the number of rounds each character lasts.

### List of features

  - The **_GameBuilder_** class is used to build a game with the minimum requirements to run. It uses the **Builder Pattern** to construct a **_Game_**. The characters and the items are created so that the Game can be built. To build the **_Game_** a minimum of 2 characters and 1 of each type of clothing should be created.
  - The **_Game_** interface represents a game built by the builder class and contains the features of the game. **_GameImpl_** class implements the **_Game_** class and provides the different features offered. 
	> The game can populate a chest of gears from the available gears created while building the game. The chest contains a minimum of 4 headgear, 8 footwear, 15 handgear and 15 jewelry.
	> It can dress all the characters in the game by picking 20 random items from the chest and equipping accordingly. A character can only wear a maximum of 1 headgear, 2 footwear and 10 handgear. It can wear any number of jewelry.
	> It can print details of all the characters in the game with the strengths of the character and the details of the items worn.
	> Predicts a battle between 2 characters. A simulation is run which calculates the maximum number of rounds a character can last when the other character attacks. The character which lasts more number of rounds is declared a winner. If the number of rounds is same for both the characters, then it is declared a TIE.
	> Provides an option to call a rematch between the same 2 characters after the battle prediction is given. If user chooses to call rematch, then all the characters are discarded of all the items they are wearing and a new chest is populated from which 20 are selected again randomly for each character and dressed accordingly. The the battle prediction is called again to run the simulation.
  - The **_Chest_** interface is used to construct a chest of gears from the available gears in the game which were created at the time of building. The **_ChestImpl_** class implements the **_Chest_** interface and populates the list of gears to made available to the characters to dress.
  - The **_Character_** interface is implemented by the **_CharacterImpl_** class. All the operations that are to be performed by a character is listed and implemented in these classes. The operations of character are to equip an item and keep track of all the items added or removed, retrieve hit points at any time, modify the hit points when other character attacks, retrieve the current attack and defense strengths, attack a character and replace an item it is wearing if it can find a better one while dressing for battle and discard all the items it is wearing.
  - The **_Clothing_** interface represents an item a character can wear. It is implemented by the **_ClothingImpl_** abstract class to perform the necessary operations. The different types of wearings a character can wear - **_HEADGEAR_**, **_FOOTWEAR_**, **_HANDGEAR_** and **_JEWELRY_** are the extensions of the **_ClothingImpl_** class and implement all the opertaions defined in the **_Clothing_** interface. The features include retrieving the name, description, power, mode, if it is cursed or not, if it is worn out or not, maximum number of times it can be used. It can also keep track of the usage of the items and can compare any given item with itself and return which is better and if it is equal to the other given item.
    > An **enum** _Mode_ is used to define the different modes of an item - **_ATTACK_**, **_DEFENSE_**.

### How To Run
  Instructions to run the **_JAR_** file provided in the **_res/_** folder
  > Use: **_java -jar .\EquippingCharacters.jar_** in the command prompt(Windows).
  > **jdk-11 Java version** is used to compile and build the application.

### How to Use the Program
The **_GameDriver_** class has a **_main_** function that demonstrates all the features of the **_Game_**.
> First, it creates characters and gears. The demonstration contains 3 characters created and 2 each of the gears.
> Second, it builds the game and prints the available characters in the game.
> Third, it populates a chest of gears from the created gears.
> Then it dresses the characters for battle making use of the chest of gears populated. While dressing the characters, information of any item discarded for a better one is printed out.
> Next, it initiates a battle prediction between 2 characters and prints the result of the battle on to the screen.
> Now, it gives the user an option to call a rematch between these 2 characters. The user can enter 'Y' for rematch, 'N' to proceed further. The option to call a rematch is given to the user until he inputs 'N'.
> The battle prediction and the rematch option is executed 2 more times for a different set of characters.
> The message 'Demonstration complete.' is displayed at the end of the program.

### Description of Example Run
```sh
Filename: sampleRun.txt
```
It demonstrates the game by printing details about **_Characters, details of the gears while dressing and the result of the battle prediction**.
> The flow of execution is as follows:
>> Prints the message 'Initializing Game.' at the start of program.
>> Prints the message 'Creating character 'character_name' when characters are created.
>>> Creating character 'Goku'.
>>> Creating character 'Vegeta'.
>>> Creating character 'Gohan'.
>> Prints the message 'Creating headgear 'headgear_name'.' when headgears are created.
>>> Creating headgear 'Potara'.
>>> Creating headgear 'Shades'.
>> Prints the message 'Creating footwear 'footwear_name'.' when footwears are created.
>>> Creating footwear 'Boots'.
>>> Creating footwear 'Sandals'.
>> Prints the message 'Creating handgear 'handgear_name'.' when handgears are created.
>>> Creating handgear 'Sword'.
>>> Creating handgear 'Gloves'.
>> Prints the message 'Creating jewelry 'jewelry_name'.' when jewelry are created.
>>> Creating jewelry 'Scouter'.
>>> Creating jewelry 'Radar'.
>> Prints the message 'Building Game.' while building the **_Game_**.
>> Prints the message 'Printing characters created.' before printing the list of characters created in the game.
>>>Character [
characterName=Goku, characterDescription=Martial Artist, hitpoints=1500, currentAttackPower=1000, currentDefensePower=500, 
]
Character [
characterName=Vegeta, characterDescription=King, hitpoints=1500, currentAttackPower=900, currentDefensePower=600, 
]
Character [
characterName=Gohan, characterDescription=Scholor, hitpoints=1200, currentAttackPower=800, currentDefensePower=400, 
]
>> Prints the message 'Populating chest from available clothing.' when the program populates a chest of gears.
>> Prints the message 'Dressing characters with clothing from chest.' when the program dresses the characters with the selected gears. Information of any discarded gears along with the gears that replace them is printed out.
>>>Goku discarded 
HandGear [clothingName=Sword, clothingDescription=Light, clothingMode=ATTACK, clothingPower=800, isCursed=false, maxUsage=4, isWornOut=false]
and replaced with
HeadGear [clothingName=Shades, clothingDescription=Doom, clothingMode=DEFENSE, clothingPower=400, isCursed=true, maxUsage=1, isWornOut=false]
Goku discarded 
Jewelry [clothingName=Radar, clothingDescription=Tracking, clothingMode=ATTACK, clothingPower=700, isCursed=false, maxUsage=Unlimited, isWornOut=false]
and replaced with
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
Vegeta discarded 
Jewelry [clothingName=Radar, clothingDescription=Tracking, clothingMode=ATTACK, clothingPower=700, isCursed=false, maxUsage=Unlimited, isWornOut=false]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=false]
Vegeta discarded 
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=false]
and replaced with
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
Vegeta discarded 
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=false]
and replaced with
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
Gohan discarded 
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
and replaced with
HeadGear [clothingName=Shades, clothingDescription=Doom, clothingMode=DEFENSE, clothingPower=400, isCursed=true, maxUsage=1, isWornOut=false]
Gohan discarded 
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=false]
and replaced with
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
Gohan discarded 
Jewelry [clothingName=Radar, clothingDescription=Tracking, clothingMode=ATTACK, clothingPower=700, isCursed=false, maxUsage=Unlimited, isWornOut=false]
and replaced with
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
>> Prints the message 'Predicting battle between 'character1_name' and 'character2_name' ' when the battle prediction between the 2 selected characters is called.
>> 'Prediction starts.' is displayed before starting the simulation.
>>>Number of rounds lasted by Goku: 2
Number of rounds lasted by Vegeta: 7
Winner: Vegeta
Do you want a rematch between 'Goku' and 'Vegeta' ? (Y/N)
>>>**User input for the rematch is required when the above message is displayed.** On entering input:
y
Initializing rematch between 'Goku' and 'Vegeta'.
Goku discarded 
HandGear [clothingName=Sword, clothingDescription=Light, clothingMode=ATTACK, clothingPower=800, isCursed=false, maxUsage=4, isWornOut=true]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
Goku discarded 
HandGear [clothingName=Sword, clothingDescription=Light, clothingMode=ATTACK, clothingPower=800, isCursed=false, maxUsage=4, isWornOut=true]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
Goku discarded 
Jewelry [clothingName=Radar, clothingDescription=Tracking, clothingMode=ATTACK, clothingPower=700, isCursed=false, maxUsage=Unlimited, isWornOut=false]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
Goku discarded 
HandGear [clothingName=Sword, clothingDescription=Light, clothingMode=ATTACK, clothingPower=800, isCursed=false, maxUsage=4, isWornOut=true]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
Goku discarded 
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
and replaced with
HeadGear [clothingName=Potara, clothingDescription=Fusion, clothingMode=DEFENSE, clothingPower=200, isCursed=false, maxUsage=3, isWornOut=false]
Vegeta discarded 
HandGear [clothingName=Gloves, clothingDescription=Power, clothingMode=DEFENSE, clothingPower=600, isCursed=false, maxUsage=1, isWornOut=true]
and replaced with
HeadGear [clothingName=Potara, clothingDescription=Fusion, clothingMode=DEFENSE, clothingPower=200, isCursed=false, maxUsage=3, isWornOut=false]
Vegeta discarded 
HandGear [clothingName=Gloves, clothingDescription=Power, clothingMode=DEFENSE, clothingPower=600, isCursed=false, maxUsage=1, isWornOut=true]
and replaced with
HeadGear [clothingName=Shades, clothingDescription=Doom, clothingMode=DEFENSE, clothingPower=400, isCursed=true, maxUsage=1, isWornOut=false]
Vegeta discarded 
HandGear [clothingName=Gloves, clothingDescription=Power, clothingMode=DEFENSE, clothingPower=600, isCursed=false, maxUsage=1, isWornOut=true]
and replaced with
HeadGear [clothingName=Shades, clothingDescription=Doom, clothingMode=DEFENSE, clothingPower=400, isCursed=true, maxUsage=1, isWornOut=false]
Gohan discarded 
Jewelry [clothingName=Radar, clothingDescription=Tracking, clothingMode=ATTACK, clothingPower=700, isCursed=false, maxUsage=Unlimited, isWornOut=false]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
Gohan discarded 
HandGear [clothingName=Sword, clothingDescription=Light, clothingMode=ATTACK, clothingPower=800, isCursed=false, maxUsage=4, isWornOut=true]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
Gohan discarded 
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
and replaced with
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
Gohan discarded 
Jewelry [clothingName=Scouter, clothingDescription=Tracking, clothingMode=DEFENSE, clothingPower=200, isCursed=true, maxUsage=5, isWornOut=true]
and replaced with
HeadGear [clothingName=Potara, clothingDescription=Fusion, clothingMode=DEFENSE, clothingPower=200, isCursed=false, maxUsage=3, isWornOut=false]
Gohan discarded 
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
and replaced with
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
Gohan discarded 
HandGear [clothingName=Sword, clothingDescription=Light, clothingMode=ATTACK, clothingPower=800, isCursed=false, maxUsage=4, isWornOut=true]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
Prediction starts.
Number of rounds lasted by Goku: 0
Number of rounds lasted by Vegeta: 0
Match Tied.

>>>Do you want a rematch between 'Goku' and 'Vegeta' ? (Y/N)
y
Initializing rematch between 'Goku' and 'Vegeta'.


>>>Goku discarded 
Jewelry [clothingName=Scouter, clothingDescription=Tracking, clothingMode=DEFENSE, clothingPower=200, isCursed=true, maxUsage=5, isWornOut=true]
and replaced with
HeadGear [clothingName=Shades, clothingDescription=Doom, clothingMode=DEFENSE, clothingPower=400, isCursed=true, maxUsage=1, isWornOut=false]
Goku discarded 
Jewelry [clothingName=Radar, clothingDescription=Tracking, clothingMode=ATTACK, clothingPower=700, isCursed=false, maxUsage=Unlimited, isWornOut=false]
and replaced with
HeadGear [clothingName=Shades, clothingDescription=Doom, clothingMode=DEFENSE, clothingPower=400, isCursed=true, maxUsage=1, isWornOut=false]
Goku discarded 
HandGear [clothingName=Sword, clothingDescription=Light, clothingMode=ATTACK, clothingPower=800, isCursed=false, maxUsage=4, isWornOut=true]
and replaced with
HeadGear [clothingName=Shades, clothingDescription=Doom, clothingMode=DEFENSE, clothingPower=400, isCursed=true, maxUsage=1, isWornOut=false]
Vegeta discarded 
Jewelry [clothingName=Scouter, clothingDescription=Tracking, clothingMode=DEFENSE, clothingPower=200, isCursed=true, maxUsage=5, isWornOut=true]
and replaced with
HeadGear [clothingName=Shades, clothingDescription=Doom, clothingMode=DEFENSE, clothingPower=400, isCursed=true, maxUsage=1, isWornOut=false]
Vegeta discarded 
Jewelry [clothingName=Scouter, clothingDescription=Tracking, clothingMode=DEFENSE, clothingPower=200, isCursed=true, maxUsage=5, isWornOut=true]
and replaced with
HeadGear [clothingName=Shades, clothingDescription=Doom, clothingMode=DEFENSE, clothingPower=400, isCursed=true, maxUsage=1, isWornOut=false]
Gohan discarded 
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
and replaced with
Footwear [clothingName=Boots, clothingDescription=Flight, clothingMode=ATTACK, clothingPower=400, isCursed=false, maxUsage=Unlimited, isWornOut=false]
Gohan discarded 
HandGear [clothingName=Sword, clothingDescription=Light, clothingMode=ATTACK, clothingPower=800, isCursed=false, maxUsage=4, isWornOut=true]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
Gohan discarded 
HandGear [clothingName=Sword, clothingDescription=Light, clothingMode=ATTACK, clothingPower=800, isCursed=false, maxUsage=4, isWornOut=true]
and replaced with
Footwear [clothingName=Sandals, clothingDescription=Speed, clothingMode=ATTACK, clothingPower=200, isCursed=true, maxUsage=3, isWornOut=true]
Prediction starts.
Number of rounds lasted by Goku: 2
Number of rounds lasted by Vegeta: 0
Winner: Goku

>>>Do you want a rematch between 'Goku' and 'Vegeta' ? (Y/N)
n
Rematch Declined. Proceeding.

> The same process is displayed for 2 other battle predictions with 2 different sets of characters.

> The message 'Demonstration complete.' is printed at the end of the program demonstration.

### Design/Model Changes
> Changes to implement double dispatch for equipping gears to a character have been made.

### Assumptions

> Before starting the game, the game has to be built with the necessary characters and gears. The minimum number of characters is 2 and the minimum number of gears is 1 for each.

> The input to create a character is a non empty **name**, **description**, positive integer value of **basic attack power** and **basic defense power**.

> The input to create a headgear is a non empty **name**, **description**, non negative integer value of **power** and positive integer for maximum number of times an item can be used **maxUse**. If there is no limit on the maximum number of times an item can be used, -1 is to be entered. The mode of the headgear is only **DEFENSE**.

> The input to create a footwear is a non empty **name**, **description**, non negative integer value of **power** and positive integer for maximum number of times an item can be used **maxUse**. If there is no limit on the maximum number of times an item can be used, -1 is to be entered. The mode of the footwear is only **ATTACK**.

> The input to create a handgear is a non empty **name**, **description**, mode of the item **ATTACK** or **DEFENSE** of the **Mode** enumeration, non negative integer value of **power** and positive integer for maximum number of times an item can be used **maxUse**. If there is no limit on the maximum number of times an item can be used, -1 is to be entered. The mode of the handgear can be either **ATTACK** or **DEFENSE** but not both.

> The input to create a jewelry is a non empty **name**, **description**, mode of the item **ATTACK** or **DEFENSE** of the **Mode** enumeration, non negative integer value of **power** and positive integer for maximum number of times an item can be used **maxUse**. If there is no limit on the maximum number of times an item can be used, -1 is to be entered. The mode of the jewelry can be either **ATTACK** or **DEFENSE** but not both.

> If an item is cursed, depending on the mode of the item the respective `currentAttackPower` or `currentDefensePower` is reduced by an amount of the `power` of the item. 

> Every time a character attacks or defends, the usage of item with the corresponding `mode` is incremented. If it is used more than `maxUse`, it is declared as worn-out.

> If an item is worn out, depending on the mode of the item the respective `currentAttackPower` or `currentDefensePower` is reduced by an amount of the `power` of the item.

> While populating chest of gears, a random selection is made from the available list of gears. Duplicates can also be populated in this chest.

> While dressing characters, a random set of 20 items are picked from the chest list populated for each character. But for all characters, the same chest list is used. When we call rematch, the chest is repopulated.

> While dressing, the character does not know if an item is cursed or has limited usage count. Only a high attack power is preferred.

> The `hitPoints` of the character is initially considered to be the sum of `basicAttackPower` and `basicDefensePower`.

> When the gears are equipped to the character, the `currentAttackPower` and `currentDefensePower` are modified and the `hitPoints` is recalculated to be the sum of `currentAttackPower` and `currentDefensePower`.

> When initiating the battle prediction, the `hitPoints`, `currentAttackPower` and `currentDefensePower` are retrieved.

> For each character, the number of rounds it lasts is calculated.

> First it is done for character1. Character 1 defends the attacks of character 2. The calculation of the damage is done in such a way that the `currentDefensePower` is modified for character1 after every attack and `currentAttackPower` is modified if an attack item is worn out for character 2.

> The modification of `currentDefensePower` is if the `currentAttackPower` of character 2 is greater than `currentAttackPower`, then `character1.hitPoints = character2.currentAttackPower - character1.currentDefensePower` and `character1.currentDefensePower = 0`. If `currentAttackPower` of character2 is less than `currentDefensePower` of character1, then `character1.currentDefensePower = character1.currentDefensePower - character2.currentAttackPower`.

> The `currentAttackPower` is modified only when the items wear out and in the case when it goes below `0`, it is reinitialized to `basicAttackPower`.

> If `numberOfRounds` lasted by a character is more than the other, then it is declared a winner. If it is equal for both, it is a tie.
