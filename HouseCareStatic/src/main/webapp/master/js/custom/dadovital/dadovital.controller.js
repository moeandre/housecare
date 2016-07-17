
// To run this code, edit file index.html or index.jade and change
// html data-ng-app attribute from angle to myAppName
// ----------------------------------------------------------------------

(function() {
    'use strict';

    angular
        .module('custom.dadovital')
        .controller('DadoVitalController', DadoVitalController);

    DadoVitalController.$inject = ['$log'];
    function DadoVitalController($log) {
        // for controllerAs syntax
        // var vm = this;

        activate();

        ////////////////

        function activate() {
          $log.log('I\'m a line from dadovital.js');
        }
    }
})();
