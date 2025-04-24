# DATA STRUCTURE & ALGORITHMS (In Java)


## ----------------- Contents ------------------
- [DATA STRUCTURE](#DATASTRUCTURE(DS)&Algorithm(Algo))
## -------------- End Of Contents --------------



<h1 id="DATASTRUCTURE(DS)&Algorithm(Algo)"> DATA STRUCTURE (DS) & Algorithm (Algo) </h1>

- What is a data structure ?
    - It's how your data is structured. It could be structured in a list (List of items) or set (set of records) or map (key -> value)
    - You can think it as a small inmemory structured database

- What is an Algorithm ?
    - How fast we process the "structured data" !!
    - A CRUD operation
    - Create/insert     Retrive/Search      Update      Delete




```
                              Object
                            /       \
                        Arrays  Collections
                                        |
                                    Collection
                                    /   |  \
                                List  Queue Set



List -- ArrayList, LinkedList (LinkedList can do basic queue tasks through peek, pool, offer)
Queue -- PriorityQueue, ArrayDequeue (ArrayDequeue also implements Deque interface)
Set -- HashSet, LinkedHashSet, TreeSet (Similiar structure to Map)

List provides - Vector: just synchronized version

                    
                                 Map
                                /   \
                        HashMap     SortedMap
                            |           |
                    LinkedHashMap   NavigableMap
                                        |
                                    TreeMap

Map provides - HashTable: just synchronized version
```

- A DS can be ordered - by insertion or last access
- A DS can be sorted - i.e. their insertion order doesn't mater - their sorting order does


- Array : Insertion fast, Access(unless idx known) : But deletion is complex
- Stack & Queue : Slow access to other items
- LinkedList: Fast insertion & deletion : But slow search

- Binary tree : Fast search, insertion : But deletion complex (unless tree is balanced)
- Red-black & 2-3-4 : Fast search, insertion & always balanced -> complex
- Hash table : Fast insertion & fast access if key known : But Slow deletion & inefficient memory usage
- Heap : Fast insertion, deletion, access to largest item : But Slow access to other item
- Graph: Some algo are slow & complex


## Array DS
- For "A" Searching takes an average of N/2 steps
- For Insertion takes 1step
- For deletion, there is no holes allowed - occupied cells must be arranged contiguously: no holes
- A deletion requires searching through an average of N/2 elements & then moving the remaining elements (an average of N/2 moves) to fill up the resulting hole => Total N steps in all

- Array can be used to handle both primitive & objects mainly 

- The Duplicates Issue
    - Searching : with Duplicates N steps - without Duplicates N/2 steps
    - Insertion : with Duplicates 1 steps - Without duplicates Search N steps But 1 Steps
    - Deletion : with Duplicates N step comparisons, more than N/2 moves - Without duplication N/2 comparisons, N/2 moves




- OOP -&- DS

- Also think of scinario, when you query a idx from one thread & deleted another element from another thread !! how bad that would be !!

- Binary search in an ordered collection

- Being ordered insertion took times but search / deletion was fast
So useful for a scianrio where search is more frequent

Although Deletions are slow in both ordered and unordered arrays because items must be moved down to fill the hole left by the deleted item.



```
In a Binary search of a ordered collection the equation devides "HALF"
For 128 numbers it devides like - 128 64 32 16 8 4 2 1 which ranges from 2^7 .. 2^6 ...... 2^0
which is a function of - 2
    so for 128 the equation is 2^7
Or in the reverse way
    the equarion is log-base2-(128) = 6.sth = 7

________________________________________________________,
log-base(a)of(b) = log-base(c)of(b) / log-base(c)of(a)  |
________________________________________________________|

```

```
-----------------------
The "Big O" notation
-----------------------
A rough measure of algorithms performance
Comparison of algorithms that tells how an algorithm's speed is related to the number of items
As you seen for 64 items it took 6 steps for double it's items i.e. 128 items it just took 1 more step


BIG N - Denotes number of items
BIG T - Times it take


For unsorted array
No matter how big the "N" is (the number of items)
The time taken "T" to iNsErT an item is always constant K


For a Linear SeArCh, Of "N" items it takes N/2 steps at an average
The TIME will be T = K * N / 2      \\k is the constant time for 1 item



However for a binary SeArCh, Of "N" items it takes log2(N) steps at an average
considering the below formula
________________________________________________________,
log-base(a)of(b) = log-base(c)of(b) / log-base(c)of(a)  |
________________________________________________________|
Considering c = 10, We can take log-base2-(10) = 3.322 [the divisor] as constant K
The TIME will be T = K * log2(N)         \\k is the constant time for 1 item & multiplied by 3.322



Big O notation just dispenses the constant K
Just we want to compare is how T changes for different values of N

Big O - Order of



For linear search into an un/ordered array takes O(N) time
For binary search into an ordered array takes O(log N) time


For Insertion into an unordered array takes O(1) time
For Insertion into an ordered array takes O(N) time

Deletion in unordered array O(N) time - searching is N/2 an average & moving is N/2 an average
Deletion in ordered array O(N) time


O(1) is excellent
O(log N) is good
O(N) is fair
O(N2) is poor (Bubble sort)
```

<img src="./images/1-big-o.jpg" alt="Big-o-graph">










## Simple Sorting
- Sorting is So essential (for example in binary search) there exists a lots of algorithms
    - Bubble Sort
    - Selection Sort
    - Insertion Sort

The insertion sort, is preferable to quicksort for small files & for almost-sorted files
In fact, an insertion sort is commonly used as a part of a quicksort implementation

### Bubble Sort
- Taking two (A, B) at a time : return value is : -ve 0 +ve
    -ve : A < B
    0 : A = B
    +ve : A > B
Keep doing this to push the largest one to extreme right : you made N-1 comparisions & around N-1 swaps
once done this

```
    in - index 0
    nElems - no of elements
    out - nElems-1

    -------------------------------------------------------------------
    BubbleSort.java
    -------------------------------------------------------------------
    public class HelloWorld {
        public static int a[] = {3,4,2,1};

        public static void main(String []args) {
            bubbleSort();
            for (int b : a)
                System.out.println(b);
        }

        public static void bubbleSort() {
            for(int lengthAsIdx = a.length - 1; lengthAsIdx > 0;lengthAsIdx--) // 3 2 1
                for(int in=0; in<lengthAsIdx; in++)  // MAX-2   MIN-1   (lengthAsIdx)
                    if(a[in] > a[in+1])      // SWAP 2 - 3
                        swap(in, in+1);
        }

        private static void swap(int one, int two) {
            long temp = a[one];
            a[one] = a[two];
            a[two] = (int)temp;
        }
    }

    THINKING IT REVERSE
    We are swapping -- swap(in, in+1); <-- Hence we must make 1 short so we can do in+1 operation
    We have to Preserve the RightMost(1st)/NextRight(subsequent) elements for each iteration
    Bcz the RightMost(1st)/NextRight(subsequent) are very sorted

    THE KEY POINT IN THIS ALGORITHM IS - swap(in, in+1);
    /** swapping index & index+1 basedon comparision & Preserving the Right side */


    `````````````````````````````````````````````
    `   // @TODO - To report erreta on book     `
    `````````````````````````````````````````````


    -------------------------------------------
    The bubbleSort() method
    -------------------------------------------
    Considering 4 elements
    For outer Loop out=3
    The inner Loop in=0->1->2
    Seeing swap(in, in+1); --> the final


```

-  There are conditions that remain unchanged as the algorithm proceeds. These conditions are called invariants
- you can repeatedly check that the invariant is true, and signal an error if it isn't

- Thus, the algorithm makes about
```
(N-1) + (N-2) + (N-3) + ... + 1 = N*(N-1)/2
N*(N-1)/2
N2/2 comparisons
```
- There are fewer swaps than there are comparisons because two numbers are swapped only if they need to be
- If the data is random, a swap is necessary about half the time, so there will be about N^2/4
- Both swaps and comparisons are proportional to N2. Because constants don't count in Big O notation, we can ignore the 2 and the 4 and say that the bubble sort runs in O(N2) time

- The outer loop executes N times, and the inner loop executes N => N*N = N^2

### Selection Sort
- The selection sort improves on the bubble sort by reducing the number of swaps necessary from O(N2) to O(N). Unfortunately, the number of comparisons remains O(N2). However, the selection sort can still offer a significant improvement for large records that must be physically moved around in memory

- The Shrtest will be remembered & moves to the extreme left (Not 2 at a time will be compared)
```
public void selectionSort() {
    int out, in, min;
    for(out=0; out<nElems-1; out++) { // outer loop
        min = out;                     // minimum
        for(in=out+1; in<nElems; in++) // inner loop
            if(a[in] < a[min])  min = in;
        swap(out, min);
    }
}
```

### Insertion Sort
- Works when A collection is "PARTIALLY SORTED" [IMP]
- From the other unsorted list, it finds minimum & try to fill in the partially sorted
- The algorithm starts by ""assuming the very first element (at index 0) is already a sorted"" sub-list on its own
- On the first pass/item, it compares a maximum of one item (with 0th idx item)
- On the second pass, it's a maximum of two items (with 0th & 1st idx) & so on, up to a maximum of N-1 comparisons on the last pass

- What it does
- Let's say it founds a item towds right & it shifts to left before the marker (,)
- What empty space created, It push the items to fill the empty items
- Before ||,||||
- After  ||,||_| & temp=|
- After  ||_,||| & temp=|
- After  |||,||| NO temp

- To move this small item to its proper place on the left, all the intervening items (between the place where it is and where it should be) must be shifted one space right
- This step takes close to N copies, just for one item.
- Not all the items must be moved a full N spaces, But the average item must be moved N/2 spaces
- Which takes N times N/2 shifts for a total of N^2/2 copies
- Performance = O(N^2)

```
1 + 2 + 3 + ... + N-1 = N*(N-1)/2
```
However, because on each pass an average of only half of the maximum number of items are actually compared before the insertion point is found, we can divide by 2, which gives
```
N*(N-1)/4
```

- The number of copies is approximately the same as the number of comparisons. However, a copy isn't as time-consuming as a swap, so for random data this algorithm runs twice as fast as the bubble sort and faster than the selection sort
- O(N^2) time for random data
- Space Complexity: O(1) - It's an in-place sorting algorithm, meaning it requires only a constant amount of extra memory space 

```
public static void sort(int[] arr) {
    int n = arr.length;
    // Start from the second element (index 1)
    // The first element (index 0) is considered the initial sorted subarray
    for (int i = 1; i < n; ++i) {
        int key = arr[i]; // The element to be inserted into the sorted portion
        int j = i - 1;    // Index of the last element in the sorted portion

        /* Move elements of arr[0..i-1] that are greater than key,
            one position ahead of their current position */
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]; // Shift the larger element to the right
            j = j - 1;          // Move to the previous element
        }
        // Place the key (original arr[i]) in its correct sorted position
        arr[j + 1] = key;
    }
}
```


- Stability
- A sorting algorithms retain the preveous sorting order are said to be stable.


## Stacks & Queue & Priority Queue

### Stacks
- Only one item can be read or removed at a given time (unless you cheat)
- Methods : push() pop() peek() [readonly]
- The push/pop is efficient = constant O(1) time
- Using stack wrapper - make certain type of algorithms (LIFO) less error prone

### Queues
- Methods: put or add       delete or get       peek    remove()
- Circular Queue - As queue removed from 1st & added from last, there are "spaces around the front"
    - The Front & Rear arrows wrap around to the beginning of the array
    - The result is a circular queue (sometimes called a ring buffer)
    - In a circular Queue for a scinario - the front & rear at the same idx i.e. 0 => empty / full @ same time
    - This problem can be solved by making the array one cell larger than the maximum number of items that will be placed in it
    - So even if rear @ 0th idx the front is sm where @ 9th idx
- The efficiency of Queue is still O(1) time

### Deques
- Insert items at either end & delete them from either end
- insertLeft()/insertRight() & removeLeft()/removeRight()
- THis is a more versatile data structure than either a stack or a queue and is sometimes used in container class libraries to serve both purposes.
- However, it's not used as often as stacks and queues


### Priority Queues
- items are ordered by key value so that the item with the lowest key (or in some implementations the highest key) is always at the front
- ues case: preemptive multitasking operating system
- priority queues are, as we noted earlier, often implemented with a data structure called a heap
- In an underlying array implement,
    - The [minimum] value is always at [front] & [largest] item is always at reaer [index-0]
    - When you put a value in between the item will be shifted to make room for the current value
    - The rear arrow always at 0 idx,, items at front are removed only
    - Here insertion is costly but the deletion is not (deletion reqd search & then fill the empty space)
- For larger numbers of items, or when speed is critical, the heap is a better choice, then array
- insertion runs in O(N) (devided by 2!!) time, while deletion takes O(1) time



## Linked Lists
- LinkedList most commonly used after array
- LL is more preferred over an array unless you need frequent random access to individual items using an index
- [Philosophy]
    - When you do an implementation with help of array, its quite fantastic
    - But, when you arrange items without an array
    - The best approach would be to have one object holds address of another !
    - Unlike array you can't directly go to 6th or 7th index, rather you would start from 1st element
    - & from there you will make progress till 6th or 7th

### [Approach-1-Unsorted] (You can insert links anywhere in the list)
- A Link object contains a reference to the next link in the list
    ```
        class Link {
            public int iData;
            public double dData;
            public Link next;
        }
    ```
    - When you search it looks for the "LINK" scanning one by one
    - When you try to Delete, It tries to find the LINK, once link found it deletes that link
    - & connects the arrow from the previous link straight across to the following link


#### A Simple Linked List
    - insertFirst()     deleteFirst()   displayList()
    - find() : checks in every item starting from the first
    - delete() : is similar to find() in the way it searches for the link to be deleted
    - insertAfter() : finds a link with a specified key value & insert a new link following it

#### Double-Ended Lists (FirstLastList)
- The 1st element has link to 2nd & the last element
- With having reference to the last link
- You can insert a new link directly at the end of the list as well as at the beginning of the list
- Repeated insertions at the front of the list reverse the order of the items, while repeated insertions at the end preserve the order
- This have a new method : insertLast()

```

    class FirstLastList {
        private Link first;
        private Link last;
    }

    new FirstLastList().insertFirst()
    Or
    new FirstLastList().insertLast()

```

- The insertion & deletion routines are similar to those in a single-ended list
- However, both insertion routines must watch out for the special case
- When the list is empty prior to the insertion - If isEmpty() is true
    - Then insertFirst() must set [last] to the new link
    - The insertLast() must set [first] to the new link
    - Deleting from the start of the list is also a special case if it's the last item on the list: last must be set to point to null in this case
- Insertion and deletion at the beginning of a linked list are very fast O(1)
- Finding, deleting, or inserting next to a specific item requires searching through, on the average, half the items in the list. This requires O(N)
- One advantages over array is that, There is [NO SIZE LIMITATION]

```
!!!
- Unfortunately, making a list double-ended doesn't help you to delete the last link because there is still no reference to the next-to-last link, whose next field would need to be changed to null if the last link were deleted. To conveniently delete the last link, you would need a doubly linked list
```

#### Abstract Data Types (ADTs)
- You can implement a STACK / QUEUE with linkedlist (instead of an array)
- ADT are data types - that hides actual implementation from user of it & only exposes the API

- By decoupling the specification of the ADT from the implementation details, you can simplify the design process
- once the ADT has been designed, the underlying data structure must be carefully chosen to make the specified operations as efficient as possible. If you need random access to element N, for example, the linked-list representation isn't so good because random access isn't an efficient operation for a linked list. You'd be better off with an array
- If u r designing an ADT u should be clear what should be a basic data structure or which would be an ADT


### [Approach-2-Sorted-Lists]
- In a sorted list, the items are arranged in sorted order by key value
- Deletion is often limited to the smallest (or the largest) item in the list, which is at the start of the list
- although sometimes find() & delete() methods, which search through the list for specified links, are used as well
- The advantages of a sorted list over a sorted array are speed of insertion (because elements don't need to be moved)
- A sorted list can also be used to implement a priority queue, although a heap
- Insertion
    - Keep checking with while loop
    - Till the link currently being examined (current.dData) is no longer smaller than the key of the link being inserted (key)
    - while loop also terminates if current is null
    - or the list may be empty;  previous will be null; so we set first to the new link
- Delete
    - Removal always from the front (The lowest one)

- Efficiency
    - Insertion and deletion of arbitrary items in the sorted linked list require O(N) comparisons (N/2 on the average)
    - The minimum value can be found, or deleted, in O(1) time

- If an application frequently accesses the "minimum item" & fast insertion isn't critical, then a sorted linked list is an effective choice
- A priority queue might be implemented by a sorted linked list, for example


- List Insertion Sort
    - To sort an array of unsorted data items you can use Sorted list - first addd to sorted list & then remove from it
    - This type of sort turns out to be substantially more efficient than the more usual insertion sort within an array, described in Chapter 3, "Simple Sorting," because fewer copies are necessary. It's still an O(N2) process because inserting each item into the sorted list involves comparing a new item with an average of half the items already in the list, and there are N items to insert, resulting in about N2/4 comparisons. However, each item is copied only twice: once from the array to the list and once from the list to the array. N*2 copies compares favorably with the insertion sort within an array, where there are about N2 copies
    - The downside of the list insertion sort, compared with an array-based insertion sort, is that it takes somewhat more than twice as much memory: The array and linked list must be in memory at the same time

### Doubly Linked Lists
- NOT TO BE CONFUSED WITH,  double-ended list
- A potential problem with ordinary linked lists is that it's difficult to traverse backward along the list (Always NEXT)

 - Doubly Linked List as Basis for Deques :: In a deque you can insert/delete at either end, & the doubly linked list provides this capability


## Iterators
- ommonly called iterators or sometimes, as in certain Java classes, enumerators
- Its a separate object , than Link
- It points to Link
- There can be multiple iterator on same List
```
class ListIterator() {
   private LinkList ourList;   // reference to "parent" list

   private Link current;
   private Link previous;

   public void nextLink() {
    previous = current;
    current = current.next;
   }
}

LinkList theList = new LinkList();
ListIterator iter1 = theList.getIterator();
```

- reset() - Sets the iterator to the start of the list
- nextLink() - Moves the iterator to the next link
- getCurrent() - Returns the link at the iterator
- atEnd() - Returns true if the iterator is at the end of the list
- insertAfter() - Inserts a new link after the iterator
- insertBefore() - Inserts a new link before the iterator
- deleteCurrent() - Deletes the link at the iterator

- Deciding which tasks should be carried out by an iterator and which by the list itself is not always easy
- An insertBefore() method works best in the iterator, but an insertFirst() routine that always inserts at the beginning of the list might be more appropriate in the list class



## Recursion
### Triangular Numbers
- 1, 3, 6, 10, 15, 21...... i.e. (+1, +2, +3, +4, +5 ......)
- @3rd Position => 3 + 2 + 1
- @5th Position => 5 + 4 + 3 + 2 + 1
- @nth Position => n + n-1 + ...

- total += n;   n--;
- Or you can apply recursion
- Or nth triangular number = (n^2+n)/2

- Calling a method involves certain overhead. Control must be transferred from the location of the call to the beginning of the method
- In addition, the arguments to the method and the address to which the method should return must be pushed onto an internal stack so that the method can access the argument values and know where to return

- Another inefficiency is that memory is used to store all the intermediate arguments and return values on the system's internal stack. This may cause problems if there is a large amount of data, leading to stack overflow.
- Recursion is usually used because it simplifies a problem conceptually, not because it’s inherently more efficient.
- mathematical induction
```
tri(n) = 1                 if n = 1
tri(n) = n + tri(n-1)      if n > 1
```
### Factorials
- Factorials are similar in concept to triangular numbers, except that multiplication is used instead of addition
- 5*4*3*2*1
- The factorial of 0 is defined to be 1.
- if(n==0) return 1;
- arious other numerological entities lend themselves to calculation using recursion in a similar way, such as finding the greatest common denominator of two numbers (which is used to reduce a fraction to lowest terms), raising a number to a power, and so on.
- Again, while these calculations are interesting for demonstrating recursion, they probably wouldn't be used in practice because a loop-based approach is more efficient.
### Anagrams
- A permutation is an arrangement of things in a definite order
- cat => cat cta atc act tca tac
- For 3 letters there are 6 possible words;
- for 4 letters there are 24 words;
- for 5 letters, 120; and so on
- One way of thinking : keep the first letter & rotate next 2
- For more than 3 lettter ? doing a horizeontal recurssion helps !!

```

@TODO

```

### A Recursive Binary Search
-

```
public int find(long searchKey)
   {
   int lowerBound = 0;
   int upperBound = nElems-1;
   int curIn;

   while(true)
      {
      curIn = (lowerBound + upperBound ) / 2;
      if(a[curIn]==searchKey)
         return curIn;              // found it
      else if(lowerBound > upperBound)
         return nElems;             // can't find it
      else                          // divide range
         {
         if(a[curIn] < searchKey)
            lowerBound = curIn + 1; // it's in upper half
         else
            upperBound = curIn - 1; // it's in lower half
         }  // end else divide range
      }  // end while
   }  // end find()
```

- Recursive approach
```
  private int recFind(long searchKey, int lowerBound, int upperBound) {
   int curIn;

   curIn = (lowerBound + upperBound ) / 2;
   if(a[curIn]==searchKey)
      return curIn;              // found it
   else if(lowerBound > upperBound)
      return nElems;             // can't find it
   else                          // divide range
      {
      if(a[curIn] < searchKey)   // it's in upper half
         return recFind(searchKey, curIn+1, upperBound);
      else                       // it's in lower half
         return recFind(searchKey, lowerBound, curIn-1);
      }  // end else divide range
   }
```

### Divide-and-Conquer Algorithms
- binary search is an example of the divide-and-conquer approach
- Just that its not solved with concurrent approach


### The Towers of Hanoi
- All the disks start out on column A. The object of the puzzle is to transfer all the disks from column A to column C. Only one disk can be moved at a time, and no disk can be placed on a disk that’s smaller than itself.
- Thinking from the opposite/i.e. from reverse
- Imagine you have only one largest disk at Source tree & all other are in Intermediate tree
- So now you can move from Source to destination & then folowed by all the subsequent disks
```
public static void main(String[] args) {
    doTowers(nDisks, 'A', 'B', 'C');
}

public static void doTowers(int topN, char from, char inter, char to) {
    if(topN==1)
        System.out.println("Disk 1 from " + from + " to "+ to);
    else {
        doTowers(topN-1, from, to, inter);  // from-->inter
        System.out.println("Disk " + topN + " from " + from + " to "+ to);
        doTowers(topN-1, inter, from, to);  // inter-->to
    }
}

S - Source (A)
I - Intermediate (B)
D - Destination (C)

Enter (3 disks): s=A, i=B, d=C
   Enter (2 disks): s=A, i=C, d=B
      Enter (1 disk): s=A, i=B, d=C
         Base case: move disk 1 from A to C
      Return (1 disk)
      Move bottom disk 2 from A to B
      Enter (1 disk): s=C, i=A, d=B
         Base case: move disk 1 from C to B
      Return (1 disk)
   Return (2 disks)
   Move bottom disk 3 from A to C
   Enter (2 disks): s=B, i=A, d=C
      Enter (1 disk): s=B, i=C, d=A
         Base case: move disk 1 from B to A
      Return (1 disk)
      Move bottom disk 2 from B to C
      Enter (1 disk): s=A, i=B, d=C
         Base case: move disk 1 from A to C
      Return (1 disk)
   Return (2 disks)
Return (3 disks)

```

### mergesort
- The heart of the mergesort algorithm is the merging of two already-sorted arrays
- It requires an additional array in memory (Downside)
- However, if you have enough space, it's a good choice
- If you have a array of size 8 devide it 4A - 4B
    - For 4A devide it to 2AA & 2AA & while devide insrt it in order    => 4AA
    - Do the same Process for 4B - 2BB & 2BB                            => 4BB
    - Then comapre the 0th idx from 4AA & oth idx from 4BB & merge them into a destination arrray 4DD
- Speed/Time mergesort is O(N*logN)

- There are 24 copies necessary to sort 8 items [2+2+4] & [2+2+4] & merging them => + 8 = 24
- The log-base(2)of(8) = 3
- So 8*log-base(2)-of-8 = 24
- 
- & multiplying *2 bcz they are also getting copied back to origional array
- 
- 
- 
- As we break the array into subarray of 2 it becomes the function of 2 (i.e *2 => ^2)
- I.e. For 2 items 4 (2^2) copies reqd
- For 4 items 8 (2^3) copies reqd
- For 8 items 24 (2^4) copies reqd

- It's conceptually easier than quicksort and the Shell short


### Eliminating Recursion
- Sometimes recursive triangle() & factorial() methods can be implemented more efficiently using a simple loop
- However, various divide-and-conquer algorithms, such as mergesort, work very well as recursive routines

```

## @TODO - Eliminating Recursion

```

### The Knapsack Problem
- For example, suppose you want your knapsack to weigh exactly 20 pounds
- And you have five items, with weights of 11, 8, 7, 6, and 5 pounds
- A solution can be 8+7+5

    - Start by selecting the first item
    - Try, one by one, each of the possible combinations of the remaining items.
    - If none of the combinations work, discard the first item, and start the whole process again with the second item.

### Combinations: Picking a Team
- combination is a selection of things in which their order doesn't matter
- A, B, C, D, E


## Advanced Sorting
- We discussed simple sorts : "bubble", "selection" & "insertion" sorts,, They are easy to implement but are rather slow
-  The "mergesort" runs much faster than the simple sorts but requires twice as much space as the original array
- 
- 
- The "Shellsort" in about O(N*(logN)2) time & "quicksort" in O(N*logN) time
- Neither of these sorts requires a large amount of extra space
- 
- The "Shellsort" is almost as easy to implement as mergesort
- While "quicksort" [partitioning] is the fastest of all the 'general-purpose' sorts
- 
- The "Radix sort", an unusual and interesting approach to sorting
- 

### Shellsort
- This is good for medium-sized arrays, perhaps up to a few thousand items
- Some experts (see Sedgewick) recommend starting with a Shellsort for almost any sorting project & changing to a more advanced sort, like quicksort, only if Shellsort proves too slow in practice
- 
- 
- In the INSERTION SORT
- To move this small item to its proper place on the left, all the intervening items (between the place where it is and where it should be) must be shifted one space right
- This step takes close to N copies, just for one item.
- Not all the items must be moved a full N spaces, But the average item must be moved N/2 spaces
- Which takes N times N/2 shifts for a total of N^2/2 copies
- Thus, the performance of insertion sort is O(N^2)
- 
- 
- This performance could be improved if we could somehow move a smaller item many spaces to the left "without shifting all the intermediate items individually"
- 
- 
##### How it works
```
If you have 10 unsorted items, it breaks from half (5-sort)
If you have 11 unsorted items, it breaks from half (5-sort)
it sawp 5-0, 6-1 ... 9-4, [10-5 & 5-0]

It first does 5 then for each 5 it does 2 & for each 2 it does 1

[Check ShellSortWithInterval.java]
```


##### N-Sorting
- The Shellsort achieves these large shifts by insertion-sorting widely spaced elements
- After they are sorted, it sorts somewhat less widely spaced elements & so on
- The spacing between elements for these sorts is called the increment
- and is traditionally represented by the letter "h"
- 
- For example we can take "4-Sorting"
- In 1st index we will take [0, 4 & 8]          =>  (0,4,8)
- In next iteration we will take [1, 5 & 9]     =>  (1,5,9)
- process continues until all the elements have been 4-sorted
- Then the item will be sorted like - (0,4,8) (1,5,9) (2,6) & (3,7)
- So array being "almost" sorted
- Now we can do Insertion sort - i.e. Shell sort of "1-Sorting"
- 
- This Diminishing Gaps for larger array should be effectively managed
- For instance, an array of 1,000 items might be
- 364-sorted, then 121-sorted, then 40-sorted, then 13-sorted, then 4-sorted & finally 1-sorted
- Knuth's Interval Sequence
```
The h=h*3+1 applied to generate sequence 1, 4, 13, 40, 121, 364 ...

For a 1,000-element array, the seventh number in the sequence, 1,093, is too large
Thus, we begin the sorting process with the sixth-largest number - i.e. creating a 364-sort


Then, each time through the outer loop of the sorting routine,
we "reduce the interval" using the inverse of the formula previously given:
h = (h-1) / 3


    h = 3*h+1     (h-1)/3
    1     4
    4     13      1
    13    40      4
    40    121     13
    121   364     40
    364   1093    121

```

```
    -----------------------------------------------------------------
    Java code
    -----------------------------------------------------------------
    public void shellSort() {
        int inner, outer;
        long temp;
        int h = 1;                                      /** find initial value of h */
        while(h <= nElems/3)
            h = h*3 + 1;                                /** (1, 4, 13, 40, 121, ...) */
            while(h>0) {                                /** decreasing h, until h=1 */
                for(outer=h; outer<nElems; outer++) {   /** H-sort */
                    temp = theArray[outer];
                    inner = outer;                      /** one subpass (eg 0, 4, 8) */
                    while(inner > h-1 && theArray[inner-h] >=  temp) {
                        theArray[inner] = theArray[inner-h];
                        inner -= h;
                    }
                    theArray[inner] = temp;
                }
                h = (h-1) / 3;                          /** decrease h */
            }
    }

    A=20 89 6 42 55 59 41 69 75 66
    A=6 20 41 42 55 59 66 69 75 89
```
- Shellsort so much faster than the insertion sort because
- When h is large, the number of items per pass is small, and items move long distances
- This is very efficient. As h grows smaller, the number of items per pass increases, but the items are already closer to their final sorted positions, which is more efficient for the insertion sort
- 
- 
- Notice that later sorts (small values of h) don't undo the work of earlier sorts (large values of h)
- An array that has been 40-sorted remains 40-sorted after a 13-sort, for example. If this wasn't so, the Shellsort couldn't work
- It might seem more obvious for the algorithm to 4-sort each complete subarray first-(0,4), (0,4,8), (1,5), (1,5,9), (2,6), (3,7)-but the algorithm handles the array indices more efficiently using the first scheme.

- The Shellsort is actually NOT very efficient with only 10 items, making almost as many swaps and comparisons as the insertion sort. However, with 100 bars the improvement becomes significant.


- Picking an interval sequence is a bit of a black art. Our discussion so far used the formula h=h*3+1 to generate the interval sequence, but other interval sequences have been used with varying degrees of success. The only absolute requirement is that the diminishing sequence ends with 1, so the last pass is a normal insertion sort.

- In Shell's original paper, he suggested an initial gap of N/2, which was simply divided in half for each pass. Thus, the descending sequence for N=100 is 50, 25, 12, 6, 3, 1. This approach has the advantage that you don't need to calculate the sequence before the sort begins to find the initial gap; you just divide N by 2. However, this turns out not to be the best sequence. Although it's still better than the insertion sort for most data, it sometimes degenerates to O(N2) running time, which is no better than the insertion sort.
- A variation of this approach is to divide each interval by 2.2 instead of 2. For n=100 this leads to 45, 20, 9, 4, 1. This is considerably better than dividing by 2, as it avoids some worst-case circumstances that lead to O(N2) behavior. Some extra code is needed to ensure that the last value in the sequence is 1, no matter what N is. This gives results comparable to Knuth's sequence shown in the listing.

- Another possibility for a descending sequence (from Flamig;)
It's generally considered important that the numbers in the interval sequence are relatively prime; that is, they have no common divisors except 1. This constraint makes it more likely that each pass will intermingle all the items sorted on the previous pass. The inefficiency of Shell's original N/2 sequence is due to its failure to adhere to this rule.
- You may be able to invent a gap sequence of your own that does just as well (or possibly even better) than those shown. Whatever it is, it should be quick to calculate so as not to slow down the algorithm
```
if(h < 5)
   h = 1;
else
   h = (5*h-1) / 11;
```
- 
- 
- Efficiency of the Shellsort
No one so far has been able to analyze the Shellsort's efficiency theoretically, except in special cases. Based on experiments, there are various estimates, which range from 0(N3/2) down to O(N7/6).


- shows some of these estimated O() values, compared with the slower insertion sort and the faster quicksort. The theoretical times corresponding to various values of N are shown. Note that Nx/y means the yth root of N raised to the x power. Thus, if N is 100, N3/2 is the square root of 1003, which is 1,000. Also, (logN)2 means the log of N, squared. This is often written log2N, but that’s easy to confuse with log2N, the logarithm to the base 2 of N.

```
Estimates of Shellsort Running Time

O() Value       Type of Sort        10 Items        100 Items       1,000 Items     10,000 Items
--------------------------------------------------------------------------------------------------
N^2             Insertion, etc.     100             10,000          1,000,000       100,000,000
N^3/2           Shellsort           32              1,000           32,000          1,000,000
N*(logN)2       Shellsort           10              400             9,000           160,000
N5/4            Shellsort           18              316             5,600           100,000
N7/6            Shellsort           14              215             3,200           46,000
N*logN          Quicksort, etc.     10              200             3,000           40,000

- For most data, the higher estimates, such as N3/2, are probably more realistic.

```
-  ...........................
- | TO KNOW MORE REFER BOOK   |
-  ...........................

### Partitioning
- Partitioning is the underlying mechanism of quicksort
- It takes an approximate/average/pivot point & number that are <= fall in Left & > fall in Right
- You can wisely choose any value you want for the pivot value

- The two pointers start at opposite ends of the array and move toward each other at a more or less constant rate, stopping and swapping as they go. When they meet, the partition is complete.

    - When leftPtr encounters a data item smaller than the pivot value, it keeps going because that item is already on the correct side of the array. However, when it encounters an item larger than the pivot value, it stops.

    - Similarly, when rightPtr encounters an item larger than the pivot, it keeps going, but when it finds a smaller item, it also stops.
```
public int partitionIt(int left, int right, long pivot) {
    int leftPtr = left - 1;           // right of first elem
    int rightPtr = right + 1;         // left of pivot
    
    while(true) {
        while(leftPtr < right && [[[[theArray[++leftPtr] < pivot]]]] )
                ;  // find bigger item (nop - no operation)
        while(rightPtr > left && [[[[theArray[--rightPtr] > pivot]]]] )
                ; // find smaller item (nop)


        if(leftPtr >= rightPtr)        // if pointers cross,
            break;                      //    partition done        - Break INFINITY
        else                           // not crossed, so
            swap(leftPtr, rightPtr);    //    swap elements
    }  // end while(true)

    return leftPtr;                   // return partition
}

---

main() {
    long pivot = 99;              // pivot value - choose wisely !!
    System.out.print("Pivot is " + pivot);
    int size = arr.size();      // partition array
    int partDex = arr.partitionIt(0, size-1, pivot);
}

```
- EDGE CASES
    - 

- Efficiency of the Partition Algorithm
    - Running time is proportional to N     ->      O(N) time
    - More specifically, for each partition there will be N+1 or N+2 comparisons
    - the pointers overshoot each other before they find out they've "crossed" or gone beyond each other, so there are one or two extra comparisons before the partition is complete.
    - The number of swaps, however, does depend on how the data is arranged. (MAX ~ N/2 swaps)


- Lomuto Partition Scheme
    - This scheme maintains an index i that points to the end of the "less than pivot" section. It iterates through the subarray, and whenever it encounters an element less than or equal to the pivot, it swaps that element with the element at index i and increments i. Finally, it swaps the pivot with the element at index i.
- Hoare Partition Scheme
    - This scheme uses two pointers, one starting from the left and one from the right of the subarray. The left pointer moves right until it finds an element greater than or equal to the pivot, and the right pointer moves left until it finds an element less than or equal to the pivot. These two elements are then swapped. The process continues until the pointers cross.





- Also see, Partitioning in Data Mining & Machine Learning 
    - Clustering Algorithms (K-Means)
    - Data Preprocessing





### quicksort
- A simple steps
```
public void recQuickSort(int left, int right) {
   if(right-left <= 0)        // if size is 1,
       return;                //    it's already sorted
   else {                       // size is 2 or larger partition range
      int partition = partitionIt(left, right);
      recQuickSort(left, partition-1);   // sort left side
      recQuickSort(partition+1, right);  // sort right side
    }
}
```
- A pivot value partition the array into 2 sub-array
- Which results     [subarray-1    --  The pivot value     -- subarray-2]
    - subarray-1: 0 to partition-1
    - subarray-2: partition+1 to right
- the pivot value is allready sorted
- The other 2 subarray calls themselves reccursively to sort
- It often choose from the rightmost element & try to fit starting from left
(Provided no smaller element not onto the right)

- to sort 100 inversely sorted bars, you'll see that the algorithm runs much more slowly
- problem is in the selection of the pivot. Ideally, the pivot should be the median of the items being sorted. That is, half the items should be larger than the pivot, and half smaller
- The worst situation results when a subarray with N elements is divided into one subarray with 1 element and the other with N-1 elements.
- If this 1 and N-1 division happens with every partition, then every element requires a separate partition step. This is in fact what takes place with inversely sorted data: In all the subarrays, the pivot is the smallest item, so every partition results in N-1 elements in one subarray and only the pivot in the other.
- performance of the algorithm degenerates to O(N^2)
- 
- Median-of-Three Partitioning
    - To find a good pivot, we used to find the median of the first, last, and middle elements of the array, and use this for the pivot. Picking the median of the first, last, and middle elements is called the median-of-three approach
    - The number 3 in this case is called a cutoff point
- Another option for dealing with small partitions is to use the "insertion sort"
    - When you do this, you aren't restricted to a cutoff of 3. You can set the cutoff to 10, 20, or any other number
    - Knuth recommends a cutoff of 9
    - However, the optimum number depends on your computer, operating system, compiler (or interpreter), and so on.


- Insertion Sort Following Quicksort
    - When quicksort is finished, the array will be almost sorted.
    - You then apply the insertion sort to the entire array.
    - The insertion sort is supposed to operate efficiently on almost-sorted arrays,
    - Also note, The insertion sort appears to be happier doing a lot of small sorts than one big one

- Removing Recursion
    - Another embellishment recommended by many writers is removing recursion from the quicksort algorithm.
    - This involves rewriting the algorithm to store deferred subarray bounds (left and right) on a stack, and using a loop instead
    - The idea in doing this is to speed up the program by removing method calls.
    - However, this idea arose with older compilers and computer architectures, which imposed a large time penalty for each method call.
    - It's not clear that removing recursion is much of an improvement for modern systems, which handle method calls more efficiently.


- Efficiency of Quicksort
    - quicksort operates in the divide-and-conquer algorithms, in which a recursive method divides a range of items into two groups and then calls itself to handle each group
    - n this situation the logarithm actually has a base of 2: The running time is proportional to N*log(2)N
    - Swaps fewer than N/2*log(2)N



### Radix Sort
- Ten 10 is the radix of the decimal system
- Two 2 is the radix of the binary system
- Radix Sort is a non-comparative integer sorting algorithm
- It works by processing digits of each number from least significant to most significant.



- The sort involves examining each digit of the key separately, starting with the 1s (least significant) digit
    - All the data items are divided into 10 groups, according to the value of their 1s digit.
    - These 10 groups are then reassembled: All the keys ending with 0 go first, followed by all the keys ending in 1, and so on up to 9. We'll call these steps a sub-sort.
    - In the second sub-sort, all data is divided into 10 groups again, but this time according to the value of their 10s digit. This must be done without changing the order of the previous sort. That is, within each of the 10 groups, the ordering of the items remains the same as it was after step 2; the sub-sorts must be stable.
    - Again the 10 groups are recombined, those with a 10s digit of 0 first, then those with a 10s digit of 1, and so on up to 9
    - This process is repeated for the remaining digits. If some keys have fewer digits than others, their higher-order digits are considered to be 0.



```
It have 10 buckets
For every pass - it arranges unit digit, ten digit, 100th digit & so on...
0th bucket-
1 bucket-
2 bucket-
3 bucket-
.
.
.
8th bucket-
9th bucket-

In first pass it only consider the unit digit
Preserve the order
In Second pass it only consider the 10th digit
preserve the order
& so on..

```

- Efficiency of the Radix Sort
    - In Radix sort, All you do is copy the original data from the array to the lists & back again
    - If there are 10 data items, this is 20 copies
    - You repeat this procedure once for each digit
    - If you assume, say, """""5-digit""""" numbers, then you'll have 20*5 equals 100 copies
    - If you have 100 data items, there are 200*5 equals 1,000 copies
    - The number of copies is proportional to the number of data items, which is O(N) [most efficient]
    - 
    - 
    - Unfortunately, it's generally true that if you have more data items, you'll need longer keys.
    - If you have 10 times as much data, you may need to add another digit to the key
    - The number of copies is proportional to the number of data items **tim*es** the number of """"digits"""" in the key
    - The number of digits is the log of the key values, so in most situations we’re back to O(N*logN) efficiency, the same as quicksort

    - 
    - 
    - 
    - There are no comparisons, although it takes time to extract each digit from the number
    - It may be, however, that a given computer can do the digit-extraction in binary more quickly than it can do a comparison
    - like mergesort, the radix sort uses about twice as much memory as quicksort






## Binary Trees
- Combines advantages of 2 other structures: (i) An ordered array (ii) A linked list
    - You can search a tree quickly, as you can an "ordered array"
        - An ordered array is a good choice for search, bcz elements are ordered,
        It does search for the half if not found, it search for 2nd half & so on O(logN)
        - Insertion is bad, bcz if you have to insert an item smome where, You need to move rest of the element towards Right
    - you can also insert & delete items quickly, as you can with a "linked list"
        - insert & delete is just mater of O(1) time, just have to cahnge link
        - But search is average of N/2 item which is slow - requireing O(N) time
        - There's no way to access a given element without following the chain

- A "Tree" consists of "NODES" (Entity, Object, Student, Employee, Car) connected by "EDGES" (lines) (link or reference or Has-A)
- Trees have been studied extensively as abstract mathematical entities
- A tree is actually an instance of a more general category called a graph
- The only way to get from node to node is to follow a path along the lines.
- Generally, you are restricted to going in "one direction" along edges: from the root downward.
- 
- A tree can have more than 2 child is reffered as 'multiway trees'
- A binary tree have 2 child & a node have 1 immidiate parent
- A node that has no children is called a leaf node or simply a leaf
- A node is visited when program control arrives at the node
- Merely passing over a node on the path from one node to another is not considered to be visiting the node.
- But carrying out some operation on the node, such as checking the value of one of its data fields or displaying it is considered
- Traversing means to visit all the nodes in some specified order.
- The Lavel starts at 0 zero (From ROOT node)
- Key value is used to search for the item or perform other operations on it
- Two children of each node in a binary tree are called: left child & right child

### binary search tree
- A node's left child must have a key less than its parent, and a node's right child must have a key greater than or equal to its parent
- Example: hierarchical file structure in a computer system (Not Exactly Similiar)
- It diifers In a way, That the file structure, subdirectories contain no data; they contain only references to other subdirectories or to files. Only files contain data. In a tree, every node contains data

```
Folder
/   \
    Folder & Files
        |
    Folder & Files
```

- subtrees may also be unbalanced, they have most of their nodes on one side of the root or the other
- Trees become unbalanced because of the order in which the data items are inserted. If these key values are inserted randomly, the tree will be more or less balanced. However, if an ascending sequence (like 11, 18, 33, 42, 65, and so on) or a descending sequence is generated, all the values will be right children (if ascending) or left children (if descending) and the tree will be unbalanced.
- When this happens, tree efficiency can be seriously degraded

<img src="./images/2-tree-unbalanced.jpg" alt="Big-o-graph">

- 
- 
- The Node Class
```
class Node {
    int iData;          /** used as key value */
    double fData;       /** other data */
    node leftChild;
    node rightChild;

    public void displayNode() {}
}
Some programmers also include a reference to the node’s parent. This simplifies some operations but complicates others
```
- 
- The Tree Class
```
class Tree {
    private Node root;
    public void find(int key) { }
    public void insert(int id, double dd) { }
    public void delete(int id) { }
}
```
- Finding a Node
```
public Node find(int key) {
    Node current = root;
    while(current.iData != key) {
        if(key < current.iData)          /** go left? */
            current = current.leftChild;
        else
            current = current.rightChild; /** or go right? */
        if(current == null)              /** if no child - reached dead end */
            return null;
    }
    return current; /** return node so you can access any of the node's data */
}
```

<img src="./images/2-tree-search.jpg" alt="Big-o-graph">

- The time required to find a node depends on how many levels down it is situated.
- In the above there can be up to 31 nodes, but no more than five levels
- So you can find any node using a maximum of only five comparisons. This is O(log2N) time
- 
- Inserting a Node
    - We start from the root node then reach the node whose left/right is [[[null]]]
    - We add the value there
- 
- Traversing the Tree
    - visiting each node in a specified order
    - Three simple ways to traverse a tree: "preorder", "inorder" & "postorder"
    - The most commonly used for binary search trees is "inorder"
    - Inorder Traversal
        <img src="./images/3-tree-traversal-inorder.jpg" alt="Big-o-graph">

        - Will visit the nodes in ascending order, based on their key values
        - If you want to create a sorted list of the data in a binary tree, this is one way to do it
        - A recursive method to traverse the entire tree is called with a node as an argument
            - Call itself to traverse the node's left subtree
            - Visit the node
            - Call itself to traverse the node's right subtree

            ```
            private void inOrder(node localRoot) {
                if(localRoot != null) {
                    inOrder(localRoot.leftChild);
                    System.out.print(localRoot.iData + " ");
                    inOrder(localRoot.rightChild);
                }
            }
            ```
    - Preorder & Postorder Traversals
        - A binary tree (NOT a binary search tree) can be used to represent an algebraic expression that involves the binary arithmetic operators +, -, /, *.
        - The root node holds an operator,and the other nodes hold either a variable name (like A, B, or C), or another operator.
        <img src="./images/4-tree-traversal-pre-post-order.jpg" alt="Big-o-graph">
        - preorder (prefix notation) would generate the expression
        - Starting on the left, each operator is applied to the next two things in the expression
        - postorder, contains the three steps   "ABC+*"
            - Call itself to traverse the node's left subtree
            - Call itself to traverse the node's right subtree
            - Visit the node
        - apply the last operator in the expression, *, to the first and second things.” The first thing is A, and the second thing is BC+
        - Result "*A+BC"
        - Which then converted to (B+C)
        - Which then converted to A*(B+C)
- Finding Maximum and Minimum Values
    - Max = Rightmost child
    - Min = Left most child or if doesn't have a left child then the last node itself
    ```
    public Node minimum()     // returns node with minimum key value {
        Node current, last;
        current = root;                   // start at root
        while(current != null) {        // until the bottom,
            last = current;                // remember node
            current = current.leftChild;   // go to left child
        }
        return last;
    }

    For Max: Go to right child
        current = current.rightChild;
    ```


- Deleting a Node
    - various cases
        - 1. The node to be deleted is a leaf (has no children)
        - 2. The node to be deleted has one child
        - 3. The node to be deleted has two children
        - 
    - 1. The node to be deleted is a leaf (has no children)
        - simply change the appropriate child field in the node's parent to point to null
        ```
        public boolean delete(int key) { // delete node with given key (assumes non-empty list)
            Node current = root;
            Node parent = root;
            boolean isLeftChild = true;
            while(current.iData != key) {        // search for node
                parent = current;
                if(key < current.iData) { // go left?
                    isLeftChild = true;
                    current = current.leftChild;
                } else {    // or go right?
                    isLeftChild = false;
                    current = current.rightChild;
                }
                if(current == null)             // end of the line, didn't find it
                    return false;
            }  // end while

            if(current.leftChild==null && current.rightChild==null) { // found node to delete
                if(current == root)             // if root,
                    root = null;                 // tree is empty
                else if(isLeftChild)
                    parent.leftChild = null;     // disconnect from parent
                else
                    parent.rightChild = null;
            }
        }
        ```
    - 2. The node to be deleted has one child
        - The one child of the node, to be deleted,, may be either a left or right child
        - There is also a specialized situation: the node to be deleted may be the root, in which case it has no parent and is simply replaced by the appropriate subtree.

        <img src="./images/5-tree-node-deletion.jpg" alt="Big-o-graph">

        ```
        // if no right child, replace with left subtree
        else if(current.rightChild==null)
            if(current == root)
                root = current.leftChild;
            else if(isLeftChild)           // left child of parent
                parent.leftChild = current.leftChild;
            else                           // right child of parent
                parent.rightChild = current.leftChild;
                
            // if no left child, replace with right subtree
        else if(current.leftChild==null)
            if(current == root)
                root = current.rightChild;
            else if(isLeftChild)           // left child of parent
                parent.leftChild = current.rightChild;
            else                           // right child of parent
                parent.rightChild = current.rightChild;
        ```
        - [IMPORTANT] you don't need to worry about moving them individually. In fact, they "move" only in the sense of being conceptually in different positions relative to the other nodes. As far as the program is concerned, only the reference to the root of the subtree has changed.
    - 3. The node to be deleted has two children
        - In the below picture we will try to delete 25
        <img src="./images/6-tree-deleting-node-with-two-children.jpg" alt="Big-o-graph">
        - replace the node with its inorder successor
        <img src="./images/7-tree-deletenode-with-successor.jpg" alt="Big-o-graph">
    - Finding the Successor
        - First, the program goes to the original node's right child, which must have a key larger than the node
        - Then it goes to this right child's left child (if it has one), and to this left child's left child, and so on, following down the path of left children
        - The last left child in this path is the successor of the original node
        <img src="./images/8-tree-finding-successor.jpg" alt="Big-o-graph">
        - Because, you can find the minimum value in a subtree by following the path down all the left children
        - Thus, this algorithm finds the minimum value that is greater than the original node; this is what we mean by its successor
        - If the right child of the original node has no left children, this right child is itself the successor
        <img src="./images/9A-tree-sucessor-with-2-node-no-subleft-children.jpg" alt="Big-o-graph">

        ```
        private node getSuccessor(node delNode) {
            Node successorParent = delNode;
            Node successor = delNode;
            Node current = delNode.rightChild;
            while(current != null) { // go to right child until no more left children,
                successorParent = successor;
                successor = current;
                current = current.leftChild; // go to left child
            }
            if(successor != delNode.rightChild) { // if successor not right child, make connections
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = delNode.rightChild;
            }
            return successor;
        }
        ```

        ```
        else { // two children, so replace with inorder successor
            // get successor of node to delete (current)
            Node successor = getSuccessor(current);
            
            // connect parent of current to successor instead
            if(current == root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // connect successor to current's left child
            successor.leftChild = current.leftChild;
        }  // end else two children
        // (successor cannot have a left child)
        return true;
        ```
        - The code handles the below special cases
        - The successor can be current's ["right child"], or it can be one of this ["right child's"] """left descendants"""
        - Successor Is Right Child of delNode
            - Things are simplified somewhat because we can simply move the subtree of which successor is the root & plug it in where the deleted node was
            - Unplug current from the rightChild field of its parent
            - Unplug current's left child from current, and plug it into the leftChild field of successor
            ```
            parent.rightChild = successor;
            successor.leftChild = current.leftChild;
            ```
            <img src="./images/1B-tree.jpg" alt="Big-o-graph">
            -  Step 1: If the node to be deleted, current, is the root, it has no parent so we merely set the root to the successor. Otherwise, the node to be deleted can be either a left or right child (Figure 8.19 shows it as a right child), so we set the appropriate field in its parent to point to successor. When delete() returns and current goes out of scope, the node referred to by current will have no references to it, so it will be discarded during Java's next garbage collection.
            - Step 2: We set the left child of successor to point to current's left child.
            What happens if the successor has children of its own? First of all, a successor node is guaranteed not to have a left child. This is true whether the successor is the right child of the node to be deleted or one of this right child's left children. How do we know this?

            - Well, remember that the algorithm we use to determine the successor goes to the right child first and then to any left children of that right child. It stops when it gets to a node with no left child, so the algorithm itself determines that the successor can't have any left children. If it did, that left child would be the successor instead.
            - You can check this out. No matter how many trees you make, you'll never find a situation in which a node's successor has a left child (assuming the original node has two children, which is the situation that leads to all this trouble in the first place).
            - On the other hand, the successor may very well have a right child. This isn't much of a problem when the successor is the right child of the node to be deleted. When we move the successor, its right subtree simply follows along with it. There's no conflict with the right child of the node being deleted because the successor is this right child.

        - Successor Is Left Descendant of Right Child of delNode
            - 1. Plug the right child of successor into the leftChild field of the successor's parent
            - 2. Plug the right child of the node to be deleted into the rightChild field of successor
            - 3. Unplug current from the rightChild field of its parent, and set this field to point to successor
            - 4. Unplug current's left child from current, and plug it into the leftChild field of successor.
            <img src="./images/1C-Tree.jpg" alt="Big-o-graph">
            - Steps 1 and 2 are handled in the getSuccessor() routine, while 3 and 4 are carried out in delete().
            ```
            1. successorParent.leftChild = successor.rightChild;
            2. successor.rightChild = delNode.rightChild;
            3. parent.rightChild = successor;
            4. successor.leftChild = current.leftChild;
            ```
            - (Step 3 could also refer to the left child of its parent.) The numbers in Figure show the connections affected by the four steps. Step 1 in effect replaces the successor with its right subtree. Step 2 keeps the right child of the deleted node in its proper place (this happens automatically when the successor is the right child of the deleted node). Steps 1 and 2 are carried out in the if statement that ends the getSuccessor() method shown earlier.
            ```
            if(successor != delNode.rightChild) { // if successor not right child, make connections
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = delNode.rightChild;
            }
            ```
            - These steps are more convenient to perform here than in delete(), because in getSuccessor() we can easily figure out where the successor's parent is while we're descending the tree to find the successor.
            - Steps 3 and 4 we've seen already; they're the same as steps 1 and 2 in the case where the successor is the right child of the node to be deleted, and the code is in the if statement at the end of delete()

- Is Deletion Necessary?
- Some programmers try to sidestep it altogether. They add a new Boolean field to the node class, called something like isDeleted. To delete a node, they simply set this field to true.
- This approach is a bit of a cop-out, but it may be appropriate where there won't be many deletions in a tree.

- The Efficiency of Binary Trees
    - In a full tree, about half the nodes are on the bottom level.
    - Thus, about half of all searches or insertions or deletions require finding a node on the lowest level.
    - During a search we need to visit one node on each level
    ```
    Number of Nodes         Number of Levels
        1                           1
        3                           2
        7                           3
        15                          4
        31                          5
        ...                         ...
        1,023                       10
        ...                         ...
        32,767                      15
        1,048,575                   20
        33,554,432                  25
        1,073,741,824               30
    ```
    - The number of comparisons for a binary search was approximately equal to the base 2 logarithm of the number of cells in the array
    - if we call the number of nodes in the first column N,
    - and the number of levels in the second column L,
    - we can say that N is 1 less than 2 raised to the power L, or N = 2^L - 1
    - Adding 1 to both sides of the equation, we have N + 1 = 2^L
    - This is equivalent to L = log(base 2)of(N + 1)
    - In Big O notation we say such operations take O(logN) time.
    - Thus, a tree provides high efficiency for all the common data storage operations.
    - Traversing is not as fast as the other operations. However, traversals are probably not very commonly carried out in a typical large database. They're more appropriate when a tree is used as an aid to parsing algebraic or similar expressions, which are probably not too long anyway.

### Trees Represented as Arrays
- In the array approach, the nodes are stored in an array and are not linked by references. The position of the node in the array corresponds to its position in the tree. The node at index 0 is the root, the node at index 1 is the root's left child, and so on,
- Progressing from left to right along each level of the tree
- Every position in the tree, whether it represents an existing node or not, corresponds to a cell in the array. Adding a node at a given position in the tree means inserting the node into the equivalent cell in the array. Cells representing tree positions with no nodes are filled with 0 or null.
- With this scheme, a node's children and parent can be found by applying some simple arithmetic to the node's index number in the array.
- If a node's index number is index, this node's left child is
2*index + 1

its right child is
2*index + 2

and its parent is
(index-1) / 2
- In most situations, representing a tree with an array isn't very efficient. Unfilled nodes and deleted nodes leave holes in the array, wasting memory. Even worse, when deletion of a node involves moving subtrees, every node in the subtree must be moved to its new location in the array, which is time-consuming in large trees.
- However, if deletions aren't allowed, the array representation may be useful, especially if obtaining memory for each node dynamically is, for some reason, too time-consuming. The array rep


### Duplicate Keys
- a node with a duplicate key will be inserted as the right child of its twin
- The problem is that the find() routine will find only the first of two (or more) duplicate nodes. The find() routine could be modified to check an additional data item, to distinguish data items even when the keys were the same, but this would be (at least somewhat) time-consuming.
- One option is to simply forbid duplicate keys. When duplicate keys are excluded by the nature of the data (employee ID numbers, for example), there's no problem. Otherwise, you need to modify the insert() routine to check for equality during the insertion process, and abort the insertion if a duplicate is found.


### The Huffman Code
- Is an "Algorithm" that uses a binary tree in a surprising way to "compress data"
- In English, E is often the most common letter & On the other hand, Z is seldom used


- There are several approaches to compressing data
- For text, the most common approach is
- To reduce the number of bits that represent the most-used characters & using a large number of bits for less commonly used character


- We must be careful that NOOO character is represented by the same bit combination
- That appears at the beginning of an another longer code used for some other character
- For example, if E is 01, and X is 01011000, then anyone decoding 01011000 wouldn't know if the initial 01 represented an E or the beginning of an X
- RULE: NO CODE CAN BE THE PREFIX OF ANY OTHER CODE








- Example: How "a b c d" coded & decoded using Huffman coding
- How this works
    - [STEP-1] Generate & Store the code table
    - [STEP-2] Build Huffman Tree ['0' to the left branch and '1' to the right (arbitarily)]
    - [STEP-3] Encoded the Sequence
    - [STEP-4] Decoded the Sequence


- Assume the frequency of these characters in a larger hypothetical text is as
    ```
        'a': 5 times
        ' ': 4 (space) times
        'b': 2 times
        'c': 2 times
        'd': 1 times
    ```


- Step 1: Build the Huffman Tree

    Initial Nodes: Create a leaf node for each character and its frequency:
    'a' (5 times)
    ' ' (4 times)
    'b' (2 times)
    'c' (2 times)
    'd' (1 times)

- Merge Lowest Frequencies
    - Merge 'c' (2 times) & 'd' (1 times) into a new node with frequency 3.
    Let's arbitrarily assign '0' to the left branch and '1' to the right.

    - Merge 'b' (2 times) and the 'cd' node (3) into a new node with frequency 5. Again,
    assign '0' to the left ('b') and '1' to the right ('cd').

    - Merge ' ' (4 times) and the 'bcd' node (5) into a new node with frequency 9.
    Assign '0' to the left (' ') and '1' to the right ('bcd').

    - Finally, merge 'a' (5 times) and the ' bcd' node (9) into the root node with frequency 14.
    Assign '0' to the left ('a') and '1' to the right (' bcd').

    - The Resulting Huffman Tree (Conceptual)
         ```
              14
             /  \
            0(a) 1( bcd)
               /    \
              0(' ')  1(bcd)
                    /   \
                   0(b) 1(cd)
                         /  \
                        0(c) 1(d)
        ```


- Assign Huffman Codes
- Now, we traverse the tree from the root to each leaf node to determine the code:

    ```
    FROM ROOT

    'a': 0      [Only 1st Left]
    ' ': 10     [1st Right + 1st Left]
    'b': 110    [1st Right + 2nd Right + 1st Left]
    'c': 1110   [1st Right + 2nd Right + 3rd Right + 1st Left]
    'd': 1111   [1st Right + 2nd Right + 3rd Right + 4th Right]
    ```

- Encode "a b c d"
    - So, the encoded sequence for "a b c d" would be: "010110101110101111"
    - So, the encoded sequence for "a b c d" would be: "0-10-110-10-1110-10-1111"




- Decode the Encoded Sequence "010110101110101111"
- To decode, we start from the beginning of the encoded sequence & traverse the Huffman tree based on the bits:
```
'0': Start at the root. Read '0', go left. We reach the leaf node 'a'. So, the first character is 'a'


'1': Go right from the root
'0': Go left. We reach the leaf node ' '. So, the second character is ' '


'1': Go right from the root.
'1': Go right.
'0': Go left. We reach the leaf node 'b'. So, the third character is 'b'.


'1': Go right from the root.
'0': Go left. We reach the leaf node ' '. So, the fourth character is ' '.


'1': Go right from the root.
'1': Go right.
'1': Go right.
'0': Go left. We reach the leaf node 'c'. So, the fifth character is 'c'.


'1': Go right from the root.
'0': Go left. We reach the leaf node ' '. So, the sixth character is ' '.


'1': Go right from the root.
'1': Go right.
'1': Go right.
'1': Go right. We reach the leaf node 'd'. So, the seventh character is 'd'.


By decoding the bit sequence, we successfully reconstruct the original sequence: "a b c d".
```







## Red-Black Trees
- The binary tree become much slower if data is inserted in already-sorted order (17, 21, 28, 36,...) or inversely sorted order (36, 28, 21, 17,...)
- When the values to be inserted are already ordered, a binary tree becomes unbalanced
- With an unbalanced tree, the ability to quickly find (or insert or delete) a given element is lost
- There are other ways to ensure that trees are balanced
- 
- The red-black tree, is a binary search tree with some added features
- 
### Insertion
- Top-Down Insertion
- The approach to insertion that we'll discuss is called top-down insertion
- This means that some ""structural changes may be made"" to the tree as the search routine descends the tree looking for the place to insert the node
- 
- Another approach is bottom-up insertion
- This involves "finding the place to insert the node" ~&&~ "then working back up through the tree making structural changes"
- Bottom-up insertion is less efficient because two passes must be made through the tree
- 
### Balanced & Unbalanced Trees
- Unbalanced Trees
    <img src="./images/1L-RB-TREE.jpg" alt="Big-o-graph">

- When we insert a series of nodes whose keys are in either ascending or descending order
- The nodes arrange themselves in a line with no branches. Because each node is larger than the previously inserted one, every node is a right child, so all the nodes are on one side of the root. The tree is maximally unbalanced. If you inserted items in descending order, every node would be the left child of its parent, and the tree would be unbalanced on the other side
- Degenerates to O(N)
    - It becomes a linked list (1D)
    - you must now search through (on the average) half the items to find the one you're looking for :: the speed of searching is reduced to O(N), instead of O(logN)
    - Searching through 10,000 items in such an unbalanced tree would require an average of 5,000 comparisons
    - With a realistic amount of random data, it's not likely a tree would become seriously unbalanced. However, there may be runs of sorted data that will partially unbalance a tree. Searching partially unbalanced trees will take time somewhere between O(N) and O(logN), depending on how badly the tree is unbalanced.

- Balance to the Rescue
    - In a ""red-black tree"", balance is achieved during insertion (and also deletion)
    - As an item is being inserted, the insertion routine checks that certain characteristics of the tree are not violated. If they are, it takes corrective action, restructuring the tree as necessary
    - By maintaining these characteristics, the tree is kept balanced


### Red-Black Tree Characteristics
- The nodes are colored
- During insertion and deletion, rules are followed that preserve various arrangements of these colors

### Colored Nodes (HUMANIZED)
- In a red-black tree, The rules are
    - 1. Every node is either red or black
    - 2. The root is always black
    - 3. If a node is red, its children must be black (although the converse isn't necessarily true) (black root can follow black child)
    - 4. Every path from the root to a leaf, or to a null child, must contain the same number of black nodes.
    - 
    - The """"null child"""" referred to in Rule 4 is a place where a child could be attached to a non-leaf node.
    - In other words, it's the potential left child of a node with a right child, or the potential right child of a node with a left child.
    - This will make more sense as we go along.
    - 
    - The number of black nodes on a path from root to leaf is called the black height. Another way to state Rule 4 is that the black height must be the same for all paths from the root to a leaf.
- What actions you can take to fix things if one of the red-black rules is broken.
    - Duplicate Keys
        - What happens if there's more than one data item with the same key? This presents a slight problem in red-black trees. It's important that nodes with the same key are distributed on both sides of other nodes with the same key. That is, if keys arrive in the order 50, 50, 50, you want the second 50 to go to the right of the first one, and the third 50 to go to the left of the first one. Otherwise, the tree becomes unbalanced.
        - Distributing nodes with equal keys could be handled by some kind of randomizing process in the insertion algorithm. However, the search process then becomes more complicated if all items with the same key must be found.
        - It's simpler to outlaw items with the same key
        - In this discussion we'll assume duplicates aren't allowed
    - Fixing Rule Violations
        - There are two, and only two, possible actions you can take:
        - You can change the colors of nodes.
        - You can perform rotations
            - A rotation is a rearrangement of the nodes that, one hopes, leaves the tree more balanced
            - Rotation Left (ROL) & Rotation Right (LOR)
            - In a binary search tree the left children of any node have key values less than the node, while its right children have key values greater than or equal to the node
            - If the rotation didn't maintain a valid binary search tree, it wouldn't be of much use, because the search algorithm, as we saw in the preceding chapter, relies on the search-tree arrangement.
            - Note that color rules and node color changes are used only to help decide when to perform a rotation.
            - Fiddling with the colors doesn't accomplish anything by itself; IT'S THE ROTATION THATS'S THE HEAVY HITTER
        - For example if you have a balance tree
            <img src="./images/1N-RB-Tree.jpg">
        - Do a Right Rotation
            <img src="./images/1O-RB-Tree.jpg">
            Now the tree become Unbalance
            Keeping pointer at 25 & doing an ROL rotation will fix the tree
        - Now ading further node to the earlier balance tree ,, requires a color flip
        - & it will violates the 4th rule
            <img src="./images/1P-RB-Tree.jpg">
            Changing RED to Balck will cause :: Error: Black heights differ
        - The term black height is used to describe the number of black nodes from the root to a given node. In the below Figure the black height of 50 is 1, of 25 is still 1, of 12 is 2 & so on
        - <img src="./images/1Q-RB-Tree.jpg">
        - As Rule 4 specifies all paths,, go from the root "to any leaf" o/r "to any null children" must have the same number of black nodes
        - 
        - Rotations must do two things at once:
            - Raise some nodes and lower others to help balance the tree.
            - Ensure that the characteristics of a binary search tree are not violated
        - 
    - [1] Simple Rotations
        - The nodes themselves aren't rotated; it's the relationship between them that changes
        - If we're doing a right rotation (CLOCK WISE), this "top" node will move down and to the right, into the position of its right child. Its left child will move up to take its place
        - 
        - One node is chosen as the "top" of the rotation
        - Remember that the top node isn't the "center" of the rotation
        - 
        - any node can be the top node in a rotation, provided it has the appropriate child
        - If you're doing a right rotation (CLOCK WISE), the top node has a left child. Otherwise, there's nothing to rotate into the top spot
        - If you're doing a left rotation (ANTI CLOCK WISE), the top node must have a right child
        - 
    - The Weird Crossover Node
        - <img src="./images/1R-RB-Tree.jpg">
        - In the origional position
            - The inside grandchild of the top node, 50
            - The 12 is an outside grandchild
        - Place the arrow on 50 & the right rotation will cause 37 moves across,, The rotation has caused a violation of Rule 4
        - left child of the top node in a right rotation) is always disconnected from its parent and reconnected to its former grandparent. It's like becoming your own uncle
        -  
    - Subtrees on the Move
        - <img src="./images/1S-RB-Tree.jpg">
        - Position the arrow on the root, 50. Now press RoR
        - A lot of nodes have changed position
        - You'll see the Error: root must be black
    - 
### Inserting a New Node (COMPUTERIZED)
- red-black tree's insertion routine uses rotations and the color rules to maintain the tree's balance.
- Variable X, P, and G 
    - X is a node that has caused a rule violation
    - Sometimes X refers to a newly inserted node,
    - and sometimes to the child node when a parent and child have a red-red conflict
    - X is a particular node.
    - 
    - P is the parent of X
    - G is the grandparent of X (the parent of P)
```
To find the insertion point

You perform a color flip whenever you find a black node with two red children (a violation of Rule 2)

Sometimes the flip causes a red-red conflict (a violation of Rule 3)
Call the red child X and the red parent P
The conflict can be fixed with a single rotation or a double rotation,
depending on whether X is an outside or inside grandchild of G



After you've inserted the new node X,
if P is black, you simply attach the new red node
If P is red, there are two possibilities:
    1] X can be an outside or inside grandchild of G
        You perform two color changes 
    2] If X is an outside grandchild,
        You perform one rotation, and if it's an inside grandchild, you perform two
        This restores the tree to a balanced state.
```
- So it drawns 3 points
    - 1. Color flips on the way down
    - 2. Rotations after the node is inserted
    - 3. Rotations on the way down

- [1.] Color Flips on the Way Down
    - @TODO




## 2-3-4 Trees and External Storage
- In a Binary-Tree, if we allow more data items and children per node, the result is a multiway tree
- 
- An 2-3-4 Tree is a multiway trees
- can have up to four children & three data items per node
- 
- An B-tree is another kind of multiway tree that's particularly useful for organizing data in external storage (disk drive)
- A node in a B-tree can have dozens or hundreds of children
- 
- 
- 

### 2-3-4 Trees
- <img src="./images/1T-234-Tree.jpg"></img>
- They're balanced trees like red-black trees
- They're slightly less efficient than red-black trees but easier to program
- In a 2-3-4 tree all the leaf nodes are always on the same level
- 
- node with 1 data item always has 2 children
- node with 2 data item always has 3 children
- node with 3 data item always has 4 children
- child links is L = data item D + 1
- 
- A leaf node, by contrast, has no children, but it can nevertheless contain 1, 2, or 3 data items
- Empty nodes are not allowed
- In a 2-3-4 tree, on the other hand, nodes with a single link are not permitted
- 
- A node with two links is called a 2-node, a node with three links is a 3-node, but there is no such thing as a 1-node
- 
- If a 234 tree have 4 levels then it will have a total of = 1 + 4 + 16 + 64 nodes
- 
- 2-3-4 Tree Organization
- The data items in a node are arranged in ascending key order
-  All children in the subtree """rooted at child 0""" have key values < key-0
- children in the subtree ""rooted at child 1""" have key values > key-0 < key-1
- Subtree """rooted at child 2""" have key values > key 1 < key-2
- children in the subtree """rooted at child 3""" have key values > key-2
    - <img src="./images/1U-234-Tree.jpg"></img>
    - <img src="./images/1V-234-Tree.jpg"></img>
- Upper-level nodes are often not full; that is, they may contain only one or two data items instead of three
- Also, notice that the tree is balanced. It retains its balance even if you insert a sequence of data in ascending (or descending) order. The 2-3-4 tree’s self-balancing capability results from the way new data items are inserted
- 
- Searching
- You start at the root and, unless the search key is found there, select the link that leads to the subtree with the appropriate range of values.
- 
- Insertion
- New data items are always inserted in leaves, which are on the bottom row of the tree. If items were inserted in nodes with children, the number of children would need to be changed to maintain the structure of the tree, which stipulates that there should be one more child than data items in a node.
- Insertion into a 2-3-4 tree is sometimes quite easy and sometimes rather complicated. In any case the process begins by searching for the appropriate leaf node.
- If no full nodes are encountered during the search, insertion is easy. When the appropriate leaf node is reached, the new data item is simply inserted into it.
- 
    - <img src="./images/1W-234-Tree.jpg"></img>
- Insertion may involve moving one or two other items in a node so the keys will be in the correct order after the new item is inserted. In this example the 23 had to be shifted right to make room for the 18.
- 
- Node Splits
    - Insertion becomes more complicated if a full node is encountered on the path down to the insertion point. When this happens, the node must be split. It's this splitting process that keeps the tree balanced
    - We assume the node being split is not the root; we'll examine splitting the root later
    - <img src="./images/1X-234-Tree.jpg"></img>
    - Let's name the data items in the node that's about to be split A, B, and C
    - A new, empty node is created. It's a sibling of the node being split, and is placed to its right.
    - Data item C is moved into the new node.
    - Data item B is moved into the parent of the node being split.
    - Data item A remains where it is.
    - The rightmost two children are disconnected from the node being split and connected to the new node.
    - 
    - Notice that the effect of the node split is to move data up and to the right. It is this rearrangement that keeps the tree balanced.
    - 
    - Here the insertion required only one node split, but more than one full node may be encountered on the path to the insertion point. When this is the case, there will be multiple splits.
    - 
- Splitting the Root
    - When a full root is encountered at the beginning of the search for the insertion point, the resulting split is slightly more complicated:
        - A new root is created. It becomes the parent of the node being split.
        - A second new node is created. It becomes a sibling of the node being split.
        - Data item C is moved into the new sibling.
        - Data item B is moved into the new root.
        - Data item A remains where it is.
        - The two rightmost children of the node being split are disconnected from it and connected to the new right-hand node.
        - <img src="./images/1Z-234-Tree.jpg"></img>
    - 
- Splitting on the Way Down
    - Notice that, because all full nodes are split on the way down, a split can't cause an effect that ripples back up through the tree. The parent of any node that's being split is guaranteed not to be full and can therefore accept data item B without itself needing to be split. Of course, if this parent already had two children when its child was split, it will become full. However, that just means that it will be split when the next search encounters it.
    - <img src="./images/2A-234-Tree.jpg"></img>
    - 
- Java Code for a 2-3-4 Tree
    - There are 3 classes: "DataItem", "Node", "Tree234"
    - DataItem Class
        - represent the data items stored in nodes
        - In a real-world program it's an object : "Person", "Book" etc.
    - Node Class
        - contains two arrays: childArray and itemArray.
        - first is four cells long & holds references to whatever children the node might have
        - The second is three cells long & holds references to objects of type DataItem contained in the node
        - data items in itemArray comprise an """ordered array"""
        - We can chosen to store the number of items currently in the node ~ & ~ the node's parent
        - ordered array >>> findItem(), insertItem(), and removeItem()
    - Tree234 Class
        - Has only one field: root, of type Node. All operations start at the root, so that's all a tree needs to remember
        - Searching
            -  It starts at the root and at each node calls that node's findItem() routine to see whether the item is there. If so, it returns the index of the item within the node's item array.
            - If it can't find the item in the current node, and the current node isn't a leaf, find() calls the getNextChild() method
            - If find() is at a leaf and can't find the item, the search has failed, so it returns -1.
            - 
        - Inserting
            - The insert() method starts with code similar to find(), except that it splits a full node if it finds one. Also, it assumes it can't fail; it keeps looking, going to deeper and deeper levels, until it finds a leaf node.
        - Splitting
            - The split() method is the most complicated in this program. It is passed the node that will be split as an argument. First, the two rightmost data items are removed from the node and stored. Then the two rightmost children are disconnected; their references are also stored.
            - A new node, called newRight, is created. It will be placed to the right of the node being split. If the node being split is the root, an additional new node is created: a new root.
            - Next, appropriate connections are made to the parent of the node being split. It may be a pre-existing parent,
            - or if the root is being split, it will be the newly created root node.
            - 
            - Assume the three data items in the node being split are called A, B, and C. Item B is inserted in this parent node. If necessary, the parent's existing children are disconnected and reconnected one position to the right to make room for the new data item and new connections. The newRight node is connected to this parent
            - 
            - Now the focus shifts to the newRight node. Data Item C is inserted in it, and child 2 and child 3, which were previously disconnected from the node being split, are connected to it. The split is now complete, and the split() routine returns.
        - 
#### 2-3-4 Trees and Red-Black Trees
- The 2-3-4 trees and red-black trees are equivalent
- One can be transformed into the other by the application of a few simple rules
- and even the operations needed to keep them balanced are equivalent. Mathematicians would say they were isomorphic.
- Historically, the 2-3-4 tree was developed first; later the red-black tree evolved from it.
- <img src="./images/2B-234-Tree.jpg"></img>
    - Transform any 2-node in the 2-3-4 tree into a black node in the red-black tree
    - 
    - Transform any 3-node into a child node and a parent node.
    - The child node has two children of its own: either W and X or X and Y. The parent has one other child: either Y or W. It doesn't matter which item becomes the child and which the parent. The child is colored red and the parent is colored black.
    - 
    - Transform any 4-node into a parent and two children
    - The first child has its own children W and X; the second child has children Y and Z. As before, the children are colored red and the parent is black.
    - 
- <img src="./images/2C-234-Tree.jpg"></img>
    - shows a 2-3-4 tree and the corresponding red-black tree obtained by applying these transformations. Dotted lines surround the subtrees that were made from 3-nodes and 4-nodes
    - The red-black rules are automatically satisfied by the transformation. Check that this is so: Two red nodes are never connected, and there is the same number of black nodes on every path from root to leaf (or null child).
    - 
    - You can say that a 3-node in a 2-3-4 tree is equivalent to a parent with a red child in a red-black tree, and a 4-node is equivalent to a parent with two red children.
    - It follows that a black parent with a black child in a red-black tree does not represent a 3-node in a 2-3-4 tree; it simply represents a 2-node with another 2-node child.
    - Similarly, a black parent with two black children does not represent a 4-node.

- Operational Equivalence
    - 4-Node Splits and Color Flips
        - As you descend a 2-3-4 tree searching for the insertion point for a new node, you split each 4-node into two 2-nodes. In a red-black tree you perform color flips.
        - How are these operations equivalent?
        - <img src="./images/2D-234-Tree.jpg"></img>
        - The dotted line surrounds the equivalent of the 4-node. A color flip results in the red-black tree of
        - Now nodes 40 and 60 are black and 50 is red
        - Thus, 50 and its parent form the equivalent of a 3-node, as shown by the dotted line. This is the same 3-node formed by the node split
        - Thus, we see that splitting a 4-node during the insertion process in a 2-3-4 tree is equivalent to performing color flips during the insertion process in a red-black tree.
    - 3-Node Splits and Rotations
        - When a 3-node in a 2-3-4 tree is transformed into its red-black equivalent, two arrangements are possible,
        - Either of the two data items can become the parent.
        - Depending on which one is chosen, the child will be either a left child or a right child, and the slant of the line connecting parent and child will be either left or right.
        - 
        - Both arrangements are valid; however, they may not contribute equally to balancing the tree. Let's look at the situation in a slightly larger context.
        - 
        - <img src="./images/2E-234-Tree.jpg"></img>
        - Picture 'a' shows a 2-3-4 tree,
        - 'b' and 'c' show two equivalent red-black trees derived from the 2-3-4 tree by applying the transformation rules.
        - The difference between them is the choice of which of the two data items in the 3-node to make the parent: in b) 80 is the parent; in c) it's 70.
        - 
        - Although these arrangements are equally valid, you can see that the tree in b) is not balanced, while that in c) is. Given the red-black tree in b), we would want to rotate it to the right (and perform two color changes) to balance it. Amazingly, this rotation results in the exact same tree shown in c).
        - 
        - Thus, we see an equivalence between rotations in red-black trees and the choice of which node to make the parent when transforming 2-3-4 trees to red-black trees. Although we don't show it, a similar equivalence can be seen for the double rotation necessary for inside grandchildren.
        - 
