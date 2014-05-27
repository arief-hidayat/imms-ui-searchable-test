// override default settings here
//
//= require core.settings
//= require_self

//App.options.language = "en";
//App.css.selected = 'warning';

App.dt.config.table = {
    Asset : {
        columns : [ { "data": "code" }, { "data": "name" }, { "data": "assetType" }, { "data": "status" }, { "data": "locationCd" }]
//        , order : [[1, 'asc']]
    }
};

App.dt.config.customUrl = {
//        asset : {
//            url : "only for custom",
//            extraParams : function(request) { }
//        }
};