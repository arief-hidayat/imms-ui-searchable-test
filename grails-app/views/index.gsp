<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="imms"/>
		<title>Asset List</title>
	</head>
	<body>
    <dt:table id='asset-list' key='Asset'/>
    %{--<table id="asset-list" class="display" cellspacing="0" width="100%">--}%
        %{--<thead>--}%
        %{--<tr>--}%
            %{--<th>Code</th>--}%
            %{--<th>Name</th>--}%
            %{--<th>Type</th>--}%
            %{--<th>Status</th>--}%
            %{--<th>Location</th>--}%
        %{--</tr>--}%
        %{--</thead>--}%

        %{--<tfoot>--}%
        %{--<tr>--}%
            %{--<th>Code</th>--}%
            %{--<th>Name</th>--}%
            %{--<th>Type</th>--}%
            %{--<th>Status</th>--}%
            %{--<th>Location</th>--}%
        %{--</tr>--}%
        %{--</tfoot>--}%
    %{--</table>--}%
    <script type="text/javascript" charset="utf-8">
        $(document).ready(function() {
            new App.view.MultiSelectTable({el: '#asset-list', key:  "Asset"});
        } );
    </script>
	</body>
</html>
