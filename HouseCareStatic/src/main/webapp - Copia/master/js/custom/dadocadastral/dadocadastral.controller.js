
// To run this code, edit file index.html or index.jade and change
// html data-ng-app attribute from angle to myAppName
// ----------------------------------------------------------------------

(function() {
    'use strict';

    angular
        .module('cliente.dadocadastral')
        .controller('DadoCadastralController', DadoCadastralController);

    DadoCadastralController.$inject = ['$log'];
    function DadoCadastralController($log) {
        // for controllerAs syntax
        // var vm = this;

        activate();

        ////////////////

        function activate() {
          $log.log('I\'m a line from dadocadastral.js');
        }
    }
})();
