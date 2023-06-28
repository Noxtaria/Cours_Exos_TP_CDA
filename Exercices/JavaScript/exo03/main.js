// Déclaration des variables 

let diametre, 
    perimetre, 
    aire, 
    affichage;

// Déclaration de constante
const pi = Math.PI;

// Calcul du périmètre du cercle

diametre = Number(prompt("Veuillez saisir le diamètre de votre cercle : "))
perimetre = diametre * pi;
aire = pi * Math.pow((diametre / 2),2);

affichage = `Le périmètre de votre cercle est égale à : ${Math.round(perimetre)} et l'aire de votre cercle : ${Math.round(aire)}`;

console.log(affichage);

alert(affichage);