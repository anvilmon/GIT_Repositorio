'use strict';
 
App.factory('RepositorioService', ['$http', '$q', function($http, $q){
	$http.defaults.headers.post["Content-Type"] = "application/json";

    return {
         
            fetchAllRepositorios: function() {
                    return $http.get('http://'+window.location.host+'/api/repositorio/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching repositorios');
                                        return $q.reject(errResponse);
                                    }
                            );
            	
//            	 return $http.get('http://'+window.location.host+'/Usuario')
//                 .then(
//                         function(response){
//                             return response.data;
//                         }, 
//                         function(errResponse){
//                             console.error('Error while fetching repositorios');
//                             return $q.reject(errResponse);
//                         }
//                 );
            },
             
            createRepositorio: function(repositorio){
                    return $http.post('http://'+window.location.host+'/api/repositorio/', repositorio)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating repositorio');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateRepositorio: function(repositorio, id){
                    return $http.put('http://'+window.location.host+'/api/repositorio/'+id+'', repositorio)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating repositorio');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteRepositorio: function(id){
                    return $http.delete('http://'+window.location.host+'/api/repositorio/'+id+'')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting repositorio');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
 
}]);