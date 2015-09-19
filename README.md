# binary-heap
BinaryHeap class written in Java

This repo contains the code for a BinaryHeap data structure. This data structure is represented as a binary tree that keeps the min-heap property; that is, every node has priority greater than that of its parent node. It is useful as an implementation of heapsort, in which an array of unordered items is loaded into a BinaryHeap, and the minimum-priority element is removed repeatedly and placed into the old array. BinaryHeap implements the heap *not as a tree*, but as an ArrayList, since it is very possible to use simple mathematical shortcuts to get from a "node" to its children and back instead of having to rely on pointers.

This project was completed in CSSE230 - Data Structures and Algorithm Analysis at Rose-Hulman Institute of Technology.