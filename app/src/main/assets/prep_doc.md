# 📱 Coroutines, Android Concepts & DSA in Kotlin

---

## 🔄 Coroutines in Android

Coroutines are the recommended solution for asynchronous programming on Android.

- **Lightweight and Efficient**:  
  Coroutines are lightweight and super fast compared to traditional threads. While threads are managed by the operating system, coroutines are managed at the user level, making them more efficient.  
  You can run thousands of coroutines simultaneously with minimal overhead, whereas managing even tens of threads can become resource-intensive.

### 🌐 GlobalScope
- `GlobalScope` is a top-level `CoroutineScope` that operates throughout the entire lifecycle of the application.
- Coroutines launched in `GlobalScope` will keep running as long as the application is alive.
- Suitable for background tasks that are not tied to any specific component lifecycle.

---

## 📚 Computer Science Fundamentals

### 🧩 Data Structure
- Organizing data on your computer in a way that it can be used effectively.
- Helps in efficient data storage, retrieval, and manipulation.

### ⚙️ Algorithm
- A set of instructions or rules designed to perform a specific task.
- A defined step-by-step procedure for solving a problem.
- Used by computers to perform operations efficiently and correctly.

---

## 🗃️ Room Database in Android

Room provides an abstraction layer over SQLite and is part of Android Jetpack.

### 1. Define an Entity class:
```kotlin
@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    val name: String,
    val email: String
)
```


### 2. Create a DAO (Data Access Object):

```kotlin
@Dao
interface UserDao {
@Query("SELECT * FROM users")
fun getUsers(): List<User>

    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)
}
```

### 3. Define the Database class:

```kotlin
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
abstract fun userDao(): UserDao
}
```

### 4. Use the Room database in your app:

```kotlin
val database = Room.databaseBuilder(
context,
AppDatabase::class.java,
"my-database"
).build()

val userDao = database.userDao()
val users = userDao.getUsers()
```


# 📦 Modularization & DSA in Kotlin for Android Developers

## 🔹 What is Modularization?

**Modularization** is the practice of organizing a codebase into loosely coupled and self-contained parts.  
Each part is a *module* that is independent and serves a clear purpose.  
By dividing a problem into smaller subproblems, you reduce the complexity of designing and maintaining large systems.

---

## 🔹 Common Design Patterns in Android

| Pattern     | Common Use Cases in Android                          |
|-------------|------------------------------------------------------|
| **Singleton**  | Database, SharedPreferences, Retrofit instance     |
| **Factory**    | ViewModelProvider, Room Database                  |
| **Observer**   | LiveData, RxJava, Flow                            |
| **Adapter**    | RecyclerView Adapter                              |
| **Builder**    | AlertDialog, Glide                                |

---

## 📚 DSA in Kotlin

### 1️⃣ Arrays & Lists – Best for Indexed Access & Simple Storage
- ✅ **Use When:**
    - Fixed-size data
    - Fast random access (`O(1)`)
    - Sorting needed
- 🔍 **Examples:**
    - Two Sum *(HashMap)*
    - Merge Intervals *(HashMap + Pair)*

---

### 2️⃣ HashMap / HashSet – Fast Lookup & Unique Elements
- ✅ **Use When:**
    - Fast insert, search, delete (`O(1)` average)
    - Frequency counting
- 🔍 **Examples:**
    - Two Sum
    - First Non-Repeating Character *(LinkedHashMap)*

---

### 3️⃣ Stack – LIFO (Last In, First Out)
- ✅ **Use When:**
    - Undo/Redo, browser history
    - Parentheses, expression problems
    - Backtracking/DFS

---

### 4️⃣ Queue & Deque – FIFO & Sliding Window
- ✅ **Use When:**
    - Task scheduling, BFS
    - Sliding window problems *(Deque for optimization)*

---

### 5️⃣ Linked List – Dynamic Memory Allocation
- ✅ **Use When:**
    - Need dynamic size
    - Fast insert/delete
