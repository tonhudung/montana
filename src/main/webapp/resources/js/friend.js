/**
 * Created by alexto on 26/10/15.
 */
(function () {
    "use strict";
    angular.module('com.montana.friendrequest', ['ngResource'])
        .constant('friendRequestSettings', {
            path: 'api/friendrequests/'
        })
        .factory('friendRequestResource', [
            '$resource', 'appSettings', 'friendRequestSettings', function ($resource, appSettings, friendRequestSettings) {
                return $resource(appSettings.serverPath + friendRequestSettings.path);
            }
        ]);

    angular.module('com.montana').requires.push('com.montana.friendrequest');
})();
