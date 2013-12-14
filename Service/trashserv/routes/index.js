var results = require('../model/list');

exports.retrieve = function(req, res){
	results.getLoc(function(err,list){
		res.send(list);
	}, req.query.lat,req.query.lng);
};

exports.alldata = function(req, res){
	results.getAll(function(err,list){
		res.send(list);
	});
};


