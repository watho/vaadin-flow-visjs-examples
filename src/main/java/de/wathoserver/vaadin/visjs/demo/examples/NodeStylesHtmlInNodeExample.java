package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes.Builder;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;
import de.wathoserver.vaadin.visjs.network.options.physics.Stabilization;
import de.wathoserver.vaadin.visjs.network.util.Shape;

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
   {from: 2, to: 5},
   {from: 3, to: 3}
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
public class NodeStylesHtmlInNodeExample extends AbstractExample {

  private final NetworkDiagram nd;

  public NodeStylesHtmlInNodeExample() {
    nd = new NetworkDiagram(Options.builder()
        .withPhysics(Physics.builder()
            .withStabilization(Stabilization.builder().withEnabled(false).build()).build())
        .withEdges(Edges.builder().withSmooth(false).build()).build());
    nd.setSize("600px", "600px");
    // Set Nodes
    final Builder builder =
        Node.builder().withShape(Shape.image).withImage("frontend/img/svg/label.svg");
    nd.setNodes(new Node("1", builder), new Node("2", builder));
    // Set Edges
    nd.setEdges(new Edge("1", "2", Edge.builder().withLength(300)));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
