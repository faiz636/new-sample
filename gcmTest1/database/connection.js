/**
 * Created by Faiz on 27/02/2016.
 */
var mysql = require('mysql');

var pool = mysql.createPool({
    connectionLimit: 100, //important
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'gcm_test',
    debug: false
});

module.exports = pool;