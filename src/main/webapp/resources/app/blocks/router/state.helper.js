(function () {
    'use strict';

    angular.module('app.blocks.state')
        .provider('stateHelperConfig', stateHelperConfig)
        .factory('stateHelper', stateHelper);

    // Must configure via the routeHelperConfigProvider
    function stateHelperConfig() {
        /* jshint validthis:true */
        this.config = {
            // These are the properties we need to set
            // $routeProvider: undefined
            // docTitle: ''
            // resolveAlways: {ready: function(){ } }
        };

        this.$get = function () {
            return {
                config: this.config
            };
        };
    }

    stateHelper.$inject = ['stateHelperConfig'];

    function stateHelper(stateHelperConfig) {
        var $stateProvider = stateHelperConfig.config.$stateProvider;
        var $urlRouterProvider = stateHelperConfig.config.$urlRouterProvider;

        return {
            configureStates: configureStates
        };
        ///////////////

        function configureStates(states) {
            states.forEach(function (state) {
                //state.config.resolve = angular.extend(state.config.resolve || {}, stateHelperConfig.config.resolveAlways);
                $stateProvider.state(state.name, state.config);
            });
            $urlRouterProvider.otherwise('/');
        }
    }
})();