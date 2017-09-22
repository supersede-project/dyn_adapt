var app = angular.module('w5app');

app.controllerProvider.register('enacted_adaptations', function($scope, $http) {
	
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
		url: "adaptation-dashboard/enactment",
		method: 'GET'
	}).success(function (data, status) {
		var localData = [];
		
		for(var i = 0; i < data.length; i++)
		{
			var row = {};
			row['fc_id'] = data[i]['adaptation']['fc_id'];			
			row['enactment_request_time'] = data[i]['enactment_request_time'];
			row['enactment_completion_time'] = data[i]['enactment_completion_time']
			row['result'] = data[i]['result'];
			
			row['action_ids'] = [];
			row['action_names'] = [];
			row['action_descriptions'] = [];
			row['action_enableds'] = [];
			
			for(var j = 0; j < data[i]['adaptation']['actions'].length; j++) {
				
				row['action_ids'].push(data[i]['adaptation']['actions'][j]['ac_id']);
				row['action_names'].push(data[i]['adaptation']['actions'][j]['name']);
				row['action_descriptions'].push(data[i]['adaptation']['actions'][j]['description']);
				row['action_enableds'].push(data[i]['adaptation']['actions'][j]['enabled']);
			}
						
			localData.push(row);
		}
		
		// prepare the data
		var source =
		{
			datatype: "json",
			datafields: [
				{ name: 'fc_id', type: 'string' },
				{ name: 'enactment_request_time', type: 'string' },
				{ name: 'enactment_completion_time', type: 'string' },
				{ name: 'result', type: 'string' },
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
			altrows: true,
			source: dataAdapter,
			//columnsresize: true,
			selectionmode: 'checkbox',
			columns: [
			    { text: 'Adaptation id', align: 'center', datafield: 'fc_id' , width: 110},
			    { text: 'Action id', columngroup: 'Actions', align: 'center', datafield: 'action_ids',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var grid = '<table style="width:100%;table-layout: fixed;">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;"><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} },
				{ text: 'Action name', columngroup: 'Actions', align: 'center', datafield: 'action_names',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var grid = '<table style="width:100%;table-layout: fixed;">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;"><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} },
				{ text: 'Action description', columngroup: 'Actions', align: 'center', datafield: 'action_descriptions',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var grid = '<table style="width:100%;%table-layout: fixed;">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;"><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} },
				{ text: 'Action enabled', columngroup: 'Actions', align: 'center', datafield: 'action_enableds',
						cellsRenderer: function (row, columnDataField, value) {
				    		var grid = '<table style="width:100%;%table-layout: fixed;">';
				    		for (var i = 0; i < value.length; i++) {
				    			//painting borders
				    			if (i == 0) grid += '<tr><td><div style="height: 25px;">';
				    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;">';
				    				
				    			//checkbox
				    			if(value[i]==true){
				    				grid += '<div style="height: 25px;"><input type="checkbox" checked="checked" disabled="disabled"></div></td></tr>';
				    			}
				    			else
				    				grid += '<div style="height: 25px;"><input type="checkbox" disabled="disabled"></div></td></tr>';
				    		}
				    		grid += '</table>'
				    		return grid;
						} },
			    { text: 'Enactment request time', align: 'center', datafield: 'enactment_request_time', width: 200},
			    { text: 'Enactment completion time', align: 'center', datafield: 'enactment_completion_time', width: 200},
				{ text: 'Result', align: 'center', datafield: 'result', width: 70,
					cellsRenderer: function (row, columnDataField, value) {
						console.log(row);
						
						if (value) {
							//var color = 'green';
							//var text = 'SUCCESS';
							var img = './jqx/styles/images/check_black.png';
						}
						else {
							//var color = 'red';
							//var text = 'FAILURE';
							var img = './jqx/styles/images/close_black.png';
						}
						return '<img style= width: 60 height: 30 align: center; src="'+img+'"/> ';
						//'<div class="jqx-grid-cell-left-align" style="color:' + color + ';'
						//+ 'display: flex; align-items: center;vertical-align: middle; margin-top:20%;">' + text + '</div>'
						
					} }
			],
			columngroups: 
                [
                  { text: 'Actions', align: 'center', name: 'Actions' }
                ],
			ready: function()
			{
				$('#btnDelete').jqxButton({ disabled: true });
				
				var selectedRows = {};
				
				$('#jqxGrid').bind('rowselect', function(event)  {
					var current_index = event.args.rowindex;
					var datarow = $('#jqxGrid').jqxGrid('getrowdata', current_index);
					
					selectedRows[current_index] = datarow;
					$('#btnDelete').jqxButton({ disabled: false });
				});
				$('#jqxGrid').bind('rowunselect', function(event)  {
					var current_index = event.args.rowindex;
					var datarow = $('#jqxGrid').jqxGrid('getrowdata', current_index);
					
					delete selectedRows[current_index];
					
					if (Object.keys(selectedRows).length <= 0) {
						$('#btnDelete').jqxButton({ disabled: true });
					}
					
				});
			}
		};
		
		
		$scope.deleteSuggestedAdaptations = function() {
			var indexes = $('#jqxGrid').jqxGrid('selectedrowindexes');
			var count = 0;
			var lim = indexes.length;
			for(var i = lim-1; i >= 0; --i ) {
				var row_data = $('#jqxGrid').jqxGrid('getrowdata', indexes[i]);
				 $http({
		            url: "adaptation-dashboard/enactment/" + row_data['fc_id'],
		            method: 'DELETE'
		        }).success(function(data) {
		        	console.log("Enactment deleted successfully");
		        	++count;
		        	if (count == lim) alert("Enactment/s deleted successfully");
			    }).error(function(err) {
			    	console.log(err);
			    	alert("There was an internal error");
			    });
		        $('#jqxGrid').jqxGrid('deleterow', row_data['fc_id']);
			}
		}
		

		
		$scope.createWidget = true;
	 }).error(function (data, status) {
		 alert(status);
	 });
});
