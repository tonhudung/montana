/**
 * Created by alexto on 26/10/15.
 */
(function () {
    "use strict";
    angular.module('com.montana.friend', ['ngResource'])
        .constant('friendResourceSettings', {
            friendRequestPath: 'api/:userA/friendrequests/:userB',
            friendPath: 'api/:userA/friends/:userB'
        })
        .factory('friendResource', [
            '$resource', 'appSettings', 'friendResourceSettings', function ($resource, appSettings, friendResourceSettings) {
                return $resource(appSettings.serverPath + friendResourceSettings.friendPath);
            }
        ])
        .factory('friendRequestResource', [
            '$resource', 'appSettings', 'friendResourceSettings', function ($resource, appSettings, friendResourceSettings) {
                return $resource(appSettings.serverPath + friendResourceSettings.friendRequestPath, null, {
                    'update': {method: 'PUT'}
                });
            }
        ])
        .factory('friendRequestService', ['friendRequestResource', function (friendRequestResource) {
            return {
                addFriend: function (sender, recipient) {
                    var friendRequest = new friendRequestResource({
                        recipient: recipient
                    });
                    return friendRequest.$save({userA: sender});
                },
                cancelFriendRequest: function (sender, recipient) {
                    return friendRequestResource.delete(
                        {
                            userA: sender,
                            userB: recipient
                        }).$promise;
                },
                confirmFriendRequest: function (sender, recipient) {
                    return friendRequestResource.update(
                        {userA: recipient},
                        {
                            user: sender,
                            friend_request_status: 'ACCEPTED'
                        }).$promise;
                },
                ignoreFriendRequest: function (sender, recipient) {
                    return friendRequestResource.update(
                        {userA: recipient},
                        {
                            user: sender,
                            friend_request_status: 'IGNORED'
                        }).$promise;
                }
            }
        }])
        .factory('friendService', ['friendResource', function (friendResource) {
            return {
                unfriend: function (userA, userB) {
                    return friendResource.delete(
                        {
                            userA: userA,
                            userB: userB
                        }).$promise;
                }
            }
        }])
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
        });

    angular.module('com.montana').requires.push('com.montana.friend');
})();
