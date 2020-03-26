
// To run this code, edit file index.html or index.jade and change
// html data-ng-app attribute from angle to myAppName
// ----------------------------------------------------------------------

(function() {
    'use strict';

    angular
        .module('custom.farmacia')
        .controller('FarmaciaController', FarmaciaController);

    FarmaciaController.$inject = ['$log'];
    function FarmaciaController($log) {
        // for controllerAs syntax
        // var vm = this;

        activate();

        ////////////////

        function activate() {
          $log.log('I\'m a line from farmacia.js');
        }
    }
})();
