(function () {
    'use strict';

    angular.module('topbar', ['ngResource'])
        .factory('topbarResource', [
            '$resource', function ($resource) {
                return $resource("/api/topbar/");
            }
        ])
        .controller('TopBarController', ['$scope', 'topbarResource', 'authService', function ($scope, topbarResource, authService) {
            $scope.currentUser = authService.getCurrentUser();
            $scope.currentUserFirstName = authService.getCurrentUserFirstName();
        }]);

    angular.module('montana').requires.push('topbar');
})();