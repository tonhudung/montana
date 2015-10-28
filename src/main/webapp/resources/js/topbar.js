(function () {
    'use strict';

    angular.module('com.montana.topbar', ['ngResource'])
        .factory('topbarResource', [
            '$resource', function ($resource) {
                return $resource("/api/topbar/");
            }
        ])
        .controller('TopBarController', ['$scope', 'topbarResource', 'authService', function ($scope, topbarResource, authService) {
            $scope.currentUser = authService.getCurrentUser();
            $scope.currentUserFirstName = authService.getCurrentUserFirstName();
        }]);

    angular.module('com.montana').requires.push('com.montana.topbar');
})();