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
				
				console.log(data);
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
		    
			root: 'actions',
			id: 'fc_id',
			localdata: localData
		};
		var dataAdapter = new $.jqx.dataAdapter(source, { autoBind: true });
		 
		//1st end of the link(Suggested_Adaptations)
		//trying to retrieve data stored in Enacted_Adaptation table to subData
		 $http({
           url: "adaptation-dashboard/enactment/",
           method: 'GET'
       }).success(function(data) {
          var subData= [];
          
          for(var i = 0; i < data.length; i++)
  		{
  			subData.push(data[i]['fc_id']);
  			console.log(subData);
  		}
  	
    	   
	            
		
        //create original grid
		$scope.gridSettings =
		{
			autowidth: true,
			pageable: true,
			autoheight: true,
			altrows: true,
			autorowheight: true,
			source: dataAdapter,
			columnsresize: true,
			selectionmode: 'checkbox',
			columns: [
			    { text: '<b>Adaptation id</b>', align: 'center', datafield: 'fc_id', width: 110,
			    	cellsRenderer: function (row, columnfield, value, defaulthtml, columnproperties){
			    		for (var i=0; i< subData.length; i++){ //comparing each adaptation to see if it is in the enacted table
			    			if(value == subData[i])
			    				
			    			    
			    			    //TODO: 2nd end of the link(Enacted_Adaptation)
			    			    //get grid from Enactment_Adaptation page
			    			    //get all Adaptation ids (stored one per row) in all the grid's pages
			    			    //when clicking on the link show only the page that contains the enacted adaptation with that id
			    				
			    				//$.get("#/adaptation-dashboard/enacted_adaptations.html", null, function(text){
			    				    //console.log(text);//$(text).find('#jqxGrid'));
			    				//});
			    				
			    				
			    				//showing link only for those that are
			    				//return '<a href= "#/adaptation-dashboard/enacted_adaptations"><b>'+value+'</b></a>';
			    		}
			    	}

				/*
				format ={target: ''};
				html= '<link href= "#/adaptation-dashboard/enacted_adaptations"/>';
				alert("");
				$location.path('/adaptation-dashboard/enacted_adaptations');
				window.location.reload();
				*/
			    },
			    { text: '<b>Name</b>', align: 'center', datafield: 'name', width: 80},
			    { text: '<b>Computation Timestamp</b>', align: 'center', datafield: 'computation_timestamp', width: 180},
			    //{ text: 'Rank', align: 'center', datafield: 'rank', width: 100},
			    { text: '<b>Model System</b>', align: 'center', datafield: 'model_system', width: 190},
			    { text: '<b>Action id' ,columngroup: 'Actions', align: 'center', datafield: 'action_ids',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		console.log("row: "+row+" columnData: "+columnDataField+" value: "+value);
			    		var grid = '<table style="width:100%;table-layout: fixed;">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;"><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} },
				{ text: '<b>Action name</b>', columngroup: 'Actions', align: 'center', datafield: 'action_names',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var grid = '<table style="width:100%;table-layout: fixed;">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;"><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} },
				{ text: '<b>Action description</b>',columngroup: 'Actions', align: 'center', datafield: 'action_descriptions',
			    	cellsRenderer: function (row, columnDataField, value) {
			    		var grid = '<table style="width:100%;%table-layout: fixed;">';
			    		for (var i = 0; i < value.length; i++) {
			    			if (i == 0) grid += '<tr><td><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    			else grid += '<tr><td style="border-top:1px solid #DDDDDD;"><div style="height: 25px;">' + value[i] + '</div></td></tr>';
			    		}
			    		grid += '</table>'
			    		return grid;
					} },
				{ text: '<b>Action enabled</b>',columngroup: 'Actions', align: 'center', datafield: 'action_enableds',
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
					}
				}
			],
			columngroups: 
                [
                  { text: '<b>Actions</b>', align: 'center', name: 'Actions'}
                ],
			ready: function()
			{
				
				$('#btnEnact').jqxButton({ disabled: true });
				$('#btnDelete').jqxButton({ disabled: true });
				
				var selectedRows={};			
		
		
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
			var indexes = $('#jqxGrid').jqxGrid('selectedrowindexes');
			var count = 0;
			var lim = indexes.length;
			for(var index in indexes ) {
				console.log(index);
				var row_data = $('#jqxGrid').jqxGrid('getrowdata', indexes[index]);
				$http({
		            url: "adaptation-dashboard/adaptation/" + row_data['fc_id'],
		            method: 'POST'
		        }).success(function(data) {
		        	console.log("Enacted adaptation");
		        	++count;
		        	if (count == lim) alert("Adaptation/s enacted successfully");
			    }).error(function(err) {
			    	console.log(err);
			    	alert("There was an internal error");
			    });
			}
		}
		
		$scope.deleteSuggestedAdaptations = function() {
			var indexes = $('#jqxGrid').jqxGrid('selectedrowindexes');
			var count = 0;
			var lim = indexes.length;
			for(var i = lim-1; i >= 0; --i) {
				var row_data = $('#jqxGrid').jqxGrid('getrowdata', indexes[i]);
				 $http({
		            url: "adaptation-dashboard/adaptation/" + row_data['fc_id'],
		            method: 'DELETE'
		        }).success(function(data) {
		        	console.log("Adaptation deleted successfully");
		        	++count;
		        	if (count == lim) alert("Adaptation/s deleted successfully");
			    }).error(function(err) {
			    	console.log(err);
			    	alert("There was an internal error");
			    });
				$('#jqxGrid').jqxGrid('deleterow', row_data['fc_id']);
			}
		}
			

		//FOR ENACTMENTS
       }).error(function(err) {
           console.log(err);
       });
	

		 //FOR ADAPTATIONS
	 }).error(function (data, status) {
		 alert(status);
	 });
});

