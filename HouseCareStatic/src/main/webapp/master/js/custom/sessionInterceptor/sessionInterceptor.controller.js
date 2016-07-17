
// To run this code, edit file index.html or index.jade and change
// html data-ng-app attribute from angle to myAppName
// ----------------------------------------------------------------------

(function() {
    'use strict';

    angular
    	.module('custom.sessionInterceptor')
    	.factory('SessionInterceptor', SessionInterceptor);

    SessionInterceptor.$inject = ['$rootScope','$cookieStore','$location','$q'];
    function SessionInterceptor($rootScope, $cookieStore, $location, $q) { 
		return {
			'request': function(request) {

				// if we're not logged-in to the AngularJS app, redirect to login page
				$rootScope.loggedIn = ($cookieStore.get('loggedIn') == true);

				if (!$rootScope.loggedIn && $location.path() != '/login') {
					$location.path('/login');
				}
				

				return request;

			},
			'responseError': function(rejection) {
				// if we're not logged-in to the web service, redirect to login page
				// rejection.status === 401 && 
				if ($location.path() != '/login') {
					$rootScope.loggedIn = false;
					$cookieStore.remove('loggedIn');
					$location.path('/login');
				}
				return $q.reject(rejection);
			}
		};
	}
    
    
})();