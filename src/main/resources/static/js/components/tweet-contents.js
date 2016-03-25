"use strict";
const $ = require('jquery');
var TweetContents = {

    emptyContents: function () {
        $('#tweet-contents').val('');
    },
    getContents: function () {
        return $('#tweet-contents').val();
    },
    isEmpty: function () {
        return this.getContents() === '';
    },
    getContentsLength: function () {
        return this.getContents().length;
    },
    isLengthOver: function () {
        return this.getContentsLength() > 140;
    }
};

module.exports = TweetContents;