/**
 * Created by alexto on 26/10/15.
 */
(function () {

    "use strict";
    angular.module('auth')
        .factory('authService', [function () {

            return {
                currentUser: function currentUser()
                {

                }
            }
        }]);

    angular.module('montana').requires.push('auth');
});