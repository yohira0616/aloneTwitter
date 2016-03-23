"use strict";
const $ = require('jquery');
const TWEET_MAX_LENGTH = 140;
class TweetContents {

    constructor() {
        this.$elem = $('#tweet-contents');
    };

    emptyContents() {
        this.$elem.val('');
    }

    getContents() {
        return this.$elem.val();
    }

    isEmpty() {
        return this.getContents() === '';
    }

    getContentsLength() {
        return this.getContents().length;
    }

    isLengthOver() {
        return this.getContentsLength() > TWEET_MAX_LENGTH;
    }


}

module.exports = TweetContents;