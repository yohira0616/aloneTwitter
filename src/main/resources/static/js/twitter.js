"use strict";
const $ = require('jquery');

(function ($) {
    const notify = require('bootstrap-notify');
    const tweetContents = require('./components/tweet-contents');
    const ajaxSender = require('./util/ajax-sender');
    const tweetLengthCounter = require('./components/tweet-length-counter');
    const MSG = require('./config/messages');
    const twitterService = require('./service/twitter-service');
    $(function () {
        const config = require('./config/app-config');
        loadPosts();

        $('#delete-post').on('click', function () {
            twitterService.tweetInputClear();
        });

        $('#execute-post').on('click', function () {
            if (tweetContents.isEmpty()) {
                $.notify({
                    message: MSG["error.empty"],
                    type: 'danger'
                });
                return;
            }
            if (tweetContents.isLengthOver()) {
                $.notify({
                    message: MSG["error.overlength"],
                    type: 'danger'
                });
                return;
            }
            var param = {
                contents: tweetContents.getContents()
            };
            ajaxSender.send(param, config.server + '/alonetwitter/create', function () {
                $('#post-content-render-block').empty();
                loadPosts();
                twitterService.tweetInputClear();
                $.notify(MSG["info.save"]);
            }, 'html');

        });

        $('body').on('click', 'a.post-delete', function () {
            const $this = $(this);
            const postId = $this.parents('.panel.panel-default').attr('data-postId');
            ajaxSender.touch(config.server + '/alonetwitter/delete/' + postId, function() {
                $this.parents('.panel.panel-default').remove();
                $.notify(MSG["info.delete"]);
            }, 'html');
        });

        $('#tweet-contents').on('keyup', function () {
            tweetLengthCounter.updateLength(tweetContents.getContentsLength());
        });

        //TODO XSS Handle
        function makePostElement(data) {
            var html = '';
            html += '<div class="panel panel-default" data-postid="' + data.postId + '">';
            html += '<div class="panel-body">';
            html += '<div class="post-contents">';
            html += data.contents;
            html += '</div>';
            html += '</div>';
            html += '<div class="panel-footer">';
            html += '<span class="post-date">';
            html += data.prcDate;
            html += '</span>';
            html += '<a href="#" class="post-delete"><i class="glyphicon glyphicon-trash pull-right"> </i></a>';
            html += '</div></div>';
            return html;
        }

        function loadPosts() {
            ajaxSender.touch(config.server + '/alonetwitter/getTweets', function (data) {
                const $target = $('#post-content-render-block');
                $.each(data, function () {
                    var createdHtml = makePostElement(this);
                    $target.append(createdHtml);
                });
            });
        }
    });
})($);

