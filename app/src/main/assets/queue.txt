
A **Queue** is a linear data structure that operates on the **FIFO (First In, First Out)** principle. This means that the first element added to the queue is the first one to be removed, much like a line of people waiting for service.

---

### Key Operations of a Queue:
1. **Enqueue**: Add an element to the back of the queue.
2. **Dequeue**: Remove and return the element from the front of the queue.
3. **Peek (or Front)**: Retrieve the front element without removing it.
4. **IsEmpty**: Check if the queue is empty.

---

### Types of Queues:
1. **Simple Queue**: Operates on basic FIFO principles.
2. **Circular Queue**: Connects the end of the queue back to the front to optimize space.
3. **Priority Queue**: Each element is assigned a priority, and higher-priority elements are dequeued first.
4. **Deque (Double-Ended Queue)**: Allows insertion and deletion from both ends.

---

### Use Cases of Queue:
Queues are best suited for scenarios involving **sequential processing** or **waiting lines**. Common use cases include:

1. **Task Scheduling**:
   - Used in operating systems for process scheduling.
   - Example: CPU task queues or print job management.

2. **Breadth-First Search (BFS)**:
   - In graph or tree traversal, queues are used to explore nodes level by level.

3. **Data Streaming**:
   - Real-time processing of data streams (e.g., queues in messaging systems like Kafka or RabbitMQ).

4. **Resource Management**:
   - Managing resources like tickets, requests in web servers, or handling customer service queues.

5. **Order Preservation**:
   - Ensuring that elements are processed in the same order as they arrive.

---

### Example Problem: **Simulating a Queue**
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue elements
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Dequeue and display elements
        while (!queue.isEmpty()) {
            System.out.println(queue.remove()); // Outputs 1, 2, 3
        }
    }
}
```

---

### When to Use a Queue:
- When tasks need to be processed **in the order they arrive**.
- In problems requiring **level-by-level traversal** (e.g., BFS in graphs).
- For **buffering** in scenarios like data streaming or IO operations.

