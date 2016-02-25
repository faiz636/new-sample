/**
 * Created by Faiz on 14/02/2016.
 */

var http = require("http");

var post_data = JSON.stringify(

    {
        "collapse_key": "minha chave legal",
        "data": {
            "score": "4x8",
            "time": "15:16.2342",
            "age" : 29
        },
        "registration_ids": [“YOUR_REGISTRATION_IDS_GENERATED_BY_THE_DEVICES”]
}

);

var options = {
    hostname: "android.googleapis.com",
    port: 80,
    path: "/gcm/send",
    method: "POST",
    headers: {
        "content-type": "application/json",
        "content-length": post_data.length,
        "authorization": "key=AIzaSyBFlByhiw7S5_4BWw-r9PSyBX6Vy0VBRPU"
    }
};

var req = http.request(options, function(res) {

    console.log("STATUS: " + res.statusCode);
    console.log("HEADERS: " + JSON.stringify(res.headers));

    res.setEncoding("utf8");

    res.on("data", function(chunk) {

        console.log("BODY: " + chunk);

    });

});

req.on("error", function(e) {

    console.log("problem with request: " + e.message);
    console.log(e.stack);

});

// write data to request body
req.write(post_data);

req.end();
