def threeSumClosest(nums, target):
    closest_sum = sum(nums[:3])
    nums = sorted(nums)

    for i in range(len(nums) - 2):
        j = i + 1
        k = len(nums) - 1

        while j < k:
            current_sum = nums[i] + nums[j] + nums[k]

            if (current_sum > target):
                k -= 1
            else:
                j += 1

            if (abs(target - current_sum) < abs(target - closest_sum)):
                closest_sum = current_sum

        return closest_sum

print(threeSumClosest([-1, 2, 1, -4], 1))
