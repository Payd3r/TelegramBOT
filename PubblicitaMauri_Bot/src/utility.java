/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Payd3r
 */
public class utility {
      /*    
        //lettura di un file JSon
    
        InputStream is = url.openConnection().getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = null;
        String s = "";
        while ((line = reader.readLine()) != null) {
            s += line;
        }
    
        //parsing del file JSon
    
        JSONObject objs = new JSONObject(s);
        JSONArray arr = objs.getJSONArray("eventuale nome dell'array"); // può dover essere fatto prima
        if (!arr.isEmpty()) {
            for (int i = 0; i < arr.length(); i++) {
                JSONObject result = arr.getJSONObject(i);
                result.getJSONObject(" ").getString(" ");
            }
        }
    
        //scrittura file csv
    
        File file = new File("NomiCitta.csv");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scanner = new Scanner(file);
        StringBuffer stringBuffer = new StringBuffer();
        String rigaDaModificare = null;
        while (scanner.hasNextLine()) {
            String riga = scanner.nextLine();
            if (riga.contains(String.valueOf(id))) {
                rigaDaModificare = riga;
            }
            stringBuffer.append(riga + System.lineSeparator());
        }
        String contents = stringBuffer.toString();
        scanner.close();
        if (rigaDaModificare != null) {
            contents = contents.replaceAll(rigaDaModificare, id + ";" + first_name + ";" + second_name + ";" + latitudine + ";" + longitudine);
        } else {
            contents += id + ";" + first_name + ";" + second_name + ";" + latitudine + ";" + longitudine + System.lineSeparator();
        }
        contents = contents.trim();
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(contents);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        //lettura file csv    
    
        Files.readAllLines(Paths.get("NomiCitta.csv"))
        
        //operazioni con file XML
    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        var document = builder.parse("utl pagina XML");
        NodeList lista = document.getElementsByTagName("tag"); //salva lista di nodi        
        
        Node place = lista.item(0); //salva singolo nodo || lista.item(i);
        place.getAttributes();        
        String s = document.getElementsByTagName("place").item(0).getTextContent();//salvare il valore
        NamedNodeMap attr = document.getElementsByTagName("place").item(0).getAttributes(); //variabile per lavorare con gli attributi
        attr.getNamedItem("currency").getNodeValue(); //prendere valore di un attributo      
     */
}
