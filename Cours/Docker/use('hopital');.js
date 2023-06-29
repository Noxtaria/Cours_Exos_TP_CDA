use('hopital');

// db.hopital.insertMany([{firstname: "Jean", lastName: "PAUL", age: 30}, {firstname: "Vincent", lastName: "TIM", age: 41}, {firstname: "Merlin", lastName: "LEROY", age: 74}])

db.hopital.insertMany([{
firstname: "Luc",
lastName: "SKY",
age: "24",
history: [{desease: "Rhume",treatment: "Repos"},{desease: "Rhino",treatment: "Aspirin"}]},

{firstname: "Bill",lastName: "ELLIOT",age: "69","history": [{desease: "Grippe",treatment: "Repos"}, {desease: "Gastro",treatment: "Smecta"}]},

{firstname: "Finn",lastName: "LAKILL",age: "30","history": [{desease: "Angine",treatment: "Soupe"}, {desease: "Fievre",treatment: "Repos"}]}]);

// db.hopital.updateOne(
// {firstname: "Bill"},{$set: {age: "69"}, $set: {firstname: "Lilie"}, $set: {history: [{desease: "Rhume",treatment: "Sirup"}, {desease: "Grippa",treatment: "Aspirin"}]}});

// db.hopital.find({age: {$gt: "29"}}).pretty();

// db.hopital.findOneAndDelete({desease: "Rhume"});