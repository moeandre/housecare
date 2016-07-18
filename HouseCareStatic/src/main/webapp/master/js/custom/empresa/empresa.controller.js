
// To run this code, edit file index.html or index.jade and change
// html data-ng-app attribute from angle to myAppName
// ----------------------------------------------------------------------

(function() {
    'use strict';

    angular
        .module('custom.empresa')
        .controller('EmpresaController', EmpresaController);

    EmpresaController.$inject = ['$log'];
    function EmpresaController($log) {
    	
    	var vm = this;
    	
        // for controllerAs syntax
        // var vm = this;

        activate();

        ////////////////

        function activate() {
          
          $log.log('I\'m a line from empresa.js');
          
          vm.pesquisar = function(){};
          
          vm.editar = function(){};
          
          vm.salvar = function(){};
          
        }

    }
})();
