let etudiants = [ 
    { 
        prenom: "José", 
        nom: "Garcia", 
        matieres: { 
            francais: 16, 
            anglais: 7, 
            humour: 14 
        }  
    }, 
    { 
        prenom: "Antoine", 
        nom: "De Caunes", 
        matieres: { 
            francais: 15, 
            anglais: 6, 
            humour: 16, 
            informatique: 4, 
            sport: 10 
        } 
    } 
]; 

for(let i = 0; i < etudiants.length; i++){
    console.table(etudiants[i].prenom)
    console.table(etudiants[i].nom)
    console.table(etudiants[i].matieres)

    for(let matieres in etudiants){
        console.log(matieres + " : " +matieres[value]);// Affiche la valeurs
    }

    console.log("")
}