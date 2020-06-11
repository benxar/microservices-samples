const express = require('express');
const router = express.Router();

const token = (req, res) => {

    console.log("\n");
    console.log("validate: ")
    console.log("\t dni: \t" + req.body.dni);
    console.log("\t pin: \t" + req.body.pin);
    console.log("\t clave: " + req.body.clave);
    console.log("\n");

    if (req.body.dni == '28018235' &&
        req.body.pin == '1234' &&
        req.body.clave == 'redhat01') {
        res
            .status(200)
            .json({
                "clientId": "XXXX-XXXX-XXXX-XXXX",
                "mfaType": "otp",
                "name": "Benja",
                "status": "active"
            })
    } else {
        res
            .status(403)
            .json({
                "status": "Forbidden"
            });
    }

};

router
    .route('/validate')
    .post(token);

module.exports = router;
