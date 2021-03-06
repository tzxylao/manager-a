<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout Layui</title>
    <link rel="stylesheet" href="${basePath!}/static/layui/css/layui.css">
    <script src="${basePath!}/static/layui/layui.js"></script>
</head>
<body class="layui-layout-body" style="padding: 10px">
<a class="layui-btn layui-btn-primary"  onclick="window.location.href='treeMenu.html';">刷新</a>
<a class="layui-btn layui-btn-primary"  onclick="add();">新增一行</a>
<a class="layui-btn layui-btn-primary"  onclick="print();">打印缓存对象</a>
<div>
    <table class="layui-hidden" id="treeTable" lay-filter="treeTable"></table>
</div>
<script>
    var editObj=null,ptable=null,treeGrid=null,tableId='treeTable',layer=null;
    layui.config({
        base: '${basePath!}/static/layui/extend/'
    }).extend({
        treeGrid:'treeGrid'
    }).use(['jquery','treeGrid','layer'], function(){
        var $=layui.jquery;
        treeGrid = layui.treeGrid;//很重要
        layer=layui.layer;
        ptable=treeGrid.render({
            id:tableId
            ,elem: '#'+tableId
            ,idField:'id'
            ,url:'../json/menu/summary'
            ,cellMinWidth: 100
            ,treeId:'id'//树形id字段名称
            ,treeUpId:'pId'//树形父id字段名称
            ,treeShowName:'name'//以树形式显示的字段
            ,cols: [[
                {width:100,title: '操作', align:'center'/*toolbar: '#barDemo'*/
                    ,templet: function(d){
                    var html='';
                    var addBtn='<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="add">添加</a>';
                    var delBtn='<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                    return addBtn+delBtn;
                }
                }
                ,{field:'name', edit:'text',width:300, title: '水果名称'}
                ,{field:'id',width:100, title: 'id'}
                ,{field:'pId', title: 'pid'}
            ]]
            ,page:false
        });

        treeGrid.on('tool('+tableId+')',function (obj) {
            if(obj.event === 'del'){//删除行
                del(obj);
            }else if(obj.event==="add"){//添加行
                add(obj.data);
            }
        });
    });

    function del(obj) {
        layer.confirm("你确定删除数据吗？如果存在下级节点则一并删除，此操作不能撤销！", {icon: 3, title:'提示'},
            function(index){//确定回调
                obj.del();
                layer.close(index);
            },function (index) {//取消回调
               layer.close(index);
            }
        );
    }


    var i=1000;
    //添加
    function add(pObj) {
        var param={};
        param.name='水果'+Math.random();
        param.id=++i;
        param.pId=pObj?pObj.id:0;
        treeGrid.addRow(tableId,pObj?pObj.LAY_TABLE_INDEX+1:0,param);
    }

    function print() {
        console.log(treeGrid.cache[tableId]);
        var loadIndex=layer.msg("对象已打印，按F12，在控制台查看！", {
            time:3000
            ,offset: 'auto'//顶部
            ,shade: 0
        });
    }
</script>
</body>
</html>