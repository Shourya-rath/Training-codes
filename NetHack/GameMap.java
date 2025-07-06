public class GameMap {
    private char[][] tiles;

    public GameMap() {
        tiles = new char[20][40];

        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                if (y == 0 || y == tiles.length - 1 || x == 0 || x == tiles[y].length - 1) {
                    tiles[y][x] = '#'; // Wall
                } else {
                    tiles[y][x] = '.'; // Floor
                }
            }
        }
    }

    public char[][] getTiles() {
        return tiles;
    }

    public void render(Player player, Enemy enemy) {
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                if (x == player.getX() && y == player.getY()) {
                    System.out.print('@');
                } else if (x == enemy.getX() && y == enemy.getY()) {
                    System.out.print('E');
                } else {
                    System.out.print(tiles[y][x]);
                }
            }
            System.out.println();
        }
    }
}