- Efficiency of 2-3-4 Trees
    - It's harder to analyze the efficiency of a 2-3-4 tree than a red-black tree, but the equivalence of red-black trees and 2-3-4 trees gives us a starting point.
    - Speed
        - in a red-black tree one node on each level must be visited during a search, whether to find an existing node or insert a new one. The number of levels in a red-black tree (a balanced binary tree) is about log2(N+1), so search times are proportional to this.
        - 
        - One node must be visited at each level in a 2-3-4 tree as well, but the 2-3-4 tree is shorter (has fewer levels) than a red-black tree with the same number of data items.
        - where the 2-3-4 tree has three levels and the red-black tree has five.
        - More specifically, in 2-3-4 trees there are up to four children per node. If every node were full, the height of the tree would be proportional to log4N. Logarithms to the base 2 and to the base 4 differ by a constant factor of 2. Thus, the height of a 2-3-4 tree would be about half that of a red-black tree, provided that all the nodes were full. Since they aren’t all full, the height of the 2-3-4 tree is somewhere between log2(N+1) and log2(N+1)/2. The reduced height of the 2-3-4 tree decreases search times slightly compared with red-black trees.
        - On the other hand, there are more items to examine in each node, which increases the search time. Because the data items in the node are examined using a linear search, this multiplies the search times by an amount proportional to M, the average number of items per node. The result is a search time proportional to M*log4N.
        - Some nodes contain one item, some two, and some three. If we estimate that the average is two, search times will be proportional to 2*log4N. This is a small constant number that can be ignored in Big O notation.
        - Thus, for 2-3-4 trees the increased number of items per node tends to cancel out the decreased height of the tree. The search times for a 2-3-4 tree and for a balanced binary tree such as a red-black tree are approximately equal, and are both O(logN).
        - 
    - Storage Requirements
        - Each node in a 2-3-4 tree contains storage for three references to data items and four references to its children. This space may be in the form of arrays, as shown in tree234.java, or of individual variables. Not all this storage is used. A node with only one data item will waste 2/3 of the space for data and 1/2 the space for children. A node with two data items will waste 1/3 of the space for data and 1/4 of the space for children; or put another way, it will use 5/7 of the available space.
        - 
        - If we take two data items per node as the average utilization, about 2/7 of the available storage is wasted.
        - 
        - You might imagine using linked lists instead of arrays to hold the child and data references, but the overhead of the linked list compared with an array, for only three or four items, would probably not make this a worthwhile approach.
        - 
        - Because they're balanced, red-black trees contain few nodes that have only one child, so almost all the storage for child references is used. Also, every node contains the maximum number of data items, which is one. This makes red-black trees more efficient than 2-3-4 trees in terms of memory usage.
        - 
        - In Java, which stores references to objects instead of the objects themselves, this difference in storage between 2-3-4 trees and red-black trees may not be important, and the programming is certainly simpler for 2-3-4 trees. However, in languages that don’t use references this way, the difference in storage efficiency between red-black trees and 2-3-4 trees may be significant.
        - 

