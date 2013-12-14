/**
 * New node file
 */
var mongoose = require('mongoose');
exports.getLoc = function list(callback, lat,log){
	console.log('Calling DB');
	 var COMPLAINT = mongoose.model( 'COMPLAINT' );

	 COMPLAINT.find({"loc":{"$near":[lat,log],"$maxDistance":0.44996}},function(e,docs){
			if(e)
				console.log(e);
			else {
				console.log("Result::::"+ docs);
				callback("",docs);
			}
			
        });
};


exports.getAll = function list(callback){
	console.log('Calling DB');
	 var COMPLAINT = mongoose.model( 'COMPLAINT' );

	 COMPLAINT.find({},function(e,docs){
			if(e)
				console.log(e);
			else {
				console.log("Result::::"+ docs);
				callback("",docs);
			}
			
        });
};