"use strict";
const $ = require('jquery');

(function ($) {
    const twitterService = require('./service/twitter-service');
    $(()=> {
        twitterService.initialize();

        $('#delete-post').on('click', ()=> {
            twitterService.tweetInputClear();
        });

        $('#execute-post').on('click', ()=> {
            twitterService.save();
        });

        $('body').on('click', 'a.post-delete', function () {
            twitterService.removePost(this);
        });

        $('#tweet-contents').on('keyup', ()=> {
            twitterService.updateCounter();
        });

        $('#app-profile-save-button').on('click', function () {
            twitterService.updateProfile();
        });
    });
})($);

