(function () {

    "use strict";

    angular.module('profile', ['ngResource', 'friend'])
        .constant('profileSettings', {
            path: 'api/profiles/:userName'
        })
        .factory('profileResource', [
            '$resource', 'appSettings', 'profileSettings', function ($resource, appSettings, profileSettings) {
                return $resource(appSettings.serverPath + profileSettings.path);
            }
        ])
        .controller('ProfileController', [
            '$scope', 'authService', 'profileResource', 'friendResource', function ($scope, authService, profileResource, friendResource) {
                $scope.$watch('userName', function () {
                    profileResource.get({userName: $scope.userName}, function (data) {
                        $scope.profile = data;
                    });
                });

                $scope.addFriend = function () {
                    var friendRequest = new friendResource({friendUserName: $scope.userName});
                    friendRequest.$save({userName: authService.getCurrentUser()}, function(data)
                    {

                    })
                };

                $scope.initVars = function (userName) {
                    $scope.userName = userName;
                };
            }
        ]);

    angular.module('montana').requires.push('profile');

})();