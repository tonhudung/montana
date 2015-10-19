(function () {

    "use strict";

    angular.module('profile', ['ngResource'])
        .factory('profileResource', [
            '$resource', 'appSettings', function ($resource, appSettings) {
                return $resource(appSettings.serverPath + "api/profiles/:id");
            }
        ])
        .controller('ProfileController', [
            '$scope', 'profileResource', function ($scope, profileResource) {
                $scope.$watch('userName', function () {
                    profileResource.get({id: $scope.userName}, function (data) {
                        $scope.profile = data;
                    });
                });

                $scope.setUserName = function (userName) {
                    $scope.userName = userName;
                }
            }
        ]);

    angular.module('montana').requires.push('profile');

})();