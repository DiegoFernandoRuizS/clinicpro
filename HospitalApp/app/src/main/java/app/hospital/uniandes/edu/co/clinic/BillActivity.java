package app.hospital.uniandes.edu.co.clinic;

import com.cete.dynamicpdf.*;
import com.cete.dynamicpdf.pageelements.Cell2;
import com.cete.dynamicpdf.pageelements.Column2;
import com.cete.dynamicpdf.pageelements.Label;
import com.cete.dynamicpdf.pageelements.Row2;
import com.cete.dynamicpdf.pageelements.Table2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import android.view.View;


import org.sufficientlysecure.htmltextview.HtmlTextView;

public class BillActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent intent = getIntent();

        final String documento = intent.getStringExtra("documento");
        final String nombres = intent.getStringExtra("nombres");
        final String apellidos = intent.getStringExtra("apellidos");
        final String servicio = intent.getStringExtra("servicio");
        final Double costo = intent.getDoubleExtra("costo", 0D);
        final String direccion = intent.getStringExtra("direccion");
        String FILE = Environment.getExternalStorageDirectory()
                + "/recibo" + documento + ".pdf";

        HtmlTextView text = (HtmlTextView) findViewById(R.id.html_text);

        // loads html from string and displays cat_pic.png from the app's drawable folder
        text.setHtmlFromString("<h2>Recibo generado</h2><ul><li>Para el servicio: " + servicio + "</li><li>Costo: " + costo + "</li></ul>", new HtmlTextView.LocalImageGetter());

        // Creando documento y configurando propiedades
        Document objDocument = new Document();
        objDocument.setCreator("BillActivity.java");
        objDocument.setAuthor("Diego F. Ruiz S.");
        objDocument.setTitle("Recibo servicio médico");

        // Creando una pagina para agregar al documento
        Page objPage = new Page(PageSize.LETTER, PageOrientation.PORTRAIT,
                54.0f);

        // Titulo para el recibo con los datos
        String strText = "Hospital ABC...\nRecibo de pago \n";

        Label objLabel = new Label(strText, 0, 0, 504, 100,
                Font.getHelvetica(), 18, TextAlign.CENTER);

        // Create a table
        Table2 table = new Table2(50, 50, 600, 600);

        //Add columns to the table
        Column2 column1 = table.getColumns().add(250);
        column1.getCellDefault().setAlign(TextAlign.CENTER);
        table.getColumns().add(150);

        // Add rows to the table and add cells to the rows
        Row2 row1 = table.getRows().add(40, Font.getHelveticaBold(), 16, Grayscale.getBlack(),
                Grayscale.getSilver());
        row1.getCellDefault().setAlign(TextAlign.CENTER);
        row1.getCellDefault().setVAlign(VAlign.CENTER);
        row1.getCells().add("Nombre del paciente");
        row1.getCells().add(nombres + " " + apellidos);

        Row2 row2 = table.getRows().add(30);
        Cell2 cell1 = row2.getCells().add("Documento del paciente", Font.getHelveticaBold(), 16,
                Grayscale.getBlack(), Grayscale.getWhite(), 1);
        cell1.setAlign(TextAlign.CENTER);
        cell1.setVAlign(VAlign.CENTER);
        row2.getCells().add(documento);


        Row2 row3 = table.getRows().add(30);
        Cell2 cell2 = row3.getCells().add("Dirección del paciente", Font.getHelveticaBold(), 16,
                Grayscale.getBlack(), Grayscale.getWhite(), 1);
        cell2.setAlign(TextAlign.CENTER);
        cell2.setVAlign(VAlign.CENTER);
        row3.getCells().add(direccion);

        Row2 row4 = table.getRows().add(30);
        Cell2 cell3 = row4.getCells().add("Nombre del servicio a pagar", Font.getHelveticaBold(), 16,
                Grayscale.getBlack(), Grayscale.getWhite(), 1);
        cell3.setAlign(TextAlign.CENTER);
        cell3.setVAlign(VAlign.CENTER);
        row4.getCells().add(servicio);

        Row2 row5 = table.getRows().add(30);
        Cell2 cell4 = row5.getCells().add("Total a pagar", Font.getHelveticaBold(), 16,
                Grayscale.getBlack(), Grayscale.getWhite(), 1);
        cell4.setAlign(TextAlign.CENTER);
        cell4.setVAlign(VAlign.CENTER);
        row5.getCells().add("$ " + costo);

        table.getBorder().getLeft().setLineStyle(LineStyle.getNone());
        table.getBorder().getRight().setLineStyle(LineStyle.getNone());


        // Agregando label to page
        objPage.getElements().add(objLabel);
        objPage.getElements().add(table);

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
            System.out.println("Error generando recibo... : " + e.getMessage());
        }
    }
}