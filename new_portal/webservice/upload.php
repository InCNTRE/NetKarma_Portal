<?php
/*
Server-side PHP file upload code for HTML5 File Drag & Drop demonstration
Featured on SitePoint.com
Developed by Craig Buckler (@craigbuckler) of OptimalWorks.net
*/
$fn = (isset($_SERVER['HTTP_X_FILENAME']) ? $_SERVER['HTTP_X_FILENAME'] : false);
$id = (isset($_SERVER['HTTP_X_EXP_ID']) ? $_SERVER['HTTP_X_EXP_ID'] : false);
$type = (isset($_SERVER['HTTP_X_FILETYPE']) ? $_SERVER['HTTP_X_FILETYPE'] : false);



if ($id) {
    mkdir ('uploads/' . $id);
}

if ($fn) {

	// AJAX call
	file_put_contents(
		'uploads/' . $id . '/' . $fn,
		file_get_contents('php://input')
	);
	echo "$fn uploaded";
        $output = shell_exec('injest.pl $id');
        echo $output; 
           
	exit();

}
else {

	// form submit
	$files = $_FILES['fileselect'];

	foreach ($files['error'] as $id => $err) {
		if ($err == UPLOAD_ERR_OK) {
			$fn = $files['name'][$id];
			move_uploaded_file(
				$files['tmp_name'][$id],
				'uploads/' . $id . '/' . $fn
			);
			echo "<p>File $fn uploaded.</p>";
		}
	}

}
