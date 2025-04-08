
A **Stack** is a linear data structure that follows the **LIFO (Last In, First Out)** principle, meaning the last element added to the stack is the first one to be removed.

---

### Key Features of Stack:
1. **Push**: Adds an element to the top of the stack.
2. **Pop**: Removes and returns the top element of the stack.
3. **Peek/Top**: Retrieves the top element without removing it.
4. **IsEmpty**: Checks if the stack is empty.

---

### How It Works:
- A stack can be implemented using arrays or linked lists.
- Operations are typically restricted to one end of the stack, called the **top**.
- The stack grows and shrinks dynamically as elements are added or removed.

---

### Common Use Cases of Stack:
1. **Reversing Data**:
   - Strings or data sequences can be reversed using a stack.
2. **Expression Evaluation and Conversion**:
   - Stacks are used for evaluating postfix expressions and converting infix expressions to postfix or prefix.
3. **Backtracking**:
   - E.g., solving a maze, undo functionality in text editors, or parsing problems.
4. **Function Call Management**:
   - The call stack in programming manages function calls and returns.
5. **Depth-First Search (DFS)**:
   - DFS in trees or graphs uses a stack to keep track of visited nodes.
6. **Balanced Parentheses or Bracket Matching**:
   - A stack is used to ensure every opening bracket has a matching closing bracket.
7. **Undo/Redo Operations**:
   - Used in applications like text editors for tracking changes.

---

### Example of a Stack Problem: **Balanced Brackets**
```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
        if (ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((ch == ')' && top != '(') ||
                (ch == '}' && top != '{') ||
                (ch == ']' && top != '[')) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```

---

### When to Use a Stack:
1. When the **order of operations** is important and you need to process the most recent task first.
2. In problems involving **nested structures**, such as parsing expressions, tags, or parentheses.
3. When implementing algorithms like **DFS**, backtracking, or handling recursive problems iteratively.

---

### Advantages:
- Simple and efficient for certain operations.
- Intuitive for problems requiring LIFO order.

### Limitations:
- Limited size if implemented using arrays (fixed size).
- Does not allow random access to elements.

---
