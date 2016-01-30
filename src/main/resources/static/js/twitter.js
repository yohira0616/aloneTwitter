var $ = require('jquery');
var notify = require('bootstrap-notify');
var tweetContents = require('./components/tweet-contents');
var ajaxSender = require('./util/ajax-sender');
var tweetLengthCounter = require('./components/tweet-length-counter');

$(function () {

    var hostUrl = 'http://localhost:1243';
    loadPosts();


    $('#delete-post').on('click', function () {
        tweetInputClear();
    });

    $('#execute-post').on('click', function () {
        if (tweetContents.isEmpty()) {
            $.notify({
                message: '書き込みが入力されていません',
                type: 'danger'
            });
            return;
        }
        if (tweetContents.isLengthOver()) {
            $.notify({
                message: '書き込み上限文字数を超えています',
                type: 'danger'
            });
            return;
        }
        var tweetInsParam = {
            contents: tweetContents.getContents()
        };
        ajaxSender.send(tweetInsParam, hostUrl + '/alonetwitter/create', function () {
            $('#post-content-render-block').empty();
            loadPosts();
            tweetInputClear();
            $.notify('書き込みました！');
        }, 'html');
    });

    $('body').on('click', 'a.post-delete', function () {
        var $this = $(this);
        var postId = $this.parents('.panel.panel-default').attr('data-postId');
        ajaxSender.touch(hostUrl + '/alonetwitter/delete/' + postId, function () {
            $this.parents('.panel.panel-default').remove();
            $.notify('削除しました');
        }, 'html');
    });

    $('#tweet-contents').on('keyup', function () {
        var textLength = tweetContents.getContentsLength();
        tweetLengthCounter.updateLength(textLength);
    });

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
        ajaxSender.touch(hostUrl + '/alonetwitter/getTweets', function (data) {
            var $target = $('#post-content-render-block');
            $.each(data, function () {
                var createdHtml = makePostElement(this);
                $target.append(createdHtml);
            });
        });
    }

    function tweetInputClear() {
        tweetContents.emptyContents();
        tweetLengthCounter.updateLength(0);
    }

});