/**
 * Created by alexto on 26/10/15.
 */
(function () {
    "use strict";
    angular.module('com.montana.wall', ['ngResource', 'monospaced.elastic', 'com.montana.embed'])
        .constant('postSettings', {
            path: 'api/profiles/:userName/posts/:id'
        })
        .factory('postResource', [
            '$resource', 'appSettings', 'postSettings', function ($resource, appSettings, postSettings) {
                return $resource(appSettings.serverPath + postSettings.path);
            }
        ])
        .directive('createLinkPost', function () {
            return {
                replace: true,
                restrict: 'E',
                templateUrl: '/partials/post/create-link-post.html'
            };
        })
        .directive('createPhotoPost', function () {
            return {
                replace: true,
                restrict: 'E',
                templateUrl: '/partials/post/create-photo-post.html'
            };
        })
        .directive('createVideoPost', function () {
            return {
                replace: true,
                restrict: 'E',
                templateUrl: '/partials/post/create-video-post.html'
            };
        })
        .controller('WallController', ['$sce', '$scope', 'embedResource', 'postResource', 'embedSettings', function ($sce, $scope, embedResource, postResource, embedSettings) {
            $scope.linkDetected = false;
            $scope.postInputOnPaste = function (e) {
                if ($scope.linkDetected)
                    return;

                var pastedText = undefined;
                if (window.clipboardData && window.clipboardData.getData) { // IE
                    pastedText = window.clipboardData.getData('Text');
                } else if (e.clipboardData && e.clipboardData.getData) {
                    pastedText = e.clipboardData.getData('text/plain');
                }

                var links = linkify.find(pastedText, 'url');
                if (links.length > 0) {
                    $scope.linkDetected = true;
                    embedResource.get({
                        key: embedSettings.key,
                        url: links[0].value,
                        maxwidth: embedSettings.maxwidth
                    }, function (data) {
                        $scope.embed = data;
                        $scope.html = $sce.trustAsHtml($scope.embed.html);
                    });
                }
            };

            $scope.initVars = function (userName) {
                $scope.userName = userName;
            };

            $scope.$watch('userName', function () {
                postResource.query({userName: $scope.userName}, function (data) {
                    $scope.posts = data;
                });
            });

            $scope.addPost = function () {
                var post = new postResource($scope.embed);
                post.message = $scope.message;
                post.$save({userName: $scope.userName},
                    function (data) {

                    });
            };
        }]);

    angular.module('com.montana').requires.push('com.montana.wall');

})();