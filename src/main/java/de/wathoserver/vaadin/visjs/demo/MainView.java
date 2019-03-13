package de.wathoserver.vaadin.visjs.demo;

import com.github.appreciated.demo.helper.DemoHelperView;
import com.github.appreciated.demo.helper.view.devices.DeviceSwitchView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.github.appreciated.demo.helper.view.paragraph.ImageParagraphView;
import com.github.appreciated.prism.element.Language;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import de.wathoserver.vaadin.visjs.demo.examples.SimpleExample;
import de.wathoserver.vaadin.visjs.demo.showcase.views.IntroductionView;

@SuppressWarnings("serial")
@Route()
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@PWA(name = "Demoapplication for Vis.js Vaadin Component", shortName = "VisJsVaadinComponentDemo")
public class MainView extends DemoHelperView {

  public static final String RELEASE = "1.0.0";

  public MainView() {
    withHorizontalHeader("Demoapplication for Vis.js Vaadin Component", RELEASE, "icons/icon.png") //
        .withParagraph("Simple Demo", createSimpleDemo()) //
        .with(createShowcaseParagraph()).withParagraph("Usage")
        .withStep("Install", "Add to your pom.xml, check latest version on vaadin directory",
            new CodeExample(
                "<dependency>\n" + "   <groupId>de.wathoserver.vaadin</groupId>\n"
                    + "   <artifactId>visjs-vaadin-component</artifactId>\n" + "   <version>"
                    + RELEASE + "</version>\n" + "</dependency>\n\n" + "<repository>\n"
                    + "   <id>vaadin-addons</id>\n"
                    + "   <url>http://maven.vaadin.com/vaadin-addons</url>\n" + "</repository>",
                Language.markup, "Maven"))
        .withStep("Create Component", "Create Component and set properties",
            new CodeExample("NetworkDiagram nd = new NetworkDiagram(\n"
                + "        Options.builder().withWidth(\"100%\").withHeight(\"100%\").withAutoResize(true).build());",
                Language.java, "Java"))
        .withStep("Add Nodes", "Add dataprovider or with var-args",
            new CodeExample("// Set Nodes with var-args\n"
                + "nd.setNodes(new Node(\"1\", \"Label 1\"), new Node(\"2\", \"Label 2\"), new Node(\"3\", \"Label 3\"),\n"
                + "    new Node(\"4\", \"Label 4\"));" + "// or as Collection"
                + "Set<Nodes> nodes = new HashSet<>();\n" + "// fill collection and set as nodes\n"
                + "nd.setNodes(nodes);\n" + "// or with DataProvider\n"
                + "DataProvider<Node, Void> nodeDataProvider = \n"
                + "    DataProvider.fromCallbacks(q -> getNodes(), q -> getNodesCount());\n"
                + "nd.setNodesDataProvider(nodeDataProvider);", Language.java, "Java"))
        .withStep("Add Edges", "Add dataprovider or with var-args",
            new CodeExample("// Set Edges with var-args\n"
                + "nd.setEdges(new Edge(\"1\", \"2\"), new Edge(\"2\", \"3\"), new Edge(\"3\", \"4\"),\n"
                + "    new Edge(\"4\", \"2\"));" + "// or as Collection"
                + "Set<Edges> edges = new HashSet<>();\n" + "// fill collection and set as edges \n"
                + "nd.setEdges(edges);\n" + "// or with DataProvider\n"
                + "DataProvider<Edge, Void> edgeDataProvider =\n"
                + "    DataProvider.fromCallbacks(q -> getEdges(), q -> getEdgesCount());\n"
                + "nd.setEdgesDataProvider(edgeDataProvider);", Language.java, "Java"))
        .withStep("Listen to events",
            "Event data is currently only available as json. See http://visjs.org/docs/network/#Events for available events and the corresponding event data.",
            new CodeExample("// Add Listener\n"
                + "nd.addSelectNodeListener(event -> Notification.show(event.getParams().toJson()));",
                Language.java, "Java"))
        .withParagraph("Ressources",
            new Div(new Anchor("https://vaadin.com/directory/component/visjs-vaadin-component",
                "Vaadin Directory")),
            new Div(new Anchor("https://github.com/watho/vaadin-flow-visjs", "Github")),
            new Div(new Anchor("https://visjs.org", "Vis.js")))
        .withParagraph("Acknowledgements",
            new Div(new Div(new Text("This Page is created with "),
                new Anchor("https://vaadin.com/directory/component/demohelperview",
                    "Component DemoHelperView"),
                new Text(" by Johannes Goebel"))));
  }

  private Component createShowcaseParagraph() {
    final ImageParagraphView p = new ImageParagraphView("Vis.js examples",
        "Tries to recreate all original Vis.js examples. Currently 17 of 61 examples are implemented.",
        "frontend/img/showcase.png");
    p.getImage().getStyle().set("border", "1px gray solid");
    p.getTextWrapper()
        .add(new Button("Open Showcase", e -> UI.getCurrent().navigate(IntroductionView.class)));
    return p;
  }

  private Component createSimpleDemo() {

    return new VerticalLayout(new DeviceSwitchView(new SimpleExample()),
        new CodeExampleView(new CodeExample(SimpleExample.class)));
  }

}
