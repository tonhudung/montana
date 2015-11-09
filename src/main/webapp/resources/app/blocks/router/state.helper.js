(function () {
    'use strict';

    angular.module('blocks.state')
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

    stateHelper.$inject = [
        '$location', '$rootScope', '$state',
        'logger', 'stateHelperConfig'
    ];

    function stateHelper($state, stateHelperConfig) {
        var states = [];
        var $stateProvider = stateHelperConfig.config.$stateProvider;
        var $urlRouterProvider = stateHelperConfig.config.$urlRouterProvider;

        return {
            configureStates: configureStates,
            getStates: getStates
        };
        ///////////////

        function configureStates(states) {
            states.forEach(function (state) {
                state.config.resolve =
                    angular.extend(state.config.resolve || {}, stateHelperConfig.config.resolveAlways);
                $stateProvider.state(state.name, state.config);
            });
            $urlRouterProvider.otherwise('/');
        }

        function getStates() {
            for (var prop in $state.states) {
                if ($state.states.hasOwnProperty(prop)) {
                    var state = $state.states[prop];
                    var isState = !!state.title;
                    if (isState) {
                        states.push(state);
                    }
                }
            }
            return states;
        }
    }
})();