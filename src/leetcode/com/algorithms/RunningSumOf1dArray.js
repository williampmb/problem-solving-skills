/**
 * @param {number[]} nums
 * @return {number[]}
 */
var runningSum = function (nums) {
  let ans = [],
    sum = 0;
  if (!nums) return ans;
  nums.forEach((element) => {
    sum += element;
    ans.push(sum);
  });
  return ans;
};

var runningSum = function (nums) {
  for (let i = 1; i < nums.length; i++) {
    nums[i] += nums[i - 1];
  }
  return ans;
};

runningSum([1, 2, 3, 4]);
