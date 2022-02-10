const buildArray = nums =>{
    let arr = []
    for(let i =0; i < nums.length;i++){
        arr[i] = nums[nums[i]];
    }
    
    return arr;
        
}

buildArray([0,2,1,5,3,4])