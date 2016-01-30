/**
 * Created by yukito ohira on 2016/01/30.
 */
var $ = require('jquery');
var ajaxSender = {
    send: function (obj, url, callbackFunc, dataType) {
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
    },
    touch: function (url, callbackFunc, dataType) {
        this.send(null, url, callbackFunc, dataType);
    }
};
module.exports = ajaxSender;