### 2-3 Trees
- We'll discuss 2-3 trees briefly here because they are historically important and because they are still used in many applications. Also, some of the techniques used with 2-3 trees are applicable to B-trees, which we'll examine in the next section. Finally, it's interesting to see how a small change in the number of children per node can cause a large change in the tree's algorithms.
- 2-3 trees are similar to 2-3-4 trees except that, as you might have guessed from the name, they hold one less data item and have one less child
- B-trees (of which the 2-3-4 tree is a special case)
- In many respects the operation of 2-3 trees is similar to that of 2-3-4 trees. Nodes can hold one or two data items and can have zero, one, two, or three children. Otherwise, the arrangement of the key values of the parent and its children is the same. Inserting a data item into a node is potentially simplified because fewer comparisons and moves are potentially necessary. As in 2-3-4 trees, all insertions are made into leaf nodes, and all leaf nodes are on the bottom level.
- 
- Node Splits
    - Here insertion isn't similar to a 2-3-4 tree, there is a surprising difference in the way splits are handled
    - In either kind of tree (2-3-4 or 2-3) a node split requires "three data items":
        - one to be kept in the node being split,
        - one to move right into the new node, and 
        - one to move up to the parent node.
        - A full node in a 2-3-4 tree has three data items, which are moved to these three destinations.
        - However, a full node in a 2-3 tree has only two data items.
        - Where can we get a third item? We must use the new item: the one being inserted in the tree
        - In a 2-3-4 tree the new item is inserted after all the splits have taken place. In the 2-3 tree it must participate in the split. It must be inserted in a leaf, so no splits are possible on the way down. If the leaf node where the new item should be inserted is not full, the new item can be inserted immediately, but if the leaf node is full, it must be split. Its two items and the new item are distributed among these three nodes: the existing node, the new node, and the parent node. If the parent is not full, the operation is complete (after connecting the new node)
        - <img src="./images/2F-234-Tree.jpg"></img>
        - However, if the parent is full, it too must be split. Its two items and the item passed up from its recently split child must be distributed among the parent, a new sibling of the parent, and the parent's parent.
        - <img src="./images/2G-234-Tree.jpg"></img>
        - If the parent’s parent (the grandparent of the leaf node) is full, it too must be split. The splitting process ripples upward until either a non-full parent or the root is encountered. If the root is full, a new root is created that is the parent of the old root,
        - <img src="./images/2H-234-Tree.jpg"></img>
        - Below picture shows a node split that ripples up through a tree until it reaches the root.
        - <img src="./images/2I-234-Tree.jpg"></img>
        - 

