/**
 * Created by Faiz on 21/02/2016.
 */

var http = require("http");
//var data = {};
var data = "hello world";
//data.msg = "hello world";
//{    'msg': 'Hello World!'};
var postData = JSON.stringify(data);
console.log('postdata:' + postData);

var options = {
    hostname: 'localhost',
    port: 4000,
    path: '/test',
    method: 'POST',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Content-Length': postData.length
    }
};

var req = http.request(options, function (res) {
        console.log('STATUS:' + res.statusCode);
        console.log('HEADERS: ' + JSON.stringify(res.headers));
        res.setEncoding('utf8');
        res.on('data', function (chunk) {
            console.log('BODY:' + chunk);
        })
        ;
        res.on('end', function () {
            console.log('No more data in response.')
        })
    })
    ;

req.on('error', function (e) {
    console.log('problem with request: ' + e.message);
})
;

// write data to request body
req.write(postData);
req.end();