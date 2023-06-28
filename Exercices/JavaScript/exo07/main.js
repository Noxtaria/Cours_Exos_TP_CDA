let email = "test@test.fr";
let password = "jesuisuntest";

let emailSaisi = prompt("Veuillez saisir votre email : ");
let passwordSaisi = prompt("Veuillez saisir votre mot de passe : ");

if(emailSaisi == email && passwordSaisi == password){
    console.log("Email et Password OK! o/")
} else {
    console.log("C'est pas bon, DOMMAGE ! :D")
}

