/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var smallerNumbersThanCurrent = function(nums) {
    let arr = []
    for(let numb of nums){
        let qt = arr[numb]
        arr[numb] = !qt  ? 1: arr[numb]+1;
    }
    
    arr[0] = !arr[0] ? 0 : arr[0];
    for(let i =1; i < arr.length-1; i++){
        arr[i] = !arr[i]? arr[i-1]: arr[i]+arr[i-1];
    }
    let ans = [];
    for(let numb of nums){
        if(numb !=0){
            ans.push(arr[numb-1]);
        }else{
            ans.push(0)
        }
        
    }
    
    return ans;
};

console.log(smallerNumbersThanCurrent([7,7,7,7]))

console.log(smallerNumbersThanCurrent([0,1,2,2,3]))

console.log(smallerNumbersThanCurrent([8,1,2,2,3]))

