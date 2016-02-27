/**
 * Created by Faiz on 27/02/2016.
 */

var express = require('express');

var pool = require('./../database/connection');

var router = express.Router();

var i = 0;

router.route('/')
    .post(function (req, res) {
        console.log("\nregister request number "+i++);
        var body = req.body;
        if (body.userid == null || body.registration_id == null || body.userid == null) {
            res.json({"code": 400, "status": "incomplete data"});
            console.log("incomplete request: ");
            console.log(body);
            return
        }

        pool.getConnection(function (err, connection) {
            console.log("connecting database");
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

module.exports = router;
