import java.util.Scanner;

public class GameEngine {
    private GameMap map;
    private Player player;
    private Enemy enemy;
    private boolean isRunning;

    public GameEngine() {
        map = new GameMap();
        player = new Player(5, 5);
        enemy = new Enemy(10, 5);
        isRunning = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            utils.TerminalUtils.clearScreen();
            map.render(player, enemy);

            System.out.print("Move (WASD): ");
            String input = scanner.nextLine();
            handleInput(input);

            enemy.move(map.getTiles());

            // Collision detection
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                utils.TerminalUtils.clearScreen();
                map.render(player, enemy);
                System.out.println("Game Over! You were caught by an enemy.");
                isRunning = false;
            }
        }
    }

    private void handleInput(String input) {
        switch (input.toLowerCase()) {
            case "w": player.move(0, -1, map.getTiles()); break;
            case "s": player.move(0, 1, map.getTiles()); break;
            case "a": player.move(-1, 0, map.getTiles()); break;
            case "d": player.move(1, 0, map.getTiles()); break;
        }
    }
}
