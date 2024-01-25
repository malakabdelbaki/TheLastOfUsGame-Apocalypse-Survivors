# The Last Of Us: Apocalypse Survivors

## Overview

Welcome to Apocalypse Survivors, a turn-based single-player survival game set in a post-apocalyptic world infested with zombies. In a turn each player character receives a specific number of action points per turn, which they can use to move, attack or cure zombies, or use special actions. Inspired by the intense atmosphere of The Last Of Us, this game challenges players to strategically navigate a grid-based map, cure zombies, and build a community to survive the apocalypse.

**Start Scene**
![Uploading Screenshot 2024-01-24 223207.png…]()


**Choose starting hero**
![Uploading Screenshot 2024-01-24 223238.png…]()

![Uploading Screenshot 2024-01-24 223404.png…]()

![Uploading Screenshot 2024-01-24 223342.png…]()


*Explorer Special Action**
*![Uploading Screenshot 2024-01-24 223418.png…]()


**Win Scene**

![Uploading Screenshot 2024-01-24 223547.png…]()

**Loss Scene**

![Uploading Screenshot 2024-01-24 223651.png…]()

## Project Structure

### 1. `engine`

- **Game Class**: Represents the game as a 2D grid, tracking heroes, zombies, and collectibles.
- **Heroes.csv**: File containing available heroes and their attributes.
- **Game Setup**: Initializes the game with 10 collectibles (5 Vaccines, 5 Supplies), 5 traps, 10 zombies, and the player's hero at the bottom left corner.
- **Turn Mechanics**: Players use action points to move, attack, cure zombies, or perform special actions.
- **Visibility Update**: Map visibility is updated based on heroes' locations.
- **End Turn**: Zombies attack, hero actions reset, map visibility updates, and a new zombie spawns.

### 2. `exceptions`

- **GameActionException**: Generic exception class with subclasses:
    - **InvalidTargetException**: Occurs when targeting the wrong character.
    - **MovementException**: Arises from invalid character movement.
    - **NoAvailableResourcesException**: Triggered when using an unavailable collectible.
    - **NotEnoughActionsException**: Happens when a character lacks sufficient action points.

### 3. `model.characters`

- **Character Interface**: Represents the two different types of characters available in the game : Heroes and Zombies. 
A character has a name, a location, attack damage ( represents the damage inflicted by the character on its target when attacking) and initial health points decrease as they get attacked, defend themselves or step into a trap cell (in case of a Hero).  Any character can select a target in its adjacent cells and attack it. Characters automatically defend themselves in the event of getting attacked. Whenever a character’s health points reaches 0, they are considered dead.

### Heroes

Heroes are the types of characters that the player can control. There are several types of heroes available in the game, each one provides different assets for the player in order to win the game. Considering that the aim of the game is to build a large enough community to survive the apocalypse thus the player must try to maintain and protect their heroes at all costs, as well as try to expand their available pool of heroes. Each hero type has a unique action they can add to the player’s team. A hero starts with an initial amount of health points that decrease as they do different actions.

- Possible actions that can be done by a Hero:
    - Move : left, right, up and down
    - Attack a zombie
    - Cure a zombie using collected vaccines
    - Use their special actions
- **Hero Types and their special actions**:
    - **Fighter**: Can attack multiple times for one turn when a supply is used.
    - **Medic**: Can heal other heroes or themselves when a supply is used.
    - **Explorer**: Can see the entire map for one turn when a supply is used.

### **Zombie**

Zombies are the types of characters that threaten the player during the game. Zombies cannot be controlled, however they can be cured or attacked. Each time a zombie is killed another zombie will spawn somewhere on the map. In addition to extra zombies spawning every time the player ends a turn. Whenever a zombie is cured an extra hero will take its place and be available for the player to use in future turns. Zombies all have 40 health points, 10 attack damage, and are named according to how many Zombie objects have been created.

### 4. `model.collectibles`

Collectibles are scattered objects across the map that can help the player survive and advance in the game. Each collectible is only usable once, and after that is discarded from the hero’s inventory and cannot be reused.

- **Collectible Interface**: Defines methods for all collectibles.
- **Vaccines**: Essential for winning the game by curing zombies and recruiting new heroes.
- **Supplies**: Enables heroes to use special actions.

### 5. `model.world`

- **Cell Class**: Represents different cell types in the game. At the start of a turn, all cells are invisible except for the 8 cells surrounding each hero:
    - **CharacterCell**: Contains a character.
    - **CollectibleCell**: Contains a collectible item.
    - **TrapCell**: Contains a trap, reducing a hero's health if stepped on.

### 6. `tests`

- Unit tests ensuring the correctness of various game components.

### 7. `views`

- UI components for presenting the game to the player.

## Gameplay Flow

The player starts by choosing 1 player to begin playing and accumulates more heroes as their heroes cure zombies. During the game, once there are more than 1 hero available on the grid, player may freely alternate between their heroes. The initial game setup, is as such : 10 collectibles (5 Vaccines, 5 Supplies), 5 traps , 10 zombies are spawned randomly around the map, and the hero is allocated to the bottom left corner of the map.

During the game, a player may choose to end the current turn, then all zombies attempt to attack an adjacent hero (if exists), as well as reset each hero’s actions, target, and special, update the map visibility in the game such that only cells adjacent to heroes are visible, and finally spawn a zombie randomly on the map.

## Win or Loss

- **Win**: Collect and use all vaccines, with at least 5 heroes alive.
- **Loss**: All heroes defeated by zombies.

Get ready for an immersive experience in Apocalypse Survivors – where every decision matters, and survival is the ultimate goal!
