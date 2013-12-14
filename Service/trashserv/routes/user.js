
/*
 * GET users listing.
 */

var results = require('../model/list');

exports.retrieve = function(req, res){
	results.getLoc(function(err,list){
		res.send(list);
	}, req.query.lat,req.query.lng);
};