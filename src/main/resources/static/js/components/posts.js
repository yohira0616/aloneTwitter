"use strict";
const ajaxSender = require('./../util/ajax-sender');
const post = require('./post');
const config = require('../config/app-config');

module.exports = {
    load: function () {
        ajaxSender.touch(config.server + '/alonetwitter/getTweets', (data)=> {
            const $target = $('#post-content-render-block');
            $.each(data, function () {
                var createdHtml = post.createElement(this);
                $target.append(createdHtml);
            });
        });
    }
};