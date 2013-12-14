/**
 * New node file
 */
var mongoose = require('mongoose');

//Complaint Schema
var compliantSchema = mongoose.Schema({
    loc: [],
    address: String,
    status:String,
    bounty:String,
    type:String,
    finalImagePath:String,
    complaints:[
            {
    		mobile:String,
    		bounty: String,
    		imagePath:String
    	}
      ]
	},{ collection : 'COMPLAINT' });
	compliantSchema.index({ loc: '2d' });
	
mongoose.model( 'COMPLAINT', compliantSchema );

// User Schema

var userSchema = mongoose.Schema({
    name: String,
    email: String,
    mobile: String,
    points: String
	
	},{ collection : 'USER' });

	
mongoose.model( 'USER', userSchema );


mongoose.connect('mongodb://127.0.0.1:27017/test');
var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
	db.once('open', function callback () {
		console.log("Db Connected - here");
});
	