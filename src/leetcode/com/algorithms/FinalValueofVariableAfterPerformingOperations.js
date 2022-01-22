/**
 * @param {string[]} operations
 * @return {number}
 */
 var finalValueAfterOperations = function(operations) {
  
    let x = 0;
    for(let op of operations){
        if('--X'===op || 'X--' ===op){
            x--;
        }else{
            x++
        }
    }
    return x;
};