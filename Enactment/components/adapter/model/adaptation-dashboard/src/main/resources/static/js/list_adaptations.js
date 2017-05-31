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
		url: "adaptation-dashboard/adaptation",
		method: 'GET'
	}).success(function (data, status) {
		var localData = [];
		
		for(var i = 0; i < data.length; i++)
		{
			var row = {};
			row['name'] = data[i]['name'];
			row['feature_id'] = data[i]['feature_id'];
			row['enabled'] = data[i]['enabled'];
			row['description'] = data[i]['description'];
			var date = new Date(data[i]['enacted_timestamp']);
			row['enacted_timestamp'] = date.toUTCString();
			var result = data[i]['result'];
			if (result == true) row['result'] = "SUCCESS";
			else row['result'] = "FAILURE";
			//var time = new Date(data[i]['enacted_time']);
			row['enacted_time'] = data[i]['enacted_time'];
			
			
			localData.push(row);
		}
		
		// prepare the data
		var source =
		{
			datatype: "json",
			datafields: [
				{ name: 'name', type: 'string' },
				{ name: 'feature_id', type: 'string' },
				{ name: 'enabled', type: 'string' },
				{ name: 'description', type: 'string' },
				{ name: 'enacted_timestamp', type: 'string' },
				{ name: 'result', type: 'string' },
				{ name: 'enacted_time', type: 'string' }
			],
			id: 'adaptationId',
			localdata: localData
		};
		var dataAdapter = new $.jqx.dataAdapter(source);
		
		$scope.gridSettings =
		{
			width: '100%',
			pageable: true,
			autoheight: true,
			autorowheight: false,
			source: dataAdapter,
			columnsresize: true,
			selectionmode: 'checkbox',
			columns: [
			    { text: 'Name', datafield: 'name' },
				{ text: 'Feature Id', datafield: 'feature_id' },
				{ text: 'Enabled', datafield: 'enabled' },
				{ text: 'Description', datafield: 'description' },
				{ text: 'Enactment timestamp', datafield: 'enacted_timestamp' },
				{ text: 'Result', datafield: 'result', 
					cellsRenderer: function (row, columnDataField, value) {
						if (value == 'SUCCESS') var color = 'green';
						else var color = 'red';
						return '<div class="jqx-grid-cell-left-align" style="color:' + color + ';margin-top: 4px; margin-bottom: 4px;">' + value + '</div>';
					} },
				{ text: 'Enactment time', datafield: 'enacted_time' }
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
