const express = require('express');
const router = express.Router();

const user = (req, res) => {
    res
        .status(201)
        .json({"status": "success"});
};

router
    .route('/user')
    .get(user);

module.exports = router;
