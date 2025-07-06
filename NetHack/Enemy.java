import java.util.Random;

public class Enemy {
    private int x, y;
    private Random rand = new Random();

    public Enemy(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move(char[][] map) {
        int dx = rand.nextInt(3) - 1; // -1, 0, 1
        int dy = rand.nextInt(3) - 1;

        int newX = x + dx;
        int newY = y + dy;

        if (map[newY][newX] != '#') {
            x = newX;
            y = newY;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
