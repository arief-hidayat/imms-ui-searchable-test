<%@ page import="com.hida.imms.AssetType" %>
<% int tableWidth = grails.util.Holders.config.imms?.datatable?.singlepage?.width?.AssetType ?: 6 %>
<div class="row" id="content-section">
    <div id="list-section" class="col-md-${tableWidth}">%{--App.view.TableRegion--}%
        <div class="row buttons" style="margin-top: 10px">
            <div class="col-md-${tableWidth} col-centered">
                <bt:create value="__"></bt:create>
                <bt:show  value="__"></bt:show>
                <bt:delete  value="__"></bt:delete>
            </div>
        </div>

        <div class="row">
            <dt:table key='AssetType'/>%{-- App.view.Table--}%
        </div>
    </div>

    <div id="detail-section" class="col-md-${12 - tableWidth}">
        <div class="row buttons" style="margin-top: 20px">
        </div>
        <g:render template="partialCreate"/>
    </div>
</div>
</body>
</html>
