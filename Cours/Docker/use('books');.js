use('books');
// db.books.insertOne({title: "je suis un livre", pageCount: 455});
// db.books.insertMany([{title: "je suis un livre", pageCount: 455},{title: "cassandra , elle est là", pageCount: 455, status: "PUBLISHED"}])

// command find

// db.books.find();
// db.books.find().limit(5);
// db.books.findOneAndDelete({title: "Unlocking Android"});

// db.books.find({pageCount: {$gt: 500}}).pretty();

// db.books.find({categories: {$all: ['Java', 'Web Development']}});

// db.books.find({categories: {$all: ['PowerBuilder', 'Client-Server']}})

// db.books.find({$or: [{_id: 19}, {_id:98745}]});

// db.books.find({}, {title: 1, status: 1});

