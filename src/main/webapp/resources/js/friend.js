/**
 * Created by alexto on 26/10/15.
 */
(function () {
    "use strict";
    angular.module('friend', ['ngResource'])
        .factory('friendResource', [
            '$resource', 'appSettings', function ($resource, appSettings) {
                return $resource(appSettings.serverPath + "api/profiles/:userName/friends/:friendUserName");
            }
        ]);

    angular.module('montana').requires.push('friend');
});