- Implementation In Java
    - The insertion routine doesn't care if the nodes it encounters are full or not. It searches down through the tree until it finds the appropriate leaf. If the leaf is not full, it inserts the new value. However, if the leaf is full, it must rearrange the tree to make room. To do this, it calls a split() method
    - Arguments to this method can be the full leaf node and the new item. It will be the responsibility of split() to make the split and insert the new node in the new leaf.
    - If split() finds that the leaf's parent is full, it calls itself recursively to split the parent. It keeps calling itself until a non-full leaf or the root is found. The return value of split() is the new right node, which can be used by the previous incarnation of split().
    - Coding the splitting process is complicated by several factors. In a 2-3-4 tree the three items to be distributed are already sorted, but in the 2-3 tree the new item's key must be compared with the two items in the leaf; the three are then distributed according to the results of the comparison.
    - Also, splitting a parent creates a second parent, so now we have a left (the original) parent and a new right parent. We need to change the connections from a single parent with three children to two parents with two children each. There are three cases, depending on which child (0, 1, or 2) is being split. This situation is shown in Figure
    - the new nodes created as the result of a split are shaded, and new connections are shown as wiggly lines
    <img src="./images/2J-234-Tree.jpg"></img>
    - 
### External Storage
- 2-3-4 trees are examples of multiway trees, which have more than two children and more than one data item. Another kind of multiway tree, the B-tree, is useful when data resides in external storage. External storage typically refers to some kind of disk system, such as the hard disk found in most desktop computers or servers.
- #external file handling. #organizing external data: sequential ordering #indexing
- we'll begin by describing various aspects of external file handling. We'll talk about a simple approach to organizing external data: sequential ordering. Finally, we'll discuss B-trees and explain why they work so well with disk files. We'll finish with another approach to external storage, indexing, which can be used alone or with a B-tree.
- We'll also touch on other aspects of external storage, such as searching techniques. In the next chapter we'll mention a different approach to external storage: hashing
- Accessing External Data
    - in many situations the amount of data to be processed is too large to fit in main memory all at once. In this case a different kind of storage is necessary. Disk files generally have a much larger capacity than main memory; this is made possible by their lower cost per byte of storage.
    - Disk files can retain data indefinitely with the power off
    - 
    - Disk files can be much slower than main memory
    - To access a particular piece of data on a disk drive, the read-write head must first be moved to the correct track. This is done with a stepping motor or similar device; it's a mechanical activity that requires several milliseconds (thousandths of a second).
    - Once the correct track is found, the read-write head must wait for the data to rotate into position. On the average, this takes half a revolution. Even if the disk is spinning at 10,000 revolutions per minute, about 3 more milliseconds pass before the data can be read.
    - Thus, disk access times of around 10 milliseconds are common. This is something like 10,000 times slower than main memory.
    - 
    - One Block at a Time
    - When the read-write head is correctly positioned and the reading (or writing) process begins, the drive can transfer a large amount of data to main memory fairly quickly
    - For this reason, and to simplify the drive control mechanism, data is stored on the disk in chunks called blocks, pages, allocation units, or some other name, depending on the system. We'll call them blocks.
    - 
    - The disk drive always reads or writes a minimum of one block of data at a time.
    - Block size varies, depending on the operating system, the size of the disk drive, and other factors, but it is usually a power of 2.
    - Let's assume a block size of (2^13) = 8,192 bytes
    - 
    - For example a phone book for a medium-sized city-perhaps 500,000 entries
    - Let's say an entry is stored as a record requiring 512 bytes
    - The result is a file size of 500,000 * 512, which is 256,000,000 bytes or 256 megabytes.
    - 
    - Thus, our phone book database will require 256,000,000 bytes divided by 8,192 bytes per block, which is 31,250 blocks.
    - Your software is most efficient when it specifies a read or write operation that's a multiple of the block size.
    - If you ask to read 100 bytes, the system will read one block, 8,192 bytes, and throw away all but 100.
    - If you ask to read 8,200 bytes, it will read two blocks, or 16,384 bytes, and throw away almost half of them
    - By organizing your software so that it works with a block of data at a time, you can optimize its performance.
    - 
    - Assuming our each phone book record size of 512 bytes, you can store 8192/512 = 16 records in a block
    - Thus, for maximum efficiency it's important to read 16 records at a time (or multiples of this number)
    - Notice that it's also useful to make your record size a multiple of 2. That way, an integral number of them will always fit in a block.
    - It follows that the larger the block, the more efficiently you can read or write a single record (assuming you use all the records in the block).
    - .
     <img src="./images/2K-234-Tree.jpg"></img>
    - 
