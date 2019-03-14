package de.wathoserver.vaadin.visjs.demo;

import com.github.appreciated.app.layout.behaviour.Behaviour;
import com.github.appreciated.app.layout.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.component.appmenu.left.LeftNavigationComponent;
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftSubMenuBuilder;
import com.github.appreciated.app.layout.router.AppLayoutRouterLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RoutePrefix;

import de.wathoserver.vaadin.visjs.demo.showcase.views.BasicUsageView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.IntroductionView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles.EdgeStylesArrowTypesView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles.EdgeStylesArrowsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles.EdgeStylesColorsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles.EdgeStylesDashesView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles.EdgeStylesSmoothView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles.EdgeStylesSmoothWorldcupView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.labels.LabelsLabelAlignmentView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.labels.LabelsLabelBackgroundView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.labels.LabelsLabelColorAndSizeView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.labels.LabelsLabelMarginsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.labels.LabelsLabelMultifontView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.labels.LabelsLabelMultilineTextView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.labels.LabelsLabelStrokeView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesCircularImagesView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesColorsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesCustomGroupsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesGroupsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesHtmlInNodeView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesIconsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesImagesView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesImagesWithBordersView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesShadowsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesShapesView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesShapesWithDashedBordersView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles.NodeStylesWidthHeightView;

@SuppressWarnings("serial")
@RoutePrefix("showcase")
public class MainShowcaseLayout extends AppLayoutRouterLayout {

  public MainShowcaseLayout() {
    init(AppLayoutBuilder.get(Behaviour.LEFT_RESPONSIVE)
        .withTitle("Vis.js Showcase v" + MainView.RELEASE)
        .withAppMenu(LeftAppMenuBuilder.get()
            .add(new LeftNavigationComponent(IntroductionView.class))
            .add(new LeftNavigationComponent(BasicUsageView.class)).add(buildNodeStylesSubMenu())
            .add(buildEdgeStylesSubMenu()).add(buildLabelsSubMenu()).build())
        .build());
  }

  private Component buildNodeStylesSubMenu() {
    return LeftSubMenuBuilder.get("Node styles", VaadinIcon.CIRCLE.create())
        .add(new LeftNavigationComponent(NodeStylesCircularImagesView.class)) //
        .add(new LeftNavigationComponent(NodeStylesColorsView.class)) //
        .add(new LeftNavigationComponent(NodeStylesCustomGroupsView.class)) //
        .add(new LeftNavigationComponent(NodeStylesGroupsView.class)) //
        .add(new LeftNavigationComponent(NodeStylesHtmlInNodeView.class)) //
        .add(new LeftNavigationComponent(NodeStylesIconsView.class)) //
        .add(new LeftNavigationComponent(NodeStylesImagesView.class)) //
        .add(new LeftNavigationComponent(NodeStylesImagesWithBordersView.class)) //
        .add(new LeftNavigationComponent(NodeStylesShadowsView.class)) //
        .add(new LeftNavigationComponent(NodeStylesShapesView.class)) //
        .add(new LeftNavigationComponent(NodeStylesShapesWithDashedBordersView.class)) //
        .add(new LeftNavigationComponent(NodeStylesWidthHeightView.class)) //
        .build();
  }

  private Component buildEdgeStylesSubMenu() {
    return LeftSubMenuBuilder.get("Edge styles", VaadinIcon.TRENDING_UP.create())//
        .add(new LeftNavigationComponent(EdgeStylesArrowsView.class)) //
        .add(new LeftNavigationComponent(EdgeStylesArrowTypesView.class)) //
        .add(new LeftNavigationComponent(EdgeStylesColorsView.class)) //
        .add(new LeftNavigationComponent(EdgeStylesDashesView.class)) //
        .add(new LeftNavigationComponent(EdgeStylesSmoothView.class)) //
        .add(new LeftNavigationComponent(EdgeStylesSmoothWorldcupView.class)) //
        .build();
  }

  private Component buildLabelsSubMenu() {
    return LeftSubMenuBuilder.get("Labels", VaadinIcon.TEXT_LABEL.create())//
        .add(new LeftNavigationComponent(LabelsLabelAlignmentView.class)) //
        .add(new LeftNavigationComponent(LabelsLabelBackgroundView.class)) //
        .add(new LeftNavigationComponent(LabelsLabelColorAndSizeView.class)) //
        .add(new LeftNavigationComponent(LabelsLabelMarginsView.class)) //
        .add(new LeftNavigationComponent(LabelsLabelMultifontView.class)) //
        .add(new LeftNavigationComponent(LabelsLabelStrokeView.class)) //
        .add(new LeftNavigationComponent(LabelsLabelMultilineTextView.class)) //
        .build();
  }
}
