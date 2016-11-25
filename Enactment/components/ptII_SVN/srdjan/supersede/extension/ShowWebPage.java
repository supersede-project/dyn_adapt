package srdjan.supersede.extension;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ptolemy.actor.TypedAtomicActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.StringToken;
import ptolemy.data.expr.Parameter;
import ptolemy.data.type.BaseType;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;


import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;



public class ShowWebPage extends TypedAtomicActor {
/** Constructor */
public ShowWebPage(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
    super(container, name);
    trigger = new TypedIOPort(this, "trigger", true, false);
    initial=new Parameter(this, "initial", new IntToken(0));
    url=new Parameter(this, "url", new StringToken(""));
        
    output = new TypedIOPort(this, "output", false, true);
    output.setTypeEquals(BaseType.INT);
}
/** Ports and parameters. */
public TypedIOPort trigger, output;
public Parameter url, initial;

/** Action methods. */
public void initialize() throws IllegalActionException {
    super.initialize();
    _count = ((IntToken)initial.getToken()).intValue();
}
public void fire() throws IllegalActionException {
    
    
    //opening a URL in the browser from java 
    //String url_to_show = "http://localhost:4567/relay/https://nike.erd.siemens.at/supersede/getmeteorologicaldata/";
    String url_to_show = this.url.getValueAsString();
    url_to_show = url_to_show.substring(1, url_to_show.length()-1);
    if(Desktop.isDesktopSupported()){
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI(url_to_show));
        } catch (IOException | URISyntaxException e) {
            // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }else{
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("xdg-open " + url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

       
    super.fire();
    if (trigger.getWidth() > 0 && trigger.hasToken(0)) {
    trigger.get(0);
    }
    output.send(0, new IntToken(_count + 1));
}
public boolean postfire() throws IllegalActionException {
    _count += 1;
    return super.postfire();
}
private int _count = 0; /** Local variable. */

}
