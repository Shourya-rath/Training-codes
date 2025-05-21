import pygame
import sys

# Initialize Pygame
pygame.init()

# Constants
BOARD_SIZE = 8
SQUARE_SIZE = 60
WIDTH, HEIGHT = BOARD_SIZE * SQUARE_SIZE, BOARD_SIZE * SQUARE_SIZE
LIGHT_GREEN = (255,255,255)  # Light green color
DARK_GREEN = (128,128,128)       # Dark green color

# Set up display
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Simple Chess")

# Load images
def load_images():
    pieces = ['wP', 'wR', 'wN', 'wB', 'wQ', 'wK', 'bP', 'bR', 'bN', 'bB', 'bQ', 'bK']
    images = {}
    for piece in pieces:
        images[piece] = pygame.transform.scale(pygame.image.load(f'images/{piece}.png'), (SQUARE_SIZE, SQUARE_SIZE))
    return images

images = load_images()

# Chess board setup
def initialize_board():
    board = [
        ['bR', 'bN', 'bB', 'bQ', 'bK', 'bB', 'bN', 'bR'],
        ['bP', 'bP', 'bP', 'bP', 'bP', 'bP', 'bP', 'bP'],
        ['--', '--', '--', '--', '--', '--', '--', '--'],
        ['--', '--', '--', '--', '--', '--', '--', '--'],
        ['--', '--', '--', '--', '--', '--', '--', '--'],
        ['--', '--', '--', '--', '--', '--', '--', '--'],
        ['wP', 'wP', 'wP', 'wP', 'wP', 'wP', 'wP', 'wP'],
        ['wR', 'wN', 'wB', 'wQ', 'wK', 'wB', 'wN', 'wR']
    ]
    return board

# Draw the board and pieces
def draw_board(board):
    for row in range(BOARD_SIZE):
        for col in range(BOARD_SIZE):
            # Alternate colors for squares
            square_color = LIGHT_GREEN if (row + col) % 2 == 0 else DARK_GREEN
            pygame.draw.rect(screen, square_color, pygame.Rect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE))
            piece = board[row][col]
            if piece != '--':
                screen.blit(images[piece], (col * SQUARE_SIZE, row * SQUARE_SIZE))
    pygame.display.flip()

# Basic move validation function (placeholder)
def is_valid_move(start_pos, end_pos, board, current_turn):
    # Placeholder for actual move validation logic
    return board[end_pos[0]][end_pos[1]] == '--' or board[end_pos[0]][end_pos[1]].startswith('b') != current_turn.startswith('b')

# Main game loop
def main():
    board = initialize_board()
    selected_piece = None
    current_turn = 'w'  # White starts
    running = True

    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.MOUSEBUTTONDOWN:
                x, y = pygame.mouse.get_pos()
                col, row = x // SQUARE_SIZE, y // SQUARE_SIZE
                if selected_piece is None:
                    if board[row][col] != '--' and board[row][col].startswith(current_turn):
                        selected_piece = (row, col)
                else:
                    if is_valid_move(selected_piece, (row, col), board, current_turn):
                        board[row][col], board[selected_piece[0]][selected_piece[1]] = board[selected_piece[0]][selected_piece[1]], '--'
                        current_turn = 'b' if current_turn == 'w' else 'w'  # Switch turns
                    selected_piece = None
        draw_board(board)

if __name__ == "__main__":
    main()