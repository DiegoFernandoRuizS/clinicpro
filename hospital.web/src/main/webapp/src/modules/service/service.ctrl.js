
(function (ng) {

    var mod = ng.module("serviceModule");

    mod.controller("serviceCtrl", ["$scope", "$rootScope","serviceService", function ($scope,$rootScope, svc) {

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
            this.editModeServices = true;

            this.changeTab = function (tab) {
                $scope.tab = tab;
            };

            this.getRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    return response;
                }, responseError);
            };

            this.getRecords = function () {
                return svc.fetchRecords().then(function (response) {
                    $scope.records = response.data;
                    console.log($scope.records);
                    return response;
                }, responseError);
            };

            this.getRecords();

            this.getCost = function (record) {
                return svc.fetchRecord(record.servicio).then(function (response) {
                    $scope.servicio = response.data;
                    console.log("Root scope");
                    console.log($rootScope.paciente);
                    return response;
                }, responseError);
            };

            this.print=function(elementId) {
                var a = document.getElementById('printing-css').value;
                var b = document.getElementById(elementId).innerHTML;
                window.frames["print_frame"].document.title = document.title;
                window.frames["print_frame"].document.body.innerHTML = '<style>' + a + '</style>' + b;
                window.frames["print_frame"].window.focus();
                window.frames["print_frame"].window.print();
            }
            
            //
            this.listServices=function ()
            {
                self.editModeServices=false;
                             self.editModeList=true;

                
            };
            
            //-------
             //Metodos para el CRUD
            //Metodos para el CRUD
            this.createRecord = function () {
             $scope.$broadcast("pre-create", $scope.currentRecord);
             this.editMode = true;
             this.editModeServices=true;
             self.editModeList=true;
            
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
             
             this.editModeServices=true;
             self.editMode = false;
             self.editModeList=false;
           
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

        }]);

})(window.angular);