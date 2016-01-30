//require('./package');
//require('./common/Ajax');

(function ($) {
    "use strict";

    $(function () {

        var hostUrl = 'http://localhost:1243';
        loadPosts();


        $('#delete-post').on('click', function () {
            tweetInputClear();
        });

        $('#execute-post').on('click', function () {
            if (!validate()) {
                return;
            }
            var content = $('#tweet-contents').val();
            var tweetInsParam = {
                contents: content
            };
           sendUtil(tweetInsParam, hostUrl + '/alonetwitter/create', function () {
                $('#post-content-render-block').empty();
                loadPosts();
                $.notify('書き込みました！');
            }, 'html');
        });

        $('body').on('click', 'a.post-delete', function (e) {
            var $this = $(this);
            var postId = $this.parents('.panel.panel-default').attr('data-postId');
            sendUtil(null, hostUrl + '/alonetwitter/delete/' + postId, function () {
                $this.parents('.panel.panel-default').remove();
                $.notify('削除しました');
            }, 'html');
        });

        $('#tweet-contents').on('keyup', function () {
            var textLength = $('#tweet-contents').val().length;
            if (textLength > 160) {
                $('#tweet-length-counter').html(textLength).addClass('text-input-over');
            } else {
                $('#tweet-length-counter').html(textLength).removeClass('text-input-over');
            }
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

        function validate() {
            if ($('#tweet-contents').val() === '') {
                $.notify('書き込みが入力されていません');
                return false;
            }
            return true;
        }

        function loadPosts() {
            sendUtil(null, hostUrl + '/alonetwitter/getTweets', function (data) {
                var $target = $('#post-content-render-block');
                $.each(data, function () {
                    var makedHtml = makePostElement(this);
                    $target.append(makedHtml);
                });
            });
        }

        function tweetInputClear() {
            $('#tweet-contents').val('');
            $('#tweet-length-counter').html('0').removeClass('text-input-over');
        }

        function sendUtil(obj, url, callbackFunc, dataType){
            $.ajax({
                type: 'POST',
                url: url,
                data: JSON.stringify(obj),
                contentType: 'application/JSON',
                dataType: dataType || 'JSON',
                success: callbackFunc,
                error: function (xhr, status, error) {
                    console.log(status);
                    console.log(error);
                }
            });
        }

    });
})(jQuery);