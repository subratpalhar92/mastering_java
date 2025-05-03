# Common Pointers While Manipulating Data In Java


## Mastering Conditional & Loop Expression
- The important thing to remember all the 3 section are independent of each other
    - initializattion::     only once
    - condition::           Is checked before each iteration of the loop (INCLUDING VERY FIRST ONE)
    - Increment/Decrement:: Executed after each iteration of the loop
- You can write arbitary S.o.p() statement in 
```
    public static void main(String []args) {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("counter= "+ ++counter + "i=" + i);
        }
        counter = 0;
        System.out.println("--------------------------");
        for (int i = 0; i < 5; ++i) {
            System.out.println("counter= "+ ++counter + "i=" + i);
        }
    }

    O/P [In Both The Cases]
        counter= 1i=0
        counter= 2i=1
        counter= 3i=2
        counter= 4i=3
        counter= 5i=4
```

## Operations On String
```
Common Operation
    length()            isEmpty();
    toLowerCase()       toUpperCase()       trim()
    str1.concat(str2)
    
    str1.equalsIgnoreCase(str2)

    str1.compareTo(str2); // -ve 0 +ve
    
    csvStr.split(",")

    "example".substring(2) /** ample */
    "example".substring(1, 4); // "xam"
    "apple".replace('p', 'b') /** also works with string arguments */


    text.startsWith("Hello")
    text.endsWith("world")
    


Helps In Algorithm
    charAt(0)       "Programming".indexOf("gram") /** 4 */      lastIndexOf("a")

```

## String -to- Interger -to- int -to- Interger -to- String conversion
```
    int pmtv = Integer.parseInt("123");         /** parseInt        STR->PMTV */

    Integer wrppr = Integer.valueOf(str);       /** valueOf         STR->WRPER */

    new Integer(789)intValue();                 /** intValue        WRPER ->int O|R you can directly assign */

    new Integer(123);  Integer.valueOf(123)     /** new Integer     int->INTGR O|R you can directly assign */

    Integer.toString(123);  new Integer(1415).toString();   /** toString    WRPER|PMTV->STR  */

    NumberFormatException
```

## String -to- Char Array -to- String conversion
```
String[] strArray = {"apple", "banana", "cherry"};
String strFromArr = Arrays.toString(strArray);

String[] strArray = {"apple", "banana", "cherry"};
String joinedString = String.join("-", strArray);   /** apple-banana-cherry */


tring text = "hello";
char[] charArray = text.toCharArray();  /** [h, e, l, l, o] */

```


## BIT Twidling & HASH

- Bit twiddling is particularly useful in scenarios where:
    - Performance is critical: Bitwise operations are often faster than arithmetic operations.
    - Memory is constrained: Representing sets or flags using individual bits within an integer can be very memory-efficient.
    - Low-level programming or hardware interaction: When dealing directly with hardware or implementing low-level data structures.
    - Algorithmic optimizations: Some algorithms, like those involving sets or counting, can be significantly optimized using bit manipulation.
- mportant Considerations:
    - Readability: While efficient, bitwise operations can sometimes make code harder to read and understand. Use them judiciously and add comments to explain their purpose.
    - Portability: Be mindful of the size of integer types across different platforms if you're relying on specific bit patterns. Java's primitive types have well-defined sizes.
    - Alternatives: Before resorting to complex bit twiddling, consider if there are more readable and maintainable alternatives using standard Java APIs.


```
& (Bitwise AND): Sets a bit to 1 only if both corresponding bits are 1.
| (Bitwise OR): Sets a bit to 1 if at least one of the corresponding bits is 1.
^ (Bitwise XOR): Sets a bit to 1 only if the corresponding bits are different.
~ (Bitwise NOT): Inverts all the bits of an operand.
<< (Left Shift): Shifts the bits of an operand to the left by a specified number of positions. Vacated bits are filled with 0s.
>> (Signed Right Shift): Shifts the bits of a signed operand to the right. The sign bit is extended to preserve the sign.
>>> (Unsigned Right Shift): Shifts the bits of an operand to the right. Vacated bits are filled with 0s, regardless of the sign
```

- Number is Even or Odd
```
int num = 10;
if ((num & 1) == 0) {
    System.out.println(num + " is even");
} else {
    System.out.println(num + " is odd");
}
```

- Multiplying or Dividing by Powers of 2
```
Left shifting by n bits is equivalent to multiplying by 2^n
Right shifting by n bits (signed or unsigned) is equivalent to integer division by 2^n
This is often faster than standard multiplication and division.

int num = 5;
int multiplyBy4 = num << 2; // Equivalent to num * 2^2
int divideBy2 = num >> 1;   // Equivalent to num / 2^1 (integer division)
```

