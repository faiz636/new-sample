/**
 * Created by Faiz on 21/02/2016.
 */
var superagent = require("superagent");
//var googleAddress = 'https://gcm-http.googleapis.com/gcm/send';
superagent
    //.get('localhost:4000/test')
    .post('localhost:8888/test')

    .query({query: 'Manny'})
    .query({range: '1..5'})
    .query({order: 'desc'})

    //.set('content-type','application/json')
    //.set('API-Key', 'foobar')
    //.set('Accept', 'application/json')
    .set('Authorization', 'key=AIzaSyCHweEU0gXdGxQdFDIvWWh4bjbiIIck3m8')

    //.send({resdf:'adsfasd'})
    .send(
        {
            data: {
                score: 50,
                time: 465461
            },
            to:'adfaskdfahklsdfjahlskdfjasdflaks'
        }
    )
/*
*/
    .end(function (err, res) {
        console.log("response");
        //console.log(err);
        //console.log(res);

    });