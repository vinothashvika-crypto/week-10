# Week 10 – Quiz and Concept Question Answers

Topic: Java fundamentals revision (strings, objects and references, static members, loops, pass-by-value, OOP).

## Part B – Quiz

| Q | Answer | Why |
|---|--------|-----|
| 1 | **D** | `new String(...)` creates two different objects, so `==` is false, but their contents are equal, so `equals` is true. |
| 2 | **B** – `"baL avaJ"` | `"Java Lab"` reversed character by character. |
| 3 | **B** – `Student(String name)` | That is the constructor `new Student("Ravi")` calls directly. It then chains with `this(...)` to the 2-argument one. |
| 4 | **D** – 700 / 700 | `w2 = w1` copies the reference, so there is only one `Wallet` object. |
| 5 | **C** – 3 | The static `count` is shared by all objects and incremented once per constructor call. |
| 6 | **A** – `45 78 92 60 85` | Indices 0 to length-1, in order. |
| 7 | **B** – `1 2 4 5` | `continue` skips printing when `i == 3`. |
| 8 | **A** – 5 | Primitives are passed by value; `change` only modifies its own copy. |
| 9 | **C** – `83.33333333333333` | `count` is a `double`, so `250 / 3.0` is floating-point division (verified by running it). |
| 10 | **B** – `Paid 510.0 by card` | Runtime dispatch calls `Card.pay`: 500 + 2% = 510.0. |
| 11 | **B** | Strings are immutable. `toUpperCase()` returns a *new* `"JAVA"`, and `name` stays `"java"`. |
| 12 | **B** – 2 | `s1` and `s2` share one pooled `"hello"`; `new String` makes a second object on the heap. |
| 13 | **A** – `6` / `m` | `"Campus"` has 6 characters, and index 2 is `'m'`. |
| 14 | **A** – 4 | `u s e r @`, so `@` is at index 4. |
| 15 | **B** | The default constructor sets `"Unknown"` and `0.0`. |
| 16 | **A** | The parameterized constructor stores the given values. |
| 17 | **B** – 2 | `w1` and `w2` point to one object, and `w3` is a second object. |
| 18 | **C** – 700 / 700 | Same object reached through two references. |
| 19 | **C** – `Anu` / `Ravi` | Only `s1`'s object changed; `s2` is a separate object. |
| 20 | **C** – `Total visitors: 3` | The static counter is shared by all three objects. |

## Part C – Concept Questions

**1. String immutability and performance.**
A `String` can never change after it is created. Every "modification" (`+`, `concat`, `toUpperCase`, `replace`) builds a **new** object. In a loop like `s = s + i;` repeated n times, each step copies the whole string so far. That is O(n²) character copying, plus lots of garbage for the collector. The fix is to use a mutable `StringBuilder` (or `StringBuffer` when thread safety is needed): `sb.append(i)` changes one buffer in place, and `sb.toString()` is called once at the end. Immutability itself is useful: strings are safe to share, can be pooled, and work reliably as `HashMap` keys.

**2. `this` with same-named fields and parameters.**
Inside the constructor, a plain name refers to the parameter, which *shadows* the field. `this.name` explicitly means "this object's field". Example: `public Student(String name, int roll) { this.name = name; this.roll = roll; }`. Without `this.`, `name = name;` would just assign the parameter to itself and leave the field `null`.

**3. Object vs. reference variable.**
The **object** lives on the heap and holds the actual data. A **reference variable** is a small value (on the stack or inside another object) that points to the object. `Wallet w2 = w1;` copies only the *reference*, so both variables now point to the **same** object and no new object is created. Changes made through `w2` are visible through `w1`. To get an independent copy, you must create a new object (a copy constructor or `clone`).

**4. Static vs. instance variables.**
Use **instance** variables for data that differs per object, such as each `Student`'s `name` and `attendance`. Use **static** variables for data shared by the whole class, such as `collegeName` (the same for every student, stored once) or a counter of how many objects were created (`studentCount++` in the constructor). Making `name` static would be wrong, because every student would overwrite the same single value.

**5. `for` vs. `while` vs. `do-while`.**
- `for`: best when the number of iterations is known, such as walking an array by index (`for (int i = 0; i < arr.length; i++)`).
- `while`: best when you loop until a condition changes and may need zero iterations, such as reading input until end of file or `while (number > 0)` to extract digits.
- `do-while`: the body runs **at least once** before the condition is checked, such as showing a menu and repeating until the user picks "Exit", or asking for a PIN until it is valid.

**6. Pass-by-value in Java.**
Java always passes a *copy of the value*. For a **primitive**, the method gets a copy of the number, so assigning to the parameter never affects the caller's variable (Quiz Q8). For an **object**, the value copied is the *reference*. The method can therefore change the object's fields (`arr[0] = 99` or `wallet.add(100)`), and the caller sees it, because both point to the same object. But reassigning the parameter (`arr = new int[5]`) only changes the method's copy, not the caller's variable.

**7. Integer division.**
When both operands are integers, `/` performs integer division and **truncates** toward zero: `7 / 2 == 3` and `250 / 3 == 83`. The fractional part is lost *before* any assignment, so `double avg = total / n;` with `int total, n` still gives `83.0`. Casting one operand first, `(double) total / n`, makes the division floating-point and gives `83.333...`. Casting after the division, `(double)(total / n)`, is too late.

**8. Encapsulation.**
Encapsulation bundles data with the methods that act on it and hides the data's internals. Marking fields `private` means outside code can't put an object into an invalid state directly. Getters give read access, and setters or action methods (`deposit`, `withdraw`) can *validate* every change, for example rejecting a negative amount or a withdrawal larger than the balance. The class can also change its internal representation later without breaking callers.

**9. `==` vs. `equals()`.**
For objects, `==` checks **reference identity**: are these the same object in memory? `equals()` checks **logical equality** as defined by the class. The default `Object.equals` is the same as `==`, but classes like `String` override it to compare contents. If you override `equals` in your own class (for example, two `Student`s are equal when their `rollNo` matches), then two different objects with the same roll number are `equals` but still not `==`. You should also override `hashCode()` so that hash-based collections stay consistent.

**10. Overloading vs. overriding.**
**Overloading** means the same method name with *different parameter lists* in the same class. The compiler picks the version at **compile time** from the argument types, for example `add(int, int)` and `add(double, double)`. **Overriding** means a subclass redefines a method with the *same signature* as its parent. The version is chosen at **run time** from the actual object, for example `Animal a = new Dog(); a.makeSound();` prints `Woof`.
