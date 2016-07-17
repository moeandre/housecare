
// To run this code, edit file index.html or index.jade and change
// html data-ng-app attribute from angle to myAppName
// ----------------------------------------------------------------------

(function() {
    'use strict';

    angular
    	.module('custom.sessionInterceptor')
    	.factory('SessionInterceptor', SessionInterceptor);

    SessionInterceptor.$inject = ['$rootScope','$location','$q','$localStorage'];
    function SessionInterceptor($rootScope, $location, $q, $localStorage) { 
		return {
			'request': function(request) {

				// if we're not logged-in to the AngularJS app, redirect to login page
				$rootScope.loggedIn = ($localStorage.account != null);

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
					$location.path('/login');
				}
				return $q.reject(rejection);
			}
		};
	}
    
    
})();