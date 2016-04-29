'use strict';
 
App.controller(
		'RepositorioController', 
		[
		 	'$scope',
		 	'RepositorioService',
		 	function($scope, RepositorioService) 
		 	{
		 		$scope.toggle=true;
		 		$scope.selection = [];
		 		$scope.statuses=['ACTIVE','COMPLETED'];
		 		$scope.priorities=['HIGH','LOW','MEDIUM'];
		 		var self = this;
		 		self.repositorio=
		 		{
		 			id		:null,
		 			url		:'',
		 			image	:'',
		 			root	:'',
		 			active	:'',
		 			name	:''
		 		};
		 		
		 		self.repositorios=[];
		 		
		 		self.fetchAllRepositorios = function(){
		 			RepositorioService.fetchAllRepositorios().then(
		 					function(d) { self.repositorios = d; },
		 					function(errResponse){ console.error('Error while fetching Repositorios'); }
                    );
		 		};
            
		 		self.createRepositorio = function(repositorio){
		 			RepositorioService.createRepositorio(repositorio).then(
		 					self.fetchAllRepositorios, 
                            function(errResponse){ console.error('Error while creating Repositorio.'); } 
		 			);
		 		};
 
		 		self.updateRepositorio = function(repositorio, id){
		 			RepositorioService.updateRepositorio(repositorio, id).then(
                            self.fetchAllRepositorios, 
                            function(errResponse){ console.error('Error while updating Repositorio.'); } 
		 			);
		 		};
 
		 		self.deleteRepositorio = function(id){
		 			RepositorioService.deleteRepositorio(id).then(
                            self.fetchAllRepositorios, 
                            function(errResponse){ console.error('Error while deleting Repositorio.'); } 
		 			);
		 		};
 
		 		self.fetchAllRepositorios();
 
		 		self.submit = function() {
		 			if(self.repositorio.id===null){
		 				console.log('Saving New Repositorio', self.repositorio);    
		 				self.createRepositorio(self.repositorio);
		 			}else{
		 				self.updateRepositorio(self.repositorio, self.repositorio.id);
		 				console.log('Repositorio updated with id ', self.repositorio.id);
		 			}
		 			self.reset();
		 		};
               
		 		self.edit = function(id){
		 			console.log('id to be edited', id);
		 			for(var i = 0; i < self.repositorios.length; i++){
		 				if(self.repositorios[i].id === id) {
		 					self.repositorio = angular.copy(self.repositorios[i]);
		 					break;
		 				}
		 			}
		 		};
               
		 		self.remove = function(id){
		 			console.log('id to be deleted', id);
		 			if(self.repositorio.id === id) {
		 				//clean form if the user to be deleted is shown there.
		 				self.reset();
		 			}
		 			self.deleteRepositorio(id);
		 		};
 
		 		self.reset = function(){
		 			self.repositorio=
		 			{
		 					id		:null,
		 					url		:'',
		 					image	:'',
		 					root	:'',
		 					active	:'',
		 					name	:''
		 			};
		 			$scope.myForm.$setPristine(); //reset Form
		 		};
 
		 	}
	]
);