/**
 * Created by yukito ohira on 2015/11/08.
 */
var AloneTwitter = AloneTwitter;

(function ($) {
    AloneTwitter.common.Ajax = {};

    AloneTwitter.common.Ajax.send = function (obj, url, callbackFunc, dataType) {
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
        })
    }

})(jQuery);