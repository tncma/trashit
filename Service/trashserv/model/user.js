/**
 * New node file
 */
var mongoose = require('mongoose');

exports.getAll = function list(callback) {
	var USER = mongoose.model('USER');
	console.log('Calling DB - Get All Users');
	USER.find({}, function(e, docs) {
		if (e)
			console.log(e);
		else {
			console.log("Retrieval Fine!!");
			callback("", docs);
		}

	});
};

exports.insert = function add(callback, data) {
	console.log('Calling DB - Insert a new User');
	var USER = mongoose.model('USER');
	var newRequest = new USER({
		name : data.name,
		email : data.email,
		mobile : data.mobile,
		points : data.points
	});
	newRequest.save();
	callback('', {
		status : 'success'
	});
};

exports.update = function modify(callback, data) {
	console.log('Calling DB - Update the bounty a new User');
	var USER = mongoose.model('USER');
	USER
			.find(
					{
						'_id' : data._id
					},
					"points",
					function(e, result) {
						if (result && result.length > 0) {
							if (result.size)
								console.log(result);
							var newBounty = (parseInt(result[0].points) + parseInt(data.points))
									+ '';
							USER.findOneAndUpdate({
								'_id' : data._id
							}, {
								points : newBounty
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