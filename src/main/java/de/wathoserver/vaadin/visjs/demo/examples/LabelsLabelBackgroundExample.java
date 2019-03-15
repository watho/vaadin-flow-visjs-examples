package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Font;

/**
 * <pre>
<script type="text/javascript">
 // create an array with nodes
  var nodes = [
    {id: 1, label: 'Node 1', font: {background: 'red'}},
    {id: 2, label: 'Node 2', font: {background: 'white'}},
    {id: 3, label: 'Node 3', font: {background: 'cyan'}},
    {id: 4, label: 'Node 4', font: {background: 'lime'}},
    {id: 5, label: 'Node 5', font: {background: 'pink'}}
  ];

  // create an array with edges
  var edges = [
    {from: 1, to: 2, label: 'label1', font: {background: '#ff0000'}},
    {from: 1, to: 3, label: 'label2', font: {background: 'yellow'}},
    {from: 2, to: 4, label: 'label3', font: {background: 'lime'}},
    {from: 2, to: 5, label: 'label3', font: {background: 'pink'}}
  ];

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {nodes:{font:{strokeWidth:0}}, edges:{font:{strokeWidth:0}}};
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
public class LabelsLabelBackgroundExample extends AbstractExample {

  private final NetworkDiagram nd;

  public LabelsLabelBackgroundExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Node 1",
        Node.builder().withFont(Font.builder().withBackground("red").build()));
    final Node node2 = new Node("2", "Node 2",
        Node.builder().withFont(Font.builder().withBackground("white").build()));
    final Node node3 = new Node("3", "Node 3",
        Node.builder().withFont(Font.builder().withBackground("cyan").build()));
    final Node node4 = new Node("4", "Node 4",
        Node.builder().withFont(Font.builder().withBackground("lime").build()));
    final Node node5 = new Node("5", "Node 5",
        Node.builder().withFont(Font.builder().withBackground("pink").build()));

    nd = new NetworkDiagram(
        Options.builder()
            .withNodes(Nodes.builder().withFont(Font.builder().withStrokeWidth(0).build())//
                .build())
            .withEdges(Edges.builder().withFont(Font.builder().withStrokeWidth(0).build())//
                .build())
            .build());
    nd.diagramSetSize("600px", "600px");
    nd.setNodes(node1, node2, node3, node4, node5);

    nd.setEdges( //
        new Edge("1", "2",
            Edge.builder().withLabel("label1")
                .withFont(Font.builder().withBackground("#ff0000").build())),
        new Edge("1", "3",
            Edge.builder().withLabel("label2")
                .withFont(Font.builder().withBackground("yellow").build())),
        new Edge("2", "4",
            Edge.builder().withLabel("label3")
                .withFont(Font.builder().withBackground("lime").build())),
        new Edge("2", "5", Edge.builder().withLabel("label4")
            .withFont(Font.builder().withBackground("pink").build())));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
