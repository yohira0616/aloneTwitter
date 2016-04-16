
module.exports = {

    success: function (message) {
        $.notify({
            message: message,
            type: "success"
        })
    },
    error: function (message) {
        $.notify({
            message: message,
            type: "danger"
        })
    },
    warning: function (message) {
        $.notify({
            message: message,
            type: "warning"
        })
    }
};