const express = require('express');
const router = express.Router();
const http = require('http');
const querystring = require('querystring');

const modules = (req, res) => {

  console.log(req.kauth.grant.access_token.token);
  // form data
  var postData = querystring.stringify({
    grant_type: "urn:ietf:params:oauth:grant-type:uma-ticket",
    audience: "portal-digital",
    response_mode: "permissions",
  });

  var options = {
    host: '127.0.0.1',
    port: 8180,
    path: '/auth/realms/test/protocol/openid-connect/token',
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
      'Content-Length': postData.length,
      'Authorization': 'Bearer ' + req.kauth.grant.access_token.token
    }
  };

  const umaReq = http.request(options, umaRes => {
    console.log(`statusCode: ${umaRes.statusCode}`)

    umaRes.on('data', d => {
      process.stdout.write(d),
      res
          .status(200)
          .json(JSON.parse(d.toString()));
    })
  });

  umaReq.on('error', error => {
    console.error(error)
  });

  umaReq.write(postData);
  umaReq.end();

};


router
    .route('/modules')
    .get(modules);

module.exports = router;
