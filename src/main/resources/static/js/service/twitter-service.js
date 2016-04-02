"use strict";
const $ = require('jquery');
const tweetContents = require('../components/tweet-contents');
const tweetLengthCounter = require('../components/tweet-length-counter');
const posts = require('./../components/posts');
const ajaxSender = require('./../util/ajax-sender');
const notify = require('../util/notify-helper');
const messages = require('./../config/messages');
const config = require('./../config/app-config');

function _tweetInputClear() {
    tweetContents.emptyContents();
    tweetLengthCounter.updateLength(0);
}

const TwitterService = {
    initialize: function () {
        $('#app-self-introduction').editable();
        posts.load();
    },
    tweetInputClear: function () {
        _tweetInputClear();
    },
    loadPosts: function () {
        posts.load();
    },
    save: function () {
        if (tweetContents.isEmpty()) {
            notify.error(messages["error.empty"]);
            return;
        }
        if (tweetContents.isLengthOver()) {
            notify.error(messages["error.overlength"]);
            return;
        }
        ajaxSender.send({contents: tweetContents.getContents()}, config.server + '/alonetwitter/create', function () {
            $('#post-content-render-block').empty();
            posts.load();
            _tweetInputClear();
            notify.success(messages["info.save"]);
        }, 'html');
    },
    removePost: function ($this) {
        const postId = $this.parents('.panel.panel-default').attr('data-postId');
        ajaxSender.touch(config.server + '/alonetwitter/delete/' + postId, function () {
            $this.parents('.panel.panel-default').remove();
            $.notify(messages["info.delete"]);
        }, 'html');
    },
    updateCounter: function () {
        tweetLengthCounter.updateLength(tweetContents.getContentsLength());
    },
    updateProfile: function () {
        notify.success("保存しました");
    }
};
module.exports = TwitterService;