//  OpenShift sample Node application
var express = require('express'),
    app     = express(),
    cors    = require('cors'),
    morgan  = require('morgan');


var session = require('express-session');
var Keycloak = require('keycloak-connect');

var apiRouter = require('./api/routes/index.js');

var memoryStore = new session.MemoryStore();


Object.assign=require('object-assign')

app.engine('html', require('ejs').renderFile);
app.use(morgan('combined'));
app.use(express.json());
app.use(session({
  secret: 'mySecret',
  resave: false,
  saveUninitialized: true,
  store: memoryStore
}));

var keycloak = new Keycloak({ store: memoryStore });

app.use( keycloak.middleware({
  logout: '/logout',
  admin: '/'
}));

var port = process.env.PORT || process.env.OPENSHIFT_NODEJS_PORT || 8080,
    ip   = process.env.IP   || process.env.OPENSHIFT_NODEJS_IP || '0.0.0.0';

// Allow CORS
app.use(cors());

app.use('/api', keycloak.protect(), apiRouter);
//app.use('/api', apiRouter);

// error handling
app.use(function(err, req, res, next){
  console.error(err.stack);
  res.status(500).send('Something bad happened!');
});

//const https = require('https');
//const fs = require('fs');

app.listen(port, ip);
console.log('Server running on http://%s:%s', ip, port);

module.exports = app ;
