(function () {
    'use strict';
    angular
        .module('app.authentication')
        .run(stateConfig);
    stateConfig.$inject = ['stateHelper'];
    /* @ngInject */
    function stateConfig(stateHelper) {
        stateHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                name: 'login',
                config: {
                    url: '/login',
                    templateUrl: 'app/authentication/login.html',
                    title: 'login'
                }
            }
        ];
    }
})();