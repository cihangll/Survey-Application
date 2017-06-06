<script type="text/javascript">
	$(document).ready(
			function() {
				var editorOptions = {
					showEmbededSurveyTab : true
				}; //see examples below
				var survey = new SurveyEditor.SurveyEditor(
						"surveyEditorContainer", editorOptions);
				//set function on save callback
				editor.saveSurveyFunc = saveMySurvey;
				editor.text = yourSurveyJSON;
			}

	);

	$(document).ready(function() {
		var yourNewSurveyJSON = editor.text;
		//send updated json in your storage
		alert(yourNewSurveyJSON);
		alert("Hello World!")
	});

	/* document.getElementById("completeSurvey").onclick = saveMySurvey; */
</script>
