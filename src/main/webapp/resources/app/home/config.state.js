/**
 * Created by alex on 15/11/15.
 */
(function () {
    'use strict';
    angular.module('app.home')
        .config(configure);

    configure.$inject = ['$stateProvider'];

    function configure($stateProvider) {
        $stateProvider.state(
            'root', {
                url: '/',
                views: {
                    'header': {
                        templateUrl: '/resources/app/navbar/navbar.html',
                        controller: 'NavBarController'
                    },
                    'body':{
                        templateUrl: '/resources/app/home/home.html',
                        controller: 'HomeController'
                    },
                    'footer':{
                        templateUrl: '/resources/app/shell/footer.html'
                    }

                }
            }
        )
    }
})();