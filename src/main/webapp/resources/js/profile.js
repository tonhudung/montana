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
            '$scope', 'authService', 'profileResource', 'friendRequestService', 'friendService',
            function ($scope, authService, profileResource, friendRequestService, friendService) {
                $scope.$watch('userName', function () {
                    profileResource.get({userName: $scope.userName}, function (data) {
                        $scope.profile = data;
                    });
                });

                $scope.addFriend = function () {
                    friendRequestService
                        .addFriend(authService.getCurrentUser(), $scope.userName)
                        .then(function (data) {
                            $scope.profile.friendship_status = 'FRIEND_REQUEST_SENT';
                        });
                };

                $scope.cancelRequest = function () {
                    friendRequestService.cancelFriendRequest(authService.getCurrentUser(), $scope.userName)
                        .then(function (data) {
                            $scope.profile.friendship_status = 'ADD_FRIEND';
                        });
                };

                $scope.confirmRequest = function () {
                    friendRequestService.confirmFriendRequest($scope.userName, authService.getCurrentUser())
                        .then(function (data) {
                            $scope.profile.friendship_status = "FRIENDS";
                        });
                };

                $scope.ignoreRequest = function () {
                    friendRequestService.ignoreFriendRequest($scope.userName, authService.getCurrentUser())
                        .then(function (data) {
                            $scope.profile.friendship_status = "ADD_FRIEND";
                        });
                };

                $scope.unfriend = function () {
                    friendService.unfriend(authService.getCurrentUser(), $scope.userName)
                        .then(function (data) {
                            $scope.profile.friendship_status = "ADD_FRIEND";
                        });
                }

                $scope.initVars = function (userName) {
                    $scope.userName = userName;
                };
            }
        ]);

    angular.module('com.montana').requires.push('com.montana.profile');

})();