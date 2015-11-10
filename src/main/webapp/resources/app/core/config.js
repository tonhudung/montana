/**
 * Created by alex on 5/11/15.
 */
(function () {
    'use strict';
    var core = angular.module('app.core');
    core.config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider', 'stateHelperConfig'];

    function configure($stateProvider, $urlRouterProvider, stateHelperConfig) {

        configureRouting();

        function configureRouting() {
            var routeCfg = stateHelperConfig;
            routeCfg.config.$stateProvider = $stateProvider;
            routeCfg.config.$urlRouterProvider = $urlRouterProvider;
            routeCfg.config.docTitle = 'CC: ';
        }
    }

})();