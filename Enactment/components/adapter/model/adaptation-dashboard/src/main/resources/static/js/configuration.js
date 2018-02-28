var app = angular.module('w5app');

app.controllerProvider.register('configuration', function($scope, $http) {
	

//////////////////////////////////////////////////////////
//////////////////// Radio & Buttons /////////////////////
//////////////////////////////////////////////////////////

//Radio 
$("#rbtnSupervised").jqxRadioButton({ width: 200, height: 25 });
$("#rbtnAutomatic").jqxRadioButton({ width: 200, height: 25 });
top.config="";


 $("#rbtnSupervised").on('checked', function (event) {//bind() deprecated
	 //$('#supervision').show();
	 $('#typeConf').val('Configuration type: Supervised');
	 top.config="supervised";
 });
 
 $("#rbtnAutomatic").on('checked', function (event) {//bind() deprecated
	 //$('#supervision').hide();
	 $('#typeConf').val('Configuration type: Automated');
	 top.config="automated";
 });
 
 //When click on radioButton
 //TODO Write adaptation configuration in backend API
 $scope.setConfiguration = function() {
	 console.log(top.config);

	 $http({
            url: "adaptation-dashboard/adaptation/configuration/" + top.config,
            method: 'POST' //'GET'
        }).success(function(data) {
	        	//console.log(data);
		}).error(function(err) {
		    	console.log(err);
		    	alert("The adaptation backend services are not available. Please, contact SUPERSEDE administrator");
		});
	}
 
     
     
	 //////////////////////////////////////////////////////////
	 //////////////////// Page Initialization /////////////////
	 //////////////////////////////////////////////////////////
	 //Hiding the grid and the radio buttons 
	 $('#supervision').hide();
	 //Automatic configuration is selected by default
	 //TODO Read adaptation configuration from backend API
	 $("#rbtnAutomatic").jqxRadioButton('check');
	 top.config="automated";

	 getConfiguration = function() {
	 
	 		$http({
	 			url : "adaptation-dashboard/adaptation/configuration",
	 			method : 'GET'
	 		}).success(function(data, status) {
	 			console.log(data);
	 			top.config = "automated";
	 		 	if (data['mode'] == 'automated') {
	 		 		top.config = "automated";
	 		 		$("#rbtnAutomatic").jqxRadioButton('check');
	 		 	} else {
	 		 		top.config = "supervised";
	 		 		$("#rbtnSupervised").jqxRadioButton('check');
	 		 	}
	 		}).error(function(err) {
	 			console.log(err);
	 			alert("The adaptation backend services are not available. Please, contact SUPERSEDE administrator");
	 		});
	 }
	 
	 getConfiguration();
		
});

//# sourceURL=configuration.js
