﻿function InitTable(table, actionUrl, tableColumns, paging){
	// 是否分页
	if (paging == undefined){
		paging = true; 
	}
	//initiate dataTables plugin
	var myTable = $(table)
	//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
	.DataTable( {
		bAutoWidth: false,
        ajax: {
            url: actionUrl,
            type: "POST",
            data: function(d){
            	//d.start 开始行数 d.length 显示条数
            	var params = {'draw':d.draw,'pag':{'page_size':d.length,'start_size':d.start,'end_size':d.start + d.length + 1},'queryParams':searchData()};

            	return JSON.stringify(params);
            },
            dataType: "json",
            contentType:"application/json; charset=UTF-8"
        },
        "destroy": true,                   // 销毁已经存在的Datatables实例并替换新的选项
		"aoColumns": tableColumns,
		"aaSorting": [],
		oLanguage: {
			"sProcessing": "数据加载中……",
			"sSearch": "快速检索:",
			"sLengthMenu": "每页显示 _MENU_ 条",
			"sInfo": "从 _START_ 到 _END_ 条，总共 _TOTAL_ 条记录",
			"sZeroRecords": "没有记录",
			"sInfoEmpty": "暂无记录",
			"sInfoFiltered": "(一共有 _MAX_  条记录)",
			"oPaginate": {
				"sFirst": "首页",
				"sPrevious": " 上一页 ",
				"sNext": " 下一页 ",
				"sLast": " 末页 "
			}
		},
        "lengthMenu": [
                       [5, 10, 15, 20, -1],
                       [5, 10, 15, 20, "All"] // change per page values here
                   ],
        "pageLength": 10,                    // 改变初始的页面长度(每页显示的记录数)
		//"bProcessing": true,
        "bServerSide": true,
        paging:paging,
        lengthChange: true,                 // 是否允许用户改变表格每页显示的记录数
        ordering: false,                     // 排序
        processing: true,                   // 是否显示正在处理的状态
        searching: false
		//"sScrollY": "200px",
		//"bPaginate": false,

		//"sScrollX": "100%",
		//"sScrollXInner": "120%",
		//"bScrollCollapse": true,
		//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
		//you may want to wrap the table inside a "div.dataTables_borderWrap" element

		//"iDisplayLength": 50
//		select: {
//			style: 'multi'
//		}
    } );

	
	
	$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';
	
	new $.fn.dataTable.Buttons( myTable, {
		buttons: [
		  {
			"extend": "colvis",
			"text": "<i class='fa fa-search bigger-110 blue'></i> <span class='show'>显示/隐藏 列</span>",
			"className": "btn btn-sm  btn-white btn-round",
			columns: ':not(:first):not(:last)'
		  },
		  {
			"extend": "copy",
			"text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='show'>复制到剪贴板</span>",
			"className": "btn btn-sm  btn-white btn-round"
		  },
		  {
			"extend": "csv",
			"text": "<i class='fa fa-database bigger-110 orange'></i> <span class='show'>导出csv</span>",
			"className": "btn btn-sm  btn-white btn-round"
		  },
		  {
			"text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='show'>导出Excel</span>",
			"className": "btn btn-sm  btn-white btn-round  	buttons-excel",
			action: function ( e, dt, node, config ) {
				exportExcel("resultTablle","导出文件");
            }
		  },
		  {
			"extend": "print",
			"text": "<i class='fa fa-print bigger-110 grey'></i> <span class='show'>打印</span>",
			"className": "btn btn-sm  btn-white btn-round",
			autoPrint: false,
			message: 'This print was produced using the Print button for DataTables'
		  }		  
		]
	} );
	// 清空按钮展示区域
	$('.tableTools-container').empty();
	// 将导出等按钮添加到指定区域
	myTable.buttons().container().appendTo( $('.tableTools-container') );
	
	//style the message box
	var defaultCopyAction = myTable.button(1).action();
	myTable.button(1).action(function (e, dt, button, config) {
		defaultCopyAction(e, dt, button, config);
		$('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
	});
	
	
//	var defaultColvisAction = myTable.button(0).action();
//	myTable.button(0).action(function (e, dt, button, config) {
//		defaultColvisAction(e, dt, button, config);
//		
//		if($('.dt-button-collection > .dropdown-menu').length == 0) {
//			$('.dt-button-collection')
//			.wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
//			.find('a').attr('href', '#').wrap("<li />")
//		}
//		$('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
//	});
	

}



var preCondition = function(){
	var current_page = 1;
	var username = 'test';
	var params = {'pag':{'current_page':current_page,'page_size':10},'queryParams':{'username':searchData()}};
	return JSON.stringify(params);
}




// 通用表格
function InitTableNewVersion(table, actionUrl, tableColumns) {
   var showTable = $(table).dataTable({
        autoWidth: false,                    // 控制Datatables是否自适应宽度
        deferRender: false,                 // 控制Datatables的延迟渲染，可以提高初始化的速度
        info: true,                        // 控制是否显示表格左下角的信息
        lengthChange: true,                 // 是否允许用户改变表格每页显示的记录数
        ordering: false,                     // 排序
        paging: true,                       // 分页
        processing: true,                   // 是否显示正在处理的状态
        scrollX: true,                      // 水平滚动
        scrollY: false,
        fixedHeader: true,
        searching: true,                   // 是否允许Datatables开启本地搜索
        serverSide: true,                   // 是否开启服务器模式
        stateSave: false,                   // 状态保存 - 再次加载页面时还原表格状态
        ajax: {
            url: actionUrl,
            type: "POST",
            data: function(d){
            	alert(d.draw);
            	return preCondition;
            }
            	
            	
            	
            	,
            dataType: "json",
            contentType:"application/json; charset=UTF-8"
        },
                                // 请求数据
        deferLoading: null,                // 延迟请求加载服务端的数据，直到表格第二次绘制
        destroy: true,                    // 销毁已经存在的Datatables实例并替换新的选项
        orderCellsTop: true,               // 控制表头的哪一个cell可以应用于该列的排序响应
        orderClasses: true,                // 高亮显示在table的body中排序的列
        pageLength: 5,                    // 改变初始的页面长度(每页显示的记录数)
        pagingType: "simple_numbers",      // 分页按钮的显示方式
        renderer: "bootstrap",             // 显示组件的渲染方式
        scrollCollapse: false,              // 当显示更少的记录时，是否允许表格减少高度
        oLanguage: {
            "sProcessing": "数据加载中……",
            "sSearch": "快速检索:",
            "sLengthMenu": "每页显示 _MENU_ 条",
            "sInfo": "从 _START_ 到 _END_ 条，总共 _TOTAL_ 条记录",
            "sZeroRecords": "没有记录",
            "sInfoEmpty": "暂无记录",
            "sInfoFiltered": "(一共有 _MAX_  条记录)",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 末页 "
            }
        },
        columns: tableColumns,
        buttons: [{
			"extend": "colvis",
			"text": "<i class='fa fa-search bigger-110 blue'></i> <span class='show'>显示/隐藏 列</span>",
			"className": "btn btn-sm  btn-white btn-round",
			columns: ':not(:first):not(:last)'
		  },
		  {
			"extend": "copy",
			"text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='show'>复制到剪贴板</span>",
			"className": "btn btn-sm  btn-white btn-round"
		  },
		  {
			"extend": "csv",
			"text": "<i class='fa fa-database bigger-110 orange'></i> <span class='show'>导出csv</span>",
			"className": "btn btn-sm  btn-white btn-round"
		  },
		  {
			"extend": "excel",
			"text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='show'>导出Excel</span>",
			"className": "btn btn-sm  btn-white btn-round"
		  },
		  {
			"extend": "print",
			"text": "<i class='fa fa-print bigger-110 grey'></i> <span class='show'>打印</span>",
			"className": "btn btn-sm  btn-white btn-round",
			autoPrint: false,
			message: 'This print was produced using the Print button for DataTables'
		  }],
        "lengthMenu": [
            [5, 10, 15, 20, -1],
            [5, 10, 15, 20, "All"] // change per page values here
        ],
        "dom": "<'row' <'col-md-12'B>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>"
   });

    return showTable;
}

