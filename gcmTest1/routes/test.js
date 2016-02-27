/**
 * Created by Faiz on 27/02/2016.
 */
var express = require('express');

var router = express.Router();

var i=0;

router.all('/', function (req, res) {
    console.log("\ntest request number "+i++);
    // Prepare output in JSON format
    response = {
        testing1: req.query.first_name,
        testing2: req.query.last_name
    };
    console.log(req.method);
    console.log(req.query);
    console.log(req.headers);
    console.log(req.body);

    response.test = "good testing";
    res.json(response);
});

module.exports = router;