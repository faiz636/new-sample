/**
 * Created by Faiz on 20/02/2016.
 */
function addRegId(regid,key){
    jsonObj = require("./registration.json");
    jsonObj[regid] = key;
    console.log(jsonObj);
}

// And then, to read it...
jsonArr = require("./registration.json");
console.log(jsonArr);
console.log(jsonArr.length);

