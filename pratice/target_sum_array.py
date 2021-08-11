def target_sum_brute_force(target, nums):
  for i in range(target):
    for j in range(i+1, len(nums)):
      if (nums[i]+nums[j] == target):
        print(nums[i], nums[j])
        return "found"
  return "none"

nums = [4,5,3,7,3]
target = 8
print(target_sum_brute_force(target, nums))

def target_sum_n_log_n(target, nums):
  # log n time
  nums = sorted(nums)
  i = 0
  j = len(nums)-1
  
  # linear n time
  while (i < j):
    if (nums[i] + nums[j] == target):
      print(nums[i], nums[j])
      return "found"
    if (nums[i] + nums[j] > target):
      j=j-1
    if (nums[i] + nums[j] < target):
      i=i+1
  return "none"

nums = [1,2,3,3,5,7,8]
target=6
print(target_sum_n_log_n(target, nums))

def target_sum_n(target, nums):
  complement = {}
  for n in nums:
    c = target-n
    if (c in complement):
      print(n, c)
      return "found"
    else:
      complement[n] = c

  return "none"

nums = [6,3,5,3,4,7,8,1]
target = 6
print(target_sum_n(target, nums))