- 🔍 **Examples:**
    - Cycle detection
    - Reverse list
    - Merge sorted lists

---

### 6️⃣ Trees (BST, Trie, Heap) – Hierarchical Data
- ✅ **Use When:**
    - Searching/sorting, hierarchical relations
- 🔍 **Examples:**
    - BST → `O(log N)` search
    - Trie → Auto-complete
    - Heap → Priority Queue

---

### 7️⃣ Graphs – Connections & Networks
- ✅ **Use When:**
    - Track relationships between nodes
    - Shortest path problems
- 🔍 **Algorithms:**
    - Dijkstra
    - Floyd Warshall

---

### 8️⃣ Sorting & Searching Algorithms
- ✅ **Use When:**
    - Efficient data sorting/searching
- 🔍 **Examples:**
    - Merge Sort, Quick Sort *(Divide & Conquer)*
    - Binary Search → `O(log N)`
    - Rotated Array Search

---

## 🧠 DSA Pattern Recognition

| Problem Type      | DSA to Use      |
|-------------------|-----------------|
| Fast Lookup        | `HashMap`       |
| LIFO               | `Stack`         |
| FIFO               | `Queue`         |
| Hierarchy          | `Tree`          |
| Relationships      | `Graph`         |

---

## 📱 Android-Specific DSA Use Cases

### 1️⃣ UI Event Processing → **Stack**
- **Solution:** Use stack to manage screen history (Back Navigation)

### 2️⃣ Real-Time Analytics → **HashMap**
- **Solution:** Use `HashMap` for counting likes, shares, etc. (O(1) operations)

### 3️⃣ Nearby Users → **Graph + Dijkstra**
- **Use Case:** Location-based features (Ola/Uber)
- **Solution:** Shortest path recommendation using `Graph` and `Dijkstra’s Algorithm`

### 4️⃣ News Feed → **Min-Heap (Priority Queue)**
- **Problem:** Show top K trending articles
- **Solution:** Use `PriorityQueue` to efficiently fetch Top K items
- **Use Case:** Trending Topics, Top Products, Popular Movies

---

## 💡 Final Thoughts

> **Pehle brute-force socho, phir optimized DSA use karo.**  
> Stick to the language you're most comfortable with—focus on solving the problem, not fighting the syntax.

---

### 🚨 Issue: Strings are immutable in Kotlin, so character = i.toString() creates a new string every iteration → O(N) extra space usage.

# 👩‍💻 Kotlin, OOP, SOLID, Coroutines & Reactive Patterns in Android

---

# OOPs Concepts

### Class
A blueprint or template for creating objects. It defines properties (data) and methods (functions) that the objects will have.

### Object
A real-world instance of a class. It represents a real-world entity and has its own state (attributes) and behaviour (methods).

### Encapsulation
Wrapping data. Protects data by controlling how it is accessed or modified.

### Abstraction
Hiding complex implementation details and showing only the important parts.  
You only need to know how to use the method, not how it works internally.

### Inheritance
When one class derived from another class is called inheritance, where subclass has access to all the super class functionalities. The subclass can reuse the fields and methods of the superclass.
The child class inherits features from the parent class but can also have its own features.

### Polymorphism

Polymorphism is about having same name but different behaviours. It means the same thing can act differently depending on the situation.
Polymorphism allows objects of different classes to be treated as objects of a common superclass through method overriding and method overloading.

- **Method Overriding**:  
  Subclasses can provide their own implementation of methods defined in the superclass, allowing the same method name to behave differently in different classes.

- **Method Overloading**:  
  Multiple methods can have the same name but different parameter lists within a single class, enabling a method to perform different tasks based on the arguments passed to it.

---

# Agile Methodology in Android App Development

Agile is a way to manage app development by dividing the work into small, manageable pieces called **sprints** (usually 1-2 weeks).  
It focuses on **flexibility, teamwork**, and **delivering features quickly**.

---

# SOLID Principles

### Single Responsibility Principle (SRP)
A class should have only one reason to change. It keeps your code focused and easier to maintain.

