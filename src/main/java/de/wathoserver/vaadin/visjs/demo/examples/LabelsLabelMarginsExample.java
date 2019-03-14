package de.wathoserver.vaadin.visjs.demo.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.nodes.Margin;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
 // create an array with nodes
  var nodes = [
    { id: 1, label: 'Default Value\n(5)', x: -150, y: -150 },
    { id: 2, label: 'Single Value\n(25)', margin: 20, x: 0, y: 0 },
    { id: 3, label: 'Different Values\n(10, 20, 40, 30)', margin: { top: 10, right: 20, bottom: 40, left: 30 }, x: 120, y: 120},
    { id: 4, label: 'A Negative Value\n(10, 20, 40, -50)', margin: { top: 10, right: 20, bottom: 30, left: -20 }, x: 300, y: -300}
  ];

  // create an array with edges
  var edges = [
    {from: 1, to: 2},
    {from: 2, to: 3},
    {from: 3, to: 4}
  ];

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {
    nodes: {
      shape: 'box'
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
public class LabelsLabelMarginsExample extends AbstractExample {

  private final NetworkDiagram nd;
  ObjectMapper mapper = new ObjectMapper();

  public LabelsLabelMarginsExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Default Value\n(5)", Node.builder().withx(-150).withy(-150));
    final Node node2 =
        new Node("2", "Single Value\n(25)",
        Node.builder().withMargin(20).withx(0).withy(0));
    final Node node3 = new Node("3", "Different Value\n(10, 20, 40, 30)",
        Node.builder()
            .withMargin(
                Margin.builder().withTop(10).withRight(20).withBottom(40).withLeft(30).build())
            .withx(120).withy(120));
    final Node node4 = new Node("4", "A negative Value\n(10, 20, 40, -50)", Node.builder()
        .withMargin(Margin.builder().withTop(10).withRight(20).withBottom(30).withLeft(-20).build())
        .withx(300).withy(-300));

    nd = new NetworkDiagram(Options.builder().withNodes(//
        Nodes.builder().withShape(Shape.box).build()) //
        .build());
    nd.diagramSetSize("600px", "600px");
    nd.setNodes(node1, node2, node3, node4);
    nd.setEdges( //
        new Edge("1", "2"), new Edge("2", "3"), new Edge("3", "4"));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
