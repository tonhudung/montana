/**
 * Created by alexto on 26/10/15.
 */
(function () {
    "use strict";
    angular.module('friend', ['ngResource'])
        .constant('friendSettings', {
            path: 'api/profiles/:userName/friends/:friendUserName'
        })
        .factory('friendResource', [
            '$resource', 'appSettings', 'friendSettings', function ($resource, appSettings, friendSettings) {
                return $resource(appSettings.serverPath + friendSettings.path);
            }
        ]);

    angular.module('montana').requires.push('friend');
})();
