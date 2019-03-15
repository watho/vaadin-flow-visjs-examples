package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.options.Configure;
import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout;
import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout.Direction;
import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout.SortMethod;
import de.wathoserver.vaadin.visjs.network.options.Interaction;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Layout;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;

/**
 * <pre>
<script type="text/javascript">
   var data = {
        nodes: nodes,
        edges: edges
    };
    // create a network
    var container = document.getElementById('network');
    var options = {
        layout: {
            hierarchical: {
                direction: "UD",
                sortMethod: "directed"
            }
        },
        interaction: {dragNodes :false},
        physics: {
            enabled: false
        },
        configure: {
          filter: function (option, path) {
              if (path.indexOf('hierarchical') !== -1) {
                  return true;
              }
              return false;
          },
          showButton:false
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
@JavaScript("src/largeHierarchicalDataset.js")
public class LayoutHierarchicalLayoutWithoutPhysicsExample extends AbstractExample {

  private final NetworkDiagram nd;
  private final Options options;

  public LayoutHierarchicalLayoutWithoutPhysicsExample() {
    // Set Nodes

    options = Options.builder()
        .withLayout(Layout.builder()
            .withHierarchical(HierarchicalLayout.builder().withDirection(Direction.UD)
                .withSortMethod(SortMethod.directed).build())//
            .build())
        .withInteraction(Interaction.builder().withDragNodes(false).build()) //
        .withPhysics(Physics.builder().withEnabled(false).build()) //
        .withConfigure(
            Configure.builder().withFilter("layout.hierarchical").withShowButton(false).build()) //
        .build();
    nd = new NetworkDiagram(options);
    nd.diagramSetSize("1000px", "400px");
    // Data is set within largeHierarchicalDataSet.js
    nd.setPredefinedNodesVariableName("nodes");
    nd.setPredefinedEdgesVariableName("edges");
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