### Open/Closed Principle (OCP)
A class should be open for extension but closed for modification.  
You should be able to add new functionality without changing existing code.  
It avoids breaking existing code when adding new features. (suppose Base code)

### Liskov Substitution Principle (LSP)
Objects of a child class should be replaceable with objects of the parent class without breaking the code.  
Ensures that subclasses behave like their parent class.

### Interface Segregation Principle (ISP)
A class should not be forced to implement methods it doesn’t need.  
Instead, create smaller, specific interfaces. Keeps classes focused and avoids unnecessary dependencies.

### Dependency Inversion Principle (DIP)
High-level modules (logic) should not depend on low-level modules (details).  
Both should depend on abstractions (interfaces). Makes the code flexible and easier to change.

---

## 🧵 Kotlin Fundamentals

| Keyword     | Description |
|-------------|-------------|
| `const`     | Compile-time constant. Immutable and initialized at compile-time. |
| `val`       | Read-only variable. Assigned once at **runtime**. |
| `var`       | Mutable variable. Can change anytime. |
| `lateinit`  | For **non-null `var`**, initialized later. Throws exception if accessed before init. |
| `lazy`      | Initializes only **when first accessed**. Used with `val`, and **thread-safe** by default. |

---

## ⚙️ Coroutines & Dispatchers

### 🔹 Default Dispatchers
- Use a **shared thread pool** within the **current process**.
- Each process has its **own pool**; not shared across processes.

### 🔹 Suspend Functions
- Functions that **can pause and resume** without blocking threads.
- Essential for async operations like network/database calls.

---

## ➕ Kotlin Extension Functions

**What:** Add new functions to existing classes **without modifying them**.

```kotlin
fun String.capitalizeFirst(): String = this.replaceFirstChar { it.uppercase() }
```
# Kotlin and Android Concepts

## Extension Functions
**What it is:** Lets you add new functions to existing classes without modifying their code.

---

## const
**What it is:** A compile-time constant. The value is fixed and cannot change.

---

## val
**What it is:** A read-only variable. You can set its value only once, but it can be set at runtime.

---

## var
**What it is:** A mutable variable. You can change its value anytime.

---

## lateinit
**What it is:** A special keyword for declaring a variable later, but it must be of a non-nullable type and `var`.

**Key Point:** Throws an exception if accessed before being initialized.

---

## lazy
**What it is:** A property delegate that initializes a variable only when it’s accessed for the first time.

**When to use:** For variables that are expensive to create or don’t need to be initialized right away, like a database instance or a large data structure.

**Key Point:** It is thread-safe by default and used only with `val`.

---

## Suspend Functions
Functions that can pause their execution and resume later.

---

## ViewModel
The ViewModel survives configuration changes (like screen rotations). Lifecycle aware.

---

## Reactive Approach: LiveData or StateFlow

---

### LiveData
A lifecycle-aware data holder that automatically updates the UI when data changes.

**Lifecycle Awareness:** Updates the UI only if the Activity or Fragment is active.

**When to Use LiveData:**
- For simple UI updates in Android apps.
- When you need lifecycle awareness to prevent crashes (e.g., updating the UI only when the Activity is active).
- Best for view-related data in MVVM architecture.

---

### Kotlin Flow
A cold, asynchronous stream of data that emits values sequentially over time.

**To handle streams of data** (like network responses, sensor data, or database updates) in a more flexible and powerful way.

**Transformation:** Offers operators like `map`, `filter`, and `collect` to process data streams.

**When to Use Flow:**
- For complex data streams that need powerful transformations (e.g., filtering, combining).
- When you’re working with coroutines and need better async handling.
- For non-UI-related data processing or in shared business logic (like repositories).

---

## LiveData vs Flow
- Use **LiveData** when you want a UI-friendly, lifecycle-aware solution.
- Use **Flow** when you need asynchronous data streams and powerful transformations.

---

## setValue vs postValue

### setValue
Updates the value of LiveData synchronously on the main thread.  
**Note:** Can only be called on the main thread. Calling it from a background thread will throw an exception.