// 获取form表单的所有项目拼接json
function searchData() {
    var searchArr = new Object();
    var a = $("#searchForm");
    var serializeObj = {};
    var result ={};
    var array = a.serializeArray();
    var str = a.serialize();
    $(array).each(function () {
        if (serializeObj[this.name]) {
            if ($.isArray(serializeObj[this.name])) {
                serializeObj[this.name].push(this.value);
            } else {
                serializeObj[this.name] = [serializeObj[this.name], this.value];
            }
        } else {
            serializeObj[this.name] = this.value;
        }
    });
    //return $("#departmentId").find("option:checked").attr('value');
    result["queryParams"]=serializeObj;
    return serializeObj;
};

//excel 导出
var idTmr;
function getExplorer() {
    var explorer = window.navigator.userAgent;
    //ie  Edge
    if (explorer.indexOf("MSIE") >= 0 || (explorer.indexOf("Windows NT 6.1;") >= 0 && explorer.indexOf("Trident/7.0;") >= 0)) {
        return 'ie';
    }
        //firefox  
    else if (explorer.indexOf("Firefox") >= 0) {
        return 'Firefox';
    }
        //Chrome  
    else if (explorer.indexOf("Chrome") >= 0) {
        return 'Chrome';
    }
        //Opera  
    else if (explorer.indexOf("Opera") >= 0) {
        return 'Opera';
    }
        //Safari  
    else if (explorer.indexOf("Safari") >= 0) {
        return 'Safari';
    }
}
function exportExcel(tableId, fileName) {
    if (getExplorer() == 'ie') {
        var curTbl = document.getElementById(tableId);
        var oXL = new ActiveXObject("Excel.Application");
        var oWB = oXL.Workbooks.Add();
        var xlsheet = oWB.Worksheets(1);
        var sel = document.body.createTextRange();
        sel.moveToElementText(curTbl);
        sel.select();
        sel.execCommand("Copy");
        xlsheet.Paste();
        oXL.Visible = true;

        try {
            var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
        } catch (e) {
            print("Nested catch caught " + e);
        } finally {
            oWB.SaveAs(fname);
            oWB.Close(savechanges = false);
            oXL.Quit();
            oXL = null;
            idTmr = window.setInterval("Cleanup();", 1);
        }

    }
    else {
        tableToExcel(tableId, fileName)
    }
}
function Cleanup() {
    window.clearInterval(idTmr);
    CollectGarbage();
}
var tableToExcel = (function () {
    var uri = 'data:application/vnd.ms-excel;base64,',
    template = '<html><head><meta charset="UTF-8"></head><body><p id="headTitle" class="text-center" style="font-weight:bold;font-size:200%;font-family:KaiTi;">{p}</p><table border="1" cellspacing="1">{table}</table></body></html>',
    base64 = function (s) { return window.btoa(unescape(encodeURIComponent(s))) },
    format = function (s, c) {
        return s.replace(/{(\w+)}/g,
        function (m, p) { return c[p]; })
    }
    
    
    return function (table, name) {
        if (!table.nodeType) table = document.getElementById(table)
        p = $(table).parents().prev("#headTitle")[0];
        var title = "";
        if (p != undefined) {
            title = p.innerHTML
        }
        var ctx = { worksheet: name || 'Worksheet', title: title, table: table.innerHTML }
        //window.location.href = uri + base64(format(template, ctx))
        var tdCount = $(table).DataTable().columns()[0].length
        template = '<html><head><meta charset="UTF-8"></head><body><table border="1" cellspacing="1"><tr><td align="center" style="font-weight:bold;font-size:200%;font-family:KaiTi;" colspan="' + tdCount + '">{title}</td></tr></table><table border="1" cellspacing="1">{table}</table></body></html>';
        var downloadLink = document.createElement("a");
        downloadLink.href = uri + base64(format(template, ctx))
        if (title != "") {
            name = title;
        }
        downloadLink.download = name + ".xls";
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);

    }
})();