// import java.util.*;

// public class RoguelikeGame {
//     static final int WIDTH = 10;
//     static final int HEIGHT = 10;

//     static char[][] map = new char[HEIGHT][WIDTH];
//     static int playerX = 1;
//     static int playerY = 1;

//     static List<Enemy> enemies = new ArrayList<>();
//     static Random random = new Random();

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         initializeMap();
//         spawnEnemies();

//         while (true) {
//             renderMap();

//             System.out.print("Move (WASD): ");
//             String input = scanner.nextLine().toUpperCase();
//             if (!input.isEmpty()) {
//                 handlePlayerInput(input.charAt(0));
//                 moveEnemies();
//             }

//             clearScreen();
//         }
//     }

//     static void initializeMap() {
//         for (int y = 0; y < HEIGHT; y++) {
//             for (int x = 0; x < WIDTH; x++) {
//                 map[y][x] = (x == 0 || y == 0 || x == WIDTH - 1 || y == HEIGHT - 1) ? '#' : '.';
//             }
//         }
//         map[playerY][playerX] = '@';
//     }

//     static void spawnEnemies() {
//         enemies.add(new Enemy(3, 3));
//         enemies.add(new Enemy(6, 5));
//         for (Enemy e : enemies) {
//             map[e.y][e.x] = 'E';
//         }
//     }

//     static void handlePlayerInput(char move) {
//         int newX = playerX;
//         int newY = playerY;

//         switch (move) {
//             case 'W': newY--; break;
//             case 'S': newY++; break;
//             case 'A': newX--; break;
//             case 'D': newX++; break;
//             default: return;
//         }

//         if (map[newY][newX] == '.') {
//             map[playerY][playerX] = '.';
//             playerX = newX;
//             playerY = newY;
//             map[playerY][playerX] = '@';
//         }
//     }

//     static void moveEnemies() {
//         for (Enemy e : enemies) {
//             int dx = 0, dy = 0;

//             switch (random.nextInt(4)) {
//                 case 0: dy = -1; break; // Up
//                 case 1: dy = 1; break;  // Down
//                 case 2: dx = -1; break; // Left
//                 case 3: dx = 1; break;  // Right
//             }

//             int newX = e.x + dx;
//             int newY = e.y + dy;

//             // Don't move if wall or player or another enemy
//             if (map[newY][newX] == '.') {
//                 map[e.y][e.x] = '.';
//                 e.x = newX;
//                 e.y = newY;
//                 map[e.y][e.x] = 'E';
//             }
//         }
//     }

//     static void renderMap() {
//         for (int y = 0; y < HEIGHT; y++) {
//             for (int x = 0; x < WIDTH; x++) {
//                 System.out.print(map[y][x]);
//             }
//             System.out.println();
//         }
//     }

//     static void clearScreen() {
//         System.out.print("\033[H\033[2J");
//         System.out.flush();
//     }
// }

// class Enemy {
//     int x, y;
//     Enemy(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
// }
