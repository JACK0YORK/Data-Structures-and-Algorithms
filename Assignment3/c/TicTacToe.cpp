#include <cstdarg>
#include <cstdlib>
#include <ctime>
#include <iostream>
#include <string>

const int paths[24] = {0, 1, 2,  // Rows
                       3, 4, 5,
                       6, 7, 8,
                       0, 3, 6,  // Columns
                       1, 4, 7,
                       2, 5, 8,
                       0, 4, 8,  // Diags
                       2, 4, 6};

const int X = 1, O = -1, UNRESOLVED = 99, NONE = 0;

struct Board {
    int arr[9];

    int result() {
        bool full = true;
        for (int i = 0; i < 24; i += 3) {
            if (full && (!arr[paths[i]] || !arr[paths[i + 1]] || !arr[paths[i + 2]]))
                full = false;
            const auto sum = arr[paths[i]] + arr[paths[i + 1]] + arr[paths[i + 2]];
            if (sum * sum == 9)
                return arr[paths[i]];
        }
        return full ? NONE : UNRESOLVED;
    }

    int &operator[](size_t const &i) {
        return arr[i];
    }

    Board copy() {
        Board copyBoard;
        for (size_t j = 0; j < 9; j++)
            copyBoard[j] = arr[j];
        return copyBoard;
    }
    friend std::ostream &operator<<(std::ostream &o, Board &b) {
        for (size_t i = 0; i < 3; i++) {
            for (size_t j = 0; j < 3; j++) {
                const auto val = b[3 * i + j];
                std::cout << (val == X ? " X " : (val == O ? " O " : "   ")) << (j < 2 ? "|" : "");
            }
            std::cout << (i < 2 ? "\n---+---+---\n" : "\n");
        }
    }
};

class Tree {
   public:
    Tree *parent = nullptr, *leftChild = nullptr, *rightSibling = nullptr;
    int player;  // whose turn is it?
    Board board;
    int eval;  // who is winning?

    Tree(Tree *parent, Board board) {
        this->parent = parent;

        this->player = parent ? -parent->player : X;

        this->board = board;

        this->eval = this->board.result();  // base case: -1, 0, 1
                                            // unresolved case: 99

        if (this->eval == UNRESOLVED) {
            int max = -1;
            for (size_t i = 0; i < 9; i++)
                if (this->board[i] == 0) {
                    // Create Child Board with change in position i
                    Board childBoard = board.copy();
                    childBoard[i] = player;
                    // Add Child
                    Tree *child = new Tree(this, childBoard);
                    child->rightSibling = this->leftChild;
                    this->leftChild = child;
                    // Set max to the evaluation of this child.
                    if (this->leftChild->eval * player > max)
                        max = this->leftChild->eval * player;
                }
            this->eval = player * max;
        }
    }
};

template <typename T>
T max(T *array, bool lessThanFunc(T, T)) {
    size_t n = sizeof(array) / sizeof(T);
    T max = array[0];
    for (size_t i = 1; i < n; i++) {
        if (lessThanFunc(max, array[i])) {
            max = array[i];
        }
    }
}

Tree *minimax(Tree *tree) {
    Tree *max = tree->leftChild;
    for (auto i = max->rightSibling; i != nullptr; i = i->rightSibling) {
        const auto diff = (max->eval - i->eval) * tree->player;
        if (diff < 0)
            max = i;
        if ((diff == 0) && !(rand() % 5))
            max = i;
    }
    return max;
}

Tree *posNotZero(Tree *tree, int position) {
    for (auto i = tree->leftChild; i != nullptr; i = i->rightSibling)
        if (i->board[position] != 0)
            return i;
}

int promptCoords(Tree *tree) {
    int x, y, pos;
    while (true) {
        std::string input;
        std::cout << "Enter coordinates: (x y)" << std::endl;
        std::getline(std::cin, input);
        int x_pos = input.find_first_of("1234567890");
        int y_pos = input.find_first_of("1234567890", x_pos + 1);
        if ((x_pos == -1) || (y_pos == -1)) {
            std::cout << "Invalid input, please input at least 2 numbers." << std::endl;
            continue;
        }
        x = input[x_pos] - '0';
        y = input[y_pos] - '0';

        if (!(x >= 1 && x <= 3 && y >= 1 && y <= 3)) {
            std::cout << "Invalid coordinates, values not in the range [1,3]." << std::endl;
            continue;
        }
        pos = 3 * y + x - 4;
        if (tree->board[pos] != 0) {
            std::cout << "Invalid coordinates, position already taken." << std::endl;
            continue;
        }
        break;
    }
    return pos;
}

bool promptYN(const char *message) {
    std::string input;
    std::cout << message;
    std::getline(std::cin, input);
    size_t ypos = input.find_first_of("Yy");
    size_t npos = input.find_first_of("Nn");
    return ypos <= npos;
}

int playGame(Tree *tree) {
    bool human_first = promptYN("Wanna go first? (y/n)\n");
    while (tree->board.result() == UNRESOLVED) {
        if ((human_first && tree->player == 1) || (!human_first && tree->player == -1)) {
            // player turn
            std::cout << tree->board << /* "Eval: " << tree->eval <<  */ "\n\n";
            int pos = promptCoords(tree);
            tree = posNotZero(tree, pos);
        } else {
            // robot turn
            tree = minimax(tree);
        }
    }
    int res = tree->eval;
    std::cout << "\n"
              << tree->board << "\nWinner: ";
    std::cout << (res == 1 ? "X" : (res == -1 ? "O" : "C")) << std::endl;
    return res;
}

int main(int argc, char const *argv[]) {
    Board b = {0, 0, 0,
               0, 0, 0,
               0, 0, 0};
    srand(time(0));
    Tree *main_t = new Tree(nullptr, b);
    while (true) {
        playGame(main_t);
        // std::cout << "Play Again? (y/n)" << std::endl;
        if (promptYN("\nPlay Again? (y/n)\n")) {
            continue;
        }
        break;
    }

    return 0;
}