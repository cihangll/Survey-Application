<script type="text/javascript">
	$(document).ready(function() {
		Survey.Survey.cssType = "bootstrap";
		var surveyJSON = ${surveyJsonVal}
		
		function sendDataToServer(survey) {
			//send Ajax request to your web server.
			alert("The results are:" + JSON.stringify(s.data));
		}

		var survey = new Survey.Model(surveyJSON);
		$("#surveyContainer").Survey({
			model : survey,
			onComplete : sendDataToServer
		});
	});
</script>
