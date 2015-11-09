/**
 * Created by alex on 5/11/15.
 */

(function () {
    'use strict';
    var core = angular.module('app.core');
    core.config(configure);

    configure.$inject = ['$stateProvider', '$urlRouteProvider', 'routeHelperConfigProvider', ];

    function configure($stateProvider, $urlRouterProvider, routeHelperConfigProvider) {

        configureRouting();

        function configureRouting() {
            var routeCfg = routeHelperConfigProvider;
            routeCfg.config.$stateProvider = $stateProvider;
            routeCfg.config.$urlRouterProvider = $urlRouterProvider;
            routeCfg.config.docTitle = 'CC: ';
            routeCfg.config.resolveAlways = { /* @ngInject */
                ready: function(datacontext) {
                    return datacontext.ready();
                }
//                ready: ['datacontext', function (datacontext) {
//                    return datacontext.ready();
//                }]
            };
        }
    }

})();