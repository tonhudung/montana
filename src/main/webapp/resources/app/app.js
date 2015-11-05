// Write your Javascript code.
(function () {
    "use strict";

    angular.module('com.montana')
        .constant('appSettings', {
            serverPath: 'http://localhost:8080/'
        })
        .config(['$resourceProvider', function($resourceProvider){
            $resourceProvider.defaults.stripTrailingSlashes = false;
        }])
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