- Sequential Ordering
    - One way to arrange the phone book data in the disk file would be to order all the records according to some key, say alphabetically by last name.
- Searching
    - To search a sequentially ordered file for a particular last name such as Smith, you could use a binary search. You would start by reading a block of records from the middle of the file (S is expected somewhere in middle)
    - The 16 records in the block are all read at once into an 8,192-byte buffer in main memory

    - If the keys of these records are too early in the alphabet (Keller, for example), you would go to the 3/4 point in the file (Prince) and read a block there; if the keys were too late, you'd go to the 1/4 point (DeLeon). By continually dividing the range in half, you would eventually find the record you were looking for.

    - As we saw in Chapter 2, a binary search in main memory takes log-base-2-of(N) comparisons
    - which for 500,000 items would be about 19.
    - If every comparison took, say 10 microseconds, this would be 190 microseconds, OR ~ 2/10,000 of a SECOND

    - 
    - 
    - 

    - However, we're now dealing with data stored on a disk. Because each disk access is so time-consuming
    - It's more important to focus on how many disk accesses are necessary than on how many individual records there are
    - The time to read a block of records will be very much larger than the time to search the 16 records in the block once they're in in-memory

    - Disk accesses are much slower than memory accesses, but on the other hand we access a block at a time, and there are far fewer blocks than records. In our example there are 31,250 blocks.
    - Log2 of 31,250 is about 15, so in theory we'll need about 15 disk accesses to find the record we want.
    
    - In practice this number is reduced somewhat because we read 16 records at once. In the beginning stages of a binary search, it doesn't help to have multiple records in memory because the next access will be in a distant part of the file.
    - However, when we get close to the desired record, the next record we want may already be in memory because it's part of the same block of 16
    - This "MAY" reduce the number of comparisons by two or so. Thus, we'll need about 13 disk accesses (15-2), which at 10 milliseconds per access requires about 130 milliseconds, or 1/7 second
    - This is much slower than in-memory access, but still not too bad.

