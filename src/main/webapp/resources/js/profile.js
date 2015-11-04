(function () {
    "use strict";
    angular.module('com.montana.profile', ['ngResource', 'com.montana.friend'])
        .constant('profileSettings', {
            path: 'api/profiles/:userName'
        })
        .factory('profileResource', [
            '$resource', 'appSettings', 'profileSettings', function ($resource, appSettings, profileSettings) {
                return $resource(appSettings.serverPath + profileSettings.path);
            }
        ])
        .controller('ProfileController', [
            '$scope', 'authService', 'profileResource',
            function ($scope, authService, profileResource) {
                $scope.$watch('userName', function () {
                    profileResource.get({userName: $scope.userName}, function (data) {
                        $scope.profile = data;
                    });
                });

                $scope.initVars = function (userName) {
                    $scope.userName = userName;
                };
            }
        ]);

    angular.module('com.montana').requires.push('com.montana.profile');

})();