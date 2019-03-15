package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Layout;

/**
 * <pre>
<script type="text/javascript">
  // create an array with nodes
  var nodes = new vis.DataSet([
    {id: 1, label: 'Node 1'},
    {id: 2, label: 'Node 2'},
    {id: 3, label: 'Node 3'},
    {id: 4, label: 'Node 4'},
    {id: 5, label: 'Node 5'}
  ]);

  // create an array with edges
  var edges = new vis.DataSet([
    {from: 1, to: 3},
    {from: 1, to: 2},
    {from: 2, to: 4},
    {from: 2, to: 5}
  ]);

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {layout:{randomSeed:2}};
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
@JavaScript("src/exampleUtil.js")
public class LayoutRandomSeedExample extends AbstractExample {

  private final NetworkDiagram nd;
  private final Options options;

  public LayoutRandomSeedExample() {
    // Set Nodes

    options = Options.builder().withLayout(Layout.builder().withRandomSeed(2).build()).build();
    nd = new NetworkDiagram(options);
    nd.setNodes(new Node("1", "Node 1"), new Node("2", "Node 2"), new Node("3", "Node 3"),
        new Node("4", "Node 4"), new Node("5", "Node 5"));
    nd.setEdges("1", "3", "1", "2", "2", "4", "2", "5");
    nd.diagramSetSize("600px", "400px");
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
