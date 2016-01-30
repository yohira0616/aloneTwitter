var $ = require('jquery');
var tweetContents = {

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
    }

};

module.exports = tweetContents;