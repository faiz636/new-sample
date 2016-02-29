/**
 * Created by Faiz on 21/02/2016.
 */
var superagent = require("superagent");
var address;
address = 'https://gcm-http.googleapis.com/gcm/send';
//address = 'localhost:4000/test';
var i = 0;
for (i = 0; i < 50; i++) {
    superagent
    //.get('localhost:4000/test')
        .post(address)
        .set('Authorization', 'key=AIzaSyCHweEU0gXdGxQdFDIvWWh4bjbiIIck3m8')

        .send(
            {
                "collapse_key" : "demo",
                "priority" : "high",
                "to" : "/topics/global",
                //"to" : "e2FaQFC4Y2c:APA91bFqj6cD9yhQTPrrDGL6ZVUjRRkWZiyAS_T6eFnoU2QKQXQacPpVr1n7PR_kMgnu6mpYnmAyIfILzthOm_Nw41OQTVdWpAbhDFD1nbIyFp3AifCnxr99eeosp6IiQxMj5-zVX-y_",
                //"to" : "eE1k3c3oTn8:APA91bHp91A5wtvJThHatU_Atn7jR4UZ4c84uw4DJWLagufCYLuOSJzRTlbpwZgZkT0URMo9I5bmYpV3pyF3roaaByDZMxIurP17SgUq-XCQ5jDR0IiqSFh_dyp5MOo3VDthRRS0ZWKc",
/*
                "registration_ids": [
                    "fY_FWe4u_TA:APA91bGIdtLFJXdCTDJkTwsozinW3sj_AWrPp7mT2RlhfRledpIvl3I5bCsE7Hvu_kfcsYK6V6VQ2hD75mLTIvD9VJ-v0C9cB_dCg_yrgLXQlkC7T-cjY7UxA4ehRlnGOYYV-zbYnVhY",
                    "coy6lZt5c4s:APA91bGGf-lXaesgPYhsNVlcJ_hmTMbrJdTNoQlCqtMd-XiWxv83uSr8o2SApgt6XbCo_J8jQtptMuDbiMRuuBmSmh03yyf29MMPmlG0FlivgNMDDfXhL-7CTEfpfqJIvR2Zih4RpDo1"
                ],
*/
                "notification": {
                    "body": "testing is good",
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