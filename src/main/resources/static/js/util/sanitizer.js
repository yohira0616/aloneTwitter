module.exports = {

    sanitize: function (text) {
        return $('<div />').text(text).html();
    }
};