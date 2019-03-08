package de.wathoserver.vaadin.visjs.demo;

import com.github.appreciated.demo.helper.DemoHelperView;
import com.github.appreciated.demo.helper.view.devices.DeviceSwitchView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.github.appreciated.prism.element.Language;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

import de.wathoserver.vaadin.visjs.demo.examples.SimpleExample;
import de.wathoserver.vaadin.visjs.demo.showcase.views.IntroductionView;

@SuppressWarnings("serial")
@Route()
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@PWA(name = "Demoapplication for Vis.js Vaadin Component", shortName = "VisJsVaadinComponentDemo")
public class MainView extends DemoHelperView {

  public static final String RELEASE = "0.0.2";

  public MainView() {
    withHorizontalHeader("Demoapplication for Vis.js Vaadin Component", RELEASE, "icons/icon.png") //
        .withParagraph("Simple Demo", createSimpleDemo()) //
        .withParagraph("Vis.js examples", "Tries to recreate all original Vis.js examples.",
            new RouterLink("Vis.js showcase", IntroductionView.class)) //
        .withParagraph("Usage")
        .withStep("Install", "Add to your pom.xml, check latest version on vaadin directory",
            new CodeExample(
                "<dependency>\n" + "   <groupId>de.wathoserver.vaadin</groupId>\n"
                    + "   <artifactId>visjs-vaadin-component</artifactId>\n" + "   <version>"
                    + RELEASE + "</version>\n" + "</dependency>\n\n" + "<repository>\n"
                    + "   <id>vaadin-addons</id>\n"
                    + "   <url>http://maven.vaadin.com/vaadin-addons</url>\n" + "</repository>",
                Language.markup, "Maven"))
        .withStep("Create Component", "Create Component and set properties",
            new CodeExample("", Language.java, "Java"))
        .withStep("Add Nodes", "Add dataprovider or with var-args",
            new CodeExample("", Language.java, "Java"))
        .withStep("Add Edges", "Add dataprovider or with var-args",
            new CodeExample("", Language.java, "Java"))
        .withParagraph("Ressources", "",
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

  private Component createSimpleDemo() {

    return new VerticalLayout(new DeviceSwitchView(new SimpleExample()),
        new CodeExampleView(new CodeExample(SimpleExample.class)));
  }

}
