(function () {
    "use strict";
    angular.module('com.montana.profile', ['ngResource', 'com.montana.friendrequest'])
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
            '$scope', 'authService', 'profileResource', 'friendRequestResource', function ($scope, authService, profileResource, friendRequestResource) {
                $scope.$watch('userName', function () {
                    profileResource.get({userName: $scope.userName}, function (data) {
                        $scope.profile = data;
                    });
                });

                $scope.addFriend = function () {
                    var friendRequest = new friendRequestResource({
                        sender: authService.getCurrentUser(),
                        recipient: $scope.userName
                    });
                    friendRequest.$save(function (data) {
                        $scope.profile.friendship_status = 'FRIEND_REQUEST_SENT';
                        $scope.profile.friend_request_id = data.id;
                    })
                };

                $scope.cancelRequest = function () {
                    friendRequestResource.delete({id: $scope.profile.friend_request_id}, function(data){
                        $scope.profile.friendship_status = "ADD_FRIEND";
                    });
                };

                $scope.confirmRequest = function(){

                }

                $scope.initVars = function (userName) {
                    $scope.userName = userName;
                };
            }
        ]);

    angular.module('com.montana').requires.push('com.montana.profile');

})();