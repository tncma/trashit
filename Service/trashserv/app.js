
/**
 * Module dependencies.
 */

var express = require('express');
var routes = require('./routes');
var user = require('./routes/user');
var index = require('./routes/index');
var http = require('http');
var path = require('path');
//Models

var db = require('./model/db');



var app = express();

// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.json());
app.use(express.urlencoded());
app.use(express.methodOverride());
app.use(express.bodyParser());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));

// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

//Handle Complaints
app.get('/',index.alldata);
app.get('/list', index.retrieve);
app.post('/add', index.insert);
app.put('/update',index.update);
// Handle User Details
app.get('/users',user.alldata);
app.post('/users/add',user.insertuser);
app.put('/users/update',user.updateuser);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
