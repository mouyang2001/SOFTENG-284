def isPalindrome(x):
  nums = [n for n in str(x)]
  i = 0
  j = len(nums) - 1
  while i <= j:
    if nums[i] != nums[j]:
      return False
    i=i+1
    j=j-1
  
  return True


x = 1121
print(isPalindrome(x))