/**
 * @param {number[][]} accounts
 * @return {number}
 */
 var maximumWealth = function(accounts) {
    
    let richest=0;
    for(let acc of accounts){
        let cur=0
        for(let bank of acc){
            cur +=bank
        }
        richest = richest>cur?richest:cur;
    }
    return richest;
};