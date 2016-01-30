var $ = require('jquery');
var TweetLengthCounter = {
    updateLength: function (length) {
        var $dom = $('#tweet-length-counter');
        $dom.html(length);
        length > 140 ? $dom.addClass('text-input-over') : $dom.removeClass('text-input-over');
    }

};

module.exports = TweetLengthCounter;