### postValue
Updates the value of LiveData asynchronously.  
**Note:** It is safe to call from a background thread.

- Use `postValue()` when you’re updating LiveData from a background thread, such as during network calls or database operations.
- Use `setValue()` for updates on the main thread (UI-related tasks).
- Use `postValue()` for updates from background threads (network or database operations).

---

## Compose State Management
**State is essential** because Compose UI is declarative, meaning the UI automatically updates when the state changes.  
**State is any value that can change and is used to drive what the UI displays.**

When the value of `MutableState` changes, Compose recomposes the affected UI.

```kotlin
val abc = remember { mutableStateOf<Type>("") }
```

### rememberSaveable : Similar to remember, but it also saves the state across configuration changes like screen rotation.

```kotlin
navController.navigate(JetnewsDestinations.HOME_ROUTE) {
    // Pop up to the start destination of the graph to
    // avoid building up a large stack of destinations
    // on the back stack as users select items
    popUpTo(navController.graph.findStartDestination().id) {
        saveState = true
    }
    // Avoid multiple copies of the same destination when
    // reselecting the same item
    launchSingleTop = true
    // Restore state when reselecting a previously selected item
    restoreState = true
}
```

https://www.linkedin.com/pulse/android-jetpack-compose-ui-design-interview-questions-anand-gaur-aexuc/
https://www.geeksforgeeks.org/android-jetpack-compose-tutorial/

### Alert dialog : properties = DialogProperties(dismissOnClickOutside = isDismissible)

# Jetpack Compose UI Basics

## Layout Composables

Layout composables, like `Row`, `Column`, and `Box`, allow you to organize child composables in Jetpack Compose.

- **Row** – Places children in a horizontal sequence.
- **Column** – Places children in a vertical sequence.
- **Box** – Stacks children on top of each other and allows alignment customization.

---

## Recomposition

**Recomposition** is the process by which Jetpack Compose determines when to update the UI based on state changes or other triggers.

- It ensures that only the parts of the UI that depend on the changed state are recomposed.
- Improves performance by avoiding unnecessary redraws.

---

## Box Example

Below is an example of using `Box` with modifiers and a clickable icon in the top-end alignment:

```kotlin
Box(
    modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp),
    contentAlignment = Alignment.TopEnd
) {
    Icon1(
        imageVector = Icons.Default.Clear,
        modifier = Modifier
            .shadow(elevation = 4.dp, shape = CircleShape)
            .background(color = Color.White, shape = CircleShape)
            .size(30.dp)
            .padding(5.dp)
            .clickable { onDismiss() },
        contentDescription = stringResource(R.string.close)
    )
}
```

# StateFlow and Lifecycle Observation in Jetpack Compose

StateFlow is part of Kotlin's `kotlinx.coroutines` library and is used to represent a state that can be observed over time.  
It is a state-holder observable flow, which means it can be used to manage and emit UI state in a reactive way.  
StateFlow is similar to LiveData in Android, but it is built on top of Kotlin Coroutines, offering a more structured and flexible approach.

**MutableStateFlow:** This is the version of StateFlow that can be updated.  
**StateFlow:** This is the read-only version of MutableStateFlow.

In a Jetpack Compose UI, you can collect values from StateFlow using `collectAsState()`.

**Automatic Recomposition:** When the state changes, Jetpack Compose automatically recomposes the affected UI parts.  
StateFlow is a state-holder that can be observed and updated over time.

You can observe the Lifecycle of an Activity or Fragment using `LifecycleEventObserver`.  
This is how you can listen for lifecycle events like `onResume()` or `onStop()`:

```kotlin
@Composable
fun ObserveLifecycle() {
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    println("ON_RESUME called")
                }
                Lifecycle.Event.ON_STOP -> {
                    println("ON_STOP called")
                }
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}
```


# Android & Kotlin Essentials

## 1. Enum Class
**What it is:**  
An enum represents a set of constants that are known at compile-time.  
Use enum when you need to define a fixed set of related constants, like days of the week or directions.

