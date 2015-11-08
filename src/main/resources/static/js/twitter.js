(function ($) {
    "use strict";

    $(function () {

        AloneTwitter.common.Ajax.send(null, 'http://localhost:8888/alonetwitter/getTweets', function (data) {
            var $target = $('#post-content-render-block');
            $.each(data, function () {
                var makedHtml = makePostElement(this);
                $target.append(makedHtml);
            });
        });

        $('#delete-post').on('click', function () {
            $('#tweet-contents').val('');
        });

        $('#execute-post').on('click', function () {
            if (!validate()) {
                return;
            }
            var content = $('#tweet-contents').val();
            var tweetInsParam = {
                contents: content
            };
            AloneTwitter.common.Ajax.send(tweetInsParam, 'http://localhost:8888/alonetwitter/create', function () {
                alert('書き込みました！');
            });
        });

        $('body').on('click', 'a.post-delete', function (e) {
            var $this = $(e.toElement);
            var $parentPanel = $this.parents('.panel.panel-default');
            var postId = $parentPanel.attr('data-itemId');
            console.log(postId);
            AloneTwitter.common.Ajax.send(null, 'http://localhost:8888/alonetwitter/delete/' + postId, function () {
                alert('削除しました');
            }, 'html');
        });

        //private functions
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
                alert('空欄です');
                return false;
            }
            return true;
        }

        //TODO common化
        function commonJsonSend(obj, url, successFunc, dataType) {
            $.ajax({
                type: 'POST',
                url: url,
                data: JSON.stringify(obj),
                contentType: 'application/JSON',
                dataType: dataType || 'JSON',
                success: successFunc,
                error: function (xhr, status, error) {
                    console.log(status);
                    console.log(error);
                }
            })
        }
    });
})(jQuery);