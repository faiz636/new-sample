/**
 * Created by Faiz on 21/02/2016.
 */
var superagent = require("superagent");
var address;
address = 'https://gcm-http.googleapis.com/gcm/send';
//address = 'localhost:4000/test';
superagent
//.get('localhost:4000/test')
    .post(address)
    .set('Authorization', 'key=AIzaSyCHweEU0gXdGxQdFDIvWWh4bjbiIIck3m8')

    .send(
        {
            "to" : "cULPqFEQfK0:APA91bFq7EQhY78v6UM6eEgMD_szPGQH7E6-c7Ve6htoyxlT574LXqLeY9ja8mb1p-ogzhy3ws8HDGatximnflcRPs0fhggJAzNa1MNz597F9Wv1MJrBfPvgzmA22fqKmK27GxQw3qRO",
            "notification" : {
                "body" : "great match!",
                "title" : "Portugal vs. Denmark",
                "icon" : "myicon"
            }
        }
    )

    .end(function (err, res) {
        console.log("response");
        //console.log(err);
        //console.log(res);

    });