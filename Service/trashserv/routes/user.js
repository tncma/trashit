/*
 * GET users listing.
 */

var user = require('../model/user');

exports.alldata = function(req, res) {
	user.getAll(function(err, list) {
		res.send(list);
	});
};

exports.insertuser = function(request, res) {
	
	user.insert(function(err, result) {
		res.send(result);
	}, request.body);

};

exports.updateuser = function(request, res) {
	user.update(function(err, result) {
		res.send(result);
	}, request.body);

};