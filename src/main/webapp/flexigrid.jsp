<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
        <link href="js/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="js/jquery-ui/css/start/jquery-ui-1.9.2.custom.min.css" rel="stylesheet"/>
        <link href="js/jqGrid-4.4.1/css/ui.jqgrid.css" rel="stylesheet"/>

        <script src="js/jquery-1.8.3.js"></script>
        <script src="js/jquery-ui/js/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="js/jqGrid-4.4.1/js/jquery.jqGrid.min.js"></script>
        <script src="js/bootstrap/js/bootstrap.min.js"></script>

        <style>
            body {
                padding-top: 60px;
            }
        </style>
        <link href="js/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand">QMS 4</a>
                </div>
            </div>
        </div>
        <div class="container">
            <table id="data-grid"></table>
            <script>
                var gridOpt = {
                    datatype: "local",
                    height: 250,
                    colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
                    colModel:[
                        {name:'id',index:'id', width:60, sorttype:"int"},
                        {name:'invdate',index:'invdate', width:90, sorttype:"date"},
                        {name:'name',index:'name', width:100},
                        {name:'amount',index:'amount', width:80, align:"right",sorttype:"float"},
                        {name:'tax',index:'tax', width:80, align:"right",sorttype:"float"},		
                        {name:'total',index:'total', width:80,align:"right",sorttype:"float"},		
                        {name:'note',index:'note', width:150, sortable:false}		
                    ],
                    multiselect: true,
                    caption: "Manipulating Array Data"
                };
                
                $('#data-grid').jqGrid(gridOpt);
                
                var mydata = [
                    {id:"1",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
                    {id:"2",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
                    {id:"3",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
                    {id:"4",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
                    {id:"5",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
                    {id:"6",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
                    {id:"7",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
                    {id:"8",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
                    {id:"9",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"}
                ];
                for(var i=0;i<=mydata.length;i++)
                    $("#data-grid").jqGrid('addRowData',i+1,mydata[i]);
            </script>
        </div>
    </body>
</html>
