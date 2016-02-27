/**
 * Created by Faiz on 27/02/2016.
 */
var express = require('express');

var pool = require('./../database/connection');

var router = express.Router();

var i = 0;

router//.route('/')
    .post("/", function (req, res) {
        console.log("\nnews post request: " + i++);
        var body = req.body;
        if (body.title == null || body.s_desc == null || body.l_desc == null || body.author == null) {
            res.json({"code": 400, "status": "incomplete data"});
            console.log("incomplete request: ");
            console.log(body);
            return
        }
        var title = body.title;
        var s_desc = body.s_desc;
        var l_desc = body.l_desc;
        var author = body.author;
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
            var query, values;

            query = "INSERT INTO `news`( `title`, `s_desc`, `l_desc`, `author`";
            values = "VALUES( " +
                "'" + title + "', " +
                "'" + s_desc + "', " +
                "'" + l_desc + "', " +
                "'" + author + "' ";
            if (body.imageurl != null) {
                query += ", `imageurl`";
                values += ",'" + body.imageurl + "' ";
            }

            query = query + ")" + values + " )";
            console.log(query);
            connection.query(query, function (err, result) {
                console.log("database response");
                console.log(result);
                connection.release();
                if (!err) {
                    obj = {"code": 200};
                    obj.deviceid = result.insertId;
                    obj.status = "news added";
                    //console.log(result);
                    res.json(obj);
                    console.log("operation complete");
                } else {
                    console.log("database bad error response");
                    console.log(err);
                    res.json({"code": 100, "status": "Error in database query"});
                }
            });

            connection.on('error', function (err) {
                console.log("database error response");
                console.log(err);
                res.json({"code": 100, "status": "Error in connection database"});
                return;
            });
        });

    })
    .get("/", function (req, res) {
        console.log("\nnews get request: " + i++);
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
            var query = "SELECT * FROM `news`";
            connection.query(query, function (err, result) {
                console.log("database response");
                //console.log(result);
                connection.release();
                if (!err) {
                    obj = {"code": 200};
                    obj.status = "good";
                    obj.data = result;
                    res.json(obj);
                    console.log("operation complete");
                } else {
                    console.log("database bad error response");
                    console.log(err);
                    res.json({"code": 100, "status": "Error in database query"});
                }
            });

            connection.on('error', function (err) {
                console.log("database error response");
                console.log(err);
                res.json({"code": 100, "status": "Error in connection database"});
                return;
            });
        });
    })
    .get("/:id/*", function (req, res) {
        console.log("\nnews get request: " + i++ + " with id " + req.params.id);
        console.log(req.params);
        //console.log(req);
/*
        obj = {"code": 200};
        obj.status = "good";
        res.json(obj);
*/
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
            var query = "SELECT * FROM `news` WHERE `newsid`="+req.params.id;
            connection.query(query, function (err, result) {
                console.log("database response");
                //console.log(result);
                connection.release();
                if (!err) {
                    obj = {"code": 200};
                    obj.status = "good";
                    obj.data = result;
                    res.json(obj);
                    console.log("operation complete");
                } else {
                    console.log("database bad error response");
                    console.log(err);
                    res.json({"code": 100, "status": "Error in database query"});
                }
            });

            connection.on('error', function (err) {
                console.log("database error response");
                console.log(err);
                res.json({"code": 100, "status": "Error in connection database"});
                return;
            });
        });
    });

module.exports = router;
