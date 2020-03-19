package tech.tablesaw.plotly.components;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import tech.tablesaw.plotly.components.threeD.Scene;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Layout {

    private final static String DEFAULT_TITLE = "";
    private final static String DEFAULT_PAPER_BG_COLOR = "#fff";
    private final static String DEFAULT_PLOT_BG_COLOR = "#fff";
    private final static String DEFAULT_DECIMAL_SEPARATOR = ".";
    private final static String DEFAULT_THOUSANDS_SEPARATOR = ",";
    private final static boolean DEFAULT_AUTO_SIZE = false;
    private final static boolean DEFAULT_SHOW_LEGEND = false;
    private final static HoverMode DEFAULT_HOVER_MODE = HoverMode.FALSE;
    private final static DragMode DEFAULT_DRAG_MODE = DragMode.ZOOM;
    private final static int DEFAULT_HOVER_DISTANCE = 20;
    private final static BarMode DEFAULT_BAR_MODE = BarMode.GROUP;
    private final static Font DEFAULT_TITLE_FONT = Font.builder().build();
    private final static Font DEFAULT_FONT = Font.builder().build();

    private final PebbleEngine engine = TemplateUtils.getNewEngine();
    private final Scene scene;

    /**
     * Determines the mode of hover interactions.
     */
    public enum HoverMode {
        X("x"),
        Y("y"),
        CLOSEST("closest"),
        FALSE("false");

        private final String value;

        HoverMode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Determines the display mode for bars when you have multiple bar traces. This also applies to histogram bars.
     * Group is the default.
     *
     * With "stack", the bars are stacked on top of one another.
     * With "relative", the bars are stacked on top of one another, but with negative values below the axis,
     * positive values above.
     * With "group", the bars are plotted next to one another centered around the shared location.
     * With "overlay", the bars are plotted over one another, provide an "opacity" to see through the overlaid bars.
     */
    public enum BarMode {
        STACK("stack"),
        GROUP("group"),
        OVERLAY("overlay"),
        RELATIVE("relative");

        private final String value;

        BarMode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Determines the mode of drag interactions.
     * "select" and "lasso" apply only to scatter traces with markers or text.
     * "orbit" and "turntable" apply only to 3D scenes.
     */
    public enum DragMode {
        ZOOM("zoom"),
        PAN("pan"),
        SELECT("select"),
        LASSO("lasso"),
        ORBIT("orbit"),
        TURNTABLE("turntable");

        private final String value;

        DragMode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * The global font
     */
    private final Font font;

    /*
     * The plot title
     */
    private final String title;

    /**
     * Sets the title font
     */
    private final Font titleFont;

    /**
     * Determines whether or not a layout width or height that has been left undefined by the user
     * is initialized on each relayout. Note that, regardless of this attribute, an undefined layout width or height
     * is always initialized on the first call to plot.
     */
    private final boolean autoSize;

    /**
     * The width of the plot in pixels
     */
    private final int width;

    /**
     * The height of the plot in pixels
     */
    private final int height;

    /**
     * Sets the margins around the plot
     */
    private final Margin margin;

    /**
     * Sets the color of paper where the graph is drawn.
     */
    private final String paperBgColor;

    /**
     * Sets the color of plotting area in-between x and y axes.
     */
    private final String plotBgColor;

    /**
     * Sets the decimal. For example, "." puts a '.' before decimals
     */
    private final String decimalSeparator;

    /**
     * Sets the separator. For example, a " " puts a space between thousands.
     */
    private final String thousandsSeparator;

    /**
     * Determines whether or not a legend is drawn.
     */
    private final boolean showLegend;

    /**
     * Determines the mode of hover interactions.
     */
    private final HoverMode hoverMode;

    /**
     * Determines the mode of drag interactions. "select" and "lasso" apply only to scatter traces with markers or text.
     * "orbit" and "turntable" apply only to 3D scenes.
     */
    private final DragMode dragMode;

    /**
     * Sets the default distance (in pixels) to look for data to add hover labels
     * (-1 means no cutoff, 0 means no looking for data). This is only a real distance
     * for hovering on point-like objects, like scatter points. For area-like objects (bars, scatter fills, etc)
     * hovering is on inside the area and off outside, but these objects will not supersede hover on point-like
     * objects in case of conflict.
     */
    private final int hoverDistance;

    private final Axis xAxis;

    private final Axis yAxis;

    private final Axis zAxis;

    private final BarMode barMode;

    private Layout(LayoutBuilder builder) {
        this.title = builder.title;
        this.autoSize = builder.autoSize;
        this.decimalSeparator = builder.decimalSeparator;
        this.thousandsSeparator = builder.thousandsSeparator;
        this.dragMode = builder.dragMode;
        this.font = builder.font;
        this.titleFont = builder.titleFont;
        this.hoverDistance = builder.hoverDistance;
        this.hoverMode = builder.hoverMode;
        this.margin = builder.margin;
        this.height = builder.height;
        this.width = builder.width;
        this.xAxis = builder.xAxis;
        this.yAxis = builder.yAxis;
        this.zAxis = builder.zAxis;
        this.paperBgColor = builder.paperBgColor;
        this.plotBgColor = builder.plotBgColor;
        this.showLegend = builder.showLegend;
        this.barMode = builder.barMode;
        this.scene = builder.scene;
    }

    public String getTitle() {
        return title;
    }

    public String asJavascript() {
        Writer writer = new StringWriter();
        PebbleTemplate compiledTemplate;
        try {
            compiledTemplate = engine.getTemplate("layout_template.html");
            compiledTemplate.evaluate(writer, getContext());
        } catch (PebbleException | IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    protected Map<String, Object> getContext() {
        Map<String, Object> context = new HashMap<>();
        if (!title.equals(DEFAULT_TITLE)) context.put("title", title);
        if(!titleFont.equals(DEFAULT_TITLE_FONT)) context.put("titlefont", titleFont);
        context.put("width", width);
        context.put("height", height);
        if(!font.equals(DEFAULT_FONT)) context.put("font", font);
        if(!autoSize == DEFAULT_AUTO_SIZE) context.put("autosize", autoSize);
        if(hoverDistance != DEFAULT_HOVER_DISTANCE) context.put("hoverdistance", hoverDistance);
        if (!hoverMode.equals(DEFAULT_HOVER_MODE)) context.put("hoverMode", hoverMode);
        if (margin != null) {
            context.put("margin", margin);
        }
        if (!decimalSeparator.equals(DEFAULT_DECIMAL_SEPARATOR)) context.put("decimalSeparator", decimalSeparator);
        if (!thousandsSeparator.equals(DEFAULT_THOUSANDS_SEPARATOR)) context.put("thousandsSeparator", thousandsSeparator);
        if(!dragMode.equals(DEFAULT_DRAG_MODE)) context.put("dragmode", dragMode);
        if (!showLegend == DEFAULT_SHOW_LEGEND) context.put("showlegend", showLegend);
        if (!plotBgColor.equals(DEFAULT_PLOT_BG_COLOR)) context.put("plotbgcolor", plotBgColor);
        if (!paperBgColor.equals(DEFAULT_PAPER_BG_COLOR))context.put("paperbgcolor", paperBgColor);
        if (!barMode.equals(DEFAULT_BAR_MODE)) context.put("barMode", barMode);
        if (scene != null) context.put("scene", scene);

        if (xAxis != null) {
            context.put("xAxis", xAxis);
        }
        if (yAxis != null) {
            context.put("yAxis", yAxis);
        }
        if (zAxis != null) {  // TODO: remove? It's in scene for 3d scatters at least.
            context.put("zAxis", zAxis);
        }
        return context;
    }

    public static LayoutBuilder builder() {
        return new LayoutBuilder();
    }

    public static class LayoutBuilder {

        /**
         * The global font
         */
        final Font font = DEFAULT_FONT;

        /*
         * The plot title
         */
        String title = "";

        /**
         * Sets the title font
         */
        Font titleFont = DEFAULT_TITLE_FONT;

        /**
         * Determines whether or not a layout width or height that has been left undefined by the user
         * is initialized on each relayout. Note that, regardless of this attribute, an undefined layout width or height
         * is always initialized on the first call to plot.
         */
        final boolean autoSize = false;

        /**
         * The width of the plot in pixels
         */
        int width = 700;

        /**
         * The height of the plot in pixels
         */
        int height = 450;

        /**
         * Sets the margins around the plot
         */
        Margin margin;

        /**
         * Sets the color of paper where the graph is drawn.
         */
        String paperBgColor = DEFAULT_PAPER_BG_COLOR;

        /**
         * Sets the color of plotting area in-between x and y axes.
         */
        String plotBgColor = DEFAULT_PLOT_BG_COLOR;

        /**
         * Sets the decimal. For example, "." puts a '.' before decimals
         */
        final String decimalSeparator = DEFAULT_DECIMAL_SEPARATOR;

        /**
         * Sets the separator. For example, a " " puts a space between thousands.
         */
        final String thousandsSeparator = DEFAULT_THOUSANDS_SEPARATOR;

        /**
         * Determines whether or not a legend is drawn.
         */
        boolean showLegend = DEFAULT_SHOW_LEGEND;

        /**
         * Determines the mode of hover interactions.
         */
        HoverMode hoverMode = DEFAULT_HOVER_MODE;

        /**
         * Determines the mode of drag interactions. "select" and "lasso" apply only to scatter traces with markers or text.
         * "orbit" and "turntable" apply only to 3D scenes.
         */
        final DragMode dragMode = DEFAULT_DRAG_MODE;

        /**
         * Sets the default distance (in pixels) to look for data to add hover labels
         * (-1 means no cutoff, 0 means no looking for data). This is only a real distance
         * for hovering on point-like objects, like scatter points. For area-like objects (bars, scatter fills, etc)
         * hovering is on inside the area and off outside, but these objects will not supersede hover on point-like
         * objects in case of conflict.
         */
        int hoverDistance = DEFAULT_HOVER_DISTANCE; // greater than or equal to -1

        Axis xAxis;

        Axis yAxis;

        Axis zAxis;

        BarMode barMode = DEFAULT_BAR_MODE;

        private Scene scene;

        public Layout build() {
            return new Layout(this);
        }

        private LayoutBuilder() {}

        public LayoutBuilder title(String title) {
            this.title = title;
            return this;
        }

        public LayoutBuilder titleFont(Font titleFont) {
            this.titleFont = titleFont;
            return this;
        }

        public LayoutBuilder barMode(BarMode barMode) {
            this.barMode = barMode;
            return this;
        }

        public LayoutBuilder margin(Margin margin) {
            this.margin = margin;
            return this;
        }

        public LayoutBuilder scene(Scene scene) {
            this.scene = scene;
            return this;
        }

        public LayoutBuilder hoverMode(HoverMode hoverMode) {
            this.hoverMode = hoverMode;
            return this;
        }

        public LayoutBuilder hoverDistance(int distance) {
            this.hoverDistance = distance;
            return this;
        }

        public LayoutBuilder showLegend(boolean showLegend) {
            this.showLegend = showLegend;
            return this;
        }

        public LayoutBuilder height(int height) {
            this.height = height;
            return this;
        }
        public LayoutBuilder width(int width) {
            this.width = width;
            return this;
        }

        public LayoutBuilder xAxis(Axis axis) {
            this.xAxis = axis;
            return this;
        }

        public LayoutBuilder yAxis(Axis axis) {
            this.yAxis = axis;
            return this;
        }

        public LayoutBuilder zAxis(Axis axis) {
            this.zAxis = axis;
            return this;
        }

        public LayoutBuilder plotBgColor(String color) {
            this.plotBgColor = color;
            return this;
        }

        public LayoutBuilder paperBgColor(String color) {
            this.paperBgColor = color;
            return this;
        }
    }
}
