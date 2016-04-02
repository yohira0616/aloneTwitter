"use strict";
const TweetLengthCounter = {
    updateLength: function (length) {
        const $dom = $('#tweet-length-counter');
        $dom.html(length);
        length > 140 ? $dom.addClass('text-input-over') : $dom.removeClass('text-input-over');
    }

};

module.exports = TweetLengthCounter;