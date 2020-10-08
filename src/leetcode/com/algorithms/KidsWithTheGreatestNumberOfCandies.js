/**
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
var kidsWithCandies = function (candies, extraCandies) {
  let max = Math.max(...candies);
  return candies.map((kid) => kid + extraCandies >= max);
};

kidsWithCandies([2, 3, 5, 1, 3], 3);
