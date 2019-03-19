package de.wathoserver.vaadin.visjs.demo.examples;

import java.util.Set;

import com.google.common.collect.Sets;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes.Builder;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
    // Create a data table with nodes.
      nodes = [];

      // Create a data table with links.
      edges = [];

      nodes.push({id: 1, label: 'Main', image: DIR + 'Network-Pipe-icon.png', shape: 'image'});
      nodes.push({id: 2, label: 'Office', image: DIR + 'Network-Pipe-icon.png', shape: 'image'});
      nodes.push({id: 3, label: 'Wireless', image: DIR + 'Network-Pipe-icon.png', shape: 'image'});
      edges.push({from: 1, to: 2, length: EDGE_LENGTH_MAIN});
      edges.push({from: 1, to: 3, length: EDGE_LENGTH_MAIN});

      for (var i = 4; i <= 7; i++) {
        nodes.push({id: i, label: 'Computer', image: DIR + 'Hardware-My-Computer-3-icon.png', shape: 'image'});
        edges.push({from: 2, to: i, length: EDGE_LENGTH_SUB});
      }

      nodes.push({id: 101, label: 'Printer', image: DIR + 'Hardware-Printer-Blue-icon.png', shape: 'image'});
      edges.push({from: 2, to: 101, length: EDGE_LENGTH_SUB});

      nodes.push({id: 102, label: 'Laptop', image: DIR + 'Hardware-Laptop-1-icon.png', shape: 'image'});
      edges.push({from: 3, to: 102, length: EDGE_LENGTH_SUB});

      nodes.push({id: 103, label: 'network drive', image: DIR + 'Network-Drive-icon.png', shape: 'image'});
      edges.push({from: 1, to: 103, length: EDGE_LENGTH_SUB});

      nodes.push({id: 104, label: 'Internet', image: DIR + 'System-Firewall-2-icon.png', shape: 'image'});
      edges.push({from: 1, to: 104, length: EDGE_LENGTH_SUB});

      for (var i = 200; i <= 201; i++ ) {
        nodes.push({id: i, label: 'Smartphone', image: DIR + 'Hardware-My-PDA-02-icon.png', shape: 'image'});
        edges.push({from: 3, to: i, length: EDGE_LENGTH_SUB});
      }

      // create a network
      var container = document.getElementById('mynetwork');
      var data = {
        nodes: nodes,
        edges: edges
      };
      var options = {};
      network = new vis.Network(container, data, options);
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class NodeStylesImagesExample extends AbstractExample {

  private final NetworkDiagram nd;
  private static final String IMAGEPATH = "frontend/img/hardware/";

  public NodeStylesImagesExample() {
    nd = new NetworkDiagram();
    nd.setSize("600px", "800px");

    // Set Nodes
    final Set<Node> nodes = Sets.newLinkedHashSet();
    final Set<Edge> edges = Sets.newLinkedHashSet();
    nodes.add(new Node("1", "Main",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "Network-Pipe-icon.png")));
    nodes.add(new Node("2", "Office",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "Network-Pipe-icon.png")));
    nodes.add(new Node("3", "Wireless",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "Network-Pipe-icon.png")));
    edges.add(new Edge("1", "2", Edge.builder().withLength(150)));
    edges.add(new Edge("1", "3", Edge.builder().withLength(150)));
    for (int i = 4; i <= 7; i++) {
      final Builder computerNodeBuilder = Node.builder().withShape(Shape.image)
          .withImage(IMAGEPATH + "Hardware-My-Computer-3-icon.png");
      nodes.add(new Node(String.valueOf(i), "Computer", computerNodeBuilder));
      edges.add(new Edge("2", String.valueOf(i), Edge.builder().withLength(50)));
    }
    nodes.add(new Node("101", "Printer", Node.builder()
        .withImage(IMAGEPATH + "Hardware-Printer-Blue-icon.png").withShape(Shape.image)));
    edges.add(new Edge("2", "101", Edge.builder().withLength(50)));

    nodes.add(new Node("102", "Laptop",
        Node.builder().withImage(IMAGEPATH + "Hardware-Laptop-1-icon.png").withShape(Shape.image)));
    edges.add(new Edge("3", "102", Edge.builder().withLength(50)));
    nodes.add(new Node("103", "network drive",
        Node.builder().withImage(IMAGEPATH + "Network-Drive-icon.png").withShape(Shape.image)));
    edges.add(new Edge("1", "103", Edge.builder().withLength(50)));
    nodes.add(new Node("104", "Internet",
        Node.builder().withImage(IMAGEPATH + "System-Firewall-2-icon.png").withShape(Shape.image)));
    edges.add(new Edge("1", "104", Edge.builder().withLength(50)));
    final Builder smartphoneNodeBuilder =
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "Hardware-My-PDA-02-icon.png");
    for (int i = 200; i <= 201; i++) {
      nodes.add(new Node(String.valueOf(i), "Smartphone", smartphoneNodeBuilder));
      edges.add(new Edge("3", String.valueOf(i), Edge.builder().withLength(50)));
    }
    nd.setNodes(nodes);
    nd.setEdges(edges);
    nd.addSelectNodeListener(ev -> Notification.show("node selected"));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
