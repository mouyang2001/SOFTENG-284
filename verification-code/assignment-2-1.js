function sillySort(nums) {

    count = 0;

    for (let i = 0; i < nums.length-1; i++) {
        count++
        if (nums[i] > nums[i + 1]) {
            count++
            let temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
            i = -1;
        }
    }

    return count;
}

a = [8,7,6,5,4,3,2,1];
console.log(sillySort(a));

a = [7, 6, 5, 4, 3, 2, 1];
console.log(sillySort(a));

a = [6, 5, 4, 3, 2, 1];
console.log(sillySort(a));

a = [5, 4, 3, 2, 1];
console.log(sillySort(a));

a = [4, 3, 2, 1];
console.log(sillySort(a));

a= [3, 2, 1];
console.log(sillySort(a));