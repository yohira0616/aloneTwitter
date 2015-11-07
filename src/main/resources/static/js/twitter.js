(function ($) {

    //onload events
    $(function () {
        console.log('load succeeded!');

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8888/alonetwitter/getTweets',
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });

        $('#delete-post').on('click', function () {
            //TODO focus‚ðtextarea‚É–ß‚·
            $('#tweet-contents').val('');
        });

        $('#execute-post').on('click', function () {
            alert('posted!');
        });

        $('body').on('click','a.post-delete',function(){
           alert('deleted!');
        });

        //private functions
        function makePostElement(data) {
            var html='';
            html+='<div class="panel panel-default" data-postid="">';
            html+='<div class="panel-body">';
            html+='<div class="post-contents">'
            html+='</div>';
            html+='<div class="panel-footer">';
            html+='<span class="post-date">';
            html+='</span>';
            html+='<a href="#" class="post-delete"><i class="glyphicon glyphicon-trash pull-right"> </i></a>';
            html+='</div></div>';
            return html;
        }

    });

})(jQuery);