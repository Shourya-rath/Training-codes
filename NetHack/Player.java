
public class Player {
    
    private int x, y;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move(int dx, int dy, char[][] map) {
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
