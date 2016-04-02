"use strict";
const sanitizer = require('./../util/sanitizer');

const post = {

    createElement(postData){
        var html = '';
        html += '<div class="panel panel-default" data-postid="' + postData.postId + '">';
        html += '<div class="panel-body">';
        html += '<div class="post-contents">';
        html += sanitizer.sanitize(postData.contents);
        html += '</div>';
        html += '</div>';
        html += '<div class="panel-footer">';
        html += '<span class="post-date">';
        html += postData.prcDate;
        html += '</span>';
        html += '<a href="#" class="post-delete"><i class="glyphicon glyphicon-trash pull-right"> </i></a>';
        html += '</div></div>';
        return html;
    }
};

module.exports = post;