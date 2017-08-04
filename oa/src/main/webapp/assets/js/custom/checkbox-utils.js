function selectChe(checkBoxName,checkedValName){
	debugger
	var chs = $("input[type='checkbox'][name='"+checkBoxName+"']");
	var ched = $("input[type='hidden'][name='"+checkedValName+"']");
	if(ched.length>0&&chs.length>0){
		$.each(chs,function(index,item){
			$.each(ched,function(ind,it){
				if(item.value==it.value){
					$(item).prop("checked","checked");
				}
			})
		})
	}
}