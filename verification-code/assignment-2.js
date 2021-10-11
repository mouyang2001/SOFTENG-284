function strangeSort(nums) {
    var count = 0;
    for (let i = 1; i < nums.length; i++) {
        count++;
        if (nums[i] < nums[i - 1]) {
            var temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
            count++;

            
            if (i > 1) {
                i--;
            }
        }
    }

    return count;
}

let a = [1,2,3,4,5,6,7,8];
console.log(strangeSort(a));

let b = [8,7,6,5,4,3,2,1];
console.log(strangeSort(b));