(function () {
    'use strict';
    angular
        .module('app.authentication')
        .config(configure);

    configure.$inject = ['stateHelperProvider'];

    function configure(stateHelperProvider) {
        stateHelperProvider.state('root.login', {
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