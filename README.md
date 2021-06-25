# data-structure-project
Find and analyize 7 different methods to find the amount of distinct numbers in an array

Original Pseudo-code:
```
D(A) // A is an array of numbers
U_Size = 1
For i=2 to length(A)
         U=TRUE
  For j=1 to U_Size
    If A[j]=A[i]
     Then U = FALSE
      j = U_Size
   if U = TRUE
     Then U_Size = U_Size +1   
         A[U_Size] = A[i]
return U_Size
```

The algorithm above finds the distinct element in a given array ( main purpose ) and re-arrange the array

The attached PDF file has all of the assignment instructions and demends written in hebrew

grade: 100