- Setting, Clearing, and Toggling a Specific Bit:
```
Setting: Create a mask with a 1 at the desired position and use bitwise OR.
Clearing: Create a mask with a 1 at the desired position, invert it, and use bitwise AND.
Toggling: Create a mask with a 1 at the desired position and use bitwise XOR.


int num = 0;
int bitPosition = 2; // Let's work with the 3rd bit (0-indexed)

// Setting the bit
int setBitMask = 1 << bitPosition;
int numWithBitSet = num | setBitMask; // Result: 4 (binary 100)

// Clearing the bit
int clearBitMask = ~(1 << bitPosition);
int numWithBitCleared = numWithBitSet & clearBitMask; // Result: 0 (binary 000)

// Toggling the bit
int toggleBitMask = 1 << bitPosition;
int numWithBitToggled = numWithBitSet ^ toggleBitMask; // Result: 0 (binary 000)
```
- Checking if a Specific Bit is Set
```
Create a mask with a 1 at the desired position and use bitwise AND. If the result is non-zero, the bit was set.


int num = 6; // Binary 110
int bitPosition = 1; // Checking the 2nd bit

if ((num & (1 << bitPosition)) != 0) {
    System.out.println("The " + (bitPosition + 1) + "nd bit is set"); // Output: The 2nd bit is set
} else {
    System.out.println("The " + (bitPosition + 1) + "nd bit is not set");
}
```

- Getting the Lowest Set Bit (LSB)
```
The two's complement of a number (-num) has all the bits flipped up to and including the LSB, and then the LSB remains 1. The bitwise AND isolates this LSB. This is useful in algorithms like the Fenwick Tree (Binary Indexed Tree)


int num = 12; // Binary 1100
int lsb = num & -num; // Result: 4 (binary 0100)
```

- Checking if a Number is a Power of 2
```
Powers of 2 in binary have only one bit set (e.g., 1, 10, 100, 1000). Subtracting 1 from a power of 2 results in a number with all bits set up to (but not including) the original set bit (e.g., 0, 01, 011, 0111). The bitwise AND of the number and its predecessor will be 0 if and only if the original number was a power of 2 (and greater than 0).

int num = 16;
if ((num > 0) && ((num & (num - 1)) == 0)) {
    System.out.println(num + " is a power of 2");
} else {
    System.out.println(num + " is not a power of 2");
}
```

- Counting Set Bits (Hamming Weight)
```
num &= (num - 1) clears the least significant set bit in each iteration. The loop continues until all set bits are cleared.


int num = 13; // Binary 1101
int count = 0;
while (num != 0) {
    num &= (num - 1);
    count++;
}
System.out.println("Number of set bits: " + count); // Output: 3



Lookup Table (for smaller numbers or repeated calculations): You can precompute the number of set bits for all possible byte values (0-255) and then use these values to count set bits in larger numbers by processing them byte by byte



Bit Twiddling Magic (more complex but potentially faster)
This approach uses a series of bitwise operations to sum the set bits in parallel. It's often faster for larger numbers but can be harder to understand initially

int n = 13;
n = n - ((n >>> 1) & 0x55555555);
n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
n = (n + (n >>> 4)) & 0x0F0F0F0F;
n = n + (n >>> 8);
n = n + (n >>> 16);
n = n & 0x3F;
System.out.println("Number of set bits: " + n); // Output: 3
```

- Swapping Two Numbers Without a Temporary Variable:
```
int a = 5;
int b = 10;

a = a ^ b;
b = a ^ b;
a = a ^ b;

System.out.println("a: " + a + ", b: " + b); // Output: a: 10, b: 5




This clever trick utilizes the properties of XOR:

x ^ x = 0
x ^ 0 = x
x ^ y = y ^ x
(x ^ y) ^ z = x ^ (y ^ z)
```

- Finding the Next Power of 2:
```
This series of bitwise OR operations with right shifts effectively "fills" all the bits to the right of the most significant bit. Incrementing the result then gives the next power of 2.

int n = 13;
n--;
n |= n >> 1;
n |= n >> 2;
n |= n >> 4;
n |= n >> 8;
n |= n >> 16; // For 32-bit integers
n++;
System.out.println("Next power of 2 for " + 13 + " is: " + n); // Output: 16
```
- 

## JAVA TRICKS
```
- ListNode
- HashMap . computeIfAbsent . add


```




