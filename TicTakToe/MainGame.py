import random


# displaying the game board:
def display_board(board):
    print(board[7] + '  | ' + board[8] + ' | ' + board[9])
    print('---|---|---')
    print(board[4] + '  | ' + board[5] + ' | ' + board[6])
    print('---|---|---')
    print(board[1] + '  | ' + board[2] + ' | ' + board[3])


# test_board = [' ']*10
# display_board(test_board)


# taking player's choice on marker:
def player_input():
    player1_choice = 'wrong'
    while player1_choice not in ['X', 'O']:
        player1_choice = input("player1 please enter your choice! (X or O) :")
        if player1_choice not in ['X', 'O']:
            print("invalid choice")

    if player1_choice == 'X':
        player2_choice = 'O'
    else:
        player2_choice = 'X'
    return player1_choice, player2_choice


# player_1_marker, player_2_marker = player_input()
# print('player1:', player_1_marker)
# print('player2:', player_2_marker)


# assignment of player choice in the board:
def place_marker(board, marker, position):
    board[position] = marker


# # place_marker(test_board, 'X', 8)
# place_marker(test_board, 'X', 9)
# place_marker(test_board, 'X', 7)
# # place_marker(test_board, 'X', 8)
# place_marker(test_board, 'X', 4)
# place_marker(test_board, 'X', 2)
# place_marker(test_board, 'X', 5)
# place_marker(test_board, 'X', 1)
# display_board(test_board)


# to check winner
def win_check(board, mark):
    if board[7] == board[8] == board[7] == mark:
        return True
    elif board[4] == board[5] == board[6] == mark:
        return True
    elif board[1] == board[2] == board[3] == mark:
        return True
    elif board[7] == board[4] == board[1] == mark:
        return True
    elif board[8] == board[5] == board[2] == mark:
        return True
    elif board[9] == board[6] == board[1] == mark:
        return True
    elif board[9] == board[5] == board[1] == mark:
        return True
    elif board[7] == board[5] == board[3] == mark:
        return True
    else:
        return False


# print(win_check(test_board, 'X'))


# choosing whom to start first
def choose_first():
    flip = random.randint(0, 1)
    if flip == 0:
        return 'Player 1'
    else:
        return 'Player 2'


# checking space for placing the marker
def space_check(board, position):
    return board[position] == ' '


# checking if the board is full
def full_board_check(board):
    for i in range(1, 10):
        if space_check(board, i):
            return False
    return True


# asking the player for position
def player_choice(board):
    position = 0
    while position not in range(1, 10) or not space_check(board, position):
        position = int(input('choose a position (1-9):'))
        if position not in range(1, 10):
            print('Invalid Value')
    return position


# asking player to play again
def replay():
    choice = '0'
    while choice not in ['yes', 'no']:
        choice = input('Play again? Enter Yes or No:')
        if choice not in ['yes', 'no']:
            print('Invalid value')
    return choice == 'yes'


# assembling the parts of the game
print('Welcome to Tic Tac Toe!')

while True:
    the_board = [' ']*10
    display_board(the_board)
    player_1_mark, player_2_mark = player_input()
    turn = choose_first()
    print(turn + ' will go first')
    play_game = input('Ready to play? y or n:')
    if play_game == 'y':
        game_on = True
    else:
        game_on = False
    while game_on:
        if turn == 'Player 1':

            print('player 1 turn!')
            pos = player_choice(the_board)
            place_marker(the_board, player_1_mark, pos)
            display_board(the_board)
            if win_check(the_board, player_1_mark):
                print('Congratulations player 1, you have won the game!')
                break
            elif full_board_check(the_board):
                print('Tie Game!')
                break
            else:
                turn = 'Player 2'

        else:

            print('player 2 turn!')
            pos = player_choice(the_board)
            place_marker(the_board, player_2_mark, pos)
            display_board(the_board)
            if win_check(the_board, player_2_mark):
                print('Congratulations player 2, you have won the game!')
                break
            elif full_board_check(the_board):
                print('Tie Game!')
                break
            else:
                turn = 'Player 1'
    if not replay():
        break
