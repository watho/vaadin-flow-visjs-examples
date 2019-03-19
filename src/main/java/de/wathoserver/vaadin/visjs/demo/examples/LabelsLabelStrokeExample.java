package de.wathoserver.vaadin.visjs.demo.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
 // create an array with nodes
  var nodes = [
    {id: 1, label: 'Node 1', font: {strokeWidth: 3, strokeColor: 'white'}},
    {id: 2, label: 'Node 2'},
    {id: 3, label: 'Node 3'},
    {id: 4, label: 'Node 4'},
    {id: 5, label: 'Node 5'}
  ];

  // create an array with edges
  var edges = [
    {from: 1, to: 2, label: 'edgeLabel', font: {strokeWidth: 2, strokeColor : '#00ff00'}},
    {from: 1, to: 3, label: 'edgeLabel'},
    {from: 2, to: 4},
    {from: 2, to: 5}
  ];

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {
    nodes : {
      shape: 'dot',
      size: 10
    }
  };
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
public class LabelsLabelStrokeExample extends AbstractExample {

  private final NetworkDiagram nd;
  ObjectMapper mapper = new ObjectMapper();

  public LabelsLabelStrokeExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Node 1", Node.builder()
        .withFont(Font.builder().withStrokeWidth(3).withStrokeColor("white").build()));
    final Node node2 = new Node("2", "Node 2");
    final Node node3 = new Node("3", "Node 3");
    final Node node4 = new Node("4", "Node 4");
    final Node node5 = new Node("5", "Node 5");

    nd = new NetworkDiagram(Options.builder()
        .withNodes(Nodes.builder().withShape(Shape.dot).withSize(10).build()).build());
    nd.setSize("600px", "600px");
    nd.getStyle().set("background", "#d1d1d1");
    nd.setNodes(node1, node2, node3, node4, node5);
    nd.setEdges( //
        new Edge("1", "2",
            Edge.builder().withLabel("edgeLabel")
                .withFont(Font.builder().withStrokeWidth(2).withStrokeColor("#00ff00").build())),
        new Edge("1", "3", "edgeLabel"), new Edge("2", "4"), new Edge("2", "5"));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
