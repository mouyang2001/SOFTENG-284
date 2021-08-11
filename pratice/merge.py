def merge_two_sorted_arrays(A, B):
  # Write your code here
  i = len(A) - 1
  j = len(B) - 1
  k = len(A) + len(B) - 1
  while i >= 0 and j >= 0:
      if A[i] > B[j]:
          A[k] = A[i]
          i -= 1
      else:
          A[k] = B[j]
          j -= 1
      k -= 1
  while j >= 0:
      A[k] = B[j]
      j -= 1
      k -= 1
  return A

