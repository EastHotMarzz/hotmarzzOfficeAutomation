var arrayToJson = function(arr,jsonKey){
	if(arr !=null && arr != undefined && arr.length>0){
		var json = [];
		$.each(arr,function(index,item){
			var ele = {jsonKey:item};
			json.push(ele);
		})
		return json;
	}
}