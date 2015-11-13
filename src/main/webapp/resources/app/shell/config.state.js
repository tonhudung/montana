/**
 * Created by Alex To on 11/13/2015.
 */
(function () {
    'use strict';
    angular.module('app.shell')
        .config(configure);

    configure.$inject = ['stateHelperProvider', $urlRouterProvider];
    function configure(stateHelperProvider) {
        stateHelperProvider.state(
            'root', {
                views: {
                    'header': {
                        templateUrl: '/resources/app/navbar/navbar.html',
                        controller: 'NavBarCtrl',
                        controllerAs: 'vm'
                    },
                    'body':{
                        templateUrl: '/resources/app/shell/body.html'
                    },
                    'footer':{
                        templateUrl: 'resources/app/shell/footer.html'
                    }
                }
            }
        );

        $urlRouterProvider.otherwise('/');
    }

})();