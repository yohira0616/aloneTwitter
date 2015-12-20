(function ($) {
    "use strict";

    $(function () {

        loadPosts();
        var hostUrl='http://localhost:1243';

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
            AloneTwitter.common.Ajax.send(tweetInsParam, hostUrl+'/alonetwitter/create', function () {
                $('#post-content-render-block').empty();
                loadPosts();
                $.notify('書き込みました！');
            },'html');
        });

        $('body').on('click', 'a.post-delete', function (e) {
            console.log(this);
            var $this = $(this);
            var postId = $this.parents('.panel.panel-default').attr('data-postId');
            console.log(postId);
            AloneTwitter.common.Ajax.send(null, hostUrl+'/alonetwitter/delete/' + postId, function () {
                $this.parents('.panel.panel-default').remove();
                $.notify('削除しました');
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
                $.notify('空欄です');
                return false;
            }
            return true;
        }

        function loadPosts(){
            AloneTwitter.common.Ajax.send(null, hostUrl+'/alonetwitter/getTweets', function (data) {
                var $target = $('#post-content-render-block');
                $.each(data, function () {
                    var makedHtml = makePostElement(this);
                    $target.append(makedHtml);
                });
            });
        }
    });
})(jQuery);