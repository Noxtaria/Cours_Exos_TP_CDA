let n = Number(prompt("Veuillez saisir un nombre : "));
let results = [];

for (let i = 1; i <= (n / 2); i++) {
    let currentSum = i;
    for (let j = i + 1; j <= n; j++) {
        currentSum += j;
        if (currentSum === n) {
            let consecutive = [];
            for (let k = i; k <= j; k++) {
                consecutive.push(k);
            }
            results.push(consecutive);
            break;
        } else if (currentSum > n) {
            break;
        }
    }
}

console.log(results);