# Interview Questions: Stacks and Queues

1. **Queue with two stacks**. Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.

2. **Stack with max**. Create a data structure that efficiently supports the stack operations (push and pop) and also a return-the-maximum operation. Assume the elements are real numbers so that you can compare them.

3. **Java generics**. Explain why Java prohibits generic array creation.

# Interview Quetions: Elementary Sorts

1. **Intersection of two sets**. Given two arrays a[] and b[], each containing nn distinct 2D points in the plane, design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].

2. **Permutation**. Given two integer arrays of size nn, design a subquadratic algorithm to determine whether one is a permutation of the other. That is, do they contain exactly the same entries but, possibly, in a different order.

3. **Dutch national flag**. Given an array of nn buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:

- swap(i,j): swap the pebble in bucket ii with the pebble in bucket jj.
- color(i): determine the color of the pebble in bucket ii.

  The performance requirements are as follows:
  - At most n calls to color().
  - At most n calls to swap().
  - Constant extra space.