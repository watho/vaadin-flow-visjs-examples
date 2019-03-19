package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.options.Configure;
import de.wathoserver.vaadin.visjs.network.options.Interaction;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.EdgeColor;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.edges.Smooth;
import de.wathoserver.vaadin.visjs.network.options.edges.Smooth.Type;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Scaling;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
 <script type="text/javascript">
  var container = document.getElementById('mynetwork');
    var options = {
      nodes: {
        shape: 'dot',
        scaling: {
          min: 10,
          max: 30
        },
        font: {
          size: 12,
          face: 'Tahoma'
        }
      },
      edges: {
        color:{inherit:true},
        width: 0.15,
        smooth: {
          type: 'continuous'
        }
      },
      interaction: {
        hideEdgesOnDrag: true,
        tooltipDelay: 200
      },
      configure: {
        filter: function (option, path) {
          if (option === 'inherit') {return true;}
          if (option === 'type' && path.indexOf("smooth") !== -1) {return true;}
          if (option === 'roundness') {return true;}
          if (option === 'hideEdgesOnDrag') {return true;}
          if (option === 'hideNodesOnDrag') {return true;}
          return false;
        },
        container: document.getElementById('optionsContainer'),
        showButton: false
      },
      physics: false
    };

    var data = {nodes:nodes, edges:edges};
    // Note: data is coming from ./data/WorldCup2014.js
    network = new vis.Network(container, data, options);
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
@JavaScript("src/WorldCup2014.js")
public class EdgeStylesSmoothWorldcupExample extends AbstractExample {

  private final NetworkDiagram nd;

  public EdgeStylesSmoothWorldcupExample() {
    // nodes and edges come from js-file
    nd = new NetworkDiagram(Options.builder()//
        .withNodes(Nodes.builder().withShape(Shape.dot)
            .withScaling(Scaling.builder().withMin(10).withMax(30).build())
            .withFont(Font.builder().withSize(12).withFace("Tahoma").build()).build()) //
        .withInteraction(
            Interaction.builder().withHideEdgesOnDrag(true).withTooltipDelay(200).build()) //
        .withConfigure(Configure.builder().withEnabled(true).withFilter("edges.smooth")
            .withShowButton(false).build())//
        .withEdges(Edges.builder().withColor(EdgeColor.builder().withInherit(true).build())
            .withWidth(0.15).withSmooth(Smooth.builder().withType(Type.continuous).build()).build()) //
        .withPhysics(Physics.builder().withEnabled(false).build()).build());
    nd.setSize("800px", "800px");
    // Data is set with external javascript-file. Here the variablenames are set.
    nd.setPredefinedNodesVariableName("predefinedNodes");
    nd.setPredefinedEdgesVariableName("predefinedEdges");
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
