(function () {
    "use strict";
    angular.module('com.montana.embed', ['ngResource'])
        .constant('embedSettings', {
            serverPath: 'http://api.embed.ly/1/oembed',
            key: '66c4affe32874bab971882b61ed4c4d4',
            maxwidth: '583px'
        })
        .factory('embedResource', [
            '$resource', 'embedSettings', function ($resource, embedSettings) {
                return $resource(embedSettings.serverPath);
            }
        ])
        .factory('embedService', ['embedResource', 'embedSettings', function (embedResource, embedSettings) {
            return {
                get: function (url) {
                    return embedResource.get({
                        key: embedSettings.key,
                        url: url,
                        maxwidth: embedSettings.maxwidth
                    }).$promise;
                }
            }
        }]);

    angular.module('com.montana').requires.push('com.montana.embed');

})();