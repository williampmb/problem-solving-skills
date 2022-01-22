
const coinChangeTabulation = (coins, amount) =>{
    if(amount == 0) return 0;
    const comb = new Array(amount+1).fill(null);
    comb[0] = [];

    for(let i =0 ; i < amount ; i++){
        if(!comb[i]) continue;
        
        for(let coin of coins){
            let combination = [...comb[i], coin]
            if(i+coin>amount) continue;
            if(!comb[i+coin] || comb[i+coin].length > combination.length){
                comb[i+coin] =  combination;
            }

        }
    }
    
    return !comb[amount] ? -1: comb[amount].length;
} 

const coinChangeMemoization = (coins, amount) => {
    
    const combination = coinChangeMemoizationRecursively(coins,amount);
    return !combination?-1:combination.length;

}

function coinChangeMemoizationRecursively(coins, amount, memo={}){
    if(amount in memo) return memo[amount];
   if(amount ===0)return [];
   if(amount <0) return null;
    let result = null;

    for(let coin of coins){
        let change = amount - coin;
        let comb = coinChangeMemoizationRecursively(coins,change);
        if(comb !== null){
            let localCombination = [...comb, coin];
            if(!result || localCombination.length < result.length){
                result = localCombination;
            }
        }
    }
    memo[amount] = result;
    return memo[amount];
}

console.log(coinChangeMemoization([1,2,5],10))
console.log(coinChangeMemoization([2],3))
console.log(coinChangeMemoization([2,5],0))