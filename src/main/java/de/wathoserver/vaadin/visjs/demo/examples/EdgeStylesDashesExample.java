package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;

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
    {id: 6, label: 'Node 6'}
  ]);

  // create an array with edges
  var edges = new vis.DataSet([
    {from: 1, to: 3, dashes:true},
    {from: 1, to: 2, dashes:[5,5]},
    {from: 2, to: 4, dashes:[5,5,3,3]},
    {from: 2, to: 5, dashes:[2,2,10,10]},
    {from: 2, to: 6, dashes:false},
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
public class EdgeStylesDashesExample extends AbstractExample {

  private final NetworkDiagram nd;

  public EdgeStylesDashesExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Node 1");
    final Node node2 = new Node("2", "Node 2");
    final Node node3 = new Node("3", "Node 3");
    final Node node4 = new Node("4", "Node 4");
    final Node node5 = new Node("5", "Node 5");
    final Node node6 = new Node("6", "Node 6");

    nd = new NetworkDiagram();
    nd.diagramSetSize("600px", "400px");
    nd.setNodes(node1, node2, node3, node4, node5, node6);

    nd.setEdges( //
        new Edge("1", "3", Edge.builder().withDashes(true)),
        new Edge("1", "2", Edge.builder().withDashes(new Integer[] {5, 5})),
        new Edge("2", "4", Edge.builder().withDashes(new Integer[] {5, 5, 3, 3})),
        new Edge("2", "5", Edge.builder().withDashes(new Integer[] {2, 2, 10, 10})),
        new Edge("2", "6", Edge.builder().withDashes(false)));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
