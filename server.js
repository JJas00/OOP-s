//author : Jaswanth Jerripothula
//Project : Simple BMI Calculator Project in Node and Express
const express = require("express");
const bodyParser = require("body-parser");

const app = express();
app.use(bodyParser.urlencoded({extended: true}));

app.get("/", function(req, res){        // Request and Respond to the browser
  res.sendFile(__dirname+"/index.html");  //__dirname will give current directory of the file
});

app.post("/", function(req, res){          //Post request sent to the browser
  var n1 = Number(req.body.num1);
  var n2 = Number(req.body.num2);     //request to the server with the input values (req.body)
  var BMIresult = n1 / (n2 * n2);        // BMI operation
  var result = n1 + n2;
  res.send("The answer of BMI operation is :: " + BMIresult + " &  The answer of the operation is :: " + result);
});

app.listen(7000, function(){            //Server Establishment in localhost
  console.log("Server has started on port 7000");
});
