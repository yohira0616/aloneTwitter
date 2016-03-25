"use strict";
const tweetContents = require('../components/tweet-contents');
const tweetLengthCounter = require('../components/tweet-length-counter');

var TwitterService = {
    tweetInputClear:function() {
        tweetContents.emptyContents();
        tweetLengthCounter.updateLength(0);
    }
};
module.exports = TwitterService;