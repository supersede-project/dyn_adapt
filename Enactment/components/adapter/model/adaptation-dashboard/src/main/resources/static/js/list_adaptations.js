var app = angular.module('w5app');

app.controllerProvider.register('list_adaptations', function($scope, $http) {
	
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
			row['fc_id'] = data[i]['fc_id'];			
			var date = new Date(data[i]['enactment_request_time']);
			row['enactment_request_time'] = date.toUTCString();
			row['enactment_completion_time'] = data[i]['enactment_completion_time'];
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
			source: dataAdapter,
			columnsresize: true,
			selectionmode: 'checkbox',
			columns: [
			    { text: 'Feature Id', datafield: 'fc_id' },
			    { text: 'Action id', datafield: 'action_ids',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var text = value[0];
			    		for (var i = 1; i < value.length; i++) text += '<br\>' + value[i];
			    		return '<div class="jqx-grid-cell-left-align" style="margin-top: 4px; margin-bottom: 4px;">' + text + '</div>';
					} },
				{ text: 'Action name', datafield: 'action_names',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var text = value[0];
			    		for (var i = 1; i < value.length; i++) text += '<br\>' + value[i];
			    		return '<div class="jqx-grid-cell-left-align" style="margin-top: 4px; margin-bottom: 4px;">' + text + '</div>';
					} },
				{ text: 'Action description', datafield: 'action_descriptions',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var text = value[0];
			    		for (var i = 1; i < value.length; i++) text += '<br\>' + value[i];
			    		return '<div class="jqx-grid-cell-left-align" style="color:margin-top: 4px; margin-bottom: 4px;">' + text + '</div>';
					} },
				{ text: 'Action enabled', datafield: 'action_enableds',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var text = value[0];
			    		for (var i = 1; i < value.length; i++) text += '<br\>' + value[i];
			    		return '<div class="jqx-grid-cell-left-align" style="color:margin-top: 4px; margin-bottom: 4px;">' + text + '</div>';
					} },
			    { text: 'Enactment request time', datafield: 'enactment_request_time'},
			    { text: 'Enactment completion time', datafield: 'enactment_completion_time'},
				{ text: 'Result', datafield: 'result', 
					cellsRenderer: function (row, columnDataField, value) {
						if (value) {
							var color = 'green';
							var text = 'SUCCESS'
						}
						else {
							var color = 'red';
							var text = 'FAILURE';
						}
						return '<div class="jqx-grid-cell-left-align" style="color:' + color + ';margin-top: 4px; margin-bottom: 4px;">' + text + '</div>';
					} }
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
	 }).error(function (data, status) {
		 alert(status);
	 });
});
