/**
 * Created by alexto on 26/10/15.
 */
(function () {
    "use strict";
    angular.module('com.montana.post', ['ngResource', 'monospaced.elastic', 'com.montana.embed'])
        .constant('postSettings', {
            path: 'api/profiles/:userName/posts/:id'
        })
        .factory('postResource', [
            '$resource', 'appSettings', 'postSettings', function ($resource, appSettings, postSettings) {
                return $resource(appSettings.serverPath + postSettings.path);
            }
        ])
        .factory('postService', ['postResource', function (postResource) {
            return {
                addPost: function (data, to) {
                    var post = new postResource(data);
                    return post.$save({userName: to});
                }
            }
        }])
        .controller('PostController', ['$sce', '$scope', 'embedService', 'postService', function ($sce, $scope, embedService, postService) {
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
                    embedService.get(links[0].value)
                        .then(function (data) {
                            $scope.embed = data;
                            $scope.html = $sce.trustAsHtml($scope.embed.html);
                        });
                }
            };

            $scope.initVars = function (userName) {
                $scope.userName = userName;
            };

            $scope.$watch('userName', function () {
            });

            $scope.addPost = function () {
                var post = $scope.embed;
                post.message = $scope.message;
                postService.addPost(post, $scope.userName)
                    .then(function (data) {

                    });
            };
        }])
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
        });

    angular.module('com.montana').requires.push('com.montana.post');

})();