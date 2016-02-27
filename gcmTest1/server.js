/**
 * Created by Faiz on 14/02/2016.
 */

var express = require('express');
var bodyParser = require('body-parser');

var register = require("./routes/register");
var news = require("./routes/news");
var test = require("./routes/test");

var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.use("/test",test);
app.use("/register",register);
app.use("/news",news);

app.listen(8888, function () {
    console.log('Example app listening on port 8888!');
});