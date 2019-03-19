package de.wathoserver.vaadin.visjs.demo.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
  // create some nodes
      var nodes = [
        {id: 1, label: 'Node in\nthe center', shape: 'text', font:{strokeWidth:4}},
        {id: 2, label: 'Node\nwith\nmultiple\nlines', shape: 'circle'},
        {id: 3, label: 'This is a lot of text\nbut luckily we can spread\nover multiple lines', shape: 'database'},
        {id: 4, label: 'This is text\non multiple lines', shape: 'box'},
        {id: 5, label: 'Little text', shape: 'ellipse'}
      ];

      // create some edges
      var edges = [
        {from: 1, to: 2, color: 'red', width: 3, length: 200}, // individual length definition is possible
        {from: 1, to: 3, dashes:true, width: 1, length: 200},
        {from: 1, to: 4, width: 1, length: 200, label:'I\'m an edge!'},
        {from: 1, to: 5, arrows:'to', width: 3, length: 200, label:'arrows\nare cool'}
      ];

      // create a network
      var container = document.getElementById('mynetwork');
      var data = {
        nodes: nodes,
        edges: edges
      };
      var options = {};
      var network = new vis.Network(container, data, options);
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class LabelsLabelMultilineTextExample extends AbstractExample {

  private final NetworkDiagram nd;
  ObjectMapper mapper = new ObjectMapper();

  public LabelsLabelMultilineTextExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Node in\nthe center",
        Node.builder().withShape(Shape.text).withFont(Font.builder().withStrokeWidth(4).build()));
    final Node node2 =
        new Node("2", "Node\nwith\nmultiple\nlines", Node.builder().withShape(Shape.circle));
    final Node node3 =
        new Node("3", "This is a lot of text\nbut luckily we can spread\nover multiple lines",
            Node.builder().withShape(Shape.database));
    final Node node4 =
        new Node("4", "This is text\non multiple lines", Node.builder().withShape(Shape.box));
    final Node node5 = new Node("5", "Little text", Node.builder().withShape(Shape.ellipse));

    nd = new NetworkDiagram();
    nd.setSize("600px", "600px");
    nd.setNodes(node1, node2, node3, node4, node5);

    nd.setEdges( //
        new Edge("1", "2", Edge.builder().withColor("red").withWidth(3.0)//
            .withLength(200)), // individal length definition possible
        new Edge("1", "3", Edge.builder().withDashes(true).withWidth(1.0).withLength(200)),
        new Edge("1", "4", Edge.builder().withLabel("I'm an edge!").withWidth(1.0).withLength(200)),
        new Edge("1", "5",
            Edge.builder().withLabel("arrows\nare cool").withArrows("to").withWidth(3.0)
                .withLength(200)));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
