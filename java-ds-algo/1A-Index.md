# DATA STRUCTURE & ALGORITHMS (In Java)

- What is a data structure ?
    - It's how your data is structured.. It could be structured in a list (List of items) or set (set of records) or map (key -> value)
    - You can think it as a small inmemory structured database

- What is an Algorithm ?
    - How fast we process the "structured data" !!
    - A CRUD operation
    - Create/insert     Retrive/Search      Update      Delete








# DATA STRUCTURE (DS) & Algorithm (Algo)


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
- A collection is partially sorted
- From the other unsorted list, it finds minimum & try to fill in the partially sorted
- The algorithm starts by assuming the very first element (at index 0) is already a sorted sub-list on its own.
- On the first pass, it compares a maximum of one item. On the second pass, it’s a maximum of two items, and so on, up to a maximum of N-1 comparisons on the last pass
```
1 + 2 + 3 + ... + N-1 = N*(N-1)/2
```
However, because on each pass an average of only half of the maximum number of items are actually compared before the insertion point is found, we can divide by 2, which gives
```
N*(N-1)/4
```
- The number of copies is approximately the same as the number of comparisons. However, a copy isn’t as time-consuming as a swap, so for random data this algorithm runs twice as fast as the bubble sort and faster than the selection sort
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




## Advanced Sorting
- Advanced Sorting includes
    - Shellsort
    - quicksort






## Perfrmance
- Too many method call add lil overhead
- heap - special kind of tree
- Stack used to help traverse the nodes of a tree - Binary Trees
- Graphs, we'll apply it to searching the vertices of a graph
- Theoretically, an ADT stack doesn't become full

