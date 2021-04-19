#include <iostream>

namespace tree_tools {
template <typename T>
void print(T** tree, size_t const n);
template <typename T>
void tree_draw(T** tree, size_t const n, size_t head, std::string lpad);
template <typename T>
void draw_branch(T** tree, size_t const n, size_t head, std::string lpad, bool end);

template <typename T>
void print(T** tree, size_t const n) {
    std::cout << "┬";
    tree_draw<T>(tree, n, 0, "");
}

template <typename T>
void tree_draw(T** tree, size_t const n, size_t root, std::string lpad) {
    const size_t left = root * 2 + 1;
    const size_t right = root * 2 + 2;

    std::cout << *tree[root] << std::endl;

    if (right < n && (tree[left] || tree[right])) {
        draw_branch<T>(tree, n, left, lpad, false);
        draw_branch<T>(tree, n, right, lpad, true);
    }
}

template <typename T>
void draw_branch(T** tree, size_t const n, size_t root, std::string lpad, bool end) {
    const size_t left = root * 2 + 1;
    const size_t right = root * 2 + 2;

    std::cout << lpad << (end ? "└" : "├") /* << "─" */;
    if (right >= n || !(tree[left] || tree[right])) {
        std::cout << "─";
        if (tree[root])
            std::cout << *tree[root];
        std::cout << std::endl;
    } else {
        std::cout << "┬";
        tree_draw<T>(tree, n, root, lpad.append((end ? " " : "│")));
    }
}

}  // namespace tree_tools