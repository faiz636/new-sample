/**
 * Created by Faiz on 20/02/2016.
 * this project is intended to learn mysql for node js
 */
var mysql      = require('mysql');
var connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : '',
    database : 'gcm_test'
});

connection.connect();

connection.query('INSERT INTO `api_key`' +
    '(`userid`,`registration_id`)' +
    'VALUES(' +
    '"test3",' +
    '"asdfjasdkfalskdfhasldkfjasldfkjasdfahsdkjlf"' +
    ')', function(err,result) {
        if (err) throw err;

        console.log(result);

    });
/*
connection.query('SELECT * from api_key', function(err, rows, fields) {
    if (err) throw err;
    console.log('fields are: ', fields);
    rows.forEach(function(element, index, arr){
        console.log('row '+index+': ', element);
        console.log('row '+index+': ', element.userid);
        console.log('row '+index+': ', element.deviceid);
        console.log('row '+index+': ', element.registration_id);
        console.log('row '+index+': ', element.timestamp);

    });
 });
 */

 /*
 console.log('The solution is: ', rows[0]);
 console.log('The solution is: ', rows[0].userid);
 console.log('The solution is: ', rows[0].deviceid);
 console.log('The solution is: ', rows[0].registration_id);
 console.log('The solution is: ', rows[0].timestamp);
 */

connection.end();