- Insertion
    - Unfortunately, the picture is much worse if we want to insert (or delete) an item from a sequentially ordered file. Because the data is ordered, both operations require moving half the records on the average, and therefore about half the blocks.

    - Moving each block requires two disk accesses: one read and one write. When the insertion point is found, the block containing it is read into a memory buffer.
    - The last record in the block is saved, and the appropriate number of records are shifted up to make room for the new one, which is inserted. Then the buffer contents are written back to the disk file.

    - Next, the second block is read into the buffer. Its last record is saved, all the other records are shifted up, and the last record from the previous block is inserted at the beginning of the buffer. Then the buffer contents are again written back to disk. This process continues until all the blocks beyond the insertion point have been rewritten.

    - Assuming there are 31,250 blocks, we must read and write (on the average) 15,625 of them, which at 10 milliseconds per read and write requires more than 5 minutes to insert a single entry. This won't be satisfactory if you have thousands of new names to add to the phone book.

    - Another problem with the sequential ordering is that it works quickly for only one key. Our file is arranged by last names. But suppose you wanted to search for a particular phone number. You can't use a binary search because the data is ordered by name. You would need to go through the entire file, block by block, using sequential access. This search would require reading an average of half the blocks, which would require about 2.5 minutes, very poor performance for a simple search. It would be nice to have a more efficient way to store disk data.

