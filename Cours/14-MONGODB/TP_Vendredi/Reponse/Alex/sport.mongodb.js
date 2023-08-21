/* global use, db */
// MongoDB Playground
// To disable this template go to Settings | MongoDB | Use Default Template For Playground.
// Make sure you are connected to enable completions and to be able to run a playground.
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.
// The result of the last command run in a playground is shown on the results panel.
// By default the first 20 documents will be returned with a cursor.
// Use 'console.log()' to print to the debug output.
// For more documentation on playgrounds please refer to
// https://www.mongodb.com/docs/mongodb-vscode/playgrounds/

// Select the database to use.
use('Sport');
// Tous les sportifs entre 20 et 30 ans
//db.sportsmen.find({Age : {$gte: 20, $lte: 30}},{_id: 0, Sexe: 0, Age: 0, Sports: 0, IdSportifConseiller: 0})

//Gymnases de la ville de Villetaneuse ou de Sarcelles avec une surface de plus de 400m2
//db.places.find({$and :[{$or : [{Ville : "SARCELLES"}, {Ville : "VILLETANEUSE"}]}, {Surface : {$gte: 400}}]})

//Sportifs qui pratiquent le handball
//db.sportsmen.find({"Sports.Jouer" : "Hand ball"}, {_id: 1, Nom:1})

//Sportifs ne praticant aucun sport
//db.sportsmen.find({"Sports.Jouer": null})

// Gymnases sans séances le dimanche
//db.places.find({"Seances.Jour" : {$ne : "Dimanche"}})

//Gymnases proposant séance de basket ou volley ball
//db.places.find({$or : [{"Seances.Libelle" : "Volley ball"}, {"Seances.Libelle" : "Basket ball"}]})

// Liste des entraineurs-joueurs
//db.sportsmen.find({$nor : [{"Sports.Jouer" : null}, {"Sports.Entrainer" : null}]})

// Conseiller du sportif Kervadec

//Moyenne d'âge des sportives qui pratiquent le basket
db.sportsmen.aggregate([{$match : {$and : [{Sexe : "F"}, {"Sports.Jouer" : "Basket ball"}]}}, {$group: {_id: ""},avg_age : {$avg: ""}}])

// Entraineurs qui n'entrainent que du hand ou du basket

// Donner le nombre de sports que chaque sportif arbitre
