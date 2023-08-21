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
use('Hopital');

//db.patient.insertOne({firstname: "Alexandre", lastname: "Lecoeur", age: 37, history : [{desease : "rhume", treatment: "sirop"}, {desease : "fièvre", treatment: "doliprane"}]})
//db.patient.insertOne({firstname: "Karim", lastname: "Megri", age: 35, history : [{desease : "typhus", treatment: "antibio"}]})
//db.patient.insertOne({firstname: "Emilea", lastname: "Lecoeur", age: 32, history : [{desease : "angine", treatment: "sirop"}]})

//db.patient.updateOne({firstname: "Emilea"}, {$set : {lastname: "Toto Lobe", age : 33, history : {desease: "grippe", treatment: "sirop"}}})
//db.patient.find({age: {$gt: 34}})

db.patient.findOneAndDelete({"history.desease" : "rhume"})