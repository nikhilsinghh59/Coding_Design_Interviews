/*

Given file1, file2 you need to print the modification made in file 1 to get file2. That is if an element is removed from file1 to make file2, you need to append -ve sign before it, if new element is added in file1 to make file2, you need to append +ve sign before it. (Similar to git diff)

Example:
File 1: A B C
File 2: B C D

Output : -A B C +D

Soln : 
Find the Longest Common Subsequence (LCS) of the two files' contents.
Obviously, you need to label the elements of the LCS in the 2 files, and then work out + and - accordingly.

*/