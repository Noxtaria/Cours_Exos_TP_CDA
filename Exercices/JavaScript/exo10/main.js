let eau = 1,
    orange = 2,
    limonade = 3,
    cafe = 4,
    the = 5;

let choixUtilisateur = Number(prompt("Quel boisson désirez-vous parmis la liste suivant : "));

switch(choixUtilisateur) {
    case '1':
        console.log("Vous avez choisi de l'eau");
        break;
    case '2':
        console.log("Vous avez choisi un Jus d'orange");
        break;
    case '3':
        console.log("Vous avez choisi une Limonade");
        break;
    case '4':
        console.log("Vous avez choisi un Café");
        break;
    case '5':
        console.log("Vous avez choisi un Thé");
        break;
    default:
        console.log("Vous n'avez rien choisis");
        break;
}