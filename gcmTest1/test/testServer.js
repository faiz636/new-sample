/**
 * Created by Faiz on 20/02/2016.
 */
var express = require('express');
var bodyParser = require('body-parser');

var app = express();

app.use(bodyParser.json()); // for parsing application/json

// for parsing application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: true }));

app.all('/test', function (req, res) {

    // Prepare output in JSON format
    response = {};

    response.method = req.method;
    response.testing1 = req.query.first_name;
    response.testing2 = req.query.last_name;
    response.status = 200;

    console.log(req.method);
    console.log(req.query);
    console.log(req.headers);
    console.log(req.body);


    res.json(response);
});

app.route("/test2")
    .get(function(req,res,next){
        console.log(req.method);
        res.send(req.method);
    })
    .post(function(req,res,next){
        console.log(req.method);
        res.send(req.method);
    })
    .put(function(req,res,next){
        console.log(req.method);
        res.send(req.method);
    })
    .delete(function(req,res,next){
        console.log(req.method);
        res.send(req.method);
    })
    .all(function(req,res,next){
        console.log("all:"+req.method);
        res.send("all:"+req.method);
    });

app.route("/register")
    .post(function(req,res,next){
        var id = req.body.id;
        var key = req.body.key;
        //addRegId(id,key);
        res.json({status:200});
    });

app.listen(8888, function () {
    console.log('Example app listening on port 3000!');
});