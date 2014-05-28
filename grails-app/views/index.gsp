<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="imms"/>
		<title>Asset List</title>
	</head>
	<body>
    <div class="row" id="message-section">

    </div>
    <div class="row" id="content-section">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#list-section" data-toggle="tab">List of Data</a></li>
            <li><a href="#detail-section" data-toggle="tab">Selected Item's Detail</a></li>
        </ul>
        <div class="tab-content">
            <div id="list-section" class="tab-pane active col-md-12">
                %{--new App.view.TableRegion( el: '#list-section', key: 'Asset' )--}%
                <div class="row buttons" style="margin-top: 10px">
                    <div class="col-md-4 col-centered">
                        <bt:create/>
                        <bt:show/>
                        <bt:delete/>
                    </div>
                </div>
                <div class="row">
                    <dt:table key='Asset'/>
                </div>
            </div>
            <div id="detail-section" class="tab-pane col-md-12">
                <div class="col-md-3">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="#form1" data-toggle="pill">Asset Static Data</a></li>
                        <li><a href="#form2" data-toggle="pill">Asset Real Time Data</a></li>
                    </ul>
                </div>
                <div class="tab-content col-md-9">
                    <div class="tab-pane active" id="form1">...form1</div>
                    <div class="tab-pane" id="form2">... form 2</div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" charset="utf-8">
        $(document).ready(function() {
            new App.view.TableRegion( {el: '#list-section', key: 'Asset'} );
        } );
    </script>
	</body>
</html>
