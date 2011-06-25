package app.configuration;

import app.configuration.converters.MetricConverter;
import app.configuration.converters.PixelTilerConverter;
import app.configuration.converters.ScaleTransformConverter;

import com.beust.jcommander.Parameter;

import lib.comparators.Metric;
import lib.tilers.RectangularPixelTiler;
import lib.transformations.ScaleTransform;

/**
 * The available options to the system
 */
class Options {

    @Parameter(names        = { "-f", "--fuzz" },
               description  = "colors within this distance are considered equal")
    protected double  fuzz  = 5;

    @Parameter(names        = { "-h", "--help" },
               description  = "display this help message")
    protected boolean help  = false;

    @Parameter(names        = { "-d", "--debug" },
               description  = "display debug messages")
    protected boolean debug = false;

    @Parameter(names        = { "-m", "--metric" },
               description  = "the metric to use when comparing images",
               converter    = MetricConverter.class)
    protected Metric metric = Metric.AE;

    @Parameter(names        = { "-s", "--scale" },
               description  = "the width and height scale factors for the domain image",
               converter    = ScaleTransformConverter.class)
    protected ScaleTransform domainScale  = new ScaleTransform(.5, .5);

    @Parameter(names        = { "-t", "--tile" },
               description  = "the width and height in pixels to tile the image",
               converter    = PixelTilerConverter.class)
    protected RectangularPixelTiler tiler = new RectangularPixelTiler(8, 8);
}