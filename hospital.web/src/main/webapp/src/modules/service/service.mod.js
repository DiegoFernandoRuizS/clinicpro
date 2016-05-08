
(function(ng){
    
    var mod = ng.module("serviceModule", ["ui.bootstrap"]);
    
    mod.constant("serviceContext", "http://localhost:8080/hospital.api/api/services");
    
})(window.angular);

