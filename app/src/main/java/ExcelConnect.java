import android.os.AsyncTask;
import android.util.Log;

import com.example.mytestapplication.MainActivity;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.List;

import static com.example.mytestapplication.MainActivity.APPLICATION_NAME;

public class ExcelConnect extends AsyncTask<URL, Integer, Void> {

    private ValueRange response;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        final NetHttpTransport HTTP_TRANSPORT;
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            final String spreadsheetId = "1vX1RtgarEFQawzdeRBcp4f__aS7rtO0lkazvlrg7ik8";
            final String range = "Class Data!A2:E";
            Sheets service = new Sheets.Builder(HTTP_TRANSPORT, MainActivity.JSON_FACTORY, MainActivity.getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            response = service.spreadsheets().values()
                    .get(spreadsheetId, range)
                    .execute();

        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Void doInBackground(URL... urls) {
//        return null;
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
//            System.out.println("No data found.");
            Log.d("NoData", "No data found");
        } else {
//            System.out.println("Name, Major");
            Log.d("Data", "Name, Major");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
//                System.out.printf("%s, %s\n", row.get(0), row.get(4));
                Log.d("Rows", "\"%s, %s\\n\", row.get(0), row.get(4)");
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

}
