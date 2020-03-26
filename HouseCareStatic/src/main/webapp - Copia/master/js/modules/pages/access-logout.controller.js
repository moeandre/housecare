/**
 * ========================================================= Module:
 * access-login.js Demo for login api
 * =========================================================
 */

(function() {
	'use strict';

	angular.module('app.pages').controller('LogoutController',
			LogoutController);

	LogoutController.$inject = ['$state', '$localStorage'];
	function LogoutController($state, $localStorage) {
		var vm = this;

		activate();

		// //////////////

		function activate() {

			$localStorage.user = {};
			$state.go('login', {}, {reload: true});

		}
	}
})();
