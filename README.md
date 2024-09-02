# Leetcode 75 Tests

## What is this?

This is a repo to store my solutions to the Leetcode 75 set of questions. In a lot of cases, they might not be the most
efficient solution, but I expect I'll revisit from time to time to look at efficiency improvements. They might also serve
as a useful reference for others to look at what has worked and what hasn't.


## Multiple Attempts
Where there are 2 or more methods, it is largely down to making multiple attempts to solve the problem, or creating an
inefficient attempt the first time round. Few of the solutions are in the top 90% of performant submissions and will likely
not achieve O1 time/space efficiency, they're practice.


# Patterns

## Binary Search
Set a left and right pointer, then set the middle. If the target is higher than the middle, shift the left pointer to the middle+1
and reset the middle. If the target is lower than the middle, shift the right pointer to the middle-1 and reset the middle.
Continue until the middle matches the target or left > right.
### Used For
Sorted arrays only. The quickest way to find a target in a sorted array.
### Implementation Example
```
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;

        while(l <= r) {

            int mid = (r - l) / 2;

            if(nums[mid]==target) {
                return mid;
            }

            if(nums[mid] > target) {

                r = mid -1;

            }

            if(nums[mid] < target) {

                l = mid + 1;

            }

        }

        return -1;
    }
```
Here, you're checking whether you've matched against a target. If the target is in the array, you can find its index with a handful
of iterations. If it's not in the array, return -1 to show that it's not there.

## Fast/Slow
Set a pointer to move through each element (`i++`) and a pointer to move through each 2 elements (`i+2`).
### Used For
Iterating through a list you can only traverse one way (eg a linked list) to find the middle element. Checking if a linkedlist
repeats back on itself.
### Implementation.
Pseudo code looks like:
```
slowPointer = 0
fastPointer = 0

while a condition isn't met:
    Do stuff using slow pointer and fast pointer.
    
    Increase slow pointer by 1.
    Increase fast pointer by 2.

```

## Alphabetic Search
Create an array for all characters, then add counters to each of the character values, then decrement the counters once they're
used up. If the counter is < 0, there are no characters left.
### Used For
Stuff like anagrams. Does X contain all elements of Y? Specifically with anagrams, characters have value representations.
So it's very easy to just ++ the value for an element. NOTE: You can also use Hashmap for this kind of thing.
### Implementation
TODO

## Backtracking
Checks all permutations of a set of elements.
### Used For
Returning cross pairs of all elements (like an SQL cross join).
### Implementation
Pseudo code for backtracking looks like:
```
Main Code block:
    Create a result list.
    Run the backtracking method and pass in the result list and a blank temporary list.
    Return the result list.

Backtracking Method block:
    Base Case: Does the number of elements in the temporary list match the expected size/length of the input string/list?
        If so, add to result list.
    
    For each of the numbers in the array:
        Add to the temporary list.
        Run the backtracking method, increasing the number in the array (if necessary).
        Remove from the temporary list.
        
```

The key bit is to add to the list prior to running the method and to remove from the list afterwards.

## Recursion

### Used For


### Implementation
#### Tabulation


#### Memoization

## Data Structures
### Sets
Stores a list of items without duplicates. HashSet stores unordered.

### Maps
Stores a key/value pair. Hashmap stores unordered.

### Heaps
#### Min Heap
Priority Queue used for heaps, defaulting to Min Heap. Minimum value sits at the top.

#### Max Heap
Priority Queue with a reverse order (`new PriorityQueue<Integer>(Collections.reverseOrder())`) can be used to create a max heap.
The maximum value can then be taken off the top of the heap.

### Arrays v ArrayLists
Arrays are quicker to traverse and take up less space. They're not dynamic though, and need to be declared when they're created,
ie `int[] myArray = new int[]{1,2};`.