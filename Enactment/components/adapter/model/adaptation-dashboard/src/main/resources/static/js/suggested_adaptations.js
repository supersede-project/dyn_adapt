var app = angular.module('w5app');

app.controllerProvider.register('suggested_adaptations', function($scope, $http) {
	
//    $scope.adaptations = "";
//    $scope.getAdaptations = function() {
//        $http({
//            url: "adaptation-app/adaptation",
//            method: 'GET'
//        }).success(function(data) {
//            $scope.adaptations = data;//.firstName + " " + data.lastName;
//	            }).error(function(err) {
//	                console.log(err);
//	            });
//    };
//    $scope.getAdaptations();
	
	$http({
		url: "adaptation-dashboard/adaptation",
		method: 'GET'
	}).success(function (data, status) {
		var localData = [];
		
		for(var i = 0; i < data.length; i++)
		{
			var row = {};
			row['fc_id'] = data[i]['fc_id'];			
			row['name'] = data[i]['name'];
			row['computation_timestamp'] = data[i]['computation_timestamp'];
			row['rank'] = data[i]['rank'];
			row['model_system'] = data[i]['model_system'];
			
			row['action_ids'] = [];
			row['action_names'] = [];
			row['action_descriptions'] = [];
			row['action_enableds'] = [];
			
			for(var j = 0; j < data[i]['actions'].length; j++) {
				
				row['action_ids'].push(data[i]['actions'][j]['ac_id']);
				row['action_names'].push(data[i]['actions'][j]['name']);
				row['action_descriptions'].push(data[i]['actions'][j]['description']);
				row['action_enableds'].push(data[i]['actions'][j]['enabled']);
			}
						
			localData.push(row);
		}
		
		// prepare the data
		var source =
		{
			datatype: "json",
			datafields: [
				{ name: 'fc_id', type: 'string' },
				{ name: 'name', type: 'string' },
				{ name: 'computation_timestamp', type: 'string' },
				{ name: 'rank', type: 'string' },
				{ name: 'model_system', type: 'string'},
				{ name: 'action_ids', type: 'array' },
				{ name: 'action_names', type: 'array' },
				{ name: 'action_descriptions', type: 'array' },
				{ name: 'action_enableds', type: 'array' }
			],
			hierarchy:
		    {
		        root: 'actions'
		    },
			id: 'fc_id',
			localdata: localData
		};
		var dataAdapter = new $.jqx.dataAdapter(source);
				
		$scope.gridSettings =
		{
			width: '100%',
			pageable: true,
			autoheight: true,
			autorowheight: true,
			source: dataAdapter,
			columnsresize: false,
			selectionmode: 'checkbox',
			columns: [
			    { text: 'Adaptation id', align: 'center', datafield: 'fc_id' , width: 110},
			    { text: 'Name', align: 'center', datafield: 'name', width: 80},
			    { text: 'Computation Timestamp', align: 'center', datafield: 'computation_timestamp', width: 180},
			    //{ text: 'Rank', align: 'center', datafield: 'rank', width: 100},
			    { text: 'Model System', align: 'center', datafield: 'model_system', width: 190},
			    { text: 'Action id', columngroup: 'Actions', align: 'center', datafield: 'action_ids',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var grid = '<table style="height:100%; width:100%">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td>' + value[i] + '<tr><td>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;">' + value[i] + '<tr><td>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} },
				{ text: 'Action name', columngroup: 'Actions', align: 'center', datafield: 'action_names',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var grid = '<table style="height:100%; width:100%">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td>' + value[i] + '<tr><td>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;">' + value[i] + '<tr><td>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} },
				{ text: 'Action description', columngroup: 'Actions', align: 'center', datafield: 'action_descriptions',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var grid = '<table style="height:100%; width:100%">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td>' + value[i] + '<tr><td>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;">' + value[i] + '<tr><td>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} },
				{ text: 'Action enabled', columngroup: 'Actions', align: 'center', datafield: 'action_enableds',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var grid = '<table style="height:100%; width:100%">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td>' + value[i] + '<tr><td>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;">' + value[i] + '<tr><td>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} }
			],
			columngroups: 
                [
                  { text: 'Actions', align: 'center', name: 'Actions' }
                ],
			ready: function()
			{
				$('#btnEnact').jqxButton({ disabled: true });
				$('#btnDelete').jqxButton({ disabled: true });
				
				var selectedRows = {};
				
				$('#jqxGrid').bind('rowselect', function(event)  {
					var current_index = event.args.rowindex;
					var datarow = $('#jqxGrid').jqxGrid('getrowdata', current_index);
					
					selectedRows[current_index] = datarow;
					$('#btnEnact').jqxButton({ disabled: false });
					$('#btnDelete').jqxButton({ disabled: false });
				});
				$('#jqxGrid').bind('rowunselect', function(event)  {
					var current_index = event.args.rowindex;
					var datarow = $('#jqxGrid').jqxGrid('getrowdata', current_index);
					
					delete selectedRows[current_index];
					
					if (Object.keys(selectedRows).length <= 0) {
						$('#btnEnact').jqxButton({ disabled: true });
						$('#btnDelete').jqxButton({ disabled: true });
					}
					
				});
			}
		};
		$scope.createWidget = true;
		
		$scope.enactSuggestedAdaptations = function() {
			$http({
	            url: "adaptation-dashboard/adaptation",
	            method: 'POST',
	            data: {
	                "fc_id": "FC_4",
	                "name": "Feature1",
	                "computation_timestamp": "2017/05/31 16:00:00",
	                "rank": 0.898400009,
	                "model_system": "Siemens",
	                "actions": [
	                    {
	                        "name": "Action1",
	                        "description": "Description of Action1",
	                        "enabled": true,
	                        "ac_id": "AC_1"
	                    }
	                ]
	            }
	        }).success(function(data) {
	        	alert("Created adaptation");
		    }).error(function(err) {
		    	console.log(err);
		    });
		}
		
		$scope.deleteSuggestedAdaptations = function() {
			var indexes = $('#jqxGrid').jqxGrid('selectedrowindexes');
			for(var index in indexes ) {
				var row_data = $('#jqxGrid').jqxGrid('getrowdata', indexes[index]);
				 $http({
		            url: "adaptation-dashboard/adaptation/" + row_data['fc_id'],
		            method: 'DELETE'
		        }).success(function(data) {
		        	alert("Adaptation " + row_data['fc_id'] + " deleted successfully");
		        	$('#jqxGrid').jqxGrid('deleterow', row_data['fc_id']);
			    }).error(function(err) {
			    	console.log(err);
			    });
			}
		}

	 }).error(function (data, status) {
		 alert(status);
	 });
});