### B-Trees
- used for external data than for in-memory data
- a multiway tree somewhat like a 2-3-4 tree, but with many more data items per node

- One Block Per Node
    - It makes sense then to store an entire block of data in each node of the tree. This way, reading a node accesses a maximum amount of data in the shortest time.
    - When we simply stored the 512-byte data records for our phone book example, we could fit 16 into an 8,192-byte block.
    - In a tree, however, we also need to store the links to other nodes
    - For a tree stored in a disk file, the links are block numbers in a file (from 0 to 31,249, in our phone book example)
    - For block numbers we can use a field of type int, a 4-byte type, which can point to more than 2 billion possible blocks, which is probably enough for most files.
    - Now we can no longer squeeze 16 512-byte records into a block because we need room for the links to child nodes. We could reduce the number of records to 15 to make room for the links, but it's most efficient to have an even number of records per node, so (after appropriate negotiation with management) we reduce the record size to 507 bytes. There will be 17 child links (one more than the number of data items) so the links will require 68 bytes (17 * 4). This leaves room for 16 507-byte records with 12 bytes left over (507 * 16 + 68 = 8,180). A block in such a tree, and the corresponding node representation
    - A node in a B-tree of order 17.
    <img src="./images/2M-234-Tree.jpg"></img>
    - Within each node the data is ordered sequentially by key, as in a 2-3-4 tree. In fact, the structure of a B-tree is similar to that of a 2-3-4 tree, except that there are more data items per node and more links to children. The order of a B-tree is the number of children each node can potentially have. In our example this is 17, so the tree is an order 17 """"B-tree"""" !!!!!

