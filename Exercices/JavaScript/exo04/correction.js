// Déclaration des variables
let cote,
    longueur,
    largeur,
    perimetreCarre,
    aireCarre,
    perimetreRectangle,
    aireRectangle,
    affichage;


// Carré

cote = Number(prompt("Veuillez saisir le coté de votre carré : "))

perimetreCarre = cote * 4;

aireCarre = cote * cote;

affichage = `Le périmètre de votre carré est de ${perimetreCarre} et son aire est de ${aireCarre}`

console.log(affichage);

// Rectangle

longueur = Number(prompt("Veuillez saisir la longueur de votre rectangle : "))
largeur = Number(prompt("Veuillez saisir la largeur de votre rectangle : "))

perimetreRectangle = (longueur + largeur) * 2;

aireRectangle = longueur * largeur;

affichage = `Le périmètre de votre rectangle est de ${perimetreRectangle} et son aire est de ${aireRectangle}`

console.log(affichage);