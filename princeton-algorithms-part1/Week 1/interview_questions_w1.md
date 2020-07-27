# Interview Questions: Union–Find 

1. **Social network connectivity**. Given a social network containing *n* members and a log file containing *m* timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be m log *m* or better and use extra space proportional to *n*.

2. **Union-find with specific canonical element**. Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing ii. The operations, union(), connected(), and find() should all take logarithmic time or better.

For example, if one of the connected components is {1, 2, 6, 9}, then the find() method should return 99 for each of the four elements in the connected components.

3. **Successor with delete**. Given a set of nn integers S={0,1,...,n−1} and a sequence of requests of the following form:

Remove *x* from *S*
Find the successor of xx: the smallest *y* in *S* such that y≥x.
design a data type so that all operations (except construction) take logarithmic time or better in the worst case.

# Interview Questions: Analysis of Algorithms

1. **3-SUM in quadratic time**. Design an algorithm for the 3-SUM problem that takes time proportional to n^2 in the worst case. You may assume that you can sort the nn integers in time proportional to n^2 or better.

2. **Search in a bitonic array**. An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of nn distinct integer values, determines whether a given integer is in the array.

- Standard version: Use ∼ 3 lg(n) compares in the worst case.
- Signing bonus: Use ∼2 lg(n) compares in the worst case (and prove that no algorithm can guarantee to perform fewer than ∼2 lg(n) compares in the worst case).

3. **Egg drop**. Suppose that you have an nn-story building (with floors 1 through nn) and plenty of eggs. An egg breaks if it is dropped from floor TT or higher and does not break otherwise. Your goal is to devise a strategy to determine the value of TT given the following limitations on the number of eggs and tosses:

- Version 0: 1 egg, T≤T tosses.
- Version 1: ∼1 lg(n) eggs and ∼1 lg(n) tosses.
- Version 2: ∼lg(T) eggs and ∼2 lg(T) tosses.
- Version 3: 22 eggs and ∼2√n tosses.
- Version 4: 22 eggs and ≤c√T tosses for some fixed constant cc.