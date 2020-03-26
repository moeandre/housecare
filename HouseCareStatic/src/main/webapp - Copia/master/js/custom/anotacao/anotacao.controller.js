
// To run this code, edit file index.html or index.jade and change
// html data-ng-app attribute from angle to myAppName
// ----------------------------------------------------------------------

(function() {
    'use strict';

    angular
        .module('custom.anotacao')
        .controller('AnotacaoController', AnotacaoController);

    AnotacaoController.$inject = ['$log'];
    function AnotacaoController($log) {
        // for controllerAs syntax
        // var vm = this;

        activate();

        ////////////////

        function activate() {
          $log.log('I\'m a line from anotacao.js');
        }
    }
})();
