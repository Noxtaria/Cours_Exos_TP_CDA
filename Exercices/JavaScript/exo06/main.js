// Déclaration des variables

let tva,
    prix,
    valeurTVA,
    prixTTC,
    affichage;

// Entrer des valeurs

prix = Number(prompt("Quel est le prix hors taxe de votre article : "));
tva = Number(prompt("Quel est le % tva appliqué (valeur entre 0 et 100) : "));

// calcul

valeurTVA = prix * (tva / 100);
prixTTC = prix + valeurTVA;

// affichage
