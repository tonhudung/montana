/**
 * Created by alex on 5/11/15.
 */
(function () {
    'use strict';
    var core = angular.module('app.core');
    core.config(configure);

    configure.$inject = ['$httpProvider', '$stateProvider', '$urlRouterProvider', 'stateHelperConfigProvider'];

    function configure($httpProvider, $stateProvider, $urlRouterProvider, stateHelperConfigProvider) {

        configureRouting();
        configureHttpProvider();

        function configureRouting() {
            var routeCfg = stateHelperConfigProvider;
            routeCfg.config.$stateProvider = $stateProvider;
            routeCfg.config.$urlRouterProvider = $urlRouterProvider;
            routeCfg.config.docTitle = 'CC: ';
        }

        function configureHttpProvider() {
            $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
            $httpProvider.interceptors.push(responseError);
            responseError.$inject = ['$q'];
            function responseError($q) {
                return {
                    'responseError': function (rejection) {
                        var status = rejection.status;
                        if (status == 403) {
                            $stateProvider.go("login");
                        }
                        return $q.reject(rejection);
                    }
                };
            }
        }
    }

})();