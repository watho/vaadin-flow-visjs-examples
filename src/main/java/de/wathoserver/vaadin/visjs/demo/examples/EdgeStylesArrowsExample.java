package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.edges.ArrowHead;
import de.wathoserver.vaadin.visjs.network.options.edges.Arrows;

/**
 * <pre>
<script type="text/javascript">
 // create an array with nodes
  var nodes = new vis.DataSet([
    {id: 1, label: 'Node 1'},
    {id: 2, label: 'Node 2'},
    {id: 3, label: 'Node 3'},
    {id: 4, label: 'Node 4'},
    {id: 5, label: 'Node 5'},
    {id: 6, label: 'Node 6'},
    {id: 7, label: 'Node 7'},
    {id: 8, label: 'Node 8'}
  ]);

  // create an array with edges
  var edges = new vis.DataSet([
    {from: 1, to: 8, arrows:'to', dashes:true},
    {from: 1, to: 3, arrows:'to'},
    {from: 1, to: 2, arrows:'to, from'},
    {from: 2, to: 4, arrows:'to, middle'},
    {from: 2, to: 5, arrows:'to, middle, from'},
    {from: 5, to: 6, arrows:{to:{scaleFactor:2}}},
    {from: 6, to: 7, arrows:{middle:{scaleFactor:0.5},from:true}}
  ]);

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
public class EdgeStylesArrowsExample extends AbstractExample {

  private final NetworkDiagram nd;

  public EdgeStylesArrowsExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Node 1");
    final Node node2 = new Node("2", "Node 2");
    final Node node3 = new Node("3", "Node 3");
    final Node node4 = new Node("4", "Node 4");
    final Node node5 = new Node("5", "Node 5");
    final Node node6 = new Node("6", "Node 6");
    final Node node7 = new Node("7", "Node 7");
    final Node node8 = new Node("8", "Node 8");

    nd = new NetworkDiagram();
    nd.setSize("600px", "400px");
    nd.setNodes(node1, node2, node3, node4, node5, node6, node7, node8);

    nd.setEdges( //
        new Edge("1", "8", Edge.builder().withArrows("to").withDashes(true)),
        new Edge("1", "3", Edge.builder().withArrows("to")),
        new Edge("1", "2", Edge.builder().withArrows("to, from")),
        new Edge("2", "4", Edge.builder().withArrows("to, middle")),
        new Edge("2", "5", Edge.builder().withArrows("to, middle, from")),
        new Edge("5", "6",
            Edge.builder().withArrows(
                Arrows.builder().withTo(ArrowHead.builder().withScaleFactor(2d).build()).build())),
        new Edge("6", "7", Edge.builder().withArrows(Arrows.builder()
            .withMiddle(ArrowHead.builder().withScaleFactor(0.5).build()).withFrom(true).build())));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
