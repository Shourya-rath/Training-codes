# Content
- [Content](#content)
  - [🗺️ **ASCII Roguelike Game in Java – Module Roadmap**](#️-ascii-roguelike-game-in-java--module-roadmap)
    - [🔰 **Module 1: Rendering an ASCII Player on a Static Map**](#-module-1-rendering-an-ascii-player-on-a-static-map)
    - [🕹️ **Module 2: Handling Player Movement**](#️-module-2-handling-player-movement)
    - [👾 **Module 3: Basic Enemies and Turn-Based Mechanics**](#-module-3-basic-enemies-and-turn-based-mechanics)
    - [⚔️ **Module 4: Combat System**](#️-module-4-combat-system)
    - [🧭 **Module 5: Map Boundaries and Simple Level Layout**](#-module-5-map-boundaries-and-simple-level-layout)
    - [🧠 **Module 6: Simple AI for Enemies and Pets**](#-module-6-simple-ai-for-enemies-and-pets)
    - [🎒 **Module 7: Inventory and Items**](#-module-7-inventory-and-items)
    - [🧱 **Module 8: Procedural Map Generation**](#-module-8-procedural-map-generation)
    - [🧙 **Module 9: RPG Elements**](#-module-9-rpg-elements)
    - [💾 **Module 10: Save/Load System**](#-module-10-saveload-system)
    - [🧪 **Module 11: Polish, Logging, and Refactoring**](#-module-11-polish-logging-and-refactoring)
  - [Notes for module 2](#notes-for-module-2)
  - [✅ **Progress Summary (Modules 1–2)**](#-progress-summary-modules-12)
    - [🧱 **Module 1: Rendering an ASCII Player on a Static Map**](#-module-1-rendering-an-ascii-player-on-a-static-map-1)
      - [📌 What We Built:](#-what-we-built)
      - [🛠 Key Concepts:](#-key-concepts)
    - [🕹️ **Module 2: Handling Player Movement**](#️-module-2-handling-player-movement-1)
      - [📌 What We Built:](#-what-we-built-1)
      - [🛠 Key Concepts:](#-key-concepts-1)
      - [🧼 Visual Polish:](#-visual-polish)
    - [🧠 What You’ve Learned So Far:](#-what-youve-learned-so-far)


---

## 🗺️ **ASCII Roguelike Game in Java – Module Roadmap**

### 🔰 **Module 1: Rendering an ASCII Player on a Static Map**

* Create a 2D char array as the map
* Place `@` as the player symbol
* Display the map in the console

---

### 🕹️ **Module 2: Handling Player Movement**

* Capture keyboard input (WASD)
* Update player’s position
* Redraw the map after every move
* Prevent walking into walls

---

### 👾 **Module 3: Basic Enemies and Turn-Based Mechanics**

* Add basic enemies (`E`) on the map
* Implement simple turn-based system: player acts → enemies act
* Basic enemy movement logic

---

### ⚔️ **Module 4: Combat System**

* Add health to player and enemies
* Attack system: collide = fight
* Display combat messages in a log panel

---

### 🧭 **Module 5: Map Boundaries and Simple Level Layout**

* Create walls (`#`), floor (`.`), doors (`+`)
* Handle map collision
* Build a simple dungeon layout

---

### 🧠 **Module 6: Simple AI for Enemies and Pets**

* Add a dog companion that follows and attacks
* Add enemy AI that chases the player
* Add randomness or basic pathfinding

---

### 🎒 **Module 7: Inventory and Items**

* Create and pick up items (`!`, `?`, `)`)
* Add a basic inventory system
* Equip weapons, use consumables

---

### 🧱 **Module 8: Procedural Map Generation**

* Generate random rooms + corridors
* Spawn player and enemies in safe spots
* Add stairs and multiple dungeon levels

---

### 🧙 **Module 9: RPG Elements**

* Add leveling, XP, stats (STR, INT, etc.)
* Skills or special abilities
* Pets level up or gain loyalty

---

### 💾 **Module 10: Save/Load System**

* Store game state in a file
* Load saved game
* Handle restart, quit, death

---

### 🧪 **Module 11: Polish, Logging, and Refactoring**

* Add message log
* Organize code into packages
* Add reusable utility methods and structure

## Notes for module 2
- System.out.print("\033[H\033[2J");
> \033[H makes sure that the cursor is at the top of terminal
> \033[2J makes sure that the screen is cleared for next o/p
- // used ternary opereaor to make # and . in the borders and the floor

## ✅ **Progress Summary (Modules 1–2)**

---

### 🧱 **Module 1: Rendering an ASCII Player on a Static Map**

#### 📌 What We Built:

* A **10x10 2D char array** representing a game map.
* Map symbols:

  * `#` = Wall (map boundary)
  * `.` = Floor (walkable space)
  * `@` = Player

#### 🛠 Key Concepts:

* Declared and initialized a 2D character array.
* Used loops to fill the map with floor and border walls.
* Printed the map to the terminal using nested `for` loops.

---

### 🕹️ **Module 2: Handling Player Movement**

#### 📌 What We Built:

* A basic **WASD movement system** for the player (`@`).
* The player can move around the map, one step at a time.
* Movement is blocked by walls (`#`).

#### 🛠 Key Concepts:

* Read keyboard input using `Scanner`.
* Updated player position (`playerX`, `playerY`) based on key input.
* Added **input handling logic** to:

  * Detect wall collisions
  * Replace the old position with `.` and move `@` to the new location

#### 🧼 Visual Polish:

* Added a `clearScreen()` method using ANSI escape codes to **refresh the terminal screen** each time the map updates.

---

### 🧠 What You’ve Learned So Far:

| Concept           | Description                                  |
| ----------------- | -------------------------------------------- |
| 2D Arrays         | Used to represent a tile-based map           |
| ASCII Characters  | Render visual elements in the terminal       |
| Player State      | Track position with `playerX`, `playerY`     |
| Input Handling    | Used `Scanner` to detect `WASD` movement     |
| Game Loop         | Basic loop for input + update + render cycle |
| Terminal Clearing | Used ANSI codes to simulate screen refresh   |

---



