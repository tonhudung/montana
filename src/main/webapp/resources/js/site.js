// Write your Javascript code.
(function () {
    "use strict";

    angular.module('montana', ['ngCookies'])
        .constant('appSettings', {
            serverPath: 'http://localhost:8080/'
        })
        .factory('authService', ['$cookies', function ($cookies) {
            return {
                getCurrentUser: function () {
                    return $cookies.get('currentUser');
                },
                getCurrentUserFirstName: function () {
                    return $cookies.get('currentUserFirstName');
                }
            }
        }]);
})();
