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
        .directive('friendButtonAddFriend', function () {
            return {
                replace: true,
                restrict: 'E',
                templateUrl: '/partials/profile/friend-button-add-friend.html'
            }
        })
        .directive('friendButtonRequestSent', function () {
            return {
                replace: true,
                restrict: 'E',
                templateUrl: '/partials/profile/friend-button-request-sent.html'
            }
        })
        .directive('friendButtonResponseToRequest', function () {
            return {
                replace: true,
                restrict: 'E',
                templateUrl: '/partials/profile/friend-button-response-to-request.html'
            }
        })
        .directive('friendButtonFriends', function () {
            return {
                replace: true,
                restrict: 'E',
                templateUrl: '/partials/profile/friend-button-friends.html'
            }
        })
        .controller('ProfileController', [
            '$scope', 'authService', 'profileResource', 'friendResource', function ($scope, authService, profileResource, friendResource) {
                $scope.$watch('userName', function () {
                    profileResource.get({userName: $scope.userName}, function (data) {
                        $scope.profile = data;
                    });
                });

                $scope.addFriend = function () {
                    var friendRequest = new friendResource({friend_user_name: $scope.userName});
                    friendRequest.$save({userName: authService.getCurrentUser()}, function (data) {

                    })
                };

                $scope.initVars = function (userName) {
                    $scope.userName = userName;
                };
            }
        ]);

    angular.module('com.montana').requires.push('com.montana.profile');

})();