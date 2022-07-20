class Solution {
    public void duplicateZeros(int[] A) {
       int n = A.length, count = 0;
    
    for (int num : A) 
        if (num == 0) count++;
        
    int i = n - 1;
    int j = n + count - 1;
    
    while (i >= 0 && j >= 0)  {
      
          if (A[i] != 0) { // Non-zero, just write it in
            if ( j< n)
                A[j] = A[i];
          } 
          else { // Zero found, write it in twice if we can
            if (j < n) A[j] = A[i];
            j--;
            if (j < n) 
                A[j] = A[i];
          }

          i--;
          j--;
        }
    }
}