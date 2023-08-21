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
use ('hopital');

// Insert a few documents into the sales collection.
// db.getCollection('patients').insertMany([
//   { _id:01, nom:"a", prenom:"matthieu",age: 27,  history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]},
//   { _id:02, nom:"b", prenom:"clement",age: 24, history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]},
//   { _id:03, nom:"c", prenom: "theo" ,age:6,  history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]},
//   { _id:04, nom:"d", prenom:"cassandre",age: 31,  history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]},
//   { _id:05, nom:"e", prenom :"vincent",age: 37, history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]},
//   { _id:06, nom: "f", prenom:"mohammed",age: 45,  history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]},
//   { _id:07, nom:"g", prenom:"leo",age: 23, history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]},
//   { _id:08, nom:"h", prenom:"alexandre",age: 40,  history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]}
// ]);



// db.patients.insertMany([s
//   { _id:09, nom: "f", prenom:"mohammed",age: 45,  history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]},
//   { _id:10, nom:"g", prenom:"leo",age: 23, history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]},
//   { _id:11, nom:"h", prenom:"alexandre",age: 40,  history:[{desease:"engine",treatment:"sirop"},{desease:"grippe",treatment:"sirop"}]}
// ]);

// db.patients.updateOne({_id: 01},{$set: {nom: "robert"}});

// db.patients.find({age:{$gt:29}}).pretty();
// db.patients.deleteMany({history:[{desease:"rhume"}]});