## 2. Sealed Class
**What it is:**  
A sealed class is a class that restricts its subclasses to a predefined set. Unlike enums, its subclasses can hold different types of data.  
Use a sealed class when you need to model a hierarchy of types with specific data for each type.  
By choosing the right option based on your use case, you can write cleaner, more efficient code! 😊

---

## What is a Memory Leak?
A memory leak happens when an app holds onto memory (RAM) that it no longer needs, but it fails to release it.  
Over time, this can lead to the app consuming more memory than necessary, slowing down the device, and even causing crashes due to OutOfMemoryError.

### How Does a Memory Leak Happen?
In Android, memory leaks commonly occur when:
- Long-lived objects reference short-lived objects (e.g., a static variable holding a reference to an Activity).
- Resources like listeners, handlers, or threads aren’t properly cleaned up.
- Incorrect usage of context, especially Activity or Fragment contexts.

### Why Preventing Memory Leaks is Important
- **Performance:** Keeps the app running smoothly without slowing down the device.
- **Stability:** Prevents crashes caused by OutOfMemoryError.
- **User Experience:** Ensures users don’t experience lags or app crashes.

```xml
<androidx.compose.ui.platform.ComposeView
    android:id="@+id/feeDashboardView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

---

## Backpressure
Handles data flow control when the data producer is faster than the consumer.

---

## Android Gradle Plugin (AGP)
**What it is:**  
The Android Gradle Plugin is a special Gradle plugin provided by Google specifically for building Android apps.  
It extends Gradle to handle Android-specific tasks like:  
AGP makes Gradle understand Android projects and provides tools to build Android apps efficiently.

```gradle
plugins {
    id 'com.android.application' version '8.1.0' apply false
}
```

---

## What is an ANR (Application Not Responding)?
An ANR (Application Not Responding) is a dialog shown by Android when an app becomes unresponsive for too long, usually because it is blocking the main thread (UI thread).  
This results in a bad user experience, and users often choose to force close the app.

### How to Avoid ANRs?
Offload Heavy Work to Background Threads

---

## What is a Thread Pool?
A thread pool is a group of reusable threads managed by a pool manager.  
Instead of creating and destroying threads repeatedly (which is resource-intensive), a thread pool allows threads to be reused for executing tasks.  
This improves performance and helps manage system resources effectively.

---

## What is a Shared Thread Pool in Coroutines?
In Kotlin Coroutines, a shared thread pool is used to execute tasks in a non-blocking way.  
Coroutines don’t create a thread for every coroutine; instead, they reuse a small pool of threads to run multiple coroutines efficiently.

---

## What is an Abstract Class in Kotlin?
An abstract class is a class that cannot be instantiated directly and is meant to be inherited by other classes.  
It can have both abstract (unimplemented) methods and concrete (implemented) methods.

---

## Coroutines

- Use `async + await` when you need parallel computation with results.
- Use `launch` when you just want to fire and forget.

---

## Sealed vs Sealed Interface

- Use a sealed class when you need a hierarchy of types that hold data.
- Use a sealed interface when you need behavior-based polymorphism with multiple implementations.

---

## Launch Modes
Launch modes control how activities behave in the task stack.

---

```kotlin
val userMap = mapOf(1 to "Alice", 2 to "Bob", 3 to "Charlie")
```

---

## JUnit Unit Tests
Location: `app/src/test`  
JUnit is used for writing and running unit tests for non-UI components, such as business logic, data processing, and utility functions.

---

## Espresso UI Tests
Location: `app/src/androidTest`  
Espresso is employed for UI testing to verify the behavior of your app's user interface.

---

## remember in Jetpack Compose
The `remember` function in Jetpack Compose is used to create and store a value that survives recomposition.

---

# MVI in Jetpack Compose

## What is MVI in Compose?

MVI focuses on **unidirectional data flow**:

- **Model**: Represents the state of the UI.
- **View**: Renders the state and sends user intents (actions/events).
- **Intent**: User interactions that cause state changes, handled by the ViewModel.

---

## Key Components of MVI

### 1. State
A single **immutable object** that represents the entire state of the UI.

### 2. Intent (Event)
Actions or events that describe **user interactions**.

---

## ViewModel & Scope Handling

If you're using `viewModelScope` for dependency injection and managing the scope manually, the `hiltViewModel()` approach wouldn't automatically handle the scope.  
You may need to **manually pass the correct scope or NavBackStackEntry** for ViewModel injection.

```kotlin
val parentStack = navController.isParentAvailable(NavigationRoutes.BookListScreen.route)
val booksViewModel: BooksViewModel = if (parentStack != null) {
    hiltViewModel(parentStack)
} else {
    hiltViewModel()
}
```

# Android & API Fundamentals

## HTTP Methods in API

Here’s a brief explanation of when to use the different HTTP methods in an API:

1. **GET**  
   **Purpose**: Retrieve data from the server.  
   **Usage**: When you need to fetch information without modifying it.

2. **POST**  
   **Purpose**: Send data to the server to create a new resource.  
   **Usage**: When you need to create something new on the server.

3. **PUT**  
   **Purpose**: Update an existing resource or create it if it doesn’t exist.  
   **Usage**: When you want to replace the entire resource with new data.

4. **PATCH**  
   **Purpose**: Partially update an existing resource.  
   **Usage**: When you want to modify specific fields of a resource.

5. **DELETE**  
   **Purpose**: Remove a resource from the server.  
   **Usage**: When you need to delete something.

---

## Kotlin Basics

- **Abstract Class**: An abstract class cannot be instantiated and may contain abstract methods (methods without a body) that must be implemented by its subclasses.

- **Interface**: An interface defines a contract for classes to implement. It contains method signatures without method bodies. Classes implement interfaces to provide specific behaviour.

- **var**: In Kotlin, `var` is a keyword used to declare a mutable variable, meaning its value can be changed after it's initialized.

- **val**: Similarly, `val` is a keyword used to declare an immutable variable, meaning once initialized, its value cannot be changed. It's akin to declaring a constant.

- **lateinit**: The `lateinit` in Kotlin is used for the late initialization of a variable in Kotlin. Using the `lateinit` keyword, you can declare a variable and not provide an initial value for the variable. It specifies that the variable will be initialized later in the program.

- **let**: In Kotlin, `let` is a scoping function. It allows you to execute a block of code on a non-null object. It's often used to perform operations on nullable objects safely without the need for explicit null checks.

- **run**: `run` is another scoping function in Kotlin. It's similar to `let`, but instead of taking the object as an argument, it executes the given block of code within the context of the object itself, allowing access to its members without qualification.

- **const**: The `const` keyword is used to declare properties that are immutable in nature, i.e., read-only properties. The values are only known at compile-time though; as a result, no values may be assigned at runtime to `const` variables.  
  The main difference between `val` and `const val` is that `val` can be assigned a value at runtime, whereas `const val` must be assigned a value at compile time and cannot be changed afterward (their values are hardcoded).

---

## Android Components

App components are the essential building blocks of an Android app. Each component is an entry point through which the system or a user can enter your app. Some components depend on others.

There are four types of app components:

- **Activities**  
  An activity is the entry point for interacting with the user. It represents a single screen with a user interface.

- **Services**  
  A service is a general-purpose entry point for keeping an app running in the background for all kinds of reasons. It is a component that runs in the background to perform long-running operations or to perform work for remote processes. A service does not provide a user interface.  
  For example, a service might play music in the background while the user is in a different app, or it might fetch data over the network without blocking user interaction with an activity. Another component, such as an activity, can start the service and let it run or bind to it to interact with it.  
  There are two types of services that tell the system how to manage an app: started services and bound services.

- **Broadcast Receivers**  
  Broadcast receivers are components that respond to system-wide broadcast announcements. These announcements can originate from the system itself or from other applications. Broadcast receivers are used to listen for events such as the completion of a download, the insertion of a new contact, or the charging of the device. Broadcast receivers allow your application to listen for and react to these events.

- **Content Providers**  
  Content providers manage a shared set of application data. They provide a standardized way for one application to access data from another application or to share data with other applications. Content providers are commonly used to expose structured data, such as contacts, calendar events, or media files, to other applications.

These application components are defined in the `AndroidManifest.xml` file of the Android application and are instantiated and managed by the Android operating system.

---

## Intents

It is an inter-application message passing framework for communication between Android components.

---

## Fragments

Fragment is the part of activity, it is also known as sub-activity. There can be more than one fragment in an activity. Fragments represent multiple screens inside one activity. Android fragment lifecycle is affected by activity lifecycle because fragments are included in activity.  
Each fragment has its own life cycle methods that is affected by activity life cycle because fragments are embedded in activity.  
The `FragmentManager` class is responsible to make interaction between fragment objects.

---

## Architecture Components

Architecture components in Android development refer to a set of libraries provided by Google to help developers design robust, maintainable, and testable applications.  
These components promote best practices such as separation of concerns, lifecycle awareness, and data persistence.

All the Android Architecture Components are as follows:

- **Data Binding**: It helps in declaratively binding UI elements to in our layout to data sources of our app.

- **Lifecycles**: It manages activity and fragment lifecycles of our app, survives configuration changes, avoids memory leaks and easily loads data into our UI.

- **LiveData**: It notifies views of any database changes. Use LiveData to build data objects that notify views when the underlying database changes.

- **Navigation**: It handles everything needed for in-app navigation in Android application.

- **Paging**: It helps in gradually loading information on demand from our data source.

- **Room**: It is a SQLite object mapping library. Use it to avoid boilerplate code and easily convert SQLite table data to Java objects. Room provides compile-time checks of SQLite statements and can return RxJava, Flowable and LiveData observables.

- **ViewModel**: It manages UI-related data in a lifecycle-conscious way. It stores UI-related data that isn't destroyed on app rotations.

- **WorkManager**: It manages every background job in Android with the circumstances we choose.

---

## Hilt

[Hilt Documentation](https://developer.android.com/training/dependency-injection/hilt-android)

Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project. Doing manual dependency injection requires you to construct every class and its dependencies by hand, and to use containers to reuse and manage dependencies.

Hilt provides a standard way to use DI in your application by providing containers for every Android class in your project and managing their lifecycles automatically. Hilt is built on top of the popular DI library Dagger to benefit from the compile-time correctness, runtime performance, scalability, and Android Studio support that Dagger provides.

### Here’s a breakdown of why Hilt is often preferred over Dagger in Android development:

1. **Ease of Setup and Boilerplate Reduction**
    - **Hilt**: Provides a set of predefined components (e.g., `ApplicationComponent`, `ActivityComponent`, `FragmentComponent`), removing the need to create and manage custom components manually.
    - **Dagger**: Requires creating custom components, writing `@Component` interfaces, and often manually managing dependency scopes and lifecycles, which can be verbose and complicated.
    - **Advantage**: Hilt automatically creates and manages DI components based on Android app classes, greatly reducing boilerplate code.

2. **Android Lifecycle Awareness**
    - **Hilt**: Integrates directly with the Android lifecycle by providing lifecycle-aware components that automatically clean up dependencies when they're no longer needed.
    - **Dagger**: While it supports lifecycle scopes, managing scoped components manually requires more effort and lifecycle understanding from the developer.
    - **Advantage**: Hilt manages lifecycles for you, making it much easier to correctly scope dependencies, especially in Android's Activity and Fragment lifecycles.

---

## SharedPreferences

- `commit()`: is a **synchronous** method that immediately writes changes to disk and returns a result. It is suitable for small or quick operations but may cause UI freezes if called on the UI thread.

- `apply()`: is an **asynchronous** method that schedules changes to be written in the background without blocking the calling thread. It does not provide immediate feedback but is recommended for non-blocking scenarios.
