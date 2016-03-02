/**
 * Created by Faiz on 29/02/2016.
 */
var superagent = require("superagent");
var address;
address = 'https://gcm-http.googleapis.com/gcm/send';
superagent
.post(address)
    .set('Authorization', 'key=AIzaSyCHweEU0gXdGxQdFDIvWWh4bjbiIIck3m8')

    .send(
        {
            "collapse_key" : "demo",
            "priority" : "high",
            "to" : "/topics/global",
            "notification": {
                "body": "making good",
                "title": "good test title" + (100 + i),
                "icon": "myicon"
            }
        }
    )

    .end(function (err, res) {
        console.log("response");
        //if (err != null) {
        console.log(err);
        //}
        console.log("================================");
        console.log(res.text);
        console.log(res.body);

    });
}