(function () {
    'use strict';
    angular
        .module('app.home')
        .run(stateConfig);
    stateConfig.$inject = ['stateHelper'];
    /* @ngInject */
    function stateConfig(stateHelper) {
        stateHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                name: '/',
                config: {
                    templateUrl: 'app/home/home.html',
                    title: 'dashboard'
                }
            }
        ];
    }
})();