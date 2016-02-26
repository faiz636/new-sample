/**
 * Created by Faiz on 14/02/2016.
 */

var express = require('express');
var bodyParser = require('body-parser');
var mysql = require('mysql');

var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

var pool = mysql.createPool({
    connectionLimit: 100, //important
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'gcm_test',
    debug: false
});

var i = 0;

app.all('/test', function (req, res) {

    // Prepare output in JSON format
    response = {
        testing1: req.query.first_name,
        testing2: req.query.last_name
    };
    console.log(i++);
    console.log(req.method);
    console.log(req.query);
    console.log(req.headers);
    console.log(req.body);

    response.test = "good testing";
    res.json(response);
});

app.route('/register')
    .post(function (req, res) {
        var body = req.body;
        if (body.userid == null || body.registration_id == null || body.userid == null) {
            res.json({"code": 400, "status": "incomplete data"});
            console.log("incomplete request: ");
            console.log(body);
            return
        }

        pool.getConnection(function (err, connection) {
            if (err) {
                res.json({"code": 100, "status": "Error in connection database"});
                //connection.release();
                if (connection == null) {
                    console.log("null connection");
                }
                console.log(err);
                return;
            }

            console.log('connected as id ' + connection.threadId);
            var query;
            if (body.deviceid > 0) {
                query = 'UPDATE `api_key` SET ' +
                    '`registration_id` = ' +
                    '"' + body.registration_id + '"' +
                    'WHERE ' +
                    '`deviceid` = ' +
                    body.deviceid;
                console.log("record updating for id "+body.deviceid);
            } else {
                query = 'INSERT INTO `api_key`' +
                    '(`userid`,`registration_id`)' +
                    'VALUES(' +
                    '"' + body.userid + '",' +
                    '"' + body.registration_id + '"' +
                    ')';
                console.log("new record");
            }
            connection.query(query, function (err, result) {
                connection.release();
                if (!err) {
                    obj = {"code": 200};
                    obj.deviceid = result.insertId;
                    obj.status = "device key updated";
                    //console.log(result);
                    res.json(obj);
                    console.log("operation complete");
                }
            });

            connection.on('error', function (err) {
                res.json({"code": 100, "status": "Error in connection database"});
                return;
            });
        });

    });

app.listen(8888, function () {
    console.log('Example app listening on port 3000!');
});