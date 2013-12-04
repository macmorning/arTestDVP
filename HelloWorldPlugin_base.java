import com.remedy.arsys.plugincontainer.DefinitionFactory;
import com.remedy.arsys.plugincontainer.NoPermissionException;
import com.remedy.arsys.plugincontainer.Plugin;
import com.remedy.arsys.plugincontainer.PluginConfig;
import com.remedy.arsys.plugincontainer.PluginContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldPlugin implements Plugin {
    public void init(PluginConfig config) {
    }
    public void processRequest(PluginContext pc) throws IOException, NoPermissionException    {
        HttpServletResponse response = pc.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Hello World Plugin Example</title></head>");
        writer.println("<body><h1>Hello World</h1></body></html>");
    }
    public String handleEvent(PluginContext pc, String eventType,String eventData) throws IOException, NoPermissionException {
         return "alert(\"Got event data in Midtier as " + eventData + "\");"; 
    }
    public DefinitionFactory getDefinitionFactory() {
         return null;
    }
    public void cleanup() {}
}
