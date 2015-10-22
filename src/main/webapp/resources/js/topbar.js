(function () {
    'use strict';

    angular.module('topbar', ['ngResource'])
        .factory('topbarResource', [
            '$resource', function ($resource) {
                return $resource("/api/topbar/");
            }
        ])
        .controller('TopBarController', ['$scope', 'topbarResource', function ($scope, topbarResource) {
            /*topbarResource.get(function (data) {
                $scope.profile = data;
            });*/
        }]);

    angular.module('montana').requires.push('topbar');
})();