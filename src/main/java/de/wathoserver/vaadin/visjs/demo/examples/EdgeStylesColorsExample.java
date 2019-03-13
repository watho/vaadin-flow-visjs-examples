package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.EdgeColor;
import de.wathoserver.vaadin.visjs.network.options.edges.EdgeColor.Inherit;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
 // create an array with nodes
  var nodes = new vis.DataSet([
    {id: 1, label: 'node\none', shape: 'box', color:'#97C2FC'},
    {id: 2, label: 'node\ntwo', shape: 'circle', color:'#FFFF00'},
    {id: 3, label: 'node\nthree', shape: 'diamond', color:'#FB7E81'},
    {id: 4, label: 'node\nfour', shape: 'dot', size: 10, color:'#7BE141'},
    {id: 5, label: 'node\nfive', shape: 'ellipse', color:'#6E6EFD'},
    {id: 6, label: 'node\nsix', shape: 'star', color:'#C2FABC'},
    {id: 7, label: 'node\nseven', shape: 'triangle', color:'#FFA807'},
    {id: 8, label: 'node\neight', shape: 'triangleDown', color:'#6E6EFD'}
  ]);

  // create an array with edges
  var edges = new vis.DataSet([
    {from: 1, to: 8, color:{color:'red'}},
    {from: 1, to: 3, color:'rgb(20,24,200)'},
    {from: 1, to: 2, color:{color:'rgba(30,30,30,0.2)', highlight:'blue'}},
    {from: 2, to: 4, color:{inherit:'to'}},
    {from: 2, to: 5, color:{inherit:'from'}},
    {from: 5, to: 6, color:{inherit:'both'}},
    {from: 6, to: 7, color:{color:'#ff0000', opacity:0.3}},
    {from: 6, to: 8, color:{opacity:0.3}},
  ]);

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {
    nodes: {
      shape: 'circle'
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
public class EdgeStylesColorsExample extends AbstractExample {

  private final NetworkDiagram nd;

  public EdgeStylesColorsExample() {
    // Set Nodes
    final Node node1 =
        new Node("1", "Node\none", Node.builder().withShape(Shape.box).withColor("#97C2FC"));
    final Node node2 =
        new Node("2", "Node\ntwo", Node.builder().withShape(Shape.circle).withColor("#FFFF00"));
    final Node node3 =
        new Node("3", "Node\nthree", Node.builder().withShape(Shape.diamond).withColor("#FB7E81"));
    final Node node4 =
        new Node("4", "Node\nfour",
            Node.builder().withShape(Shape.dot).withSize(10).withColor("#7BE141"));
    final Node node5 =
        new Node("5", "Node\nfive", Node.builder().withShape(Shape.ellipse).withColor("#6E6EFD"));
    final Node node6 =
        new Node("6", "Node\nsix", Node.builder().withShape(Shape.star).withColor("#C2FABC"));
    final Node node7 =
        new Node("7", "Node\nseven", Node.builder().withShape(Shape.triangle).withColor("#FFA807"));
    final Node node8 = new Node("8", "Node\neight",
        Node.builder().withShape(Shape.triangleDown).withColor("#6E6EFD"));

    nd = new NetworkDiagram(
        Options.builder().withNodes(Nodes.builder().withShape(Shape.circle).build()).build());
    nd.diagramSetSize("600px", "400px");
    nd.setNodes(node1, node2, node3, node4, node5, node6, node7, node8);

    nd.setEdges( //
        new Edge("1", "8", Edge.builder().withColor(EdgeColor.builder().withColor("red").build())), //
        new Edge("1", "3", Edge.builder().withColor("rgb(20,24,200)")), //
        new Edge("1", "2",
            Edge.builder().withColor(
                EdgeColor.builder().withColor("rgba(30,30,30,0.2)").withHighlight("blue").build())), //
        new Edge("2", "4",
            Edge.builder().withColor(EdgeColor.builder().withInherit(Inherit.to).build())), //
        new Edge("2", "5",
            Edge.builder().withColor(EdgeColor.builder().withInherit(Inherit.from).build())), //
        new Edge("5", "6",
            Edge.builder().withColor(EdgeColor.builder().withInherit(Inherit.both).build())), //
        new Edge("6", "7",
            Edge.builder()
                .withColor(EdgeColor.builder().withColor("#ff0000").withOpacity(0.3).build())), //
        new Edge("6", "8", Edge.builder().withColor(EdgeColor.builder().withOpacity(0.3).build())));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
