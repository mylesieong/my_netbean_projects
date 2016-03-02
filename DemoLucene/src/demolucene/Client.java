/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demolucene;

import java.io.IOException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

/**
 * This is a demo application of Lucene 5.3.1. It simply create a string text and put it into
 * the Document instance. And by indexing it with the IndexWriter, we use IndexSearcher
 * to get result.
 * @author Myles
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        /**
         * This simple example is copy from the official docmentation from lucene.apache.org,
         * This URL is: https://lucene.apache.org/core/5_3_1/core
         */
        
        /**
         * Create a document.
         */
        Document doc=new Document();
        String text= "Today is sunny. All works and no plays make Myles a dumb boy. So today Myles stop working.";
        doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
        
        /**
         * Setup the configuration of the IndexWriter.
         */
        Analyzer analyzer=new StandardAnalyzer();
        Directory directory=new RAMDirectory();//Store the index in memory, for creating and storing index files, use FSDirectory.
        IndexWriterConfig config=new IndexWriterConfig(analyzer);
        IndexWriter writer= new IndexWriter(directory, config);
        
        /**
         * Index the document create previously.
         */           
        writer.addDocument(doc);
        writer.close();
        
        /**
         * Search the keyword with IndexSearcher class.
         */
        DirectoryReader reader=DirectoryReader.open(directory); //directory stored the index directory.
        IndexSearcher searcher=new IndexSearcher(reader);
        QueryParser parser = new QueryParser ("fieldname",analyzer);
        Query query= parser.parse("Myles");
        ScoreDoc[] hits=searcher.search(query,null,1000).scoreDocs;
        
        /**
         * Iterate the resoult documents.
         */
        for (int i=0; i < hits.length ; i++){
            Document hitDoc=searcher.doc(hits[i].doc);
            System.out.println("The number "+(i+1)+" results found:");
            System.out.println(hitDoc.get("fieldname"));
        }
        reader.close();
        directory.close();
    }
}
