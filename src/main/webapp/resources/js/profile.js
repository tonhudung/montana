(function () {

    "use strict";

    angular.module('profile', ['ngResource', 'friend'])
        .factory('profileResource', [
            '$resource', 'appSettings', function ($resource, appSettings) {
                return $resource(appSettings.serverPath + "api/profiles/:userName");
            }
        ])
        .controller('ProfileController', [
            '$scope', 'profileResource', 'friendResource', function ($scope, profileResource, friendResource) {
                $scope.$watch('userName', function () {
                    profileResource.get({userName: $scope.userName}, function (data) {
                        $scope.profile = data;
                    });
                });

                $scope.initVars = function (userName, loggedInUser) {
                    $scope.userName = userName;
                    $scope.loggedInUser = loggedInUser;
                }

                $scope.addFriend = function () {
                    var friend = new friendResource({friendUserName: $scope.userName});
                    friend.$save({userName: $scope.userName})
                }
            }
        ]);

    angular.module('montana').requires.push('profile');

})();