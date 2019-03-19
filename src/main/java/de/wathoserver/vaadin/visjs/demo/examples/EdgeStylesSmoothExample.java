package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Configure;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.edges.Smooth;
import de.wathoserver.vaadin.visjs.network.options.edges.Smooth.Type;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;

/**
 * <pre>
 // create an array with nodes
  var nodes = [
    {id: 1, label: 'Fixed node', x:0, y:0, fixed:true},
    {id: 2, label: 'Drag me', x:150, y:130, physics:false},
    {id: 3, label: 'Obstacle', x:80, y:-80, fixed:true, mass:10}
  ];

  // create an array with edges
  var edges = [
    {from: 1, to: 2, arrows:'to'}
  ];

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {
    physics:true,
    configure:function (option, path) {
      if (path.indexOf('smooth') !== -1 || option === 'smooth') {
        return true;
      }
      return false;
    },
    edges: {
      smooth: {
        type: 'continuous'
      }
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
public class EdgeStylesSmoothExample extends AbstractExample {

  private final NetworkDiagram nd;

  public EdgeStylesSmoothExample() {
    // Set Nodes
    final Node node1 =
        new Node("1", "Fixed node", Node.builder().withx(0).withy(0).withFixed(true));
    final Node node2 =
        new Node("2", "Drag me", Node.builder().withx(150).withy(130).withPhysics(false));
    final Node node3 =
        new Node("3", "Obstacle", Node.builder().withx(80).withy(-80).withFixed(true).withMass(10));

    nd = new NetworkDiagram(Options.builder()//
        .withPhysics(Physics.builder().withEnabled(true).build()) //
        .withConfigure(Configure.builder().withEnabled(true).withFilter("edges.smooth").build())//
        .withEdges(
            Edges.builder().withSmooth(Smooth.builder().withType(Type.continuous).build()).build()) //
        .build());
    nd.setSize("500px", "500px");
    nd.setNodes(node1, node2, node3);

    nd.setEdges( //
        new Edge("1", "2", Edge.builder().withArrows("to")));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
