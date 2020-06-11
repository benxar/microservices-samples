require('../models/user');

const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');

const User = mongoose.model('User');

const user = (req, res) => {
    res
        .status(201)
        .json({"status": "success"});
};

router
    .route('/user')
    .get(user);

module.exports = router;