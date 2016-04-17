(function (ng) {

    var mod = ng.module("mainApp", [
        "ui.router",
        "personModule",
        "serviceModule"  
    ]);

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/person");
            $stateProvider

                    .state('person', {
                        url: '/person',
                        views: {
                            "paciente": {controller: "personCtrl",
                                controllerAs: "ctrl",
                                templateUrl: "src/modules/person/person.tpl.html"}
                            ,
                            "servicio": {controller: "serviceCtrl",
                                controllerAs: "ctrl",
                                templateUrl: "src/modules/service/service.tpl.html"}
                        }
                    });

        }]);
})(window.angular);