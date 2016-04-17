
(function (ng) {

    var mod = ng.module("personModule");

    mod.controller("personCtrl", ["$scope", "$rootScope","personService", function ($scope,$rootScope, svc) {


            $scope.record = {}
            $rootScope.paciente={};
            $scope.currentRecord = {};
            $scope.records = [];

            $scope.today = function () {
                $scope.value = new Date();
            };

            $scope.clear = function () {
                $scope.value = null;
            };

            $scope.open = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };


            var self = this;
            function responseError(response) {
                self.showError(response.data);
            }
            //Variables para el controlador
            this.readOnly = false;
            this.editMode = false;

            this.changeTab = function (tab) {
                $scope.tab = tab;
            };

            //Consultar una persona
            this.getRecord = function (record) {
                console.log("El id? " + record.cedula);
                return svc.fetchRecord(record.cedula).then(function (response) {
                    $scope.currentRecord = response.data;
                    $rootScope.paciente= response.data;
                }, responseError);
            };

            //Metodos para el CRUD
            /*this.createRecord = function () {
             $scope.$broadcast("pre-create", $scope.currentRecord);
             this.editMode = true;
             $scope.currentRecord = {};
             $scope.$broadcast("post-create", $scope.currentRecord);
             };
             
             this.editRecord = function (record) {
             console.log("LLego? " + record.id);
             $scope.$broadcast("pre-edit", $scope.currentRecord);
             return svc.fetchRecord(record.id).then(function (response) {
             $scope.currentRecord = response.data;
             self.editMode = true;
             $scope.$broadcast("post-edit", $scope.currentRecord);
             return response;
             }, responseError);
             };
             
             this.fetchRecords = function () {
             return svc.fetchRecords().then(function (response) {
             $scope.records = response.data;
             $scope.currentRecord = {};
             self.editMode = false;
             return response;
             }, responseError);
             };
             
             this.saveRecord = function () {
             return svc.saveRecord($scope.currentRecord).then(function () {
             self.fetchRecords();
             }, responseError);
             };
             
             this.deleteRecord = function (record) {
             return svc.deleteRecord(record.id).then(function () {
             self.fetchRecords();
             }, responseError);
             };
             
             this.fetchRecords();
             */
        }]);

})(window.angular);