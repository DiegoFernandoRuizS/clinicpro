package app.hospital.uniandes.edu.co.clinic;

import com.cete.dynamicpdf.*;
import com.cete.dynamicpdf.pageelements.Label;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

public class PdfActivity extends Activity {
	private static String FILE = Environment.getExternalStorageDirectory()
			+ "/HelloWorld.pdf";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Create a document and set it's properties
		Document objDocument = new Document();
		objDocument.setCreator("PdfActivity.java");
		objDocument.setAuthor("Your Name");
		objDocument.setTitle("Hello World");

		// Create a page to add to the document
		Page objPage = new Page(PageSize.LETTER, PageOrientation.PORTRAIT,
				54.0f);

		// Create a Label to add to the page
		String strText = "Hello World...\nFrom DynamicPDF� Generator "
				+ "for Java\nDynamicPDF.com";
		Label objLabel = new Label(strText, 0, 0, 504, 100,
				Font.getHelvetica(), 18, TextAlign.CENTER);

		// Add label to page
		objPage.getElements().add(objLabel);

		// Add page to document
		objDocument.getPages().add(objPage);

		try {
			// Outputs the document to file
			objDocument.draw(FILE);
			Toast.makeText(this, "Recibo generado... :" + FILE,
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(this,
					"Error, en generar recibo\n" + e.getMessage(),
					Toast.LENGTH_LONG).show();
			System.out.println("Error ... Diego... : "+e.getMessage());
		}
	}
}