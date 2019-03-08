package de.wathoserver.vaadin.visjs.demo.examples;

import com.github.appreciated.demo.helper.view.components.layout.SinglePageLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;

import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;

@SuppressWarnings("serial")
@SpringComponent
public class SimpleExample extends SinglePageLayout {

  public SimpleExample() {
    // Creating diagram object with options
    final NetworkDiagram nd = new NetworkDiagram(
        Options.builder().withWidth("100%").withHeight("100%").withAutoResize(true).build());
    // Set Nodes
    nd.setNodes(new Node("1", "Label 1"), new Node("2", "Label 2"), new Node("3", "Label 3"),
        new Node("4", "Label 4"));
    // Set Edges
    nd.setEdges(new Edge("1", "2"), new Edge("2", "3"), new Edge("2", "4"), new Edge("3", "1"));
    add(nd);
  }

}
