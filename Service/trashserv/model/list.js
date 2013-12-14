/**
 * New node file
 */
var mongoose = require('mongoose');
var config = require('../config');

exports.getLoc = function list(callback, lat, log) {
	var COMPLAINT = mongoose.model('COMPLAINT');
	console.log('Calling DB - List Specific Data');
	COMPLAINT.find({
		"loc" : {
			"$near" : [ lat, log ],
			"$maxDistance" : config.radius
		}
	}, function(e, docs) {
		if (e)
			console.log(e);
		else {
			console.log("Retrieval Fine!!");
			callback("", docs);
		}

	});
};

exports.getAll = function list(callback) {
	console.log('Calling DB - List all the data');
	var COMPLAINT = mongoose.model('COMPLAINT');
	COMPLAINT.find({}, function(e, docs) {
		if (e)
			console.log(e);
		else {
			console.log("Retrieval Fine!!");
			callback("", docs);
		}

	});
};

exports.insert = function add(callback, data) {
	var COMPLAINT = mongoose.model('COMPLAINT');
	console.log('Calling DB - Insert data');
	var newRequest = new COMPLAINT({
		address : data.address,
		status : data.status,
		bounty : data.bounty,
		type : data.type,
		loc : data.loc,
		complaints : data.complaints
	});
	newRequest.save();
	callback('', {
		status : 'success'
	});

};

exports.update = function modify(callback, data) {
	console.log('Calling DB - Update data');
	var COMPLAINT = mongoose.model('COMPLAINT');
	COMPLAINT
			.find(
					{
						'_id' : data._id
					},
					"bounty complaints",
					function(e, result) {

						if (result && result.length > 0) {
							var newBounty = (parseInt(result[0].bounty) + parseInt(data.complaints[0].bounty))
									+ '';
							result[0].complaints.push(data.complaints[0]);
							COMPLAINT.findOneAndUpdate({
								'_id' : data._id
							}, {
								bounty : newBounty,
								complaints : result[0].complaints
							}).exec();
							callback('', {
								status : 'success'
							});
						} else {
							callback('', {
								status : 'failure'
							});
						}

					});

};
