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
use('User');
//db.Users.insertOne({name: "Chuck Norris", age: 77, hobbies: ["Karate", "Kung-Fu", "Rulling the World"]})
//db.Users.find({name : "Chuck Norris"})
//db.Users.find({}, {name: 1, age: 1, hobbies : 1})
//db.Users.find({ age : { $gt :  20, $lt : 30}})
//db.Users.find({$and : [{ age : { $gt :  30, $lt : 40}}, {gender: "male"}]})
db.Users.find({"address.state": "Louisiana"})
//db.Users.find().limit(20).sort({age : -1})
//db.Users.find({$and : [{age : 30}, {gender: "female"}]}).count()


//db.Users.updateMany({ },{ $unset: { phone: "" } })

//db.Users.updateOne({name : "Chuck Norris"}, {$set : {age: "Infinity"}})

//db.Users.updateMany({ age: {$gt : 50}}, { $push: { hobbies : "Jardinage" } })