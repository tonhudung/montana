(function () {
    'use strict';
    angular
        .module('app.authentication')
        .config(configure);

    configure.$inject = ['$stateProvider'];

    function configure($stateProvider) {
        $stateProvider.state('root.login', {
            views: {
                'body@': {
                    templateUrl: 'resources/app/authentication/login.html',
                    controller: 'LoginCtrl',
                    controllerAs: 'vm'
                }
            }
        })
    }
})();