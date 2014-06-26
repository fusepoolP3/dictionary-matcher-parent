package eu.fusepoolp3.dictionarymatcher;

import eu.fusepool.extractor.sample.Arguments;
import eu.fusepool.extractor.server.ExtractorServer;
import org.wymiwyg.commons.util.arguments.ArgumentHandler;


public class Main 
{
    public static void main(String[] args) throws Exception {
        Arguments arguments = ArgumentHandler.readArguments(Arguments.class, args);
        if (arguments != null) {
            start(arguments);
        }
    }
    
    private static void start(Arguments arguments) throws Exception {
        ExtractorServer server = new ExtractorServer(arguments.getPort());

        DictionaryMatcher.getInstance();
        
        server.start(new DictionaryMatcherExtractor());

        server.join();
    }
}
