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

exports.insert = function(request, res){
	console.log(request.body);
		results.insert(function(err,result){
			res.send(result);
		}, request.body);
	
	
};


exports.update = function(request, res){
	console.log(request.body);
		results.update(function(err,result){
			res.send(result);
		},request.body);
	
	
};