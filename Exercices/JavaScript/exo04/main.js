let perimetre,
    perimetreRectangle,
    aire,
    longueur,
    largeur,
    cote,
    affichageCarre,
    affichageRectangle;

cote = Number(prompt("Veuillez saisir le coté de votre carré : "));
perimetre = cote * 4;
aire = Math.pow((perimetre / 4),2);

affichageCarre = `Le périmètre du carré est égale à : ${Math.round(perimetre)} et l'aire de votre carré : ${Math.round(aire)}`;

console.log(affichageCarre);

alert(affichageCarre)

longueur = Number(prompt("Veuillez saisir la longueur de votre rectangle : "))
largeur = Number(prompt("Veuillez saisir la largeur de votre rectangle : "))

perimetreRectangle = (longueur + largeur) * 2;

affichageRectangle = `Le périmètre d'un rectangle est égale à : ${Math.round(perimetreRectangle)}`;

console.log(affichageRectangle);

alert(affichageRectangle);

