package app.hospital.uniandes.edu.co.clinic;

import com.cete.dynamicpdf.*;
import com.cete.dynamicpdf.pageelements.Label;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

public class BillActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Intent intent = getIntent();

		final String documento = intent.getStringExtra("documento");
		final String nombres = intent.getStringExtra("nombres");
		final String apellidos = intent.getStringExtra("apellidos");
		final String servicio = intent.getStringExtra("servicio");
		final Double costo = intent.getDoubleExtra("costo",0D);
		System.out.println("Llega el costo?------------------------------");
		System.out.println(costo);
		String FILE = Environment.getExternalStorageDirectory()
				+ "/recibo"+documento+".pdf";


		// Creando documento y configurando propiedades
		Document objDocument = new Document();
		objDocument.setCreator("BillActivity.java");
		objDocument.setAuthor("Diego F. Ruiz S.");
		objDocument.setTitle("Recibo servicio médico");

		// Creando una pagina para agregar al documento
		Page objPage = new Page(PageSize.LETTER, PageOrientation.PORTRAIT,
				54.0f);



		// Titulo para el recibo
		String strText = "Hospital ABC...\nRecibo de pago \n" +
				"Documento: "+documento +"\n"+
				"Nombres: "+nombres+" "+apellidos+"\n" +
				"Servicio: "+servicio+"\n" +
				"Costo: $ "+costo;

		Label objLabel = new Label(strText, 0, 0, 504, 100,
				Font.getHelvetica(), 18, TextAlign.CENTER);

		// Agregando label to page
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
			System.out.println("Error generando recibo... : "+e.getMessage());
		}
	}
}