- Searching
    - A search for a record with a specified key is carried out in much the same way it is in an in-memory 2-3-4 tree. First, the block containing the root is read into memory. The search algorithm then starts examining each of the 15 records (or, if it's not full, as many as the node actually holds), starting at 0. When it finds a record with a greater key, it knows to go to the child whose link lies between this record and the preceding one.
    - This process continues until the correct node is found. If a leaf is reached without finding the specified key, the search is unsuccessful.
- Insertion
    - The insertion process in a B-tree is more like an insertion in a 2-3 tree than in a 2-3-4 tree.
    - in a 2-3-4 tree many nodes are not full, and in fact contain only one data item. In particular, a node split always produces two nodes with one item in each. This is not an optimum approach in a B-tree.
    - In a B-tree it's important to keep the nodes as full as possible so that each disk access, which reads an entire node, can acquire the maximum amount of data. To help achieve this end, the insertion process differs from that of 2-3-4 trees in three ways:
        - A node split divides the data items equally: Half go to the newly created node, and half remain in the old one.
        - Node splits are performed from the bottom up, as in a 2-3 tree, rather than from the top down.
        - Again, as in a 2-3 tree, it's not the middle item in a node that's promoted upward, but the middle item in the sequence formed from the items in the node plus the new item.
        - Example of order 5 B-tree
            <img src="./images/2L-234-Tree.jpg"></img>
        - shows a root node that's already full; items with keys 20, 40, 60, and 80 have already been inserted into the tree. A new data item with a key of 70 is inserted, resulting in a node split. Here's how the split is accomplished. Because it's the root that's being split, two new nodes are created (as in a 2-3-4 tree): a new root and a new node to the right of the one being split.
        - To decide where the data items go, the insertion algorithm arranges their five keys in order, in an internal buffer. Four of these keys are from the node being split, and the fifth is from the new item being inserted. In Figure 10.25, these five-item sequences are shown to the side of the tree. In this first step the sequence 20, 40, 60, 70, 80 is shown.
        - The center item in this sequence, 60 in this first step, is promoted to the new root node. (In the figure, an arrow indicates that the center item will go upward.) All the items to the left of center remain in the node being split, and all the items to the right go into the new right-hand node
        - these five-item sequences are shown to the side of the tree. In this first step the sequence 20, 40, 60, 70, 80 is shown.
        - The center item in this sequence, 60 in this first step, is promoted to the new root node. (In the figure, an arrow indicates that the center item will go upward.) All the items to the left of center remain in the node being split, and all the items to the right go into the new right-hand node. The result is shown in Figure b
        - In Figure b we insert two more items, 10 and 30. They fill up the left child, as shown in Figure c. The next item to be inserted, 15, splits this left child, with the result shown in Figure d. Here the 20 has been promoted upward into the root
        - Next, three items - 75, 85, and 90 - are inserted into the tree. The first two fill up the third child, and the third splits it, causing the creation of a new node and the promotion of the middle item, 80, to the root. The result is shown in Figure e.
        - Again three items - 25, 35, and 50 - are added to the tree. The first two items fill up the second child, and the third one splits it, causing the creation of a new node and the promotion of the middle item, 35, to the root, as shown in Figure f.
        - Now the root is full. However, subsequent insertions don't necessarily cause a node split, because nodes are split only when a new item is inserted into a full node, not when a full node is encountered in the search down the tree. Thus, 22 and 27 are inserted in the second child without causing any splits, as shown in Figure g.
        - However, the next item to be inserted, 32, does cause a split; in fact it causes two of them. The second node child is full, so it's split, as shown in Figure h. However, the 27, promoted from this split, has no place to go because the root is full. Therefore, the root must be split as well, resulting in the arrangement of Figure i.
        - Notice that throughout the insertion process no node (except the root) is ever less than half full, and many are more than half full. As we noted, this promotes efficiency because a file access that reads a node always acquires a substantial amount of data.

- Efficiency of B-Trees
    - Because there are so many records per node, and so many nodes per level, operations on B-trees are very fast, considering that the data is stored on disk
    - In our phone book example there are 500,000 records.
    - All the nodes in the B-tree are at least half full, so they contain at least 8 records and 9 links to children.
    - The height of the tree is thus somewhat less than logbase9of(N) (logarithm to the base 9 of N), where N is 500,000. This is 5.972, so there will be about 6 levels in the tree.
    - Thus, using a B-tree, only six disk accesses are necessary to find any record in a file of 500,000 records. At 10 milliseconds per access, this takes about 60 milliseconds, or 6/100 of a second
    - The more records there are in a node, the fewer levels there are in the tree. We've seen that there are 6 levels in our B-tree, even though the nodes hold only 16 records. In contrast, a binary tree with 500,000 items would have about 19 levels, and a 2-3-4 tree would have 10. If we use blocks with hundreds of records, we can reduce the number of levels in the tree and further improve access times.
    - Although searching is faster in B-trees than in sequentially ordered disk files, it's for insertion and deletion that B-trees show the greatest advantage.
    - 
    - Let's first consider a B-tree insertion in which no nodes need to be split. This is the most likely scenario, because of the large number of records per node. In our phone book example, as we've seen, only 6 accesses are required to find the insertion point. Then one more access is required to write the block containing the newly inserted record back to the disk, for a total of 7 accesses.
    - 
    - Next let's see how things look if a node must be split. The node being split must be read, have half its records removed, and be written back to disk. The newly created node must be written to the disk, and the parent must be read and, following the insertion of the promoted record, written back to disk. This is 5 accesses in addition to the 6 necessary to find the insertion point, for a total of 12. This is a major improvement over the 500,000 accesses required for insertion in a sequential file.
    - 
    - In some versions of the B-tree, only leaf nodes contain records. Non-leaf nodes contain only keys and block numbers. This may result in faster operation because each block can hold many more block numbers. The resulting higher-order tree will have fewer levels, and access speed will be increased. However, programming may be complicated because there are two kinds of nodes: leaves and non-leaves.
    - 
- Indexing
    - A different approach to speeding up file access is to store records in sequential order but use a file index along with the data itself.
    - A file index is a list of key/block pairs, arranged with the keys in order.
    - Recall that in our original phone book example we had 500,000 records of 512 bytes each, stored 16 records to a block, in 31,250 blocks.
    - Assuming our search key is the last name, every entry in the index contains two items:
        - The key, like Jones.
        - The number of the block where the Jones record is located within the file. These numbers run from 0 to 31,249.
        - Let's say we use a string 28 bytes long for the key (big enough for most last names) and 4 bytes for the block number (a type int in Java). Each entry in our index thus requires 32 bytes. This is only 1/16 the amount necessary for each record.
        - The entries in the index are arranged sequentially by last name.
        - The original records on the disk can be arranged in any convenient order.
        - This usually means that new records are simply appended to the end of the file, so the records are ordered by time of insertion.
        - <img src="./images/2N-234-Tree.jpg"></img>
        - The index is much smaller than the file containing actual records. It may even be small enough to fit entirely in main memory. In our example there are 500,000 records. Each one has a 32-byte entry in the index, so the index will be 32 * 500,000, or 1,600,000 bytes long (1.6 megabytes). In modern computers there's no problem fitting this in memory. The index can be stored on the disk but read into memory whenever the database program is started up. From then on, operations on the index can take place in memory. At the end of each day (or perhaps more frequently), the index can be written back to disk for permanent storage.
    - 
- Searching
    - The index-in-memory approach allows much faster operations on the phone book file than are possible with a file in which the records themselves are arranged sequentially. For example, a binary search requires 19 index accesses. At 20 microseconds per access, that's only about 4/10,000 of a second. Then there's (inevitably) the time to read the actual record from the file, once its block number has been found in the index. However, this is only one disk access of (say) 10 milliseconds.
- Insertion
    - To insert a new item in an indexed file, two steps are necessary. We first insert the item’s full record into the main file; then we insert an entry, consisting of the key and the block number where the new record is stored, into the index.
    - Because the index is in sequential order, to insert a new item, we need to move half the index entries, on the average. Figuring 2 microseconds to move a byte in memory, we have 250,000 times 32 times 2, or about 16 seconds to insert a new entry. This compares with 5 minutes for the unindexed sequential file. (Note that we don't need to move any records in the main file; we simply append the new record at the end of the file.)
    - Of course, you can use a more sophisticated approach to storing the index in memory. You could store it as a binary tree, 2-3-4 tree, or red-black tree, for example. Any of these would significantly reduce insertion and deletion times. In any case the index-in-memory approach is much faster than the sequential-file approach. In some cases it will also be faster than a B-tree.
    - The only actual disk accesses necessary for an insertion into an indexed file involve the new record itself. Usually, the last block in the file is read into memory, the new record is appended, and the block is written back out. This process involves only two file accesses.
- Multiple Indexes
    - An advantage of the indexed approach is that multiple indexes, each with a different key, can be created for the same file. In one index the keys can be last names; in another, telephone numbers; in another, addresses. Because the indexes are small compared with the file, this doesn’t increase the total data storage very much. Of course, it does present more of a challenge when items are deleted from the file because entries must be deleted from all the indexes

- Index Too Large for Memory
    - If the index is too large to fit in memory, it must be broken into blocks and stored on the disk. For large files storing the index itself as a B-tree may then be profitable. In the main file the records are stored in any convenient order.
    - This arrangement can be very efficient. Appending records to the end of the main file is a fast operation, and inserting the index entry for the new record is also quick because the index is a tree. The result is very fast searching and insertion for large files.
    - Note that when an index is arranged as a B-tree, each node contains n child pointers and n-1 data items. The child pointers are the block numbers of other nodes in the index. The data items consist of a key value and a pointer to a block in the main file. Don't confuse these two kinds of block pointers.
- Complex Search Criteria
    - In complex searches the only practical approach may be to read every block in a file sequentially. Suppose in our phone book example we wanted a list of all entries in the phone book with first name Frank, who lived in Springfield, and who had a phone number with three 7 digits in it. (These were perhaps clues found scrawled on a scrap of paper clutched in the hand of a victim of foul play.)
    - A file organized by last names would be no help at all. Even if there were index files ordered by first names and cities, there would be no convenient way to find which files contained both Frank and Springfield
    - In such cases (which are quite common in many kinds of databases), the fastest approach is probably to read the file sequentially, block by block, checking each record to see whether it meets the criteria !!!!!!!!!!!!!!!!!!!!!!!!!!!!
    - 
- Sorting External Files
    - Mergesort is the preferred algorithm for sorting external data. This is because, more so than most sorting techniques, disk accesses tend to occur in adjacent records rather than random parts of the file.
    - From "Recursion" we know that mergesort works recursively by calling itself to sort smaller and smaller sequences
    - Once two of the smallest sequences (one byte each in the internal-memory version) have been sorted, they are then merged into a sorted sequence twice as long. Larger and larger sequences are merged, until eventually the entire file is sorted.
    - The approach for external storage is similar. However, the smallest sequence that can be read from the disk is a block of records. Thus, a two-stage process is necessary.
        - In the first phase, a block is read, its "records are sorted internally", and the resulting sorted block is written back to disk. The next block is similarly sorted and written back to disk. This process continues until all the blocks are internally sorted.
        - In the second phase, two sorted blocks are read, merged into a two-block sequence, and written back to disk. This process continues until all pairs of blocks have been merged. Next, each pair of two-block sequences is merged into a four-block sequence. Each time, the size of the sorted sequences doubles, until the entire file is sorted.

    - <img src="./images/2O-234-Tree.jpg"></img>

    - Internal Sort of Blocks
        - In the first phase all the blocks in the file are sorted internally. This is done by reading the block into memory and sorting it with any appropriate internal sorting algorithm, such as quicksort (or for smaller numbers of records Shellsort or insertion sort).
        - A second file may be used to hold the sorted blocks, and we assume that availability of external storage is not a problem. It's often desirable to avoid modifying the original file.
    - Merging
        - In the second phase we want to merge the sorted blocks. In the first pass we merge every pair of blocks into a sorted two-block sequence. Thus, the two blocks 2-9-11-14 and 4-12-13-16 are merged into 2-4-9-11-12-13-14-16. Also, 3-5-10-15 and 1-6-7-8 are merged into 1-3-5-6-7-8-10-15.
        - In the second pass, the two 8-record sequences are merged into a 16-record sequence, which can be written back to File 2
        - Now the sort is complete. Of course, more merge steps would be required to sort larger files; the number of such steps is proportional to log2N. The merge steps can alternate between two files (File 2 and File 3)
    - Internal Arrays
        - Because the computer's internal memory has room for only three blocks, the merging process must take place in stages. Let's say there are three arrays, called arr1, arr2, and arr3, each of which can hold a block.
        - In the first merge, block 2-9-11-14 is read into arr1, and 4-12-13-16 is read into arr2. These two arrays are then mergesorted into arr3. However, because arr3 holds only one block, it becomes full before the sort is completed. When it becomes full, its contents are written to disk. The sort then continues, filling up arr3 again. This completes the sort, and arr3 is again written to disk
        - <img src="./images/2O-234-Tree.jpg"></img>
        ```
        Mergesort 1:

        1. Read 2-9-11-14 into arr1.

        2. Read 4-12-13-16 into arr2.

        3. Merge 2, 4, 9, 11 into arr3; write to disk.

        4. Merge 12, 13, 14, 16 into arr3; write to disk.

        Mergesort 2:

        1. Read 3-5-10-15 into arr1.

        2. Read 1-6-7-8 into arr2.

        3. Merge 1, 3, 5, 6 into arr3; write to disk.

        4. Merge 7, 8, 10, 15 into arr3, write to disk.

        Mergesort 3:

        1. Read 2-4-9-11 into arr1.

        2. Read 1-3-5-6 into arr2.

        3. Merge 1, 2, 3, 4 into arr3; write to disk.

        4. Merge 5, 6 into arr3 (arr2 is now empty).

        5. Read 7-8-10-15 into arr2.

        6. Merge 7, 8 into arr3; write to disk.

        7. Merge 9, 10, 11 into arr3 (arr1 is now empty).

        8. Read 12-13-14-16 into arr1.

        9. Merge 12 into arr3; write to disk.

        10. Merge 13, 14, 15, 16 into arr3; write to disk.
        ```







## Perfrmance
- Too many method call add lil overhead
- heap - special kind of tree
- Stack used to help traverse the nodes of a tree - Binary Trees
- Graphs, we'll apply it to searching the vertices of a graph
- Theoretically, an ADT stack doesn't become full

# Algorith books
- Sedgewick
