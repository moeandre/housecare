// To run this code, edit file index.html or index.jade and change
// html data-ng-app attribute from angle to myAppName
// ----------------------------------------------------------------------

(function() {
	'use strict';

	angular.module('configuracao.empresa').controller('EmpresaController',
			EmpresaController);

	EmpresaController.$inject = [ '$log', '$state','$stateParams', '$localStorage', '$http' ];

	function EmpresaController($log, $state, $stateParams, $localStorage, $http) {

		var vm = this;

		vm.empresas = [];
		activate();

		// //////////////

		function activate() {

			$http.get('/api/rest/empresa/listar', {
				headers : {
					'user-token' : $localStorage.user.sessao.uuid
				}
			}).then(function(response) {
				if (response.data.results) {
					vm.empresas = response.data.results;
					$log.log(vm.empresas);
				}
			}, function() {
				vm.authMsg = 'Server Request Error';
			});
			
			$stateParams.portfolioId

			vm.pesquisar = function() {};

			vm.editar = function(id){
				
			};
			
			vm.deletar = function(id){};
			
			vm.salvar = function(){};

		}

	}
})();
