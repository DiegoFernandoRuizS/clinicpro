
(function(ng){
    
    var mod = ng.module("personModule", ["ui.bootstrap"]);
    
    mod.constant("personContext", "http://localhost:8080/hospital.logic/api/persons");
    
})(window.angular);

