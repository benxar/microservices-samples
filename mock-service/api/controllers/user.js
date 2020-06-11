const user = (req, res) => {
    res
        .status(201)
        .json({"status": "success"});
};

module.exports = {
    user
}