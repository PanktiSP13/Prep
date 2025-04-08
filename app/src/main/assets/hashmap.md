
A **HashMap** is a data structure in Java that stores key-value pairs. It provides efficient retrieval, insertion, and deletion operations with an average time complexity of **O(1)** due to its use of **hashing**.

### Key Concepts of HashMap
1. **Key-Value Pairs**: Data is stored as pairs, where each key maps to a value.
2. **Hashing**: A hash function computes an index (hash code) for each key, determining where its value will be stored in an internal array called a **bucket array**.
3. **Buckets**: Each position in the bucket array can store one or more key-value pairs. If two keys generate the same hash code (collision), both are stored in the same bucket.

---

### How HashMap Works Internally
1. **Structure**:
   - A **HashMap** is backed by an array of **Node<K, V>** or **Entry<K, V>**, where each node stores a key, a value, a hash code, and a pointer to the next node (in case of collisions).

2. **Hash Function**:
   - When a key is added, a hash function is applied to generate its hash code.
   - The hash code is further processed using **index = hash % array_size** to determine the array position (bucket index).

3. **Adding an Entry**:
   - If the bucket at the calculated index is empty, the key-value pair is stored directly.
   - If there’s already a key-value pair in the bucket, a **collision resolution** strategy is applied:
     - **Separate Chaining**: The bucket is implemented as a linked list or a tree. New entries are added as nodes in the list or tree.
   - If the key already exists, its value is updated.

4. **Collision Handling**:
   - Earlier versions of HashMap used a **linked list** to resolve collisions.
   - Starting from Java 8, if the number of entries in a bucket exceeds a threshold (e.g., 8), the linked list is converted to a **balanced binary tree** to optimize lookup performance.

5. **Retrieving a Value**:
   - The hash code for the key is computed, and the bucket index is determined.
   - The bucket is scanned to find the matching key. If multiple entries are present, the search is done either in the linked list or the binary tree.

6. **Rehashing**:
   - If the load factor (default is 0.75) is exceeded, the HashMap resizes its bucket array (doubles in size).
   - During resizing, all existing entries are redistributed to the new buckets based on their updated hash codes.

---

### Advantages of HashMap
- Fast data access with **O(1)** on average for basic operations.
- Dynamic resizing ensures optimal performance even as the data grows.

### Limitations
- It does not maintain the insertion order (use **LinkedHashMap** if order is required).
- Not thread-safe (use **ConcurrentHashMap** for multi-threaded environments).

---

### Example:
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("Alice", 25); // Add a key-value pair
map.put("Bob", 30);   // Add another key-value pair
System.out.println(map.get("Alice")); // Retrieve value: 25
```
