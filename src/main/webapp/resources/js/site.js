// Write your Javascript code.
(function () {
    "use strict";

    angular.module('montana', [])
        .constant('appSettings', {
            serverPath: 'http://localhost:8080/'
        })
        .controller('NewsFeedController', [
        '$scope', function ($scope) {
            var posts = [
                {
                    from: 'Surin Chang',
                    profilePic: 'https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xfa1/v/t1.0-1/p50x50/11201808_10207046552266644_248581875703035798_n.jpg?oh=66c6123250cab4f4513a156d64e43fbf&oe=56A7D72E&__gda__=1452692136_1c403a2a78e9d31418df02b9a445b217',
                    picture: 'http://www.mudah.org/wp-content/uploads/2012/12/starbucks-buy-1-free-1-promotion.jpg',
                    message: 'Spotted this promotion by Starbucks. Who wanna share with me?',
                    created: '15 August at 09:45'
                }
            ];
            $scope.posts = posts;
        }
    ]);
})();
