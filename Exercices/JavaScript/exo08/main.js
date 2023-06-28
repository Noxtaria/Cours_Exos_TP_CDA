let wordSaisi = prompt("Veuillez saisir un mot");
let word = wordSaisi;
let palindrome = word == word.split('').reverse().join('');
let message = "";

message = `Le mot saisi est ${word} et est-il un palindrome : ${palindrome}`

console.log(message);