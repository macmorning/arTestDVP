import com.remedy.arsys.plugincontainer.DefinitionFactory;
import com.remedy.arsys.plugincontainer.NoPermissionException;
import com.remedy.arsys.plugincontainer.Plugin;
import com.remedy.arsys.plugincontainer.PluginConfig;
import com.remedy.arsys.plugincontainer.PluginContext;
import com.remedy.arsys.plugincontainer.PageService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;



public class HelloWorldPlugin implements Plugin {
    public void init(PluginConfig config) {
    }
    public void processRequest(PluginContext pc) throws IOException, NoPermissionException    {
   	PageService ps = pc.getPageService();
        HttpServletResponse response = pc.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
	writer.println("<html><head>");
	writer.println(ps.getEventInfrastructureCode());
	writer.println("<script>function sendMidTierEvent() {");
	writer.println("var result = "+ps.getEventDispatcherName()+".sendEventToMidTier(\"ClickEvent\",\"Title\");");
	writer.println("eval(result);");
	writer.println("};</script>");
	writer.println("<script src=\"http://js.nicedit.com/nicEdit-latest.js\" type=\"text/javascript\"></script>");
	writer.println("<script type=\"text/javascript\">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>");
	writer.println("</head>");
	writer.println("<body><textarea id='txtArea' style='width:90%;height:90%;'></textarea><button onclick=\"sendMidTierEvent();\">envoyer</button></body></html>");
    }
    public String handleEvent(PluginContext pc, String eventType,String eventData) throws IOException, NoPermissionException {
         return "alert(\"Got event data in Midtier as " + eventData + "\");"; 
    }
    public DefinitionFactory getDefinitionFactory() {
         return null;
    }
    public void cleanup() {}
}

