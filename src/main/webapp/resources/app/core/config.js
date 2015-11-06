/**
 * Created by alex on 5/11/15.
 */

(function () {
    var core = angular.module('app.core');

    core.config(configure);

    configure.$inject = ['$stateProvider']

    function configure($stateProvider) {
        $stateProvider
            .state(home)
            .state(profile);

        var home = {
            name: 'home'
        };

        var profile = {
            name: 'profile'
        };
    }


})();