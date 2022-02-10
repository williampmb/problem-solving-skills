/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var getConcatenation = function(nums) {
    let arr = [];
    let n = nums.length;
    for(let i =0; i < n ; i++){
        arr[i]=nums[i];
        arr[i+n]=nums[i]
    }
    
    return arr;
};