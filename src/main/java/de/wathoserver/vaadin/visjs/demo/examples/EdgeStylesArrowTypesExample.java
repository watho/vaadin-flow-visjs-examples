package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.edges.ArrowHead;
import de.wathoserver.vaadin.visjs.network.options.edges.ArrowHead.Type;
import de.wathoserver.vaadin.visjs.network.options.edges.Arrows;

/**
 * <pre>
<script type="text/javascript">
 // create an array with nodes
  var nodes = new vis.DataSet([
    {id: 1, label: 'A'},
    {id: 2, label: 'B'},
    {id: 3, label: 'C'},
    {id: 4, label: 'D'}
  ]);

  // create an array with edges
  var edges = new vis.DataSet([
    {from: 1, to: 2, arrows:'to'},
    {from: 2, to: 3, arrows:{
      to: {
        enabled: true,
        type: 'circle'
      }
    }},
    {from: 3, to: 4, arrows:{
      to: {
        enabled: true,
        type: 'bar'
      }
    }},
  ]);

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };

  var options = {
/*
    // Enable this to make the endpoints smaller/larger
    edges: {
      arrows: {
        to: {
          scaleFactor: 5
        }
      }
    }
/
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
public class EdgeStylesArrowTypesExample extends AbstractExample {

  private final NetworkDiagram nd;

  public EdgeStylesArrowTypesExample() {
    // Set Nodes
    final Node node1 = new Node("1", "A");
    final Node node2 = new Node("2", "B");
    final Node node3 = new Node("3", "C");
    final Node node4 = new Node("4", "D");

    nd = new NetworkDiagram();
    nd.diagramSetSize("600px", "400px");
    nd.setNodes(node1, node2, node3, node4);

    nd.setEdges( //
        new Edge("1", "2", Edge.builder().withArrows("to")),
        new Edge("2", "3", Edge.builder().withArrows(Arrows.builder()
            .withTo(ArrowHead.builder().withEnabled(true).withType(Type.circle).build()).build())),
        new Edge("3", "4", Edge.builder().withArrows(Arrows.builder()
            .withTo(ArrowHead.builder().withEnabled(true).withType(Type.bar).build()).build())));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
