const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
  clientId: Number,
  name: String,
  mfaType: String
});

userSchema.index({date: 'date'});

mongoose.model('User', userSchema);